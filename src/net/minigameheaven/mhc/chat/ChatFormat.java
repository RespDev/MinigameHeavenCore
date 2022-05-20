package net.minigameheaven.mhc.chat;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import net.minigameheaven.mhc.rank.Rank;
import net.minigameheaven.mhc.rank.RankManager;

public class ChatFormat implements Listener {

	@EventHandler
	public void onChat(AsyncPlayerChatEvent c) {
		c.setCancelled(true);
		Player p = (Player) c.getPlayer();
		// Get message
		String message = c.getMessage();
		String name = p.getName();
		UUID uuid = p.getUniqueId();
		Rank r = RankManager.getRank(uuid);
		if (r == Rank.OWNER) {
			c.setFormat(ChatColor.BLUE + "[OWNER] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.ADMIN) {
			c.setFormat(ChatColor.RED + "[ADMIN] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.DEV) {
			c.setFormat(ChatColor.RED + "[DEV] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.MOD) {
			c.setFormat(ChatColor.DARK_AQUA + "[MOD] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.TRAINEE) {
			c.setFormat(ChatColor.AQUA + "[TRAINEE] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.VIP) {
			c.setFormat(ChatColor.GREEN + "[VIP] " + name + ChatColor.WHITE + ": " + message);
			c.setCancelled(false);
		}
		else if (r == Rank.DEFAULT) {
			c.setFormat(ChatColor.GRAY + "[MEMBER] " + name + ": " + message);
			c.setCancelled(false);
		}
		else {
			c.setCancelled(true);
			c.getPlayer().sendMessage(ChatColor.RED + "An error happened trying to send your chat message please contact a staff member!");
		}
	}
}
