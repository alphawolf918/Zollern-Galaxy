/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.eden;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenEdenPumpkins extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		for (int i = 0; i < 64; ++i) {
			int x = rand.nextInt(8) - rand.nextInt(8);
			int y = rand.nextInt(4) - rand.nextInt(4);
			int z = rand.nextInt(8) - rand.nextInt(8);
			BlockPos blockpos = position.add(x, y, z);
			IBlockState state = worldIn.getBlockState(blockpos.down());
			Block block = state.getBlock();
			Block pumpkin = Blocks.PUMPKIN;
			IBlockState pumpkinState = pumpkin.getDefaultState();
			IBlockState pumpkinModState = pumpkinState.withProperty(BlockPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(rand));
			boolean isGrassOrDirt = (block instanceof ZGBlockGrass || block instanceof ZGBlockDirt);
			if (worldIn.isAirBlock(blockpos) && isGrassOrDirt && pumpkin.canPlaceBlockAt(worldIn, blockpos)) {
				worldIn.setBlockState(blockpos, pumpkinModState, 2);
			}
		}
		return true;
	}
}