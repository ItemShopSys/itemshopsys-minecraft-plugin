package dev.shiza.itemshopsys.bungee.command;

import dev.shiza.itemshopsys.command.CommandDispatcher;
import net.md_5.bungee.api.ProxyServer;

public final class BungeeCommandDispatcher implements CommandDispatcher {

  private final ProxyServer server;

  public BungeeCommandDispatcher(final ProxyServer server) {
    this.server = server;
  }

  @Override
  public void dispatchCommand(final String command) {
    server.getPluginManager().dispatchCommand(server.getConsole(), command);
  }
}
