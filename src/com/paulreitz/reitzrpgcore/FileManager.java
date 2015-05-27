package com.paulreitz.reitzrpgcore;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager
{
	public static File EaseOfUse;
	
	public static File ItemConfiguration;
	
	public static File MiningExperienceSettings;
	
	public static File WoodcuttingExperienceSettings;
	
	public static File DiggingExperienceSettings;
	
	public static File FishingExperienceSettings;
	
	public static File DistanceLevelMonsterSettings;
	
	public static File DistanceLevelExperienceSettings;
	
	

	public static void FileManagerFiles()
	{

		EaseOfUse = new File("plugins/ReitzRPGCore/Ease_Of_Use_Configuration.yml");
		
		ItemConfiguration = new File("plugins/ReitzRPGCore/Item_Configuration.yml");
		
		MiningExperienceSettings = new File("plugins/ReitzRPGCore/Mining_Experience_Settings.yml");
		
		WoodcuttingExperienceSettings = new File("plugins/ReitzRPGCore/Woodcutting_Experience_Settings.yml");
		
	    DiggingExperienceSettings = new File("plugins/ReitzRPGCore/Digging_Experience_Settings.yml");
	    
	    DistanceLevelMonsterSettings = new File("plugins/ReitzRPGCore/Distance_Level_Monster_Settings.yml");
	    
	    DistanceLevelExperienceSettings = new File("plugins/ReitzRPGCore/Distance_Level_Experience_Settings.yml");
	    
	    FishingExperienceSettings = new File("plugins/ReitzRPGCore/Fishing_Experience_Settings.yml");
	
	}
	public static void FileManagerSave(File file)
	{
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		try {
			configuration.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
