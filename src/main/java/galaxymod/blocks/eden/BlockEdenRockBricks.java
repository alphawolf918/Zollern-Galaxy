/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import net.minecraft.block.material.Material;

public class BlockEdenRockBricks extends BlockNova {
	public BlockEdenRockBricks() {
		super(Material.rock);
		NGHelper.setNameAndTexture(this, "edenrockbricks");
		this.setResistance(9.8F);
		this.setHardness(0.9F);
	}
}