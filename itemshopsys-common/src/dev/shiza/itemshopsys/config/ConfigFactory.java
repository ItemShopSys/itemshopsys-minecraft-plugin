package dev.shiza.itemshopsys.config;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.configurer.Configurer;
import eu.okaeri.configs.serdes.OkaeriSerdesPack;
import java.nio.file.Path;
import java.util.function.Supplier;

public final class ConfigFactory {

  private final Path dataPath;
  private final Supplier<Configurer> configurer;

  public ConfigFactory(final Path dataPath, final Supplier<Configurer> configurer) {
    this.dataPath = dataPath;
    this.configurer = configurer;
  }

  public <T extends OkaeriConfig> T produceConfig(
      final Class<T> configType,
      final String configFileName,
      final OkaeriSerdesPack... serdesPacks) {
    return produceConfig(configType, dataPath.resolve(configFileName), serdesPacks);
  }

  public <T extends OkaeriConfig> T produceConfig(
      final Class<T> configType, final Path configFilePath, final OkaeriSerdesPack... serdesPacks) {
    return ConfigManager.create(
        configType,
        initializer ->
            initializer
                .withConfigurer(configurer.get(), serdesPacks)
                .withBindFile(configFilePath)
                .saveDefaults()
                .load(true));
  }
}
