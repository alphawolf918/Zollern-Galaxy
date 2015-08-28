/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Galacticraft Add-On Mod
 ******************************************************************************/

package galaxymod.core;

import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.dimensions.providers.zollus.WorldProviderZollus;
import galaxymod.lib.ModInfo;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;

public class NGCore {

	public static SolarSystem systemPsion6;

	public static Star starPsion6;

	public static Planet zollus;
	public static Planet eden;

	public static void init() {
		initStarSystems();
		initPlanets();
		initMoons();
		registerSystems();
		registerTeleportTypes();
	}

	public static void initStarSystems() {
		systemPsion6 = new SolarSystem("psion6", "milkyWay")
				.setMapPosition(new Vector3(0.9F, 1.2F, 0.2F));
		starPsion6 = new Star("psion6").setParentSolarSystem(systemPsion6);
		starPsion6.setTierRequired(-1);
		starPsion6.setRelativeSize(40.0F);
		starPsion6.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/psion6.png"));
		systemPsion6.setMainStar(starPsion6);
	}

	public static void initPlanets() {

		// <Planet Zollus
		zollus = new Planet("zollus").setParentSolarSystem(systemPsion6);
		zollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		zollus.setPhaseShift(8.7446F);
		zollus.setRelativeDistanceFromCenter(new ScalableDistance(5.0F, 5.0F));
		zollus.setRelativeOrbitTime(13F);
		zollus.setTierRequired(3);
		zollus.setRelativeSize(6.876F);
		zollus.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/zollus.png"));
		zollus.setDimensionInfo(-31, WorldProviderZollus.class);
		// >

		// <Planet Eden
		eden = new Planet("eden").setParentSolarSystem(systemPsion6);
		eden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		eden.setPhaseShift(0.0F);
		eden.setRelativeOrbitTime(8.0F);
		eden.setRelativeDistanceFromCenter(new ScalableDistance(2.4F, 2.4F));
		eden.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON)
				.atmosphereComponent(IAtmosphericGas.WATER);
		eden.setTierRequired(3);
		eden.setRelativeSize(20.0F);
		eden.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/eden.png"));
		eden.setDimensionInfo(-32, WorldProviderEden.class);
		// >
	}

	public static void initMoons() {
		
	}

	public static void registerSystems() {
		GalaxyRegistry.registerSolarSystem(systemPsion6);
		GalaxyRegistry.registerPlanet(zollus);
		GalaxyRegistry.registerPlanet(eden);
	}

	public static void registerTeleportTypes() {
		TeleportTypeNG teleType = new TeleportTypeNG();
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class,
				teleType);
	}
}