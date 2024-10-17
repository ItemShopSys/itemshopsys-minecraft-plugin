package dev.shiza.itemshopsys.bungee.player;

import dev.shiza.itemshopsys.player.PlayerAccessor;
import net.md_5.bungee.api.ProxyServer;

public final class BungeePlayerAccessor implements PlayerAccessor {

  private final ProxyServer server;

  public BungeePlayerAccessor(final ProxyServer server) {
    this.server = server;
  }

  @Override
  public boolean isPlayerOnline(final String username) {
    return server.getPlayer(username) != null;
  }
}
