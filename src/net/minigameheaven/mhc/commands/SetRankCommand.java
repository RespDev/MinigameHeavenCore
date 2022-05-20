package net.minigameheaven.mhc.commands;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import net.minigameheaven.mhc.rank.Rank;
import net.minigameheaven.mhc.rank.RankManager;

public class SetRankCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] arguments) {
		if (name.equalsIgnoreCase("setrank")) {
			Player p = (Player) sender;
			Integer rid = Rank.getId(RankManager.getRank(p.getUniqueId()));
			if (rid >= Rank.getId(Rank.ADMIN)) {
				if (arguments.length == 0) {
					p.sendMessage(ChatColor.RED + "Usage: /setrank [player] [rank]");
					return true;
				}
				if (arguments.length == 1) {
					p.sendMessage(ChatColor.RED + "Usage: /setrank [player] [rank]");
					return true;
				}
				// Yay the player used the command right!
				if (Bukkit.getPlayer(arguments[0]) == null) {
					p.sendMessage(ChatColor.RED + "That player does not exist!");
					return true;
				}
				Player argPlayer = (Player) Bukkit.getPlayer(arguments[0]);
				UUID argUUID = argPlayer.getUniqueId();
				if (arguments[1].equalsIgnoreCase("owner")) {
					RankManager.setRank(argUUID, Rank.OWNER);
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Owner!");
					return true;
				}
				if (arguments[1].equalsIgnoreCase("admin")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Admin!");
					RankManager.setRank(argUUID, Rank.ADMIN);
					return true;
				}
				if (arguments[1].equalsIgnoreCase("dev")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Dev!");
					RankManager.setRank(argUUID, Rank.DEV);
					return true;
				}
				if (arguments[1].equalsIgnoreCase("mod")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Mod!");
					RankManager.setRank(argUUID, Rank.MOD);
					return true;
				}
				if (arguments[1].equalsIgnoreCase("trainee")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Trainee!");
					RankManager.setRank(argUUID, Rank.TRAINEE);
					return true;
				}
				if (arguments[1].equalsIgnoreCase("vip")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Vip!");
					RankManager.setRank(argUUID, Rank.VIP);
					return true;
				}
				if (arguments[1].equalsIgnoreCase("default")) {
					p.sendMessage(ChatColor.GREEN + "You have set " + arguments[0] + "'s" + " rank to Default!");
					RankManager.setRank(argUUID, Rank.DEFAULT);
					return true;
				}
				else {
					p.sendMessage(ChatColor.RED + "That rank does not exist!");
					return true;
				}
			}
			else {
				p.sendMessage(ChatColor.RED + "Try again tomorrow and maybe it will work!");
				return true;
			}
		}
		return false;
	}
}