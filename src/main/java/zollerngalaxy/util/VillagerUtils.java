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
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAltum;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAstros;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAtheon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCaligro;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCandora;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCentotl;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderEden;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderExodus;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKriffon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKronos;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderOasis;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPerdita;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderTlaloc;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderToci;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;
import zollerngalaxy.mobs.entities.villagers.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.villagers.EntityAstrosVillager;
import zollerngalaxy.mobs.entities.villagers.EntityAtheonVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCaligroVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCandoraVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCentotlVillager;
import zollerngalaxy.mobs.entities.villagers.EntityEdenVillager;
import zollerngalaxy.mobs.entities.villagers.EntityExodusVillager;
import zollerngalaxy.mobs.entities.villagers.EntityHarranVillager;
import zollerngalaxy.mobs.entities.villagers.EntityKriffonVillager;
import zollerngalaxy.mobs.entities.villagers.EntityKronosVillager;
import zollerngalaxy.mobs.entities.villagers.EntityOasisVillager;
import zollerngalaxy.mobs.entities.villagers.EntityPerditaVillager;
import zollerngalaxy.mobs.entities.villagers.EntityPurgotVillager;
import zollerngalaxy.mobs.entities.villagers.EntityTlalocVillager;
import zollerngalaxy.mobs.entities.villagers.EntityTociVillager;
import zollerngalaxy.mobs.entities.villagers.EntityZollusVillager;

public class VillagerUtils {
	
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
			Entity entity = event.getEntity();
			VillagerUtils.transformIntoVillager(world, entity, EntityAbyssalVillager.class, WorldProviderAltum.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityHarranVillager.class, WorldProviderMetztli.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityEdenVillager.class, WorldProviderEden.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityAstrosVillager.class, WorldProviderAstros.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityCaligroVillager.class, WorldProviderCaligro.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityZollusVillager.class, WorldProviderZollus.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityKriffonVillager.class, WorldProviderKriffon.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityPurgotVillager.class, WorldProviderPurgot.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityCentotlVillager.class, WorldProviderCentotl.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityTociVillager.class, WorldProviderToci.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityPerditaVillager.class, WorldProviderPerdita.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityTlalocVillager.class, WorldProviderTlaloc.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityOasisVillager.class, WorldProviderOasis.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityCandoraVillager.class, WorldProviderCandora.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityExodusVillager.class, WorldProviderExodus.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityKronosVillager.class, WorldProviderKronos.class);
			VillagerUtils.transformIntoVillager(world, entity, EntityAtheonVillager.class, WorldProviderAtheon.class);
		}
	}
	
	/**
	 * Uses basic Java Reflection to convert GC's default Alien Villagers to the world-appropriate
	 * ones.
	 * 
	 * @param worldIn
	 *            The current World.
	 * @param entity
	 *            The Alien Villager entity to convert.
	 * @param villagerIn
	 *            The ZG Villager class of the entity to convert this Villager to.
	 * @param providerClassIn
	 *            The WorldProvider class for this planet or moon.
	 */
	private static void transformIntoVillager(World worldIn, Entity entity, Class<? extends EntityZGVillagerBase> villagerIn, Class<? extends WorldProviderZG> providerClassIn) {
		if (!worldIn.isRemote) {
			if (entity instanceof EntityAlienVillager) {
				if (worldIn.provider.getClass() == providerClassIn) {
					EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
					BlockPos worldPos = alienVillager.getPos();
					alienVillager.setDead();
					try {
						EntityZGVillagerBase zgVillager = villagerIn.getDeclaredConstructor(World.class).newInstance(worldIn);
						zgVillager.copyLocationAndAnglesFrom(alienVillager);
						worldIn.spawnEntity(zgVillager);
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
						ZGHelper.LogErr("There was an error in trying to convert an Alien Villager!");
						e.printStackTrace();
					}
				}
			}
		}
	}
}