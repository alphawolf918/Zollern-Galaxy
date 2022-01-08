/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import java.lang.reflect.InvocationTargetException;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAltum;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAstros;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCaligro;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCentotl;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderEden;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKriffon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderOasis;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPerdita;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderTlaloc;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderToci;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;
import zollerngalaxy.mobs.entities.villagers.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.villagers.EntityAstrosVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCaligroVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCentotlVillager;
import zollerngalaxy.mobs.entities.villagers.EntityEdenVillager;
import zollerngalaxy.mobs.entities.villagers.EntityHarranVillager;
import zollerngalaxy.mobs.entities.villagers.EntityKriffonVillager;
import zollerngalaxy.mobs.entities.villagers.EntityOasisVillager;
import zollerngalaxy.mobs.entities.villagers.EntityPerditaVillager;
import zollerngalaxy.mobs.entities.villagers.EntityPurgotVillager;
import zollerngalaxy.mobs.entities.villagers.EntityTlalocVillager;
import zollerngalaxy.mobs.entities.villagers.EntityTociVillager;
import zollerngalaxy.mobs.entities.villagers.EntityZollusVillager;

public class VillageUtils {
	
	/**
	 * Convert Alien Villagers to planet-specific Villagers.
	 * All you need to pass is the event, everything else
	 * comes with it.
	 * 
	 * @param event
	 *            EntityJoinWorldEvent
	 */
	public static void ConvertVillagers(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		if (!world.isRemote) {
			WorldProvider provider = world.provider;
			Entity entity = event.getEntity();
			if (provider instanceof WorldProviderAltum) {
				VillageUtils.transformIntoVillager(world, entity, EntityAbyssalVillager.class);
			} else if (provider instanceof WorldProviderMetztli) {
				VillageUtils.transformIntoVillager(world, entity, EntityHarranVillager.class);
			} else if (provider instanceof WorldProviderEden) {
				VillageUtils.transformIntoVillager(world, entity, EntityEdenVillager.class);
			} else if (provider instanceof WorldProviderAstros) {
				VillageUtils.transformIntoVillager(world, entity, EntityAstrosVillager.class);
			} else if (provider instanceof WorldProviderCaligro) {
				VillageUtils.transformIntoVillager(world, entity, EntityCaligroVillager.class);
			} else if (provider instanceof WorldProviderZollus) {
				VillageUtils.transformIntoVillager(world, entity, EntityZollusVillager.class);
			} else if (provider instanceof WorldProviderKriffon) {
				VillageUtils.transformIntoVillager(world, entity, EntityKriffonVillager.class);
			} else if (provider instanceof WorldProviderPurgot) {
				VillageUtils.transformIntoVillager(world, entity, EntityPurgotVillager.class);
			} else if (provider instanceof WorldProviderCentotl) {
				VillageUtils.transformIntoVillager(world, entity, EntityCentotlVillager.class);
			} else if (provider instanceof WorldProviderToci) {
				VillageUtils.transformIntoVillager(world, entity, EntityTociVillager.class);
			} else if (provider instanceof WorldProviderPerdita) {
				VillageUtils.transformIntoVillager(world, entity, EntityPerditaVillager.class);
			} else if (provider instanceof WorldProviderTlaloc) {
				VillageUtils.transformIntoVillager(world, entity, EntityTlalocVillager.class);
			} else if (provider instanceof WorldProviderOasis) {
				VillageUtils.transformIntoVillager(world, entity, EntityOasisVillager.class);
			}
		}
		
	}
	
	/**
	 * Uses Java Reflection to convert GC's default Alien Villagers to the planet-appropriate ones.
	 * 
	 * @param worldIn
	 *            The current World.
	 * @param entity
	 *            The Alien Villager entity to convert.
	 * @param villagerIn
	 *            The ZG Villager class of the entity to convert this Villager to.
	 */
	private static void transformIntoVillager(World worldIn, Entity entity, Class<? extends EntityZGVillagerBase> villagerIn) {
		if (!worldIn.isRemote) {
			if (entity instanceof EntityAlienVillager) {
				EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
				BlockPos worldPos = alienVillager.getPos();
				alienVillager.setDead();
				try {
					EntityZGVillagerBase zgVillager = villagerIn.getDeclaredConstructor(World.class).newInstance(worldIn);
					zgVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
					worldIn.spawnEntity(zgVillager);
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
					ZGHelper.LogErr("There was an error in trying to convert an Alien Villager!");
					e.printStackTrace();
				}
			}
		}
	}
}