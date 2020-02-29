package zollerngalaxy.recipes;

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
		CraftingRecipes.addRockBricks(ZGBlocks.perdStone, ZGBlocks.perdRockBricks);
		
		// Items -> Blocks
		CraftingRecipes.addIngotMetal(ZGItems.ingotVirinium, ZGBlocks.blockViri);
		CraftingRecipes.addIngotMetal(ZGItems.ingotCobalt, ZGBlocks.blockCobalt);
		CraftingRecipes.addIngotMetal(ZGItems.ingotEvenium, ZGBlocks.blockEve);
		CraftingRecipes.addIngotMetal(ZGItems.prometheanCrystal, ZGBlocks.blockPromethean);
		CraftingRecipes.addIngotMetal(ZGItems.superChargedCoal, ZGBlocks.blockSuperChargedCoal);
		CraftingRecipes.addIngotMetal(ZGItems.plutoniumCrystal, ZGBlocks.blockPlutonium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotShinestone, ZGBlocks.blockShinestoneCrystal);
		CraftingRecipes.addIngotMetal(ZGItems.ingotShinium, ZGBlocks.blockShinium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotChargium, ZGBlocks.blockChargium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotFueltonium, ZGBlocks.blockFueltonium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotAmaranth, ZGBlocks.blockAmaranth);
		CraftingRecipes.addIngotMetal(ZGItems.azurite, ZGBlocks.blockAzurite);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZollernium, ZGBlocks.blockZollernium);
		CraftingRecipes.addIngotMetal(ZGItems.ingotZinc, ZGBlocks.blockZinc);
		CraftingRecipes.addIngotMetal(Items.BLAZE_POWDER, ZGBlocks.kriffBlazeRock);
		
		// Compression
		CraftingRecipes.addIngotMetal(ZGItems.compressedCobalt, ZGBlocks.blockCompressedCobalt);
		CraftingRecipes.addIngotMetal(ZGItems.compressedEvenium, ZGBlocks.blockCompressedEve);
		CraftingRecipes.addIngotMetal(ZGItems.compressedHeartium, ZGBlocks.blockCompressedHeartium);
		CraftingRecipes.addIngotMetal(ZGItems.compressedPromethean, ZGBlocks.blockCompressedPromethean);
		CraftingRecipes.addIngotMetal(ZGItems.compressedSuperChargedCoal, ZGBlocks.blockCompressedSuperChargedCoal);
		CraftingRecipes.addIngotMetal(ZGItems.compressedVirinium, ZGBlocks.blockCompressedViri);
		
		// Schweets
		CraftingRecipes.addIngotMetal(ZGItems.chocolateBar, ZGBlocks.blockChocolate);
		CraftingRecipes.addIngotMetal(Items.COOKIE, ZGBlocks.blockCookie);
		CraftingRecipes.addIngotMetal(ZGItems.brownie, ZGBlocks.blockBrownie);
		CraftingRecipes.addIngotMetal(ZGItems.iceCreamSandwich, ZGBlocks.blockIceCreamSandwich);
		
		// Tree things
		CraftingRecipes.addPlanks(ZGBlocks.edenWoodLog, ZGBlocks.edenWoodPlanks);
		
		// Shinium
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.ingotShinium, 1), new Object[] { "DLD", "DSD", "DLD", 'D',
				ZGItems.prometheanCrystal, 'S', ZGItems.ingotShinestone, 'L', ZGItems.ingotLapis });
		totalCraftRecipes++;
		
		// Chargium Fluid
		ItemStack filledBucket = FluidUtil.getFilledBucket(new FluidStack(ZGFluids.fluidChargium,
				ZGFluids.fluidChargium.BUCKET_VOLUME));
		
		// Chargium Dust
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.dustChargium, 8), new Object[] { "SS ", "ZZ ", "F  ", 'S',
				ZGItems.dustShinium, 'Z', ZGItems.kriffCrystal, 'F', filledBucket });
		totalCraftRecipes++;
		
		// HUD
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.hud, 1), new Object[] { "RXR", "SDS", "RXR", 'R', Items.REDSTONE, 'X',
				new ItemStack(GCItems.basicItem, 1, 3), 'S', new ItemStack(GCItems.basicItem, 1, 5), 'D',
				new ItemStack(MarsItems.marsItemBasic, 1, 3) });
		totalCraftRecipes++;
		
		// Kriffon Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.kriffCrystal, 1), new Object[] { "FZF", "CVC", "ERE", 'F',
				ZGItems.compressedKriffonium, 'Z', ZGItems.zolCrystal, 'C', ZGItems.compressedCobalt, 'V',
				new ItemStack(MarsItems.marsItemBasic, 1, 3), 'E', ZGItems.compressedHeartium, 'R', ZGItems.compressedEmerald });
		totalCraftRecipes++;
		
		// Purgot Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.purgCrystal, 1), new Object[] { "E E", " R ", "E E", 'E',
				ZGItems.compressedEvenium, 'R', Items.REDSTONE });
		totalCraftRecipes++;
		
		// Eden Crystal
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.edenCrystal, 1), new Object[] { "EXE", "HRH", "EXE", 'E',
				ZGItems.compressedEmerald, 'R', ZGItems.kriffCrystal, 'X', ZGItems.purgCrystal, 'H', ZGItems.zolCrystal });
		totalCraftRecipes++;
		
		// Alien Stone
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.alienStone, 1), new Object[] { "CVC", "ZBZ", "CIC", 'C',
				ZGItems.edenCrystal, 'V', ZGItems.compressedVyrex, 'Z', ZGBlocks.blockCompressedCobalt, 'B', ZGBlocks.blockViri,
				'I', ZGBlocks.edenBrightStone });
		totalCraftRecipes++;
		
		// **** Begin Sweets ****
		
		// Raw Chocolate
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.chocolateRaw, 3), new Object[] { "CCC", "CEC", "CCC", 'C',
				new ItemStack(Items.DYE, 1, 3), 'E', Items.EGG });
		totalCraftRecipes++;
		
		// Brownie
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.brownie, 4),
				new Object[] { "CC ", "CC ", "   ", 'C', ZGItems.chocolateRaw });
		totalCraftRecipes++;
		
		// Candy Apple
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.candyApple, 1),
				new Object[] { Items.APPLE, ZGItems.chocolateRaw });
		totalCraftRecipes++;
		
		// Cream Ball
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ZGItems.creamBall, 3), new Object[] { Items.MILK_BUCKET, Items.SUGAR });
		totalCraftRecipes++;
		
		// Ice Cream Sandwich
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { "B  ", "C  ", "B  ", 'B',
				ZGItems.brownie, 'C', ZGItems.creamBall });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { " B ", " C ", " B ", 'B',
				ZGItems.brownie, 'C', ZGItems.creamBall });
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.iceCreamSandwich, 1), new Object[] { "  B", "  C", "  B", 'B',
				ZGItems.brownie, 'C', ZGItems.creamBall });
		totalCraftRecipes += 3;
		
		// **** End Sweets ****
		
		// Pickaxes
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeAzurite), ZGItems.azurite);
		CraftingRecipes.addPickaxe(new ItemStack(ZGItems.pickaxeZollernium), ZGItems.ingotZollernium);
		
		// Shovels
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelAzurite), ZGItems.azurite);
		CraftingRecipes.addShovel(new ItemStack(ZGItems.shovelZollernium), ZGItems.ingotZollernium);
		
		// Axes
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeAzurite), ZGItems.azurite);
		CraftingRecipes.addAxe(new ItemStack(ZGItems.axeZollernium), ZGItems.ingotZollernium);
		
		// Hoes
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeAzurite), ZGItems.azurite);
		CraftingRecipes.addHoe(new ItemStack(ZGItems.hoeZollernium), ZGItems.ingotZollernium);
		
		// Swords
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordCobalt), ZGItems.ingotCobalt);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordEvenium), ZGItems.ingotEvenium);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordVirinium), ZGItems.ingotVirinium);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordAmaranth), ZGItems.ingotAmaranth);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordAzurite), ZGItems.azurite);
		CraftingRecipes.addSword(new ItemStack(ZGItems.swordZollernium), ZGItems.ingotZollernium);
		
		// Power Stick (Rod of Ascension)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.powerStick, 2), new Object[] { " A ", " L ", " A ", 'A',
				ZGItems.compressedAmaranth, 'L', ZGItems.ingotLapis });
		totalCraftRecipes++;
		
		// Golden Construct Blocks
		ZGRecipeHelper.addRecipe(new ItemStack(ZGBlocks.atheonConstructBlock, 4), new Object[] { "GGG", "GCG", "GGG", 'G',
				Blocks.GOLD_BLOCK, 'C', ZGBlocks.xantheonConstructBlock });
		totalCraftRecipes++;
		
		// Omnitool
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.OMNITOOL, 1), new Object[] { "ZZZ", "APA", " P ", 'Z',
				ZGItems.compressedZollernium, 'A', ZGItems.compressedAzurite, 'P', ZGItems.powerStick });
		totalCraftRecipes++;
		
		// Star Gate (Tier 1)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier1, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGItems.compressedDiamond, 'C', ZGItems.compressedHeartium, 'H', ZGItems.heartium, 'Y', ZGItems.zolCrystal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 2)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier2, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGItems.compressedCobalt, 'C', ZGItems.kriffCrystal, 'H', ZGItems.heartium, 'Y', ZGBlocks.blockCobalt });
		totalCraftRecipes++;
		
		// Star Gate (Tier 3)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier3, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGItems.compressedEvenium, 'C', ZGItems.compressedHeartium, 'H', ZGItems.compressedCobalt, 'Y',
				ZGItems.purgCrystal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 4)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier4, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGBlocks.blockCompressedViri, 'C', ZGItems.compressedVyrex, 'H', ZGBlocks.blockCompressedCobalt, 'Y',
				ZGItems.alienStone });
		totalCraftRecipes++;
		
		// Star Gate (Tier 5)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier5, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGBlocks.blockCompressedPromethean, 'C', ZGItems.prometheanCrystal, 'H', ZGBlocks.blockCompressedViri, 'Y',
				ZGItems.compressedPromethean });
		totalCraftRecipes++;
		
		// Star Gate (Tier 6)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier6, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGBlocks.blockCompressedSuperChargedCoal, 'C', ZGItems.compressedRiven, 'H', ZGBlocks.blockCompressedPromethean,
				'Y', ZGItems.compressedSuperChargedCoal });
		totalCraftRecipes++;
		
		// Star Gate (Tier 7)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateTier7, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGItems.compressedAmaranth, 'C', ZGItems.compressedAzurite, 'H', ZGBlocks.xantheonConstructBlock, 'Y',
				ZGBlocks.blockFueltonium });
		totalCraftRecipes++;
		
		// Star Gate (Tier 8)
		// TODO
		
		// Star Gate (Birthday Protocol)
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.starGateCandy, 1), new Object[] { "VCV", "HYH", "YCY", 'V',
				ZGBlocks.xathCobble, 'C', ZGBlocks.oasisRock, 'H', ZGBlocks.blockCompressedPromethean, 'Y',
				ZGItems.compressedSuperChargedCoal });
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
}