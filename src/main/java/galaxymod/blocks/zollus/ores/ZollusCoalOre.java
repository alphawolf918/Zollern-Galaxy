/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.zollus.ores;

import galaxymod.blocks.BlockNova;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class ZollusCoalOre extends BlockNova {
	
	public static Item dropItem = Items.coal;
	
	public ZollusCoalOre() {
		super(Material.rock);
		this.setNameAndTexture("zolcoalore");
		this.setHardResist(4.0F, 2.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return this.dropItem;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		if (p_149745_1_.nextInt(10) == 2) {
			return 4;
		} else {
			return 2;
		}
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 6, 11);
			
			return j1;
		}
		return 0;
	}
}