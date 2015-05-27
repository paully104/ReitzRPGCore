package com.paulreitz.reitzrpgcore;



import org.bukkit.GameMode;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftItem;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class Fishing_Block_Experience implements Listener {
/*
 * 		configuration.addDefault("FISH", 2);
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
 */
	int Fish = API.fishing_block_experience.getInt("FISH");//done
	int Salmon = API.fishing_block_experience.getInt("SALMON");//done
	int Clownfish = API.fishing_block_experience.getInt("CLOWNFISH");//done
	int Pufferfish = API.fishing_block_experience.getInt("PUFFERFISH");//done
	int Bow = API.fishing_block_experience.getInt("BOW");//done
	int Enchanted_Book = API.fishing_block_experience.getInt("ENCHANTED_BOOK");//done
	int Fishing_Rod = API.fishing_block_experience.getInt("FISHING_ROD");//done
	int Name_Tag = API.fishing_block_experience.getInt("NAME_TAG");//done
	int Saddle = API.fishing_block_experience.getInt("SADDLE");//done
    int Lily_Pad = API.fishing_block_experience.getInt("LILY_PAD");//done
    int Bowl = API.fishing_block_experience.getInt("BOWL");//done
    int Leather = API.fishing_block_experience.getInt("LEATHER");//done
    int Leather_Boots = API.fishing_block_experience.getInt("LEATHER_BOOTS");//done
    int Rotten_Flesh = API.fishing_block_experience.getInt("ROTTEN_FLESH");//done
    int Stick = API.fishing_block_experience.getInt("STICK");//done
    int String = API.fishing_block_experience.getInt("STRING");//done
    int Water_Bottle = API.fishing_block_experience.getInt("WATER_BOTTLE");//done
    int Bone = API.fishing_block_experience.getInt("BONE");
    int Ink_Sac = API.fishing_block_experience.getInt("INK_SAC");
    int Tripwire_Hook = API.fishing_block_experience.getInt("TRIPWIRE_HOOK");
    
    int EXP_PER_LEVEL = API.fishing_block_experience.getInt("EXP-PER-LEVEL");
    int EXP_CURVE = API.fishing_block_experience.getInt("EXP-CURVE");
    
  //ScoreboardManager scoreboard = new ScoreboardManager(p,API.Players.get(p.getName()));
    
    @EventHandler (priority = EventPriority.NORMAL)
    public void PlayerFishEventIsOccuring(PlayerFishEvent e)
    {
		 if (e.isCancelled()) { return; }
	    	if(e.getPlayer().getGameMode() == GameMode.CREATIVE)
	    	{
	    		return; //no exp for creative!
	    	}
    	
    	if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH || e.getState() == PlayerFishEvent.State.CAUGHT_ENTITY)
    	{
    	Player p = e.getPlayer();
    	Entity caught = e.getCaught();
    	if(caught instanceof CraftItem)
    	{
    		CraftItem itemcaught = (CraftItem)caught;
    		ItemStack itemcaughtdata = itemcaught.getItemStack(); //how to tell different ids
    		int id = ((CraftItem) caught).getItemStack().getTypeId();
    		
    		
    		if(id == 349 && itemcaughtdata.getData().getData() == 0)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Fish;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);
    		}
    		if(id == 349 && itemcaughtdata.getData().getData() == 1)//Salmon
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Salmon;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 349 && itemcaughtdata.getData().getData() == 2)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Clownfish;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 349 && itemcaughtdata.getData().getData() == 3)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Pufferfish;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		
    		if(id == 261)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Bow;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 403)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Enchanted_Book;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 346)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Fishing_Rod;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 421)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Name_Tag;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 329)//raw fish
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Saddle;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 111)//LILY
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Lily_Pad;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 281)//Bowl
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Bowl;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 334)//Leather
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Leather;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 301)//Leather Boots
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Leather_Boots;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 367)//Rotten_Flesh
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Rotten_Flesh;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 280)//Stick
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Stick;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 367)//String
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + String;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 374)//Water bottle
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Water_Bottle;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 352)//bone
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Bone;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 351)//ink sac
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Ink_Sac;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}
    		if(id == 131)//tripwire
    		{
    			Integer fishingexp = API.Players.get(p.getName()).getData().getInt("Fishing-EXP");
    			Integer calculatedexp = fishingexp + Tripwire_Hook;
				API.Players.get(p.getName()).getData().set("Fishing-EXP", calculatedexp);				
    		}

    	}//end of catch list
    	
    	PlayerData pd = API.Players.get(e.getPlayer().getName());
    	int Fishing_Experience = pd.getData().getInt("Fishing-EXP");
    	int Fishing_Level = pd.getData().getInt("Fishing");
    	
    	System.out.println(EXP_PER_LEVEL + " " + EXP_CURVE + " " + Fishing_Level);
    	int HOW_MUCH_TO_LEVEL = EXP_PER_LEVEL * EXP_CURVE * Fishing_Level;
    	if(Fishing_Experience >= HOW_MUCH_TO_LEVEL)
    	{
    		e.getPlayer().sendMessage("Your fishing skill has increased.");
    		API.Players.get(e.getPlayer().getName()).getData().set("Fishing", Fishing_Level+1);
    		API.Players.get(e.getPlayer().getName()).getData().set("Fishing-EXP", Fishing_Experience -  HOW_MUCH_TO_LEVEL);
    		ScoreboardManager scoreboard = new ScoreboardManager(e.getPlayer(), pd);
    		
    		
    		
    	}
    	
    	
    	
    	}
    	
    	
    }
    
    
}
