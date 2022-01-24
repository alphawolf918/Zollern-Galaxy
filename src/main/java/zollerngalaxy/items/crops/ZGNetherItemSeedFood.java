/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.crops;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.EnumPlantType;

public class ZGNetherItemSeedFood extends ZGItemSeedFood {
	
	public ZGNetherItemSeedFood(String name, int healAmount, float saturation, Block crops) {
		super(name, healAmount, saturation, crops, Blocks.SOUL_SAND);
	}
	
	@Override
	public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Nether;
	}
}