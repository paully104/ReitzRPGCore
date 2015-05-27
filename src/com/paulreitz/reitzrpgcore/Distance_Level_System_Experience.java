package com.paulreitz.reitzrpgcore;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;

public class Distance_Level_System_Experience implements Listener {
	/*
	 * LIST OF STUFF
	File file = FileManager.DistanceLevelExperienceSettings;
	YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
	configuration.addDefault("EXP-PER-LEVEL", 100);
	configuration.addDefault("EXP-CURVE", 2);
	configuration.addDefault("EXP-PER-MONSTER-LEVEL", 2);
	
	configuration.addDefault("BLAZE", 5);
	configuration.addDefault("CAVE_SPIDER", 5);		
	configuration.addDefault("CHICKEN", 1);		
	configuration.addDefault("COW", 1);		
	configuration.addDefault("CREEPER", 5);	
	configuration.addDefault("ENDER_DRAGON", 5000);		
	configuration.addDefault("ENDERMAN", 25);	
	configuration.addDefault("ENDERMITE", 10);	
	configuration.addDefault("GHAST", 50);	
	configuration.addDefault("GIANT", 10);	
	configuration.addDefault("GUARDIAN", 7);
	configuration.addDefault("MAGMA_CUBE",7);
	configuration.addDefault("MUSHROOM_COW", 1);	
	configuration.addDefault("PIG", 1);	
	configuration.addDefault("PIG_ZOMBIE", 20);	
	configuration.addDefault("RABBIT", 1);		
	configuration.addDefault("SHEEP", 1);	
	configuration.addDefault("SILVERFISH", 2);	
	configuration.addDefault("SKELETON", 3);	
	configuration.addDefault("SLIME", 5);		
	configuration.addDefault("SNOWMAN", 1);	
	configuration.addDefault("SPIDER", 4);
	configuration.addDefault("SQUID", 1);
	configuration.addDefault("VILLAGER", -10);
	configuration.addDefault("WOLF", 1);
	configuration.addDefault("ZOMBIE", 3);
	*/
	int Blocks_Per_Level = API.distance_level_monster_configuration.getInt("BLOCKS-PER-MOB-LEVEL");
	int exp_per_monster_level = API.distance_level_experience_configuration.getInt("EXP-PER-MONSTER-LEVEL");
	
	int Blaze = API.distance_level_experience_configuration.getInt("BLAZE"); //done
	int Cave_Spider = API.distance_level_experience_configuration.getInt("CAVE_SPIDER");//done
	int Chicken = API.distance_level_experience_configuration.getInt("CHICKEN");
	int Cow = API.distance_level_experience_configuration.getInt("COW");
	int Creeper = API.distance_level_experience_configuration.getInt("CREEPER"); //done
	int Ender_Dragon = API.distance_level_experience_configuration.getInt("ENDER_DRAGON");
	int Enderman = API.distance_level_experience_configuration.getInt("ENDERMAN");
	int Endermite = API.distance_level_experience_configuration.getInt("ENDERMITE");
	int Ghast = API.distance_level_experience_configuration.getInt("GHAST");
	int Giant = API.distance_level_experience_configuration.getInt("GIANT");
	int Guardian = API.distance_level_experience_configuration.getInt("GUARDIAN");
	int Magma_Cube = API.distance_level_experience_configuration.getInt("MAGMA_CUBE");
	int Mushroom_Cow = API.distance_level_experience_configuration.getInt("MUSHROOM_COW");
	int Pig = API.distance_level_experience_configuration.getInt("PIG");
	int Pig_Zombie = API.distance_level_experience_configuration.getInt("PIG_ZOMBIE");
	int Rabbit = API.distance_level_experience_configuration.getInt("RABBIT");
	int Sheep = API.distance_level_experience_configuration.getInt("SHEEP");
	int Silverfish = API.distance_level_experience_configuration.getInt("SILVERFISH");
	int Skeleton = API.distance_level_experience_configuration.getInt("SKELETON"); //done
	int Slime = API.distance_level_experience_configuration.getInt("SLIME");
	int Snowman = API.distance_level_experience_configuration.getInt("SNOWMAN");
	int Spider= API.distance_level_experience_configuration.getInt("SPIDER"); //done
	int Squid= API.distance_level_experience_configuration.getInt("SQUID");
	int Villager = API.distance_level_experience_configuration.getInt("VILLAGER");
	int Wolf = API.distance_level_experience_configuration.getInt("WOLF");
	int Zombie = API.distance_level_experience_configuration.getInt("ZOMBIE"); //done
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void OnMonsterDeathCausedByPlayer(EntityDeathEvent e)
	{
		//This verifies that the reason the monster died was due to combat. 
		if(e.getEntity().getLastDamageCause().getCause() == DamageCause.ENTITY_ATTACK || e.getEntity().getLastDamageCause().getCause() == DamageCause.ENTITY_EXPLOSION
				|| e.getEntity().getLastDamageCause().getCause() == DamageCause.PROJECTILE)
		{
		
			Entity dying_entity = e.getEntity();
			Entity killing_entity = e.getEntity().getKiller();
			
			if(killing_entity.getType() == EntityType.ARROW)
			{
				Arrow arrow = (Arrow)killing_entity;
				killing_entity = (Entity) arrow.getShooter();
				
			}
		
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.BLAZE)//PLAYER KILLS BLAZE
			{
			Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
			Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
			int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
				int calculatedexp = Blaze + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			//Blaze has died from player
			
			}
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.ZOMBIE)//PLAYER KILLS ZOMBIE
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
				int calculatedexp = Zombie + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.SKELETON)//PLAYER KILLS SKELETON
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
			
				int calculatedexp = Skeleton + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
			
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.CREEPER)//PLAYER KILLS CREEPER
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
			
				int calculatedexp = Creeper + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.CAVE_SPIDER)//PLAYER KILLS CAVE SPIDER
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
			
				int calculatedexp = Cave_Spider + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
			
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.SPIDER)//PLAYER KILLS SPIDER
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
			
				int calculatedexp = Spider + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
			if(killing_entity.getType() == EntityType.PLAYER && dying_entity.getType() == EntityType.ENDERMAN)//PLAYER KILLS ENDERMAN
			{
				Integer currentcombatexp = API.Players.get(killing_entity.getName()).getData().getInt("Combat-EXP");
				Float level = Distance_Level_System_Health.CalculateDistanceFromSpawn(dying_entity.getWorld(), dying_entity);
				int level_rounded = Math.round(level / Blocks_Per_Level);
				if(level_rounded < 1)
				{
				level_rounded = 1;
				
				}
			
				int calculatedexp = Enderman + (level_rounded * exp_per_monster_level);
				API.Players.get(killing_entity.getName()).getData().set("Combat-EXP", currentcombatexp + calculatedexp);
				ScoreboardManager scoreboard = new ScoreboardManager((Player)killing_entity, API.Players.get(killing_entity.getName()));
			
			
			
			}
		
		}//end of giant if they died in combat
		
		
	}

}
