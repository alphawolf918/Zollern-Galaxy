package zollerngalaxy.recipes;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;

public class CraftingRecipes {
	
	public static void init() {
		CraftingRecipes.addShapelessRecipes();
	}
	
	private static void addShapelessRecipes() {
		CraftingRecipes.addRockBricks(ZGBlocks.zolStone, ZGBlocks.zolRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.kriffStone, ZGBlocks.kriffRockBricks);
		CraftingRecipes.addRockBricks(ZGBlocks.purgStone, ZGBlocks.purgRockBricks);
	}
	
	private static void addRockBricks(Block stoneIn, Block bricksOut) {
		ZGRecipeHelper.addShapelessRecipe(new ItemStack(bricksOut, 4), new ItemStack(stoneIn, 4));
	}
}