/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.tools.keys;

import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.ZGItemBase;

public class ItemKeyZG extends ZGItemBase implements IKeyItem, ISortableItem {
	
	private int tier = 1;
	
	public ItemKeyZG(String name, int tierIn) {
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.setTier(tierIn);
	}
	
	public ItemKeyZG(String name) {
		this(name, 1);
	}
	
	public Item setTier(int tierIn) {
		this.tier = tierIn;
		return this;
	}
	
	public int getTier() {
		return this.tier;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
	}
	
	@Override
	public int getTier(ItemStack keyStack) {
		return this.getTier();
	}
	
	@Override
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.KEYS;
	}
}