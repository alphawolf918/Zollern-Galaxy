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

package galaxymod.blocks.eden.ores;

import galaxymod.blocks.BlockNovaOre;
import java.util.Random;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class EdenRedstoneOre extends BlockNovaOre {
	
	public EdenRedstoneOre() {
		super("edenredstoneore");
		this.setHardResist(2.0F);
		this.setExpDrop(5, 7);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.redstone;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return (par1Rand.nextInt(2) == 1) ? 4 : 2;
	}
	
}