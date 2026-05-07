package dev.shiza.itemshopsys.velocity;

import dev.shiza.itemshopsys.ItemShopLogger;
import java.util.logging.Level;

public class ItemShopVelocityLogger implements ItemShopLogger {

  private final java.util.logging.Logger logger;
  private boolean debugEnabled;

  public ItemShopVelocityLogger(final java.util.logging.Logger logger) {
    this.logger = logger;
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

    logger.log(Level.INFO, "[itemshopsys] " + message);
  }

  @Override
  public void error(final String message) {
    logger.log(Level.SEVERE, "[itemshopsys] " + message);
  }
}
