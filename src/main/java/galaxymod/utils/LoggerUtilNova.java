/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.utils;

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