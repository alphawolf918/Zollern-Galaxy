/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.lib;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void init() {
		CraftingRecipes.init();
		SmeltingRecipes.init();
	}
	
	public static class CraftingRecipes {
		public static void init() {
			// Eden Bloodstone
			ItemStack css = new ItemStack(BlockList.edenBloodStone, 4);
			GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
					'C', BlockList.edenBloodSand });
			
			// Edenwood Planks
			GameRegistry.addShapelessRecipe(new ItemStack(
					BlockList.edenWoodPlanks, 4),
					new Object[] { BlockList.edenWoodLog });
			
			// Edenrock Bricks
			ItemStack edenRockBricks = new ItemStack(BlockList.edenRockBricks,
					4);
			GameRegistry.addRecipe(edenRockBricks, new Object[] { "CC ", "CC ",
					"   ", 'C', BlockList.edenRock });
		}
	}
	
	public static class SmeltingRecipes {
		
		public static void init() {
			
			// Food
			addSmelting(ItemList.alienBeefRaw, ItemList.alienBeefCooked, 1.4F);
			addSmelting(ItemList.alienBaconRaw, ItemList.alienBaconCooked, 1.4F);
			
			// Ores (Eden)
			addSmelting(BlockList.edenCoalOre,
					new ItemStack(Blocks.coal_ore, 2), 2.0F); // Coal
			addSmelting(BlockList.edenCopperOre, new ItemStack(
					GCBlocks.basicBlock, 2, 5), 2.0F); // Copper
			addSmelting(BlockList.edenDeshOre, new ItemStack(
					MarsItems.marsItemBasic, 2, 0), 2.0F); // Desh
			addSmelting(BlockList.edenDiamondOre, new ItemStack(
					Blocks.diamond_ore, 2), 2.0F); // Diamond
			addSmelting(BlockList.edenEmeraldOre, new ItemStack(
					Blocks.emerald_ore, 2), 2.0F); // Emerald
			addSmelting(BlockList.edenGoldOre,
					new ItemStack(Blocks.gold_ore, 2), 2.0F); // Gold
			addSmelting(BlockList.edenIronOre,
					new ItemStack(Blocks.iron_ore, 2), 2.0F); // Iron
			addSmelting(BlockList.edenMeteoricIronOre, new ItemStack(
					GCItems.meteoricIronRaw, 2), 2.0F); // Meteoric Iron
			addSmelting(BlockList.edenTinOre, new ItemStack(
					GCBlocks.basicBlock, 2, 6), 2.0F); // Tin
			
			// Other
			addSmelting(BlockList.edenCobbleRock, BlockList.edenRock, 0.4F);
			addSmelting(BlockList.edenBloodSand, BlockList.edenGlass, 0.7F);
		}
		
		public static void addSmelting(ItemStack itemStack, ItemStack output,
				float xp) {
			GameRegistry.addSmelting(itemStack, output, xp);
		}
		
		public static void addSmelting(Block input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Item input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
		}
		
		public static void addSmelting(Item input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Block input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
		}
		
		public static void addSmelting(Block input, Block output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
	}
}