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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
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

public class ItemEnderSword extends ZGItemSword {
	
	public ItemEnderSword() {
		super("ender", ZGToolMats.ASCENDANT);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		int length = 100;
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY + playerIn.getEyeHeight(), playerIn.posZ);
		Vec3d endPos = startPos.add(new Vec3d(playerIn.getLookVec().x * length, playerIn.getLookVec().y * length, playerIn.getLookVec().z * length));
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		this.checkBlockAt(vecPos.getX(), vecPos.getY(), vecPos.getZ(), worldIn, playerIn);
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	/**
	 * Recursive function, checks to ensure a block is not present at the
	 * desired teleport location, and if it is, adds 2 to the Y coordinate.
	 * Repeats until it finds an empty spot.
	 */
	private void checkBlockAt(double posX, double posY, double posZ, World world, EntityPlayer entityplayer) {
		if (world.getBlockState(new BlockPos(posX, posY, posZ)) == Blocks.AIR.getDefaultState()) {
			this.playEnderSound(world, entityplayer, posX, posY, posZ);
			entityplayer.attemptTeleport(posX, posY, posZ);
			for (int t = 1; t < 10; t++) {
				world.spawnParticle(EnumParticleTypes.PORTAL, posX + 5.0D, posY + 5.0D, posZ + 5.0D, 0, 0, 0);
			}
		} else {
			checkBlockAt(posX, posY + 2, posZ, world, entityplayer);
		}
	}
	
	private void playEnderSound(World world, EntityPlayer entityPlayer, double posX, double posY, double posZ) {
		world.playSound(entityPlayer, new BlockPos(posX + 0.5D, posY + 0.5D, posZ + 0.5D), SoundEvents.ENTITY_ENDERMEN_TELEPORT, SoundCategory.MASTER, 2.0F,
				world.rand.nextFloat() * 0.1F + 0.9F);
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
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.endersword1"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.endersword2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}