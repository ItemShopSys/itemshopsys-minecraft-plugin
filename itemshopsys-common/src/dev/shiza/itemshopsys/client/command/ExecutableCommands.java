package dev.shiza.itemshopsys.client.command;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public final class ExecutableCommands {

  private final @SerializedName("data") List<ExecutableCommand> commands;

  public ExecutableCommands(final List<ExecutableCommand> commands) {
    this.commands = commands;
  }

  public List<ExecutableCommand> getCommands() {
    return commands;
  }

  @Override
  public String toString() {
    return "ExecutableCommands{" +
        "commands=" + commands +
        '}';
  }
}
