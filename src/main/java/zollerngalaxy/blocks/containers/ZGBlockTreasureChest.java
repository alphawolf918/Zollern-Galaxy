/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.containers;

import micdoodle8.mods.galacticraft.core.blocks.BlockTier1TreasureChest;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.tileentities.TileEntityTier10TreasureChestZG;

public class ZGBlockTreasureChest extends BlockTier1TreasureChest implements ISingleZGBlockRender {
	
	protected static String name;
	
	public ZGBlockTreasureChest(String assetName) {
		super(assetName);
		this.name = assetName;
		this.setBlockName(this, assetName);
	}
	
	public void setBlockName(Block block, final String blockName) {
		block.setUnlocalizedName(blockName);
	}
	
	@Override
	public String getName() {
		return this.name.toLowerCase();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZGTabs.zgBlocksTab;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTier10TreasureChestZG();
	}
}