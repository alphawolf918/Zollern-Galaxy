/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Galacticraft
 * Add-On Mod
 ******************************************************************************/

package galaxymod.core;

import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.dimensions.providers.kriffus.WorldProviderKriffus;
import galaxymod.dimensions.providers.zollus.WorldProviderZollus;
import galaxymod.events.NovaEventHandler;
import galaxymod.lib.ModInfo;
import galaxymod.lib.NovaHelper;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;

public class NGPlanets {
	
	static int totalSystems = 0;
	static int totalPlanets = 0;
	static int totalMoons = 0;
	
	public static SolarSystem systemPsios = new SolarSystem("psion6",
			"milkyWay");
	public static SolarSystem systemPraedyth = new SolarSystem("praedyth",
			"milkyWay");
	public static SolarSystem systemPantheon = new SolarSystem("pantheon",
			"milkyWay");
	public static SolarSystem systemOlympus = new SolarSystem("olympus",
			"milkyWay");
	public static SolarSystem systemAsgard = new SolarSystem("asgard",
			"milkyWay");
	public static SolarSystem systemVega = new SolarSystem("vega", "milkyWay");
	public static SolarSystem systemNova = new SolarSystem("nova", "milkyWay");
	
	public static Star starPsios = new Star("psion6");
	public static Star starPraedyth = new Star("praedyth");
	public static Star starPantheon = new Star("pantheon");
	public static Star starOlympus = new Star("olympus");
	public static Star starAsgard = new Star("asgard");
	public static Star starVega = new Star("vega");
	public static Star starNova = new Star("nova");
	
	// Psios System
	public static PlanetNova planetZollus = new PlanetNova("zollus");
	public static PlanetNova planetEden = new PlanetNova("eden");
	public static PlanetNova planetKriffon = new PlanetNova("kriffus");
	public static PlanetNova planetPurgot;
	
	// Praedyth System
	public static PlanetNova planetXathius;
	public static PlanetNova planetXantheon;
	public static PlanetNova planetAtheon;
	
	// Pantheon / Hykaria System
	public static PlanetNova planetMeztli;
	public static PlanetNova planetCentotl;
	public static PlanetNova planetToci;
	public static PlanetNova planetTlaloc;
	
	// Olympus System
	public static PlanetNova planetAres;
	public static PlanetNova planetPrometheus;
	public static PlanetNova planetIcarus;
	public static PlanetNova planetKronos;
	
	// Asgard system
	public static PlanetNova planetAsgard;
	
	// Vega System
	public static PlanetNova planetMeridian;
	
	public static void init() {
		NovaEventHandler.init();
		initStarSystems();
		initPlanets();
		initMoons();
		registerSystems();
		registerTeleportTypes();
	}
	
	public static void initStarSystems() {
		// Psios System
		systemPsios.setMapPosition(new Vector3(0.9F, 1.2F, 0.2F));
		starPsios.setParentSolarSystem(systemPsios);
		starPsios.setTierRequired(-1);
		starPsios.setRelativeSize(60.0F);
		starPsios.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/psion6.png"));
		systemPsios.setMainStar(starPsios);
		totalSystems++;
		
		// Praedyth System
		systemPraedyth.setMapPosition(new Vector3(1.1F, 0.4F, 0.9F));
		starPraedyth.setParentSolarSystem(systemPraedyth);
		starPraedyth.setTierRequired(-1);
		starPraedyth.setRelativeSize(40.0F);
		starPraedyth.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/praedyth.png"));
		systemPraedyth.setMainStar(starPraedyth);
		totalSystems++;
		
		// Pantheon System
		systemPantheon.setMapPosition(new Vector3(2.0F, 1.2F, 0.2F));
		starPantheon.setParentSolarSystem(systemPantheon);
		starPantheon.setTierRequired(-1);
		starPantheon.setRelativeSize(20.0F);
		starPantheon.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/pantheon.png"));
		systemPantheon.setMainStar(starPantheon);
		totalSystems++;
		
		// Olympus System
		systemOlympus.setMapPosition(new Vector3(2.5F, 0.5F, 1.4F));
		starOlympus.setParentSolarSystem(systemOlympus);
		starOlympus.setTierRequired(-1);
		starOlympus.setRelativeSize(45.0F);
		starOlympus.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/olympus.png"));
		systemOlympus.setMainStar(starOlympus);
		totalSystems++;
		
		// Asgard System
		systemAsgard.setMapPosition(new Vector3(3.0F, 1.2F, 0.3F));
		starAsgard.setParentSolarSystem(systemAsgard);
		starAsgard.setTierRequired(-1);
		starAsgard.setRelativeSize(16.0F);
		starAsgard.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/asgard.png"));
		systemAsgard.setMainStar(starAsgard);
		totalSystems++;
		
		// Vega System
		systemVega.setMapPosition(new Vector3(1.0F, 2.5F, 0.9F));
		starVega.setParentSolarSystem(systemVega);
		starVega.setTierRequired(-1);
		starVega.setRelativeSize(5.0F);
		starVega.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/vega.png"));
		systemVega.setMainStar(starVega);
		totalSystems++;
		
		// Nova System
		systemNova.setMapPosition(new Vector3(-3.0F, 4.0F, -2.0F));
		starNova.setParentSolarSystem(systemNova);
		starNova.setTierRequired(-1);
		starNova.setRelativeSize(5.0F);
		starNova.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/nova.png"));
		systemNova.setMainStar(starNova);
		totalSystems++;
		
		NovaHelper.echo("Loaded a total of " + totalSystems + " star systems.");
	}
	
