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

package galaxymod.blocks.renderers;

import galaxymod.blocks.renderers.eden.TileEntityRendererEdenTreasureChest;
import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import cpw.mods.fml.client.registry.ClientRegistry;

public class TileEntityRendererNG {
	
	public static void registerTileEntityRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityTreasureChestEden.class,
				new TileEntityRendererEdenTreasureChest());
	}
}