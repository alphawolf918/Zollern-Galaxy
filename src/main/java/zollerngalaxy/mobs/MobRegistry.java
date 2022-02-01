/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs;

import com.google.common.base.CaseFormat;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving.SpawnPlacementType;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
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

public class MobRegistry {
	
	private static int entityId = -1;
	private static int totalMobs = 0;
	
	private static CaseFormat caseFormLower = CaseFormat.LOWER_CAMEL;
	private static CaseFormat caseFormUnder = CaseFormat.LOWER_UNDERSCORE;
	
	private static ZollernGalaxyCore coreInstance = ZollernGalaxyCore.instance();
	
	public static void init() {
		// Moolus
		registerEntity("moolus", EntityEdenCow.class, entityId++, 0x008b00, 0xeeeeee);
		
		// Oinkus
		registerEntity("oinkus", EntityOinkus.class, entityId++, 0x009f00, 0xeeffee);
		
		// Squidlus
		registerEntity("squidlus", EntitySquidlus.class, entityId++, 0x0099ff, 0xeeeeee);
		EntitySpawnPlacementRegistry.setPlacementType(EntitySquidlus.class, SpawnPlacementType.IN_WATER);
		
		// Frost Giant
		registerEntity("frostgiant", EntityFrostGiant.class, entityId++, 0x0099ff, 0x3399ff);
		
		// Magmos
		registerEntity("magmos", EntityMagmos.class, entityId++, 0x8b0000, 0xff0000);
		
		// Gray Alien
		registerEntity("grayalien", EntityGrayAlien.class, entityId++, 0xeeeeee, 0x000000);
		
		// Galaxy Knight
		registerEntity("galaxyknight", EntityGalaxyKnight.class, entityId++, 0x444444, 0x8b008b);
		
		// Mega Creeper
		registerEntity("megacreeper", EntityMegaCreeper.class, entityId++, 0xee00ee, 0x00ee00);
		
		// Mummy
		registerEntity("mummy", EntityMummy.class, entityId++, 0x8b990, 0xf5eeb3);
		
		// Scorpion
		registerEntity("scorpion", EntityScorpion.class, entityId++, 0xf5eeb3, 0x8b9900);
		
		// Spiderling
		registerEntity("spiderling", EntitySpiderling.class, entityId++, 0x000000, 0xff8b00);
		
		// Krull
		registerEntity("krull", EntityKrull.class, entityId++, 0xf5eeb3, 0x444444);
		
		// Shadow Skeleton
		registerEntity("shadowskeleton", EntityShadowSkeleton.class, entityId++, 0xeeeeee, 0x00009e);
		
		// Helleton
		registerEntity("helleton", EntityHelleton.class, entityId++, 0x8b0000, 0xaa0000);
		
		// Shade
		registerEntity("shade", EntityShade.class, entityId++, 0x000000, 0xffffff);
		
		// Faceless
		registerEntity("faceless", EntityFaceless.class, entityId++, 0x800080, 0xffa500);
		
		// ***** BEGIN BOSSES ***** //
		// Shadow Alien
		registerEntity("shadowalien", EntityShadowAlien.class, entityId++, 0x000000, 0xeeeeee);
		
		// Xenomorph Queen
		registerEntity("xenomorphqueen", EntityXenomorphQueen.class, entityId++, 0xeeeeee, 0x8bc4fc);
		
		// Vexbot Boss
		registerEntity("vexbotboss", EntityVexBotBoss.class, entityId++, 0xeeddea, 0x8b009f);
		// ***** END BOSSES ***** //
		
		// Blubber Fish
		registerEntity("blubberfish", EntityBlubberFish.class, entityId++, 0xffff00, 0x0099ff);
		EntitySpawnPlacementRegistry.setPlacementType(EntityBlubberFish.class, SpawnPlacementType.IN_WATER);
		
		// Gypsy Fish
		registerEntity("gypsyfish", EntityGypsyFish.class, entityId++, 0x8b9900, 0x0099ff);
		EntitySpawnPlacementRegistry.setPlacementType(EntityGypsyFish.class, SpawnPlacementType.IN_WATER);
		
		// Blade Fish
		registerEntity("bladefish", EntityBladeFish.class, entityId++, 0x8b0000, 0x0099ff);
		EntitySpawnPlacementRegistry.setPlacementType(EntityBladeFish.class, SpawnPlacementType.IN_WATER);
		
		// Shark
		registerEntity("shark", EntityShark.class, entityId++, 0x000000, 0x777777);
		EntitySpawnPlacementRegistry.setPlacementType(EntityShark.class, SpawnPlacementType.IN_WATER);
		
		// Jellyfish
		registerEntity("jellyfish", EntityJellyfish.class, entityId++, 0x00008b, 0x008b00);
		EntitySpawnPlacementRegistry.setPlacementType(EntityJellyfish.class, SpawnPlacementType.IN_WATER);
		
		/** BEGIN VILLAGERS **/
		
		// Abyssal Villager
		registerEntity("abyssalvillager", EntityAbyssalVillager.class, entityId++, 0x8b8b00, 0x0099ff);
		EntitySpawnPlacementRegistry.setPlacementType(EntityAbyssalVillager.class, SpawnPlacementType.IN_WATER);
		
		// Harran Villager
		registerEntity("harranvillager", EntityHarranVillager.class, entityId++, 0x8b4d8b, 0xffff4d);
		
		// Eden Villager
		registerEntity("edenvillager", EntityEdenVillager.class, entityId++, 0x0099ff, 0x008b00);
		
		// Astros Villager
		registerEntity("astrosvillager", EntityAstrosVillager.class, entityId++, 0xeeeeee, 0xeeffee);
		
		// Caligro Villager
		registerEntity("caligrovillager", EntityCaligroVillager.class, entityId++, 0x000000, 0xff0000);
		
		// Zollus Villager
		registerEntity("zollusvillager", EntityZollusVillager.class, entityId++, 0x0099ff, 0x0);
		
		// Kriffon Villager
		registerEntity("kriffonvillager", EntityKriffonVillager.class, entityId++, 0xff0000, 0x8b0000);
		
		// Purgot Villager
		registerEntity("purgotvillager", EntityPurgotVillager.class, entityId++, 0x964b00, 0xff4b00);
		
		// Centotl Villager
		registerEntity("centotlvillager", EntityCentotlVillager.class, entityId++, 0x000000, 0xffffff);
		
		// Toci Villager
		registerEntity("tocivillager", EntityTociVillager.class, entityId++, 0x0099ff, 0x8b008b);
		
		// Perdita Villager
		registerEntity("perditavillager", EntityPerditaVillager.class, entityId++, 0x8b008b, 0xe48b3c);
		
		// Tlaloc Villager
		registerEntity("tlalocvillager", EntityTlalocVillager.class, entityId++, 0xeeeeee, 0xbbbbbb);
		
		// Oasis Villager
		registerEntity("oasisvillager", EntityOasisVillager.class, entityId++, 0xff0000, 0xffd700);
		
		// Candora Villager
		registerEntity("candoravillager", EntityCandoraVillager.class, entityId++, 0xa76bc1, 0x00008b);
		
		// Exodus Villager
		registerEntity("exodusvillager", EntityExodusVillager.class, entityId++, 0x008b00, 0x00ffce);
		
		// Kronos Villager
		registerEntity("kronosvillager", EntityKronosVillager.class, entityId++, 0x0099ff, 0x8b00ff);
		
		// Atheon Villager
		registerEntity("atheonvillager", EntityAtheonVillager.class, entityId++, 0x00ffff, 0x008b8b);
		
		/** END VILLAGERS **/
		
		// Wanderer
		registerEntity("wanderer", EntityWanderer.class, entityId++, 0x00dd00, 0x8b21de);
		
		// Wasp
		registerEntity("wasp", EntityWasp.class, entityId++, 0x000000, 0xffff00);
		EntitySpawnPlacementRegistry.setPlacementType(EntityWasp.class, SpawnPlacementType.IN_AIR);
		
		// Pig Shroom
		registerEntity("pigshroom", EntityPigShroom.class, entityId++, 0x990000, 0xeeeeee);
		
		// Arcon
		registerEntity("arcon", EntityArcon.class, entityId++, 0x0000ee, 0x0000cc);
		
		// ** Zombie Mutations **
		
		// Volatile
		registerEntity("volatile", EntityVolatile.class, entityId++, 0xeeeeee, 0xf00000);
		
		// Seeker
		registerEntity("seeker", EntitySeeker.class, entityId++, 0x009900, 0x00008b);
		
		// Overlord
		registerEntity("overlord", EntityOverlord.class, entityId++, 0xeeeeee, 0x008b00);
		
		// Ghoul
		registerEntity("ghoul", EntityGhoul.class, entityId++, 0x444444, 0xeeeeee);
		
		// Light Walker
		// TODO
		
		// Hulk Beast
		// TODO
		
		// ** End Mutations **
		
		// Facehugger
		registerEntity("facehugger", EntityFacehugger.class, entityId++, 0xa76bc1, 0x964b00);
		
		// Xenomorph
		registerEntity("xenomorph", EntityXenomorph.class, entityId++, 0xeeeeee, 0xcccccc);
		
		// Galaxy Dragon
		registerEntity("dragon", EntityGalaxyDragon.class, entityId++, 0x000000, 0x990099);
		
		// Vexbot
		registerEntity("vexbot", EntityVexBot.class, entityId++, 0xeeeeee, 0xbebebe);
		
		// Golden Vexbot
		registerEntity("vexbotgold", EntityVexBotGold.class, entityId++, 0xffff00, 0xbe0000);
		
		// Blood Worm
		registerEntity("bloodworm", EntityBloodWorm.class, entityId++, 0x8b008b, 0x8b008b);
		
		ZGHelper.Log("Loaded a total of " + totalMobs + " new mobs.");
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		String strName = registryName.toString();
		String entityName = caseFormUnder.to(caseFormLower, strName);
		EntityRegistry.registerModEntity(registryName, cls, entityName, id, coreInstance, 64, 1, true);
		totalMobs++;
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id, int primaryEggColor, int secondaryEggColor) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		String strName = registryName.toString();
		int clrPrm = primaryEggColor;
		int clrSec = secondaryEggColor;
		String entityName = caseFormUnder.to(caseFormLower, strName);
		EntityRegistry.registerModEntity(registryName, cls, entityName, id, coreInstance, 64, 1, true, clrPrm, clrSec);
		totalMobs++;
	}
	
}