package com.paulreitz.reitzrpgcore;

import java.util.HashMap;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class API {
	//Contains Player Name as key and then PlayerData as the storage
	static HashMap<String, PlayerData> Players = new HashMap<String, PlayerData>();
	static FileConfiguration mining_block_experience;
	static FileConfiguration woodcutting_block_experience;
	static FileConfiguration digging_block_experience;
	static FileConfiguration distance_level_monster_configuration;
	static FileConfiguration distance_level_experience_configuration;
	static FileConfiguration fishing_block_experience;
	public static void Set_Mining_Block_Experience()
	{
		mining_block_experience = YamlConfiguration.loadConfiguration(FileManager.MiningExperienceSettings);
		
	}
	public static void Set_Woodcutting_Block_Experience()
	{
		woodcutting_block_experience = YamlConfiguration.loadConfiguration(FileManager.WoodcuttingExperienceSettings);
		
	}
	public static void Set_Digging_Block_Experience()
	{
		digging_block_experience = YamlConfiguration.loadConfiguration(FileManager.DiggingExperienceSettings);
		
		
	}
	public static void Set_Distance_Level_Monster_Configuration()
	{
		distance_level_monster_configuration = YamlConfiguration.loadConfiguration(FileManager.DistanceLevelMonsterSettings);
		
	}
	public static void Set_Distance_Level_Experience_Config()
	{
		distance_level_experience_configuration = YamlConfiguration.loadConfiguration(FileManager.DistanceLevelExperienceSettings);
		
	}
	public static void Set_Fishing_Block_Experience()
	{
		
		fishing_block_experience = YamlConfiguration.loadConfiguration(FileManager.FishingExperienceSettings);
	}

}