	public static void initPlanets() {
		// Planet Zollus
		planetZollus.setParentSolarSystem(systemPsios);
		planetZollus.setPlanetClass(EnumPlanetClass.L);
		planetZollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetZollus.setPhaseShift(0.0F);
		planetZollus.setRelativeOrbitTime(16F);
		planetZollus.setRelativeDistanceFromCenter(new ScalableDistance(4.0F,
				4.0F));
		planetZollus.atmosphereComponent(IAtmosphericGas.HYDROGEN)
				.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.HELIUM);
		planetZollus.setTierRequired(4);
		planetZollus.setRelativeSize(14.876F);
		planetZollus.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/zollus.png"));
		planetZollus.setDimensionInfo(-31, WorldProviderZollus.class);
		totalPlanets++;
		
		// Planet Eden
		planetEden.setParentSolarSystem(systemPsios);
		planetEden.setPlanetClass(EnumPlanetClass.M);
		planetEden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetEden.setPhaseShift(0.0F);
		planetEden.setRelativeOrbitTime(8.0F);
		planetEden.setRelativeDistanceFromCenter(new ScalableDistance(2.4F,
				2.4F));
		planetEden.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON)
				.atmosphereComponent(IAtmosphericGas.WATER);
		planetEden.setTierRequired(3);
		planetEden.setRelativeSize(40.0F);
		planetEden.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/eden.png"));
		planetEden.setDimensionInfo(-32, WorldProviderEden.class);
		totalPlanets++;
		
		// Planet Kriffus
		planetKriffon.setParentSolarSystem(systemPsios);
		planetKriffon.setPlanetClass(EnumPlanetClass.Y);
		planetKriffon.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetKriffon.setPhaseShift(0.0F);
		planetKriffon.setRelativeOrbitTime(2.0F);
		planetKriffon.setRelativeDistanceFromCenter(new ScalableDistance(0.4F,
				0.4F));
		planetKriffon.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON);
		planetKriffon.setTierRequired(3);
		planetKriffon.setRelativeSize(20.0F);
		planetKriffon.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/kriffus.png"));
		planetKriffon.setDimensionInfo(-33, WorldProviderKriffus.class);
		totalPlanets++;
		
		NovaHelper.echo("Loaded a total of " + totalPlanets + " planets.");
	}
	
	public static void initMoons() {
		// TODO
		NovaHelper.echo("Loaded a total of " + totalMoons + " moons.");
	}
	
	public static void registerSystems() {
		GalaxyRegistry.registerSolarSystem(systemPsios);
		GalaxyRegistry.registerSolarSystem(systemPraedyth);
		GalaxyRegistry.registerSolarSystem(systemPantheon);
		GalaxyRegistry.registerSolarSystem(systemOlympus);
		GalaxyRegistry.registerSolarSystem(systemAsgard);
		GalaxyRegistry.registerSolarSystem(systemVega);
		GalaxyRegistry.registerSolarSystem(systemNova);
		GalaxyRegistry.registerPlanet(planetZollus);
		GalaxyRegistry.registerPlanet(planetEden);
		GalaxyRegistry.registerPlanet(planetKriffon);
	}
	
	public static void registerTeleportTypes() {
		TeleportTypeNG teleType = new TeleportTypeNG();
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffus.class,
				teleType);
	}
}