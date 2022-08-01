/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.worldgen.zollus;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.worldgen.ZGWorldGenMaster;

public class WorldGenZGIceSpikes extends ZGWorldGenMaster {
	
	private int spikeHeight = ZGHelper.rngInt(4, 16);
	private IBlockState iceBlock = Blocks.PACKED_ICE.getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		if (!this.isValidSpawn(worldIn, pos)) {
			return false;
		}
		
		this.generateSpike(worldIn, pos);
		this.generateSpike(worldIn, pos.add(1, 0, 0));
		this.generateSpike(worldIn, pos.add(0, 0, 1));
		this.generateSpike(worldIn, pos.add(-1, 0, 0));
		this.generateSpike(worldIn, pos.add(0, 0, -1));
		
		return true;
	}
	
	private void generateSpike(World worldIn, BlockPos pos) {
		for (int i = 0; i < this.spikeHeight; i++) {
			worldIn.setBlockState(pos.add(0, i, 0), iceBlock);
		}
	}
}