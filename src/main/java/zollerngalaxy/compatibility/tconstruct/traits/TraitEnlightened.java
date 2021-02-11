/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compatibility.tconstruct.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import zollerngalaxy.mobs.entities.interfaces.ICorruptEntity;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.potions.ZGPotions;

public class TraitEnlightened extends AbstractTrait {
	
	public TraitEnlightened() {
		super("trait_enlightened", 0xffff00);
	}
	
	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		int dmg = Math.round(damageDealt) * 10;
		dmg *= ((target instanceof IShadeEntity) || (target instanceof ICorruptEntity)) ? 4 : 1;
		target.addPotionEffect(new PotionEffect(ZGPotions.radiance, dmg, 2));
	}
}