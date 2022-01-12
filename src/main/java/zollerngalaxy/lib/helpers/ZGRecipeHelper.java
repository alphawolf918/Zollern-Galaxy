/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib.helpers;

import java.util.HashMap;
import java.util.List;
import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.recipe.CircuitFabricatorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
		ZGRecipeHelper.addSmeltingRecipe(input, output, xp);
	}
	
	public static void addCompressorRecipe(ItemStack output, Object... obj) {
		CompressorRecipes.addRecipe(output, obj);
	}
	
	public static void addShapelessCompressorRecipe(ItemStack output, Object... obj) {
		CompressorRecipes.addShapelessRecipe(output, obj);
	}
	
	public static void addArmorSet(Item itemInput, Item itemOutput, String armorType) {
		armorType = armorType.toLowerCase();
		if (armorType.equals("helmet")) {
			// Helmet
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "ZZZ", "Z Z", "   ", 'Z', itemInput });
			// Chestplate
		} else if (armorType.equals("chest")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', itemInput });
			// Leggings
		} else if (armorType.equals("legs")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', itemInput });
			// Boots
		} else if (armorType.equals("boots")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "   ", "Z Z", "Z Z", 'Z', itemInput });
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "Z Z", "Z Z", "   ", 'Z', itemInput });
		}
	}
	
	public static void addArmorSet(Item itemOutput, Block blockInput, String armorType) {
		armorType = armorType.toLowerCase();
		if (armorType.equals("helmet")) {
			// Helmet
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "ZZZ", "Z Z", "   ", 'Z', blockInput });
			// Chestplate
		} else if (armorType.equals("chest")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "Z Z", "ZZZ", "ZZZ", 'Z', blockInput });
			// Leggings
		} else if (armorType.equals("legs")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "ZZZ", "Z Z", "Z Z", 'Z', blockInput });
			// Boots
		} else if (armorType.equals("boots")) {
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "   ", "Z Z", "Z Z", 'Z', blockInput });
			ZGRecipeHelper.addRecipe(new ItemStack(itemOutput, 1), new Object[] { "Z Z", "Z Z", "   ", 'Z', blockInput });
		}
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
	
	public static void addCircuitFabricatorRecipe(ItemStack output, List<Object> inputs) {
		CircuitFabricatorRecipes.addRecipe(output, inputs);
	}
}