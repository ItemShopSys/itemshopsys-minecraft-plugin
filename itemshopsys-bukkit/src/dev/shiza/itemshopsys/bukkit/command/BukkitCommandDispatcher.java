package dev.shiza.itemshopsys.bukkit.command;

import dev.shiza.itemshopsys.command.CommandDispatcher;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public final class BukkitCommandDispatcher implements CommandDispatcher {

  private final Plugin plugin;
  private final Server server;

  public BukkitCommandDispatcher(final Plugin plugin) {
    this.plugin = plugin;
    this.server = plugin.getServer();
  }

  @Override
  public void dispatchCommand(final String command) {
    server
        .getScheduler()
        .runTask(plugin, () -> server.dispatchCommand(server.getConsoleSender(), command));
  }
}
