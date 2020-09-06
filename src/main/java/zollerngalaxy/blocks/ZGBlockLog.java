/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGBlockLog extends ZGBlockPlanks {
	
	public ZGBlockLog(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setHarvestLevel("axe", EnumHarvestLevelZG.IRON.getHarvestLevel());
		this.setShouldJSONIgnore(true);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerLogBlock(blockName);
		}
	}
	
	public ZGBlockLog(String singleName) {
		this(singleName, 2.5F);
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		int i = 4;
		int j = 5;
		
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);
				
				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}
	
	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return EnumHarvestLevelZG.IRON.getHarvestLevel();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return EnumHarvestToolZG.AXE.getHarvestTool();
	}
	
}