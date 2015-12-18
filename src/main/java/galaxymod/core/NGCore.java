/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Galacticraft
 * Add-On Mod
 ******************************************************************************/

package galaxymod.core;

import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.dimensions.providers.kriffus.WorldProviderKriffus;
import galaxymod.dimensions.providers.zollus.WorldProviderZollus;
import galaxymod.events.NGEventHandler;
import galaxymod.lib.ModInfo;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;

public class NGCore {
	
	public static SolarSystem systemPsion6;
	
	public static Star starPsion6;
	
	public static PlanetNova zollus = new PlanetNova("zollus");
	public static PlanetNova eden = new PlanetNova("eden");
	public static PlanetNova kriffus = new PlanetNova("kriffus");// 90 -45 45 (color
																// code for
																// Kriffrock and
																// ores)
	
	// public static Satellite edenSpaceStation;
	
	public static void init() {
		NGEventHandler.init();
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
		starPsion6.setRelativeSize(60.0F);
		starPsion6.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/psion6.png"));
		systemPsion6.setMainStar(starPsion6);
	}
	
	public static void initPlanets() {
		
		// Planet Zollus
		zollus.setParentSolarSystem(systemPsion6);
		zollus.setPlanetClass(EnumPlanetClass.L);
		zollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		zollus.setPhaseShift(8.7446F);
		zollus.setRelativeOrbitTime(24F);
		zollus.setRelativeDistanceFromCenter(new ScalableDistance(5.0F, 5.0F));
		zollus.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON)
				.atmosphereComponent(IAtmosphericGas.CO2);
		zollus.setTierRequired(3);
		zollus.setRelativeSize(14.876F);
		zollus.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/zollus.png"));
		zollus.setDimensionInfo(-31, WorldProviderZollus.class);
		
		// Planet Eden
		eden.setParentSolarSystem(systemPsion6);
		eden.setPlanetClass(EnumPlanetClass.M);
		eden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		eden.setPhaseShift(0.0F);
		eden.setRelativeOrbitTime(8.0F);
		eden.setRelativeDistanceFromCenter(new ScalableDistance(2.4F, 2.4F));
		eden.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON)
				.atmosphereComponent(IAtmosphericGas.WATER);
		eden.setTierRequired(3);
		eden.setRelativeSize(40.0F);
		eden.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/eden.png"));
		eden.setDimensionInfo(-32, WorldProviderEden.class);
		
		// Planet Kriffus
		kriffus.setParentSolarSystem(systemPsion6);
		kriffus.setPlanetClass(EnumPlanetClass.Y);
		kriffus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		kriffus.setPhaseShift(0.0F);
		kriffus.setRelativeOrbitTime(2.0F);
		kriffus.setRelativeDistanceFromCenter(new ScalableDistance(0.4F, 0.4F));
		kriffus.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON);
		kriffus.setTierRequired(3);
		kriffus.setRelativeSize(20.0F);
		kriffus.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/kriffus.png"));
		kriffus.setDimensionInfo(-33, WorldProviderKriffus.class);
		
		// Eden Satellite
		// edenSpaceStation = new Satellite("spaceStation.eden");
		// edenSpaceStation.setParentBody(NGCore.eden);
		// edenSpaceStation.setRelativeSize(0.2667F);
		// edenSpaceStation.setRelativeDistanceFromCenter(
		// new CelestialBody.ScalableDistance(9F, 9F))
		// .setRelativeOrbitTime(1 / 0.05F);
		// edenSpaceStation.setDimensionInfo(-33, WorldProviderEdenOrbit.class);
		// edenSpaceStation.setTierRequired(3);
		// edenSpaceStation.setBodyIcon(new ResourceLocation(
		// GalacticraftCore.ASSET_PREFIX,
		// "textures/gui/celestialbodies/spaceStation.png"));
	}
	
	public static void initMoons() {
		
	}
	
	public static void registerSystems() {
		GalaxyRegistry.registerSolarSystem(systemPsion6);
		GalaxyRegistry.registerPlanet(zollus);
		GalaxyRegistry.registerPlanet(eden);
		// GalaxyRegistry.registerSatellite(edenSpaceStation);
		GalaxyRegistry.registerPlanet(kriffus);
	}
	
	public static void registerTeleportTypes() {
		TeleportTypeNG teleType = new TeleportTypeNG();
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffus.class,
				teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderEdenOrbit.class,
		// teleType);
	}
}