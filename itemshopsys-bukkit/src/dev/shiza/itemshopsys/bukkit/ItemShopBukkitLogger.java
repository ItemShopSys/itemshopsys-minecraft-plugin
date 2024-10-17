package dev.shiza.itemshopsys.bukkit;

import dev.shiza.itemshopsys.ItemShopLogger;
import java.util.logging.Level;
import org.bukkit.Server;

public final class ItemShopBukkitLogger implements ItemShopLogger {

  private final Server server;

  public ItemShopBukkitLogger(final Server server) {
    this.server = server;
  }

  @Override
  public void debug(final String message) {
    server.getLogger().log(Level.INFO, message);
  }

  @Override
  public void error(final String message) {
    server.getLogger().log(Level.SEVERE, message);
  }
}
