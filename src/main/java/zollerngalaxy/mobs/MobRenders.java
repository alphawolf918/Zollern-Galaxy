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
import zollerngalaxy.mobs.entities.EntityAbyssalVillager;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityGypsyFish;
import zollerngalaxy.mobs.entities.EntityJellyfish;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.entities.EntityWasp;
import zollerngalaxy.mobs.renders.RenderAbyssalVillager;
import zollerngalaxy.mobs.renders.RenderBladeFish;
import zollerngalaxy.mobs.renders.RenderBlubberFish;
import zollerngalaxy.mobs.renders.RenderFrostGiant;
import zollerngalaxy.mobs.renders.RenderGrayAlien;
import zollerngalaxy.mobs.renders.RenderGypsyFish;
import zollerngalaxy.mobs.renders.RenderJellyfish;
import zollerngalaxy.mobs.renders.RenderMagmos;
import zollerngalaxy.mobs.renders.RenderMegaCreeper;
import zollerngalaxy.mobs.renders.RenderMoolus;
import zollerngalaxy.mobs.renders.RenderMummy;
import zollerngalaxy.mobs.renders.RenderOinkus;
import zollerngalaxy.mobs.renders.RenderScorpion;
import zollerngalaxy.mobs.renders.RenderShark;
import zollerngalaxy.mobs.renders.RenderSquidlus;
import zollerngalaxy.mobs.renders.RenderWasp;

public final class MobRenders {
	
	public static void init() {
		RenderMob(EntityMoolus.class, RenderMoolus::new);
		RenderMob(EntityOinkus.class, RenderOinkus::new);
		RenderMob(EntitySquidlus.class, RenderSquidlus::new);
		RenderMob(EntityFrostGiant.class, RenderFrostGiant::new);
		RenderMob(EntityMagmos.class, RenderMagmos::new);
		RenderMob(EntityGrayAlien.class, RenderGrayAlien::new);
		RenderMob(EntityMegaCreeper.class, RenderMegaCreeper::new);
		RenderMob(EntityMummy.class, RenderMummy::new);
		RenderMob(EntityScorpion.class, RenderScorpion::new);
		RenderMob(EntityBlubberFish.class, RenderBlubberFish::new);
		RenderMob(EntityGypsyFish.class, RenderGypsyFish::new);
		RenderMob(EntityBladeFish.class, RenderBladeFish::new);
		RenderMob(EntityShark.class, RenderShark::new);
		RenderMob(EntityJellyfish.class, RenderJellyfish::new);
		RenderMob(EntityAbyssalVillager.class, RenderAbyssalVillager::new);
		RenderMob(EntityWasp.class, RenderWasp::new);
	}
	
	/**
	 * Render a Mob to the registry.
	 * 
	 * @param entityClass
	 *            The .class file of the entity (mob).
	 * @param renderFactory
	 *            the IRenderFactory.
	 */
	public static <T extends Entity> void RenderMob(Class<T> entityClass, IRenderFactory<? super T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
	
}