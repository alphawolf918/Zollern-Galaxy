/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.stationblocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.proxy.IProxy;

public class ZGBlockStationBase extends ZGBlockBase {
	
	protected static final IProxy proxy = ZollernGalaxyCore.proxy;
	
	public ZGBlockStationBase(String blockName) {
		super(blockName);
		this.setHardness(10.0F);
		this.setBlockUnbreakable();
		this.setMaterial(Material.ANVIL);
		this.setSound(SoundType.METAL);
		this.setBlockType(EnumBlockType.STATION);
	}
	
	protected void performStationEvent(EntityPlayer playerIn, EnumHand hand) {
		// Inherited classes use this
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
			float hitX, float hitY, float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		this.performStationEvent(playerIn, hand);
		return true;
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return false;
	}
}