/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockIce extends ZGBlockBase {
	
	public ZGBlockIce(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setSlipperiness(1.02F);
		this.setMaterial(Material.ICE);
		this.setSound(SoundType.GLASS);
		this.setBlockType(EnumBlockType.ICE);
	}
	
	public ZGBlockIce(String blockName) {
		this(blockName, 0.2F);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 0;
	}
	
	@Override
	public EnumPushReaction getMobilityFlag(IBlockState state) {
		return EnumPushReaction.NORMAL;
	}
}