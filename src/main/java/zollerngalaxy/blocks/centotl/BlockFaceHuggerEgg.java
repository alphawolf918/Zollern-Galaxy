/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.centotl;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockEgg;
import zollerngalaxy.mobs.entities.EntityFacehugger;

public class BlockFacehuggerEgg extends ZGBlockEgg {
	
	public BlockFacehuggerEgg() {
		super("facehugger_egg");
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.hatchEgg(worldIn, pos);
		this.ticksEggExisted = 0;
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		this.ticksEggExisted += 10;
		return true;
	}
	
	public void hatchEgg(World worldIn, int par2x, int par3y, int par4z) {
		int randInt = new Random().nextInt(4);
		randInt = (randInt == 0) ? 1 : randInt;
		for (int i = 0; i < randInt; i++) {
			if (!worldIn.isRemote) {
				EntityFacehugger facehugger = new EntityFacehugger(worldIn);
				facehugger.setLocationAndAngles(par2x + i, par3y + i, par4z + i, 0, 0);
				worldIn.spawnEntity(facehugger);
			}
		}
	}
	
	public void hatchEgg(World par1World, BlockPos pos) {
		int posX = pos.getX();
		int posY = pos.getY();
		int posZ = pos.getZ();
		this.hatchEgg(par1World, posX, posY, posZ);
	}
}