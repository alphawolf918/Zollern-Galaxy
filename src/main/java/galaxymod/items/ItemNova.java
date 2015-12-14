/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.items;

import galaxymod.lib.NGHelper;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNova extends Item {
	
	public ItemNova(String strTexture) {
		NGHelper.setTab(this);
		this.setNameAndTexture(strTexture);
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
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}
}