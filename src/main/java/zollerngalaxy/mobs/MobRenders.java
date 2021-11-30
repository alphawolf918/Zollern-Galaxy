/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import zollerngalaxy.mobs.entities.EntityArcon;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityFaceless;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.mobs.entities.EntityGalaxyKnight;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityGypsyFish;
import zollerngalaxy.mobs.entities.EntityJellyfish;
import zollerngalaxy.mobs.entities.EntityKrull;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityPigShroom;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShade;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.EntitySpiderling;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.entities.EntityWasp;
import zollerngalaxy.mobs.entities.boss.EntityShadowAlien;
import zollerngalaxy.mobs.entities.villagers.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.villagers.EntityAstrosVillager;
import zollerngalaxy.mobs.entities.villagers.EntityCaligroVillager;
import zollerngalaxy.mobs.entities.villagers.EntityEdenVillager;
import zollerngalaxy.mobs.entities.villagers.EntityHarranVillager;
import zollerngalaxy.mobs.entities.villagers.EntityZollusVillager;
import zollerngalaxy.mobs.entities.zombiemutations.EntityGhoul;
import zollerngalaxy.mobs.entities.zombiemutations.EntityOverlord;
import zollerngalaxy.mobs.entities.zombiemutations.EntitySeeker;
import zollerngalaxy.mobs.entities.zombiemutations.EntityVolatile;
import zollerngalaxy.mobs.renders.RenderArcon;
import zollerngalaxy.mobs.renders.RenderBladeFish;
import zollerngalaxy.mobs.renders.RenderBlubberFish;
import zollerngalaxy.mobs.renders.RenderFaceless;
import zollerngalaxy.mobs.renders.RenderFrostGiant;
import zollerngalaxy.mobs.renders.RenderGalaxyKnight;
import zollerngalaxy.mobs.renders.RenderGrayAlien;
import zollerngalaxy.mobs.renders.RenderGypsyFish;
import zollerngalaxy.mobs.renders.RenderJellyfish;
import zollerngalaxy.mobs.renders.RenderKrull;
import zollerngalaxy.mobs.renders.RenderMagmos;
import zollerngalaxy.mobs.renders.RenderMegaCreeper;
import zollerngalaxy.mobs.renders.RenderMoolus;
import zollerngalaxy.mobs.renders.RenderMummy;
import zollerngalaxy.mobs.renders.RenderOinkus;
import zollerngalaxy.mobs.renders.RenderPigShroom;
import zollerngalaxy.mobs.renders.RenderScorpion;
import zollerngalaxy.mobs.renders.RenderShade;
import zollerngalaxy.mobs.renders.RenderShadowSkeleton;
import zollerngalaxy.mobs.renders.RenderShark;
import zollerngalaxy.mobs.renders.RenderSpiderling;
import zollerngalaxy.mobs.renders.RenderSquidlus;
import zollerngalaxy.mobs.renders.RenderWasp;
import zollerngalaxy.mobs.renders.boss.RenderShadowAlien;
import zollerngalaxy.mobs.renders.villagers.RenderAbyssalVillager;
import zollerngalaxy.mobs.renders.villagers.RenderAstrosVillager;
import zollerngalaxy.mobs.renders.villagers.RenderCaligroVillager;
import zollerngalaxy.mobs.renders.villagers.RenderEdenVillager;
import zollerngalaxy.mobs.renders.villagers.RenderHarranVillager;
import zollerngalaxy.mobs.renders.villagers.RenderZollusVillager;
import zollerngalaxy.mobs.renders.zombiemutations.RenderGhoul;
import zollerngalaxy.mobs.renders.zombiemutations.RenderOverlord;
import zollerngalaxy.mobs.renders.zombiemutations.RenderSeeker;
import zollerngalaxy.mobs.renders.zombiemutations.RenderVolatile;

public final class MobRenders {
	
	public static void init() {
		RenderMob(EntityMoolus.class, RenderMoolus::new);
		RenderMob(EntityOinkus.class, RenderOinkus::new);
		RenderMob(EntitySquidlus.class, RenderSquidlus::new);
		RenderMob(EntityFrostGiant.class, RenderFrostGiant::new);
		RenderMob(EntityMagmos.class, RenderMagmos::new);
		RenderMob(EntityGrayAlien.class, RenderGrayAlien::new);
		RenderMob(EntityMegaCreeper.class, RenderMegaCreeper::new);
		RenderMob(EntityGalaxyKnight.class, RenderGalaxyKnight::new);
		RenderMob(EntityMummy.class, RenderMummy::new);
		RenderMob(EntityScorpion.class, RenderScorpion::new);
		RenderMob(EntityBlubberFish.class, RenderBlubberFish::new);
		RenderMob(EntityGypsyFish.class, RenderGypsyFish::new);
		RenderMob(EntityBladeFish.class, RenderBladeFish::new);
		RenderMob(EntityShark.class, RenderShark::new);
		RenderMob(EntityJellyfish.class, RenderJellyfish::new);
		RenderMob(EntityAbyssalVillager.class, RenderAbyssalVillager::new);
		RenderMob(EntityWasp.class, RenderWasp::new);
		RenderMob(EntityKrull.class, RenderKrull::new);
		RenderMob(EntitySpiderling.class, RenderSpiderling::new);
		RenderMob(EntityShadowSkeleton.class, RenderShadowSkeleton::new);
		RenderMob(EntityShade.class, RenderShade::new);
		RenderMob(EntityShadowAlien.class, RenderShadowAlien::new);
		RenderMob(EntityFaceless.class, RenderFaceless::new);
		RenderMob(EntityPigShroom.class, RenderPigShroom::new);
		RenderMob(EntityArcon.class, RenderArcon::new);
		RenderMob(EntityVolatile.class, RenderVolatile::new);
		RenderMob(EntitySeeker.class, RenderSeeker::new);
		RenderMob(EntityOverlord.class, RenderOverlord::new);
		RenderMob(EntityGhoul.class, RenderGhoul::new);
		RenderMob(EntityHarranVillager.class, RenderHarranVillager::new);
		RenderMob(EntityEdenVillager.class, RenderEdenVillager::new);
		RenderMob(EntityAstrosVillager.class, RenderAstrosVillager::new);
		RenderMob(EntityCaligroVillager.class, RenderCaligroVillager::new);
		RenderMob(EntityZollusVillager.class, RenderZollusVillager::new);
	}
	
	/**
	 * Render a Mob to the registry.
	 * 
	 * @param entityClass
	 *            The .class file of the entity (mob).
	 * @param renderFactory
	 *            The IRenderFactory.
	 */
	private static <T extends Entity> void RenderMob(Class<T> entityClass, IRenderFactory<? super T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
	
}