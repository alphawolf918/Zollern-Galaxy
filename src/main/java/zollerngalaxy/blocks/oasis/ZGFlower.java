/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.oasis;

import micdoodle8.mods.galacticraft.core.blocks.ISortableBlock;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGFlower extends ZGBlockFlower implements ISortableBlock {
	
	protected String flowerName;
	
	public ZGFlower(String blockName) {
		super(blockName);
		this.flowerName = blockName;
		this.setupFlower();
	}
	
	private void setupFlower() {
		this.setMaterial(Material.VINE);
		JSONFactory.registerFlowerBlock(this.flowerName);
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		BlockPos posD = pos.down();
		IBlockState stateD = world.getBlockState(posD);
		Block blockD = stateD.getBlock();
		return (blockD instanceof ZGBlockGrass || blockD instanceof ZGBlockDirt);
	}
	
	@Override
	public EnumSortCategoryBlock getCategory(int meta) {
		return EnumSortCategoryBlock.DECORATION;
	}
}