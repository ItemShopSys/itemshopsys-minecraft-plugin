package dev.shiza.itemshopsys.client.http;

import dev.shiza.itemshopsys.ItemShopLogger;
import dev.shiza.itemshopsys.client.ItemShopClient;
import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import dev.shiza.itemshopsys.platform.PlatformDataProvider;

public final class HttpItemShopClientFactory {

  private HttpItemShopClientFactory() {}

  public static ItemShopClient create(
      final PlatformDataProvider platformDataProvider,
      final ItemShopLogger logger,
      final ItemShopClientConfig config) {
    final HttpItemShopClient client = new HttpItemShopClient(platformDataProvider, logger);
    client.configure(config);
    return client;
  }
}
