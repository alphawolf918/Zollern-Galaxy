/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.sirens;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;

public class BlockEmeraldSiren extends SirenBlockBase {
	
	public BlockEmeraldSiren(String blockName, SoundEvent sirenSound, boolean isOn) {
		super(blockName, sirenSound, isOn);
		this.setSirenBlockSound(sirenSound);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.isOn && !worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ZGBlocks.emeraldSiren.getDefaultState(), 2);
			} else if (!this.isOn && worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ZGBlocks.emeraldSirenON.getDefaultState(), 2);
				this.playAlarm(worldIn, pos);
			}
		}
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			if (this.isOn && !worldIn.isBlockPowered(pos)) {
				worldIn.scheduleUpdate(pos, this, 4);
			} else if (!this.isOn && worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ZGBlocks.emeraldSirenON.getDefaultState(), 2);
				this.playAlarm(worldIn, pos);
			}
		}
	}
	
	@Override
	public void playAlarm(World worldIn, BlockPos pos) {
		float soundPitch = worldIn.rand.nextFloat() * 0.1F + 0.9F;
		worldIn.playSound(null, pos, this.getSirenBlockSound(), SoundCategory.AMBIENT, 1.5F, soundPitch);
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (this.isOn && !worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ZGBlocks.emeraldSiren.getDefaultState(), 2);
			}
		}
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ZGBlocks.emeraldSiren);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ZGBlocks.emeraldSiren);
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(ZGBlocks.emeraldSiren);
	}
}