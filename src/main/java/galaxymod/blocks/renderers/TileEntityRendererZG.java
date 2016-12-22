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

package galaxymod.blocks.renderers;

import galaxymod.blocks.renderers.eden.TileEntityRendererEdenTreasureChest;
import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import cpw.mods.fml.client.registry.ClientRegistry;

public class TileEntityRendererZG {
	
	public static void registerTileEntityRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(
				TileEntityTreasureChestEden.class,
				new TileEntityRendererEdenTreasureChest());
	}
}