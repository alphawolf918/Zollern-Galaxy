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

package galaxymod.items.food;

import galaxymod.ZollernGalaxyCore;
import galaxymod.utils.ZGHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class ItemFruit extends ItemFood {
	
	public ItemFruit(String strTexture) {
		super(4, 4, false);
		this.setInfo(strTexture);
	}
	
	public ItemFruit(String strTexture, int par1, int par2) {
		super(par1, par2, false);
		this.setInfo(strTexture);
	}
	
	void setInfo(String strTexture) {
		ZGHelper.setTab(this);
		ZGHelper.setNameAndTexture(this, strTexture);
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ZollernGalaxyCore.novaTabItems;
	}
}