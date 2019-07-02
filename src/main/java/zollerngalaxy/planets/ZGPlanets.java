package zollerngalaxy.planets;

import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.core.EnumPlanetClass;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZollernHelper;
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
		starPsios.setRelativeSize(60.0F);
		starPsios.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/psion6.png"));
		systemPsios.setMainStar(starPsios);
		totalSystems++;
		
		// Praedyth System
		systemPraedyth.setMapPosition(new Vector3(-1.1F, 1.4F, -0.2F));
		starPraedyth.setParentSolarSystem(systemPraedyth);
		starPraedyth.setTierRequired(-1);
		starPraedyth.setRelativeSize(40.0F);
		starPraedyth.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/praedyth.png"));
		systemPraedyth.setMainStar(starPraedyth);
		totalSystems++;
		
		// Pantheon System
		systemPantheon.setMapPosition(new Vector3(2.0F, 1.2F, 0.2F));
		starPantheon.setParentSolarSystem(systemPantheon);
		starPantheon.setTierRequired(-1);
		starPantheon.setRelativeSize(20.0F);
		starPantheon.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/pantheon.png"));
		systemPantheon.setMainStar(starPantheon);
		totalSystems++;
		
		// Olympus System
		systemOlympus.setMapPosition(new Vector3(4.5F, 1.5F, 1.4F));
		starOlympus.setParentSolarSystem(systemOlympus);
		starOlympus.setTierRequired(-1);
		starOlympus.setRelativeSize(45.0F);
		starOlympus.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/olympus.png"));
		systemOlympus.setMainStar(starOlympus);
		totalSystems++;
		
		// Asgard System
		systemAsgard.setMapPosition(new Vector3(3.0F, 1.2F, 0.3F));
		starAsgard.setParentSolarSystem(systemAsgard);
		starAsgard.setTierRequired(-1);
		starAsgard.setRelativeSize(16.0F);
		starAsgard.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/asgard.png"));
		systemAsgard.setMainStar(starAsgard);
		totalSystems++;
		
		// Vega System
		systemVega.setMapPosition(new Vector3(1.0F, 2.5F, 0.9F));
		starVega.setParentSolarSystem(systemVega);
		starVega.setTierRequired(-1);
		starVega.setRelativeSize(5.0F);
		starVega.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/vega.png"));
		systemVega.setMainStar(starVega);
		totalSystems++;
		
		// Nova System
		systemNova.setMapPosition(new Vector3(-3.0F, 4.0F, -2.0F));
		starNova.setParentSolarSystem(systemNova);
		starNova.setTierRequired(-1);
		starNova.setRelativeSize(5.0F);
		starNova.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID,
				"textures/gui/nova.png"));
		systemNova.setMainStar(starNova);
		totalSystems++;
		
		ZollernHelper.logInfo("Loaded a total of " + totalSystems
				+ " new star systems.");
	}
	
	public static void initPlanets() {
		// Planet Zollus
		planetZollus.setParentSolarSystem(systemPsios);
		planetZollus.setPlanetClass(EnumPlanetClass.L);
		planetZollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetZollus.setPhaseShift(0.0F);
		planetZollus.setRelativeOrbitTime(16F);
		planetZollus.setDistanceFromCenter(3F);
		planetZollus.setTierRequired(4);
		planetZollus.setRelativeSize(14.876F);
		planetZollus.setPlanetTemperature(-102.6f);
		planetZollus.setPlanetToxicity(0.4f);
		planetZollus.setPlanetRadiation(4.5f);
		planetZollus.setWindLevel(2.6F);
		planetZollus.setDensity(0.1F);
		planetZollus.setHasRain(false);
		planetZollus.setPlanetIcon("zollus");
		// planetZollus.setDimensionInfo(ConfigManagerZG.planetZollusDimensionId,
		// WorldProviderZollus.class);
		totalPlanets++;
		
		// Planet Eden
		planetEden.setParentSolarSystem(systemPsios);
		planetEden.setPlanetClass(EnumPlanetClass.M);
		planetEden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetEden.setPhaseShift(0.1F);
		planetEden.setRelativeOrbitTime(8.0F);
		planetEden.setDistanceFromCenter(2F);
		planetEden.setTierRequired(3);
		planetEden.setRelativeSize(40.0F);
		planetEden.setPlanetTemperature(71.2f);
		planetEden.setPlanetToxicity(0.0f);
		planetEden.setPlanetRadiation(0.0f);
		planetEden.setBreathable(true);
		planetEden.setWindLevel(0.6F);
		planetEden.setDensity(0.9F);
		planetEden.setHasRain(true);
		planetEden.setPlanetIcon("eden");
		// planetEden.setDimensionInfo(ConfigManagerZG.planetEdenDimensionId,
		// WorldProviderEden.class);
		totalPlanets++;
		
		// Planet Kriffon
		planetKriffon.setParentSolarSystem(systemPsios);
		planetKriffon.setPlanetClass(EnumPlanetClass.Y);
		planetKriffon.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetKriffon.setPhaseShift(0.2F);
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
		planetKriffon.setPlanetIcon("kriffus");
		// planetKriffon.setDimensionInfo(
		// ConfigManagerZG.planetKriffonDimensionId,
		// WorldProviderKriffon.class);
		totalPlanets++;
		
		// Planet Purgot
		planetPurgot.setParentSolarSystem(systemPsios);
		planetPurgot.setPlanetClass(EnumPlanetClass.NINE);
		planetPurgot.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetPurgot.setPhaseShift(0.3F);
		planetPurgot.setRelativeOrbitTime(10F);
		planetPurgot.setDistanceFromCenter(1.2f);
		planetPurgot.setTierRequired(5);
		planetPurgot.setRelativeSize(40.0F);
		planetPurgot.setPlanetTemperature(-74.5f);
		planetPurgot.setPlanetToxicity(15.2f);
		planetPurgot.setPlanetRadiation(6.2f);
		planetPurgot.setWindLevel(5.7F);
		planetPurgot.setDensity(0.3F);
		planetPurgot.setHasRain(false);
		planetPurgot.setPlanetIcon("purgot");
		// planetPurgot.setDimensionInfo(ConfigManagerZG.planetPurgotDimensionId,
		// WorldProviderPurgot.class);
		totalPlanets++;
		
		// Planet Xathius
		planetXathius.setParentSolarSystem(systemPraedyth);
		planetXathius.setPlanetClass(EnumPlanetClass.NINE);
		planetXathius.setRingColorRGB(0.1F, 0.9F, 1.4F);
		planetXathius.setPhaseShift(0.4F);
		planetXathius.setRelativeOrbitTime(3F);
		planetXathius.setDistanceFromCenter(3.4F);
		planetXathius.setTierRequired(5);
		planetXathius.setRelativeSize(20.0F);
		planetXathius.setPlanetTemperature(82.4f);
		planetXathius.setPlanetToxicity(1.5f);
		planetXathius.setPlanetRadiation(16.5f);
		planetXathius.setWindLevel(3.2F);
		planetXathius.setDensity(1.1F);
		planetXathius.setHasRain(true);
		planetXathius.setPlanetIcon("xathius");
		// planetXathius.setDimensionInfo(
		// ConfigManagerZG.planetXathiusDimensionId,
		// WorldProviderXathius.class);
		totalPlanets++;
		
		// Planet Oasis
		planetOasis.setParentSolarSystem(systemPraedyth);
		planetOasis.setPlanetClass(EnumPlanetClass.R);
		planetOasis.setRingColorRGB(2.0f, 5.4f, 3.2f);
		planetOasis.setPhaseShift(0.5f);
		planetOasis.setRelativeOrbitTime(4f);
		planetXathius.setDistanceFromCenter(3.9f);
		planetOasis.setTierRequired(5);
		planetOasis.setRelativeSize(64.0f);
		planetOasis.setPlanetTemperature(68.2f);
		planetOasis.setPlanetToxicity(0.5f);
		planetOasis.setPlanetRadiation(2.0f);
		planetOasis.setBreathable(true);
		planetOasis.setWindLevel(0.9F);
		planetOasis.setDensity(1.0F);
		planetOasis.setHasRain(true);
		planetOasis.setPlanetIcon("oasis");
		// planetOasis.setDimensionInfo(ConfigManagerZG.planetOasisDimensionId,
		// WorldProviderOasis.class);
		totalPlanets++;
		
		ZollernHelper.logInfo("Loaded a total of " + totalPlanets
				+ " new planets.");
	}
	
	public static void initMoons() {
		// TODO
		ZollernHelper
				.logInfo("Loaded a total of " + totalMoons + " new moons.");
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
		GalaxyRegistry.registerPlanet(planetOasis);
	}
	
	public static void registerTeleportTypes() {
		// TeleportTypeNG teleType = new TeleportTypeNG();
		// GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class,
		// teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderEden.class,
		// teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderKriffon.class,
		// teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderPurgot.class,
		// teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderXathius.class,
		// teleType);
		// GalacticraftRegistry.registerTeleportType(WorldProviderOasis.class,
		// teleType);
	}
}