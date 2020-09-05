/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.eden;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.ZGHelper;
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
		this.setTickRandomly(true);
		String flowerName = (this.getColor() == "") ? blockName : blockName + "_" + this.getColor();
		JSONFactory.registerFlowerBlock(flowerName);
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 20;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.updateTick(worldIn, pos, state, rand);
		String clr = this.getColor();
		
		Block blockX = worldIn.getBlockState(pos.add(1, 0, 0)).getBlock();
		Block blockNX = worldIn.getBlockState(pos.add(-1, 0, 0)).getBlock();
		Block blockZ = worldIn.getBlockState(pos.add(0, 0, 1)).getBlock();
		Block blockNZ = worldIn.getBlockState(pos.add(0, 0, -1)).getBlock();
		
		if (blockX instanceof EdenFlower) {
			EdenFlower flowerX = (EdenFlower) blockX;
			this.mateFlowers(worldIn, pos, clr, flowerX.getColor());
		}
		
		if (blockNX instanceof EdenFlower) {
			EdenFlower flowerNX = (EdenFlower) blockNX;
			this.mateFlowers(worldIn, pos, clr, flowerNX.getColor());
		}
		
		if (blockZ instanceof EdenFlower) {
			EdenFlower flowerZ = (EdenFlower) blockZ;
			this.mateFlowers(worldIn, pos, clr, flowerZ.getColor());
		}
		
		if (blockNZ instanceof EdenFlower) {
			EdenFlower flowerNZ = (EdenFlower) blockNZ;
			this.mateFlowers(worldIn, pos, clr, flowerNZ.getColor());
		}
	}
	
	private void mateFlowers(World worldIn, BlockPos pos, String clr1, String clr2) {
		if (clr1 == "" || clr2 == "") {
			return;
		}
		
		EdenFlower flower = null;
		
		if (this.checkColors("red", "white", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerPink;
		} else if (this.checkColors("red", "blue", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerPurple;
		} else if (this.checkColors("green", "blue", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerYellow;
		} else if (this.checkColors("red", "red", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerBlack;
		} else if (this.checkColors("red", "yellow", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerOrange;
		} else if (this.checkColors("blue", "white", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerCyan;
		} else if (this.checkColors("black", "black", clr1, clr2)) {
			flower = (EdenFlower) ZGBlocks.edenFlowerRed;
		}
		
		if (flower != null) {
			IBlockState flowerState = flower.getDefaultState();
			BlockPos posX1 = pos.add(1, 0, 0);
			BlockPos posX2 = pos.add(-1, 0, 0);
			BlockPos posZ1 = pos.add(0, 0, 1);
			BlockPos posZ2 = pos.add(0, 0, -1);
			BlockPos posXZ1 = pos.add(1, 0, 1);
			BlockPos posXZ2 = pos.add(-1, 0, -1);
			
			Block posBlockX1 = worldIn.getBlockState(posX1).getBlock();
			Block posBlockX2 = worldIn.getBlockState(posX2).getBlock();
			Block posBlockZ1 = worldIn.getBlockState(posZ1).getBlock();
			Block posBlockZ2 = worldIn.getBlockState(posZ2).getBlock();
			Block posBlockXZ1 = worldIn.getBlockState(posXZ1).getBlock();
			Block posBlockXZ2 = worldIn.getBlockState(posXZ2).getBlock();
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posX1, posBlockX1, flowerState);
			}
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posX2, posBlockX2, flowerState);
			}
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posZ1, posBlockZ1, flowerState);
			}
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posZ2, posBlockZ2, flowerState);
			}
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posXZ1, posBlockXZ1, flowerState);
			}
			
			if (ZGHelper.getRNGChance(5, 10)) {
				this.plantFlower(worldIn, posXZ2, posBlockXZ2, flowerState);
			}
		}
	}
	
	private void plantFlower(World worldIn, BlockPos pos, Block block, IBlockState flowerState) {
		if (block == Blocks.AIR && this.canBlockStay(worldIn, pos, flowerState)) {
			worldIn.setBlockState(pos, flowerState);
		}
	}
	
	private boolean checkColors(String clrSearch1, String clrSearch2, String clr1, String clr2) {
		if (((clr1 == clrSearch1) && (clr2 == clrSearch2)) || ((clr2 == clrSearch1) && (clr1 == clrSearch2))) {
			return true;
		}
		return false;
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