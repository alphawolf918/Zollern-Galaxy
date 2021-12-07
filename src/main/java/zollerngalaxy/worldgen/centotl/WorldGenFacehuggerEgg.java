/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.centotl;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenFacehuggerEgg extends ZGWorldGenMaster {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int x = position.getX();
		int y = position.getY();
		int z = position.getZ();
		
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		BlockPos pos = new BlockPos(x, y, z);
		
		IBlockState facehuggerEgg = ZGBlocks.facehuggerEgg.getDefaultState();
		IBlockState web = Blocks.WEB.getDefaultState();
		IBlockState air = Blocks.AIR.getDefaultState();
		
		this.setBlock(world, pos, facehuggerEgg);
		this.setBlock(world, new BlockPos(x, y, z), facehuggerEgg);
		this.setBlock(world, new BlockPos(x + 1, y, z), web);
		this.setBlock(world, new BlockPos(x - 1, y, z), web);
		this.setBlock(world, new BlockPos(x + 1, y, z + 1), web);
		this.setBlock(world, new BlockPos(x - 1, y, z - 1), web);
		this.setBlock(world, new BlockPos(x, y, z + 1), web);
		this.setBlock(world, new BlockPos(x, y, z - 1), web);
		this.setBlock(world, new BlockPos(x - 1, y, z + 1), web);
		this.setBlock(world, new BlockPos(x + 1, y, z - 1), web);
		this.setBlock(world, new BlockPos(x, y + 1, z), air);
		this.setBlock(world, new BlockPos(x, y + 1, z), air);
		this.setBlock(world, new BlockPos(x + 1, y + 1, z), air);
		this.setBlock(world, new BlockPos(x - 1, y + 1, z), air);
		this.setBlock(world, new BlockPos(x + 1, y + 1, z + 1), air);
		this.setBlock(world, new BlockPos(x - 1, y + 1, z - 1), air);
		this.setBlock(world, new BlockPos(x, y + 1, z + 1), air);
		this.setBlock(world, new BlockPos(x, y + 1, z - 1), air);
		this.setBlock(world, new BlockPos(x - 1, y + 1, z + 1), air);
		this.setBlock(world, new BlockPos(x + 1, y + 1, z - 1), air);
		
		// ZGHelper.Log(this.getSpawnedAtString(pos));
		
		return true;
	}
}