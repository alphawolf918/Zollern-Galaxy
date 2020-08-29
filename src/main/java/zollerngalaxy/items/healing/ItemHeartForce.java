/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.healing;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemHeartForce extends ItemHeart {
	
	public ItemHeartForce() {
		super("heartforce");
		this.setMaxDamage(1);
	}
	
	/**
	 * Increases the max health of the Player.
	 * 
	 * @param playerIn
	 *            The Player to affect.
	 */
	private void increasePlayerHealth(EntityPlayer playerIn) {
		World world = playerIn.world;
		if (!world.isRemote) {
			if (!playerIn.capabilities.isCreativeMode) {
				double maxHealthLimit = ConfigManagerZG.maxHealthAllowed;
				double increaseAmount = ConfigManagerZG.maxHealthIncreasedBy;
				float maxHealth = playerIn.getMaxHealth();
				IAttribute MAX_HEALTH = SharedMonsterAttributes.MAX_HEALTH;
				IAttributeInstance attrHeartMax = playerIn.getEntityAttribute(MAX_HEALTH);
				double attrMaxHearts = attrHeartMax.getAttributeValue();
				if (attrMaxHearts < maxHealthLimit) {
					maxHealth += increaseAmount;
					attrHeartMax.setBaseValue(maxHealth);
					ZGHelper.damageItemStack(this, 1, playerIn);
					String tooltip1 = ZGUtils.translate("tooltips.newhealth");
					String tooltip2 = ZGUtils.translate("tooltips.newhealth2");
					String tooltip3 = ZGUtils.translate("tooltips.hearts");
					this.proxy.sendChatMessage(playerIn, "+" + (int) increaseAmount + " " + tooltip1 + "!");
					this.proxy.sendChatMessage(playerIn, tooltip2 + (int) maxHealth + " " + tooltip3);
					this.healPlayer(playerIn);
				} else {
					String tooltip4 = ZGUtils.translate("tooltips.maxhealthtoohigh");
					this.proxy.sendChatMessage(playerIn, tooltip4 + " " + maxHealthLimit + ".");
				}
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		this.increasePlayerHealth(playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.RARE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate("tooltips.healthincrease"));
		} else {
			tooltip.add(TextFormatting.GOLD + ZGUtils.translate("tooltips.holdshift"));
		}
	}
}