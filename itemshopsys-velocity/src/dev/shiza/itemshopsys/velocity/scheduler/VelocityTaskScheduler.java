package dev.shiza.itemshopsys.velocity.scheduler;

import com.velocitypowered.api.proxy.ProxyServer;
import dev.shiza.itemshopsys.scheduler.TaskScheduler;
import java.time.Duration;

public final class VelocityTaskScheduler implements TaskScheduler {

  private final Object plugin;
  private final ProxyServer server;

  public VelocityTaskScheduler(final Object plugin, final ProxyServer server) {
    this.plugin = plugin;
    this.server = server;
  }

  @Override
  public void schedule(final Runnable task, final Duration delay) {
    server.getScheduler().buildTask(plugin, task).delay(delay).repeat(delay).schedule();
  }
}
