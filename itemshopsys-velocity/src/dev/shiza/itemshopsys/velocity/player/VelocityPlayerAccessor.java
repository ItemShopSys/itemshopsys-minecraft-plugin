package dev.shiza.itemshopsys.velocity.player;

import com.velocitypowered.api.proxy.ProxyServer;
import dev.shiza.itemshopsys.player.PlayerAccessor;

public final class VelocityPlayerAccessor implements PlayerAccessor {

  private final ProxyServer server;

  public VelocityPlayerAccessor(final ProxyServer server) {
    this.server = server;
  }

  @Override
  public boolean isPlayerOnline(final String username) {
    return server.getPlayer(username).isPresent();
  }
}
