/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import net.minecraft.block.material.Material;

public class BlockEdenWoodPlanks extends BlockNova {
	public BlockEdenWoodPlanks() {
		super(Material.wood);
		NGHelper.setNameAndTexture(this, "edentreeplanks");
		this.setHardness(1.5F);
		this.setResistance(6.0F);
		this.setStepSound(soundTypeWood);
		this.setHarvestLevel("axe", 1);
	}
}