package dev.shiza.itemshopsys.scheduler;

import java.time.Duration;

public interface TaskScheduler {

  void schedule(final Runnable task, final Duration delay);
}
