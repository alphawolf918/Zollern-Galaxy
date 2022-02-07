/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.items;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.util.ZGUtils;

public class ItemFuelBase extends ZGItemBase {
	
	private int burnTime = 1600;
	
	public ItemFuelBase(String itemName, int timeBurn) {
		super(itemName);
		this.setItemBurnTime(timeBurn);
	}
	
	public ItemFuelBase(String itemName) {
		this(itemName, 1600);
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return this.burnTime;
	}
	
	public Item setItemBurnTime(int timeBurn) {
		this.burnTime = timeBurn;
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(ZGUtils.translate("tooltips.burnrate") + ": " + this.getItemBurnTime(par1ItemStack));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
}