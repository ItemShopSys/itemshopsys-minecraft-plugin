package dev.shiza.itemshopsys.command;

import dev.shiza.itemshopsys.ItemShopLogger;
import dev.shiza.itemshopsys.client.ItemShopClient;
import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import dev.shiza.itemshopsys.client.command.ExecutableCommand;
import dev.shiza.itemshopsys.player.PlayerAccessor;
import java.util.List;

public final class CommandPoolTask implements Runnable {

  private final ItemShopLogger logger;
  private final ItemShopClientConfig config;
  private final ItemShopClient client;
  private final PlayerAccessor playerAccessor;
  private final CommandDispatcher commandDispatcher;

  public CommandPoolTask(
      final ItemShopLogger logger,
      final ItemShopClientConfig config,
      final ItemShopClient client,
      final PlayerAccessor playerAccessor,
      final CommandDispatcher commandDispatcher) {
    this.logger = logger;
    this.config = config;
    this.client = client;
    this.playerAccessor = playerAccessor;
    this.commandDispatcher = commandDispatcher;
  }

  @Override
  public void run() {
    final List<ExecutableCommand> executableCommands =
        client.retrieveCommands(config.shopId, config.serverId).getCommands();
    if (executableCommands.isEmpty()) {
      logger.debug("No commands to execute were retrieved.");
      return;
    }

    executableCommands.forEach(this::processCommand);
  }

  private void processCommand(final ExecutableCommand executableCommand) {
    if (isCommandUnavailable(executableCommand)) {
      logger.debug(
          String.format(
              "Command %s (%s) could not be executed, because %s is Offline.",
              executableCommand.getUniqueId(),
              executableCommand.getCommand(),
              executableCommand.getPlayerName()));

      client.restoreCommand(config.shopId, config.serverId, executableCommand.getUniqueId());
      return;
    }

    logger.debug(
        String.format(
            "Executing command %s (%s) for %s.",
            executableCommand.getUniqueId(),
            executableCommand.getCommand(),
            executableCommand.getPlayerName()));

    commandDispatcher.dispatchCommand(executableCommand.getCommand());
  }

  private boolean isCommandUnavailable(final ExecutableCommand command) {
    return command.isRequiresOnline()
        && command.getPlayerName() != null
        && !playerAccessor.isPlayerOnline(command.getPlayerName());
  }
}
