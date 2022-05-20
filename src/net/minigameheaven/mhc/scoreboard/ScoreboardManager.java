package net.minigameheaven.mhc.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.minigameheaven.mhc.rank.Rank;

public class ScoreboardManager {

	public static void loadHubScoreboard(Player p, Rank r) {
		ScoreboardManager Manager = Bukkit.getScoreboardManager();
		Scoreboard Board = Manager.getNewScoreboard();
		Objective Objective = Board.registerNewObjective("Lobby", "dummy");
		Objective.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "LOBBY");
		Objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		// Empty Space
		Score s5 = Objective.getScore(ChatColor.YELLOW + ChatColor.translateAlternateColorCodes('&', "&c&l&c&c ") + ChatColor.GRAY + "  ");
		s5.setScore(5);
		
		// Players Rank
		Score s4 = Objective.getScore(ChatColor.WHITE + "Rank: " + Rank.getSidebarName(r));
		s4.setScore(4);
		
		// Server
		Score s3 = Objective.getScore(ChatColor.WHITE + "Server: " + "Lobby #1");
		s3.setScore(3);
		
		// Empty Space
		Score s2 = Objective.getScore(ChatColor.WHITE + " " + ChatColor.translateAlternateColorCodes('&', "&f"));
		s2.setScore(2);

		// Website
		Score s1 = Objective.getScore(ChatColor.YELLOW + "www.minigameheaven.net");
		s1.setScore(1);
		
		// Set scoreboard
		p.setScoreboard(Board);
	}
}
