/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.items;

import galaxymod.ProjectNovaCore;
import galaxymod.lib.NovaHelper;
import galaxymod.lib.OreDictionaryNova;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemNova extends Item {
	
	public ItemNova(String strTexture) {
		NovaHelper.setTab(this);
		this.setNameAndTexture(strTexture);
	}
	
	public static void registerItemOre(String strName, Item item) {
		OreDictionaryNova.registerOre(strName, item);
	}
	
	public void setName(String strName) {
		NovaHelper.setName(this, strName);
	}
	
	public void setTexture(String strTexture) {
		NovaHelper.setTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strTexture) {
		NovaHelper.setNameAndTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strName, String strTexture) {
		NovaHelper.setNameAndTexture(this, strName, strTexture);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack itemStack) {
		return ClientProxyCore.galacticraftItem;
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ProjectNovaCore.novaTabItems;
	}
}