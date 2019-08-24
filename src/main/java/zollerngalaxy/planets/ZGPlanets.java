package zollerngalaxy.planets;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.planets.venus.dimension.TeleportTypeVenus;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderEden;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKriffon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderXathius;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.core.enums.EnumPlanetClass;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.starsystems.ZGStarSystem;

public class ZGPlanets {
	static int totalSystems = 0;
	static int totalPlanets = 0;
	static int totalMoons = 0;
	
	public static SolarSystem systemPsios = new ZGStarSystem("psion6");
	public static SolarSystem systemPraedyth = new ZGStarSystem("praedyth");
	public static SolarSystem systemPantheon = new ZGStarSystem("pantheon");
	public static SolarSystem systemOlympus = new ZGStarSystem("olympus");
	public static SolarSystem systemAsgard = new ZGStarSystem("asgard");
	public static SolarSystem systemVega = new ZGStarSystem("vega");
	public static SolarSystem systemNova = new ZGStarSystem("nova");
	
	public static Star starPsios = new Star("psion6");
	public static Star starPraedyth = new Star("praedyth");
	public static Star starPantheon = new Star("pantheon");
	public static Star starOlympus = new Star("olympus");
	public static Star starAsgard = new Star("asgard");
	public static Star starVega = new Star("vega");
	public static Star starNova = new Star("nova");
	
	// Psios System
	public static ZGPlanet planetEden = new ZGPlanet("eden");
	public static ZGPlanet planetZollus = new ZGPlanet("zollus");
	public static ZGPlanet planetKriffon = new ZGPlanet("kriffus");
	public static ZGPlanet planetPurgot = new ZGPlanet("purgot");
	public static Moon moonAstros;
	
	// Praedyth System
	public static ZGPlanet planetXathius = new ZGPlanet("xathius");
	public static ZGPlanet planetOasis = new ZGPlanet("oasis");
	public static ZGPlanet planetXantheon;
	public static ZGPlanet planetAtheon;
	
	// Pantheon System
	public static ZGPlanet planetMeztli;
	public static ZGPlanet planetCentotl;
	public static ZGPlanet planetToci;
	public static ZGPlanet planetTlaloc;
	
	// Olympus System
	public static ZGPlanet planetAres;
	public static ZGPlanet planetPrometheus;
	public static ZGPlanet planetIcarus;
	public static ZGPlanet planetKronos;
	
	// Asgard system
	public static ZGPlanet planetAsgard;
	public static ZGPlanet planetMaveth;
	
	// Vega System
	public static ZGPlanet planetMeridian;
	public static ZGPlanet planetRequiem;
	
	// Nova System
	public static ZGPlanet planetPrimor;
	
	public static void init() {
		ZGPlanets.initStarSystems();
		ZGPlanets.initPlanets();
		ZGPlanets.initMoons();
		ZGPlanets.registerSystems();
		ZGPlanets.registerTeleportTypes();
	}
	
