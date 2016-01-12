/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.commands;

import galaxymod.utils.NovaHelper;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandList {
	
	static int totalCommands = 0;
	
	public static void init(FMLServerStartingEvent event) {
		
		NovaHelper.echo("Loaded a total of " + totalCommands + " commands.");
	}
}