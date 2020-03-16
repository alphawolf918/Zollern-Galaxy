/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGItemShovel extends ItemSpade implements ISingleZGItemRender {
	
	protected String toolType = "shovel";
	
	public ZGItemShovel(String toolMetalName, ToolMaterial toolMatIn) {
		super(toolMatIn);
		this.setItemName(this, toolMetalName + "_" + this.toolType);
		this.initJSONFactory();
	}
	
	private void initJSONFactory() {
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			if (this.getName() != "" && this.getName() != null) {
				JSONFactory.registerTool(this.getName());
			}
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