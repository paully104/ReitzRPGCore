package com.paulreitz.reitzrpgcore;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Distance_Level_System_Attack implements Listener{

	int Blocks_Per_Level = API.distance_level_monster_configuration.getInt("BLOCKS-PER-MOB-LEVEL");
	int Damage_Scale = API.distance_level_monster_configuration.getInt("ATTACK-GAIN-PER-LEVEL");
	
	//Zombie Section
	int Zombie_Base_Damage = API.distance_level_monster_configuration.getInt("ZOMBIE_BASE_ATTACK");
	
	//Skeleton Section
	int Skeleton_Base_Damage = API.distance_level_monster_configuration.getInt("SKELETON_BASE_ATTACK");
	//spider
	int Spider_Base_Damage = API.distance_level_monster_configuration.getInt("SPIDER_BASE_ATTACK");
	
	//Creeper
	int Creeper_Base_Damage = API.distance_level_experience_configuration.getInt("CREEPER_BASE_ATTACK");
	@EventHandler(priority = EventPriority.NORMAL)
	public void OnMonsterAttackingPlayer(EntityDamageByEntityEvent e)
	{
		Entity defender = e.getEntity();
		Entity attacker = e.getDamager();
		System.out.println("Attack event is occuring [ATTACKER]" +attacker + " " + "[DEFENDER]"+defender);
		EntityDamageEvent.DamageCause cause = e.getCause();
		
		if(attacker.getType() == EntityType.ZOMBIE && cause == DamageCause.ENTITY_ATTACK && defender.getType() == EntityType.PLAYER)
		{
			//A Zombie is attacking a player 
			Float distance = Distance_Level_System_Health.CalculateDistanceFromSpawn(attacker.getWorld(), attacker);
			int level = Math.round(distance / Blocks_Per_Level);
			if(level < 1)
			{
				level = 1;
				
			}
			e.setDamage(Zombie_Base_Damage + (level * Damage_Scale));
			int damage = Zombie_Base_Damage + (level * Damage_Scale);
			System.out.println(damage);
		    			
		    			
		}
		if(attacker.getType() == EntityType.SKELETON && cause == DamageCause.ENTITY_ATTACK && defender.getType() == EntityType.PLAYER)
		{
			//A Skeleton is attacking a player 
			Float distance = Distance_Level_System_Health.CalculateDistanceFromSpawn(attacker.getWorld(), attacker);
			int level = Math.round(distance / Blocks_Per_Level);
			if(level < 1)
			{
				level = 1;
				
			}
			e.setDamage(Skeleton_Base_Damage + (level * Damage_Scale));
			int damage = Skeleton_Base_Damage + (level * Damage_Scale);
			System.out.println(damage);
		    			
		}
		if(attacker.getType() == EntityType.SPIDER && cause == DamageCause.ENTITY_ATTACK && defender.getType() == EntityType.PLAYER)
		{
			//A Spider is attacking a player 
			Float distance = Distance_Level_System_Health.CalculateDistanceFromSpawn(attacker.getWorld(), attacker);
			int level = Math.round(distance / Blocks_Per_Level);
			if(level < 1)
			{
				level = 1;
				
			}
			e.setDamage(Spider_Base_Damage + (level * Damage_Scale));
			int damage = Spider_Base_Damage + (level * Damage_Scale);
			System.out.println(damage);
		    			
		}
		if(attacker.getType() == EntityType.CREEPER && cause == DamageCause.ENTITY_EXPLOSION && defender.getType() == EntityType.PLAYER)
		{
			//A Spider is attacking a player 
			Float distance = Distance_Level_System_Health.CalculateDistanceFromSpawn(attacker.getWorld(), attacker);
			int level = Math.round(distance / Blocks_Per_Level);
			if(level < 1)
			{
				level = 1;
				
			}
			e.setDamage(Creeper_Base_Damage + (level * Damage_Scale));
			int damage = Creeper_Base_Damage + (level * Damage_Scale);
			System.out.println(damage);
		    			
		}
		
		
	}
	
}
