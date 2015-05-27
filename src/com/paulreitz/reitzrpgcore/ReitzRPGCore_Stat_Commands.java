package com.paulreitz.reitzrpgcore;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReitzRPGCore_Stat_Commands implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,String label,String[] arg3)
	{
		if(cmd.getName().equalsIgnoreCase("ReitzRPGCore"))
		{
			sender.sendMessage(ChatColor.GREEN + "ReitzRPGCore alpha");
			sender.sendMessage(ChatColor.GREEN + "Redesigned system focusing on performance");
			sender.sendMessage(ChatColor.GREEN + "reliablity & customization");
			sender.sendMessage(ChatColor.GREEN + "made by: Paully104");
			sender.sendMessage(ChatColor.GREEN + "Version .1 Alpha");
			sender.sendMessage(ChatColor.GREEN + "Designed on Spigot 1.8.3");
			
		}
		// TODO Auto-generated method stub
		return false;
	}

}
