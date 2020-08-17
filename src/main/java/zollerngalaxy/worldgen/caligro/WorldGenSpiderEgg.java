/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.caligro;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenSpiderEgg extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		IBlockState spiderEgg = ZGBlocks.spiderlingEgg.getDefaultState();
		IBlockState web = Blocks.WEB.getDefaultState();
		
		world.setBlockState(new BlockPos(x, y, z), spiderEgg);
		world.setBlockState(new BlockPos(x + 1, y, z), web);
		world.setBlockState(new BlockPos(x - 1, y, z), web);
		world.setBlockState(new BlockPos(x + 1, y, z + 1), web);
		world.setBlockState(new BlockPos(x - 1, y, z - 1), web);
		world.setBlockState(new BlockPos(x, y, z + 1), web);
		world.setBlockState(new BlockPos(x, y, z - 1), web);
		world.setBlockState(new BlockPos(x - 1, y, z + 1), web);
		world.setBlockState(new BlockPos(x + 1, y, z - 1), web);
		
		return true;
	}
}