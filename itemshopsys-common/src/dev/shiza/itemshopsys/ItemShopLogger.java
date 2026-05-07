package dev.shiza.itemshopsys;

public interface ItemShopLogger {

  default void setDebugEnabled(final boolean debugEnabled) {}

  void debug(final String message);

  void error(final String message);
}
