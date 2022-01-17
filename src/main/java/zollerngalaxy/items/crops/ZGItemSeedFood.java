/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.crops;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeedFood;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.IJSONtem;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.proxy.IProxy;

public class ZGItemSeedFood extends ItemSeedFood implements ISingleZGItemRender, IJSONtem {
	
	protected IProxy proxy = ZollernGalaxyCore.instance().proxy;
	
	public ZGItemSeedFood(String name, int healAmount, float saturation, Block crops) {
		super(healAmount, saturation, crops, Blocks.FARMLAND);
		this.setItemName(this, name);
		if (ZollernGalaxyCore.instance().isInDevMode() && !this.shouldJSONIgnore()) {
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