/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.compat.tconstruct.traits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import zollerngalaxy.mobs.entities.interfaces.ICorruptEntity;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.util.ZGDamageSrc;

public class TraitCorrupted extends AbstractTrait {
	
	public TraitCorrupted() {
		super("trait_corrupted", 0x8b008b);
	}
	
	@Override
	public void afterHit(ItemStack tool, EntityLivingBase player, EntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit) {
		int dmg = Math.round(damageDealt) * 10;
		dmg = (target instanceof ICorruptEntity) ? 0 : dmg;
		target.addPotionEffect(new PotionEffect(ZGPotions.corruption, dmg, 2));
		if (!(target instanceof EntityPlayer)) {
			target.attackEntityFrom(ZGDamageSrc.deathCorruption, ZGDamageSrc.deathCorruption.getDamageBase());
		}
	}
}