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
import zollerngalaxy.mobs.entities.EntityBloodWorm;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityEdenCow;
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.entities.EntityFaceless;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.mobs.entities.EntityGalaxyDragon;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityGypsyFish;
import zollerngalaxy.mobs.entities.EntityHelleton;
import zollerngalaxy.mobs.entities.EntityJellyfish;
import zollerngalaxy.mobs.entities.EntityKrull;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityPigShroom;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShade;
import zollerngalaxy.mobs.entities.EntityShadowSkeleton;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.EntitySpiderling;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import zollerngalaxy.mobs.entities.EntityVexBot;
import zollerngalaxy.mobs.entities.EntityVexBotGold;
import zollerngalaxy.mobs.entities.EntityWanderer;
import zollerngalaxy.mobs.entities.EntityWasp;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.mobs.entities.boss.EntityShadowAlien;
import zollerngalaxy.mobs.entities.boss.EntityVexBotBoss;
import zollerngalaxy.mobs.entities.boss.EntityXenomorphQueen;
import zollerngalaxy.mobs.entities.companions.EntityGalaxyKnight;
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
import zollerngalaxy.mobs.entities.zombiemutations.EntityGhoul;
import zollerngalaxy.mobs.entities.zombiemutations.EntityOverlord;
import zollerngalaxy.mobs.entities.zombiemutations.EntitySeeker;
import zollerngalaxy.mobs.entities.zombiemutations.EntityVolatile;
import zollerngalaxy.mobs.renders.RenderArcon;
import zollerngalaxy.mobs.renders.RenderBladeFish;
import zollerngalaxy.mobs.renders.RenderBloodWorm;
import zollerngalaxy.mobs.renders.RenderBlubberFish;
import zollerngalaxy.mobs.renders.RenderFacehugger;
import zollerngalaxy.mobs.renders.RenderFaceless;
import zollerngalaxy.mobs.renders.RenderFrostGiant;
import zollerngalaxy.mobs.renders.RenderGalaxyDragon;
import zollerngalaxy.mobs.renders.RenderGalaxyKnight;
import zollerngalaxy.mobs.renders.RenderGrayAlien;
import zollerngalaxy.mobs.renders.RenderGypsyFish;
import zollerngalaxy.mobs.renders.RenderHelleton;
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
import zollerngalaxy.mobs.renders.RenderVexbot;
import zollerngalaxy.mobs.renders.RenderVexbotGold;
import zollerngalaxy.mobs.renders.RenderWanderer;
import zollerngalaxy.mobs.renders.RenderWasp;
import zollerngalaxy.mobs.renders.RenderXenomorph;
import zollerngalaxy.mobs.renders.boss.RenderShadowAlien;
import zollerngalaxy.mobs.renders.boss.RenderVexbotBoss;
import zollerngalaxy.mobs.renders.boss.RenderXenomorphQueen;
import zollerngalaxy.mobs.renders.villagers.RenderAbyssalVillager;
import zollerngalaxy.mobs.renders.villagers.RenderAstrosVillager;
import zollerngalaxy.mobs.renders.villagers.RenderAtheonVillager;
import zollerngalaxy.mobs.renders.villagers.RenderCaligroVillager;
import zollerngalaxy.mobs.renders.villagers.RenderCandoraVillager;
import zollerngalaxy.mobs.renders.villagers.RenderCentotlVillager;
import zollerngalaxy.mobs.renders.villagers.RenderEdenVillager;
import zollerngalaxy.mobs.renders.villagers.RenderExodusVillager;
import zollerngalaxy.mobs.renders.villagers.RenderHarranVillager;
import zollerngalaxy.mobs.renders.villagers.RenderKriffonVillager;
import zollerngalaxy.mobs.renders.villagers.RenderKronosVillager;
import zollerngalaxy.mobs.renders.villagers.RenderOasisVillager;
import zollerngalaxy.mobs.renders.villagers.RenderPerditaVillager;
import zollerngalaxy.mobs.renders.villagers.RenderPurgotVillager;
import zollerngalaxy.mobs.renders.villagers.RenderTlalocVillager;
import zollerngalaxy.mobs.renders.villagers.RenderTociVillager;
import zollerngalaxy.mobs.renders.villagers.RenderZollusVillager;
import zollerngalaxy.mobs.renders.zombiemutations.RenderGhoul;
import zollerngalaxy.mobs.renders.zombiemutations.RenderOverlord;
import zollerngalaxy.mobs.renders.zombiemutations.RenderSeeker;
import zollerngalaxy.mobs.renders.zombiemutations.RenderVolatile;

public final class MobRenders {
	
	public static void init() {
		MobRenders.renderFish();
		MobRenders.renderBugs();
		MobRenders.renderAnimals();
		MobRenders.renderPassiveAliens();
		MobRenders.renderVillagers();
		MobRenders.renderEnemies();
		MobRenders.renderBosses();
	}
	
