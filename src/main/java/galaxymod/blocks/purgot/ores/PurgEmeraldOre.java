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

package galaxymod.blocks.purgot.ores;

import galaxymod.blocks.BlockNovaOre;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;

public class PurgEmeraldOre extends BlockNovaOre {
	
	public PurgEmeraldOre() {
		super("purgemeraldore");
		this.setHardResist(2.6F);
		this.setExpDrop(10, 15);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.emerald;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return MathHelper.getRandomIntegerInRange(p_149745_1_, 1, 4);
	}
	
}