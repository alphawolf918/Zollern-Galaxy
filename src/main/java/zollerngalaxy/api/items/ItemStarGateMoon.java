/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.api.items;

import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.item.Item;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.items.IJSONtem;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.proxy.IProxy;

public class ItemStarGateMoon extends ItemCustomStarGate implements ISingleZGItemRender, IJSONtem {
	
	protected ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	protected IProxy proxy = core.proxy;
	
	public ItemStarGateMoon() {
		super(ConfigManagerCore.idDimensionMoon, ConfigManagerCore.idDimensionOverworld);
		String name = "stargate_moon";
		this.setItemName(this, name);
		if (core.isInDevMode() && !this.shouldJSONIgnore()) {
			JSONFactory.registerItem(name);
		}
	}
	
	public void setItemName(final Item item, final String itemName) {
		item.setUnlocalizedName(itemName);
	}
	
	@Override
	public String getName() {
		return this.getUnlocalizedName().substring(5);
	}
}