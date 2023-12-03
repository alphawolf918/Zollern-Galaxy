/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compat;

import org.avp.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.entities.living.species.xenomorphs.EntityDrone;
import org.avp.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.entities.living.species.xenomorphs.EntityPraetorian;
import org.avp.entities.living.species.xenomorphs.EntityWarrior;
import org.avp.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollerngalaxy.lib.helpers.ZGHelper;

public class AvPCompat {
	
	public static void init() {
		ZGHelper.Log("AvP compat has initialized.");
	}
	
	public static void addAvPSpawns(Biome biome) {
		biome.getSpawnableList(EnumCreatureType.MONSTER).add(new SpawnListEntry(EntityFacehugger.class, 2, 1, 2));
		EntityRegistry.addSpawn(EntityNauticomorph.class, 2, 1, 2, EnumCreatureType.MONSTER, biome);
		EntityRegistry.addSpawn(EntityDrone.class, 25, 1, 3, EnumCreatureType.MONSTER, biome);
		EntityRegistry.addSpawn(EntityWarrior.class, 10, 1, 3, EnumCreatureType.MONSTER, biome);
		EntityRegistry.addSpawn(EntityPraetorian.class, 3, 1, 2, EnumCreatureType.MONSTER, biome);
		EntityRegistry.addSpawn(EntityChestburster.class, 2, 1, 3, EnumCreatureType.MONSTER, biome);
	}
}