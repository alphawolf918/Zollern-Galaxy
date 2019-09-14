package zollerngalaxy.lib.helpers;

import net.minecraftforge.fml.common.Loader;

public class ModHelperBase {
	
	public static boolean useCofh = false;
	public static boolean useThermalExpansion = false;
	public static boolean useThermalFoundation = false;
	public static boolean useThermalDynamics = false;
	public static boolean useExtremeReactors = false;
	public static boolean useMorePlanets = false;
	public static boolean useExtraPlanets = false;
	public static boolean usePlanetProgression = false;
	public static boolean useModularPowerSuits = false;
	
	public static void detectMods() {
		useCofh = isModLoaded("cofhcore");
		useThermalExpansion = isModLoaded("thermalexpansion");
		useThermalFoundation = isModLoaded("thermalfoundation");
		useThermalDynamics = isModLoaded("thermaldynamics");
		useExtremeReactors = isModLoaded("bigreactors");
		useMorePlanets = isModLoaded("moreplanets");
		useExtraPlanets = isModLoaded("extraplanets");
		usePlanetProgression = isModLoaded("planetprogression");
		useModularPowerSuits = isModLoaded("powersuits");
	}
	
	public static boolean isModLoaded(String modId) {
		boolean isLoaded = Loader.isModLoaded(modId);
		String strDetectedMod = (isLoaded) ? "Detected mod: " + modId : "Could not detect mod: " + modId;
		ZGHelper.Log(strDetectedMod);
		return isLoaded;
	}
	
}