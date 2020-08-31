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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.tools.ZGItemSword;
import zollerngalaxy.items.tools.ZGToolMats;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemFireSword extends ZGItemSword {
	
	public ItemFireSword() {
		super("fire", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		if (!worldIn.isRemote) {
			ItemStack par1ItemStack = playerIn.getHeldItem(handIn);
			Vec3d look = playerIn.getLookVec();
			EntityLargeFireball fireball = new EntityLargeFireball(worldIn);
			fireball.setPosition(playerIn.posX + look.x * 5, playerIn.posY + 1 + look.y * 5, playerIn.posZ + look.z * 5);
			fireball.accelerationX = look.x * 0.1;
			fireball.accelerationY = look.y * 0.1;
			fireball.accelerationZ = look.z * 0.1;
			worldIn.spawnEntity(fireball);
			if (!playerIn.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, playerIn);
			}
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
		entity.setFire(20);
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.firesword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.firesword2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}