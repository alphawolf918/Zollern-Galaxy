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
import zollerngalaxy.items.ZGItemBase;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemMedkit extends ZGItemBase {
	
	public ItemMedkit() {
		super("medkit");
		this.setMaxDamage(1);
		this.setMaxStackSize(1);
	}
	
	/**
	 * Heal the Player to max health.
	 * 
	 * @param playerIn
	 *            The Player to affect.
	 */
	protected void healPlayer(EntityPlayer playerIn) {
		World world = playerIn.world;
		if (!world.isRemote) {
			if (!playerIn.capabilities.isCreativeMode) {
				float maxHealth = playerIn.getMaxHealth();
				float currentHealth = playerIn.getHealth();
				if (currentHealth < maxHealth) {
					playerIn.setHealth(maxHealth);
					ZGHelper.damageItemStack(this, 1, playerIn);
					this.proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.healthrestored"));
				} else {
					this.proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.maxhealth"));
				}
			}
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		this.healPlayer(playerIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.UNCOMMON;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate("tooltips.heart"));
		} else {
			tooltip.add(TextFormatting.GOLD + ZGUtils.translate("tooltips.holdshift"));
		}
	}
	
}