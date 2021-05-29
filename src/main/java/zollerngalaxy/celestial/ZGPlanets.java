/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.GalaxyRegistry;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import micdoodle8.mods.galacticraft.planets.mars.dimension.TeleportTypeMars;
import micdoodle8.mods.galacticraft.planets.venus.dimension.TeleportTypeVenus;
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAltum;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAtheon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCaligro;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCandora;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderEden;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderExodus;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKriffon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderOasis;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPerdita;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderVortex;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderXantheon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderXathius;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.core.enums.EnumBodyClass;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.starsystems.ZGStar;
import zollerngalaxy.starsystems.ZGStarSystem;
import zollerngalaxy.util.ZGUtils;

public class ZGPlanets {
	
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	
	private static int totalSystems = 0;
	private static int totalPlanets = 0;
	private static int totalMoons = 0;
	
	// Coords (Psios)
	private static float PSIOS_X = ConfigManagerZG.psiosX;
	private static float PSIOS_Y = ConfigManagerZG.psiosY;
	private static float PSIOS_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.psiosZ);
	
	// Coords (Praedyth)
	private static float PRAEDYTH_X = ConfigManagerZG.praedythX;
	private static float PRAEDYTH_Y = ConfigManagerZG.praedythY;
	private static float PRAEDYTH_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.praedythZ);
	
	// Coords (Sol-2)
	private static float SOL2_X = ConfigManagerZG.sol2X;
	private static float SOL2_Y = ConfigManagerZG.sol2Y;
	private static float SOL2_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.sol2Z);
	
	// Coords (Pantheon)
	private static float PANTHEON_X = ConfigManagerZG.pantheonX;
	private static float PANTHEON_Y = ConfigManagerZG.pantheonY;
	private static float PANTHEON_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.pantheonZ);
	
	// Coords (Olympus)
	private static float OLYMPUS_X = ConfigManagerZG.olympusX;
	private static float OLYMPUS_Y = ConfigManagerZG.olympusY;
	private static float OLYMPUS_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.olympusZ);
	
	// Coords (Asgard)
	private static float ASGARD_X = ConfigManagerZG.asgardX;
	private static float ASGARD_Y = ConfigManagerZG.asgardY;
	private static float ASGARD_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.asgardZ);
	
	// Coords (Vega)
	private static float VEGA_X = ConfigManagerZG.vegaX;
	private static float VEGA_Y = ConfigManagerZG.vegaY;
	private static float VEGA_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.vegaZ);
	
	// Coords (Nova)
	private static float NOVA_X = ConfigManagerZG.novaX;
	private static float NOVA_Y = ConfigManagerZG.novaY;
	private static float NOVA_Z = ZGUtils.ConvertFromZero(ConfigManagerZG.novaZ);
	
	private static boolean hideUnusedStarSystems = ConfigManagerZG.hideUnusedStarSystems;
	
	// Solar Systems
	public static ZGStarSystem systemPsios = new ZGStarSystem("psion6");
	public static ZGStarSystem systemPraedyth = new ZGStarSystem("praedyth");
	public static ZGStarSystem systemSol2 = new ZGStarSystem("sol2");
	public static ZGStarSystem systemPantheon = new ZGStarSystem("pantheon");
	public static ZGStarSystem systemOlympus = new ZGStarSystem("olympus");
	public static ZGStarSystem systemAsgard = new ZGStarSystem("asgard");
	public static ZGStarSystem systemVega = new ZGStarSystem("vega");
	public static ZGStarSystem systemNova = new ZGStarSystem("nova");
	
	// Stars
	public static ZGStar starPsios = new ZGStar("psion6");
	public static ZGStar starPraedyth = new ZGStar("praedyth");
	public static ZGStar starSol2 = new ZGStar("sol2");
	public static ZGStar starPantheon = new ZGStar("pantheon");
	public static ZGStar starOlympus = new ZGStar("olympus");
	public static ZGStar starAsgard = new ZGStar("asgard");
	public static ZGStar starVega = new ZGStar("vega");
	public static ZGStar starNova = new ZGStar("nova");
	
	// Psios Planets
	public static ZGPlanet planetEden = new ZGPlanet("eden");
	public static ZGPlanet planetZollus = new ZGPlanet("zollus");
	public static ZGPlanet planetKriffon = new ZGPlanet("kriffus");
	public static ZGPlanet planetPurgot = new ZGPlanet("purgot");
	public static ZGMoonBody moonAstros;
	
	// Praedyth Planets
	public static ZGPlanet planetXathius = new ZGPlanet("xathius");
	public static ZGPlanet planetOasis = new ZGPlanet("oasis");
	public static ZGPlanet planetXantheon = new ZGPlanet("xantheon");
	public static ZGPlanet planetCandora = new ZGPlanet("candora");
	public static ZGPlanet planetAtheon = new ZGPlanet("atheon");
	
	// Sol-2 Planets
	public static ZGPlanet planetPerdita = new ZGPlanet("perdita");
	public static ZGPlanet planetAltum = new ZGPlanet("altum");
	public static ZGPlanet planetCaligro = new ZGPlanet("caligro");
	public static ZGPlanet planetExodus = new ZGPlanet("exodus");
	
	// Pantheon Planets
	public static ZGPlanet planetVortex = new ZGPlanet("vortex");
	public static ZGPlanet planetMetztli = new ZGPlanet("metztli");
	public static ZGPlanet planetCentotl;
	public static ZGPlanet planetToci;
	public static ZGPlanet planetTlaloc;
	
	// Olympus Planets
	public static ZGPlanet planetAres;
	public static ZGPlanet planetPrometheus;
	public static ZGPlanet planetIcarus;
	public static ZGPlanet planetKronos;
	
	// Asgard Planets
	public static ZGPlanet planetAsgard;
	public static ZGPlanet planetMaveth;
	
	// Vega Planets
	public static ZGPlanet planetMeridian;
	public static ZGPlanet planetRequiem;
	
	// Nova Planets
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
		systemPsios.setMapPosition(new Vector3(PSIOS_X, PSIOS_Y, PSIOS_Z));
		starPsios.setParentSolarSystem(systemPsios);
		starPsios.setRelativeSize(35.0F);
		systemPsios.setMainStar(starPsios);
		totalSystems++;
		
		// Praedyth System
		systemPraedyth.setMapPosition(new Vector3(PRAEDYTH_X, PRAEDYTH_Y, PRAEDYTH_Z));
		starPraedyth.setParentSolarSystem(systemPraedyth);
		starPraedyth.setRelativeSize(40.0F);
		systemPraedyth.setMainStar(starPraedyth);
		totalSystems++;
		
		// Sol-2 System
		systemSol2.setMapPosition(new Vector3(SOL2_X, SOL2_Y, SOL2_Z));
		starSol2.setParentSolarSystem(systemSol2);
		starSol2.setRelativeSize(80.0F);
		systemSol2.setMainStar(starSol2);
		totalSystems++;
		
		// Pantheon System
		systemPantheon.setMapPosition(new Vector3(PANTHEON_X, PANTHEON_Y, PANTHEON_Z));
		starPantheon.setParentSolarSystem(systemPantheon);
		starPantheon.setRelativeSize(20.0F);
		systemPantheon.setMainStar(starPantheon);
		totalSystems++;
		
		// Olympus System
		systemOlympus.setMapPosition(new Vector3(OLYMPUS_X, OLYMPUS_Y, OLYMPUS_Z));
		starOlympus.setParentSolarSystem(systemOlympus);
		starOlympus.setRelativeSize(45.0F);
		systemOlympus.setMainStar(starOlympus);
		totalSystems++;
		
		// Asgard System
		systemAsgard.setMapPosition(new Vector3(ASGARD_X, ASGARD_Y, ASGARD_Z));
		starAsgard.setParentSolarSystem(systemAsgard);
		starAsgard.setRelativeSize(16.0F);
		systemAsgard.setMainStar(starAsgard);
		totalSystems++;
		
		// Vega System
		systemVega.setMapPosition(new Vector3(VEGA_X, VEGA_Y, VEGA_Z));
		starVega.setParentSolarSystem(systemVega);
		starVega.setRelativeSize(5.0F);
		systemVega.setMainStar(starVega);
		totalSystems++;
		
		// Nova System
		systemNova.setMapPosition(new Vector3(NOVA_X, NOVA_Y, NOVA_Z));
		starNova.setParentSolarSystem(systemNova);
		starNova.setRelativeSize(5.0F);
		systemNova.setMainStar(starNova);
		totalSystems++;
		
		ZGHelper.Log("Loaded a total of " + totalSystems + " new star systems.");
	}
	
	public static void initPlanets() {
		// Planet Zollus
		planetZollus.setDimensionInfo(ConfigManagerZG.planetZollusDimensionId, WorldProviderZollus.class);
		planetZollus.setParentSolarSystem(systemPsios);
		planetZollus.setBodyClass(EnumBodyClass.L);
		planetZollus.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetZollus.setPhaseShift(0.0F);
		planetZollus.setRelativeOrbitTime(42.2F);
		planetZollus.setDistanceFromCenter(1.9F);
		planetZollus.setTierRequired(ConfigManagerZG.planetZollusTier);
		if (ConfigManagerZG.planetUnreachableZollus) {
			planetZollus.setDisableRockets();
		}
		planetZollus.setRelativeSize(10.876F);
		planetZollus.setBodyTemperature(-92.6F);
		planetZollus.setBodyToxicity(0.4F);
		planetZollus.setBodyRadiation(0.5F);
		planetZollus.setWindLevel(6.7F);
		planetZollus.setDensity(0.1F);
		planetZollus.setHasRain(false);
		planetZollus.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.HELIUM);
		planetZollus.setAtmosphere();
		planetZollus.setBodyIcon("zollus");
		planetZollus.setBiomeInfo(ZGBiomes.ZOLLUS, ZGBiomes.ZOLLUS_OCEAN);
		totalPlanets++;
		
		// Planet Kriffon
		planetKriffon.setDimensionInfo(ConfigManagerZG.planetKriffonDimensionId, WorldProviderKriffon.class);
		planetKriffon.setParentSolarSystem(systemPsios);
		planetKriffon.setBodyClass(EnumBodyClass.Y);
		planetKriffon.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetKriffon.setPhaseShift(0.0F);
		planetKriffon.setRelativeOrbitTime(0.3F);
		planetKriffon.setDistanceFromCenter(0.5F);
		planetKriffon.setTierRequired(ConfigManagerZG.planetKriffonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableKriffon) {
			planetKriffon.setDisableRockets();
		}
		planetKriffon.setRelativeSize(20.0F);
		planetKriffon.setBodyTemperature(107.4F);
		planetKriffon.setBodyToxicity(14.1F);
		planetKriffon.setBodyRadiation(16.8F);
		planetKriffon.setWindLevel(0.1F);
		planetKriffon.setDensity(3.0F);
		planetKriffon.setHasRain(false);
		planetKriffon.setBodyGasses(EnumAtmosphericGas.ARGON, EnumAtmosphericGas.METHANE, EnumAtmosphericGas.OXYGEN);
		planetKriffon.setAtmosphere();
		planetKriffon.setBodyIcon("kriffus");
		planetKriffon.setBiomeInfo(ZGBiomes.KRIFFON, ZGBiomes.KRIFFON_LAVA_OCEAN);
		totalPlanets++;
		
		// Planet Purgot
		planetPurgot.setParentSolarSystem(systemPsios);
		planetPurgot.setBodyClass(EnumBodyClass.NINE);
		planetPurgot.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetPurgot.setPhaseShift(0.0F);
		planetPurgot.setRelativeOrbitTime(10F);
		planetPurgot.setDistanceFromCenter(1.0F);
		planetPurgot.setTierRequired(ConfigManagerZG.planetPurgotTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachablePurgot) {
			planetPurgot.setDisableRockets();
		}
		planetPurgot.setRelativeSize(40.0F);
		planetPurgot.setBodyTemperature(-54.5F);
		planetPurgot.setBodyToxicity(15.2F);
		planetPurgot.setBodyRadiation(2.2F);
		planetPurgot.setWindLevel(5.7F);
		planetPurgot.setDensity(0.3F);
		planetPurgot.setHasRain(false);
		planetPurgot.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON);
		planetPurgot.setBodyIcon("purgot");
		planetPurgot.setAtmosphere();
		planetPurgot.setBiomeInfo(ZGBiomes.PURGOT_BASE, ZGBiomes.PURGOT_LIMBO);
		planetPurgot.addChecklistKeys("equipOxygenSuit");
		planetPurgot.setDimensionInfo(ConfigManagerZG.planetPurgotDimensionId, WorldProviderPurgot.class);
		totalPlanets++;
		
		// Planet Eden
		planetEden.setDimensionInfo(ConfigManagerZG.planetEdenDimensionId, WorldProviderEden.class);
		planetEden.setParentSolarSystem(systemPsios);
		planetEden.setBodyClass(EnumBodyClass.M);
		planetEden.setRingColorRGB(0.1F, 0.9F, 2.6F);
		planetEden.setPhaseShift(0.0F);
		planetEden.setRelativeOrbitTime(8.0F);
		planetEden.setDistanceFromCenter(0.6F);
		planetEden.setTierRequired(ConfigManagerZG.planetEdenTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableEden) {
			planetEden.setDisableRockets();
		}
		planetEden.setRelativeSize(50.0F);
		planetEden.setBodyTemperature(75.4F);
		planetEden.setBodyToxicity(0.0F);
		planetEden.setBodyRadiation(0.0F);
		planetEden.setBreathable(true);
		planetEden.setWindLevel(0.6F);
		planetEden.setDensity(1.0F);
		planetEden.setHasRain(true);
		planetEden.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER, EnumAtmosphericGas.CO2);
		planetEden.setAtmosphere();
		planetEden.setBodyIcon("eden");
		planetEden.setBiomeInfo(ZGBiomes.EDEN_GREEN_LANDS, ZGBiomes.EDEN_BLOOD_DESERT, ZGBiomes.EDEN_ROCK_MOUNTAINS, ZGBiomes.EDEN_TERRAN_VALLEY,
				ZGBiomes.EDEN_SNOWY_PLAINS, ZGBiomes.EDEN_GOLDEN_MEADOW, ZGBiomes.EDEN_SWAMPLANDS, ZGBiomes.EDENWOOD_FOREST, ZGBiomes.EDEN_PARADISE_WOODS,
				ZGBiomes.EDEN_FLOWER_GARDEN, ZGBiomes.EDEN_CRATERS, ZGBiomes.EDEN_SHROOM_HILLS, ZGBiomes.EDEN_OCEAN);
		totalPlanets++;
		
		// Planet Xathius
		planetXathius.setDimensionInfo(ConfigManagerZG.planetXathiusDimensionId, WorldProviderXathius.class);
		planetXathius.setParentSolarSystem(systemPraedyth);
		planetXathius.setBodyClass(EnumBodyClass.NINE);
		planetXathius.setRingColorRGB(0.1F, 0.9F, 1.4F);
		planetXathius.setPhaseShift(0.0F);
		planetXathius.setRelativeOrbitTime(2.5F);
		planetXathius.setDistanceFromCenter(1.4F);
		planetXathius.setTierRequired(ConfigManagerZG.planetXathiusTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableXathius) {
			planetXathius.setDisableRockets();
		}
		planetXathius.setRelativeSize(20.0F);
		planetXathius.setBodyTemperature(82.4f);
		planetXathius.setBodyToxicity(2.5f);
		planetXathius.setBodyRadiation(16.5f);
		planetXathius.setWindLevel(3.2F);
		planetXathius.setDensity(1.1F);
		planetXathius.setHasRain(true);
		planetXathius.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON);
		planetXathius.setAtmosphere();
		planetXathius.setBodyIcon("xathius");
		planetXathius.setBiomeInfo(ZGBiomes.XATHIUS_ABSTRACT_PLAINS, ZGBiomes.XATHIUS_OCEAN, ZGBiomes.XATHIUS_BLUELANDS, ZGBiomes.XATHIUS_MOUNTAINS);
		totalPlanets++;
		
		// Planet Oasis
		planetOasis.setDimensionInfo(ConfigManagerZG.planetOasisDimensionId, WorldProviderOasis.class);
		planetOasis.setParentSolarSystem(systemPraedyth);
		planetOasis.setBodyClass(EnumBodyClass.R);
		planetOasis.setRingColorRGB(2.0f, 5.4f, 3.2f);
		planetOasis.setPhaseShift(0.0f);
		planetOasis.setRelativeOrbitTime(6.2F);
		planetOasis.setDistanceFromCenter(1.8f);
		planetOasis.setTierRequired(ConfigManagerZG.planetOasisTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableOasis) {
			planetOasis.setDisableRockets();
		}
		planetOasis.setRelativeSize(64.0f);
		planetOasis.setBodyTemperature(68.2F);
		planetOasis.setBodyToxicity(0.5f);
		planetOasis.setBodyRadiation(4.0f);
		planetOasis.setBreathable(true);
		planetOasis.setWindLevel(1.9F);
		planetOasis.setDensity(1.6F);
		planetOasis.setHasRain(true);
		planetOasis.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER);
		planetOasis.setAtmosphere();
		planetOasis.setBodyIcon("oasis");
		planetOasis.setBiomeInfo(ZGBiomes.OASIS_PLAINS, ZGBiomes.OASIS_OCEAN, ZGBiomes.OASIS_REDLANDS);
		totalPlanets++;
		
		// Planet Xantheon
		planetXantheon.setDimensionInfo(ConfigManagerZG.planetXantheonDimensionId, WorldProviderXantheon.class);
		planetXantheon.setParentSolarSystem(systemPraedyth);
		planetXantheon.setBodyClass(EnumBodyClass.CONSTRUCTED);
		planetXantheon.setRingColorRGB(1.6f, 3.7f, 2.1f);
		planetXantheon.setPhaseShift(4.0f);
		planetXantheon.setRelativeOrbitTime(20.2F);
		planetXantheon.setDistanceFromCenter(2.5F);
		planetXantheon.setTierRequired(ConfigManagerZG.planetXantheonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableXantheon) {
			planetXantheon.setDisableRockets();
		}
		planetXantheon.setRelativeSize(96.0f);
		planetXantheon.setBodyTemperature(-31.2F);
		planetXantheon.setBodyToxicity(5.2f);
		planetXantheon.setBodyRadiation(46.3f);
		planetXantheon.setBreathable(false);
		planetXantheon.setWindLevel(0.0F);
		planetXantheon.setDensity(20.6F);
		planetXantheon.setHasRain(false);
		planetXantheon.setBodyGasses(EnumAtmosphericGas.CO2, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.HELIUM);
		planetXantheon.setAtmosphere();
		planetXantheon.setBodyIcon("xantheon");
		planetXantheon.setBiomeInfo(ZGBiomes.XANTHEON);
		totalPlanets++;
		
		// Candora
		planetCandora.setDimensionInfo(ConfigManagerZG.planetCandoraDimensionId, WorldProviderCandora.class);
		planetCandora.setParentSolarSystem(systemPraedyth);
		planetCandora.setBodyClass(EnumBodyClass.EXOTIC);
		planetCandora.setRingColorRGB(2.5F, 0.0F, 2.5F);
		planetCandora.setPhaseShift(0.1F);
		planetCandora.setRelativeOrbitTime(10.5F);
		planetCandora.setDistanceFromCenter(2.1F);
		planetCandora.setTierRequired(ConfigManagerZG.planetCandoraTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableCandora) {
			planetCandora.setDisableRockets();
		}
		planetCandora.setRelativeSize(102.9F);
		planetCandora.setBodyTemperature(67.5F);
		planetCandora.setBodyToxicity(0.0F);
		planetCandora.setBodyRadiation(0.0F);
		planetCandora.setBreathable(true);
		planetCandora.setWindLevel(0.0F);
		planetCandora.setDensity(0.1F);
		planetCandora.setHasRain(false);
		planetCandora.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.CO2, EnumAtmosphericGas.WATER, EnumAtmosphericGas.HELIUM);
		planetCandora.setAtmosphere();
		planetCandora.setBodyIcon("candora");
		planetCandora.setBiomeInfo(ZGBiomes.CANDY_MOUNTAIN, ZGBiomes.CANDY_OCEAN, ZGBiomes.CANDY_JOLLY_MELON_PLAINS, ZGBiomes.CANDY_BLUEBERRY_HILLS,
				ZGBiomes.CANDY_COOKIE_LANDS);
		totalPlanets++;
		
		// Atheon
		planetAtheon.setDimensionInfo(ConfigManagerZG.planetAtheonDimensionId, WorldProviderAtheon.class);
		planetAtheon.setParentSolarSystem(systemPraedyth);
		planetAtheon.setBodyClass(EnumBodyClass.CONSTRUCTED);
		planetAtheon.setRingColorRGB(3.6F, 3.2F, 1.7F);
		planetAtheon.setPhaseShift(10.2F);
		planetAtheon.setRelativeOrbitTime(0.6F);
		planetAtheon.setDistanceFromCenter(0.4F);
		planetAtheon.setTierRequired(ConfigManagerZG.planetAtheonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableAtheon) {
			planetAtheon.setDisableRockets();
		}
		planetAtheon.setRelativeSize(102.5F);
		planetAtheon.setBodyTemperature(57.2F);
		planetAtheon.setBodyToxicity(0.0F);
		planetAtheon.setBodyRadiation(96.7F);
		planetAtheon.setBreathable(false);
		planetAtheon.setWindLevel(0.0F);
		planetAtheon.setDensity(40.2F);
		planetAtheon.setHasRain(false);
		planetAtheon.setBodyGasses(EnumAtmosphericGas.CO2, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.HELIUM, EnumAtmosphericGas.METHANE);
		planetAtheon.setAtmosphere();
		planetAtheon.setBodyIcon("atheon");
		planetAtheon.setBiomeInfo(ZGBiomes.ATHEON_GOLDLANDS, ZGBiomes.ATHEON_LAVA_LAKES);
		totalPlanets++;
		
		// Perdita
		planetPerdita.setDimensionInfo(ConfigManagerZG.planetPerditaDimensionId, WorldProviderPerdita.class);
		planetPerdita.setParentSolarSystem(systemSol2);
		planetPerdita.setBodyClass(EnumBodyClass.DESERT);
		planetPerdita.setRingColorRGB(4.6F, 2.2F, 6.7F);
		planetPerdita.setPhaseShift(20.1F);
		planetPerdita.setRelativeOrbitTime(1.2F);
		planetPerdita.setDistanceFromCenter(0.8F);
		planetPerdita.setTierRequired(ConfigManagerZG.planetPerditaTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachablePerdita) {
			planetPerdita.setDisableRockets();
		}
		planetPerdita.setRelativeSize(204.6F);
		planetPerdita.setBodyTemperature(195.8F);
		planetPerdita.setBodyToxicity(1.2F);
		planetPerdita.setBodyRadiation(3.5F);
		planetPerdita.setBreathable(true);
		planetPerdita.setWindLevel(16.16F);
		planetPerdita.setDensity(20.4F);
		planetPerdita.setHasRain(false);
		planetPerdita.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.CO2, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.WATER);
		planetPerdita.setAtmosphere();
		planetPerdita.setBodyIcon("perdita");
		planetPerdita.setBiomeInfo(ZGBiomes.PERDITA_DESERT, ZGBiomes.PERDITA_HALLOWS, ZGBiomes.PERDITA_OASIS, ZGBiomes.PERDITA_FUELTONIUM_OCEAN,
				ZGBiomes.PERDITA_LOST_MOUNTAINS);
		totalPlanets++;
		
		// Altum
		planetAltum.setDimensionInfo(ConfigManagerZG.planetAltumDimensionId, WorldProviderAltum.class);
		planetAltum.setParentSolarSystem(systemSol2);
		planetAltum.setBodyClass(EnumBodyClass.OCEAN);
		planetAltum.setRingColorRGB(7.7F, 7.7F, 7.7F);
		planetAltum.setPhaseShift(5.6F);
		planetAltum.setRelativeOrbitTime(3.6F);
		planetAltum.setDistanceFromCenter(1.0F);
		planetAltum.setTierRequired(ConfigManagerZG.planetAltumTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableAltum) {
			planetAltum.setDisableRockets();
		}
		planetAltum.setRelativeSize(80.6F);
		planetAltum.setBodyRadiation(0.6F);
		planetAltum.setBodyToxicity(0.2F);
		planetAltum.setBreathable(true);
		planetAltum.setWindLevel(20.42F);
		planetAltum.setDensity(0.3F);
		planetAltum.setHasRain(true);
		planetAltum.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.CO2, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.HYDROGEN);
		planetAltum.setAtmosphere();
		planetAltum.setBodyIcon("altum");
		planetAltum.setBiomeInfo(ZGBiomes.ALTUM_ROCKY_ISLES, ZGBiomes.ALTUM_SANCTUM_BEACH, ZGBiomes.ALTUM_OCEAN, ZGBiomes.ALTUM_ROCKY_SHORE);
		totalPlanets++;
		
		// Caligro
		planetCaligro.setDimensionInfo(ConfigManagerZG.planetCaligroDimensionId, WorldProviderCaligro.class);
		planetCaligro.setParentSolarSystem(systemSol2);
		planetCaligro.setBodyClass(EnumBodyClass.DARK);
		planetCaligro.setRingColorRGB(0.0F, 10.0F, 0.0F);
		planetCaligro.setPhaseShift(100.0F);
		planetCaligro.setRelativeOrbitTime(140.18F);
		planetCaligro.setDistanceFromCenter(2.0F);
		planetCaligro.setTierRequired(ConfigManagerZG.planetCaligroTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableCaligro) {
			planetCaligro.setDisableRockets();
		}
		planetCaligro.setRelativeSize(160.0F);
		planetCaligro.setBodyTemperature(-165.62F);
		planetCaligro.setBodyToxicity(55.24F);
		planetCaligro.setBodyRadiation(32.21F);
		planetCaligro.setWindLevel(60.58F);
		planetCaligro.setDensity(100.32F);
		planetCaligro.setHasRain(false);
		planetCaligro.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON,
				EnumAtmosphericGas.METHANE, EnumAtmosphericGas.HYDROGEN);
		planetCaligro.setBodyIcon("caligro");
		planetCaligro.setAtmosphere();
		planetCaligro.setBiomeInfo(ZGBiomes.CALIGRO_UPSIDE_DOWN, ZGBiomes.CALIGRO_CREEPLANDS, ZGBiomes.CALIGRO_ROCKY_VEINS, ZGBiomes.CALIGRO_WITHERLANDS,
				ZGBiomes.CALIGRO_CORRUPTED_MESA);
		totalPlanets++;
		
		// Exodus
		planetExodus.setDimensionInfo(ConfigManagerZG.planetExodusDimensionId, WorldProviderExodus.class);
		planetExodus.setParentSolarSystem(systemSol2);
		planetExodus.setBodyClass(EnumBodyClass.M);
		planetExodus.setRingColorRGB(10.0F, 10.0F, 10.0F);
		planetExodus.setPhaseShift(50F);
		planetExodus.setRelativeOrbitTime(4.5F);
		planetExodus.setDistanceFromCenter(3.0F);
		planetExodus.setTierRequired(ConfigManagerZG.planetExodusTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableExodus) {
			planetExodus.setDisableRockets();
		}
		planetExodus.setRelativeSize(160.0F);
		planetExodus.setBodyTemperature(76.15F);
		planetExodus.setBodyToxicity(0.0F);
		planetExodus.setBodyRadiation(0.0F);
		planetExodus.setWindLevel(125.67F);
		planetExodus.setDensity(1.0F);
		planetExodus.setHasRain(true);
		planetExodus.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.CO2, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.HYDROGEN);
		planetExodus.setBodyIcon("exodus");
		planetExodus.setAtmosphere();
		planetExodus.setBiomeInfo(ZGBiomes.EXODUS_AZURE_PLAINS, ZGBiomes.EXODUS_ROCKY_HILLS, ZGBiomes.EXODUS_OCEAN, ZGBiomes.EXODUS_FOREST, ZGBiomes.EXODUS_BLACK_MESA);
		totalPlanets++;
		
		// Vortex
		planetVortex.setDimensionInfo(ConfigManagerZG.planetVortexDimensionId, WorldProviderVortex.class);
		planetVortex.setParentSolarSystem(systemPantheon);
		planetVortex.setBodyClass(EnumBodyClass.STORMY);
		planetVortex.setRingColorRGB(1.0F, 0.1F, 0.9F);
		planetVortex.setPhaseShift(50F);
		planetVortex.setRelativeOrbitTime(4.5F);
		planetVortex.setDistanceFromCenter(3.0F);
		planetVortex.setTierRequired(ConfigManagerZG.planetVortexTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableVortex) {
			planetVortex.setDisableRockets();
		}
		planetVortex.setRelativeSize(160.0F);
		planetVortex.setBodyTemperature(76.15F);
		planetVortex.setBodyToxicity(0.0F);
		planetVortex.setBodyRadiation(0.0F);
		planetVortex.setWindLevel(125.67F);
		planetVortex.setDensity(1.0F);
		planetVortex.setHasRain(true);
		planetVortex.setBodyGasses(EnumAtmosphericGas.HELIUM, EnumAtmosphericGas.NITROGEN);
		planetVortex.setBodyIcon("vortex");
		planetVortex.setAtmosphere();
		planetVortex.setBiomeInfo(ZGBiomes.VORTEX_BASE, ZGBiomes.VORTEX_MOUNTAINS, ZGBiomes.VORTEX_CHARGIUM_SEA);
		totalPlanets++;
		
		// Metztli
		planetMetztli.setDimensionInfo(ConfigManagerZG.planetMetztliDimensionId, WorldProviderMetztli.class);
		planetMetztli.setParentSolarSystem(systemPantheon);
		planetMetztli.setBodyClass(EnumBodyClass.M);
		planetMetztli.setRingColorRGB(1.0F, 1.0F, 1.9F);
		planetMetztli.setPhaseShift(0.0F);
		planetMetztli.setRelativeOrbitTime(8.0F);
		planetMetztli.setDistanceFromCenter(4.0F);
		planetMetztli.setTierRequired(ConfigManagerZG.planetMetztliTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableMetztli) {
			planetMetztli.setDisableRockets();
		}
		planetMetztli.setRelativeSize(165.0F);
		planetMetztli.setBodyTemperature(86.05F);
		planetMetztli.setDensity(10.0F);
		planetMetztli.setHasRain(true);
		planetMetztli.setBodyToxicity(5.2F);
		planetMetztli.setBodyRadiation(8.0F);
		planetMetztli.setWindLevel(25.6F);
		planetMetztli.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER);
		planetMetztli.setBodyIcon("metztli");
		planetMetztli.setAtmosphere();
		planetMetztli.setBiomeInfo(ZGBiomes.METZTLI_HARRAN_PRIME, ZGBiomes.METZTLI_HARRAN_DUNES, ZGBiomes.METZTLI_HARRAN_OCEAN, ZGBiomes.METZTLI_HARRAN_SWAMP,
				ZGBiomes.METZTLI_HARRAN_TUNDRA, ZGBiomes.METZTLI_HARRAN_SHROOMS, ZGBiomes.METZTLI_HARRAN_CLAY_MESA);
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
		GalaxyRegistry.registerSolarSystem(systemSol2);
		GalaxyRegistry.registerSolarSystem(systemPantheon);
		
		if (!hideUnusedStarSystems) {
			GalaxyRegistry.registerSolarSystem(systemOlympus);
			GalaxyRegistry.registerSolarSystem(systemAsgard);
			GalaxyRegistry.registerSolarSystem(systemVega);
			GalaxyRegistry.registerSolarSystem(systemNova);
		}
		
		ZGPlanets.registerPlanets();
	}
	
	public static void registerPlanets() {
		GalaxyRegistry.registerPlanet(planetZollus);
		GalaxyRegistry.registerPlanet(planetEden);
		GalaxyRegistry.registerPlanet(planetKriffon);
		GalaxyRegistry.registerPlanet(planetPurgot);
		GalaxyRegistry.registerPlanet(planetXathius);
		GalaxyRegistry.registerPlanet(planetOasis);
		GalaxyRegistry.registerPlanet(planetXantheon);
		GalaxyRegistry.registerPlanet(planetCandora);
		GalaxyRegistry.registerPlanet(planetAtheon);
		GalaxyRegistry.registerPlanet(planetPerdita);
		GalaxyRegistry.registerPlanet(planetAltum);
		GalaxyRegistry.registerPlanet(planetCaligro);
		GalaxyRegistry.registerPlanet(planetExodus);
		GalaxyRegistry.registerPlanet(planetVortex);
		GalaxyRegistry.registerPlanet(planetMetztli);
	}
	
	public static void registerTeleportTypes() {
		// Psios-6
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffon.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderPurgot.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class, new TeleportTypeVenus());
		
		// Praedyth
		GalacticraftRegistry.registerTeleportType(WorldProviderXathius.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderOasis.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderXantheon.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderCandora.class, new TeleportTypeVenus());
		GalacticraftRegistry.registerTeleportType(WorldProviderAtheon.class, new TeleportTypeVenus());
		
		// Sol-2
		GalacticraftRegistry.registerTeleportType(WorldProviderPerdita.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderAltum.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderCaligro.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderExodus.class, new TeleportTypeMars());
		
		// Pantheon
		GalacticraftRegistry.registerTeleportType(WorldProviderVortex.class, new TeleportTypeMars());
		GalacticraftRegistry.registerTeleportType(WorldProviderMetztli.class, new TeleportTypeMars());
	}
}