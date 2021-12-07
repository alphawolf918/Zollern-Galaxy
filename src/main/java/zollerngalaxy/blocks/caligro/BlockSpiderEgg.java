/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.caligro;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockEgg;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.EntitySpiderling;

public class BlockSpiderEgg extends ZGBlockEgg {
	
	protected int ticksEggExisted = 0;
	
	public BlockSpiderEgg() {
		super("spider_egg");
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.playHeartbeatSound(worldIn, pos);
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		this.playHeartbeatSound(worldIn, pos);
		this.ticksEggExisted += 10;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		this.checkFall(worldIn, pos);
		int par2 = pos.getX();
		int par3 = pos.getY();
		int par4 = pos.getZ();
		BlockPos soundPos = new BlockPos(par2 + 1.5D, par3 + 1.5D, par4 + 1.5D);
		if (this.ticksEggExisted >= 500) {
			this.playHeartbeatSound(worldIn, soundPos);
			this.hatchSpider(worldIn, par2, par3, par4);
			this.ticksEggExisted = 0;
			worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
		}
		this.ticksEggExisted += 10;
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 5;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		this.hatchSpider(worldIn, pos);
		this.ticksEggExisted = 0;
		worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 0);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY,
			float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		this.playHeartbeatSound(worldIn, pos);
		this.ticksEggExisted += 10;
		return true;
	}
	
	/**
	 * Hatch a Spiderling mob at this location.
	 * 
	 * @param par1World
	 *            The world object to use.
	 * @param par2x
	 *            X
	 * @param par3y
	 *            Y
	 * @param par4z
	 *            Z
	 */
	public void hatchSpider(World par1World, int par2x, int par3y, int par4z) {
		int randInt = new Random().nextInt(4);
		randInt = (randInt == 0) ? 1 : randInt;
		for (int i = 0; i < randInt; i++) {
			if (!par1World.isRemote) {
				EntitySpiderling spiderling = new EntitySpiderling(par1World);
				spiderling.setLocationAndAngles(par2x + i, par3y + i, par4z + i, 0, 0);
				par1World.spawnEntity(spiderling);
			}
		}
	}
	
	/**
	 * Hatch a Spiderling mob at this location.
	 * 
	 * @param par1World
	 *            The world object to use.
	 * @param pos
	 *            The position in the world to spawn it.
	 */
	public void hatchSpider(World par1World, BlockPos pos) {
		int posX = pos.getX();
		int posY = pos.getY();
		int posZ = pos.getZ();
		this.hatchSpider(par1World, posX, posY, posZ);
	}
	
	private void playHeartbeatSound(World worldIn, BlockPos pos) {
		float soundPitch = worldIn.rand.nextFloat() * 0.1F + 0.9F;
		SoundEvent soundEvent = ZGSoundEvents.SPIDERLING_EGG_HEARTBEAT;
		worldIn.playSound(null, pos, soundEvent, SoundCategory.AMBIENT, 1.5F, soundPitch);
	}
}