/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import net.minecraft.block.material.Material;

public class BlockEdenViri extends BlockNova {
	
	public BlockEdenViri() {
		super(Material.iron);
		this.setHardResist(2.0F);
		this.setNameAndTexture("viriblock");
		this.setStepSound(soundTypeMetal);
	}
	
}