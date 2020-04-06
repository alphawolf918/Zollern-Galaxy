/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.tools;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.ZGItemBase;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemBedrockBreaker extends ZGItemBase {
	
	private int maxUses = 5;
	
	public ItemBedrockBreaker() {
		super("bedrockbreaker");
		this.setMaxDamage(this.maxUses);
		this.setMaxStackSize(1);
	}
	
	// First thing this does is it checks to make sure the world isn't remote,
	// which basically just tells it not to do ghost things. Second, we get the
	// Block that the Player is right-clicking on, and compare it to Bedrock. If
	// it is a match, we retrieve the currently held item in their hand that
	// they're currently using, and we check its durability damage. If its less
	// than the max damage it can have, spawn between 1 and 2 Rokkite gems, and
	// set the Bedrock Block to air. If the Player is not in Creative Mode,
	// damage the tool one time. If it is not a match, play a sound event that
	// lets the user know that it's broken.
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX,
			float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			IBlockState blockState = worldIn.getBlockState(pos);
			Block block = blockState.getBlock();
			if (block == Blocks.BEDROCK) {
				ItemStack heldItem = player.getHeldItem(hand);
				int toolDamage = this.getDamage(heldItem);
				if (toolDamage < this.getMaxDamage(heldItem)) {
					Item rokkite = ZGItems.rokkite;
					ItemStack rokkiteStack = new ItemStack(rokkite, ZGHelper.rngInt(1, 2));
					EntityItem rokkiteItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), rokkiteStack);
					worldIn.spawnEntity(rokkiteItem);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
					if (!player.capabilities.isCreativeMode) {
						this.setDamage(heldItem, toolDamage + 1);
					}
				} else {
					worldIn.playSound(player, hitX, hitY, hitZ, SoundEvents.ENTITY_ITEM_BREAK, SoundCategory.MASTER, 4.0F,
							(1.0F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.2F) * 0.7F);
				}
				return EnumActionResult.PASS;
			}
		}
		return EnumActionResult.FAIL;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(ZGUtils.translate("tooltips.bedrockbreaker1"));
			tooltip.add(ZGUtils.translate("tooltips.bedrockbreaker2"));
			tooltip.add(ZGUtils.translate("tooltips.bedrockbreaker3"));
			tooltip.add(ZGUtils.translate("tooltips.bedrockbreaker4"));
			tooltip.add(ZGUtils.translate("tooltips.bedrockbreaker5"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
	
}