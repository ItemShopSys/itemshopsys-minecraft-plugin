package dev.shiza.itemshopsys.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyShutdownEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import dev.shiza.itemshopsys.ItemShopPlugin;
import dev.shiza.itemshopsys.config.ConfigFactory;
import dev.shiza.itemshopsys.platform.PlatformDataProvider;
import dev.shiza.itemshopsys.velocity.command.VelocityCommandDispatcher;
import dev.shiza.itemshopsys.velocity.command.VelocityItemShopCommand;
import dev.shiza.itemshopsys.velocity.player.VelocityPlayerAccessor;
import dev.shiza.itemshopsys.velocity.scheduler.VelocityTaskScheduler;
import eu.okaeri.configs.yaml.snakeyaml.YamlSnakeYamlConfigurer;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

@Plugin(
    id = "itemshopsys",
    version = "1.0.0-SNAPSHOT",
    authors = {"shiza"})
public final class ItemShopVelocityPlugin implements PlatformDataProvider {

  private final Logger logger;
  private final Path dataPath;
  private final ProxyServer server;
  private ItemShopPlugin itemShopPlugin;

  @Inject
  public ItemShopVelocityPlugin(
      final Logger logger, final @DataDirectory Path dataPath, final ProxyServer server) {
    this.logger = logger;
    this.dataPath = dataPath;
    this.server = server;
  }

  @Subscribe
  public void onProxyInitialization(final ProxyInitializeEvent event) {
    itemShopPlugin =
        ItemShopPlugin.create(
            this,
            new ItemShopVelocityLogger(logger),
            new ConfigFactory(dataPath, YamlSnakeYamlConfigurer::new),
            new VelocityTaskScheduler(this, server),
            new VelocityPlayerAccessor(server),
            new VelocityCommandDispatcher(server));
    itemShopPlugin.onEnable();

    server
        .getCommandManager()
        .register(
            server.getCommandManager().metaBuilder("itemshopsys").build(),
            new VelocityItemShopCommand(itemShopPlugin.getConfig()));
  }

  @Subscribe
  public void onProxyShutdown(final ProxyShutdownEvent event) {
    if (itemShopPlugin != null) {
      itemShopPlugin.onDisable();
    }
  }

  @Override
  public String getPluginVersion() {
    return Optional.ofNullable(getClass().getAnnotation(Plugin.class))
        .map(Plugin::version)
        .orElse("Unknown");
  }

  @Override
  public String getEngineName() {
    return "Velocity";
  }

  @Override
  public String getEngineVersion() {
    return PlatformDataProvider.matchVersion(server.getVersion().getVersion());
  }
}
