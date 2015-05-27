package com.paulreitz.reitzrpgcore;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor.EntityType;

public class Distance_Level_System_Health implements Listener {
	
	int Blocks_Per_Level = API.distance_level_monster_configuration.getInt("BLOCKS-PER-MOB-LEVEL");
	
	boolean Blaze = API.distance_level_monster_configuration.getBoolean("BLAZE");
	
	boolean Cave_Spider = API.distance_level_monster_configuration.getBoolean("CAVE_SPIDER");
	
	boolean Chicken = API.distance_level_monster_configuration.getBoolean("CHICKEN");
	
	boolean Cow = API.distance_level_monster_configuration.getBoolean("COW");
	
	boolean Creeper = API.distance_level_monster_configuration.getBoolean("CREEPER");//done
	int Creeper_Base_Hp = API.distance_level_monster_configuration.getInt("CREEPER_BASE_HP");
	
	boolean Ender_Dragon = API.distance_level_monster_configuration.getBoolean("ENDER_DRAGON");
	
	boolean Enderman = API.distance_level_monster_configuration.getBoolean("ENDERMAN");
	
	boolean Endermite = API.distance_level_monster_configuration.getBoolean("ENDERMITE");
	
	boolean Ghast = API.distance_level_monster_configuration.getBoolean("GHAST");
	
	boolean Giant = API.distance_level_monster_configuration.getBoolean("GIANT");
	
	boolean Guardian = API.distance_level_monster_configuration.getBoolean("GUARDIAN");
	
	boolean Magma_Cube = API.distance_level_monster_configuration.getBoolean("MAGMA_CUBE");
	
	boolean Mushroom_Cow = API.distance_level_monster_configuration.getBoolean("MUSHROOM_COW");
	
	boolean Pig = API.distance_level_monster_configuration.getBoolean("PIG");
	
	boolean Pig_Zombie = API.distance_level_monster_configuration.getBoolean("PIG_ZOMBIE");
	
	boolean Rabbit = API.distance_level_monster_configuration.getBoolean("RABBIT");
	
	boolean Sheep = API.distance_level_monster_configuration.getBoolean("SHEEP");
	
	boolean Silverfish = API.distance_level_monster_configuration.getBoolean("SILVERFISH");
	
	boolean Skeleton = API.distance_level_monster_configuration.getBoolean("SKELETON");//done
	int Skeleton_Base_Hp = API.distance_level_monster_configuration.getInt("SKELETON_BASE_HP");
	
	boolean Slime = API.distance_level_monster_configuration.getBoolean("SLIME");
	
	boolean Snowman = API.distance_level_monster_configuration.getBoolean("SNOWMAN");
	
	boolean Spider = API.distance_level_monster_configuration.getBoolean("SPIDER");//done
	int Spider_Base_Hp = API.distance_level_monster_configuration.getInt("SPIDER_BASE_HP");
	
	boolean Squid = API.distance_level_monster_configuration.getBoolean("SQUID");
	
	boolean Villager = API.distance_level_monster_configuration.getBoolean("VILLAGER");
	
	boolean Wolf = API.distance_level_monster_configuration.getBoolean("WOLF");
	
	boolean Zombie = API.distance_level_monster_configuration.getBoolean("ZOMBIE");//zombie done
	int Zombie_Base_Hp = API.distance_level_monster_configuration.getInt("ZOMBIE_BASE_HP");
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void OnMonsterSpawnLevelApplied(CreatureSpawnEvent e)
	{
		
		
		if(e.getCreatureType() == CreatureType.ZOMBIE && Zombie == true)
		{
			//this occurs on a Blaze spawn
			Float level = CalculateDistanceFromSpawn(e.getLocation().getWorld(), e.getEntity());
			int level_rounded = Math.round(level / Blocks_Per_Level);
			e.getEntity().setCustomName(level_rounded + " " + e.getCreatureType().toString());
			e.getEntity().setCustomNameVisible(true);
			int health = Zombie_Base_Hp * level_rounded;
			if(health < 1)
			{
				health = 1;				
			}
			e.getEntity().setMaxHealth(health);
			e.getEntity().setHealth(health);
		}
		if(e.getCreatureType() == CreatureType.SKELETON && Skeleton == true)
		{
			//this occurs on a Blaze spawn
			Float level = CalculateDistanceFromSpawn(e.getLocation().getWorld(), e.getEntity());
			int level_rounded = Math.round(level / Blocks_Per_Level);
			e.getEntity().setCustomName(level_rounded + " " +  e.getCreatureType().toString());
			e.getEntity().setCustomNameVisible(true);
			int health = Skeleton_Base_Hp * level_rounded;
			if(health < 1)
			{
				health = 1;				
			}
			e.getEntity().setMaxHealth(health);
			e.getEntity().setHealth(health);
		}
		if(e.getCreatureType() == CreatureType.SPIDER && Spider == true)
		{
			//this occurs on a Blaze spawn
			Float level = CalculateDistanceFromSpawn(e.getLocation().getWorld(), e.getEntity());
			int level_rounded = Math.round(level / Blocks_Per_Level);
			e.getEntity().setCustomName(level_rounded + " " +  e.getCreatureType().toString());
			e.getEntity().setCustomNameVisible(true);
			int health = Spider_Base_Hp * level_rounded;
			if(health < 1)
			{
				health = 1;				
			}
			e.getEntity().setMaxHealth(health);
			e.getEntity().setHealth(health);
		}
		if(e.getCreatureType() == CreatureType.CREEPER && Creeper == true)
		{
			//this occurs on a Blaze spawn
			Float level = CalculateDistanceFromSpawn(e.getLocation().getWorld(), e.getEntity());
			int level_rounded = Math.round(level / Blocks_Per_Level);
			e.getEntity().setCustomName(level_rounded + " " +  e.getCreatureType().toString());
			e.getEntity().setCustomNameVisible(true);
			int health = Creeper_Base_Hp * level_rounded;
			if(health < 1)
			{
				health = 1;				
			}
			e.getEntity().setMaxHealth(health);
			e.getEntity().setHealth(health);
		}
		
		
		
	}
	public static  float CalculateDistanceFromSpawn(World w, Entity e)
	{
		//use this to find the monsters location
		Location spawn = w.getSpawnLocation();
		Location entity_location = e.getLocation();
		float deltaX = (float) (spawn.getX() - entity_location.getX());
		float deltaY= (float) (spawn.getY() - entity_location.getY());
		float deltaZ= (float) (spawn.getZ() - entity_location.getZ());
		float distance = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
		
		
		return distance;
		
		
	}

}
