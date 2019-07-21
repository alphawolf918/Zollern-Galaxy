package zollerngalaxy.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;
import com.google.common.base.CaseFormat;

public class MobRegistry {
	
	private static int entityId = -1;
	
	public static void init() {
		// Moolus
		registerEntity("moolus", EntityMoolus.class, entityId++, 0x008b00, 0xeeeeee);
		
		// Oinkus
		registerEntity("oinkus", EntityOinkus.class, entityId++, 0x009f00, 0xeeffee);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, registryName.toString()),
				id, ZollernGalaxyCore.instance(), 64, 1, true);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> cls, int id,
			int primaryEggColor, int secondaryEggColor) {
		ResourceLocation registryName = new ResourceLocation(ZGInfo.MOD_ID + ":" + name);
		EntityRegistry.registerModEntity(registryName, cls,
				CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, registryName.toString()),
				id, ZollernGalaxyCore.instance(), 64, 1, true, primaryEggColor, secondaryEggColor);
	}
	
}