package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginLoader;
import org.bukkit.plugin.java.JavaPlugin;

import com.avaje.ebean.EbeanServer;

public class ReitzRPGCore extends JavaPlugin {

	public static Plugin plugin;
	public static FileConfiguration config;
	
	
	//this method is used to make registering events a lot easier THREAD: https://bukkit.org/threads/tutorial-using-multiple-classes.179833/
	public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
		for (Listener listener : listeners) {
		Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
		}
		}
	
	
	@Override
	public List<String> onTabComplete(CommandSender arg0, Command arg1,
			String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FileConfiguration getConfig() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public EbeanServer getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InputStream getResource(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		plugin = this;
	    getLogger().info("ReitzRPGCore 2.0 is now enabled");
	    config = getConfig();
	    PlayerData.setup(this);
	    FileManager.FileManagerFiles(); //enables configurations
	    Mining_Block_Experience_Config.Configuration();
	    Woodcutting_Block_Experience_Config.Configuration();
	    Digging_Block_Experience_Config.Configuration();
	    Fishing_Block_Experience_Config.Configuration();
	    Distance_Level_System_Monster_Config.Configuration();
	    Distance_Level_System_Experience_Config.Configuration();
	    API.Set_Mining_Block_Experience();
	    API.Set_Woodcutting_Block_Experience();
	    API.Set_Digging_Block_Experience();
	    API.Set_Fishing_Block_Experience();
	    API.Set_Distance_Level_Monster_Configuration();
	    API.Set_Distance_Level_Experience_Config();
	    this.getCommand("ReitzRPGCore").setExecutor(new ReitzRPGCore_Stat_Commands());
		registerEvents(this,new OnPlayerJoin(), new OnPlayerExit(), new Mining_Block_Experience(),
				new Woodcutting_Block_Experience(), new Distance_Level_System_Health(), new Distance_Level_System_Attack(),
				new Distance_Level_System_Experience(), new Fishing_Block_Experience()); //registers all events Do this last
		
		
		
		
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reloadConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveDefaultConfig() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveResource(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}




}
