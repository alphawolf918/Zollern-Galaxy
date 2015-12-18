/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.zollus;

import galaxymod.blocks.BlockNova;
import net.minecraft.block.material.Material;

public class BlockZolCobbleRock extends BlockNova {
	
	public BlockZolCobbleRock() {
		super(Material.rock);
		this.setNameAndTexture("zolcobblerock");
		this.setHardResist(1.0F, 6.5F);
	}
	
}