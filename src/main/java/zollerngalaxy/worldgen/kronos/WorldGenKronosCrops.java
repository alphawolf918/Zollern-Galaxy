/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.kronos;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.WorldGenCrops;

public class WorldGenKronosCrops extends WorldGenCrops {
	
	public WorldGenKronosCrops(IBlockState cropBlockStateIn) {
		super(cropBlockStateIn);
		this.farmlandState = Blocks.SOUL_SAND.getDefaultState();
		this.dirtState = ZGBlocks.netherDirt.getDefaultState();
	}
}