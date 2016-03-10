/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.mobs;

import galaxymod.biomes.BiomeList;
import galaxymod.biomes.eden.BiomeGenEdenBase;
import galaxymod.mobs.entities.EntityGalaxyKnight;
import galaxymod.mobs.entities.EntityGrayAlien;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.mobs.entities.eden.EntityAlienSquid;
import galaxymod.mobs.entities.eden.EntityMoolus;
import galaxymod.mobs.entities.eden.EntityOinkus;
import galaxymod.mobs.entities.kriffon.EntityMagmos;
import galaxymod.mobs.entities.xathius.slimes.EntitySlimeRaspberry;
import galaxymod.mobs.entities.zollus.EntityFrostGiant;
import galaxymod.utils.ModInfo;
import galaxymod.utils.NovaHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Mobs {
	
	public static int startEntityId = 300;
	static int totalMobs = 0;
	
	public static void init() {
		
		// Gray Alien
		registerEntity(EntityGrayAlien.class, "grayalien", 0xeeeeee, 0x000000);
		
		// Moolus
		registerEntity(EntityMoolus.class, "moolus", 0x008b00, 0xeeeeee);
		EntityRegistry.addSpawn(EntityMoolus.class, 1, 0, 1,
				EnumCreatureType.creature, BiomeList.biomeEden,
				BiomeList.biomeEdenTerranValley, BiomeList.biomeEdenGarden,
				BiomeList.biomeEdenForest, BiomeList.biomeEdenSnowyPlains,
				BiomeList.biomeEdenSwamp);
		
		// Oinkus
		registerEntity(EntityOinkus.class, "oinkus", 0x009f00, 0xeeffee);
		EntityRegistry.addSpawn(EntityOinkus.class, 1, 0, 1,
				EnumCreatureType.creature, BiomeList.biomeEden,
				BiomeList.biomeEdenTerranValley, BiomeList.biomeEdenGarden,
				BiomeList.biomeEdenForest, BiomeList.biomeEdenSnowyPlains,
				BiomeList.biomeEdenSwamp);
		
		// Alien Squid
		registerEntity(EntityAlienSquid.class, "aliensquid", 0x0099ff, 0xeeeeee);
		for (BiomeGenEdenBase biome : BiomeGenEdenBase.getEdenBiomes()) {
			EntityRegistry.addSpawn(EntityAlienSquid.class, 1, 0, 1,
					EnumCreatureType.waterCreature, biome);
		}
		
		// Galaxy Knight
		registerEntity(EntityGalaxyKnight.class, "galaxyknight", 0x444444,
				0x8b008b);
		
		// Crawler
		registerEntity(EntityCrawlerBoss.class, "crawler", 0xdddddd, 0x444444);
		
		// Frost Giant
		registerEntity(EntityFrostGiant.class, "frostgiant", 0x0099ff, 0x3399ff);
		
		// Magmos
		registerEntity(EntityMagmos.class, "magmos", 0x8b0000, 0xff0000);
		
		// Galaxy Slimes
		
		// (Raspberry)
		registerEntity(EntitySlimeRaspberry.class, "slime.raspberry", 0x000000,
				0x0099ff);
		EntityRegistry
				.addSpawn(EntitySlimeRaspberry.class, 2, 1, 2,
						EnumCreatureType.creature,
						BiomeList.biomeXathiusAbstractPlains);
		
		NovaHelper.echo("Loaded a total of " + totalMobs + " new mobs.");
	}
	
	public static void registerEntity(Class<? extends EntityLiving> entity,
			String entityName, int entityPrimaryColor, int entitySecondaryColor) {
		int uniqueEntityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entity, ModInfo.MODID + "_"
				+ entityName, uniqueEntityId);
		registerEntityEgg(entity, entityPrimaryColor, entitySecondaryColor);
		totalMobs++;
	}
	
	public static void registerEntityEgg(Class<? extends EntityLiving> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}
	
	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId;
	}
	
}