/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import zollerngalaxy.config.ConfigManagerZG;

public class ItemSweetFood extends ZGItemFood {
	
	protected Potion mobEffect = null;
	
	public ItemSweetFood(String name, Potion potionIn) {
		super(name, 4, 6, false);
		this.setAlwaysEdible();
		this.mobEffect = potionIn;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		if (!worldIn.isRemote && this.mobEffect != null && ConfigManagerZG.enableSweetFoodPotionEffects) {
			player.addPotionEffect(new PotionEffect(mobEffect, 3600, 2, true, false));
		}
	}
}