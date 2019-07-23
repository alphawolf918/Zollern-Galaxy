package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
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
		CraftingRecipes.addRockBricks(ZGBlocks.zolStone, ZGBlocks.zolRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.kriffStone, ZGBlocks.kriffRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.purgStone, ZGBlocks.purgRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.edenStone, ZGBlocks.edenRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.edenBloodSand, ZGBlocks.edenBloodStone);
		
		CraftingRecipes.addIngotMetal(ZGItems.ingotViri, ZGBlocks.blockViri);
		CraftingRecipes.addIngotMetal(ZGItems.ingotCobalt, ZGBlocks.blockCobalt);
		CraftingRecipes.addIngotMetal(ZGItems.ingotEve, ZGBlocks.blockEve);
		
		CraftingRecipes.addBriteStone(ZGItems.dustBrightstone, ZGBlocks.edenBrightStone);
		
		CraftingRecipes.addPlanks(ZGBlocks.edenWoodLog, ZGBlocks.edenWoodPlanks);
		
		// HUD
		ZGRecipeHelper.addRecipe(new ItemStack(ZGItems.hud, 1), new Object[] { "RXR", "SDS", "RXR",
				'R', Items.REDSTONE, 'X', new ItemStack(GCItems.basicItem, 1, 3), 'S',
				new ItemStack(GCItems.basicItem, 1, 5), 'D',
				new ItemStack(MarsItems.marsItemBasic, 1, 3) });
		totalCraftRecipes++;
	}
	
	private static void addRockBricks(Block stoneIn, Block bricksOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(bricksOut, 4), new Object[] { "SS", "SS", 'S',
				stoneIn });
		totalCraftRecipes++;
	}
	
	private static void addIngotMetal(Item ingotIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1), new Object[] { "III", "III", "III",
				'I', ingotIn });
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(ingotIn, 9), new ItemStack(blockOut));
		totalCraftRecipes += 2;
	}
	
	private static void addBriteStone(Item dustIn, Block blockOut) {
		ZGRecipeHelper.addRecipe(new ItemStack(blockOut, 1),
				new Object[] { "DD", "DD", 'D', dustIn });
		totalCraftRecipes++;
	}
	
	private static void addPlanks(Block logIn, Block planksOut) {
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(planksOut, 4), new ItemStack(logIn));
		totalCraftRecipes++;
	}
}