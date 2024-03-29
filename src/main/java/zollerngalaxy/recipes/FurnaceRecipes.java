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

public class FurnaceRecipes {
	
	private static int totalSmeltRecipes = 0;
	
	public static void init() {
		// Zollus
		FurnaceRecipes.SmeltBlock(ZGBlocks.zolCobbleRock, ZGBlocks.zolStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.zolTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		
		// Kriffon
		FurnaceRecipes.SmeltBlock(ZGBlocks.kriffCobbleRock, ZGBlocks.kriffStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.kriffCobaltOre, ZGItems.ingotCobalt, 1.6F);
		
		// Purgot
		FurnaceRecipes.SmeltBlock(ZGBlocks.purgCobbleRock, ZGBlocks.purgStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgAluminumOre, new ItemStack(GCItems.basicItem, 1, 5), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgCobaltOre, ZGItems.ingotCobalt, 1.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.purgEveniumOre, ZGItems.ingotEvenium, 3.6F);
		
		// Eden
		FurnaceRecipes.SmeltBlock(ZGBlocks.edenCobbleRock, ZGBlocks.edenStone, 1.5F);
		FurnaceRecipes.SmeltBlock(ZGBlocks.edenBloodSand, Blocks.GLASS, 0.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenAluminumOre, new ItemStack(GCItems.basicItem, 1, 5), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenCobaltOre, ZGItems.ingotCobalt, 1.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.edenEveniumOre, ZGItems.ingotEvenium, 3.6F);
		
		// Xathius
		FurnaceRecipes.SmeltBlock(ZGBlocks.xathCobble, ZGBlocks.xathStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.xathTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		
		// Thermal Foundation metals
		if (ModHelperBase.useCofh && ModHelperBase.useThermalFoundation) {
			TFSmeltingRecipes.init();
		}
		
		// Oasis
		FurnaceRecipes.SmeltBlock(ZGBlocks.oasisCobble, ZGBlocks.oasisStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisIronOre, Items.IRON_INGOT, 2.1F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisGoldOre, Items.GOLD_INGOT, 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.oasisLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F);
		
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
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroAmaranthOre, ZGItems.ingotAmaranth, 4.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroShiniumOre, ZGItems.ingotShinium, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.caligroZincOre, ZGItems.ingotZinc, 3.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.corruptChargiumOre, ZGItems.ingotChargium, 7.6F);
		
		// Exodus
		FurnaceRecipes.SmeltBlock(ZGBlocks.exodusCobblestone, ZGBlocks.exodusStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.exodusIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.exodusGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.exodusCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		
		// Metztli
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.harranZincOre, ZGItems.ingotZinc, 4.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.harranAmaranthOre, ZGItems.ingotAmaranth, 4.6F);
		
		// Vortex
		FurnaceRecipes.SmeltBlock(ZGBlocks.vortexCobblestone, ZGBlocks.vortexStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.vortexIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.vortexGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.vortexCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.vortexEveniumOre, ZGItems.ingotEvenium, 3.6F);
		
		// Astros
		FurnaceRecipes.SmeltBlock(ZGBlocks.astrosCobblestone, ZGBlocks.astrosStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.astrosIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.astrosGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.astrosTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.astrosZollerniumOre, ZGItems.ingotZollernium, 7.2F);
		
		// Centotl
		FurnaceRecipes.SmeltBlock(ZGBlocks.centoCobblestone, ZGBlocks.centoStone, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.centoIronOre, Items.IRON_INGOT, 5.8F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.centoGoldOre, Items.GOLD_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.centoShiniumOre, ZGItems.ingotShinium, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.centoFueltoniumOre, ZGItems.ingotFueltonium, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.centoZollerniumOre, ZGItems.ingotZollernium, 7.2F);
		
		// Toci
		FurnaceRecipes.SmeltBlock(ZGBlocks.tociCobblestone, ZGBlocks.tociStone, 5.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociIronOre, Items.IRON_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociGoldOre, Items.GOLD_INGOT, 6.0F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociFueltoniumOre, ZGItems.ingotFueltonium, 5.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociZincOre, ZGItems.ingotZinc, 3.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tociAmaranthOre, ZGItems.ingotAmaranth, 4.3F);
		
		// Tlaloc
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tlalocFueltoniumOre, ZGItems.ingotFueltonium, 5.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tlalocZollerniumOre, ZGItems.ingotZollernium, 7.2F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.tlalocShiniumOre, ZGItems.ingotShinium, 5.6F);
		
		// Kronos
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherIronOre, Items.IRON_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherGoldOre, Items.GOLD_INGOT, 6.0F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherFueltoniumOre, ZGItems.ingotFueltonium, 5.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherTinOre, new ItemStack(GCItems.basicItem, 1, 4), 2.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherLeadOre, new ItemStack(VenusItems.basicItem, 1, 1), 2.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherCopperOre, new ItemStack(GCItems.basicItem, 1, 3), 2.4F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherZincOre, ZGItems.ingotZinc, 3.7F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherAmaranthOre, ZGItems.ingotAmaranth, 4.3F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherShiniumOre, ZGItems.ingotShinium, 5.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherRaditeOre, ZGItems.ingotRadite, 8.6F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.netherZogiteOre, ZGItems.ingotZogite, 8.6F);
		
		// Maveth
		FurnaceRecipes.SmeltBlock(ZGBlocks.mavethCobblestone, ZGBlocks.mavethStone, 1.5F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.mavethIronOre, Items.IRON_INGOT, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.mavethAmaranthOre, ZGItems.ingotAmaranth, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.mavethZollerniumOre, ZGItems.ingotZollernium, 5.9F);
		FurnaceRecipes.SmeltBlockToItem(ZGBlocks.mavethVibraniumOre, ZGItems.ingotVibranium, 5.9F);
		
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
		FurnaceRecipes.SmeltItem(ZGItems.dustPlutonium, ZGItems.ingotPlutonium, 8.4F);
		FurnaceRecipes.SmeltItem(ZGItems.dustObsidian, ZGItems.ingotObsidian, 9.6F);
		FurnaceRecipes.SmeltItem(ZGItems.dustVibranium, ZGItems.ingotVibranium, 10.82F);
		
		// Lapis Dust -> Lapis Ingot
		FurnaceRecipes.SmeltItem(new ItemStack(Items.DYE, 1, 4), new ItemStack(ZGItems.ingotLapis, 1), 1.0F);
		
		// Food (Raw -> Cooked)
		FurnaceRecipes.SmeltItem(ZGItems.rawAlienBacon, ZGItems.cookedAlienBacon, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawAlienBeef, ZGItems.cookedAlienBeef, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawAlienSquid, ZGItems.cookedAlienSquid, 1.4F);
		FurnaceRecipes.SmeltItem(ZGItems.rawBlubberFish, ZGItems.cookedBlubberFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawBladeFish, ZGItems.cookedBladeFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.rawGypsyFish, ZGItems.cookedGypsyFish, 1.2F);
		FurnaceRecipes.SmeltItem(ZGItems.chocolateRaw, ZGItems.chocolateBar, 1.5F);
		FurnaceRecipes.SmeltItem(ZGItems.flour, new ItemStack(Items.BREAD, 2), 5.5F);
		FurnaceRecipes.SmeltItem(ZGItems.dough, new ItemStack(ZGItems.doughCooked, 4), 10.5F);
		FurnaceRecipes.SmeltItem(ZGItems.cornKernel, ZGItems.popcorn, 0.5F);
		
		// Clay
		FurnaceRecipes.SmeltItem(ZGItems.mudClayBall, new ItemStack(Items.BRICK, 2), 2.0F);
		
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