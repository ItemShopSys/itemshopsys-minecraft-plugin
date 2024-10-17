package dev.shiza.itemshopsys.client.http;

import dev.shiza.itemshopsys.ItemShopLogger;
import kong.unirest.Config;
import kong.unirest.HttpRequest;
import kong.unirest.HttpRequestSummary;
import kong.unirest.HttpResponse;
import kong.unirest.Interceptor;

public final class HttpItemShopClientInterceptor implements Interceptor {

  private final ItemShopLogger logger;

  public HttpItemShopClientInterceptor(final ItemShopLogger logger) {
    this.logger = logger;
  }

  @Override
  public void onRequest(final HttpRequest<?> request, final Config config) {
    logger.debug("> Sending request:");
    logger.debug(request.toSummary().asString());
  }

  @Override
  public void onResponse(
      final HttpResponse<?> response, final HttpRequestSummary request, final Config config) {
    logger.debug("> Received response:");
    logger.debug("- request: " + request.asString());
    if (response.getBody() != null) {
      logger.debug("- response body: " + response.getBody().toString());
    }
    logger.debug("- response status: " + response.getStatus());
  }
}
