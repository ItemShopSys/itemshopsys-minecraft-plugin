package dev.shiza.itemshopsys;

import dev.shiza.itemshopsys.client.ItemShopClientConfig;

public interface ItemShopCommand<S> {

  default void executeCommand(final S source, final String[] args) {
    if (!hasPermission(source, "itemshopsys.reload")) {
      sendMessage(source, "&cYou do not have permission to execute this command.");
      return;
    }

    if (args.length != 1 || !args[0].equalsIgnoreCase("reload")) {
      sendMessage(source, "&cUsage: &e/itemshopsys reload");
      return;
    }

    getConfig().load(true);

    sendMessage(source, "&7Configuration reloaded.");
  }

  void sendMessage(final S source, final String message);

  boolean hasPermission(final S source, final String permission);

  ItemShopClientConfig getConfig();
}
