/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.kriffus;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import net.minecraft.block.material.Material;

public class KriffRock extends BlockNova {
	
	public KriffRock() {
		super(Material.rock);
		this.setResistance(0.8F);
		this.setHardness(0.4F);
		NGHelper.setNameAndTexture(this, "kriffrock");
	}
}