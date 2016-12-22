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

package galaxymod.blocks;

import net.minecraft.block.material.Material;

public class BlockNovaDirt extends BlockNova {
	
	public BlockNovaDirt(String strTexture) {
		super(strTexture, Material.ground);
		this.setHardResist(0.5F);
		this.setHarvestLevel("shovel", 1);
		this.setStepSound(soundTypeGravel);
	}
	
	public BlockNovaDirt(String strTexture, float hardResist) {
		this(strTexture);
		this.setHardResist(hardResist);
	}
	
	public BlockNovaDirt(String strTexture, Material par1Material) {
		super(strTexture, par1Material);
	}
	
}