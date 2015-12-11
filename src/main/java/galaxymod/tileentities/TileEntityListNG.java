/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.tileentities;

import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityListNG {
	
	public static void init() {
		GameRegistry.registerTileEntity(TileEntityTreasureChestEden.class,
				"EdenTreasureChest");
	}
}