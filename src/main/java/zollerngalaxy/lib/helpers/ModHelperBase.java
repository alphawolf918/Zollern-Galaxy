package zollerngalaxy.lib.helpers;

import net.minecraftforge.fml.common.Loader;
import cofh.CoFHCore;
import cofh.thermaldynamics.ThermalDynamics;
import cofh.thermalexpansion.ThermalExpansion;
import cofh.thermalfoundation.ThermalFoundation;
import erogenousbeef.bigreactors.common.BigReactors;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useThermalExpansion = false;
	public static boolean useThermalFoundation = false;
	public static boolean useThermalDynamics = false;
	public static boolean useExtremeReactors = false;
	public static boolean useMorePlanets = false;
	public static boolean useExtraPlanets = false;
	public static boolean usePlanetProgression = false;
	
	public static void detectMods() {
		useCofh = isModLoaded(CoFHCore.MOD_ID);
		useThermalExpansion = isModLoaded(ThermalExpansion.MOD_ID);
		useThermalFoundation = isModLoaded(ThermalFoundation.MOD_ID);
		useThermalDynamics = isModLoaded(ThermalDynamics.MOD_ID);
		useExtremeReactors = isModLoaded(BigReactors.MODID);
		useMorePlanets = isModLoaded("moreplanets");
		useExtraPlanets = isModLoaded("extraplanets");
		usePlanetProgression = isModLoaded("planetprogression");
	}
	
	public static boolean isModLoaded(String modId) {
		boolean isLoaded = Loader.isModLoaded(modId);
		String strDetectedMod = (isLoaded) ? "Detected mod: " + modId : "Could not detect mod: "
				+ modId;
		ZGHelper.Log(strDetectedMod);
		return isLoaded;
	}
	
}