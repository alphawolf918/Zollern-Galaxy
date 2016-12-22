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

package galaxymod.events;

import net.minecraftforge.common.MinecraftForge;

public class ZGEventHandler {
	
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new ZGEvents());
	}
}