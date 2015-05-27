package com.paulreitz.reitzrpgcore;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {
	
	@SuppressWarnings("deprecation")
	public ScoreboardManager(Player p, PlayerData pd)
	{
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
		    

          

		    

}}
