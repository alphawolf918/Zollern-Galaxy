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

package galaxymod.blocks.purgot;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.BlockNova;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class PurgStone extends BlockNova {
	
	public PurgStone() {
		super("purgstone", Material.rock);
		this.setHardResist(1.2F, 8.0F);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(BlockList.purgCobbleRock);
	}
	
}