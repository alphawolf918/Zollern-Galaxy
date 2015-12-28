/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.lib;

import org.apache.logging.log4j.Level;
import cpw.mods.fml.relauncher.FMLRelaunchLog;

public class LoggerUtilNova {
	
	public static void info(String message) {
		FMLRelaunchLog.log("More Planets", Level.INFO, message);
	}
	
	public static void severe(String message) {
		FMLRelaunchLog.log("More Planets", Level.ERROR, message);
	}
}