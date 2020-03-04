/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.perdita;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGSand;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGDeadBush extends ZGBlockFlower {
	
	public ZGDeadBush(String blockName) {
		super(blockName);
		this.setMaterial(Material.VINE);
		JSONFactory.registerFlowerBlock(blockName);
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		BlockPos posD = pos.down();
		IBlockState stateD = world.getBlockState(posD);
		Block blockD = stateD.getBlock();
		return (blockD instanceof ZGSand);
	}
	
	public static boolean canBushStay(World world, BlockPos pos, IBlockState state) {
		BlockPos posD = pos.down();
		IBlockState stateD = world.getBlockState(posD);
		Block blockD = stateD.getBlock();
		return (blockD instanceof ZGSand);
	}
}
