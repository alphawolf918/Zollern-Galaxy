/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.centotl;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockEgg;
import zollerngalaxy.mobs.entities.EntityFacehugger;
import zollerngalaxy.mobs.entities.EntityXenomorph;

public class BlockFacehuggerEgg extends ZGBlockEgg {
	
	public BlockFacehuggerEgg() {
		super("facehugger_egg");
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		boolean facehuggerInstance = (entityIn instanceof EntityFacehugger);
		boolean xenomorphInstance = (entityIn instanceof EntityXenomorph);
		if (facehuggerInstance || xenomorphInstance) {
			this.hatchEgg(worldIn, pos);
			if (facehuggerInstance) {
				((EntityFacehugger) entityIn).killFacehugger();
			}
		}
	}
	
	public void hatchEgg(World worldIn, int par2x, int par3y, int par4z) {
		int randInt = new Random().nextInt(4);
		randInt = (randInt == 0) ? 1 : randInt;
		for (int i = 0; i < randInt; i++) {
			if (!worldIn.isRemote) {
				EntityFacehugger facehugger = new EntityFacehugger(worldIn);
				facehugger.setLocationAndAngles(par2x + i, par3y + i, par4z + i, 0, 0);
				worldIn.spawnEntity(facehugger);
				BlockPos pos = new BlockPos(par2x + i, par3y + i, par4z + i);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
			}
		}
	}
	
	@Override
	public void hatchEgg(World par1World, BlockPos pos) {
		int posX = pos.getX();
		int posY = pos.getY();
		int posZ = pos.getZ();
		this.hatchEgg(par1World, posX, posY, posZ);
	}
}