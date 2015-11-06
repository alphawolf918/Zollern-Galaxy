package galaxymod.mobs;

import galaxymod.biomes.BiomeList;
import galaxymod.lib.ModInfo;
import galaxymod.mobs.entities.EntityMoolus;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import cpw.mods.fml.common.registry.EntityRegistry;

public class Mobs {

	public static int startEntityId = 300;

	public static void init() {

		// Moolus
		registerEntity(EntityMoolus.class, "moolus", 0x008b00, 0xeeeeee);
		EntityRegistry.addSpawn(EntityMoolus.class, 15, 2, 4,
				EnumCreatureType.creature, BiomeList.biomeEden,
				BiomeList.biomeEdenTerranValley);
	}

	public static void registerEntity(Class<? extends EntityLiving> entity,
			String entityName, int entityPrimaryColor, int entitySecondaryColor) {
		int uniqueEntityId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entity, ModInfo.MODID + "_"
				+ entityName, uniqueEntityId);
		registerEntityEgg(entity, entityPrimaryColor, entitySecondaryColor);
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