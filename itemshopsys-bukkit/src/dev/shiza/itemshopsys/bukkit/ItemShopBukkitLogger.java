package dev.shiza.itemshopsys.bukkit;

import dev.shiza.itemshopsys.ItemShopLogger;
import java.util.logging.Level;
import org.bukkit.Server;

public final class ItemShopBukkitLogger implements ItemShopLogger {

  private final Server server;
  private boolean debugEnabled;

  public ItemShopBukkitLogger(final Server server) {
    this.server = server;
  }

  @Override
  public void setDebugEnabled(final boolean debugEnabled) {
    this.debugEnabled = debugEnabled;
  }

  @Override
  public void debug(final String message) {
    if (!debugEnabled) {
      return;
    }

    server.getLogger().log(Level.INFO, "[itemshopsys] " + message);
  }

  @Override
  public void error(final String message) {
    server.getLogger().log(Level.SEVERE, "[itemshopsys] " + message);
  }
}
