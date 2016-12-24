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

package galaxymod.items;

import galaxymod.ZollernGalaxyCore;
import galaxymod.utils.OreDictionaryNova;
import galaxymod.utils.ZGHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemNova extends Item {
	
	public ItemNova(String strTexture) {
		ZGHelper.setTab(this);
		this.setNameAndTexture(strTexture);
	}
	
	public static void registerItemOre(String strName, Item item) {
		OreDictionaryNova.registerOre(strName, item);
	}
	
	public void setName(String strName) {
		ZGHelper.setName(this, strName);
	}
	
	public void setTexture(String strTexture) {
		ZGHelper.setTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strTexture) {
		ZGHelper.setNameAndTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strName, String strTexture) {
		ZGHelper.setNameAndTexture(this, strName, strTexture);
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ZollernGalaxyCore.novaTabItems;
	}
}