package zollerngalaxy.lib.helpers;

import java.util.HashMap;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
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
	
	public static void addSimpleToolSet(ItemStack itemOutput, Item itemIngot, String toolType) {
		toolType = toolType.toLowerCase();
		// Pickaxe
		if (toolType.equals("pickaxe")) {
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { "RRR", " S ", " S ", 'R', itemIngot, 'S', Items.STICK });
			// Shovel
		} else if (toolType.equals("shovel")) {
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { " R ", " S ", " S ", 'R', itemIngot, 'S', Items.STICK });
			// Axe
		} else if (toolType.equals("axe")) {
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { " RR", " SR", " S ", 'R', itemIngot, 'S', Items.STICK });
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { "RR ", "RS ", " S ", 'R', itemIngot, 'S', Items.STICK });
			// Hoe
		} else if (toolType.equals("hoe")) {
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { "RR ", " S ", " S ", 'R', itemIngot, 'S', Items.STICK });
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { " RR", " S ", " S ", 'R', itemIngot, 'S', Items.STICK });
			// Sword
		} else if (toolType.equals("sword")) {
			ZGRecipeHelper.addRecipe(itemOutput, new Object[] { " R ", " R ", " S ", 'R', itemIngot, 'S', Items.STICK });
		}
	}
	
	public static void addSpaceStationRecipe(int spaceStationID, int planetID, HashMap<Object, Integer> obj) {
		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(spaceStationID, planetID, new SpaceStationRecipe(obj)));
	}
	
	public static void addCompresssorShapelessRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addShapelessRecipe(output, inputs);
	}
	
	public static void addCompresssorRecipe(ItemStack output, Object... inputs) {
		CompressorRecipes.addRecipe(output, inputs);
	}
	
	public static void addCircuitFabricatorRecipe(ItemStack output, NonNullList<Object> inputs) {
		CircuitFabricatorRecipes.addRecipe(output, inputs);
	}
}