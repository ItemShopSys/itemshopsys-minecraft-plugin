package dev.shiza.itemshopsys.velocity;

import dev.shiza.itemshopsys.ItemShopLogger;
import java.util.logging.Level;

public class ItemShopVelocityLogger implements ItemShopLogger {

  private final java.util.logging.Logger logger;

  public ItemShopVelocityLogger(final java.util.logging.Logger logger) {
    this.logger = logger;
  }

  @Override
  public void debug(final String message) {
    logger.log(Level.INFO, "[itemshopsys] " + message);
  }

  @Override
  public void error(final String message) {
    logger.log(Level.SEVERE, "[itemshopsys] " + message);
  }
}
