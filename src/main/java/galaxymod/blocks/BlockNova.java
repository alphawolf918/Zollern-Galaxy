/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import galaxymod.ProjectNovaCore;
import galaxymod.lib.NGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockNova extends Block {
	
	public static Item dropItem = null;
	public static int dropItemAmountMin = 1;
	public static int dropItemAmountMax = 1;
	
	public BlockNova(Material par1Material) {
		super(par1Material);
		this.setHardResist(1.8F, 9.8F);
		this.setStepSound(soundTypeStone);
	}
	
	public void setDropItem(Item itemDropped) {
		this.dropItem = itemDropped;
	}
	
	public void setDropItem(Item itemDropped, int amountDropped) {
		this.setDropItem(itemDropped);
		this.setItemAmountDropped(amountDropped);
	}
	
	public void setDropItem(Item itemDropped, int amountDroppedMin,
			int amountDroppedMax) {
		this.setDropItem(itemDropped);
		this.dropItemAmountMin = amountDroppedMin;
		this.dropItemAmountMax = amountDroppedMax;
	}
	
	public void setItemAmountDropped(int par1) {
		this.dropItemAmountMin = par1;
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		if (this.dropItem != null) {
			return this.dropItem;
		} else {
			return Item.getItemFromBlock(this);
		}
	}
	
	@Override
	public int quantityDropped(Random par1Rand) {
		if (par1Rand.nextInt(2) == 1) {
			return this.dropItemAmountMax;
		} else {
			return this.dropItemAmountMin;
		}
	}
	
	public void setHardResist(float par1Hardness, float par2Resistance) {
		NGHelper.setHardnessAndResistance(this, par1Hardness, par2Resistance);
	}
	
	public void setHardResist(float par1HardResist) {
		NGHelper.setHardnessAndResistance(this, par1HardResist);
	}
	
	public void setName(String strName) {
		NGHelper.setName(this, strName);
	}
	
	public void setTexture(String strTexture) {
		NGHelper.setTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strTexture) {
		NGHelper.setNameAndTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strName, String strTexture) {
		NGHelper.setNameAndTexture(this, strName, strTexture);
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ProjectNovaCore.novaTabBlocks;
	}
}