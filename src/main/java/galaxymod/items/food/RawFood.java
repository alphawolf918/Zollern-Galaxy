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
import net.minecraft.potion.Potion;

public class RawFood extends ItemFood {
	
	public RawFood(String strTexture) {
		super(2, 2F, false);
		ZGHelper.setTab(this);
		ZGHelper.setNameAndTexture(this, strTexture);
		setMaxStackSize(64);
		this.setPotionEffect(Potion.hunger.id, 30, 0, 0.3F);
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ZollernGalaxyCore.novaTabItems;
	}
}