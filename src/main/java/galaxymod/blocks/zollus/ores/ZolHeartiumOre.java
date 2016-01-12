/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.zollus.ores;

import galaxymod.blocks.BlockNovaOre;
import galaxymod.items.ItemList;
import java.util.Random;
import net.minecraft.item.Item;

public class ZolHeartiumOre extends BlockNovaOre {
	
	public ZolHeartiumOre() {
		super("zolheartore");
		this.setHardResist(3.0F);
		this.setExpDrop(8, 10);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.zollusHeartium;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return (par1Rand.nextInt(2) == 1) ? 2 : 1;
	}
	
}