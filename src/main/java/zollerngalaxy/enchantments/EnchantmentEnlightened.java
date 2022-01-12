/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.enchantments;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.potions.ZGPotions;

public class EnchantmentEnlightened extends ZGEnchantment {
	
	public static float lightDamageBase = 5.0F;
	
	public EnchantmentEnlightened() {
		super(Rarity.VERY_RARE, EnumEnchantmentType.WEAPON, new EntityEquipmentSlot[] { EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND });
		this.setEnchantmentName("enlightened");
	}
	
	// This is where the "effect" of the Enchantment lives. For the 'damage causing' kind, at least.
	// Radiance Time = 6000 / 4 = 1500 / 20 = 75 seconds.
	@Override
	public void onEntityDamaged(EntityLivingBase user, Entity par2TargetEntity, int level) {
		if (par2TargetEntity instanceof EntityLivingBase && !(par2TargetEntity instanceof EntityPlayer)) {
			EntityLivingBase targetEntity = (EntityLivingBase) par2TargetEntity;
			if (targetEntity instanceof IShadeEntity) {
				targetEntity.addPotionEffect(new PotionEffect(ZGPotions.radiance, (ZGPotions.radianceTime / 4), level));
				lightDamageBase *= level;
			}
		}
	}
	
	@Override
	public boolean canApply(ItemStack stack) {
		Item item = stack.getItem();
		return (item instanceof ItemSword || item instanceof ItemBow) ? true : super.canApply(stack);
	}
	
	@Override
	public int getMaxLevel() {
		return 6;
	}
}