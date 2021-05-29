/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.items.armor;

import java.util.List;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.planets.venus.items.ItemThermalPaddingTier2;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.util.ZGUtils;

public class ZGThermalArmor extends ItemThermalPaddingTier2 implements ISingleZGItemRender {
	
	public static String[] names = { "zgthermal_helm_t3", "zgthermal_chestplate_t3", "zgthermal_leggings_t3", "zgthermal_boots_t3" };
	
	public ZGThermalArmor(String assetName) {
		super(assetName);
		this.setItemName(this, assetName);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem("zgthermal_helm_t3");
			JSONFactory.registerItem("zgthermal_chestplate_t3");
			JSONFactory.registerItem("zgthermal_leggings_t3");
			JSONFactory.registerItem("zgthermal_boots_t3");
		}
	}
	
	public void setItemName(final Item item, final String itemName) {
		item.setUnlocalizedName(itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZGTabs.zgItemsTab;
	}
	
	@Override
	public String getName() {
		return this.getUnlocalizedName().substring(5);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		if (names.length > par1ItemStack.getItemDamage()) {
			return "item." + ZGThermalArmor.names[par1ItemStack.getItemDamage()];
		}
		
		return "unnamed";
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add(ZGUtils.translate("tooltips.thermal_armor_t3"));
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (tab == ZGTabs.zgItemsTab || tab == CreativeTabs.SEARCH) {
			for (int i = 0; i < ZGThermalArmor.names.length; i++) {
				subItems.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public int getThermalStrength() {
		return 3;
	}
}