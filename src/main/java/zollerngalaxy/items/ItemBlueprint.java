/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemBlueprint extends ZGItemBase {
	
	protected String tooltipTxt = "tooltips.blueprint";
	
	public ItemBlueprint(String blueprintName) {
		super("blueprint_" + blueprintName);
		this.setMaxStackSize(1);
		this.setMaxDamage(2000);
	}
	
	public Item setTooltipText(String textIn) {
		this.tooltipTxt = textIn;
		return this;
	}
	
	public String getToolTipText() {
		return this.tooltipTxt;
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack) {
		return EnumRarity.EPIC;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(TextFormatting.GREEN + ZGUtils.translate(this.getToolTipText()));
		} else {
			tooltip.add(TextFormatting.GOLD + ZGUtils.translate("tooltips.holdshift"));
		}
	}
}