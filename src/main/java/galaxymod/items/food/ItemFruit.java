/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.items.food;

import galaxymod.lib.NGHelper;
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
		NGHelper.setTab(this);
		NGHelper.setNameAndTexture(this, strTexture);
	}
}