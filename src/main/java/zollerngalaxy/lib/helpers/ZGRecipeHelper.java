package zollerngalaxy.lib.helpers;

import zollerngalaxy.lib.helpers.json.JSONRecipeHelper;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ZGRecipeHelper {
	
	public static void addRecipe(ItemStack output, Object... obj) {
		JSONRecipeHelper.addShapedRecipe(output, obj);
	}
	
	public static void addOreRecipe(ItemStack output, Object... obj) {
		JSONRecipeHelper.addShapedRecipe(output, obj);
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... obj) {
		JSONRecipeHelper.addShapelessRecipe(output, obj);
	}
	
	public static void addSmeltingRecipe(ItemStack input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
	}
	
	public static void addCompressorRecipe(ItemStack output, Object... obj) {
		CompressorRecipes.addRecipe(output, obj);
	}
	
	public static void addShapelessCompressorRecipe(ItemStack output, Object... obj) {
		CompressorRecipes.addShapelessRecipe(output, obj);
	}
}