	public static void initStarSystems() {
		// Psios System
		systemPsios.setMapPosition(new Vector3(-2.5F, 1.1F, 0.9F));
		starPsios.setParentSolarSystem(systemPsios);
		starPsios.setTierRequired(-1);
		starPsios.setRelativeSize(35.0F);
		starPsios.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/psion6.png"));
		systemPsios.setMainStar(starPsios);
		totalSystems++;
		
		// Praedyth System
		systemPraedyth.setMapPosition(new Vector3(-1.1F, 1.3F, -0.2F));
		starPraedyth.setParentSolarSystem(systemPraedyth);
		starPraedyth.setTierRequired(-1);
		starPraedyth.setRelativeSize(40.0F);
		starPraedyth.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/praedyth.png"));
		systemPraedyth.setMainStar(starPraedyth);
		totalSystems++;
		
		// Pantheon System
		systemPantheon.setMapPosition(new Vector3(2.0F, 1.2F, 0.2F));
		starPantheon.setParentSolarSystem(systemPantheon);
		starPantheon.setTierRequired(-1);
		starPantheon.setRelativeSize(20.0F);
		starPantheon.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/pantheon.png"));
		systemPantheon.setMainStar(starPantheon);
		totalSystems++;
		
		// Olympus System
		systemOlympus.setMapPosition(new Vector3(1.5F, 1.5F, 0.1F));
		starOlympus.setParentSolarSystem(systemOlympus);
		starOlympus.setTierRequired(-1);
		starOlympus.setRelativeSize(45.0F);
		starOlympus.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/olympus.png"));
		systemOlympus.setMainStar(starOlympus);
		totalSystems++;
		
		// Asgard System
		systemAsgard.setMapPosition(new Vector3(3.0F, 1.2F, 0.3F));
		starAsgard.setParentSolarSystem(systemAsgard);
		starAsgard.setTierRequired(-1);
		starAsgard.setRelativeSize(16.0F);
		starAsgard.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/asgard.png"));
		systemAsgard.setMainStar(starAsgard);
		totalSystems++;
		
		// Vega System
		systemVega.setMapPosition(new Vector3(-1.0F, 2.5F, -0.6F));
		starVega.setParentSolarSystem(systemVega);
		starVega.setTierRequired(-1);
		starVega.setRelativeSize(5.0F);
		starVega.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/vega.png"));
		systemVega.setMainStar(starVega);
		totalSystems++;
		
		// Nova System
		systemNova.setMapPosition(new Vector3(-2.0F, 1.6F, -2.0F));
		starNova.setParentSolarSystem(systemNova);
		starNova.setTierRequired(-1);
		starNova.setRelativeSize(5.0F);
		starNova.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID, "textures/gui/nova.png"));
		systemNova.setMainStar(starNova);
		totalSystems++;
		
		ZGHelper.Log("Loaded a total of " + totalSystems + " new star systems.");
	}
	
	public static void initPlanets() {
		// Planet Zollus
		planetZollus.setDimensionInfo(ConfigManagerZG.planetZollusDimensionId,
				WorldProviderZollus.class);
		planetZollus.setParentSolarSystem(systemPsios);
		planetZollus.setPlanetClass(EnumPlanetClass.L);
		planetZollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetZollus.setPhaseShift(0.0F);
		planetZollus.setRelativeOrbitTime(42F);
		planetZollus.setDistanceFromCenter(4F);
		planetZollus.setTierRequired(3);
		planetZollus.setRelativeSize(10.876F);
		planetZollus.setPlanetTemperature(-102.6f);
		planetZollus.setPlanetToxicity(0.4f);
		planetZollus.setPlanetRadiation(0.5f);
		planetZollus.setWindLevel(3.6F);
		planetZollus.setDensity(0.1F);
		planetZollus.setHasRain(false);
		planetZollus.setPlanetGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.HELIUM);
		planetZollus.setAtmosphere();
		planetZollus.setPlanetIcon("zollus");
		planetZollus.setBiomeInfo(ZGBiomes.ZOLLUS);
		planetZollus.addChecklistKeys("equipOxygenSuit");
		totalPlanets++;
		
		// Planet Kriffon
		planetKriffon.setDimensionInfo(ConfigManagerZG.planetKriffonDimensionId,
				WorldProviderKriffon.class);
		planetKriffon.setParentSolarSystem(systemPsios);
		planetKriffon.setPlanetClass(EnumPlanetClass.Y);
		planetKriffon.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetKriffon.setPhaseShift(0.0F);
		planetKriffon.setRelativeOrbitTime(0.3F);
		planetKriffon.setDistanceFromCenter(1F);
		planetKriffon.setTierRequired(4);
		planetKriffon.setRelativeSize(20.0F);
		planetKriffon.setPlanetTemperature(227.4F);
		planetKriffon.setPlanetToxicity(14.1F);
		planetKriffon.setPlanetRadiation(16.8F);
		planetKriffon.setWindLevel(0.1F);
		planetKriffon.setDensity(3.0F);
		planetKriffon.setHasRain(false);
		planetKriffon.setPlanetGasses(EnumAtmosphericGas.ARGON, EnumAtmosphericGas.METHANE);
		planetKriffon.setAtmosphere();
		planetKriffon.setPlanetIcon("kriffus");
		planetKriffon.setBiomeInfo(ZGBiomes.KRIFFON);
		planetKriffon.addChecklistKeys("equipOxygenSuit");
		totalPlanets++;
		
		// Planet Purgot
		planetPurgot.setParentSolarSystem(systemPsios);
		planetPurgot.setPlanetClass(EnumPlanetClass.NINE);
		planetPurgot.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetPurgot.setPhaseShift(0.0F);
		planetPurgot.setRelativeOrbitTime(10F);
		planetPurgot.setDistanceFromCenter(3.5F);
		planetPurgot.setTierRequired(5);
		planetPurgot.setRelativeSize(40.0F);
		planetPurgot.setPlanetTemperature(-54.5f);
		planetPurgot.setPlanetToxicity(15.2f);
		planetPurgot.setPlanetRadiation(2.2f);
		planetPurgot.setWindLevel(5.7F);
		planetPurgot.setDensity(0.3F);
		planetPurgot.setHasRain(false);
		planetPurgot.setPlanetGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER,
				EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON);
		planetPurgot.setPlanetIcon("purgot");
		planetPurgot.setAtmosphere();
		planetPurgot.setBiomeInfo(ZGBiomes.PURGOT_BASE, ZGBiomes.PURGOT_LIMBO);
		planetPurgot.addChecklistKeys("equipOxygenSuit");
		planetPurgot.setDimensionInfo(ConfigManagerZG.planetPurgotDimensionId,
				WorldProviderPurgot.class);
		totalPlanets++;
		
		// Planet Eden
		planetEden.setDimensionInfo(ConfigManagerZG.planetEdenDimensionId, WorldProviderEden.class);
		planetEden.setParentSolarSystem(systemPsios);
		planetEden.setPlanetClass(EnumPlanetClass.M);
		planetEden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetEden.setPhaseShift(0.0F);
		planetEden.setRelativeOrbitTime(8.0F);
		planetEden.setDistanceFromCenter(2F);
		planetEden.setTierRequired(5);
		planetEden.setRelativeSize(50.0F);
		planetEden.setPlanetTemperature(71.2f);
		planetEden.setPlanetToxicity(0.0f);
		planetEden.setPlanetRadiation(0.0f);
		planetEden.setBreathable(true);
		planetEden.setWindLevel(0.6F);
		planetEden.setDensity(0.9F);
		planetEden.setHasRain(true);
		planetEden.setPlanetGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN,
				EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER);
		planetEden.setAtmosphere();
		planetEden.setPlanetIcon("eden");
		planetEden.setBiomeInfo(ZGBiomes.EDEN_GREEN_LANDS, ZGBiomes.EDEN_BLOOD_DESERT,
				ZGBiomes.EDEN_ROCK_MOUNTAINS, ZGBiomes.EDEN_TERRAN_VALLEY,
				ZGBiomes.EDEN_SNOWY_PLAINS, ZGBiomes.EDEN_GOLDEN_MEADOW, ZGBiomes.EDEN_SWAMPLANDS,
				ZGBiomes.EDENWOOD_FOREST, ZGBiomes.EDEN_FLOWER_GARDEN, ZGBiomes.EDEN_CRATERS,
				ZGBiomes.EDEN_OCEAN);
		totalPlanets++;
		
		// Planet Xathius
		planetXathius.setDimensionInfo(ConfigManagerZG.planetXathiusDimensionId,
				WorldProviderXathius.class);
		planetXathius.setParentSolarSystem(systemPraedyth);
		planetXathius.setPlanetClass(EnumPlanetClass.NINE);
		planetXathius.setRingColorRGB(0.1F, 0.9F, 1.4F);
		planetXathius.setPhaseShift(0.0F);
		planetXathius.setRelativeOrbitTime(2.5F);
		planetXathius.setDistanceFromCenter(3.4F);
		planetXathius.setTierRequired(6);
		planetXathius.setRelativeSize(20.0F);
		planetXathius.setPlanetTemperature(82.4f);
		planetXathius.setPlanetToxicity(2.5f);
		planetXathius.setPlanetRadiation(16.5f);
		planetXathius.setWindLevel(3.2F);
		planetXathius.setDensity(1.1F);
		planetXathius.setHasRain(true);
		planetXathius.setPlanetGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER,
				EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON);
		planetXathius.setAtmosphere();
		planetXathius.setPlanetIcon("xathius");
		planetXathius.setBiomeInfo(ZGBiomes.XATHIUS_ABSTRACT_PLAINS, ZGBiomes.XATHIUS_OCEAN,
				ZGBiomes.XATHIUS_BLUELANDS);
		totalPlanets++;
		
		// Planet Oasis
		planetOasis.setParentSolarSystem(systemPraedyth);
		planetOasis.setPlanetClass(EnumPlanetClass.R);
		planetOasis.setRingColorRGB(2.0f, 5.4f, 3.2f);
		planetOasis.setPhaseShift(0.0f);
		planetOasis.setRelativeOrbitTime(6F);
		planetOasis.setDistanceFromCenter(2.5f);
		planetOasis.setTierRequired(6);
		planetOasis.setRelativeSize(64.0f);
		planetOasis.setPlanetTemperature(68.2f);
		planetOasis.setPlanetToxicity(0.5f);
		planetOasis.setPlanetRadiation(4.0f);
		planetOasis.setBreathable(true);
		planetOasis.setWindLevel(0.9F);
		planetOasis.setDensity(1.0F);
		planetOasis.setHasRain(true);
		planetOasis.setPlanetGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER);
		planetOasis.setAtmosphere();
		planetOasis.setPlanetIcon("oasis");
		// planetOasis.setDimensionInfo(ConfigManagerZG.planetOasisDimensionId,
		// WorldProviderOasis.class);
		totalPlanets++;
		
		ZGHelper.Log("Loaded a total of " + totalPlanets + " new planets.");
	}
	
	public static void initMoons() {
		// TODO
		// totalMoons++;
		ZGHelper.Log("Loaded a total of " + totalMoons + " new moons.");
	}
	
	public static void registerSystems() {
		GalaxyRegistry.registerSolarSystem(systemPsios);
		GalaxyRegistry.registerSolarSystem(systemPraedyth);
		GalaxyRegistry.registerSolarSystem(systemPantheon);
		GalaxyRegistry.registerSolarSystem(systemOlympus);
		GalaxyRegistry.registerSolarSystem(systemAsgard);
		GalaxyRegistry.registerSolarSystem(systemVega);
		GalaxyRegistry.registerSolarSystem(systemNova);
		
		ZGPlanets.registerPlanets();
	}
	
	public static void registerPlanets() {
		GalaxyRegistry.registerPlanet(planetZollus);
		GalaxyRegistry.registerPlanet(planetEden);
		GalaxyRegistry.registerPlanet(planetKriffon);
		GalaxyRegistry.registerPlanet(planetPurgot);
		GalaxyRegistry.registerPlanet(planetXathius);
		GalaxyRegistry.registerPlanet(planetOasis);
	}
	
	public static void registerTeleportTypes() {
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
				new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffon.class,
				new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderPurgot.class,
				new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class, new TeleportTypeVenus());
		
		GalacticraftRegistry.registerTeleportType(WorldProviderXathius.class,
				new TeleportTypeVenus());
		// GalacticraftRegistry.registerTeleportType(WorldProviderOasis.class,
		// new TeleportTypeVenus());
	}
}