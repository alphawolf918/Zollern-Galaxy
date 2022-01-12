/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;

public class EnchantmentListZG {
	
	private static int totalEnchantments = 0;
	
	/**
	 * Enchantment for weapons, applies the Radiance potion effect to whatever's
	 * hit, causing extra damage to IShadeEntity (shadow) mobs.
	 */
	public static Enchantment enlightened = new EnchantmentEnlightened();
	
	public static void init() {
		EnchantmentListZG.registerEnchantment(enlightened, "enlightened");
		ZGHelper.Log("Loaded " + totalEnchantments + " Enchantments.");
	}
	
	private static void registerEnchantment(Enchantment enchantment, String name) {
		ForgeRegistries.ENCHANTMENTS.register(enchantment.setRegistryName(ZGInfo.MOD_ID, name));
		totalEnchantments++;
	}
	
}