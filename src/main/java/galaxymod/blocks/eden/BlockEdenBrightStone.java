/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.items.ItemNova;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockEdenBrightStone extends BlockNova {
	
	private static ItemNova dropItem;
	
	public BlockEdenBrightStone() {
		super(Material.glass);
		this.setNameAndTexture("brightstone");
		this.setLightLevel(1.0F);
		this.setHardResist(0.4F);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.dropItem;
	}
	
}