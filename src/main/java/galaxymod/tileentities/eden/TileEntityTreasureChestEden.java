/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.tileentities.eden;

import galaxymod.blocks.BlockList;
import galaxymod.tileentities.TileEntityTreasureChestNG;
import net.minecraft.block.Block;

public class TileEntityTreasureChestEden extends TileEntityTreasureChestNG {
	
	public TileEntityTreasureChestEden() {
		super(3);
	}
	
	@Override
	public int getTreasureChestTier() {
		return 3;
	}
	
	@Override
	public Block getTreasureChestBlock() {
		return BlockList.edenTreasureChest;
	}
	
	@Override
	public String getTreasureChestName() {
		return "eden";
	}
	
}