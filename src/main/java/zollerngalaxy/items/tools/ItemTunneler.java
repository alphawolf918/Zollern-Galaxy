/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.tools;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
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
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.items.ZGItemBase;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;
import zollerngalaxy.worldgen.WorldGenTunnel;

public class ItemTunneler extends ZGItemBase {
	
	private static final IProxy PROXY = ZollernGalaxyCore.proxy;
	
	public ItemTunneler(String toolType, int maxDamage) {
		super(toolType + "_tunneler");
		this.setMaxStackSize(1);
		this.setMaxDamage(maxDamage);
	}
	
	/**
	 * Creates a mining tunnel.
	 * Different tool types should have different-sized tunnels.
	 */
	protected void createTunnel(World world, Random rand, BlockPos vecPos) {
		WorldGenerator tunnelGen = new WorldGenTunnel();
		tunnelGen.generate(world, rand, vecPos);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		super.onItemRightClick(worldIn, playerIn, handIn);
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		
		Random rand = new Random();
		
		if (!playerIn.capabilities.isCreativeMode) {
			itemstack.damageItem(5, playerIn);
		}
		
		int length = 25;
		
		Vec3d startPos = new Vec3d(playerIn.posX, playerIn.posY + playerIn.getEyeHeight(), playerIn.posZ);
		
		double x = playerIn.getLookVec().x;
		double y = playerIn.getLookVec().y;
		double z = playerIn.getLookVec().z;
		
		Vec3d addVec = new Vec3d(x * length, y * length, z * length);
		
		Vec3d endPos = startPos.add(addVec);
		RayTraceResult mop = worldIn.rayTraceBlocks(startPos, endPos);
		
		if (mop == null) {
			return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
		}
		
		BlockPos vecPos = new BlockPos(mop.getBlockPos());
		int j = vecPos.getY();
		
		if (j < 256) {
			this.createTunnel(worldIn, rand, vecPos);
		} else {
			PROXY.sendChatMessage(playerIn, ZGUtils.translate("tooltips.buildheight"));
		}
		
		playerIn.swingArm(handIn);
		return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack p_77613_1_) {
		return EnumRarity.EPIC;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.tunneling_tool"));
			tooltip.add(TextFormatting.ITALIC + ZGUtils.translate("tooltips.tunneling_tool2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}