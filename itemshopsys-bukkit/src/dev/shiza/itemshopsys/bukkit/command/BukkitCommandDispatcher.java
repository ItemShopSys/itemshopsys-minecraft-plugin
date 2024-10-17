package dev.shiza.itemshopsys.bukkit.command;

import dev.shiza.itemshopsys.command.CommandDispatcher;
import org.bukkit.Server;

public final class BukkitCommandDispatcher implements CommandDispatcher {

  private final Server server;

  public BukkitCommandDispatcher(final Server server) {
    this.server = server;
  }

  @Override
  public void dispatchCommand(final String command) {
    server.dispatchCommand(server.getConsoleSender(), command);
  }
}
