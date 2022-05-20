package net.minigameheaven.mhc.rank;

import org.bukkit.ChatColor;

public enum Rank {
	
	OWNER(6, "Owner", ChatColor.BLUE),
	ADMIN(5, "Admin", ChatColor.RED),
	DEV(4, "Dev", ChatColor.RED),
	MOD(3, "Mod", ChatColor.DARK_AQUA),
	TRAINEE(2, "Trainee", ChatColor.AQUA),
	VIP(1, "Vip", ChatColor.GREEN),
	DEFAULT(0, "Default", ChatColor.GRAY);
	
	Rank (int rankId, String tabName, ChatColor color) {
		
	}
	
	public static Integer getId(Rank r) {
		if (r == Rank.OWNER) {
			return 6;
		}
		if (r == Rank.ADMIN) {
			return 5;
		}
		if (r == Rank.DEV) {
			return 4;
		}
		if (r == Rank.MOD) {
			return 3;
		}
		if (r == Rank.TRAINEE) {
			return 2;
		}
		if (r == Rank.VIP) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public static String getSidebarName(Rank r) {
		if (r == Rank.OWNER) {
			return ChatColor.BLUE + "Owner";
		}
		if (r == Rank.ADMIN) {
			return ChatColor.RED + "Admin";
		}
		if (r == Rank.DEV) {
			return ChatColor.RED + "Dev";
		}
		if (r == Rank.MOD) {
			return ChatColor.DARK_AQUA + "Mod";
		}
		if (r == Rank.TRAINEE) {
			return ChatColor.AQUA + "Trainee";
		}
		if (r == Rank.VIP) {
			return ChatColor.GREEN + "Vip";
		}
		else {
			return ChatColor.GRAY + "Member";
		}
	}
}
