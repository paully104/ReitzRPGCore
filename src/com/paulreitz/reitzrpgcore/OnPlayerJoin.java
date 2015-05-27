package com.paulreitz.reitzrpgcore;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import com.mysql.jdbc.Messages;

public class OnPlayerJoin implements Listener{
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void OnPlayerJoinStatSetup(PlayerJoinEvent e)
	{

		
		Player p = e.getPlayer();
		
		PlayerData pd = new PlayerData(p.getName());
		pd.getData().set("Name", p.getName());
		
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
		
     	pd.getData().set("Name", p.getName());
    	
    	if(Health == 0.0)
    	{
    		pd.getData().set("Health", 20);
    		p.setMaxHealth(20);
    		
    	}	
    	else
    	{
    		
    		p.setMaxHealth(Health);
    	}
    	if(Archery == 0)
    	{
    	pd.getData().set("Archery", 1);	
    	
    	}	
    	if(Attack == 0)
    	{
    		pd.getData().set("Attack", 1);
    		
    	}	
    	if(Defense == 0)
    	{
    		pd.getData().set("Defense", 1);
    		
    		
    	}
    	if(CombatEXP == 0)
    	{
    		pd.getData().set("Combat-EXP", 0);
    		
    				
    	}
    	if(Magic == 0)
    	{
    		
    		pd.getData().set("Magic", 1);
    		
    	}	
    	if(MiningEXP == 0)
    	{
    		pd.getData().set("Mining-EXP", 0);
    		
    	}	
    	if(WoodcuttingEXP == 0)
    	{
    		pd.getData().set("Woodcutting-EXP", 0);
    		
    		
    	}	
    	if(Woodcutting == 0)
    	{
    		pd.getData().set("Woodcutting", 1);
    		
    		
    	}	
    	if(Mining == 0)
    	{
    		pd.getData().set("Mining", 1);
    		
    		
    	}		    	
    	if(Fishing == 0)
    	{
    		pd.getData().set("Fishing", 1);
    		
    		
    	}	
    	if(Digging == 0)
    	{
    		pd.getData().set("Digging", 1);
    		
    	}	
    	if(DiggingEXP == 0)
    	{
    		pd.getData().set("Digging-EXP", 0);
    		
    	}	
    	if(FishingEXP == 0)
    	{
    		pd.getData().set("Fishing-EXP", 0);
    		
    		
    	}
    	if(Backpacksize == 0 || Backpacksize == null)
    	{
    		pd.getData().set("BackPack-Size", 9);
    		pd.getData().set("BackPack", "9;");
    		
    		
    	}	
    	if(Backpack == null || Backpack.equalsIgnoreCase(""))
    	{
    		pd.getData().set("BackPack", "9;");
    		pd.getData().set("BackPack-Size", 9);
    		
    	}	
    	pd.save();
    	API.Players.put(e.getPlayer().getName(), pd);
    	
    	
	    //ScoreboardStuff.manageScoreboard(p, "TeamName");
	    
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("info", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(p.getName() + " stats");
      
        String displayname = p.getDisplayName();
    	displayname = ChatColor.stripColor(displayname);
    	String displayname2 = displayname.substring(0, 1).toUpperCase() + displayname.substring(1);
    	objective.setDisplayName(ChatColor.GOLD+displayname2);
    	
    	Score archery = objective.getScore((ChatColor.GOLD + ("Archery"))); //$NON-NLS-1$
    	archery.setScore(pd.getData().getInt("Archery"));  //$NON-NLS-1$
    	
    	Score attack = objective.getScore((ChatColor.GOLD + ("Attack"))); //$NON-NLS-1$
    	attack.setScore(pd.getData().getInt("Attack")); //Integer only! //$NON-NLS-1$
    	
    	Score defence = objective.getScore((ChatColor.GOLD + ("Defense"))); //$NON-NLS-1$
    	defence.setScore(pd.getData().getInt("Defense")); //$NON-NLS-1$
    	    
    	Score magic = objective.getScore((ChatColor.GOLD + ("Magic"))); //$NON-NLS-1$
	    magic.setScore(pd.getData().getInt("Magic")); //$NON-NLS-1$
	    
	    Score mining = objective.getScore((ChatColor.GOLD + ("Mining"))); //$NON-NLS-1$
	    mining.setScore(pd.getData().getInt("Mining")); //$NON-NLS-1$
	    
	    Score woodcutting = objective.getScore((ChatColor.GOLD + ("Woodcutting"))); //$NON-NLS-1$
	    woodcutting.setScore(pd.getData().getInt("Woodcutting")); //$NON-NLS-1$

	    Score combat_exp = objective.getScore((ChatColor.GOLD + ("Combat Experience"))); //$NON-NLS-1$
	    combat_exp.setScore(pd.getData().getInt("Combat-EXP")); //$NON-NLS-1$
	    
	    Score digging = objective.getScore((ChatColor.GOLD + ("Digging"))); //$NON-NLS-1$
	    digging.setScore(pd.getData().getInt("Digging"));    //$NON-NLS-1$
	    
	    Score fishing = objective.getScore((ChatColor.GOLD + ("Fishing"))); //$NON-NLS-1$
	    fishing.setScore(pd.getData().getInt("Fishing")); //$NON-NLS-1$
	       	       	
    	p.setScoreboard(board);
	}
}
    	


