/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGShineBlock extends ZGBlockBase {
	
	private Item droppedItem;
	
	public ZGShineBlock(String blockName, Item itemToDrop) {
		this(blockName, 1.2F, itemToDrop);
	}
	
	public ZGShineBlock(String blockName, float hardResist, Item itemToDrop) {
		super(blockName, hardResist);
		this.setLightLevel(1.0F);
		this.setMaterial(Material.GLASS);
		this.setSound(SoundType.GLASS);
		this.setBlockType(EnumBlockType.SHINE);
		this.droppedItem = itemToDrop;
	}
	
	public ZGShineBlock(String blockName, float hardResist) {
		this(blockName, hardResist, Item.getItemFromBlock(Blocks.AIR));
	}
	
	public ZGShineBlock(String blockName) {
		this(blockName, 1.2F);
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.droppedItem;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int randInt = rand.nextInt(6);
		return (randInt > 0) ? randInt : 1;
	}
}