/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.crops;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zollerngalaxy.blocks.IJSONBlock;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public abstract class ZGBlockCropBase extends BlockCrops implements ISingleZGBlockRender, IJSONBlock {
	
	protected ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	protected static String name;
	protected boolean shouldJSONIgnore = false;
	
	private static final AxisAlignedBB[] CROP_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.1875D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.25D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.3125D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D),
			new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.4375D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D), new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D) };
	
	public ZGBlockCropBase(String cropNameIn) {
		cropNameIn += "_crop";
		this.name = cropNameIn;
		this.setBlockName(this, cropNameIn);
		this.setShouldJSONIgnore(true);
		if (core.isInDevMode()) {
			for (int i = 0; i <= 3; i++) {
				JSONFactory.registerCrop(cropNameIn.replace("_crop", "") + "_stage_" + i);
			}
			JSONFactory.registerCropBlockState(cropNameIn);
		}
	}
	
	@Override
	protected Item getSeed() {
		return Items.WHEAT_SEEDS;
	}
	
	@Override
	protected Item getCrop() {
		return Items.WHEAT;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return CROP_AABB[state.getValue(this.getAgeProperty()).intValue()];
	}
	
	public void setBlockName(Block block, final String blockName) {
		block.setUnlocalizedName(blockName);
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
	
	@Override
	public String getName() {
		return this.name.toLowerCase();
	}
	
	/**
	 * Prevent the JSON generator from overwriting this block's files.
	 * 
	 * @param ignore
	 *            Whether or not this block should be ignored by the JSON generator.
	 * @return Block
	 */
	public Block setShouldJSONIgnore(boolean ignore) {
		this.shouldJSONIgnore = ignore;
		return this;
	}
}