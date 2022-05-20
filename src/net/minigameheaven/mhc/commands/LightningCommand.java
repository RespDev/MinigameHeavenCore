package net.minigameheaven.mhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.minigameheaven.mhc.rank.Rank;
import net.minigameheaven.mhc.rank.RankManager;

public class LightningCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] arguments) {
		if (name.equalsIgnoreCase("lightning")) {
			Player p = (Player) sender;
			Integer rid = Rank.getId(RankManager.getRank(p.getUniqueId()));
			if (rid >= Rank.getId(Rank.ADMIN)) {
				for (Player o : Bukkit.getOnlinePlayers()) {
					o.getWorld().strikeLightning(o.getLocation());
					o.setHealth(20);
				}
				return true;
			}
			else {
				p.sendMessage(ChatColor.RED + "Try again tomorrow and maybe it will work!");
				return true;
			}
		}
			
		return false;
	}
}