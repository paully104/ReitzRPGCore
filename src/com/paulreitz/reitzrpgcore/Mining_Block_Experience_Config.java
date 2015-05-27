package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Mining_Block_Experience_Config {
	
	public static void Configuration()
	{
		File file = FileManager.MiningExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This config is used to set exp for mining");
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-CURVE", 2);
		configuration.addDefault("Dirt", 1);
		configuration.addDefault("Stone", 2);
		configuration.addDefault("Granite", 2);
		configuration.addDefault("Cobblestone", 3);
		configuration.addDefault("Gravel", 1);
		configuration.addDefault("Gold", 10);
		configuration.addDefault("Iron", 7);
		configuration.addDefault("Coal", 5);
		configuration.addDefault("Lapis", 5);
		configuration.addDefault("Diamond", 25);
		configuration.options().copyDefaults(true);
		configuration.options().copyHeader(true);
		
		try {
			configuration.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
