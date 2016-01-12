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

package galaxymod.blocks.eden.ores;

import galaxymod.blocks.BlockNovaOre;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EdenEmeraldOre extends BlockNovaOre {
	
	public EdenEmeraldOre() {
		super("edenemeraldore");
		this.setHardResist(2.6F, 8.6F);
		this.setExpDrop(6, 8);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.emerald;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return (par1Rand.nextInt(2) == 1) ? 2 : 1;
	}
	
}