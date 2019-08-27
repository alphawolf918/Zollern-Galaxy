package zollerngalaxy.lib.helpers;

import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollerngalaxy.lib.helpers.json.JSONRecipeFactory;

public class ZGRecipeHelper {
	
	public static void addRecipe(ItemStack output, Object... obj) {
		JSONRecipeFactory.addShapedRecipe(output, obj);
	}
	
	public static void addOreRecipe(ItemStack output, Object... obj) {
		JSONRecipeFactory.addShapedRecipe(output, obj);
	}
	
	public static void addShapelessRecipe(ItemStack output, Object... obj) {
		JSONRecipeFactory.addShapelessRecipe(output, obj);
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