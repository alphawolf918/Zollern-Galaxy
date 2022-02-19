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
	
	// Xenomorph Mob
	public static final SoundEvent ENTITY_XENO_SAY = regSound("mob.xenomorph.say");
	public static final SoundEvent ENTITY_XENO_HURT = regSound("mob.xenomorph.hurt");
	public static final SoundEvent ENTITY_XENO_DEATH = regSound("mob.xenomorph.die");
	
	// Xenomorph Queen Mob
	public static final SoundEvent ENTITY_XENO_QUEEN_SAY = regSound("mob.xenomorph.queen.say");
	public static final SoundEvent ENTITY_XENO_QUEEN_HURT = regSound("mob.xenomorph.queen.hurt");
	public static final SoundEvent ENTITY_XENO_QUEEN_DEATH = regSound("mob.xenomorph.queen.die");
	
	// Vexbot Mob
	public static final SoundEvent ENTITY_VEXBOT_SAY = regSound("mob.vexbot.say");
	public static final SoundEvent ENTITY_VEXBOT_HURT = regSound("mob.vexbot.hurt");
	public static final SoundEvent ENTITY_VEXBOT_DIE = regSound("mob.vexbot.die");
	
	// Sentinel Drone Mob
	public static final SoundEvent ENTITY_SENTINEL_DRONE_SAY = regSound("mob.sentinel.drone.say");
	public static final SoundEvent ENTITY_SENTINEL_DRONE_HURT = regSound("mob.sentinel.drone.hurt");
	public static final SoundEvent ENTITY_SENTINEL_DRONE_DIE = regSound("mob.sentinel.drone.die");
	
	// Sentinel Hound Mob
	public static final SoundEvent ENTITY_SENTINEL_HOUND_SAY = regSound("mob.sentinel.hound.say");
	public static final SoundEvent ENTITY_SENTINEL_HOUND_HURT = regSound("mob.sentinel.hound.hurt");
	public static final SoundEvent ENTITY_SENTINEL_HOUND_DIE = regSound("mob.sentinel.hound.die");
	
	// Sentinel Firing Sound
	public static final SoundEvent ENTITY_SENTINEL_SHOOT = regSound("mob.sentinel.shoot");
	
	// Bloodworm Mob
	public static final SoundEvent ENTITY_BLOODWORM_SAY = regSound("mob.bloodworm.say");
	public static final SoundEvent ENTITY_BLOODWORM_STEP = regSound("mob.bloodworm.step");
	public static final SoundEvent ENTITY_BLOODWORM_HURT = regSound("mob.bloodworm.hurt");
	public static final SoundEvent ENTITY_BLOODWORM_DEATH = regSound("mob.bloodworm.death");
	
	// Xeno Material
	public static final SoundEvent MATERIAL_XENO_DIG = regSound("dig.xeno");
	public static final SoundEvent MATERIAL_XENO_STEP = regSound("step.xeno");
	
	// Spiderling Heartbeat
	public static final SoundEvent SPIDERLING_EGG_HEARTBEAT = regSound("mob.spiderling.heartbeat");
	
	// Wind
	public static final SoundEvent WEATHER_WIND = regSound("weather.wind");
	
	// Alarms
	public static final SoundEvent ALARM_IRON = regSound("alarms.ironsiren");
	public static final SoundEvent ALARM_GOLD = regSound("alarms.goldsiren");
	public static final SoundEvent ALARM_DIAMOND = regSound("alarms.diamondsiren");
	public static final SoundEvent ALARM_EMERALD = regSound("alarms.emeraldsiren");
	
	public static void init() {
		registerSounds(ENTITY_ALIEN_AMBIENT, ENTITY_ALIEN_HURT, ENTITY_MUMMY_AMBIENT, ENTITY_MUMMY_HURT, ENTITY_MUMMY_DEATH, ENTITY_GALAXY_KNIGHT_SAY, ENTITY_GALAXY_KNIGHT_DEATH, ENTITY_CRAWLER_SAY, ENTITY_CRAWLER_HURT, ENTITY_WASP_SAY, ENTITY_WASP_HURT, ENTITY_WASP_DEATH, ENTITY_KRULL_AMBIENT, ENTITY_KRULL_HURT, ENTITY_KRULL_DEATH, ENTITY_SHADE_SAY, ENTITY_SHADE_HURT,
				ENTITY_SHADE_DEATH, ENTITY_SHADOW_ALIEN_SAY, ENTITY_SHADOW_ALIEN_HURT, ENTITY_SHADOW_ALIEN_DEATH, ENTITY_FACELESS_AMBIENT, ENTITY_FACELESS_HURT, ENTITY_FACELESS_DEATH, ENTITY_VOLATILE_SAY, ENTITY_VOLATILE_HURT, ENTITY_VOLATILE_DEATH, ENTITY_VOLATILE_MUTATE, ENTITY_XENO_SAY, ENTITY_XENO_HURT, ENTITY_XENO_DEATH, ENTITY_XENO_QUEEN_SAY, ENTITY_XENO_QUEEN_HURT,
				ENTITY_XENO_QUEEN_DEATH, ENTITY_VEXBOT_SAY, ENTITY_VEXBOT_HURT, ENTITY_VEXBOT_DIE, ENTITY_BLOODWORM_SAY, ENTITY_BLOODWORM_STEP, ENTITY_BLOODWORM_HURT, ENTITY_BLOODWORM_DEATH, MATERIAL_XENO_DIG, MATERIAL_XENO_STEP, SPIDERLING_EGG_HEARTBEAT, WEATHER_WIND, ALARM_IRON, ALARM_GOLD, ALARM_DIAMOND, ALARM_EMERALD);
		registerSounds(ENTITY_SENTINEL_DRONE_SAY, ENTITY_SENTINEL_DRONE_HURT, ENTITY_SENTINEL_DRONE_DIE, ENTITY_SENTINEL_SHOOT, ENTITY_SENTINEL_HOUND_SAY, ENTITY_SENTINEL_HOUND_HURT, ENTITY_SENTINEL_HOUND_DIE);
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