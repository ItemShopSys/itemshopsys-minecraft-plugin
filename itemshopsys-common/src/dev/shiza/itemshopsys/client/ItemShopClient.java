package dev.shiza.itemshopsys.client;

import dev.shiza.itemshopsys.client.command.ExecutableCommands;
import java.util.UUID;

public interface ItemShopClient {

  ExecutableCommands retrieveCommands(final String shopId, final String serverId);

  void restoreCommand(final String shopId, final String serverId, final UUID commandUniqueId);
}
