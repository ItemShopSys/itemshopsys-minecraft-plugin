package dev.shiza.itemshopsys.client;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Exclude;

public final class ItemShopClientConfig extends OkaeriConfig {

  public static final @Exclude String NOT_CONFIGURED_VALUE = "default";

  public boolean debug = true;

  public String shopId = NOT_CONFIGURED_VALUE;

  public String serverId = NOT_CONFIGURED_VALUE;

  public String serverToken = NOT_CONFIGURED_VALUE;

  public String apiUrl = "https://api.itemshopsys.com/v1";
}
