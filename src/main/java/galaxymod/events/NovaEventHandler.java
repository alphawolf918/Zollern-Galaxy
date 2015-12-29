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

package galaxymod.events;

import net.minecraftforge.common.MinecraftForge;

public class NovaEventHandler {
	public static void init() {
		MinecraftForge.EVENT_BUS.register(new NovaEvents());
	}
}