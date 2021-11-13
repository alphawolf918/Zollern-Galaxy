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
import micdoodle8.mods.galacticraft.api.item.IItemThermal;
import micdoodle8.mods.galacticraft.core.entities.player.GCPlayerStats;
import micdoodle8.mods.galacticraft.core.items.ISortableItem;
import micdoodle8.mods.galacticraft.core.proxy.ClientProxyCore;
import micdoodle8.mods.galacticraft.core.util.EnumSortCategoryItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.items.ZGItemBase;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.util.ZGUtils;

public class ZGThermalArmor extends ZGItemBase implements ISingleZGItemRender, IItemThermal, ISortableItem {
	
	public static String[] names = { "zgthermal_helm_t3", "zgthermal_chestplate_t3", "zgthermal_leggings_t3", "zgthermal_boots_t3" };
	
	public ZGThermalArmor(String assetName) {
		super(assetName);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setMaxStackSize(1);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem("zgthermal_helm_t3");
			JSONFactory.registerItem("zgthermal_chestplate_t3");
			JSONFactory.registerItem("zgthermal_leggings_t3");
			JSONFactory.registerItem("zgthermal_boots_t3");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return ClientProxyCore.galacticraftItem;
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
	public int getMetadata(int par1) {
		return par1;
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
	
	@Override
	public boolean isValidForSlot(ItemStack stack, int armorSlot) {
		return stack.getItemDamage() == armorSlot;
	}
	
	@Override
	public EnumSortCategoryItem getCategory(int meta) {
		return EnumSortCategoryItem.ARMOR;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
		ItemStack itemStack = player.getHeldItem(hand);
		
		if (player instanceof EntityPlayerMP) {
			GCPlayerStats stats = GCPlayerStats.get(player);
			ItemStack gear = stats.getExtendedInventory().getStackInSlot(6);
			ItemStack gear1 = stats.getExtendedInventory().getStackInSlot(7);
			ItemStack gear2 = stats.getExtendedInventory().getStackInSlot(8);
			ItemStack gear3 = stats.getExtendedInventory().getStackInSlot(9);
			
			if (itemStack.getItemDamage() == 0) {
				if (gear.isEmpty()) {
					stats.getExtendedInventory().setInventorySlotContents(6, itemStack.copy());
					itemStack.setCount(0);
				}
			} else if (itemStack.getItemDamage() == 1) {
				if (gear1.isEmpty()) {
					stats.getExtendedInventory().setInventorySlotContents(7, itemStack.copy());
					itemStack.setCount(0);
				}
			} else if (itemStack.getItemDamage() == 2) {
				if (gear2.isEmpty()) {
					stats.getExtendedInventory().setInventorySlotContents(8, itemStack.copy());
					itemStack.setCount(0);
				}
			} else if (itemStack.getItemDamage() == 3) {
				if (gear3.isEmpty()) {
					stats.getExtendedInventory().setInventorySlotContents(9, itemStack.copy());
					itemStack.setCount(0);
				}
			}
		}
		return new ActionResult<>(EnumActionResult.SUCCESS, itemStack);
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
}