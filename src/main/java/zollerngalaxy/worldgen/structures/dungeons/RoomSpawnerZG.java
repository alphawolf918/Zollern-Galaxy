/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.structures.dungeons;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class RoomSpawnerZG extends RoomEmptyZG {
	
	public RoomSpawnerZG() {
	}
	
	public RoomSpawnerZG(DungeonConfigurationZG configuration, Random rand, int blockPosX, int blockPosZ, int sizeX, int sizeY, int sizeZ, EnumFacing entranceDir) {
		super(configuration, rand, blockPosX, blockPosZ, sizeX, sizeY, sizeZ, entranceDir);
	}
	
	@Override
	public boolean addComponentParts(World worldIn, Random random, StructureBoundingBox boundingBox) {
		if (super.addComponentParts(worldIn, random, boundingBox)) {
			// for (int i = 1; i <= this.sizeX - 1; ++i) {
			// for (int j = 1; j <= this.sizeY - 1; ++j) {
			// for (int k = 1; k <= this.sizeZ - 1; ++k) {
			// if (random.nextFloat() < 0.05F) {
			// this.setBlockState(worldIn, ZGBlocks.xantheonConstructBlock.getDefaultState(), i, j,
			// k, boundingBox);
			// }
			// }
			// }
			// }
			
			this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), 1, 0, 1, boundingBox);
			this.setBlockState(worldIn, Blocks.MOB_SPAWNER.getDefaultState(), this.sizeX - 1, 0, this.sizeZ - 1, boundingBox);
			
			BlockPos blockpos = new BlockPos(this.getXWithOffset(1, 1), this.getYWithOffset(0), this.getZWithOffset(1, 1));
			TileEntityMobSpawner spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);
			
			if (spawner != null) {
				spawner.getSpawnerBaseLogic().setEntityId(getMob(random));
			}
			
			blockpos = new BlockPos(this.getXWithOffset(this.sizeX - 1, this.sizeZ - 1), this.getYWithOffset(0), this.getZWithOffset(this.sizeX - 1, this.sizeZ - 1));
			spawner = (TileEntityMobSpawner) worldIn.getTileEntity(blockpos);
			
			if (spawner != null) {
				spawner.getSpawnerBaseLogic().setEntityId(getMob(random));
			}
			
			return true;
		}
		
		return false;
	}
	
	private static ResourceLocation getMob(Random rand) {
		return DUNGEON_CFG.getMob();
	}
}