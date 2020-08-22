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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.tools.ZGItemSword;
import zollerngalaxy.items.tools.ZGToolMats;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemWitherSword extends ZGItemSword {
	
	public ItemWitherSword() {
		super("wither", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		if (!worldIn.isRemote) {
			ItemStack par1ItemStack = playerIn.getHeldItem(handIn);
			Vec3d look = playerIn.getLookVec();
			EntityWitherSkull witherskull = new EntityWitherSkull(worldIn);
			witherskull.setPosition(playerIn.posX + look.x * 5, playerIn.posY + 1 + look.y * 5, playerIn.posZ + look.z * 5);
			witherskull.accelerationX = look.x * 0.1;
			witherskull.accelerationY = look.y * 0.1;
			witherskull.accelerationZ = look.z * 0.1;
			worldIn.spawnEntity(witherskull);
			if (!playerIn.capabilities.isCreativeMode) {
				par1ItemStack.damageItem(5, playerIn);
			}
		}
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, Entity entity) {
		super.onLeftClickEntity(par1ItemStack, par2EntityPlayer, entity);
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase living = (EntityLivingBase) entity;
			living.addPotionEffect(new PotionEffect(MobEffects.WITHER, 60, 2));
			this.playWitherSound(living.getEntityWorld(), living.posX, living.posY, living.posZ);
		}
		return false;
	}
	
	private void playWitherSound(World world, double i, double j, double k) {
		world.playSound(i + 5.0D, j + 5.0D, k + 5.0D, SoundEvents.ENTITY_WITHER_AMBIENT, SoundCategory.AMBIENT, 1.0F,
				world.rand.nextFloat() * 0.1F + 0.9F, true);
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
	public int getItemEnchantability() {
		return 80;
	}
	
	@Override
	public float getAttackDamage() {
		return 20F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.withersword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.withersword2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}