/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.events;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollerngalaxy.lib.ZGInfo;

public class ZGSoundEvents {
	
	// Gray Alien Mob
	public static final SoundEvent ENTITY_ALIEN_AMBIENT = regSound("mob.alien.say");
	public static final SoundEvent ENTITY_ALIEN_HURT = regSound("mob.alien.hurt");
	
	// Mummy Mob
	public static final SoundEvent ENTITY_MUMMY_AMBIENT = regSound("mob.mummy.say");
	public static final SoundEvent ENTITY_MUMMY_HURT = regSound("mob.mummy.hurt");
	public static final SoundEvent ENTITY_MUMMY_DEATH = regSound("mob.mummy.die");
	
	// Galaxy Knight Mob
	public static final SoundEvent ENTITY_GALAXY_KNIGHT_SAY = regSound("mob.galaxyknight.say");
	public static final SoundEvent ENTITY_GALAXY_KNIGHT_DEATH = regSound("mob.galaxyknight.die");
	
	// Crawler Mob
	public static final SoundEvent ENTITY_CRAWLER_SAY = regSound("mob.crawler.say");
	public static final SoundEvent ENTITY_CRAWLER_HURT = regSound("mob.crawler.hurt");
	
	// Wasp Mob
	public static final SoundEvent ENTITY_WASP_SAY = regSound("mob.wasp.say");
	public static final SoundEvent ENTITY_WASP_HURT = regSound("mob.wasp.hurt");
	public static final SoundEvent ENTITY_WASP_DEATH = regSound("mob.wasp.die");
	
	// Krull Mob
	public static final SoundEvent ENTITY_KRULL_AMBIENT = regSound("mob.krull.say");
	public static final SoundEvent ENTITY_KRULL_HURT = regSound("mob.krull.hurt");
	public static final SoundEvent ENTITY_KRULL_DEATH = regSound("mob.krull.die");
	
	// Shade Mob
	public static final SoundEvent ENTITY_SHADE_SAY = regSound("mob.shade.say");
	public static final SoundEvent ENTITY_SHADE_HURT = regSound("mob.shade.hurt");
	public static final SoundEvent ENTITY_SHADE_DEATH = regSound("mob.shade.die");
	
	// Shadow Alien Mob
	public static final SoundEvent ENTITY_SHADOW_ALIEN_SAY = regSound("mob.shadowalien.say");
	public static final SoundEvent ENTITY_SHADOW_ALIEN_HURT = regSound("mob.shadowalien.hurt");
	public static final SoundEvent ENTITY_SHADOW_ALIEN_DEATH = regSound("mob.shadowalien.death");
	
	// Faceless Mob
	public static final SoundEvent ENTITY_FACELESS_AMBIENT = regSound("mob.faceless.say");
	public static final SoundEvent ENTITY_FACELESS_HURT = regSound("mob.faceless.hurt");
	public static final SoundEvent ENTITY_FACELESS_DEATH = regSound("mob.faceless.die");
	
	// Volatile Mob
	public static final SoundEvent ENTITY_VOLATILE_SAY = regSound("mob.volatile.say");
	public static final SoundEvent ENTITY_VOLATILE_HURT = regSound("mob.volatile.hurt");
	public static final SoundEvent ENTITY_VOLATILE_DEATH = regSound("mob.volatile.die");
	public static final SoundEvent ENTITY_VOLATILE_MUTATE = regSound("mob.volatile.mutate");
	
	// Xeno Material
	public static final SoundEvent MATERIAL_XENO_DIG = regSound("dig.xeno");
	public static final SoundEvent MATERIAL_XENO_STEP = regSound("step.xeno");
	
	// Spiderling Heartbeat
	public static final SoundEvent SPIDERLING_EGG_HEARTBEAT = regSound("mob.spiderling.heartbeat");
	
	// Wind
	public static final SoundEvent WEATHER_WIND = regSound("weather.wind");
	
	public static void init() {
		registerSounds(ENTITY_ALIEN_AMBIENT, ENTITY_ALIEN_HURT, ENTITY_MUMMY_AMBIENT, ENTITY_MUMMY_HURT, ENTITY_MUMMY_DEATH, ENTITY_GALAXY_KNIGHT_SAY,
				ENTITY_GALAXY_KNIGHT_DEATH, ENTITY_CRAWLER_SAY, ENTITY_CRAWLER_HURT, ENTITY_WASP_SAY, ENTITY_WASP_HURT, ENTITY_WASP_DEATH, ENTITY_KRULL_AMBIENT,
				ENTITY_KRULL_HURT, ENTITY_KRULL_DEATH, ENTITY_SHADE_SAY, ENTITY_SHADE_HURT, ENTITY_SHADE_DEATH, ENTITY_SHADOW_ALIEN_SAY, ENTITY_SHADOW_ALIEN_HURT,
				ENTITY_SHADOW_ALIEN_DEATH, ENTITY_FACELESS_AMBIENT, ENTITY_FACELESS_HURT, ENTITY_FACELESS_DEATH, ENTITY_VOLATILE_SAY, ENTITY_VOLATILE_HURT,
				ENTITY_VOLATILE_DEATH, ENTITY_VOLATILE_MUTATE, MATERIAL_XENO_DIG, MATERIAL_XENO_STEP, SPIDERLING_EGG_HEARTBEAT, WEATHER_WIND);
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