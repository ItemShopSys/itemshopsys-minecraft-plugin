package dev.shiza.itemshopsys.bungee;

import dev.shiza.itemshopsys.ItemShopLogger;
import java.util.logging.Level;
import net.md_5.bungee.api.ProxyServer;

public final class ItemShopBungeeLogger implements ItemShopLogger {

  private final ProxyServer server;

  public ItemShopBungeeLogger(final ProxyServer server) {
    this.server = server;
  }

  @Override
  public void debug(final String message) {
    server.getLogger().log(Level.INFO, "[itemshopsys] " + message);
  }

  @Override
  public void error(final String message) {
    server.getLogger().log(Level.SEVERE, "[itemshopsys] " + message);
  }
}
