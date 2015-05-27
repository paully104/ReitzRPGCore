package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Distance_Level_System_Monster_Config {
	
	public static void Configuration()
	{
		File file = FileManager.DistanceLevelMonsterSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This config is used to enable or disable monsters affected by the distance leveling system."
				+ "it is also used to set monsters base attack and health");
		configuration.addDefault("BLOCKS-PER-MOB-LEVEL", 100);
		configuration.addDefault("ATTACK-GAIN-PER-LEVEL", 1);
		configuration.addDefault("HEALTH-GAIN-PER-LEVEL", 1);
		
		configuration.addDefault("APPLY-ON-SPAWNER-SPAWNS", true);
		
		configuration.addDefault("BLAZE", true);
		
		configuration.addDefault("BLAZE_BASE_HP", 4);
		configuration.addDefault("BLAZE_BASE_ATTACK", 3);
		
		
		configuration.addDefault("CAVE_SPIDER", true);
		
		configuration.addDefault("CHICKEN", true);
		
		configuration.addDefault("COW", false);
		
		configuration.addDefault("CREEPER", true);
		configuration.addDefault("CREEPER_BASE_ATTACK", 5);
		configuration.addDefault("CREEPER_BASE_HP", 8);
		
		configuration.addDefault("ENDER_DRAGON", true);
		
		configuration.addDefault("ENDERMAN", true);
		configuration.addDefault("ENDERMAN_BASE_HP", 5);
		configuration.addDefault("ENDERMAN_BASE_ATTACK", 3);
		
		configuration.addDefault("ENDERMITE", true);
		
		configuration.addDefault("GHAST", true);
		
		configuration.addDefault("GIANT", true);
		
		configuration.addDefault("GUARDIAN", true);
		
		configuration.addDefault("MAGMA_CUBE", true);
		
		configuration.addDefault("MUSHROOM_COW", false);
		
		configuration.addDefault("PIG", false);
		
		configuration.addDefault("PIG_ZOMBIE", true);
		
		configuration.addDefault("RABBIT", false);
		
		
		configuration.addDefault("SHEEP", false);
		
		configuration.addDefault("SILVERFISH", true);
		
		configuration.addDefault("SKELETON", true);
		configuration.addDefault("SKELETON_BASE_HP", 4);
		configuration.addDefault("SKELETON_BASE_ATTACK", 2);
		
		configuration.addDefault("SLIME", true);
		
		configuration.addDefault("SNOWMAN", false);
		
		configuration.addDefault("SPIDER", true);
		configuration.addDefault("SPIDER_BASE_HP", 5);
		configuration.addDefault("SPIDER_BASE_ATTACK", 3);
		
		
		configuration.addDefault("SQUID", true);
		
		configuration.addDefault("VILLAGER", false);
		
		configuration.addDefault("WOLF", true);
		
		configuration.addDefault("ZOMBIE", true);
		configuration.addDefault("ZOMBIE_BASE_HP", 5);
		configuration.addDefault("ZOMBIE_BASE_ATTACK", 3);
		

		
		configuration.options().copyDefaults(true);
		
		try {
			configuration.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
	}

}
