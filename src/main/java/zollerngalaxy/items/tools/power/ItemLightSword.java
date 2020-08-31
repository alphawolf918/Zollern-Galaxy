/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.tools.power;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.tools.ZGItemSword;
import zollerngalaxy.items.tools.ZGToolMats;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.util.ZGDamageSrc;
import zollerngalaxy.util.ZGUtils;

public class ItemLightSword extends ZGItemSword {
	
	public ItemLightSword() {
		super("light", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		playerIn.addPotionEffect(new PotionEffect(ZGPotions.radiance, ZGPotions.radianceTime, 0));
		
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.BLOCK;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return EnumRarity.EPIC;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		if (entity instanceof EntityLiving) {
			EntityLiving ent = (EntityLiving) entity;
			EnumCreatureAttribute attrCreature = ent.getCreatureAttribute();
			if (attrCreature == EnumCreatureAttribute.UNDEAD) {
				World world = ent.world;
				if (!world.isRemote) {
					ent.setDead();
				}
			}
			if (ent instanceof IShadeEntity) {
				ent.attackEntityFrom(ZGDamageSrc.deathLight, ZGDamageSrc.deathLight.getDamageBase());
			}
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.lightsword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.lightsword2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}