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
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.item.Item;

public class EdenDeshOre extends BlockNovaOre {
	
	public EdenDeshOre() {
		super("edendeshore");
		this.setHardResist(3.5F);
		this.setExpDrop(6, 8);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return MarsItems.marsItemBasic;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) == 2) {
			return 2;
		} else {
			return 1;
		}
	}
}
