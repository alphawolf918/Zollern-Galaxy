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
import zollerngalaxy.tileentities.TileEntityTier10TreasureChestZG;

public class ZGBlockTreasureChestTier10 extends ZGBlockTreasureChest {
	
	public ZGBlockTreasureChestTier10() {
		super("treasure_chest_tlaloc");
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTier10TreasureChestZG();
	}
}