	private static void renderFish() {
		MobRenders.renderMob(EntitySquidlus.class, RenderSquidlus::new);
		MobRenders.renderMob(EntityBlubberFish.class, RenderBlubberFish::new);
		MobRenders.renderMob(EntityGypsyFish.class, RenderGypsyFish::new);
		MobRenders.renderMob(EntityBladeFish.class, RenderBladeFish::new);
		MobRenders.renderMob(EntityShark.class, RenderShark::new);
		MobRenders.renderMob(EntityJellyfish.class, RenderJellyfish::new);
	}
	
	private static void renderBugs() {
		renderMob(EntityWasp.class, RenderWasp::new);
	}
	
	private static void renderAnimals() {
		MobRenders.renderMob(EntityEdenCow.class, RenderMoolus::new);
		MobRenders.renderMob(EntityOinkus.class, RenderOinkus::new);
		MobRenders.renderMob(EntityPigShroom.class, RenderPigShroom::new);
		MobRenders.renderMob(EntityGalaxyDragon.class, RenderGalaxyDragon::new);
	}
	
	private static void renderPassiveAliens() {
		MobRenders.renderMob(EntityArcon.class, RenderArcon::new);
		MobRenders.renderMob(EntityWanderer.class, RenderWanderer::new);
	}
	
	private static void renderVillagers() {
		renderMob(EntityHarranVillager.class, RenderHarranVillager::new);
		renderMob(EntityAbyssalVillager.class, RenderAbyssalVillager::new);
		renderMob(EntityEdenVillager.class, RenderEdenVillager::new);
		renderMob(EntityAstrosVillager.class, RenderAstrosVillager::new);
		renderMob(EntityCaligroVillager.class, RenderCaligroVillager::new);
		renderMob(EntityZollusVillager.class, RenderZollusVillager::new);
		renderMob(EntityKriffonVillager.class, RenderKriffonVillager::new);
		renderMob(EntityPurgotVillager.class, RenderPurgotVillager::new);
		renderMob(EntityTociVillager.class, RenderTociVillager::new);
		renderMob(EntityPerditaVillager.class, RenderPerditaVillager::new);
		renderMob(EntityTlalocVillager.class, RenderTlalocVillager::new);
		renderMob(EntityCentotlVillager.class, RenderCentotlVillager::new);
		renderMob(EntityOasisVillager.class, RenderOasisVillager::new);
		renderMob(EntityCandoraVillager.class, RenderCandoraVillager::new);
		renderMob(EntityExodusVillager.class, RenderExodusVillager::new);
		renderMob(EntityKronosVillager.class, RenderKronosVillager::new);
		renderMob(EntityAtheonVillager.class, RenderAtheonVillager::new);
	}
	
	private static void renderEnemies() {
		MobRenders.renderMob(EntityFrostGiant.class, RenderFrostGiant::new);
		MobRenders.renderMob(EntityMagmos.class, RenderMagmos::new);
		MobRenders.renderMob(EntityGrayAlien.class, RenderGrayAlien::new);
		MobRenders.renderMob(EntityMegaCreeper.class, RenderMegaCreeper::new);
		MobRenders.renderMob(EntityGalaxyKnight.class, RenderGalaxyKnight::new);
		MobRenders.renderMob(EntityMummy.class, RenderMummy::new);
		MobRenders.renderMob(EntityScorpion.class, RenderScorpion::new);
		MobRenders.renderMob(EntityKrull.class, RenderKrull::new);
		MobRenders.renderMob(EntitySpiderling.class, RenderSpiderling::new);
		MobRenders.renderMob(EntityShadowSkeleton.class, RenderShadowSkeleton::new);
		MobRenders.renderMob(EntityHelleton.class, RenderHelleton::new);
		MobRenders.renderMob(EntityShade.class, RenderShade::new);
		MobRenders.renderMob(EntityFaceless.class, RenderFaceless::new);
		MobRenders.renderMob(EntityVexBot.class, RenderVexbot::new);
		MobRenders.renderMob(EntityVexBotGold.class, RenderVexbotGold::new);
		MobRenders.renderMob(EntityVolatile.class, RenderVolatile::new);
		MobRenders.renderMob(EntitySeeker.class, RenderSeeker::new);
		MobRenders.renderMob(EntityOverlord.class, RenderOverlord::new);
		MobRenders.renderMob(EntityGhoul.class, RenderGhoul::new);
		MobRenders.renderMob(EntityFacehugger.class, RenderFacehugger::new);
		MobRenders.renderMob(EntityXenomorph.class, RenderXenomorph::new);
		MobRenders.renderMob(EntityBloodWorm.class, RenderBloodWorm::new);
	}
	
	private static void renderBosses() {
		MobRenders.renderMob(EntityShadowAlien.class, RenderShadowAlien::new);
		MobRenders.renderMob(EntityXenomorphQueen.class, RenderXenomorphQueen::new);
		MobRenders.renderMob(EntityVexBotBoss.class, RenderVexbotBoss::new);
	}
	
	/**
	 * Render a Mob to the registry.
	 * 
	 * @param entityClass
	 *            The .class file of the entity (mob).
	 * @param renderFactory
	 *            The IRenderFactory.
	 */
	private static <T extends Entity> void renderMob(Class<T> entityClass, IRenderFactory<? super T> renderFactory) {
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}
}