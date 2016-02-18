/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.utils;

import galaxymod.blocks.BlockList;
import galaxymod.integration.ThermalExpansionHelper;
import galaxymod.items.ItemList;
import micdoodle8.mods.galacticraft.api.recipe.CompressorRecipes;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeManagerNova {
	
	static int totalCraftingRecipes = 0;
	static int totalSmeltingRecipes = 0;
	static int totalPulverizerRecipes = 0;
	static int totalCompressorRecipes = 0;
	
	public static void init() {
		CraftingRecipes.init();
		SmeltingRecipes.init();
		PulverizerRecipes.init();
		CompressorRecipesNova.init();
	}
	
	public static class CraftingRecipes {
		public static void init() {
			
			// Eden Bloodstone
			ItemStack css = new ItemStack(BlockList.edenBloodStone, 4);
			GameRegistry.addRecipe(css, new Object[] { "CC ", "CC ", "   ",
					'C', BlockList.edenBloodSand });
			totalCraftingRecipes++;
			
			// Edenwood Planks
			GameRegistry.addShapelessRecipe(new ItemStack(
					BlockList.edenWoodPlanks, 4),
					new Object[] { BlockList.edenWoodLog });
			totalCraftingRecipes++;
			
			// Edenrock Bricks
			ItemStack edenRockBricks = new ItemStack(BlockList.edenRockBricks,
					4);
			GameRegistry.addRecipe(edenRockBricks, new Object[] { "CC ", "CC ",
					"   ", 'C', BlockList.edenRock });
			totalCraftingRecipes++;
			
			// Zolrock Bricks
			ItemStack zolRockBricks = new ItemStack(BlockList.zolRockBricks, 4);
			GameRegistry.addRecipe(edenRockBricks, new Object[] { "CC ", "CC ",
					"   ", 'C', BlockList.zolstone });
			totalCraftingRecipes++;
			
			// Kriffrock Bricks
			ItemStack kriffonRockBricks = new ItemStack(
					BlockList.kriffRockBricks, 4);
			GameRegistry.addRecipe(edenRockBricks, new Object[] { "CC ", "CC ",
					"   ", 'C', BlockList.kriffStone });
			totalCraftingRecipes++;
			
			// Purgrock Bricks
			ItemStack purgRockBricks = new ItemStack(BlockList.purgRockBricks,
					4);
			GameRegistry.addRecipe(edenRockBricks, new Object[] { "CC ", "CC ",
					"   ", 'C', BlockList.purgStone });
			totalCraftingRecipes++;
			
			// Virinium Block
			GameRegistry
					.addRecipe(new ItemStack(BlockList.edenViriBlock, 1),
							new Object[] { "VVV", "VVV", "VVV", 'V',
									ItemList.ingotViri });
			totalCraftingRecipes++;
			
			// Britestone
			GameRegistry.addRecipe(new ItemStack(BlockList.edenBrightStone, 1),
					new Object[] { "XX ", "XX ", "   ", 'X',
							ItemList.brightStoneDust });
			GameRegistry.addShapelessRecipe(new ItemStack(
					ItemList.brightStoneDust, 4),
					new Object[] { BlockList.edenBrightStone });
			totalCraftingRecipes++;
			
			// HUD
			GameRegistry.addRecipe(new ItemStack(ItemList.hud, 1),
					new Object[] { "RXR", "SDS", "RXR", 'R', Items.redstone,
							'X', new ItemStack(GCItems.basicItem, 1, 3), 'S',
							new ItemStack(GCItems.basicItem, 1, 5), 'D',
							new ItemStack(MarsItems.marsItemBasic, 1, 3) });
			totalCraftingRecipes++;
			
			// Eden's Essence
			GameRegistry.addRecipe(
					new ItemStack(ItemList.ancientEssenceEden, 1),
					new Object[] { "CVC", "ZBZ", "CIC", 'C',
							ItemList.edenCrystal, 'V',
							ItemList.edenCompressedVirinium, 'Z',
							GCItems.meteoricIronIngot, 'B',
							BlockList.edenViriBlock, 'I',
							BlockList.edenBrightStone });
			totalCraftingRecipes++;
			
			// Ancient Tablet (Eden)
			GameRegistry.addRecipe(new ItemStack(ItemList.edenZollusTablet, 1),
					new Object[] { "CVC", "XAX", "VAV", 'C',
							ItemList.edenCrystal, 'V',
							ItemList.edenCompressedVirinium, 'X',
							new ItemStack(GCItems.basicItem, 1, 3), 'A',
							ItemList.ancientEssenceEden });
			totalCraftingRecipes++;
			
			// Ancient Tablet (Zollus)
			GameRegistry.addRecipe(new ItemStack(ItemList.zollusKriffonTablet,
					1), new Object[] { "VCV", "HYH", "YCY", 'V',
					ItemList.zollusCompressedVyrex, 'C',
					ItemList.zollusCompressedHeartium, 'H',
					ItemList.zollusHeartium, 'Y', ItemList.zollusCrystal });
			totalCraftingRecipes++;
			
			// Kriffon Crystal
			GameRegistry.addRecipe(new ItemStack(ItemList.kriffonCrystal, 1),
					new Object[] { "FZF", "CVC", "ERE", 'F',
							ItemList.compressedKriffonium, 'Z',
							ItemList.zollusCrystal, 'C',
							ItemList.compressedCobalt, 'V',
							ItemList.edenCompressedVirinium, 'E',
							ItemList.edenCrystal, 'R',
							ItemList.zollusCompressedVyrex });
			totalCraftingRecipes++;
			
			// Ancient Tablet (Purgot)
			GameRegistry.addRecipe(new ItemStack(ItemList.kriffonPurgotTablet,
					1), new Object[] { "K K", " C ", "K K", 'K',
					ItemList.kriffonCrystal, 'C', ItemList.compressedCobalt });
			totalCraftingRecipes++;
			
			NovaHelper.echo("Loaded a total of " + totalCraftingRecipes
					+ " new crafting recipes.");
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
			addSmelting(BlockList.edenRedstoneOre, new ItemStack(
					Blocks.redstone_ore, 2), 2.0F); // Redstone
			addSmelting(BlockList.edenLapisOre, new ItemStack(Blocks.lapis_ore,
					2), 2.0F); // Lapis
			addSmelting(BlockList.edenAluminumOre, new ItemStack(
					GCBlocks.basicBlock, 2, 7), 2.0F); // Aluminum
			addSmelting(ItemList.rawViri, new ItemStack(ItemList.ingotViri, 1),
					2.0F); // Viri
			addSmelting(BlockList.edenViriOre, new ItemStack(ItemList.rawViri,
					1), 1.0F); // Viri
			
			// Ores (Zollus)
			addSmelting(BlockList.zolCoalOre,
					new ItemStack(Blocks.coal_ore, 3), 2.5F); // Coal
			addSmelting(BlockList.zolCopperOre, new ItemStack(
					GCBlocks.basicBlock, 3, 5), 2.5F); // Copper
			addSmelting(BlockList.zolGoldOre,
					new ItemStack(Blocks.gold_ore, 3), 2.5F); // Gold
			addSmelting(BlockList.zolIronOre,
					new ItemStack(Blocks.iron_ore, 3), 2.5F); // Iron
			addSmelting(BlockList.zolTinOre, new ItemStack(GCBlocks.basicBlock,
					3, 6), 2.5F); // Tin
			addSmelting(BlockList.zolHeartOre, new ItemStack(
					ItemList.zollusHeartium, 1), 1.0F); // Heartium
			
			// Ores (Kriffon)
			addSmelting(BlockList.kriffCoalOre, new ItemStack(Blocks.coal_ore),
					2.0F); // Coal
			addSmelting(BlockList.kriffIronOre, new ItemStack(Blocks.iron_ore,
					4), 2.0F);// Iron
			addSmelting(BlockList.kriffGoldOre, new ItemStack(Blocks.gold_ore,
					4), 2.0F);// Gold
			addSmelting(BlockList.kriffRedstoneOre, new ItemStack(
					Blocks.redstone_ore, 4), 2.0F); // Redstone
			addSmelting(BlockList.kriffCopperOre, new ItemStack(
					GCBlocks.basicBlock, 4, 5), 2.0F); // Copper
			addSmelting(BlockList.kriffCobaltOre, new ItemStack(
					ItemList.ingotCobalt, 1), 1.0F); // Cobalt
			
			// Ores (Purgot)
			addSmelting(BlockList.purgIronOre,
					new ItemStack(Blocks.iron_ore, 5), 4.0F);// Iron
			addSmelting(BlockList.purgGoldOre,
					new ItemStack(Blocks.gold_ore, 5), 4.0F);// Gold
			addSmelting(BlockList.purgCopperOre, new ItemStack(
					GCBlocks.basicBlock, 5, 5), 4.0F); // Copper
			addSmelting(BlockList.purgDiamondOre, new ItemStack(
					Blocks.diamond_ore, 5), 4.0F); // Diamond
			addSmelting(BlockList.purgEmeraldOre, new ItemStack(
					Blocks.emerald_ore, 5), 4.0F); // Emerald
			addSmelting(BlockList.purgEveOre, new ItemStack(
					ItemList.ingotEvenium, 1), 4.0F);
			
			// Other
			addSmelting(BlockList.edenCobbleRock, BlockList.edenRock, 0.4F);
			addSmelting(BlockList.edenBloodSand, BlockList.edenGlass, 0.7F);
			addSmelting(BlockList.zolCobbleRock, BlockList.zolstone, 0.4F);
			addSmelting(BlockList.kriffCobbleRock, BlockList.kriffStone, 0.4F);
			addSmelting(BlockList.purgCobbleRock, BlockList.purgStone, 0.6F);
			addSmelting(ItemList.dustAluminum, new ItemStack(GCItems.basicItem,
					1, 5), 0.9F);
			addSmelting(ItemList.dustCobalt, new ItemStack(
					ItemList.ingotCobalt, 1), 1.5F);
			addSmelting(ItemList.dustDiamond, new ItemStack(Items.diamond, 1),
					0.6F);
			addSmelting(ItemList.dustEmerald, new ItemStack(Items.emerald, 1),
					0.6F);
			addSmelting(ItemList.dustEvenium, new ItemStack(
					ItemList.ingotEvenium, 1), 1.5F);
			
			NovaHelper.echo("Loaded a total of " + totalSmeltingRecipes
					+ " new smelting recipes.");
			
		}
		
		public static void addSmelting(ItemStack itemStack, ItemStack output,
				float xp) {
			GameRegistry.addSmelting(itemStack, output, xp);
			totalSmeltingRecipes++;
		}
		
		public static void addSmelting(Block input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Item input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
			totalSmeltingRecipes++;
		}
		
		public static void addSmelting(Item input, Item output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
		
		public static void addSmelting(Block input, ItemStack output, float xp) {
			GameRegistry.addSmelting(input, output, xp);
			totalSmeltingRecipes++;
		}
		
		public static void addSmelting(Block input, Block output, float xp) {
			addSmelting(input, new ItemStack(output, 1), xp);
		}
	}
	
	public static class PulverizerRecipes {
		
		public static void init() {
			
			// Diamond Ore
			ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
					Blocks.diamond_ore),
					new ItemStack(ItemList.dustDiamond, 2), new ItemStack(
							Items.coal), 65);
			totalPulverizerRecipes++;
			
			// Aluminum Ore
			ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
					GCBlocks.basicBlock, 1, 7), new ItemStack(
					ItemList.dustAluminum, 2), new ItemStack(Items.coal), 30);
			totalPulverizerRecipes++;
			
			// Aluminum Ingot
			ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
					GCItems.basicItem, 1, 5), new ItemStack(
					ItemList.dustAluminum, 1), new ItemStack(Items.coal), 1);
			totalPulverizerRecipes++;
			
			// Cobalt Ore
			ThermalExpansionHelper.addPulverizerRecipe(2600, new ItemStack(
					BlockList.kriffCobaltOre, 1), new ItemStack(
					ItemList.dustCobalt, 2), new ItemStack(
					ItemList.dustAluminum), 15);
			totalPulverizerRecipes++;
			
			// Emerald Ore
			ThermalExpansionHelper.addPulverizerRecipe(1600, new ItemStack(
					Blocks.emerald_ore),
					new ItemStack(ItemList.dustEmerald, 2), new ItemStack(
							ItemList.dustDiamond), 65);
			totalPulverizerRecipes++;
			
			// Cobalt Ingot
			ThermalExpansionHelper.addPulverizerRecipe(2800, new ItemStack(
					ItemList.ingotCobalt, 1), new ItemStack(
					ItemList.dustCobalt, 1), new ItemStack(Items.coal), 1);
			totalPulverizerRecipes++;
			
			// Evenium Ore
			ThermalExpansionHelper.addPulverizerRecipe(2600, new ItemStack(
					BlockList.purgEveOre, 1), new ItemStack(
					ItemList.dustEvenium, 2),
					new ItemStack(ItemList.dustCobalt), 5);
			totalPulverizerRecipes++;
			
			// Evenium Ingot
			ThermalExpansionHelper.addPulverizerRecipe(2800, new ItemStack(
					ItemList.ingotEvenium, 1), new ItemStack(
					ItemList.dustEvenium, 1), new ItemStack(
					ItemList.ingotCobalt), 1);
			totalPulverizerRecipes++;
			
			NovaHelper.echo("Loaded a total of " + totalPulverizerRecipes
					+ " new pulverizer recipes.");
		}
	}
	
	public static class CompressorRecipesNova {
		
		public static void init() {
			
			// Compressed Virinium
			CompressorRecipes.addShapelessRecipe(new ItemStack(
					ItemList.edenCompressedVirinium, 2), new ItemStack(
					ItemList.ingotViri, 1, 0), new ItemStack(
					ItemList.ingotViri, 1, 0));
			totalCompressorRecipes++;
			
			// Compressed Heartium
			CompressorRecipes.addShapelessRecipe(new ItemStack(
					ItemList.zollusCompressedHeartium, 2), new ItemStack(
					ItemList.zollusHeartium, 1, 0), new ItemStack(
					ItemList.zollusHeartium, 1, 0));
			totalCompressorRecipes++;
			
			// Compressed Vyrex
			CompressorRecipes.addShapelessRecipe(new ItemStack(
					ItemList.zollusCompressedVyrex, 2), new ItemStack(
					ItemList.edenCompressedVirinium, 1, 0), new ItemStack(
					ItemList.zollusCompressedHeartium, 1, 0));
			totalCompressorRecipes++;
			
			// Compressed Cobalt
			CompressorRecipes.addShapelessRecipe(new ItemStack(
					ItemList.compressedCobalt, 2), new ItemStack(
					ItemList.ingotCobalt, 1, 0), new ItemStack(
					ItemList.ingotCobalt, 1, 0));
			totalCompressorRecipes++;
			
			// Compressed Kriffonium
			CompressorRecipes.addShapelessRecipe(new ItemStack(
					ItemList.compressedKriffonium, 2), new ItemStack(
					ItemList.zollusCompressedVyrex, 1, 0), new ItemStack(
					ItemList.compressedCobalt, 1, 0));
			totalCompressorRecipes++;
			
			NovaHelper.echo("Loaded a total of " + totalCompressorRecipes
					+ " new compressor recipes.");
		}
	}
}