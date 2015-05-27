package com.paulreitz.reitzrpgcore;

import java.io.File;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Digging_Block_Experience implements Listener {

	/*	MASTER LIST OF ALL EXPERIENCE VALUES
	Double Health = pd.getData().getDouble("Health");
	Integer Archery = pd.getData().getInt("Archery");
	Integer Attack = pd.getData().getInt("Attack");
	Integer Defense = pd.getData().getInt("Defense");
	Integer CombatEXP = pd.getData().getInt("Combat-EXP");
	Integer Magic = pd.getData().getInt("Magic");
    Integer MiningEXP = pd.getData().getInt("Mining-EXP");
    Integer WoodcuttingEXP = pd.getData().getInt("Woodcutting-EXP");
    Integer Fishing =  pd.getData().getInt("Fishing");
    Integer Digging = pd.getData().getInt("Digging");
    Integer DiggingEXP = pd.getData().getInt("Digging-EXP");
    Integer FishingEXP = pd.getData().getInt("Fishing-EXP");
    Integer Backpacksize = pd.getData().getInt("BackPack-Size");
    Integer Woodcutting = pd.getData().getInt("Woodcutting");
    Integer Mining = pd.getData().getInt("Mining");
    String Backpack = pd.getData().getString("BackPack");
	*/
	
	/*		ITEMS WITH VALUES
		File file = FileManager.DiggingExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
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
	 */
	
	final int Clay = API.digging_block_experience.getInt("Clay");
	final int Farmland = API.digging_block_experience.getInt("Farmland");
	final int Grass = API.digging_block_experience.getInt("Grass");
	final int Gravel = API.digging_block_experience.getInt("Gravel");
	final int Mycelium = API.digging_block_experience.getInt("Mycelium");
	final int Dirt = API.digging_block_experience.getInt("Dirt");
	final int Sand = API.digging_block_experience.getInt("Sand");
	final int SoulSand = API.digging_block_experience.getInt("SoulSand");
	final int Snow = API.digging_block_experience.getInt("Snow");
	final int EXP_PER_LEVEL = API.digging_block_experience.getInt("EXP-PER-LEVEL");
	final int EXP_CURVE = API.digging_block_experience.getInt("EXP-CURVE");
	
	 @EventHandler(ignoreCancelled = true,priority=EventPriority.NORMAL)
	    public void onBlockBreak(BlockBreakEvent event)
	    {
		 System.out.println("Block break event in woodcutting is working");
		 if (event.isCancelled()) { return; }
	    	if(event.getPlayer().getGameMode() == GameMode.CREATIVE)
	    	{
	    		return; //no exp for creative!
	    	}	
	    	//now to assume normal operations
	    	
	    	Player p = event.getPlayer();
	    	PlayerData pd = API.Players.get(event.getPlayer().getName());
	    	
	    	int Digging_Experience;
	    	int Digging_Level;
	    	
	    	Digging_Experience = pd.getData().getInt("Woodcutting-EXP");
	    	Digging_Level = pd.getData().getInt("Woodcutting");
	    	
		 
	    	if(event.getBlock().getTypeId() == 82)//clay
	    	{
	    		Digging_Experience = Digging_Experience + Clay;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 60)//farmland
	    	{
	    		Digging_Experience = Digging_Experience + Farmland;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 2)//grass
	    	{
	    		Digging_Experience = Digging_Experience + Grass;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 13)//gravel
	    	{
	    		Digging_Experience = Digging_Experience + Gravel;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 110)//Mycelium
	    	{
	    		Digging_Experience = Digging_Experience + Mycelium;    		
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 3)//dirt
	    	{
	    		Digging_Experience = Digging_Experience + Dirt;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 12)//dirt
	    	{
	    		Digging_Experience = Digging_Experience + Sand;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 88)//soulsand
	    	{
	    		Digging_Experience = Digging_Experience + SoulSand;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	if(event.getBlock().getTypeId() == 78 || event.getBlock().getTypeId() == 80)//dirt
	    	{
	    		Digging_Experience = Digging_Experience + Snow;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience);	    		
	    	}
	    	 /* 		
	    	  * 	EXPERIENCE AND EXPERIENCE CURVE SECTOR
	    	  * 	configuration.addDefault("EXP-PER-LEVEL", 100);
					configuration.addDefault("EXP-CURVE", 2)
	    	 */
	    	int HOW_MUCH_TO_LEVEL = EXP_PER_LEVEL * EXP_CURVE * Digging_Level;
	    	if(Digging_Experience >= HOW_MUCH_TO_LEVEL)
	    		{
	    		event.getPlayer().sendMessage("Your woodcutting skill has increased.");
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging", Digging_Level+1);
	    		API.Players.get(event.getPlayer().getName()).getData().set("Digging-EXP", Digging_Experience -  HOW_MUCH_TO_LEVEL);
	    		ScoreboardManager scoreboard = new ScoreboardManager(event.getPlayer(), pd);
	    		
	    		
	    		
	    		}
	    	//int Mining_Level
		 
		 
	         }
}


