/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.tlaloc;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.WorldGenZGTree2;

public class WorldGenMechTree extends WorldGenZGTree2 {
	
	public WorldGenMechTree() {
		super(ZGBlocks.xantheonConstructBlock.getDefaultState(), ZGBlocks.tlalocMechRock.getDefaultState());
	}
	
	@Override
	protected boolean isValidSpawn(World world, BlockPos pos) {
		if (!super.isValidSpawn(world, pos)) {
			return false;
		}
		
		IBlockState state = world.getBlockState(pos.down());
		
		if (state == Blocks.AIR.getDefaultState() || state == ZGBlocks.tlalocMechRock || state == ZGBlocks.xantheonConstructBlock) {
			return false;
		}
		
		return true;
	}
}