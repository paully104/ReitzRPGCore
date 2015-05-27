package com.paulreitz.reitzrpgcore;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;



public class OnPlayerExit implements Listener {
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void OnPlayerExitevent(PlayerQuitEvent e)
	{
		System.out.println(ChatColor.RED + "" + e.getPlayer().getName() + " has exited!");
		
		Player p = e.getPlayer();
		PlayerData pd = new PlayerData(p.getName());
		
		//get all stat's from when the player was online
    	Double Health = API.Players.get(e.getPlayer().getName()).getData().getDouble("Health");
    	Integer Archery = API.Players.get(e.getPlayer().getName()).getData().getInt("Archery");
    	Integer Attack = API.Players.get(e.getPlayer().getName()).getData().getInt("Attack");
    	Integer Defense = API.Players.get(e.getPlayer().getName()).getData().getInt("Defense");
    	Integer Combatexp = API.Players.get(e.getPlayer().getName()).getData().getInt("Combat-EXP");
    	Integer Magic = API.Players.get(e.getPlayer().getName()).getData().getInt("Magic");
        Integer MiningEXP = API.Players.get(e.getPlayer().getName()).getData().getInt("Mining-EXP");
        Integer WoodcuttingEXP = API.Players.get(e.getPlayer().getName()).getData().getInt("Woodcutting-EXP");
        Integer Fishing = API.Players.get(e.getPlayer().getName()).getData().getInt("Fishing");
        Integer Digging = API.Players.get(e.getPlayer().getName()).getData().getInt("Digging");
        Integer DiggingEXP = API.Players.get(e.getPlayer().getName()).getData().getInt("Digging-EXP");
        Integer FishingEXP = API.Players.get(e.getPlayer().getName()).getData().getInt("Fishing-EXP");
        Integer Backpacksize =API.Players.get(e.getPlayer().getName()).getData().getInt("BackPack-Size");
        Integer Woodcutting = API.Players.get(e.getPlayer().getName()).getData().getInt("Woodcutting");
        Integer Mining = API.Players.get(e.getPlayer().getName()).getData().getInt("Mining");
        String Backpack = API.Players.get(e.getPlayer().getName()).getData().getString("BackPack");
        
        //set all files to save locally due to them disconnecting
        
        pd.getData().set("Health", Health);
        pd.getData().set("Archery", Archery);
        pd.getData().set("Attack", Attack);
        pd.getData().set("Defense", Defense);
        pd.getData().set("Combat-EXP", Combatexp);
        pd.getData().set("Magic", Magic);
        pd.getData().set("Mining-EXP", MiningEXP);
        pd.getData().set("Woodcutting-EXP", WoodcuttingEXP);
        pd.getData().set("Fishing", Fishing);
        pd.getData().set("Digging", Digging);
        pd.getData().set("Digging-EXP", DiggingEXP);
        pd.getData().set("Fishing-EXP", FishingEXP);
        pd.getData().set("BackPack-Size", Backpacksize);
        pd.getData().set("Woodcutting", Woodcutting);
        pd.getData().set("Mining", Mining);
        pd.getData().set("Backpack", Backpack);
        pd.save();
	}
		
		
	

}
