/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.items.ItemList;
import net.minecraft.block.material.Material;

public class BlockEdenBrightStone extends BlockNova {
	
	public BlockEdenBrightStone() {
		super(Material.glass);
		this.setNameAndTexture("brightstone");
		this.setLightLevel(1.0F);
		this.setHardResist(0.4F);
		this.setStepSound(soundTypeGlass);
		this.setDropItem(ItemList.brightStoneDust, 3, 4);
	}
}