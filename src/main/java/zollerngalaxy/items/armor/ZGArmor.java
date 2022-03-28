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
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.util.ZGUtils;

public class ZGArmor extends ItemArmor implements ISingleZGItemRender {
	
	protected static final int MAX_NOVA_LEVEL = ZGInfo.MAX_NOVA_LEVEL;
	private String nbtTag = "NovaLevel";
	
	public ZGArmor(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, String itemName) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setItemName(this, itemName);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem(itemName);
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
	public void onCreated(ItemStack stack, World worldIn, EntityPlayer playerIn) {
		this.initArmorData(stack);
	}
	
	protected void initArmorData(ItemStack stack) {
		this.setNovaLevel(stack, 25);
	}
	
	public int getMaxNovaLevel() {
		return this.MAX_NOVA_LEVEL;
	}
	
	public int getNovaLevel(ItemStack stack) {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey(nbtTag)) {
			return stack.getTagCompound().getInteger(nbtTag);
		}
		return 0;
	}
	
	public ZGArmor setNovaLevel(ItemStack stack, int novaLevelIn) {
		if (novaLevelIn <= this.MAX_NOVA_LEVEL && novaLevelIn >= 0) {
			NBTTagCompound nbt = (stack.hasTagCompound()) ? stack.getTagCompound() : new NBTTagCompound();
			nbt.setInteger(nbtTag, novaLevelIn);
			stack.setTagCompound(nbt);
		}
		return this;
	}
	
	public void increaseNovaLevel(ItemStack stack, int novaLevelIncreaseIn) {
		int nova = this.getNovaLevel(stack);
		int increase = MathHelper.abs(novaLevelIncreaseIn);
		int novaLevelNew = (nova + increase);
		if (novaLevelNew > this.getMaxNovaLevel()) {
			return;
		}
		this.setNovaLevel(stack, novaLevelNew);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		int nova = this.getNovaLevel(stack);
		String boldGold = TextFormatting.GOLD + "" + TextFormatting.BOLD + nova;
		tooltip.add(TextFormatting.LIGHT_PURPLE + ZGUtils.translate("tooltips.nova_level") + ": " + boldGold);
	}
}