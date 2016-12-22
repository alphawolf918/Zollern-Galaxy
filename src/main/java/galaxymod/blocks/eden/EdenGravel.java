/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.ProjectNovaCore;
import galaxymod.utils.ZGHelper;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class EdenGravel extends BlockFalling {
	public EdenGravel() {
		super(Material.grass);
		ZGHelper.setNameAndTexture(this, "edengravel");
		ZGHelper.setHardResist(this, 0.9F, 5.6F);
		this.setStepSound(this.soundTypeGravel);
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ProjectNovaCore.novaTabBlocks;
	}
}