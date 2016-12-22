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

import galaxymod.blocks.BlockNova;
import galaxymod.items.ItemList;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class EdenBritestone extends BlockNova {
	
	public EdenBritestone() {
		super("brightstone", Material.glass);
		this.setLightLevel(1.0F);
		this.setHardResist(0.6F);
		this.setStepSound(soundTypeGlass);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.brightStoneDust;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) == 2) {
			return 3;
		} else {
			return 2;
		}
	}
	
}