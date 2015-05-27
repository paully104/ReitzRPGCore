package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Distance_Level_System_Experience_Config {

	public static void Configuration()
	{
		File file = FileManager.DistanceLevelExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This configuration is used to set experience values");
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-PER-MONSTER-LEVEL", 2);
		
		configuration.addDefault("BLAZE", 5);
		configuration.addDefault("CAVE_SPIDER", 5);		
		configuration.addDefault("CHICKEN", 1);		
		configuration.addDefault("COW", 1);		
		configuration.addDefault("CREEPER", 5);	
		configuration.addDefault("ENDER_DRAGON", 5000);		
		configuration.addDefault("ENDERMAN", 25);	
		configuration.addDefault("ENDERMITE", 10);	
		configuration.addDefault("GHAST", 50);	
		configuration.addDefault("GIANT", 10);	
		configuration.addDefault("GUARDIAN", 7);
		configuration.addDefault("MAGMA_CUBE",7);
		configuration.addDefault("MUSHROOM_COW", 1);	
		configuration.addDefault("PIG", 1);	
		configuration.addDefault("PIG_ZOMBIE", 20);	
		configuration.addDefault("RABBIT", 1);		
		configuration.addDefault("SHEEP", 1);	
		configuration.addDefault("SILVERFISH", 2);	
		configuration.addDefault("SKELETON", 3);	
		configuration.addDefault("SLIME", 5);		
		configuration.addDefault("SNOWMAN", 1);	
		configuration.addDefault("SPIDER", 4);
		configuration.addDefault("SQUID", 1);
		configuration.addDefault("VILLAGER", -10);
		configuration.addDefault("WOLF", 1);
		configuration.addDefault("ZOMBIE", 3);

		
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
