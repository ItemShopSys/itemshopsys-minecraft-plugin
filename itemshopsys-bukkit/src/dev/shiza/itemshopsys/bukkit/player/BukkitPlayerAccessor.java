package dev.shiza.itemshopsys.bukkit.player;

import dev.shiza.itemshopsys.player.PlayerAccessor;
import org.bukkit.Server;

public final class BukkitPlayerAccessor implements PlayerAccessor {

  private final Server server;

  public BukkitPlayerAccessor(final Server server) {
    this.server = server;
  }

  @Override
  public boolean isPlayerOnline(final String username) {
    return server.getPlayer(username) != null;
  }
}
