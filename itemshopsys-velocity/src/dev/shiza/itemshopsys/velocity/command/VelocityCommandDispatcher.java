package dev.shiza.itemshopsys.velocity.command;

import com.velocitypowered.api.proxy.ProxyServer;
import dev.shiza.itemshopsys.command.CommandDispatcher;

public final class VelocityCommandDispatcher implements CommandDispatcher {

  private final ProxyServer server;

  public VelocityCommandDispatcher(final ProxyServer server) {
    this.server = server;
  }

  @Override
  public void dispatchCommand(final String command) {
    server
        .getCommandManager()
        .executeImmediatelyAsync(server.getConsoleCommandSource(), command)
        .exceptionally(
            exception -> {
              exception.printStackTrace();
              return null;
            });
  }
}
