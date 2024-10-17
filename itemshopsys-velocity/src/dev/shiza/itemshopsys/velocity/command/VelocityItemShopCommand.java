package dev.shiza.itemshopsys.velocity.command;

import com.velocitypowered.api.command.CommandSource;
import com.velocitypowered.api.command.SimpleCommand;
import dev.shiza.itemshopsys.ItemShopCommand;
import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public final class VelocityItemShopCommand
    implements ItemShopCommand<CommandSource>, SimpleCommand {

  private final ItemShopClientConfig config;

  public VelocityItemShopCommand(final ItemShopClientConfig config) {
    this.config = config;
  }

  @Override
  public void execute(final Invocation invocation) {
    executeCommand(invocation.source(), invocation.arguments());
  }

  @Override
  public void sendMessage(final CommandSource source, final String message) {
    source.sendMessage(LegacyComponentSerializer.legacyAmpersand().deserialize(message));
  }

  @Override
  public boolean hasPermission(final CommandSource source, final String permission) {
    return source.hasPermission(permission);
  }

  @Override
  public ItemShopClientConfig getConfig() {
    return config;
  }
}
