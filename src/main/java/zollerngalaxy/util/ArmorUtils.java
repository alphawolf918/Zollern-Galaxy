/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.armor.ZGArmor;
import zollerngalaxy.items.armor.ZGArmorMats;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.potions.ZGPotions;

public class ArmorUtils {
	
	public static void performArmorCheck(EntityPlayer player) {
		InventoryPlayer playerInventory = player.inventory;
		NonNullList<ItemStack> armorInventory = playerInventory.armorInventory;
		
		// Initialize the count for each armor type.
		int amArmorCount = 0;
		int zArmorCount = 0;
		int azArmorCount = 0;
		int rArmorCount = 0;
		
		// Loop through the player's armor inventory, and check
		// to see if it isn't null. If not, check that it's an
		// instance of ZGArmor. For each material, check
		// the type of armor, and increment the armor count
		// variables for each one that it finds.
		for (ItemStack armorStack : armorInventory) {
			if (armorStack != null) {
				if (armorStack.getItem() instanceof ZGArmor) {
					ZGArmor armorItem = (ZGArmor) armorStack.getItem();
					ArmorMaterial armorMat = armorItem.getArmorMaterial();
					if (armorMat == ZGArmorMats.AMARANTH) {
						amArmorCount++;
					} else if (armorMat == ZGArmorMats.ZOLLERNIUM) {
						zArmorCount++;
					} else if (armorMat == ZGArmorMats.AZURITE) {
						azArmorCount++;
					} else if (armorMat == ZGArmorMats.RADIUM) {
						rArmorCount++;
					}
				}
			}
		}
		
		// Loop through 0 to 4 and if an armor set's increment variable is
		// equal to 4; add its respective potion effect.
		boolean fullSetWorn = false;
		for (int i = 0; i < 4; ++i) {
			if (amArmorCount == 4) {
				// Amaranth
				player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 100, 1, false, false));
			} else if (zArmorCount == 4) {
				// Zollernium
				player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 100, 1, false, false));
				if (ConfigManagerZG.enableStepHeight) {
					player.stepHeight = 2F;
					fullSetWorn = true;
				}
			} else if (azArmorCount == 4) {
				// Azurite
				player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 100, 2, false, false));
			} else if (rArmorCount == 4) {
				// Radium
				player.addPotionEffect(new PotionEffect(ZGPotions.radiance, 100, 1, false, false));
				if (ConfigManagerZG.enableRadianceFlying) {
					if (!ModHelperBase.useDraconicEvolution) {
						player.capabilities.allowFlying = true;
					}
				}
			} else {
				// Disable all "extra" potion capabilities that have nothing
				// to do with effects. If we don't do this, then the armor's
				// effects (not the potion's, but the armor's) will last.
				if (ConfigManagerZG.enableStepHeight && fullSetWorn) {
					player.stepHeight = 0.5F;
					fullSetWorn = false;
				}
				if (!player.capabilities.isCreativeMode && ConfigManagerZG.enableRadianceFlying) {
					if (!ModHelperBase.useDraconicEvolution) {
						player.capabilities.allowFlying = false;
					}
				}
			}
		}
	}
}