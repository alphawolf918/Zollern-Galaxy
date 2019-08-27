package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class CompressorRecipesZG {
	
	private static int totalCompressorRecipes = 0;
	
	public static void init() {
		// Compressed Virinium
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedVirinium, 2), new ItemStack(ZGItems.ingotViri,
				1, 0), new ItemStack(ZGItems.ingotViri, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Evenium
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedEvenium, 2), new ItemStack(ZGItems.ingotEve, 1,
				0), new ItemStack(ZGItems.ingotEve, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Heartium
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedHeartium, 2), new ItemStack(ZGItems.heartOfZol,
				1, 0), new ItemStack(ZGItems.heartOfZol, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Vyrex
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedVyrex, 2), new ItemStack(
				ZGItems.compressedVirinium, 1, 0), new ItemStack(ZGItems.compressedHeartium, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Cobalt
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedCobalt, 2), new ItemStack(ZGItems.ingotCobalt,
				1, 0), new ItemStack(ZGItems.ingotCobalt, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Kriffonium
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedKriffonium, 2), new ItemStack(
				ZGItems.compressedGold, 1, 0), new ItemStack(ZGItems.compressedCobalt, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Emerald
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedEmerald, 2),
				new ItemStack(Items.EMERALD, 1, 0), new ItemStack(Items.EMERALD, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Diamond
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedDiamond, 2),
				new ItemStack(Items.DIAMOND, 1, 0), new ItemStack(Items.DIAMOND, 1, 0));
		totalCompressorRecipes++;
		
		// Compressed Gold
		CompressorRecipes.addShapelessRecipe(new ItemStack(ZGItems.compressedGold, 2),
				new ItemStack(Items.GOLD_INGOT, 1, 0), new ItemStack(Items.GOLD_INGOT, 1, 0));
		totalCompressorRecipes++;
		
		ZGHelper.Log("Loaded a total of " + totalCompressorRecipes + " new compressor recipes.");
	}
	
}