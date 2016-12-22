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

package galaxymod.commands;

import galaxymod.utils.ZGHelper;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommandList {
	
	static int totalCommands = 0;
	
	public static void init(FMLServerStartingEvent event) {
		
		ZGHelper.echo("Loaded a total of " + totalCommands + " commands.");
	}
}