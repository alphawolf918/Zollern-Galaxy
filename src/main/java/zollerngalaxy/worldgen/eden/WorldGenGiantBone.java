/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.worldgen.eden;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenGiantBone extends ZGWorldGenMaster {
	
	protected boolean isValidSpawn(World world, BlockPos pos) {
		Block blockBelow = world.getBlockState(pos.down()).getBlock();
		
		if (blockBelow == Blocks.AIR) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		int i = position.getX();
		int j = position.getY();
		int k = position.getZ();
		
		if (!this.isValidSpawn(world, position)) {
			return false;
		}
		
		//
		if (rand.nextInt(100) <= 35) {
			BlockPos chestPos1 = position.add(0, -1, 0);
			
			world.setBlockState(chestPos1, Blocks.CHEST.correctFacing(world, chestPos1, Blocks.CHEST.getDefaultState()), 2);
			TileEntity tileentity2 = world.getTileEntity(chestPos1);
			
			if (tileentity2 instanceof TileEntityChest) {
				((TileEntityChest) tileentity2).setLootTable(ZGLootTables.CHEST_GIANT_BONE, rand.nextLong());
			}
		}
		//
		
		this.setBlock(world, position.add(0, 0, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(0, 1, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(0, 2, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(0, 3, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(0, 4, 0), ZGBlocks.edenBoneStone);
		
		this.setBlock(world, position.add(1, 4, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(1, 5, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(1, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(2, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(3, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(3, 7, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(3, 8, 0), ZGBlocks.edenBoneStone);
		
		this.setBlock(world, position.add(1, 7, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(1, 8, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-1, 4, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-1, 5, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-1, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-2, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-3, 6, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-3, 7, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-3, 8, 0), ZGBlocks.edenBoneStone);
		
		this.setBlock(world, position.add(-1, 7, 0), ZGBlocks.edenBoneStone);
		this.setBlock(world, position.add(-1, 8, 0), ZGBlocks.edenBoneStone);
		
		return true;
	}
}