/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import java.util.Random;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNovaOre extends BlockNova implements IDetectableResource {
	
	public BlockNovaOre() {
		super(Material.rock);
		this.setHardResist(2.0F, 4.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeStone);
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
	
	@Override
	public boolean isValueable(int metadata) {
		return true;
	}
	
}