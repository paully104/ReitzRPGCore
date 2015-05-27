package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class Digging_Block_Experience_Config {

	public static void Configuration()
	{
		File file = FileManager.DiggingExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.options().header("This config is sued to configure digging experience");
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-CURVE", 2);
		configuration.addDefault("Clay", 3);
		configuration.addDefault("Farmland", 2);
		configuration.addDefault("Grass", 1);
		configuration.addDefault("Gravel", 2);
		configuration.addDefault("Mycelium", 2);
		configuration.addDefault("Dirt", 2);
		configuration.addDefault("Sand", 2);
		configuration.addDefault("SoulSand", 5);
		configuration.addDefault("Snow", 1);
		
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
