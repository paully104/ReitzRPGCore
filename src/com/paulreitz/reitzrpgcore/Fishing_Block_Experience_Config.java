package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Fishing_Block_Experience_Config {
	
	public static void Configuration()
	{
		File file = FileManager.FishingExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This configuration is used to set fishing values");
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-CURVE", 1);
		
		configuration.addDefault("FISH", 2);
		configuration.addDefault("SALMON", 4);
		configuration.addDefault("CLOWNFISH", 50);
		configuration.addDefault("PUFFERFISH", 10);
		configuration.addDefault("BOW", 5);
		configuration.addDefault("ENCHANTED_BOOK", 10);
		configuration.addDefault("FISHING_ROD", 15);
		configuration.addDefault("NAME_TAG", 2);
		configuration.addDefault("SADDLE", 10);
		configuration.addDefault("LILY_PAD", 4);
		configuration.addDefault("BOWL", 5);
		configuration.addDefault("LEATHER", 2);
		configuration.addDefault("LEATHER_BOOTS", 2);
		configuration.addDefault("ROTTEN_FLESH", 4);
		configuration.addDefault("STICK", 1);
		configuration.addDefault("STRING", 2);
		configuration.addDefault("WATER_BOTTLE", 3);
		configuration.addDefault("BONE", 1);
		configuration.addDefault("INK_SAC", 1);
		configuration.addDefault("TRIPWIRE_HOOK", 2);
		
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
