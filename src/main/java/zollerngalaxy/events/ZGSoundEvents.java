package zollerngalaxy.events;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollerngalaxy.lib.ZGInfo;

public class ZGSoundEvents {
	
	// Gray Alien
	public static final SoundEvent ENTITY_ALIEN_AMBIENT = regSound("mob.alien.say");
	public static final SoundEvent ENTITY_ALIEN_HURT = regSound("mob.alien.hurt");
	
	// Galaxy Knight
	public static final SoundEvent ENTITY_GALAXY_KNIGHT_SAY = regSound("mob.galaxyknight.say");
	public static final SoundEvent ENTITY_GALAXY_KNIGHT_DEATH = regSound("mob.galaxyknight.die");
	
	// Crawler
	public static final SoundEvent ENTITY_CRAWLER_SAY = regSound("mob.crawler.say");
	public static final SoundEvent ENTITY_CRAWLER_HURT = regSound("mob.crawler.hurt");
	
	// Xeno Material
	public static final SoundEvent MATERIAL_XENO_DIG = regSound("dig.xeno");
	public static final SoundEvent MATERIAL_XENO_STEP = regSound("step.xeno");
	
	public static void init() {
		registerSounds(ENTITY_ALIEN_AMBIENT, ENTITY_ALIEN_HURT, ENTITY_GALAXY_KNIGHT_SAY,
				ENTITY_GALAXY_KNIGHT_DEATH, ENTITY_CRAWLER_SAY, ENTITY_CRAWLER_HURT,
				MATERIAL_XENO_DIG, MATERIAL_XENO_STEP);
	}
	
	private static void registerSound(SoundEvent sound) {
		ForgeRegistries.SOUND_EVENTS.register(sound);
	}
	
	private static SoundEvent regSound(String strSound) {
		SoundEvent s = new SoundEvent(new ResourceLocation(ZGInfo.MOD_ID + ":" + strSound));
		s.setRegistryName(strSound);
		return s;
	}
	
	private static void registerSounds(SoundEvent... sounds) {
		for (SoundEvent s : sounds) {
			registerSound(s);
		}
	}
	
}