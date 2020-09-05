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
import zollerngalaxy.potions.ZGPotions;

public class TraitInfection extends AbstractTrait {
	
	public TraitInfection() {
		super("trait_infection", 0x000000);
	}
	
	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical,
			boolean wasHit) {
		target.addPotionEffect(new PotionEffect(ZGPotions.infected, Math.round(damageDealt) * 10, 1));
	}
}