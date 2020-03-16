/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.eden;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class EdenFlower extends ZGBlockFlower {
	
	private String COLOR;
	private static String blockName = "edenflower";
	
	public EdenFlower(String flowerColor) {
		super(blockName + "_" + flowerColor);
		this.setColor(flowerColor);
		this.setupFlower();
	}
	
	public EdenFlower() {
		super(blockName);
		this.setColor("");
		this.setupFlower();
	}
	
	private void setupFlower() {
		this.setMaterial(Material.VINE);
		String flowerName = (this.getColor() == "") ? blockName : blockName + "_" + this.getColor();
		JSONFactory.registerFlowerBlock(flowerName);
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		BlockPos posD = pos.down();
		IBlockState stateD = world.getBlockState(posD);
		Block blockD = stateD.getBlock();
		return (blockD instanceof ZGBlockGrass || blockD instanceof ZGBlockDirt);
	}
	
	public Block setColor(String clr) {
		this.COLOR = clr;
		return this;
	}
	
	public String getColor() {
		return this.COLOR;
	}
	
}