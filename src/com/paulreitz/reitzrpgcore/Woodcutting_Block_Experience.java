package com.paulreitz.reitzrpgcore;

import java.io.File;

import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Woodcutting_Block_Experience implements Listener
{
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
		File file = FileManager.WoodcuttingExperienceSettings;
		YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
		configuration.addDefault("EXP-PER-LEVEL", 100);
		configuration.addDefault("EXP-CURVE", 1);
		configuration.addDefault("OAK", 5);
		configuration.addDefault("SPRUCE", 5);
		configuration.addDefault("BIRCH", 5);
		configuration.addDefault("JUNGLE", 5);
		configuration.addDefault("ACACIA", 5);
		configuration.addDefault("DARK_OAK", 5);
	 */
	
	final int Oak = API.woodcutting_block_experience.getInt("OAK");
	final int Spruce = API.woodcutting_block_experience.getInt("SPRUCE");
	final int Birch = API.woodcutting_block_experience.getInt("BIRCH");
	final int Jungle = API.woodcutting_block_experience.getInt("JUNGLE");
	final int Acacia = API.woodcutting_block_experience.getInt("ACACIA");
	final int Dark_Oak = API.woodcutting_block_experience.getInt("DARK_OAK");
	final int EXP_PER_LEVEL = API.woodcutting_block_experience.getInt("EXP-PER-LEVEL");
	final int EXP_CURVE = API.woodcutting_block_experience.getInt("EXP-CURVE");
	
	 @EventHandler(ignoreCancelled = true,priority=EventPriority.NORMAL)
	    public void onBlockBreak(BlockBreakEvent event)
	    {
		
		 if (event.isCancelled()) { return; }
	    	if(event.getPlayer().getGameMode() == GameMode.CREATIVE)
	    	{
	    		return; //no exp for creative!
	    	}	
	    	//now to assume normal operations
	    	
	    	Player p = event.getPlayer();
	    	PlayerData pd = API.Players.get(event.getPlayer().getName());
	    	
	    	int Woodcutting_Experience;
	    	int Woodcutting_Level;
	    	
	    	Woodcutting_Experience = pd.getData().getInt("Woodcutting-EXP");
	    	Woodcutting_Level = pd.getData().getInt("Woodcutting");
	    	Block block = event.getBlock();
	    	
		 
	    	if(event.getBlock().getTypeId() == 17 && block.getData() == 0 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Oak;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 17 && block.getData() == 1 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Spruce;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    	}
	    	if(event.getBlock().getTypeId() == 17 && block.getData() == 2 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Birch;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    	}
	    	if(event.getBlock().getTypeId() == 17 && block.getData() == 3 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Jungle;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    	}
	    	if(event.getBlock().getTypeId() == 162 && block.getData() == 0 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Acacia;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    	}
	    	if(event.getBlock().getTypeId() == 162 && block.getData() == 1 )
	    	{
	    		Woodcutting_Experience = Woodcutting_Experience + Dark_Oak;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience);
	    	}
	    	
	    	
	    	
	    	int HOW_MUCH_TO_LEVEL = EXP_PER_LEVEL * EXP_CURVE * Woodcutting_Level;
	    	if(Woodcutting_Experience >= HOW_MUCH_TO_LEVEL)
	    		{
	    		event.getPlayer().sendMessage("Your woodcutting skill has increased.");
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting", Woodcutting_Level+1);
	    		API.Players.get(event.getPlayer().getName()).getData().set("Woodcutting-EXP", Woodcutting_Experience -  HOW_MUCH_TO_LEVEL);
	    		ScoreboardManager scoreboard = new ScoreboardManager(event.getPlayer(), pd);
	    		
	    		
	    		
	    		}
	    	//int Mining_Level
		 
		 
	         }
}
