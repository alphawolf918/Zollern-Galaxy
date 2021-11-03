/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.proxy.IProxy;

public class ZGItemBase extends Item implements ISingleZGItemRender {
	
	protected IProxy proxy = ZollernGalaxyCore.proxy;
	
	public ZGItemBase(String name) {
		super();
		this.setItemName(this, name);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem(name);
		}
	}
	
	public void setItemName(final Item item, final String itemName) {
		item.setUnlocalizedName(itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZGTabs.zgItemsTab;
	}
	
	@Override
	public String getName() {
		return this.getUnlocalizedName().substring(5);
	}
}