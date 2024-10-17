package dev.shiza.itemshopsys.bukkit.command;

import dev.shiza.itemshopsys.ItemShopCommand;
import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public final class BukkitItemShopCommand
    implements ItemShopCommand<CommandSender>, CommandExecutor {

  private final ItemShopClientConfig config;

  public BukkitItemShopCommand(final ItemShopClientConfig config) {
    this.config = config;
  }

  @Override
  public boolean onCommand(
      @NotNull final CommandSender sender,
      @NotNull final Command command,
      @NotNull final String label,
      @NotNull final String[] args) {
    executeCommand(sender, args);
    return false;
  }

  @Override
  public boolean hasPermission(final CommandSender source, final String permission) {
    return source.hasPermission(permission);
  }

  @Override
  public void sendMessage(final CommandSender source, final String message) {
    source.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
  }

  @Override
  public ItemShopClientConfig getConfig() {
    return config;
  }
}
