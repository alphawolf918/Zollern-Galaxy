/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenTreasure extends ZGWorldGenMaster {
	
	protected ResourceLocation lootTable;
	
	public WorldGenTreasure(ResourceLocation lootTblIn) {
		this.lootTable = lootTblIn;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		if (!this.isValidSpawn(worldIn, pos) || lootTable == null) {
			return false;
		}
		
		BlockPos chestPos = pos.down();
		
		worldIn.setBlockState(chestPos, Blocks.CHEST.correctFacing(worldIn, chestPos, Blocks.CHEST.getDefaultState()), 2);
		TileEntity tileEntity = worldIn.getTileEntity(chestPos);
		
		if (tileEntity instanceof TileEntityChest) {
			TileEntityChest chestEntity = (TileEntityChest) tileEntity;
			chestEntity.setLootTable(this.lootTable, rand.nextLong());
		}
		
		return true;
	}
	
	public WorldGenerator setLootTable(ResourceLocation lootTblIn) {
		this.lootTable = lootTblIn;
		return this;
	}
}