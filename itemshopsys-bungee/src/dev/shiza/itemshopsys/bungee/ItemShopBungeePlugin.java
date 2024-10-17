package dev.shiza.itemshopsys.bungee;

import dev.shiza.itemshopsys.ItemShopPlugin;
import dev.shiza.itemshopsys.bungee.command.BungeeCommandDispatcher;
import dev.shiza.itemshopsys.bungee.command.BungeeItemShopCommand;
import dev.shiza.itemshopsys.bungee.player.BungeePlayerAccessor;
import dev.shiza.itemshopsys.bungee.scheduler.BungeeTaskScheduler;
import dev.shiza.itemshopsys.config.ConfigFactory;
import dev.shiza.itemshopsys.platform.PlatformDataProvider;
import eu.okaeri.configs.yaml.bungee.YamlBungeeConfigurer;
import net.md_5.bungee.api.plugin.Plugin;

public final class ItemShopBungeePlugin extends Plugin implements PlatformDataProvider {

  private ItemShopPlugin itemShopPlugin;

  @Override
  public void onEnable() {
    itemShopPlugin =
        ItemShopPlugin.create(
            this,
            new ItemShopBungeeLogger(getProxy()),
            new ConfigFactory(getDataFolder().toPath(), YamlBungeeConfigurer::new),
            new BungeeTaskScheduler(this, getProxy()),
            new BungeePlayerAccessor(getProxy()),
            new BungeeCommandDispatcher(getProxy()));
    itemShopPlugin.onEnable();

    getProxy()
        .getPluginManager()
        .registerCommand(this, new BungeeItemShopCommand(itemShopPlugin.getConfig()));
  }

  @Override
  public void onDisable() {
    if (itemShopPlugin != null) {
      itemShopPlugin.onDisable();
    }
  }

  @Override
  public String getPluginVersion() {
    return getDescription().getVersion();
  }

  @Override
  public String getEngineName() {
    return "BungeeCord";
  }

  @Override
  public String getEngineVersion() {
    return PlatformDataProvider.matchVersion(getProxy().getVersion());
  }
}
