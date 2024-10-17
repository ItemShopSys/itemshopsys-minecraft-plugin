package dev.shiza.itemshopsys;

import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import dev.shiza.itemshopsys.command.CommandDispatcher;
import dev.shiza.itemshopsys.config.ConfigFactory;
import dev.shiza.itemshopsys.platform.PlatformDataProvider;
import dev.shiza.itemshopsys.player.PlayerAccessor;
import dev.shiza.itemshopsys.scheduler.TaskScheduler;

public interface ItemShopPlugin {

  static ItemShopPlugin create(
      final PlatformDataProvider platformDataProvider,
      final ItemShopLogger logger,
      final ConfigFactory configFactory,
      final TaskScheduler taskScheduler,
      final PlayerAccessor playerAccessor,
      final CommandDispatcher commandDispatcher) {
    return new ItemShopPluginImpl(
        platformDataProvider,
        logger,
        configFactory,
        taskScheduler,
        playerAccessor,
        commandDispatcher);
  }

  default void onEnable() {}

  default void onDisable() {}

  ItemShopClientConfig getConfig();
}
