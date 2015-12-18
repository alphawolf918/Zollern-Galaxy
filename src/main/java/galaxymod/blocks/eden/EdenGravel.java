/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.ProjectNovaCore;
import galaxymod.lib.NGHelper;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EdenGravel extends BlockFalling {
	public EdenGravel() {
		super(Material.grass);
		NGHelper.setNameAndTexture(this, "edengravel");
		this.setHardness(0.9F);
		this.setResistance(5.6F);
		this.setStepSound(this.soundTypeGravel);
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ProjectNovaCore.novaTabBlocks;
	}
}