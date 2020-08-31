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
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
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

public class ItemThorSword extends ZGItemSword {
	
	public ItemThorSword() {
		super("thor", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		int length = 100;
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY + playerIn.getEyeHeight(), playerIn.posZ);
		Vec3d lookVec = playerIn.getLookVec();
		Vec3d endPos = startPos.add(new Vec3d(lookVec.x * length, lookVec.y * length, lookVec.z * length));
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		BlockPos spawnPos = new BlockPos(vecPos.getX(), vecPos.getY(), vecPos.getZ());
		for (int l = 0; l < 4; l += 4) {
			worldIn.spawnEntity(new EntityLightningBolt(worldIn, vecPos.getX(), vecPos.getY(), vecPos.getZ() + l, false));
		}
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
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.thorsword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.thorsword2"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.thorsword3"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}