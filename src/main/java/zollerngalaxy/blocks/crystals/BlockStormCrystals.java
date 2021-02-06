/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.crystals;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.items.ZGItems;

public class BlockStormCrystals extends ZGCrystalBlock {
	
	public BlockStormCrystals() {
		super("stormcrystals", ZGItems.stormCrystal);
		this.setLightLevel(0.0F);
		this.setBlockUnbreakable();
		this.setTickRandomly(true);
		this.setShouldJSONIgnore(true);
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.updateTick(worldIn, pos, state, RANDOM);
	}
	
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		this.updateTick(worldIn, pos, state, random);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.isRaining()) {
				this.setLightLevel(1.0F);
				this.setHardness(9.8F);
			} else {
				this.setLightLevel(0.0F);
				this.setBlockUnbreakable();
			}
		}
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 10;
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
}