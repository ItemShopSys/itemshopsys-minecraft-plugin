package dev.shiza.itemshopsys.bukkit.scheduler;

import dev.shiza.itemshopsys.scheduler.TaskScheduler;
import dev.shiza.itemshopsys.time.MinecraftTimeEquivalent;
import java.time.Duration;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public final class BukkitTaskScheduler implements TaskScheduler {

  private final Plugin plugin;
  private final Server server;

  public BukkitTaskScheduler(final Plugin plugin) {
    this.plugin = plugin;
    this.server = plugin.getServer();
  }

  @Override
  public void schedule(final Runnable task, final Duration delay) {
    server
        .getScheduler()
        .runTaskTimerAsynchronously(
            plugin, task, MinecraftTimeEquivalent.of(delay), MinecraftTimeEquivalent.of(delay));
  }
}
