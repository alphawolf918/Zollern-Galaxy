/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.astros;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import zollerngalaxy.blocks.ZGOreGem;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class AstrosSapphireOre extends ZGOreGem {
	
	public AstrosSapphireOre() {
		super("astrossapphireore", 3.2F, ZGItems.sapphire);
		this.setDroppedItemHasMetadata(false);
		this.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return ZGItems.sapphire;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		int j = ZGHelper.rngInt(this.getMinDropped(), this.getMaxDropped());
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(ZGItems.sapphire, 1));
		}
	}
	
}