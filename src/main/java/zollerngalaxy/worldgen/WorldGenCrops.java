/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.helpers.ZGHelper;

public class WorldGenCrops extends ZGWorldGenMaster {
	
	protected IBlockState blockCropState;
	protected IBlockState farmlandState = Blocks.FARMLAND.getDefaultState();
	protected IBlockState waterState = Blocks.WATER.getDefaultState();
	protected IBlockState dirtState = Blocks.DIRT.getDefaultState();
	protected IBlockState airState = Blocks.AIR.getDefaultState();
	
	public WorldGenCrops(IBlockState cropBlockStateIn) {
		this.blockCropState = cropBlockStateIn;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		this.setBlock(world, position.add(1, 0, 1), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 1), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 2), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 3), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 4), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 5), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 6), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 7), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 8), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 9), this.farmlandState);
		this.setBlock(world, position.add(1, 0, 10), this.farmlandState);
		this.setBlock(world, position.add(2, 0, 1), this.farmlandState);
		this.setBlock(world, position.add(2, 0, 10), this.farmlandState);
		
		this.setBlock(world, position.add(2, 0, 2), this.waterState);
		this.setBlock(world, position.add(2, 0, 3), this.waterState);
		this.setBlock(world, position.add(2, 0, 4), this.waterState);
		this.setBlock(world, position.add(2, 0, 5), this.waterState);
		this.setBlock(world, position.add(2, 0, 6), this.waterState);
		this.setBlock(world, position.add(2, 0, 7), this.waterState);
		this.setBlock(world, position.add(2, 0, 8), this.waterState);
		this.setBlock(world, position.add(2, 0, 9), this.waterState);
		
		this.setBlock(world, position.add(2, 1, 2), this.airState);
		this.setBlock(world, position.add(2, 1, 3), this.airState);
		this.setBlock(world, position.add(2, 1, 4), this.airState);
		this.setBlock(world, position.add(2, 1, 5), this.airState);
		this.setBlock(world, position.add(2, 1, 6), this.airState);
		this.setBlock(world, position.add(2, 1, 7), this.airState);
		this.setBlock(world, position.add(2, 1, 8), this.airState);
		this.setBlock(world, position.add(2, 1, 9), this.airState);
		
		this.setBlock(world, position.add(2, 0, 10), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 1), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 2), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 3), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 4), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 5), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 6), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 7), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 8), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 9), this.farmlandState);
		this.setBlock(world, position.add(3, 0, 10), this.farmlandState);
		
		this.setBlock(world, position.add(1, 1, 1), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 2), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 3), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 4), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 5), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 6), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 7), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 8), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 9), this.blockCropState);
		this.setBlock(world, position.add(1, 1, 10), this.blockCropState);
		this.setBlock(world, position.add(2, 1, 1), this.blockCropState);
		this.setBlock(world, position.add(2, 1, 10), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 1), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 2), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 3), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 4), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 5), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 6), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 7), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 8), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 9), this.blockCropState);
		this.setBlock(world, position.add(3, 1, 10), this.blockCropState);
		
		this.setBlock(world, position.add(1, 2, 1), this.airState);
		this.setBlock(world, position.add(1, 2, 2), this.airState);
		this.setBlock(world, position.add(1, 2, 3), this.airState);
		this.setBlock(world, position.add(1, 2, 4), this.airState);
		this.setBlock(world, position.add(1, 2, 5), this.airState);
		this.setBlock(world, position.add(1, 2, 6), this.airState);
		this.setBlock(world, position.add(1, 2, 7), this.airState);
		this.setBlock(world, position.add(1, 2, 8), this.airState);
		this.setBlock(world, position.add(1, 2, 9), this.airState);
		this.setBlock(world, position.add(1, 2, 10), this.airState);
		this.setBlock(world, position.add(2, 2, 1), this.airState);
		this.setBlock(world, position.add(2, 2, 10), this.airState);
		this.setBlock(world, position.add(3, 2, 1), this.airState);
		this.setBlock(world, position.add(3, 2, 2), this.airState);
		this.setBlock(world, position.add(3, 2, 3), this.airState);
		this.setBlock(world, position.add(3, 2, 4), this.airState);
		this.setBlock(world, position.add(3, 2, 5), this.airState);
		this.setBlock(world, position.add(3, 2, 6), this.airState);
		this.setBlock(world, position.add(3, 2, 7), this.airState);
		this.setBlock(world, position.add(3, 2, 8), this.airState);
		this.setBlock(world, position.add(3, 2, 9), this.airState);
		this.setBlock(world, position.add(3, 2, 10), this.airState);
		
		this.setBlock(world, position.add(1, -1, 1), this.dirtState);
		this.setBlock(world, position.add(1, -1, 2), this.dirtState);
		this.setBlock(world, position.add(1, -1, 3), this.dirtState);
		this.setBlock(world, position.add(1, -1, 4), this.dirtState);
		this.setBlock(world, position.add(1, -1, 5), this.dirtState);
		this.setBlock(world, position.add(1, -1, 6), this.dirtState);
		this.setBlock(world, position.add(1, -1, 7), this.dirtState);
		this.setBlock(world, position.add(1, -1, 8), this.dirtState);
		this.setBlock(world, position.add(1, -1, 9), this.dirtState);
		this.setBlock(world, position.add(1, -1, 10), this.dirtState);
		this.setBlock(world, position.add(2, -1, 1), this.dirtState);
		this.setBlock(world, position.add(2, -1, 2), this.dirtState);
		this.setBlock(world, position.add(2, -1, 3), this.dirtState);
		this.setBlock(world, position.add(2, -1, 4), this.dirtState);
		this.setBlock(world, position.add(2, -1, 5), this.dirtState);
		this.setBlock(world, position.add(2, -1, 6), this.dirtState);
		this.setBlock(world, position.add(2, -1, 7), this.dirtState);
		this.setBlock(world, position.add(2, -1, 8), this.dirtState);
		this.setBlock(world, position.add(2, -1, 9), this.dirtState);
		this.setBlock(world, position.add(2, -1, 10), this.dirtState);
		this.setBlock(world, position.add(3, -1, 1), this.dirtState);
		this.setBlock(world, position.add(3, -1, 2), this.dirtState);
		this.setBlock(world, position.add(3, -1, 3), this.dirtState);
		this.setBlock(world, position.add(3, -1, 4), this.dirtState);
		this.setBlock(world, position.add(3, -1, 5), this.dirtState);
		this.setBlock(world, position.add(3, -1, 6), this.dirtState);
		this.setBlock(world, position.add(3, -1, 7), this.dirtState);
		this.setBlock(world, position.add(3, -1, 8), this.dirtState);
		this.setBlock(world, position.add(3, -1, 9), this.dirtState);
		this.setBlock(world, position.add(3, -1, 10), this.dirtState);
		
		this.setBlock(world, position.add(1, -1, 1), this.dirtState);
		this.setBlock(world, position.add(1, -1, 2), this.dirtState);
		this.setBlock(world, position.add(1, -1, 3), this.dirtState);
		this.setBlock(world, position.add(1, -1, 4), this.dirtState);
		this.setBlock(world, position.add(1, -1, 5), this.dirtState);
		this.setBlock(world, position.add(1, -1, 6), this.dirtState);
		this.setBlock(world, position.add(1, -1, 7), this.dirtState);
		this.setBlock(world, position.add(1, -1, 8), this.dirtState);
		this.setBlock(world, position.add(1, -1, 9), this.dirtState);
		this.setBlock(world, position.add(1, -1, 10), this.dirtState);
		this.setBlock(world, position.add(2, -1, 1), this.dirtState);
		this.setBlock(world, position.add(2, -1, 10), this.dirtState);
		this.setBlock(world, position.add(3, -1, 1), this.dirtState);
		this.setBlock(world, position.add(3, -1, 2), this.dirtState);
		this.setBlock(world, position.add(3, -1, 3), this.dirtState);
		this.setBlock(world, position.add(3, -1, 4), this.dirtState);
		this.setBlock(world, position.add(3, -1, 5), this.dirtState);
		this.setBlock(world, position.add(3, -1, 6), this.dirtState);
		this.setBlock(world, position.add(3, -1, 7), this.dirtState);
		this.setBlock(world, position.add(3, -1, 8), this.dirtState);
		this.setBlock(world, position.add(3, -1, 9), this.dirtState);
		this.setBlock(world, position.add(3, -1, 10), this.dirtState);
		
		if (ZollernGalaxyCore.instance().isInTestMode()) {
			ZGHelper.Log("CROPS: " + this.getSpawnedAtString(position));
		}
		
		return true;
	}
}