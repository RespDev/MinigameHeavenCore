package net.minigameheaven.mhc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import net.minigameheaven.mhc.chat.ChatFormat;
import net.minigameheaven.mhc.commands.LightningCommand;
import net.minigameheaven.mhc.commands.SetRankCommand;
import net.minigameheaven.mhc.listeners.PlayerJoin;

public class MHC extends JavaPlugin {

	@Override
	public void onEnable() {
		registerListeners();
		registerCommands();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		Bukkit.getPluginManager().registerEvents(new ChatFormat(), this);
	}
	
	public void registerCommands() {
		this.getCommand("setrank").setExecutor(new SetRankCommand());
		this.getCommand("lightning").setExecutor(new LightningCommand());
	}
}
