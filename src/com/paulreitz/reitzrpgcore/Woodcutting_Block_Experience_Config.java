package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Woodcutting_Block_Experience_Config {
	
	public static void Configuration()
	{
		File file = FileManager.WoodcuttingExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This configuration is used to set woodcutting values"
				+ "having the same Minecraft ID");
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-CURVE", 1);
		configuration.addDefault("OAK", 5);
		configuration.addDefault("SPRUCE", 5);
		configuration.addDefault("BIRCH", 5);
		configuration.addDefault("JUNGLE", 5);
		configuration.addDefault("ACACIA", 5);
		configuration.addDefault("DARK_OAK", 5);
		

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



