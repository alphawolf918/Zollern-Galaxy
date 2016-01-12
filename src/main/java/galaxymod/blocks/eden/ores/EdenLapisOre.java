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
import net.minecraft.util.MathHelper;

public class EdenLapisOre extends BlockNovaOre {
	
	public EdenLapisOre() {
		super("edenlapisore");
		this.setHardResist(1.2F);
		this.setExpDrop(4, 6);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.dye;
	}
	
	@Override
	public int damageDropped(int par1) {
		return 4;
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		return MathHelper.getRandomIntegerInRange(par1Rand, 4, 6);
	}
	
}