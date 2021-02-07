/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.core.util.WorldUtil;
import net.minecraft.world.DimensionType;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitAltum;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitAtheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitCaligro;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitCandora;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitEden;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitExodus;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitKriffon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitOasis;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPerdita;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitPurgot;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitVortex;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXantheon;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitXathius;
import zollerngalaxy.core.dimensions.worldproviders.orbit.WorldProviderOrbitZollus;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGDimensions {
	
	// Psion-6
	public static DimensionType ZOLLUS;
	public static DimensionType ZOLLUS_ORBIT;
	public static DimensionType ZOLLUS_ORBIT_STATIC;
	
	public static DimensionType KRIFFON;
	public static DimensionType KRIFFON_ORBIT;
	public static DimensionType KRIFFON_ORBIT_STATIC;
	
	public static DimensionType EDEN;
	public static DimensionType EDEN_ORBIT;
	public static DimensionType EDEN_ORBIT_STATIC;
	
	public static DimensionType PURGOT;
	public static DimensionType PURGOT_ORBIT;
	public static DimensionType PURGOT_ORBIT_STATIC;
	
	public static DimensionType ASTROS; // Unused
	
	// Praedyth
	public static DimensionType XATHIUS;
	public static DimensionType XATHIUS_ORBIT;
	public static DimensionType XATHIUS_ORBIT_STATIC;
	
	public static DimensionType OASIS;
	public static DimensionType OASIS_ORBIT;
	public static DimensionType OASIS_ORBIT_STATIC;
	
	public static DimensionType XANTHEON;
	public static DimensionType XANTHEON_ORBIT;
	public static DimensionType XANTHEON_ORBIT_STATIC;
	
	public static DimensionType CANDORA;
	public static DimensionType CANDORA_ORBIT;
	public static DimensionType CANDORA_ORBIT_STATIC;
	
	public static DimensionType ATHEON;
	public static DimensionType ATHEON_ORBIT;
	public static DimensionType ATHEON_ORBIT_STATIC;
	
	// Sol-2
	public static DimensionType PERDITA;
	public static DimensionType PERDITA_ORBIT;
	public static DimensionType PERDITA_ORBIT_STATIC;
	
	public static DimensionType ALTUM;
	public static DimensionType ALTUM_ORBIT;
	public static DimensionType ALTUM_ORBIT_STATIC;
	
	public static DimensionType CALIGRO;
	public static DimensionType CALIGRO_ORBIT;
	public static DimensionType CALIGRO_ORBIT_STATIC;
	
	public static DimensionType EXODUS;
	public static DimensionType EXODUS_ORBIT;
	public static DimensionType EXODUS_ORBIT_STATIC;
	
	public static DimensionType VORTEX;
	public static DimensionType VORTEX_ORBIT;
	public static DimensionType VORTEX_ORBIT_STATIC;
	
	public static void init() {
		// Psion-6 (Zollus)
		ZGDimensions.ZOLLUS = ZGDimensions.getDimType(ConfigManagerZG.planetZollusDimensionId);
		ZGDimensions.ZOLLUS_ORBIT = DimensionType.register("Zollus Space Station", "_zollus_orbit", ConfigManagerZG.spaceStationZollusId, WorldProviderOrbitZollus.class,
				false);
		ZGDimensions.ZOLLUS_ORBIT_STATIC = DimensionType.register("Zollus Space Station", "_zollus_orbit", ConfigManagerZG.spaceStationZollusStaticId,
				WorldProviderOrbitZollus.class, true);
		
		// Psion-6 (Kriffon)
		ZGDimensions.KRIFFON = ZGDimensions.getDimType(ConfigManagerZG.planetKriffonDimensionId);
		ZGDimensions.KRIFFON_ORBIT = DimensionType.register("Kriffon Space Station", "_kriffon_orbit", ConfigManagerZG.spaceStationKriffonId,
				WorldProviderOrbitKriffon.class, false);
		ZGDimensions.KRIFFON_ORBIT_STATIC = DimensionType.register("Kriffon Space Station", "_kriffon_orbit", ConfigManagerZG.spaceStationKriffonStaticId,
				WorldProviderOrbitKriffon.class, true);
		
		// Psion-6 (Purgot)
		ZGDimensions.PURGOT = ZGDimensions.getDimType(ConfigManagerZG.planetPurgotDimensionId);
		ZGDimensions.PURGOT_ORBIT = DimensionType.register("Purgot Space Station", "_purgot_orbit", ConfigManagerZG.spaceStationPurgotId, WorldProviderOrbitPurgot.class,
				false);
		ZGDimensions.PURGOT_ORBIT_STATIC = DimensionType.register("Purgot Space Station", "_purgot_orbit", ConfigManagerZG.spaceStationPurgotStaticId,
				WorldProviderOrbitPurgot.class, true);
		
		// Psion-6 (Eden)
		ZGDimensions.EDEN = ZGDimensions.getDimType(ConfigManagerZG.planetEdenDimensionId);
		ZGDimensions.EDEN_ORBIT = DimensionType.register("Eden Space Station", "_eden_orbit", ConfigManagerZG.spaceStationEdenId, WorldProviderOrbitEden.class, false);
		ZGDimensions.EDEN_ORBIT_STATIC = DimensionType.register("Eden Space Station", "_eden_orbit", ConfigManagerZG.spaceStationEdenStaticId,
				WorldProviderOrbitEden.class, true);
		
		// Praedyth (Xathius)
		ZGDimensions.XATHIUS = ZGDimensions.getDimType(ConfigManagerZG.planetXathiusDimensionId);
		ZGDimensions.XATHIUS_ORBIT = DimensionType.register("Xathius Space Station", "_xathius_orbit", ConfigManagerZG.spaceStationXathiusId,
				WorldProviderOrbitXathius.class, false);
		ZGDimensions.XATHIUS_ORBIT_STATIC = DimensionType.register("Xathius Space Station", "_xathius_orbit", ConfigManagerZG.spaceStationXathiusStaticId,
				WorldProviderOrbitXathius.class, true);
		
		// Praedyth (Oasis)
		ZGDimensions.OASIS = ZGDimensions.getDimType(ConfigManagerZG.planetOasisDimensionId);
		ZGDimensions.OASIS_ORBIT = DimensionType.register("Oasis Space Station", "_oasis_orbit", ConfigManagerZG.spaceStationOasisId, WorldProviderOrbitOasis.class,
				false);
		ZGDimensions.OASIS_ORBIT_STATIC = DimensionType.register("Oasis Space Station", "_oasis_orbit", ConfigManagerZG.spaceStationOasisStaticId,
				WorldProviderOrbitOasis.class, true);
		
		// Praedyth (Xantheon)
		ZGDimensions.XANTHEON = ZGDimensions.getDimType(ConfigManagerZG.planetXantheonDimensionId);
		ZGDimensions.XANTHEON_ORBIT = DimensionType.register("Xantheon Space Station", "_xantheon_orbit", ConfigManagerZG.spaceStationXantheonId,
				WorldProviderOrbitXantheon.class, false);
		ZGDimensions.XANTHEON_ORBIT_STATIC = DimensionType.register("Xantheon Space Station", "_xantheon_orbit", ConfigManagerZG.spaceStationXantheonStaticId,
				WorldProviderOrbitXantheon.class, true);
		
		// Praedyth (Candora)
		ZGDimensions.CANDORA = ZGDimensions.getDimType(ConfigManagerZG.planetCandoraDimensionId);
		ZGDimensions.CANDORA_ORBIT = DimensionType.register("Candora Space Station", "_candora_orbit", ConfigManagerZG.spaceStationCandoraId,
				WorldProviderOrbitCandora.class, false);
		ZGDimensions.CANDORA_ORBIT_STATIC = DimensionType.register("Candora Space Station", "_candora_orbit", ConfigManagerZG.spaceStationCandoraStaticId,
				WorldProviderOrbitCandora.class, true);
		
		// Praedyth (Atheon)
		ZGDimensions.ATHEON = ZGDimensions.getDimType(ConfigManagerZG.planetAtheonDimensionId);
		ZGDimensions.ATHEON_ORBIT = DimensionType.register("Atheon Space Station", "_atheon_orbit", ConfigManagerZG.spaceStationAtheonId, WorldProviderOrbitAtheon.class,
				false);
		ZGDimensions.ATHEON_ORBIT_STATIC = DimensionType.register("Atheon Space Station", "_atheon_orbit", ConfigManagerZG.spaceStationAtheonStaticId,
				WorldProviderOrbitAtheon.class, true);
		
		// Sol-2 (Perdita)
		ZGDimensions.PERDITA = ZGDimensions.getDimType(ConfigManagerZG.planetPerditaDimensionId);
		ZGDimensions.PERDITA_ORBIT = DimensionType.register("Perdita Space Station", "_perdita_orbit", ConfigManagerZG.spaceStationPerditaId,
				WorldProviderOrbitPerdita.class, false);
		ZGDimensions.PERDITA_ORBIT_STATIC = DimensionType.register("Perdita Space Station", "_perdita_orbit", ConfigManagerZG.spaceStationPerditaStaticId,
				WorldProviderOrbitPerdita.class, true);
		
		// Sol-2 (Altum)
		ZGDimensions.ALTUM = ZGDimensions.getDimType(ConfigManagerZG.planetAltumDimensionId);
		ZGDimensions.ALTUM_ORBIT = DimensionType.register("Altum Space Station", "_altum_orbit", ConfigManagerZG.spaceStationAltumId, WorldProviderOrbitAltum.class,
				false);
		ZGDimensions.ALTUM_ORBIT_STATIC = DimensionType.register("Altum Space Station", "_altum_orbit", ConfigManagerZG.spaceStationAltumStaticId,
				WorldProviderOrbitAltum.class, true);
		
		// Sol-2 (Caligro)
		ZGDimensions.CALIGRO = ZGDimensions.getDimType(ConfigManagerZG.planetCaligroDimensionId);
		ZGDimensions.CALIGRO_ORBIT = DimensionType.register("Caligro Space Station", "_caligro_orbit", ConfigManagerZG.spaceStationCaligroId,
				WorldProviderOrbitCaligro.class, false);
		ZGDimensions.CALIGRO_ORBIT_STATIC = DimensionType.register("Caligro Space Station", "_caligro_orbit", ConfigManagerZG.spaceStationCaligroStaticId,
				WorldProviderOrbitCaligro.class, true);
		
		// Sol-2 (Exodus)
		ZGDimensions.EXODUS = ZGDimensions.getDimType(ConfigManagerZG.planetExodusDimensionId);
		ZGDimensions.EXODUS_ORBIT = DimensionType.register("Exodus Space Station", "_exodus_orbit", ConfigManagerZG.spaceStationExodusId, WorldProviderOrbitExodus.class,
				false);
		ZGDimensions.EXODUS_ORBIT_STATIC = DimensionType.register("Exodus Space Station", "_exodus_orbit", ConfigManagerZG.spaceStationExodusStaticId,
				WorldProviderOrbitExodus.class, true);
		
		// Pantheon (Vortex)
		ZGDimensions.VORTEX = ZGDimensions.getDimType(ConfigManagerZG.planetVortexDimensionId);
		ZGDimensions.VORTEX_ORBIT = DimensionType.register("Vortex Space Station", "_vortex_orbit", ConfigManagerZG.spaceStationVortexId, WorldProviderOrbitVortex.class,
				false);
		ZGDimensions.VORTEX_ORBIT_STATIC = DimensionType.register("Vortex Space Station", "_vortex_orbit", ConfigManagerZG.spaceStationVortexStaticId,
				WorldProviderOrbitVortex.class, true);
	}
	
	public static DimensionType getDimType(int dimId) {
		return WorldUtil.getDimensionTypeById(dimId);
	}
	
	public static CelestialBody getCelestialBodyByID(int dimID) {
		CelestialBody body = null;
		if (dimID == ConfigManagerZG.planetZollusDimensionId) {
			body = ZGPlanets.planetZollus;
		} else if (dimID == ConfigManagerZG.planetKriffonDimensionId) {
			body = ZGPlanets.planetKriffon;
		} else if (dimID == ConfigManagerZG.planetPurgotDimensionId) {
			body = ZGPlanets.planetPurgot;
		} else if (dimID == ConfigManagerZG.planetEdenDimensionId) {
			body = ZGPlanets.planetEden;
		} else if (dimID == ConfigManagerZG.planetXathiusDimensionId) {
			body = ZGPlanets.planetXathius;
		} else if (dimID == ConfigManagerZG.planetOasisDimensionId) {
			body = ZGPlanets.planetOasis;
		} else if (dimID == ConfigManagerZG.planetXantheonDimensionId) {
			body = ZGPlanets.planetXantheon;
		} else if (dimID == ConfigManagerZG.planetCandoraDimensionId) {
			body = ZGPlanets.planetCandora;
		} else if (dimID == ConfigManagerZG.planetAtheonDimensionId) {
			body = ZGPlanets.planetAtheon;
		} else if (dimID == ConfigManagerZG.planetPerditaDimensionId) {
			body = ZGPlanets.planetPerdita;
		} else if (dimID == ConfigManagerZG.planetAltumDimensionId) {
			body = ZGPlanets.planetAltum;
		} else if (dimID == ConfigManagerZG.planetCaligroDimensionId) {
			body = ZGPlanets.planetCaligro;
		} else if (dimID == ConfigManagerZG.planetExodusDimensionId) {
			body = ZGPlanets.planetExodus;
		} else if (dimID == ConfigManagerZG.planetVortexDimensionId) {
			body = ZGPlanets.planetVortex;
		}
		
		if (body == null) {
			ZGHelper.LogErr("Celestial Body was null.");
		}
		
		return body;
	}
}