/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.ModInfo;
import galaxymod.lib.NovaHelper;
import galaxymod.lib.StaticUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MultiBlockGlass extends BlockNova {
	
	private static final String textureBaseName = "";
	private IIcon[] icons = new IIcon[16];
	private IIcon transparentIcon;
	
	public MultiBlockGlass() {
		super(Material.glass);
		this.setName("edenglass");
		this.setHardResist(0.2F, 0.4F);
		this.setStepSound(soundTypeGlass);
		NovaHelper.setTexture(this, textureBaseName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.transparentIcon = par1IconRegister.registerIcon(ModInfo.MODID
				+ ":" + textureBaseName + "edenglasstransparent");
		
		for (int i = 0; i < 16; ++i) {
			icons[i] = par1IconRegister.registerIcon(ModInfo.MODID + ":"
					+ textureBaseName + "edenglass" + Integer.toString(i));
		}
	}
	
	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		ForgeDirection[] dirsToCheck = StaticUtils.neighborsBySide[side];
		ForgeDirection dir;
		Block myBlock = blockAccess.getBlock(x, y, z);
		int myBlockMetadata = blockAccess.getBlockMetadata(x, y, z);
		
		ForgeDirection out = ForgeDirection.getOrientation(side);
		if (blockAccess.getBlock(x + out.offsetX, y + out.offsetY, z
				+ out.offsetZ) == myBlock
				&& blockAccess.getBlockMetadata(x + out.offsetX, y
						+ out.offsetY, z + out.offsetZ) == myBlockMetadata) {
			return transparentIcon;
		}
		
		int iconIdx = 0;
		for (int i = 0; i < dirsToCheck.length; i++) {
			dir = dirsToCheck[i];
			if (blockAccess.getBlock(x + dir.offsetX, y + dir.offsetY, z
					+ dir.offsetZ) == myBlock
					&& blockAccess.getBlockMetadata(x + dir.offsetX, y
							+ dir.offsetY, z + dir.offsetZ) == myBlockMetadata) {
				iconIdx |= 1 << i;
			}
		}
		
		return icons[iconIdx];
	}
	
	@Override
	public IIcon getIcon(int side, int metadata) {
		return icons[0];
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world,
			int x, int y, int z) {
		return false;
	}
}