package dev.shiza.itemshopsys.bungee.scheduler;

import dev.shiza.itemshopsys.scheduler.TaskScheduler;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class BungeeTaskScheduler implements TaskScheduler {

  private final Plugin plugin;
  private final ProxyServer server;

  public BungeeTaskScheduler(final Plugin plugin, final ProxyServer server) {
    this.plugin = plugin;
    this.server = server;
  }

  @Override
  public void schedule(final Runnable task, final Duration delay) {
    server
        .getScheduler()
        .schedule(plugin, task, delay.toMillis(), delay.toMillis(), TimeUnit.MILLISECONDS);
  }
}
