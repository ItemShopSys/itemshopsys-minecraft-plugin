package dev.shiza.itemshopsys.client;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.Comment;
import eu.okaeri.configs.annotation.Exclude;
import eu.okaeri.configs.annotation.Header;

@Header("Więcej informacji / More info:")
@Header("https://wiki.itemshopsys.com/pl/plugin")
@Header("")
public final class ItemShopClientConfig extends OkaeriConfig {

  public static final @Exclude String NOT_CONFIGURED_VALUE = "";

  @Comment("tryb debugowania / debug mode")
  public boolean debug = false;

  @Comment("id sklepu / shop id (shop_)")
  public String shopId = NOT_CONFIGURED_VALUE;

  @Comment("id serwera / server id (serv_)")
  public String serverId = NOT_CONFIGURED_VALUE;

  @Comment("token serwera / server token")
  public String serverToken = NOT_CONFIGURED_VALUE;

  @Comment("Link do API (zostaw domyslny) / API url (dont change)")
  public String apiUrl = "https://api.itemshopsys.com/v1";
}
