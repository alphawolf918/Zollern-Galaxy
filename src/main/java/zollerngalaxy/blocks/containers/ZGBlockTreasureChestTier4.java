/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.containers;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import zollerngalaxy.tileentities.TileEntityTier4TreasureChestZG;

public class ZGBlockTreasureChestTier4 extends ZGBlockTreasureChest {
	
	public ZGBlockTreasureChestTier4(String assetName) {
		super(assetName);
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTier4TreasureChestZG();
	}
}