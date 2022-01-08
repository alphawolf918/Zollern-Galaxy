/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util;

import micdoodle8.mods.galacticraft.api.entity.IRocketType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class CachedEnumZG {
	
	private static EnumHand[] handValues = EnumHand.values();
	private static EnumDyeColor[] dyeColorValues = EnumDyeColor.values();
	private static IRocketType.EnumRocketType[] rocketValues = IRocketType.EnumRocketType.values();
	private static BiomeType[] biomeValues = BiomeType.values();
	private static Axis[] axisValues = Axis.values();
	private static TextFormatting[] textFormatValues = TextFormatting.values();
	
	public static EnumHand[] valuesHandCached() {
		return CachedEnumZG.handValues;
	}
	
	public static EnumDyeColor[] valuesDyeCached() {
		return CachedEnumZG.dyeColorValues;
	}
	
	public static IRocketType.EnumRocketType[] valuesRocketCached() {
		return CachedEnumZG.rocketValues;
	}
	
	public static BiomeType[] valuesBiomeCached() {
		return CachedEnumZG.biomeValues;
	}
	
	public static Axis[] valuesAxisCached() {
		return CachedEnumZG.axisValues;
	}
	
	public static TextFormatting[] valuesTextFormattingCached() {
		return CachedEnumZG.textFormatValues;
	}
}