/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.toci;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenWandererHouse extends ZGWorldGenMaster {
	
	IBlockState wallBlockState = null;
	IBlockState floorBlockState = null;
	
	public WorldGenWandererHouse() {
		
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
		if (!this.isValidSpawn(worldIn, position)) {
			return false;
		}
		
		this.setBlock(worldIn, position.add(0, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 0, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 0, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 0, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 1, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 1, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 1, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 2), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(1, 2, 1), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(1, 2, 2), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(1, 2, 3), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(1, 2, 4), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(1, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(2, 2, 1), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(2, 2, 2), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(2, 2, 3), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(2, 2, 4), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(2, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(3, 2, 1), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(3, 2, 2), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(3, 2, 3), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(3, 2, 4), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(3, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(4, 2, 1), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(4, 2, 2), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(4, 2, 3), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(4, 2, 4), ZGBlocks.tociStoneBricks);
		this.setBlock(worldIn, position.add(4, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 2), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 0, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 2), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 1, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 0), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 1), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 2), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 3), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 4), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(5, 2, 5), ZGBlocks.tociRock);
		this.setBlock(worldIn, position.add(0, 0, 2), Blocks.DARK_OAK_DOOR);
		// ZGHelper.Log("Wanderer House spawned at: " + this.getSpawnedAtString(position));
		return true;
	}
}