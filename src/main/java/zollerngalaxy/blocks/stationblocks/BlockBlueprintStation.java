/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.stationblocks;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.ItemBlueprint;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class BlockBlueprintStation extends ZGBlockStationBase {
	
	public BlockBlueprintStation() {
		super("blueprintblock");
	}
	
	@Override
	protected void performStationEvent(EntityPlayer playerIn, EnumHand hand) {
		if (!playerIn.capabilities.isCreativeMode) {
			ItemStack heldItemStack = playerIn.getHeldItem(hand);
			if (heldItemStack != null) {
				Item heldItem = heldItemStack.getItem();
				if (heldItem instanceof ItemBlueprint) {
					int blueprintDamage = heldItemStack.getItemDamage();
					if (blueprintDamage > 0) {
						int blueprintNewDamage = 0;
						heldItemStack.setItemDamage(blueprintNewDamage);
						proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.blueprintrepaired"));
					} else {
						proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.blueprintfine"));
					}
				}
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(ZGUtils.translate("tooltips.blueprintstation1"));
			tooltip.add(ZGUtils.translate("tooltips.blueprintstation2"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}