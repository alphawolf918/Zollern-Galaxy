/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.venus.VenusItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ModHelperBase;
import zollerngalaxy.lib.helpers.ZGHelper;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

public class FurnaceRecipes {
	
	private static int totalSmeltRecipes = 0;
	
	public static void init() {
		// Zollus
		FurnaceRecipes.SmeltBlock(ZGBlocks.zolCobbleRock, ZGBlocks.zolStone, 1.5F); // Zolstone
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F); // Tin
		
		// Kriffon
		FurnaceRecipes.SmeltBlock(ZGBlocks.kriffCobbleRock, ZGBlocks.kriffStone, 1.5F); // Kriffstone
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffCobaltOre, ZGItems.ingotCobalt, 1.6F); // Cobalt
		
		// Purgot
		FurnaceRecipes.SmeltBlock(ZGBlocks.purgCobbleRock, ZGBlocks.purgStone, 1.5F); // Purgrock
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F); // Lead
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F); // Tin
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgAluminumOre, new ItemStack(GCItems.basicItem, 1, 5), 2.4F); // Aluminum
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgCobaltOre, ZGItems.ingotCobalt, 1.6F); // Cobalt
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgEveniumOre, ZGItems.ingotEvenium, 3.6F); // Evenium
		
		// Eden
		FurnaceRecipes.SmeltBlock(ZGBlocks.edenCobbleRock, ZGBlocks.edenStone, 1.5F); // Eden
																						// Stone
		FurnaceRecipes.SmeltBlock(ZGBlocks.edenBloodSand, Blocks.GLASS, 0.5F); // Glass
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F); // Tin
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenAluminumOre, new ItemStack(GCItems.basicItem, 1, 5), 2.4F); // Aluminum
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F); // Lead
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenCobaltOre, ZGItems.ingotCobalt, 1.6F); // Cobalt
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenEveniumOre, ZGItems.ingotEvenium, 3.6F); // Evenium
		
		// Xathius
		FurnaceRecipes.SmeltBlock(ZGBlocks.xathCobble, ZGBlocks.xathStone, 1.5F); // Xath
																					// Stone
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F); // Tin
		
		// Other mod metals
		if (ModHelperBase.useCofh && ModHelperBase.useThermalFoundation) {
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenSilverOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1, 130), 3.7F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroSilverOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1, 130), 3.7F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenNickelOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xantheonNickelOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroNickelOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1, 133), 3.5F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenSteelOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSteel), 1, 160), 4.2F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenBronzeOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotBronze), 1, 163), 4.2F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenElectrumOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotElectrum), 1, 161), 4.2F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenInvarOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotInvar), 1, 162), 4.2F);
			FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenPlatinumOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotPlatinum), 1, 134), 4.2F);
		}
		
		// Oasis
		FurnaceRecipes.SmeltBlock(ZGBlocks.oasisCobble, ZGBlocks.oasisStone, 1.5F);// Oasis
																					// Stone
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisIronOre, Items.IRON_INGOT, 2.1F); // Iron
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F); // Tin
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F); // Lead
		
		// Xantheon
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xantheonIronOre, Items.IRON_INGOT, 3.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xantheonAmaranthOre, ZGItems.ingotAmaranth, 3.6F);
		
		// Atheon
		FurnaceRecipes.SmeltBlock(ZGBlocks.atheonCobble, ZGBlocks.atheonStone, 1.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.atheonAmaranthOre, ZGItems.ingotAmaranth, 2.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.atheonTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.atheonZollerniumOre, ZGItems.ingotZollernium, 3.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.atheonZincOre, ZGItems.ingotZinc, 3.6F);
		
		// Perdita
		FurnaceRecipes.SmeltBlock(ZGBlocks.perdCobble, ZGBlocks.perdStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.perdIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.perdGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.perdZollerniumOre, ZGItems.ingotZollernium, 7.2F);
		
		// Altum
		FurnaceRecipes.SmeltBlock(ZGBlocks.altumCobble, ZGBlocks.altumStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumZollerniumOre, ZGItems.ingotZollernium, 7.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumEveniumOre, ZGItems.ingotEvenium, 6.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumRhodiumOre, ZGItems.ingotRhodium, 9.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.altumAmaranthOre, ZGItems.ingotAmaranth, 4.2F);
		
		// Caligro
		FurnaceRecipes.SmeltBlock(ZGBlocks.caligroCobblestone, ZGBlocks.caligroStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroAmaranthOre, ZGItems.ingotAmaranth, 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroShiniumOre, ZGItems.ingotShinium, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroZincOre, ZGItems.ingotZinc, 3.6F);
		
		// Dust -> Ingots/Gems
		FurnaceRecipes.SmeltItem(ZGItems.dustDiamond, Items.DIAMOND, 2.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustEmerald, Items.EMERALD, 3.2F);
		FurnaceRecipes.SmeltItem(ZGItems.dustCobalt, ZGItems.ingotCobalt, 2.4F);
		FurnaceRecipes.SmeltItem(ZGItems.dustEvenium, ZGItems.ingotEvenium, 2.8F);
		FurnaceRecipes.SmeltItem(ZGItems.dustVirinium, ZGItems.ingotVirinium, 2.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustShinestone, ZGItems.ingotShinestone, 2.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustShinium, ZGItems.ingotShinium, 4.2F);
		FurnaceRecipes.SmeltItem(ZGItems.dustFueltonium, ZGItems.ingotFueltonium, 5.4F);
		FurnaceRecipes.SmeltItem(ZGItems.dustAmaranth, ZGItems.ingotAmaranth, 5.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustZollernium, ZGItems.ingotZollernium, 5.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustZinc, ZGItems.ingotZinc, 5.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustZucrite, ZGItems.ingotZucrite, 5.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustRhodium, ZGItems.ingotRhodium, 5.6F);
		FurnaceRecipes.SmeltItem(ZGItems.perdEtrium, ZGItems.ingotEtrium, 5.6F);
		
		// Lapis Dust -> Lapis Ingot
		FurnaceRecipes.SmeltItem(new ItemStack(Items.DYE, 1, 4), new ItemStack(ZGItems.ingotLapis, 1), 1.0F);
		
		// Food (Raw -> Cooked)
		FurnaceRecipes.SmeltItem(ZGItems.rawAlienBacon, ZGItems.cookedAlienBacon, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawAlienBeef, ZGItems.cookedAlienBeef, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawBlubberFish, ZGItems.cookedBlubberFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawBladeFish, ZGItems.cookedBladeFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawGypsyFish, ZGItems.cookedGypsyFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.chocolateRaw, ZGItems.chocolateBar, 1.5F);
		
		ZGHelper.Log("Loaded a total of " + totalSmeltRecipes + " new smelting recipes.");
	}
	
	public static void SmeltBlock(Block blockIn, Block blockOut, float xp) {
		GameRegistry.addSmelting(blockIn, new ItemStack(blockOut), xp);
		totalSmeltRecipes++;
	}
	
	public static void SmeltBlock(Block blockIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(blockIn, stackOut, xp);
		totalSmeltRecipes++;
	}
	
	public static void SmeltItem(Item itemIn, Item itemOut, float xp) {
		GameRegistry.addSmelting(itemIn, new ItemStack(itemOut), xp);
		totalSmeltRecipes++;
	}
	
	public static void SmeltItem(Item itemIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(itemIn, stackOut, xp);
		totalSmeltRecipes++;
	}
	
	public static void SmeltItem(ItemStack stackIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(stackIn, stackOut, xp);
	}
	
	public static void SmeltBlockToItem(Block blockIn, Item itemOut, float xp) {
		GameRegistry.addSmelting(blockIn, new ItemStack(itemOut), xp);
		totalSmeltRecipes++;
	}
	
	public static void SmeltBlockToItem(Block blockIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(blockIn, stackOut, xp);
		totalSmeltRecipes++;
	}
	
}