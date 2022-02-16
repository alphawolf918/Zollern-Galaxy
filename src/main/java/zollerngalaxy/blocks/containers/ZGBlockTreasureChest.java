/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.containers;

import micdoodle8.mods.galacticraft.core.blocks.BlockTier1TreasureChest;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.creativetabs.ZGTabs;

public abstract class ZGBlockTreasureChest extends BlockTier1TreasureChest implements ISingleZGBlockRender {
	
	protected static String blockName;
	
	public ZGBlockTreasureChest(String assetName) {
		super(assetName);
		this.blockName = assetName;
		this.setBlockName(assetName);
	}
	
	public void setBlockName(String blockNameIn) {
		this.setUnlocalizedName(blockName);
		this.blockName = blockNameIn;
	}
	
	@Override
	public String getName() {
		return this.blockName.toLowerCase();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZGTabs.zgBlocksTab;
	}
	
	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);
	
}