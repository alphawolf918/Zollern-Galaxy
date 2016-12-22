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

package galaxymod.blocks;

import java.util.Random;
import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class BlockNovaOre extends BlockNova implements IDetectableResource {
	
	private static Random rand = new Random();
	
	public static boolean canDropXp = false;
	public static int xpDropMin = 0;
	public static int xpDropMax = 1;
	
	public BlockNovaOre() {
		super(Material.rock);
		this.setDefaults();
	}
	
	public BlockNovaOre(String strTexture) {
		super(Material.rock);
		this.setDefaults();
		this.setNameAndTexture(strTexture);
	}
	
	public BlockNovaOre(String strTexture, float hardness, float resistance) {
		super(Material.rock);
		this.setDefaults();
	}
	
	@Override
	public Block setDefaults() {
		super.setDefaults();
		this.setHardResist(1.6F, 2.5F);
		this.setHarvestLevel("pickaxe", 3);
		return this;
	}
	
	@Override
	public boolean isValueable(int metadata) {
		return true;
	}
	
	public Block setExpDrop(int min, int max) {
		this.canDropXp = true;
		this.xpDropMin = min;
		this.xpDropMax = max;
		return this;
	}
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this) && this.canDropXp) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, this.xpDropMin,
					this.xpDropMax);
			
			return j1;
		} else {
			return 0;
		}
	}
}