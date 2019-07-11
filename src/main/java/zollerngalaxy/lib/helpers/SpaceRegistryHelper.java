package zollerngalaxy.lib.helpers;

import java.util.ArrayList;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;

public class SpaceRegistryHelper {
	
	public static void setAtmosphereComponentList(Planet celestial,
			ArrayList<EnumAtmosphericGas> gasList) {
		for (EnumAtmosphericGas gas : gasList) {
			celestial.atmosphereComponent(gas);
		}
	}
	
	public static void setAtmosphereComponentList(Moon celestial, EnumAtmosphericGas... gasList) {
		for (EnumAtmosphericGas gas : gasList) {
			celestial.atmosphereComponent(gas);
		}
	}
}