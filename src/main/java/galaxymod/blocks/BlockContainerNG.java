/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import galaxymod.ProjectNovaCore;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public abstract class BlockContainerNG extends BlockContainer {
	
	public BlockContainerNG(Material par1Material) {
		super(par1Material);
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ProjectNovaCore.novaTabBlocks;
	}
}