package com.paulreitz.reitzrpgcore;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Mining_Block_Experience implements Listener{
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
	 * 		configuration.addDefault("Dirt", 1);
		configuration.addDefault("Stone", 2);
		configuration.addDefault("Granite", 2);
		configuration.addDefault("Cobblestone", 3);
		configuration.addDefault("Gravel", 1);
		configuration.addDefault("Gold", 10);
		configuration.addDefault("Iron", 7);
		configuration.addDefault("Coal", 5);
		configuration.addDefault("Lapis", 5);
		configuration.addDefault("Diamond", 25);
	 */
	
	final int Dirt = API.mining_block_experience.getInt("Dirt");
	final int Stone = API.mining_block_experience.getInt("Stone");
	final int Granite = API.mining_block_experience.getInt("Granite");
	final int Cobblestone = API.mining_block_experience.getInt("Cobblestone");
	final int Gravel = API.mining_block_experience.getInt("Gravel");
	final int Gold = API.mining_block_experience.getInt("Gold");
	final int Iron = API.mining_block_experience.getInt("Iron");
	final int Coal = API.mining_block_experience.getInt("Coal");
	final int Lapis = API.mining_block_experience.getInt("Lapis");
	final int Diamond = API.mining_block_experience.getInt("Diamond");
	final int EXP_PER_LEVEL = API.mining_block_experience.getInt("EXP-PER-LEVEL");
	final int EXP_CURVE = API.mining_block_experience.getInt("EXP-CURVE");
	
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
	    	
	    	int Mining_Experience;
	    	int Mining_Level;
	    	
	    	Mining_Experience = pd.getData().getInt("Mining-EXP");
	    	Mining_Level = pd.getData().getInt("Mining");
	    	
		 
	    	if(event.getBlock().getTypeId() == 3)//dirt
	    	{
	    		Mining_Experience = Mining_Experience + Dirt;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getType().toString().contains("STONE"))//stone
	    	{
	    		Mining_Experience = Mining_Experience + Stone;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		System.out.println("Stone is being broken");
	    		System.out.println(Mining_Experience);
	    	}
	    	if(event.getBlock().getType().toString().contains("GRANITE"))//granite
	    	{
	    		Mining_Experience = Mining_Experience + Granite;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 4)//cobblestone
	    	{
	    		Mining_Experience = Mining_Experience + Cobblestone;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 13)//gravel
	    	{
	    		Mining_Experience = Mining_Experience + Gravel;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 14)//gold
	    	{
	    		Mining_Experience = Mining_Experience + Gold;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 15)//iron ore
	    	{
	    		Mining_Experience = Mining_Experience + Iron;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 16)//coal
	    	{
	    		Mining_Experience = Mining_Experience + Coal;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 21)//lapis
	    	{
	    		Mining_Experience = Mining_Experience + Lapis;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	if(event.getBlock().getTypeId() == 56)//diamond
	    	{
	    		Mining_Experience = Mining_Experience + Diamond;
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience);
	    		
	    	}
	    	
	    	 /* 		
	    	  * 	EXPERIENCE AND EXPERIENCE CURVE SECTOR
	    	  * 	configuration.addDefault("EXP-PER-LEVEL", 100);
					configuration.addDefault("EXP-CURVE", 2)
	    	 */
	    	int HOW_MUCH_TO_LEVEL = EXP_PER_LEVEL * EXP_CURVE * Mining_Level;
	    	if(Mining_Experience >= HOW_MUCH_TO_LEVEL)
	    	{
	    		event.getPlayer().sendMessage("Your mining skill has increased.");
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining", Mining_Level+1);
	    		API.Players.get(event.getPlayer().getName()).getData().set("Mining-EXP", Mining_Experience -  HOW_MUCH_TO_LEVEL);
	    		ScoreboardManager scoreboard = new ScoreboardManager(event.getPlayer(), pd);
	    		
	    		
	    		
	    	}
	    	//int Mining_Level
		 
		 
	    }

}
