package dev.shiza.itemshopsys.client.command;

import com.google.gson.annotations.SerializedName;
import java.util.UUID;
import org.jetbrains.annotations.Nullable;

public final class ExecutableCommand {

  private final @SerializedName("uuid") UUID uniqueId;
  private final String command;
  private final @SerializedName("player") String playerName;
  private final @SerializedName("playerOnlineCheck") boolean requiresOnline;

  public ExecutableCommand(
      final UUID uniqueId,
      final String command,
      final String playerName,
      final boolean requiresOnline) {
    this.uniqueId = uniqueId;
    this.command = command;
    this.playerName = playerName;
    this.requiresOnline = requiresOnline;
  }

  public UUID getUniqueId() {
    return uniqueId;
  }

  public String getCommand() {
    return command;
  }

  @Nullable
  public String getPlayerName() {
    return playerName;
  }

  public boolean isRequiresOnline() {
    return requiresOnline;
  }

  @Override
  public String toString() {
    return "ExecutableCommand{" +
        "uniqueId=" + uniqueId +
        ", command='" + command + '\'' +
        ", playerName='" + playerName + '\'' +
        ", requiresOnline=" + requiresOnline +
        '}';
  }
}
