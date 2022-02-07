/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;

public class CraftingRecipes {
	
	private static int totalCraftRecipes = 0;
	
	public static void init() {
		CraftingRecipes.addRecipes();
		ZGHelper.Log("Loaded a total of " + totalCraftRecipes + " new crafting recipes.");
	}
	
	private static void addRecipes() {
		// Bright Stuff
		CraftingRecipes.addBriteStone(ZGItems.dustBrightstone, ZGBlocks.edenBrightStone);
		CraftingRecipes.addBriteStone(ZGItems.perdGlowdust, ZGBlocks.perdGlowstone);
		CraftingRecipes.addBriteStone(ZGItems.dustShinestone, ZGBlocks.blockShinestone);
		CraftingRecipes.addBriteStone(ZGBlocks.blockShinestoneCrystal, ZGBlocks.blockShinestonePolished);
		
		// Bricks
		CraftingRecipes.addBricks(Items.MAGMA_CREAM, ZGBlocks.magmaSlimeBlock);
		
		// Rock Bricks
		CraftingRecipes.addRockBricks(ZGBlocks.zolStone, ZGBlocks.zolRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.kriffStone, ZGBlocks.kriffRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.purgStone, ZGBlocks.purgRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.edenStone, ZGBlocks.edenRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.edenBloodSand, ZGBlocks.edenBloodStone);
		CraftingRecipes.addRockBricks(ZGBlocks.edenSacredStone, ZGBlocks.edenDungeonBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.xathStone, ZGBlocks.xathRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.oasisStone, ZGBlocks.oasisRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.atheonStone, ZGBlocks.atheonRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.blockShinestonePolished, ZGBlocks.blockShinestoneCrystalBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.blockChocolate, ZGBlocks.blockChocolateBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.xantheonChrome, ZGBlocks.xantheonConstructBlock);
		CraftingRecipes.addRockBricks(ZGBlocks.perdRock, ZGBlocks.perdRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.perdCaveStone, ZGBlocks.perdCaveStoneBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.caligroStone, ZGBlocks.caligroStoneBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.corruptStone, ZGBlocks.corruptStoneBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.tociStone, ZGBlocks.tociStoneBricks);
		
		// Items -> Blocks
		CraftingRecipes.addIngotMetal(ZGItems.ingotVirinium, ZGBlocks.blockViri);
		CraftingRecipes.addIngotMetal(ZGItems.ingotCobalt, ZGBlocks.blockCobalt);
		CraftingRecipes.addIngotMetal(ZGItems.ingotEvenium, ZGBlocks.blockEve);
		CraftingRecipes.addIngotMetal(ZGItems.prometheanCrystal, ZGBlocks.blockPromethean);
		CraftingRecipes.addIngotMetal(ZGItems.superChargedCoal, ZGBlocks.blockSuperChargedCoal);
		CraftingRecipes.addIngotMetal(ZGItems.ingotShinestone, ZGBlocks.blockShinestoneCrystal);
		CraftingRecipes.addIngotMetal(ZGItems.ingotShinium, ZGBlocks.blockShinium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotChargium, ZGBlocks.blockChargium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotFueltonium, ZGBlocks.blockFueltonium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotAmaranth, ZGBlocks.blockAmaranth);
		CraftingRecipes.addIngotMetal(ZGItems.azurite, ZGBlocks.blockAzurite);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZollernium, ZGBlocks.blockZollernium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZinc, ZGBlocks.blockZinc);
		CraftingRecipes.addIngotMetal(ZGItems.perdDiamond, ZGBlocks.blockPerdDiamond);
		CraftingRecipes.addIngotMetal(ZGItems.ingotEtrium, ZGBlocks.blockPerdEtrium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZucrite, ZGBlocks.blockZucrite);
		CraftingRecipes.addIngotMetal(ZGItems.ingotRhodium, ZGBlocks.blockRhodium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotPlutonium, ZGBlocks.blockPlutonium);
		CraftingRecipes.addIngotMetal(ZGItems.plutoniumCrystal, ZGItems.ingotPlutonium, 9);
		CraftingRecipes.addIngotMetal(ZGItems.amber, ZGBlocks.blockAmber);
		CraftingRecipes.addIngotMetal(ZGItems.topaz, ZGBlocks.blockTopaz);
		CraftingRecipes.addIngotMetal(ZGItems.opal, ZGBlocks.blockOpal);
		CraftingRecipes.addIngotMetal(ZGItems.aquamarine, ZGBlocks.blockAquamarine);
		CraftingRecipes.addIngotMetal(ZGItems.garnet, ZGBlocks.blockGarnet);
		CraftingRecipes.addIngotMetal(ZGItems.ruby, ZGBlocks.blockRuby);
		CraftingRecipes.addIngotMetal(ZGItems.sapphire, ZGBlocks.blockSapphire);
		CraftingRecipes.addIngotMetal(ZGItems.amberStatic, ZGBlocks.blockAmberStatic);
		CraftingRecipes.addIngotMetal(ZGItems.aquamarineIcy, ZGBlocks.blockAquamarineIcy);
		CraftingRecipes.addIngotMetal(ZGItems.garnetFire, ZGBlocks.blockGarnetFire);
		CraftingRecipes.addIngotMetal(ZGItems.witherite, ZGBlocks.blockWitherite);
		CraftingRecipes.addIngotMetal(ZGItems.radium, ZGBlocks.blockRadium);
		CraftingRecipes.addIngotMetal(ZGItems.netheridium, ZGBlocks.blockNetheridium);
		CraftingRecipes.addIngotMetal(ZGItems.shadowBone, ZGBlocks.blockShadowBone);
		CraftingRecipes.addIngotMetal(Items.BLAZE_POWDER, ZGBlocks.blazeRock);
		CraftingRecipes.addIngotMetal(Blocks.RED_MUSHROOM, ZGBlocks.blockRedshroom);
		CraftingRecipes.addIngotMetal(Items.SUGAR, ZGBlocks.blockSugarCube);
		CraftingRecipes.addIngotMetal(ZGItems.ingotObsidian, Blocks.OBSIDIAN);
		CraftingRecipes.addIngotMetal(ZGItems.zanium, ZGBlocks.blockZanium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotRadite, ZGBlocks.blockRadite);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZogite, ZGBlocks.blockZogite);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZogradite, ZGBlocks.blockZogradite);
		
		// Compression
		CraftingRecipes.addIngotMetal(ZGItems.compressedCobalt, ZGBlocks.blockCompressedCobalt);
		CraftingRecipes.addIngotMetal(ZGItems.compressedEvenium, ZGBlocks.blockCompressedEve);
		CraftingRecipes.addIngotMetal(ZGItems.compressedHeartium, ZGBlocks.blockCompressedHeartium);
		CraftingRecipes.addIngotMetal(ZGItems.compressedPromethean, ZGBlocks.blockCompressedPromethean);
		CraftingRecipes.addIngotMetal(ZGItems.compressedSuperChargedCoal, ZGBlocks.blockCompressedSuperChargedCoal);
		CraftingRecipes.addIngotMetal(ZGItems.compressedVirinium, ZGBlocks.blockCompressedViri);
		CraftingRecipes.addIngotMetal(ZGItems.compressedZucrite, ZGBlocks.blockCompressedZucrite);
		CraftingRecipes.addIngotMetal(ZGItems.compressedRhodium, ZGBlocks.blockCompressedRhodium);
		
		// Schweets
		CraftingRecipes.addIngotMetal(ZGItems.chocolateBar, ZGBlocks.blockChocolate);
		CraftingRecipes.addIngotMetal(Items.COOKIE, ZGBlocks.blockCookie);
		CraftingRecipes.addIngotMetal(ZGItems.brownie, ZGBlocks.blockBrownie);
		CraftingRecipes.addIngotMetal(ZGItems.iceCreamSandwich, ZGBlocks.blockIceCreamSandwich);
		
		// Tree things
		CraftingRecipes.addPlanks(ZGBlocks.edenWoodLog, ZGBlocks.edenWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.perdWoodLogs, ZGBlocks.perdWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.edenParadiseWoodLog, ZGBlocks.edenParadiseWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.edenGoldenWoodLog, ZGBlocks.edenGoldenWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.edenLovetreeLog, ZGBlocks.edenLovetreePlanks);
		CraftingRecipes.addPlanks(ZGBlocks.exoWoodLogs, ZGBlocks.exoWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.cherryWoodLog, ZGBlocks.cherryWoodPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.bananaLog, ZGBlocks.bananaPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.guavaLog, ZGBlocks.guavaPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.peachLog, ZGBlocks.peachPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.grapefruitLog, ZGBlocks.grapefruitPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.orangeLog, ZGBlocks.orangePlanks);
		CraftingRecipes.addPlanks(ZGBlocks.lemonLog, ZGBlocks.lemonPlanks);
		CraftingRecipes.addPlanks(ZGBlocks.limeLog, ZGBlocks.limePlanks);
		CraftingRecipes.addPlanks(ZGBlocks.limonLog, ZGBlocks.limonPlanks);
		
		// Helmet
		CraftingRecipes.addArmorSet(ZGItems.helmetWood, Blocks.PLANKS, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetStone, Blocks.STONE, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetAmaranth, ZGItems.ingotAmaranth, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetZollernium, ZGItems.ingotZollernium, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetAzurite, ZGItems.azurite, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetRadium, ZGItems.radium, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetRuby, ZGItems.ruby, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetSapphire, ZGItems.sapphire, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetZanium, ZGItems.zanium, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetRadite, ZGItems.ingotRadite, "helmet");
		CraftingRecipes.addArmorSet(ZGItems.helmetZogite, ZGItems.ingotZogite, "helmet");
		
		// Chest
		CraftingRecipes.addArmorSet(ZGItems.chestWood, Blocks.PLANKS, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestStone, Blocks.STONE, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestAmaranth, ZGItems.ingotAmaranth, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestZollernium, ZGItems.ingotZollernium, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestAzurite, ZGItems.azurite, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestRadium, ZGItems.radium, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestRuby, ZGItems.ruby, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestSapphire, ZGItems.sapphire, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestZanium, ZGItems.zanium, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestRadite, ZGItems.ingotRadite, "chest");
		CraftingRecipes.addArmorSet(ZGItems.chestZogite, ZGItems.ingotZogite, "chest");
		
		// Legs
		CraftingRecipes.addArmorSet(ZGItems.legsWood, Blocks.PLANKS, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsStone, Blocks.STONE, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsAmaranth, ZGItems.ingotAmaranth, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsZollernium, ZGItems.ingotZollernium, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsAzurite, ZGItems.azurite, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsRadium, ZGItems.radium, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsRuby, ZGItems.ruby, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsSapphire, ZGItems.sapphire, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsZanium, ZGItems.zanium, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsRadite, ZGItems.ingotRadite, "legs");
		CraftingRecipes.addArmorSet(ZGItems.legsZogite, ZGItems.ingotZogite, "legs");
		
		// Feets
		CraftingRecipes.addArmorSet(ZGItems.bootsWood, Blocks.PLANKS, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsStone, Blocks.STONE, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsAmaranth, ZGItems.ingotAmaranth, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsZollernium, ZGItems.ingotZollernium, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsAzurite, ZGItems.azurite, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsRadium, ZGItems.radium, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsRuby, ZGItems.ruby, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsSapphire, ZGItems.sapphire, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsZanium, ZGItems.zanium, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsRadite, ZGItems.ingotRadite, "boots");
		CraftingRecipes.addArmorSet(ZGItems.bootsZogite, ZGItems.ingotZogite, "boots");
		
		// Blood Obsidian
		ZGRecipeHelper.addRecipe(new ItemStack(ZGBlocks.blockRedObsidian, 2), new Object[] { "BN ", "NB ", "   ", 'B', Blocks.NETHER_WART_BLOCK, 'N', Blocks.OBSIDIAN });
		totalCraftRecipes++;
		
		// Netheridium (Gem Form)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.netheridium, 1), new Object[] { "BSB", "LXL", "VAV", 'B', ZGItems.darkEssence, 'S', ZGItems.superChargedCoal, 'V', ZGItems.garnet, 'X', ZGBlocks.blockWitherite, 'L', Blocks.OBSIDIAN, 'V', Items.BLAZE_POWDER, 'A', ZGItems.shadowBone });
		totalCraftRecipes++;
		
		// Netherized Obsidian
		ZGRecipeHelper.addRecipe(new ItemStack(ZGBlocks.blockNetherizedObsidian, 1), new Object[] { "WNW", "NON", "SNS", 'N', ZGBlocks.blockNetheridium, 'W', ZGBlocks.blockWitherite, 'O', ZGBlocks.blockRedObsidian, 'S', ZGItems.darkEssence });
		totalCraftRecipes++;
		
		// Radium
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.radium, 2), new Object[] { "GSG", "GAG", "GSG", 'G', ZGBlocks.atheonConstructBlock, 'S', ZGBlocks.blockSuperChargedCoal, 'A', ZGBlocks.blockAzurite });
		totalCraftRecipes++;
		
		// Bedrock Breaker
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.BEDROCK_BREAKER), new Object[] { "ZAZ", " M ", " M ", 'Z', ZGItems.ingotZucrite, 'A', ZGItems.ascendium, 'M', ZGItems.ingotAscendantAmaranth });
		totalCraftRecipes++;
		
		// Firey Garnet (Gem Form)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.garnetFire, 1), new Object[] { "BLB", "RGR", "BLB", 'B', Items.BLAZE_POWDER, 'G', ZGBlocks.blockGarnet, 'R', Items.REDSTONE, 'L', Items.BLAZE_ROD });
		totalCraftRecipes++;
		
		// Icy Aqua (Gem Form)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.aquamarineIcy, 1), new Object[] { "SDS", "ZAZ", "AAA", 'S', ZGItems.ingotShinium, 'Z', ZGItems.dustShinestone, 'A', ZGBlocks.blockAquamarine, 'D', Items.DIAMOND });
		totalCraftRecipes++;
		
		// Static Amber (Gem Form)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.amberStatic, 1), new Object[] { "GTG", "UAU", "ZTZ", 'G', Items.GOLD_INGOT, 'T', ZGItems.topaz, 'A', ZGBlocks.blockAmber, 'Z', ZGItems.ingotZinc, 'U', ZGItems.azurite });
		totalCraftRecipes++;
		
		// Diablo
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordFire, 1), new Object[] { " F ", " F ", "GPG", 'F', ZGBlocks.blockGarnetFire, 'G', ZGItems.garnet, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Thor
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordThor, 1), new Object[] { " S ", " S ", "APA", 'S', ZGBlocks.blockAmberStatic, 'A', ZGItems.amber, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Ender
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordEnder, 1), new Object[] { " E ", " E ", "OPM", 'E', ZGBlocks.blockPerdEtrium, 'O', ZGBlocks.blockPerdDiamond, 'M', ZGBlocks.blockOpal, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Glacies
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordIce, 1), new Object[] { " I ", " I ", "APA", 'I', ZGItems.aquamarineIcy, 'A', ZGItems.aquamarine, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Mortem
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordWither, 1), new Object[] { " W ", " W ", "RAX", 'W', ZGBlocks.blockNetheridium, 'R', ZGBlocks.blockWitherite, 'A', ZGItems.powerStick, 'X', ZGItems.darkEssence });
		totalCraftRecipes++;
		
		// Archangel
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.swordLight, 1), new Object[] { " W ", " W ", "RAX", 'W', ZGBlocks.blockRadium, 'R', ZGBlocks.blockAmberStatic, 'A', ZGItems.powerStick, 'X', ZGItems.radium });
		totalCraftRecipes++;
		
		// Shinium
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.ingotShinium, 1), new Object[] { "DLD", "DSD", "DLD", 'D', ZGItems.prometheanCrystal, 'S', ZGItems.ingotShinestone, 'L', ZGItems.ingotLapis });
		totalCraftRecipes++;
		
		// Chargium Fluid
		ItemStack filledChargiumBucket = FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidChargium, ZGFluids.fluidChargium.BUCKET_VOLUME));
		
		// Chargium Dust
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.dustChargium, 8), new Object[] { "SS ", "ZZ ", "F  ", 'S', ZGItems.dustShinium, 'Z', ZGItems.kriffCrystal, 'F', filledChargiumBucket });
		totalCraftRecipes++;
		
		// HUD
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.hud, 1), new Object[] { "RXR", "SDS", "RXR", 'R', Items.REDSTONE, 'X', new ItemStack(GCItems.basicItem, 1, 3), 'S', new ItemStack(GCItems.basicItem, 1, 5), 'D', new ItemStack(MarsItems.marsItemBasic, 1, 3) });
		totalCraftRecipes++;
		
		// Kriffon Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.kriffCrystal, 1), new Object[] { "FZF", "CVC", "ERE", 'F', ZGItems.compressedKriffonium, 'Z', ZGItems.zolCrystal, 'C', ZGItems.compressedCobalt, 'V', new ItemStack(MarsItems.marsItemBasic, 1, 3), 'E', ZGItems.compressedHeartium, 'R', ZGItems.compressedEmerald });
		totalCraftRecipes++;
		
		// Purgot Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.purgCrystal, 1), new Object[] { "E E", " R ", "E E", 'E', ZGItems.compressedEvenium, 'R', Items.REDSTONE });
		totalCraftRecipes++;
		
		// Eden Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.edenCrystal, 1), new Object[] { "EXE", "HRH", "EXE", 'E', ZGItems.compressedEmerald, 'R', ZGItems.kriffCrystal, 'X', ZGItems.purgCrystal, 'H', ZGItems.zolCrystal });
		totalCraftRecipes++;
		
		// Alien Stone
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.alienStone, 1), new Object[] { "CVC", "ZBZ", "CIC", 'C', ZGItems.edenCrystal, 'V', ZGItems.compressedVyrex, 'Z', ZGBlocks.blockCompressedCobalt, 'B', ZGBlocks.blockViri, 'I', ZGBlocks.edenBrightStone });
		totalCraftRecipes++;
		
		// **** Begin Sweets ****
		
		// Raw Chocolate
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.chocolateRaw, 3), new Object[] { "CCC", "CEC", "CCC", 'C', new ItemStack(Items.DYE, 1, 3), 'E', Items.EGG });
		totalCraftRecipes++;
		
		// Brownie
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.brownie, 4), new Object[] { "CC ", "CC ", "   ", 'C', ZGItems.chocolateRaw });
		totalCraftRecipes++;
		
		// Candy Apple
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.candyApple, 1), new Object[] { Items.APPLE, ZGItems.chocolateRaw });
		totalCraftRecipes++;
		
		// Cream Ball
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.creamBall, 3), new Object[] { Items.MILK_BUCKET, Items.SUGAR });
		totalCraftRecipes++;
		
		// Ice Cream Sandwich
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { "B  ", "C  ", "B  ", 'B', ZGItems.brownie, 'C', ZGItems.creamBall });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { " B ", " C ", " B ", 'B', ZGItems.brownie, 'C', ZGItems.creamBall });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { "  B", "  C", "  B", 'B', ZGItems.brownie, 'C', ZGItems.creamBall });
		totalCraftRecipes += 3;
		
		// Chocolate Strawberry
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.chocolateStrawberry, 1), new Object[] { ZGItems.chocolateRaw, ZGItems.strawberry });
		totalCraftRecipes++;
		
		// Strawberry Space Milkshake
		// TODO
		
		// Bread
		ZGRecipeHelper.addRecipe(new ItemStack(Items.BREAD, 16), new Object[] { "   ", "DDD", "   ", 'D', ZGItems.doughCooked });
		totalCraftRecipes++;
		
		// **** End Sweets ****
		
		// Enrichment Dust + Poisonous Potato = Regular Potatoes
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(Items.POTATO, 2), new Object[] { Items.POISONOUS_POTATO, ZGItems.dustEnrichment });
		
		// Pea Pods -> 4 Peas
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.pea, 4), new Object[] { ZGItems.peas });
		
		// Corn Cob -> 32 Corn Kernels
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.cornKernel, 32), new Object[] { ZGItems.corn });
		
		// Popcorn Bowl
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.popcornBowl, 1), new Object[] { "CCC", "CBC", "CCC", 'C', ZGItems.popcorn, 'B', Items.BOWL });
		
		// Pickaxes
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeAzurite), ZGItems.azurite);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeZollernium), ZGItems.ingotZollernium);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeRuby), ZGItems.ruby);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeSapphire), ZGItems.sapphire);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeZanium), ZGItems.zanium);
		
		// Shovels
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelAzurite), ZGItems.azurite);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelZollernium), ZGItems.ingotZollernium);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelRuby), ZGItems.ruby);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelSapphire), ZGItems.sapphire);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelZanium), ZGItems.zanium);
		
		// Axes
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeAzurite), ZGItems.azurite);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeZollernium), ZGItems.ingotZollernium);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeRuby), ZGItems.ruby);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeSapphire), ZGItems.sapphire);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeZanium), ZGItems.zanium);
		
		// Hoes
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeAzurite), ZGItems.azurite);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeZollernium), ZGItems.ingotZollernium);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeRuby), ZGItems.ruby);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeSapphire), ZGItems.sapphire);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeZanium), ZGItems.zanium);
		
		// Swords
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordAzurite), ZGItems.azurite);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordZollernium), ZGItems.ingotZollernium);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordRuby), ZGItems.ruby);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordSapphire), ZGItems.sapphire);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordZanium), ZGItems.zanium);
		
		// Tunnelers
		CraftingRecipes.addTunneler(new ItemStack(ZGItems.tunnelerCopper), new ItemStack(GCItems.basicItem, 1, 3), new ItemStack(Items.BLAZE_POWDER, 1));
		CraftingRecipes.addTunneler(new ItemStack(ZGItems.tunnelerGold), ZGItems.compressedGold, ZGItems.radium);
		CraftingRecipes.addTunneler(new ItemStack(ZGItems.tunnelerAmaranth), ZGItems.compressedAmaranth, ZGItems.perdDiamond);
		
		// Ascendium
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.ascendium, 1), new Object[] { " Z ", " C ", " A ", 'Z', ZGItems.compressedZollernium, 'C', ZGItems.compressedZucrite, 'A', ZGItems.compressedAmaranth });
		
		// Power Stick (Staff of Ascension)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.powerStick, 2), new Object[] { " A ", " L ", " A ", 'A', ZGItems.compressedAmaranth, 'L', ZGItems.lapisStick });
		totalCraftRecipes++;
		
		// Lapis Stick
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.lapisStick, 4), new Object[] { " L ", " L ", " L ", 'L', ZGItems.ingotLapis });
		totalCraftRecipes++;
		
		// Golden Construct Blocks
		ZGRecipeHelper.addRecipe(new ItemStack(ZGBlocks.atheonConstructBlock, 4), new Object[] { "GGG", "GCG", "GGG", 'G', Blocks.GOLD_BLOCK, 'C', ZGBlocks.xantheonConstructBlock });
		totalCraftRecipes++;
		
		// Omnitool
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.OMNITOOL, 1), new Object[] { "ZZZ", "APA", " P ", 'Z', ZGItems.compressedZollernium, 'A', ZGItems.compressedAzurite, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Corruption Protection
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.blueprintCorruption, 1), new Object[] { "ZZZ", "APA", " P ", 'Z', ZGItems.compressedAscendantAmaranth, 'A', ZGItems.ascendium, 'P', ZGItems.ascendium });
		totalCraftRecipes++;
		
		// Healing Heart
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.healingHeart), new Object[] { "AZA", "AOA", "ARA", 'A', ZGItems.compressedHeartium, 'Z', ZGItems.ingotZollernium, 'R', ZGItems.ingotAmaranth, 'O', ZGItems.radium });
		totalCraftRecipes++;
		
		// Max Heartforce
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.healingHeartForce), new Object[] { "ZSZ", "ZHZ", "ZZZ", 'Z', ZGItems.ingotZinc, 'S', ZGItems.ingotZollernium, 'H', ZGItems.healingHeart });
		totalCraftRecipes++;
		
		// Star Gate (Tier 1)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier1, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGItems.compressedDiamond, 'C', ZGItems.compressedHeartium, 'H', ZGItems.heartium, 'Y', ZGItems.zolCrystal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 2)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier2, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGItems.compressedCobalt, 'C', ZGItems.kriffCrystal, 'H', ZGItems.heartium, 'Y', ZGBlocks.blockCobalt });
		totalCraftRecipes++;
		
		// Star Gate (Tier 3)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier3, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGItems.compressedEvenium, 'C', ZGItems.compressedHeartium, 'H', ZGItems.compressedCobalt, 'Y', ZGItems.purgCrystal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 4)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier4, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.blockCompressedViri, 'C', ZGItems.compressedVyrex, 'H', ZGBlocks.blockCompressedCobalt, 'Y', ZGItems.alienStone });
		totalCraftRecipes++;
		
		// Star Gate (Tier 5)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier5, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.blockCompressedPromethean, 'C', ZGItems.prometheanCrystal, 'H', ZGBlocks.blockCompressedViri, 'Y', ZGItems.compressedPromethean });
		totalCraftRecipes++;
		
		// Star Gate (Tier 6)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier6, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.blockCompressedSuperChargedCoal, 'C', ZGItems.compressedRiven, 'H', ZGBlocks.blockCompressedPromethean, 'Y', ZGItems.compressedSuperChargedCoal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 7)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier7, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGItems.compressedAmaranth, 'C', ZGItems.compressedAzurite, 'H', ZGBlocks.xantheonConstructBlock, 'Y', ZGBlocks.blockFueltonium });
		totalCraftRecipes++;
		
		// Star Gate (Tier 8)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier8, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGItems.compressedGold, 'C', ZGItems.compressedAzurite, 'H', ZGBlocks.blockPlutonium, 'Y', ZGBlocks.blockCompressedPromethean });
		totalCraftRecipes++;
		
		// Star Gate (Tier 9)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier9, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.blockCompressedZucrite, 'C', ZGItems.ascendium, 'H', ZGItems.compressedZollernium, 'Y', ZGItems.alienStone });
		totalCraftRecipes++;
		
		// Star Gate (Tier 10)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier10, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.blockCompressedRhodium, 'C', ZGItems.ascendium, 'H', ZGItems.darkEssence, 'Y', ZGItems.rokkite });
		totalCraftRecipes++;
		
		// Star Gate (Birthday Protocol)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateCandy, 1), new Object[] { "VCV", "HYH", "YCY", 'V', ZGBlocks.xathCobble, 'C', ZGBlocks.oasisRock, 'H', ZGBlocks.atheonConstructBlock, 'Y', ZGBlocks.blockPlutonium });
		totalCraftRecipes++;
		
		// Star Gate (Moon)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateMoon, 1), new Object[] { "VCV", "HYH", "YCY", 'V', GCItems.meteoricIronRaw, 'C', ZGItems.compressedVirinium, 'H', new ItemStack(GCBlocks.blockMoon, 1, 4), 'Y', ZGItems.dustObsidian });
		totalCraftRecipes++;
		
		// Storm Amulet
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.amuletStorm, 1), new Object[] { "SVS", "VSV", "SVS", 'S', ZGItems.stormCrystal, 'V', ZGItems.ingotVirinium });
		totalCraftRecipes++;
		
		// Medkit
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.medkit, 2), new Object[] { ZGItems.alcohol, ZGItems.gauze });
		totalCraftRecipes++;
		
		// Gauze
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.gauze, 1), new Object[] { "S S", " P ", "S S", 'S', Items.STRING, 'P', Items.PAPER });
		totalCraftRecipes++;
		
		// Alcohol
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.alcohol, 1), new Object[] { Items.GLASS_BOTTLE, Items.WATER_BUCKET, Items.WHEAT_SEEDS, Items.CLAY_BALL });
		totalCraftRecipes++;
		
		// Nail
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.nail, 2), new Object[] { " I ", " I ", "   ", 'I', Items.IRON_INGOT });
		totalCraftRecipes++;
		
		// Nail Group
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.nailGroup, 1), new Object[] { "NN ", "NN ", "   ", 'N', ZGItems.nail });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.nailGroup, 1), new Object[] { " NN", " NN", "   ", 'N', ZGItems.nail });
		totalCraftRecipes += 2;
		
		// Woodbox
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.woodBox, 1), new Object[] { "W W", " W ", "   ", 'W', Blocks.PLANKS });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.woodBox, 1), new Object[] { "   ", "W W", " W ", 'W', Blocks.PLANKS });
		totalCraftRecipes += 2;
		
		// Metal Parts
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.metalParts, 1), new Object[] { ZGItems.woodBox, ZGItems.nailGroup });
		totalCraftRecipes++;
		
		// Dough
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.dough, 2), new Object[] { ZGItems.flour, Items.EGG, Items.MILK_BUCKET });
		totalCraftRecipes++;
		
		// Mud Clay
		CraftingRecipes.addBricks(ZGItems.mudClayBall, ZGBlocks.mudClayBlock);
		
		// Sirens
		CraftingRecipes.addSiren(ZGBlocks.ironSiren, Items.IRON_INGOT);
		CraftingRecipes.addSiren(ZGBlocks.goldSiren, Items.GOLD_INGOT);
		CraftingRecipes.addSiren(ZGBlocks.diamondSiren, Items.DIAMOND);
		CraftingRecipes.addSiren(ZGBlocks.emeraldSiren, Items.EMERALD);
		
		// Oxygen Tanks
		CraftingRecipes.addOxygenTank(ZGItems.oxygenTankTier4, ZGItems.ingotLapis, ZGItems.compressedVirinium);
		CraftingRecipes.addOxygenTank(ZGItems.oxygenTankTier5, ZGItems.ingotAmaranth, ZGItems.compressedRhodium);
		CraftingRecipes.addOxygenTank(ZGItems.oxygenTankTier6, ZGItems.ingotPlutonium, ZGItems.compressedZanium);
	}
	
	public static void addBricks(Item coloredBrick, Block coloredBlock) {
		ZGRecipeHelper.addRecipe(new ItemStack(coloredBlock, 1), new Object[] { "CC ", "CC ", "   ", 'C', coloredBrick });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(coloredBrick, 4), new Object[] { coloredBlock });
		totalCraftRecipes++;
	}
	
	private static void addRockBricks(Block stoneIn, Block bricksOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(bricksOut, 4), new Object[] { "SS", "SS", 'S', stoneIn });
		totalCraftRecipes++;
	}
	
	private static void addIngotMetal(Item ingotIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "III", "III", "III", 'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(blockOut));
		totalCraftRecipes += 2;
	}
	
	private static void addIngotMetal(Item ingotIn, Item itemOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(itemOut, 1), new Object[] { "III", "III", "III", 'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(itemOut));
		totalCraftRecipes += 2;
	}
	
	private static void addIngotMetal(Item ingotIn, Item itemOut, int stackAmount) {
		ZGRecipeHelper.addRecipe(new ItemStack(itemOut, 1), new Object[] { "III", "III", "III", 'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(itemOut, stackAmount));
		totalCraftRecipes += 2;
	}
	
	private static void addIngotMetal(Block ingotIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "III", "III", "III", 'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(blockOut));
		totalCraftRecipes += 2;
	}
	
	private static void addIngotMetal(Block ingotIn, Block blockOut, int stackAmount) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "III", "III", "III", 'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(blockOut, stackAmount));
		totalCraftRecipes += 2;
	}
	
	private static void addBriteStone(Item dustIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "DD", "DD", 'D', dustIn });
		totalCraftRecipes++;
	}
	
	private static void addBriteStone(Block blockIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "DD", "DD", 'D', blockIn });
		totalCraftRecipes++;
	}
	
	private static void addPlanks(Block logIn, Block planksOut) {
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(planksOut, 4), new ItemStack(logIn));
		totalCraftRecipes++;
	}
	
	private static void addToolSet(ItemStack itemOutput, Item itemIngot, String toolType) {
		ZGRecipeHelper.addSimpleToolSet(itemOutput, itemIngot, toolType);
		totalCraftRecipes++;
	}
	
	public static void addArmorSet(Item itemInput, Item itemOutput, String armorType) {
		ZGRecipeHelper.addArmorSet(itemOutput, itemInput, armorType);
	}
	
	private static void addArmorSet(Item itemInput, Block blockInput, String armorType) {
		ZGRecipeHelper.addArmorSet(itemInput, blockInput, armorType);
	}
	
	private static void addPickaxe(ItemStack itemOutput, Item itemIngot) {
		CraftingRecipes.addToolSet(itemOutput, itemIngot, "pickaxe");
	}
	
	private static void addShovel(ItemStack itemOutput, Item itemIngot) {
		CraftingRecipes.addToolSet(itemOutput, itemIngot, "shovel");
	}
	
	private static void addAxe(ItemStack itemOutput, Item itemIngot) {
		CraftingRecipes.addToolSet(itemOutput, itemIngot, "axe");
	}
	
	private static void addSword(ItemStack itemOutput, Item itemIngot) {
		CraftingRecipes.addToolSet(itemOutput, itemIngot, "sword");
	}
	
	private static void addHoe(ItemStack itemOutput, Item itemIngot) {
		CraftingRecipes.addToolSet(itemOutput, itemIngot, "hoe");
	}
	
	private static void addTunneler(ItemStack itemOutput, Item itemMain, Item itemSecondary) {
		ZGRecipeHelper.addRecipe(itemOutput, new Object[] { "SMS", " M ", "SMS", 'M', itemMain, 'S', itemSecondary });
		totalCraftRecipes++;
	}
	
	private static void addTunneler(ItemStack itemOutput, ItemStack itemMain, ItemStack itemSecondary) {
		ZGRecipeHelper.addRecipe(itemOutput, new Object[] { "SMS", " M ", "SMS", 'M', itemMain, 'S', itemSecondary });
		totalCraftRecipes++;
	}
	
	private static void addSiren(Block sirenBlock, Item ingotIn) {
		ZGRecipeHelper.addRecipe(new ItemStack(sirenBlock, 1), new Object[] { "OIO", "IRI", "OIO", 'O', Blocks.OBSIDIAN, 'I', ingotIn, 'R', Items.REDSTONE });
		totalCraftRecipes++;
	}
	
	private static void addOxygenTank(Item oxygenTankOut, Item ingotItemIn, Item compressedItemIn) {
		ZGRecipeHelper.addRecipe(new ItemStack(oxygenTankOut, 1), new Object[] { "XXX", "YYY", "ZZZ", 'X', ingotItemIn, 'Y', GCItems.oxTankHeavy, 'Z', compressedItemIn });
		totalCraftRecipes++;
	}
}