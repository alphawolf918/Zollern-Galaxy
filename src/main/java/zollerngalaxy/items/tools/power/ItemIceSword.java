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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.tools.ZGItemSword;
import zollerngalaxy.items.tools.ZGToolMats;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemIceSword extends ZGItemSword {
	
	public ItemIceSword() {
		super("ice", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		
		int length = 100;
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY + playerIn.getEyeHeight(), playerIn.posZ);
		Vec3d endPos = startPos.add(new Vec3d(playerIn.getLookVec().x * length, playerIn.getLookVec().y * length, playerIn.getLookVec().z
				* length));
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		
		int i = vecPos.getX();
		int j = vecPos.getY();
		int k = vecPos.getZ();
		
		for (int l = 0; l < 8; l++) {
			int j2 = j + l;
			worldIn.setBlockState(new BlockPos(i, j2, k), Blocks.PACKED_ICE.getDefaultState());
			if (j2 < 256) {
				worldIn.setBlockState(new BlockPos(i, (j2 + 1), k), Blocks.PACKED_ICE.getDefaultState());
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
		if (entity instanceof EntityLiving) {
			EntityLiving ent = (EntityLiving) entity;
			ent.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 300, 5));
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.icesword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.icesword2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}