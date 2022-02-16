/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.recipes;

import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;

public class TFSmeltingRecipes {
	
	public static void init() {
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenSilverOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1, 130), 3.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroSilverOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1, 130), 3.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociSilverOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1, 130), 3.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenNickelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherNickleOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xantheonNickelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroNickelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociNickelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenSteelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSteel), 1, 160), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherSteelOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSteel), 1, 160), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenBronzeOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotBronze), 1, 163), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociBronzeOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotBronze), 1, 163), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenElectrumOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotElectrum), 1, 161), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.mavethElectrumOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotElectrum), 1, 161), 6.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenInvarOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotInvar), 1, 162), 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenPlatinumOre, new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotPlatinum), 1, 134), 4.2F);
	}
}