/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen;

import java.util.Random;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZGLootTables;

public class WorldGenTreasure extends ZGWorldGenMaster {
	
	protected ResourceLocation lootTable = null;
	protected static final BlockChest CHEST = Blocks.CHEST;
	protected static final IBlockState CHEST_STATE = CHEST.getDefaultState();
	
	public WorldGenTreasure(ResourceLocation lootTblIn) {
		this.lootTable = lootTblIn;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		// Only validate chest gens if enabled in config. (ExistingEevee)
		if (ConfigManagerZG.enableChestValidation) {
			if (!this.isValidSpawn(worldIn, pos)) {
				return false;
			}
		}
		
		// Don't generate an empty chest.
		if (lootTable == null) {
			return false;
		}
		
		// Try it this way now?
		BlockPos chestPos = pos.down();
		ZGLootTables.generateChest(worldIn, chestPos, rand, this.lootTable);
		return true;
	}
	
	public WorldGenerator setLootTable(ResourceLocation lootTblIn) {
		this.lootTable = lootTblIn;
		return this;
	}
}