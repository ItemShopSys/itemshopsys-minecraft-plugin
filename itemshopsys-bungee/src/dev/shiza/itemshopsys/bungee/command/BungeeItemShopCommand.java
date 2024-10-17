package dev.shiza.itemshopsys.bungee.command;

import dev.shiza.itemshopsys.ItemShopCommand;
import dev.shiza.itemshopsys.client.ItemShopClientConfig;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;

public final class BungeeItemShopCommand extends Command implements ItemShopCommand<CommandSender> {

  private final ItemShopClientConfig config;

  public BungeeItemShopCommand(final ItemShopClientConfig config) {
    super("itemshopsys", "itemshopsys.reload");
    this.config = config;
  }

  @Override
  public void execute(final CommandSender source, final String[] args) {
    executeCommand(source, args);
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
