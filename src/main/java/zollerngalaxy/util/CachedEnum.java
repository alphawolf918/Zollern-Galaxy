package zollerngalaxy.util;

import micdoodle8.mods.galacticraft.api.entity.IRocketType;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class CachedEnum {
	
	private static EnumHand[] handValues = EnumHand.values();
	private static EnumDyeColor[] dyeColorValues = EnumDyeColor.values();
	private static IRocketType.EnumRocketType[] rocketValues = IRocketType.EnumRocketType.values();
	private static BiomeType[] biomeValues = BiomeType.values();
	private static Axis[] axisValues = Axis.values();
	private static TextFormatting[] textFormatValues = TextFormatting.values();
	
	public static EnumHand[] valuesHandCached() {
		return CachedEnum.handValues;
	}
	
	public static EnumDyeColor[] valuesDyeCached() {
		return CachedEnum.dyeColorValues;
	}
	
	public static IRocketType.EnumRocketType[] valuesRocketCached() {
		return CachedEnum.rocketValues;
	}
	
	public static BiomeType[] valuesBiomeCached() {
		return CachedEnum.biomeValues;
	}
	
	public static Axis[] valuesAxisCached() {
		return CachedEnum.axisValues;
	}
	
	public static TextFormatting[] valuesTextFormattingCached() {
		return CachedEnum.textFormatValues;
	}
}