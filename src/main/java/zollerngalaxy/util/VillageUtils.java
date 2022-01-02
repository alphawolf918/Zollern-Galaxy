/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

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
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPerdita;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderTlaloc;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderToci;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.mobs.entities.villagers.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.villagers.EntityAstrosVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCaligroVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCentotlVillager;
import zollerngalaxy.mobs.entities.villagers.EntityEdenVillager;
import zollerngalaxy.mobs.entities.villagers.EntityHarranVillager;
import zollerngalaxy.mobs.entities.villagers.EntityKriffonVillager;
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
			if (provider instanceof WorldProviderAltum) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityAbyssalVillager abyssalVillager = new EntityAbyssalVillager(world);
						abyssalVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(abyssalVillager);
					}
				}
			} else if (provider instanceof WorldProviderMetztli) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityHarranVillager harranVillager = new EntityHarranVillager(world);
						harranVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(harranVillager);
					}
				}
			} else if (provider instanceof WorldProviderEden) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityEdenVillager edenVillager = new EntityEdenVillager(world);
						edenVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(edenVillager);
					}
				}
			} else if (provider instanceof WorldProviderAstros) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityAstrosVillager astrosVillager = new EntityAstrosVillager(world);
						astrosVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(astrosVillager);
					}
				}
			} else if (provider instanceof WorldProviderCaligro) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityCaligroVillager caligroVillager = new EntityCaligroVillager(world);
						caligroVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(caligroVillager);
					}
				}
			} else if (provider instanceof WorldProviderZollus) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityZollusVillager zollusVillager = new EntityZollusVillager(world);
						zollusVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(zollusVillager);
					}
				}
			} else if (provider instanceof WorldProviderKriffon) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityKriffonVillager kriffonVillager = new EntityKriffonVillager(world);
						kriffonVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(kriffonVillager);
					}
				}
			} else if (provider instanceof WorldProviderPurgot) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityPurgotVillager purgotVillager = new EntityPurgotVillager(world);
						purgotVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(purgotVillager);
					}
				}
			} else if (provider instanceof WorldProviderCentotl) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityCentotlVillager centotlVillager = new EntityCentotlVillager(world);
						centotlVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(centotlVillager);
					}
				}
			} else if (provider instanceof WorldProviderToci) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityTociVillager tociVillager = new EntityTociVillager(world);
						tociVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(tociVillager);
					}
				}
			} else if (provider instanceof WorldProviderPerdita) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityPerditaVillager perditaVillager = new EntityPerditaVillager(world);
						perditaVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(perditaVillager);
					}
				}
			} else if (provider instanceof WorldProviderTlaloc) {
				if (!world.isRemote) {
					Entity entity = event.getEntity();
					if (entity instanceof EntityAlienVillager) {
						EntityAlienVillager alienVillager = (EntityAlienVillager) entity;
						BlockPos worldPos = alienVillager.getPos();
						alienVillager.setDead();
						EntityTlalocVillager tlalocVillager = new EntityTlalocVillager(world);
						tlalocVillager.setPosition(worldPos.getX(), worldPos.getY(), worldPos.getZ());
						world.spawnEntity(tlalocVillager);
					}
				}
			}
		}
	}
}