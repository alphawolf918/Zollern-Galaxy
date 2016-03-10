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

package galaxymod.core;

import galaxymod.core.config.ConfigManagerNova;
import galaxymod.dimensions.providers.eden.WorldProviderEden;
import galaxymod.dimensions.providers.kriffon.WorldProviderKriffon;
import galaxymod.dimensions.providers.purgot.WorldProviderPurgot;
import galaxymod.dimensions.providers.xathius.WorldProviderXathius;
import galaxymod.dimensions.providers.zollus.WorldProviderZollus;
import galaxymod.events.NovaEventHandler;
import galaxymod.utils.ModInfo;
import galaxymod.utils.NovaHelper;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;

public class NGPlanets {
	
	static int totalSystems = 0;
	static int totalPlanets = 0;
	static int totalMoons = 0;
	
	public static SolarSystem systemPsios = new NovaSystem("psion6");
	public static SolarSystem systemPraedyth = new NovaSystem("praedyth");
	public static SolarSystem systemPantheon = new NovaSystem("pantheon");
	public static SolarSystem systemOlympus = new NovaSystem("olympus");
	public static SolarSystem systemAsgard = new NovaSystem("asgard");
	public static SolarSystem systemVega = new NovaSystem("vega");
	public static SolarSystem systemNova = new NovaSystem("nova");
	
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
	public static PlanetNova planetPurgot = new PlanetNova("purgot");
	public static Moon moonAstros;
	
	// Praedyth System
	public static PlanetNova planetXathius = new PlanetNova("xathius");
	public static PlanetNova planetXantheon;
	public static PlanetNova planetAtheon;
	
	// Pantheon System
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
	public static PlanetNova planetRequiem;
	
	// Nova System
	public static PlanetNova planetPrimor;
	
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
		
		NovaHelper.echo("Loaded a total of " + totalSystems
				+ " new star systems.");
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
		planetZollus.setDimensionInfo(
				ConfigManagerNova.planetZollusDimensionId,
				WorldProviderZollus.class);
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
		planetEden.setDimensionInfo(ConfigManagerNova.planetEdenDimensionId,
				WorldProviderEden.class);
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
		planetKriffon.setTierRequired(4);
		planetKriffon.setRelativeSize(20.0F);
		planetKriffon.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/kriffus.png"));
		planetKriffon.setDimensionInfo(
				ConfigManagerNova.planetKriffonDimensionId,
				WorldProviderKriffon.class);
		totalPlanets++;
		
		// Planet Purgot
		planetPurgot.setParentSolarSystem(systemPsios);
		planetPurgot.setPlanetClass(EnumPlanetClass.NINE);
		planetPurgot.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetPurgot.setPhaseShift(0.1F);
		planetPurgot.setRelativeOrbitTime(16F);
		planetPurgot.setRelativeDistanceFromCenter(new ScalableDistance(6.0F,
				6.0F));
		planetPurgot.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.WATER)
				.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON);
		planetPurgot.setTierRequired(5);
		planetPurgot.setRelativeSize(40.0F);
		planetPurgot.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/purgot.png"));
		planetPurgot.setDimensionInfo(
				ConfigManagerNova.planetPurgotDimensionId,
				WorldProviderPurgot.class);
		totalPlanets++;
		
		// Planet Xathius
		planetXathius.setParentSolarSystem(systemPraedyth);
		planetXathius.setPlanetClass(EnumPlanetClass.NINE);
		planetXathius.setRingColorRGB(0.1F, 0.9F, 1.4F);
		planetXathius.setPhaseShift(0.2F);
		planetXathius.setRelativeOrbitTime(16F);
		planetXathius.setRelativeDistanceFromCenter(new ScalableDistance(3.4F,
				3.4F));
		planetXathius.atmosphereComponent(IAtmosphericGas.OXYGEN)
				.atmosphereComponent(IAtmosphericGas.WATER)
				.atmosphereComponent(IAtmosphericGas.NITROGEN)
				.atmosphereComponent(IAtmosphericGas.ARGON);
		planetXathius.setTierRequired(5);
		planetXathius.setRelativeSize(20.0F);
		planetXathius.setBodyIcon(new ResourceLocation(ModInfo.MODID,
				"textures/gui/xathius.png"));
		planetXathius.setDimensionInfo(
				ConfigManagerNova.planetXathiusDimensionId,
				WorldProviderXathius.class);
		totalPlanets++;
		
		NovaHelper.echo("Loaded a total of " + totalPlanets + " new planets.");
	}
	
	public static void initMoons() {
		// TODO
		NovaHelper.echo("Loaded a total of " + totalMoons + " new moons.");
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
		GalaxyRegistry.registerPlanet(planetPurgot);
		GalaxyRegistry.registerPlanet(planetXathius);
	}
	
	public static void registerTeleportTypes() {
		TeleportTypeNG teleType = new TeleportTypeNG();
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffon.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderPurgot.class,
				teleType);
		GalacticraftRegistry.registerTeleportType(WorldProviderXathius.class,
				teleType);
	}
}