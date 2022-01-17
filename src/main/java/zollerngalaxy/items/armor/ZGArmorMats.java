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
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;
import zollerngalaxy.lib.ZGInfo;

public abstract class ZGArmorMats {
	
	private static final SoundEvent DIAMOND_EQUIP = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	private static final SoundEvent GENERIC_EQUIP = SoundEvents.ITEM_ARMOR_EQUIP_GENERIC;
	
	public static final ArmorMaterial WOOD = EnumHelper.addArmorMaterial("Wood", ZGInfo.MOD_ID + ":wood", 8, new int[] { 2, 3, 4, 2 }, 4, GENERIC_EQUIP, 0.1F);
	public static final ArmorMaterial STONE = EnumHelper.addArmorMaterial("Stone", ZGInfo.MOD_ID + ":stone", 11, new int[] { 3, 4, 5, 3 }, 6, GENERIC_EQUIP, 0.2F);
	public static final ArmorMaterial RUBY = EnumHelper.addArmorMaterial("Ruby", ZGInfo.MOD_ID + ":ruby", 21, new int[] { 5, 4, 2, 8 }, 16, GENERIC_EQUIP, 0.2F);
	public static final ArmorMaterial SAPPHIRE = EnumHelper.addArmorMaterial("Sapphire", ZGInfo.MOD_ID + ":sapphire", 21, new int[] { 4, 5, 5, 5 }, 16, GENERIC_EQUIP, 0.2F);
	public static final ArmorMaterial AMARANTH = EnumHelper.addArmorMaterial("Amaranth", ZGInfo.MOD_ID + ":amaranth", 60, new int[] { 4, 9, 6, 3 }, 31, GENERIC_EQUIP, 1.5F);
	public static final ArmorMaterial AZURITE = EnumHelper.addArmorMaterial("Azurite", ZGInfo.MOD_ID + ":azurite", 70, new int[] { 5, 9, 6, 4 }, 41, DIAMOND_EQUIP, 3.8F);
	public static final ArmorMaterial ZOLLERNIUM = EnumHelper.addArmorMaterial("Zollernium", ZGInfo.MOD_ID + ":zollernium", 80, new int[] { 7, 9, 8, 6 }, 61, DIAMOND_EQUIP, 4.2F);
	public static final ArmorMaterial RADIUM = EnumHelper.addArmorMaterial("Radium", ZGInfo.MOD_ID + ":radium", 90, new int[] { 9, 9, 9, 9 }, 71, DIAMOND_EQUIP, 4.6F);
	
}