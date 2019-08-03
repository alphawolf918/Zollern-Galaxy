package zollerngalaxy.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntitySquidlus;
import com.google.common.base.CaseFormat;

public class MobRegistry {
	
	private static int entityId = -1;
	private static int totalMobs = 0;
	
	public static void init() {
		// Moolus
		registerEntity("moolus", EntityMoolus.class, entityId++, 0x008b00, 0xeeeeee);
		
		// Oinkus
		registerEntity("oinkus", EntityOinkus.class, entityId++, 0x009f00, 0xeeffee);
		
		// Squidlus
		registerEntity("squidlus", EntitySquidlus.class, entityId++, 0x0099ff, 0xeeeeee);
		
		// Frost Giant
		registerEntity("frostgiant", EntityFrostGiant.class, entityId++, 0x0099ff, 0x3399ff);
		
		// Magmos
		registerEntity("magmos", EntityMagmos.class, entityId++, 0x8b0000, 0xff0000);
		
		ZGHelper.Log("Loaded a total of " + totalMobs + " new mobs.");
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, registryName.toString()),
				id, ZollernGalaxyCore.instance(), 64, 1, true);
		totalMobs++;
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id,
			int primaryEggColor, int secondaryEggColor) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, registryName.toString()),
				id, ZollernGalaxyCore.instance(), 64, 1, true, primaryEggColor, secondaryEggColor);
		totalMobs++;
	}
	
}