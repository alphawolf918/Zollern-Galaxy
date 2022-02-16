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
import zollerngalaxy.biomes.ZGBiomes;
import zollerngalaxy.celestial.starsystems.ZGStar;
import zollerngalaxy.celestial.starsystems.ZGStarSystem;
import zollerngalaxy.celestial.teleporttypes.TeleportTypeBaseZG;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAltum;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAstros;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderAtheon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCaligro;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCandora;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderCentotl;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderEden;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderExodus;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKriffon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderKronos;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMaveth;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMetztli;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderOasis;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPerdita;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPurgot;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderTlaloc;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderToci;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderVortex;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderXantheon;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderXathius;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderZollus;
import zollerngalaxy.core.enums.EnumBodyClass;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGPlanets {
	
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	protected static boolean enableExtraGalaxies = (ConfigManagerZG.enableExtraPlanetsCompat && ModHelperBase.useExtraPlanets);
	
	private static int totalSystems = 0;
	private static int totalPlanets = 0;
	private static int totalMoons = 0;
	
	// Coords (Psios)
	private static float PSIOS_X = -2.0F + ConfigManagerZG.psiosXOffset;
	private static float PSIOS_Y = 0.5F + ConfigManagerZG.psiosYOffset;
	private static float PSIOS_Z = 0.0F + ConfigManagerZG.psiosZOffset;
	
	// Coords (Praedyth)
	private static float PRAEDYTH_X = -1.2F + ConfigManagerZG.praedythXOffset;
	private static float PRAEDYTH_Y = 1.6F + ConfigManagerZG.praedythYOffset;
	private static float PRAEDYTH_Z = 0.0F + ConfigManagerZG.praedythZOffset;
	
	// Coords (Sol-2)
	private static float SOL2_X = 1.2F + ConfigManagerZG.sol2XOffset;
	private static float SOL2_Y = -1.2F + ConfigManagerZG.sol2YOffset;
	private static float SOL2_Z = 0.0F + ConfigManagerZG.sol2ZOffset;
	
	// Coords (Pantheon)
	private static float PANTHEON_X = 2.5F + ConfigManagerZG.pantheonXOffset;
	private static float PANTHEON_Y = 0.8F + ConfigManagerZG.pantheonYOffset;
	private static float PANTHEON_Z = 0.0F + ConfigManagerZG.pantheonZOffset;
	
	// Coords (Olympus)
	private static float OLYMPUS_X = (float) (((enableExtraGalaxies) ? 0.0F : 1.8) + ConfigManagerZG.olympusXOffset);
	private static float OLYMPUS_Y = (float) (((enableExtraGalaxies) ? 0.0F : 2.1) + ConfigManagerZG.olympusYOffset);
	private static float OLYMPUS_Z = 0.0F + ConfigManagerZG.olympusZOffset;
	
	// Coords (Asgard)
	private static float ASGARD_X = -0.2F + ConfigManagerZG.asgardXOffset;
	private static float ASGARD_Y = -1.6F + ConfigManagerZG.asgardYOffset;
	private static float ASGARD_Z = 0.0F + ConfigManagerZG.asgardZOffset;
	
	// Coords (Vega)
	private static float VEGA_X = 0.5F + ConfigManagerZG.vegaXOffset;
	private static float VEGA_Y = 2.2F + ConfigManagerZG.vegaYOffset;
	private static float VEGA_Z = 0.0F + ConfigManagerZG.vegaZOffset;
	
	// Coords (Nova)
	private static float NOVA_X = (float) (((enableExtraGalaxies) ? 0.0F : -1.6) + ConfigManagerZG.novaXOffset);
	private static float NOVA_Y = (float) (((enableExtraGalaxies) ? 0.0F : 2.0) + ConfigManagerZG.novaYOffset);
	private static float NOVA_Z = 0.0F + ConfigManagerZG.novaZOffset;
	
	private static boolean hideUnusedStarSystems = ConfigManagerZG.hideUnusedStarSystems;
	
	// Galaxies
	public static Galaxy gxMilkyWay = GalaxyListZG.MILKY_WAY;
	public static Galaxy gxEissentam = GalaxyListZG.EISSENTAM;
	public static Galaxy gxEuclid = GalaxyListZG.EUCLID;
	
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
	public static ZGStar starAsgard = new ZGStar("asgard", "asgard_star");
	public static ZGStar starVega = new ZGStar("vega");
	public static ZGStar starNova = new ZGStar("nova");
	
	// Psios Planets
	public static ZGPlanet planetZollus = new ZGPlanet("zollus");
	public static ZGPlanet planetKriffon = new ZGPlanet("kriffus");
	public static ZGPlanet planetPurgot = new ZGPlanet("purgot");
	public static ZGPlanet planetEden = new ZGPlanet("eden");
	public static ZGMoon moonAstros = new ZGMoon("astros");
	
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
	public static ZGPlanet planetCentotl = new ZGPlanet("centotl");
	public static ZGPlanet planetToci = new ZGPlanet("toci");
	public static ZGPlanet planetTlaloc = new ZGPlanet("tlaloc");
	
	// Olympus Planets
	public static ZGPlanet planetAres = new ZGPlanet("ares");
	public static ZGPlanet planetPrometheus = new ZGPlanet("prometheus");
	public static ZGPlanet planetIcarus = new ZGPlanet("icarus");
	public static ZGPlanet planetKronos = new ZGPlanet("kronos");
	
	// Asgard Planets
	public static ZGPlanet planetMaveth = new ZGPlanet("maveth");
	public static ZGPlanet planetAsgard = new ZGPlanet("asgard");
	
	// Vega Planets
	public static ZGPlanet planetReach = new ZGPlanet("reach");
	public static ZGPlanet planetRequiem = new ZGPlanet("requiem");
	public static ZGPlanet planetMeridian = new ZGPlanet("meridian");
	
	// Nova Planets
	public static ZGPlanet planetSomnium = new ZGPlanet("somnium");
	public static ZGPlanet planetPrimor = new ZGPlanet("primor");
	
	public static void init() {
		ZGPlanets.initStarSystems();
		ZGPlanets.initPlanets();
		ZGPlanets.initMoons();
		ZGPlanets.registerSystems();
		ZGPlanets.registerTeleportTypes();
	}
	
	public static void initStarSystems() {
		// Psios System
		systemPsios.setMapPosition(new Vector3(ZGPlanets.PSIOS_X, PSIOS_Y, PSIOS_Z));
		systemPsios.setMainStar(starPsios);
		starPsios.setParentSolarSystem(systemPsios);
		totalSystems++;
		
		// Praedyth System
		systemPraedyth.setMapPosition(new Vector3(PRAEDYTH_X, PRAEDYTH_Y, PRAEDYTH_Z));
		starPraedyth.setParentSolarSystem(systemPraedyth);
		systemPraedyth.setMainStar(starPraedyth);
		totalSystems++;
		
		// Sol-2 System
		systemSol2.setMapPosition(new Vector3(SOL2_X, SOL2_Y, SOL2_Z));
		starSol2.setParentSolarSystem(systemSol2);
		systemSol2.setMainStar(starSol2);
		totalSystems++;
		
		// Pantheon System
		systemPantheon.setMapPosition(new Vector3(PANTHEON_X, PANTHEON_Y, PANTHEON_Z));
		starPantheon.setParentSolarSystem(systemPantheon);
		systemPantheon.setMainStar(starPantheon);
		totalSystems++;
		
		// Olympus System
		systemOlympus.setMapPosition(new Vector3(OLYMPUS_X, OLYMPUS_Y, OLYMPUS_Z));
		if (ZGPlanets.enableExtraGalaxies) {
			systemOlympus.setGalaxy(gxEissentam);
		}
		starOlympus.setParentSolarSystem(systemOlympus);
		systemOlympus.setMainStar(starOlympus);
		totalSystems++;
		
		// Asgard System
		systemAsgard.setMapPosition(new Vector3(ASGARD_X, ASGARD_Y, ASGARD_Z));
		if (ZGPlanets.enableExtraGalaxies) {
			systemAsgard.setGalaxy(gxEissentam);
		}
		starAsgard.setParentSolarSystem(systemAsgard);
		systemAsgard.setMainStar(starAsgard);
		totalSystems++;
		
		// Vega System
		systemVega.setMapPosition(new Vector3(VEGA_X, VEGA_Y, VEGA_Z));
		if (ZGPlanets.enableExtraGalaxies) {
			systemVega.setGalaxy(gxEissentam);
		}
		starVega.setParentSolarSystem(systemVega);
		systemVega.setMainStar(starVega);
		totalSystems++;
		
		// Nova System
		systemNova.setMapPosition(new Vector3(NOVA_X, NOVA_Y, NOVA_Z));
		if (ZGPlanets.enableExtraGalaxies) {
			systemNova.setGalaxy(gxEuclid);
		}
		starNova.setParentSolarSystem(systemNova);
		systemNova.setMainStar(starNova);
		totalSystems++;
		
		ZGHelper.Log("Loaded a total of " + totalSystems + " new star systems.");
	}
	
	public static void initPlanets() {
		// Planet Zollus
		planetZollus.setDimensionInfo(ConfigManagerZG.planetZollusDimensionId, WorldProviderZollus.class);
		planetZollus.setParentSolarSystem(systemPsios);
		planetZollus.setPhaseShift(2.0F);
		planetZollus.setDistanceFromCenter(2.0F);
		planetZollus.setBodyClass(EnumBodyClass.L);
		planetZollus.setRelativeOrbitTime(32.2F);
		planetZollus.setTierRequired(ConfigManagerZG.planetZollusTier);
		if (ConfigManagerZG.planetUnreachableZollus) {
			planetZollus.setDisableRockets();
		}
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
		planetKriffon.setPhaseShift(0.0F);
		planetKriffon.setBodyClass(EnumBodyClass.Y);
		planetKriffon.setRelativeOrbitTime(0.3F);
		planetKriffon.setDistanceFromCenter(0.5F);
		planetKriffon.setTierRequired(ConfigManagerZG.planetKriffonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableKriffon) {
			planetKriffon.setDisableRockets();
		}
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
		planetPurgot.setPhaseShift(1.5F);
		planetPurgot.setRelativeOrbitTime(10F);
		planetPurgot.setDistanceFromCenter(1.5F);
		planetPurgot.setTierRequired(ConfigManagerZG.planetPurgotTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachablePurgot) {
			planetPurgot.setDisableRockets();
		}
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
		planetEden.setPhaseShift(1.0F);
		planetEden.setBodyClass(EnumBodyClass.M);
		planetEden.setRelativeOrbitTime(8.0F);
		planetEden.setDistanceFromCenter(1.0F);
		planetEden.setTierRequired(ConfigManagerZG.planetEdenTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableEden) {
			planetEden.setDisableRockets();
		}
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
		planetEden.setBiomeInfo(ZGBiomes.EDEN_GREEN_LANDS, ZGBiomes.EDEN_BLOOD_DESERT, ZGBiomes.EDEN_ROCK_MOUNTAINS, ZGBiomes.EDEN_TERRAN_VALLEY, ZGBiomes.EDEN_SNOWY_PLAINS, ZGBiomes.EDEN_GOLDEN_MEADOW, ZGBiomes.EDEN_SWAMPLANDS, ZGBiomes.EDENWOOD_FOREST, ZGBiomes.EDEN_PARADISE_WOODS, ZGBiomes.EDEN_FLOWER_GARDEN, ZGBiomes.EDEN_CRATERS, ZGBiomes.EDEN_SHROOM_HILLS,
				ZGBiomes.EDEN_OCEAN);
		totalPlanets++;
		
		// Planet Xathius
		planetXathius.setDimensionInfo(ConfigManagerZG.planetXathiusDimensionId, WorldProviderXathius.class);
		planetXathius.setParentSolarSystem(systemPraedyth);
		planetXathius.setBodyClass(EnumBodyClass.NINE);
		planetXathius.setRelativeOrbitTime(2.5F);
		planetXathius.setDistanceFromCenter(1.4F);
		planetXathius.setTierRequired(ConfigManagerZG.planetXathiusTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableXathius) {
			planetXathius.setDisableRockets();
		}
		planetXathius.setBodyTemperature(82.4f);
		planetXathius.setBodyToxicity(2.5F);
		planetXathius.setBodyRadiation(16.5F);
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
		planetOasis.setRelativeOrbitTime(6.2F);
		planetOasis.setDistanceFromCenter(1.8f);
		planetOasis.setTierRequired(ConfigManagerZG.planetOasisTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableOasis) {
			planetOasis.setDisableRockets();
		}
		planetOasis.setBodyTemperature(84.26F);
		planetOasis.setBodyToxicity(0.5F);
		planetOasis.setBodyRadiation(4.0F);
		planetOasis.setBreathable(true);
		planetOasis.setWindLevel(1.9F);
		planetOasis.setDensity(1.6F);
		planetOasis.setHasRain(true);
		planetOasis.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER);
		planetOasis.setAtmosphere();
		planetOasis.setBodyIcon("oasis");
		planetOasis.setBiomeInfo(ZGBiomes.OASIS_PLAINS, ZGBiomes.OASIS_RED_OCEAN, ZGBiomes.OASIS_BEACH, ZGBiomes.OASIS_REDLANDS, ZGBiomes.OASIS_MUDSWAMP, ZGBiomes.OASIS_DESERT);
		totalPlanets++;
		
		// Planet Xantheon
		planetXantheon.setDimensionInfo(ConfigManagerZG.planetXantheonDimensionId, WorldProviderXantheon.class);
		planetXantheon.setParentSolarSystem(systemPraedyth);
		planetXantheon.setBodyClass(EnumBodyClass.CONSTRUCTED);
		planetXantheon.setRelativeOrbitTime(20.2F);
		planetXantheon.setDistanceFromCenter(2.5F);
		planetXantheon.setTierRequired(ConfigManagerZG.planetXantheonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableXantheon) {
			planetXantheon.setDisableRockets();
		}
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
		planetCandora.setRelativeOrbitTime(10.5F);
		planetCandora.setDistanceFromCenter(2.1F);
		planetCandora.setTierRequired(ConfigManagerZG.planetCandoraTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableCandora) {
			planetCandora.setDisableRockets();
		}
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
		planetCandora.setBiomeInfo(ZGBiomes.CANDY_MOUNTAIN, ZGBiomes.CANDY_OCEAN, ZGBiomes.CANDY_JOLLY_MELON_PLAINS, ZGBiomes.CANDY_BLUEBERRY_HILLS, ZGBiomes.CANDY_COOKIE_LANDS);
		totalPlanets++;
		
		// Atheon
		planetAtheon.setDimensionInfo(ConfigManagerZG.planetAtheonDimensionId, WorldProviderAtheon.class);
		planetAtheon.setParentSolarSystem(systemPraedyth);
		planetAtheon.setBodyClass(EnumBodyClass.CONSTRUCTED);
		planetAtheon.setRelativeOrbitTime(0.6F);
		planetAtheon.setDistanceFromCenter(0.4F);
		planetAtheon.setTierRequired(ConfigManagerZG.planetAtheonTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableAtheon) {
			planetAtheon.setDisableRockets();
		}
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
		planetPerdita.setRelativeOrbitTime(1.2F);
		planetPerdita.setDistanceFromCenter(0.8F);
		planetPerdita.setTierRequired(ConfigManagerZG.planetPerditaTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachablePerdita) {
			planetPerdita.setDisableRockets();
		}
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
		planetPerdita.setBiomeInfo(ZGBiomes.PERDITA_DESERT, ZGBiomes.PERDITA_HALLOWS, ZGBiomes.PERDITA_OASIS, ZGBiomes.PERDITA_FUELTONIUM_OCEAN, ZGBiomes.PERDITA_LOST_MOUNTAINS);
		totalPlanets++;
		
		// Altum
		planetAltum.setDimensionInfo(ConfigManagerZG.planetAltumDimensionId, WorldProviderAltum.class);
		planetAltum.setParentSolarSystem(systemSol2);
		planetAltum.setBodyClass(EnumBodyClass.OCEAN);
		planetAltum.setRelativeOrbitTime(3.6F);
		planetAltum.setDistanceFromCenter(1.0F);
		planetAltum.setTierRequired(ConfigManagerZG.planetAltumTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableAltum) {
			planetAltum.setDisableRockets();
		}
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
		planetCaligro.setRelativeOrbitTime(140.18F);
		planetCaligro.setDistanceFromCenter(2.0F);
		planetCaligro.setTierRequired(ConfigManagerZG.planetCaligroTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableCaligro) {
			planetCaligro.setDisableRockets();
		}
		planetCaligro.setBodyTemperature(-165.62F);
		planetCaligro.setBodyToxicity(55.24F);
		planetCaligro.setBodyRadiation(32.21F);
		planetCaligro.setWindLevel(60.58F);
		planetCaligro.setDensity(100.32F);
		planetCaligro.setHasRain(false);
		planetCaligro.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.WATER, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.METHANE, EnumAtmosphericGas.HYDROGEN);
		planetCaligro.setBodyIcon("caligro");
		planetCaligro.setAtmosphere();
		planetCaligro.setBiomeInfo(ZGBiomes.CALIGRO_UPSIDE_DOWN, ZGBiomes.CALIGRO_CREEPLANDS, ZGBiomes.CALIGRO_ROCKY_VEINS, ZGBiomes.CALIGRO_WITHERLANDS, ZGBiomes.CALIGRO_CORRUPTED_MESA);
		totalPlanets++;
		
		// Exodus
		planetExodus.setDimensionInfo(ConfigManagerZG.planetExodusDimensionId, WorldProviderExodus.class);
		planetExodus.setParentSolarSystem(systemSol2);
		planetExodus.setBodyClass(EnumBodyClass.M);
		planetExodus.setRelativeOrbitTime(4.5F);
		planetExodus.setDistanceFromCenter(3.0F);
		planetExodus.setTierRequired(ConfigManagerZG.planetExodusTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableExodus) {
			planetExodus.setDisableRockets();
		}
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
		planetVortex.setRelativeOrbitTime(4.8F);
		planetVortex.setDistanceFromCenter(3.0F);
		planetVortex.setTierRequired(ConfigManagerZG.planetVortexTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableVortex) {
			planetVortex.setDisableRockets();
		}
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
		planetMetztli.setRelativeOrbitTime(8.0F);
		planetMetztli.setDistanceFromCenter(4.0F);
		planetMetztli.setTierRequired(ConfigManagerZG.planetMetztliTier);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableMetztli) {
			planetMetztli.setDisableRockets();
		}
		planetMetztli.setBodyTemperature(86.05F);
		planetMetztli.setDensity(10.0F);
		planetMetztli.setHasRain(true);
		planetMetztli.setBodyToxicity(5.2F);
		planetMetztli.setBodyRadiation(8.0F);
		planetMetztli.setWindLevel(25.64F);
		planetMetztli.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER);
		planetMetztli.setBodyIcon("metztli");
		planetMetztli.setAtmosphere();
		planetMetztli.setBiomeInfo(ZGBiomes.METZTLI_HARRAN_PLAINS, ZGBiomes.METZTLI_HARRAN_DUNES, ZGBiomes.METZTLI_HARRAN_OCEAN, ZGBiomes.METZTLI_HARRAN_SWAMP, ZGBiomes.METZTLI_HARRAN_TUNDRA, ZGBiomes.METZTLI_HARRAN_SHROOMS, ZGBiomes.METZTLI_HARRAN_CLAY_MESA, ZGBiomes.METZTLI_HARRAN_MARSH, ZGBiomes.METZTLI_HARRAN_FOREST, ZGBiomes.METZTLI_HARRAN_RED_DESERT,
				ZGBiomes.METZTLI_HARRAN_HILLS, ZGBiomes.METZTLI_HARRAN_CHERRY_FOREST, ZGBiomes.METZTLI_HARRAN_FRUIT_FOREST);
		totalPlanets++;
		
		// Centotl
		planetCentotl.setDimensionInfo(ConfigManagerZG.planetCentotlDimensionId, WorldProviderCentotl.class);
		planetCentotl.setParentSolarSystem(systemPantheon);
		planetCentotl.setBodyClass(EnumBodyClass.ABANDONED);
		planetCentotl.setRelativeOrbitTime(25.0F);
		planetCentotl.setDistanceFromCenter(2.0F);
		planetCentotl.setTierRequired(ConfigManagerZG.planetCentotlDimensionId);
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableCentotl) {
			planetCentotl.setDisableRockets();
		}
		planetCentotl.setBodyTemperature(96.59F);
		planetCentotl.setDensity(20.0F);
		planetCentotl.setHasRain(false);
		planetCentotl.setBodyToxicity(35.67F);
		planetCentotl.setBodyRadiation(0.0F);
		planetCentotl.setWindLevel(0.0F);
		planetCentotl.setBodyGasses(EnumAtmosphericGas.ARGON, EnumAtmosphericGas.METHANE, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.HELIUM);
		planetCentotl.setBodyIcon("centotl");
		planetCentotl.setAtmosphere();
		planetCentotl.setBiomeInfo(ZGBiomes.CENTOTL_BASE, ZGBiomes.CENTOTL_ROCKY_MOUNTAINS, ZGBiomes.CENTOTL_ENGINEERING_PLAINS, ZGBiomes.CENTOTL_CONSTRUCTS);
		totalPlanets++;
		
		// Toci
		planetToci.setDimensionInfo(ConfigManagerZG.planetTociDimensionId, WorldProviderToci.class);
		planetToci.setParentSolarSystem(systemPantheon);
		planetToci.setBodyClass(EnumBodyClass.DESERT);
		planetToci.setRelativeOrbitTime(3.5F);
		planetToci.setDistanceFromCenter(1.0F);
		planetToci.setTierRequired(ConfigManagerZG.planetTociDimensionId);
		if (ConfigManagerZG.planetUnreachableToci || ConfigManagerZG.planetUnreachableAll) {
			planetToci.setDisableRockets();
		}
		planetToci.setBodyTemperature(128.42F);
		planetToci.setDensity(0.1F);
		planetToci.setHasRain(false);
		planetToci.setBodyToxicity(0.01F);
		planetToci.setBodyRadiation(0.01F);
		planetToci.setWindLevel(5.0F);
		planetToci.setBodyGasses(EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.CO2, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.WATER);
		planetToci.setBreathable(true);
		planetToci.setAtmosphere();
		planetToci.setBiomeInfo(ZGBiomes.TOCI_BASE, ZGBiomes.TOCI_DESERT, ZGBiomes.TOCI_STAR_DESERT, ZGBiomes.TOCI_VALLEY, ZGBiomes.TOCI_MOUNTAINS);
		planetToci.setBodyIcon("toci");
		totalPlanets++;
		
		// Tlaloc
		planetTlaloc.setDimensionInfo(ConfigManagerZG.planetTlalocDimensionId, WorldProviderTlaloc.class);
		planetTlaloc.setParentSolarSystem(systemPantheon);
		planetTlaloc.setBodyClass(EnumBodyClass.CONSTRUCTED);
		planetTlaloc.setDistanceFromCenter(1.5F);
		planetTlaloc.setRelativeOrbitTime(5.0F);
		planetTlaloc.setTierRequired(ConfigManagerZG.planetTlalocTier);
		if (ConfigManagerZG.planetUnreachableTlaloc || ConfigManagerZG.planetUnreachableAll) {
			planetTlaloc.setDisableRockets();
		}
		planetTlaloc.setBodyTemperature(25.62F);
		planetTlaloc.setDensity(10.0F);
		planetTlaloc.setWindLevel(0.0F);
		planetTlaloc.setBodyGasses(EnumAtmosphericGas.ARGON, EnumAtmosphericGas.HELIUM, EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.METHANE);
		planetTlaloc.setBreathable(false);
		planetTlaloc.setAtmosphere();
		planetTlaloc.setBiomeInfo(ZGBiomes.TLALOC_BASE, ZGBiomes.TLALOC_CONSTRUCTS, ZGBiomes.TLALOC_CHROME_FOREST, ZGBiomes.TLALOC_GOLDEN_CONSTRUCTS);
		planetTlaloc.setBodyIcon("tlaloc");
		totalPlanets++;
		
		// Kronos
		planetKronos.setDimensionInfo(ConfigManagerZG.planetKronosDimensionId, WorldProviderKronos.class);
		planetKronos.setParentSolarSystem(systemOlympus);
		planetKronos.setBodyClass(EnumBodyClass.Y);
		planetKronos.setDistanceFromCenter(2.5F);
		planetKronos.setRelativeOrbitTime(24.46F);
		planetKronos.setTierRequired(ConfigManagerZG.planetKronosTier);
		if (ConfigManagerZG.planetUnreachableKronos || ConfigManagerZG.planetUnreachableAll) {
			planetKronos.setDisableRockets();
		}
		planetKronos.setBodyTemperature(260.0F);
		planetKronos.setDensity(10.0F);
		planetKronos.setWindLevel(0.0F);
		planetKronos.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER, EnumAtmosphericGas.METHANE);
		planetKronos.setBreathable(true);
		planetKronos.setHasRain(false);
		planetKronos.setAtmosphere();
		planetKronos.setBiomeInfo(ZGBiomes.KRONOS_BASE, ZGBiomes.KRONOS_SOUL_DESERT, ZGBiomes.KRONOS_BLACK_MOUNTAIN, ZGBiomes.KRONOS_DEATH_VALLEY, ZGBiomes.KRONOS_BLAZING_HILLS, ZGBiomes.KRONOS_LAVA_OCEAN, ZGBiomes.KRONOS_MAGMA_SLIMELANDS);
		planetKronos.setBodyIcon("kronos");
		totalPlanets++;
		
		// Ares
		// TODO
		planetAres.setParentSolarSystem(systemOlympus);
		planetAres.setDistanceFromCenter(2.0F);
		planetAres.setRelativeOrbitTime(24.46F);
		planetAres.setBodyIcon("ares");
		
		// Prometheus
		// TODO
		planetPrometheus.setParentSolarSystem(systemOlympus);
		planetPrometheus.setDistanceFromCenter(3.0F);
		planetPrometheus.setRelativeOrbitTime(36.76F);
		planetPrometheus.setBodyIcon("prometheus");
		
		// Icarus
		// TODO
		planetIcarus.setParentSolarSystem(systemOlympus);
		planetIcarus.setDistanceFromCenter(0.5F);
		planetIcarus.setRelativeOrbitTime(1.5F);
		planetIcarus.setBodyIcon("icarus");
		
		// Maveth
		// TODO
		planetMaveth.setDimensionInfo(ConfigManagerZG.planetMavethDimensionId, WorldProviderMaveth.class);
		planetMaveth.setParentSolarSystem(systemAsgard);
		planetMaveth.setBodyClass(EnumBodyClass.ABANDONED);
		planetMaveth.setRelativeOrbitTime(50000F);
		planetMaveth.setDistanceFromCenter(1.0F);
		planetMaveth.setRelativeOrbitTime(256.0F);
		planetMaveth.setDistanceFromCenter(1.5F);
		planetMaveth.setTierRequired(ConfigManagerZG.planetMavethTier);
		if (ConfigManagerZG.planetUnreachableMaveth || ConfigManagerZG.planetUnreachableAll) {
			planetMaveth.setDisableRockets();
		}
		planetMaveth.setBodyTemperature(-86.24F);
		planetMaveth.setDensity(10.0F);
		planetMaveth.setWindLevel(20.45F);
		planetMaveth.setBodyGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.OXYGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.WATER, EnumAtmosphericGas.METHANE);
		planetMaveth.setBreathable(true);
		planetMaveth.setHasRain(false);
		planetMaveth.setAtmosphere();
		planetMaveth.setBodyIcon("maveth");
		planetMaveth.setBiomeInfo(ZGBiomes.MAVETH_BASE);
		totalPlanets++;
		
		// Asgard
		// TODO
		planetAsgard.setParentSolarSystem(systemAsgard);
		planetAsgard.setDistanceFromCenter(0.5F);
		planetAsgard.setRelativeOrbitTime(4.3F);
		planetAsgard.setBodyIcon("asgard");
		
		// Reach
		// TODO
		planetReach.setParentSolarSystem(systemVega);
		planetReach.setDistanceFromCenter(1.0F);
		planetReach.setRelativeOrbitTime(2.0F);
		planetReach.setBodyIcon("reach");
		
		// Requiem
		// TODO
		planetRequiem.setParentSolarSystem(systemVega);
		planetRequiem.setDistanceFromCenter(1.5F);
		planetRequiem.setRelativeOrbitTime(4.0F);
		planetRequiem.setBodyIcon("requiem");
		
		// Meridian
		// TODO
		planetMeridian.setParentSolarSystem(systemVega);
		planetMeridian.setDistanceFromCenter(2.0F);
		planetMeridian.setRelativeOrbitTime(3.5F);
		planetMeridian.setBodyIcon("meridian");
		
		// Somnium
		// TODO
		planetSomnium.setParentSolarSystem(systemNova);
		planetSomnium.setDistanceFromCenter(0.5F);
		planetSomnium.setRelativeOrbitTime(1.5F);
		planetSomnium.setBodyIcon("somnium");
		
		// Primor
		// TODO
		planetPrimor.setParentSolarSystem(systemNova);
		planetPrimor.setDistanceFromCenter(1.0F);
		planetPrimor.setRelativeOrbitTime(2.0F);
		planetPrimor.setBodyIcon("primor");
		
		ZGHelper.Log("Loaded a total of " + totalPlanets + " new planets.");
	}
	
	public static void initMoons() {
		moonAstros.setDimensionInfo(ConfigManagerZG.moonAstrosDimensionId, WorldProviderAstros.class);
		moonAstros.setParentPlanet(ZGPlanets.planetEden);
		moonAstros.setMoonClass(EnumBodyClass.L);
		moonAstros.setRelativeOrbitTime(1 / 0.01F);
		moonAstros.setPhaseShift(1.0F);
		moonAstros.setRelativeSize(1.0F);
		moonAstros.setDistanceFromCenter(13F);
		moonAstros.setTierRequired(ZGPlanets.planetEden.getTierRequirement());
		if (ConfigManagerZG.planetUnreachableAll || ConfigManagerZG.planetUnreachableEden) {
			moonAstros.setDisableRockets();
		}
		moonAstros.setMoonTemperature(26.54F);
		moonAstros.setDensity(10.0F);
		moonAstros.setHasRain(false);
		moonAstros.setMoonToxicity(0.0F);
		moonAstros.setMoonRadiation(0.0F);
		moonAstros.setWindLevel(16.51F);
		moonAstros.setMoonGasses(EnumAtmosphericGas.NITROGEN, EnumAtmosphericGas.ARGON, EnumAtmosphericGas.HELIUM);
		moonAstros.setMoonIcon("astros");
		moonAstros.setAtmosphere();
		moonAstros.setBiomeInfo(ZGBiomes.ASTROS_BASE, ZGBiomes.ASTROS_ROCKIES, ZGBiomes.ASTROS_GLACIERS);
		totalMoons++;
		ZGHelper.Log("Loaded a total of " + totalMoons + " new moons.");
	}
	
	public static void registerSystems() {
		GalaxyRegistry.registerSolarSystem(systemPsios);
		GalaxyRegistry.registerSolarSystem(systemPraedyth);
		GalaxyRegistry.registerSolarSystem(systemSol2);
		GalaxyRegistry.registerSolarSystem(systemPantheon);
		GalaxyRegistry.registerSolarSystem(systemOlympus);
		GalaxyRegistry.registerSolarSystem(systemAsgard);
		GalaxyRegistry.registerSolarSystem(systemVega);
		GalaxyRegistry.registerSolarSystem(systemNova);
		
		if (!hideUnusedStarSystems) {
			// unused currently
		}
		
		ZGPlanets.registerPlanets();
	}
	
	public static void registerPlanets() {
		GalaxyRegistry.registerPlanet(planetZollus);
		GalaxyRegistry.registerPlanet(planetEden);
		GalaxyRegistry.registerPlanet(planetKriffon);
		GalaxyRegistry.registerPlanet(planetPurgot);
		//
		GalaxyRegistry.registerPlanet(planetXathius);
		GalaxyRegistry.registerPlanet(planetOasis);
		GalaxyRegistry.registerPlanet(planetXantheon);
		GalaxyRegistry.registerPlanet(planetCandora);
		GalaxyRegistry.registerPlanet(planetAtheon);
		//
		GalaxyRegistry.registerPlanet(planetPerdita);
		GalaxyRegistry.registerPlanet(planetAltum);
		GalaxyRegistry.registerPlanet(planetCaligro);
		GalaxyRegistry.registerPlanet(planetExodus);
		//
		GalaxyRegistry.registerPlanet(planetVortex);
		GalaxyRegistry.registerPlanet(planetMetztli);
		GalaxyRegistry.registerPlanet(planetCentotl);
		GalaxyRegistry.registerPlanet(planetToci);
		GalaxyRegistry.registerPlanet(planetTlaloc);
		//
		GalaxyRegistry.registerPlanet(planetKronos);
		GalaxyRegistry.registerPlanet(planetAres);
		GalaxyRegistry.registerPlanet(planetPrometheus);
		GalaxyRegistry.registerPlanet(planetIcarus);
		//
		GalaxyRegistry.registerPlanet(planetMaveth);
		GalaxyRegistry.registerPlanet(planetAsgard);
		//
		GalaxyRegistry.registerPlanet(planetReach);
		GalaxyRegistry.registerPlanet(planetMaveth);
		GalaxyRegistry.registerPlanet(planetRequiem);
		GalaxyRegistry.registerPlanet(planetMeridian);
		//
		GalaxyRegistry.registerPlanet(planetSomnium);
		GalaxyRegistry.registerPlanet(planetPrimor);
		//
		
		ZGPlanets.registerMoons();
	}
	
	public static void registerMoons() {
		GalaxyRegistry.registerMoon(moonAstros);
	}
	
	public static void registerTeleportTypes() {
		// Psios-6
		GalacticraftRegistry.registerTeleportType(WorldProviderZollus.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderKriffon.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderPurgot.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderEden.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderAstros.class, new TeleportTypeBaseZG());
		
		// Praedyth
		GalacticraftRegistry.registerTeleportType(WorldProviderXathius.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderOasis.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderXantheon.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderCandora.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderAtheon.class, new TeleportTypeBaseZG());
		
		// Sol-2
		GalacticraftRegistry.registerTeleportType(WorldProviderPerdita.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderAltum.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderCaligro.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderExodus.class, new TeleportTypeBaseZG());
		
		// Pantheon
		GalacticraftRegistry.registerTeleportType(WorldProviderVortex.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderMetztli.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderCentotl.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderToci.class, new TeleportTypeBaseZG());
		GalacticraftRegistry.registerTeleportType(WorldProviderTlaloc.class, new TeleportTypeBaseZG());
		
		// Olympus
		// TODO
		GalacticraftRegistry.registerTeleportType(WorldProviderKronos.class, new TeleportTypeBaseZG());
		// GalacticraftRegistry.registerTeleportType(WorldProviderAres.class, new
		// TeleportTypeBaseZG());
		// GalacticraftRegistry.registerTeleportType(WorldProviderPrometheus.class, new
		// TeleportTypeBaseZG());
		// GalacticraftRegistry.registerTeleportType(WorldProviderIcarus.class, new
		// TeleportTypeBaseZG());
		
		// Asgard
		// TODO
		
		// Vega
		// TODO
		
		// Nova
		// TODO
	}
}