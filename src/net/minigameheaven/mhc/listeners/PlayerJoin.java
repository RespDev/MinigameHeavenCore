package net.minigameheaven.mhc.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import net.minigameheaven.mhc.rank.Rank;
import net.minigameheaven.mhc.rank.RankManager;
import net.minigameheaven.mhc.scoreboard.ScoreboardManager;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent j) {
		Player p = (Player) j.getPlayer();
		RankManager.setRank(p.getUniqueId(), Rank.ADMIN);
		Rank rank = RankManager.getRank(j.getPlayer().getUniqueId());
		String name = p.getName();
		ScoreboardManager.loadHubScoreboard(p, rank);
		if (rank == Rank.OWNER) {
			j.setJoinMessage(ChatColor.DARK_BLUE + "[OWNER] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else if (rank == Rank.ADMIN) {
			j.setJoinMessage(ChatColor.RED + "[ADMIN] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else if (rank == Rank.DEV) {
			j.setJoinMessage(ChatColor.RED + "[DEV] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else if (rank == Rank.MOD) {
			j.setJoinMessage(ChatColor.DARK_AQUA + "[MOD] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else if (rank == Rank.TRAINEE) {
			j.setJoinMessage(ChatColor.AQUA + "[TRAINEE] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else if (rank == Rank.VIP) {
			j.setJoinMessage(ChatColor.GREEN + "[VIP] " + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
		else {
			j.setJoinMessage(ChatColor.GRAY + name + ChatColor.LIGHT_PURPLE + " joined the server!");
		}
	}
}
