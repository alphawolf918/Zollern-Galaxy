/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.armor;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import zollerngalaxy.lib.ZGInfo;

public abstract class ZGArmorMats {
	
	public static final ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial("Amaranth", ZGInfo.MOD_ID + ":amaranth", 60, new int[] { 4, 9, 6, 3 }, 31,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F);
	public static final ArmorMaterial AZURITE = EnumHelper.addArmorMaterial("Azurite", ZGInfo.MOD_ID + ":azurite", 70, new int[] { 5, 9, 6, 4 }, 41,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.8F);
	public static final ArmorMaterial ZOLLERNIUM = EnumHelper.addArmorMaterial("Zollernium", ZGInfo.MOD_ID + ":zollernium", 80, new int[] { 7, 9, 8, 6 }, 61,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.2F);
	public static final ArmorMaterial RADIUM = EnumHelper.addArmorMaterial("Radium", ZGInfo.MOD_ID + ":radium", 90, new int[] { 9, 9, 9, 9 }, 71,
			SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.6F);
	
}