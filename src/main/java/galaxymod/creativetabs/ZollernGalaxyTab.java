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

package galaxymod.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ZollernGalaxyTab extends CreativeTabs {
	
	protected ItemStack displayItem;
	
	public ZollernGalaxyTab(String label, ItemStack theItemStack) {
		super(CreativeTabs.getNextID(), label);
		this.displayItem = theItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return this.displayItem;
	}
	
	@Override
	public Item getTabIconItem() {
		return null;
	}
}