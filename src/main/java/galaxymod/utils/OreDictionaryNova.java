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
import galaxymod.items.ItemList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryNova {
	
	static int totalEntries = 0;
	
	public static void init() {
		
		// Blocks (Ores)
		
		// Coal
		registerOre("oreCoal", BlockList.edenCoalOre, BlockList.zolCoalOre,
				BlockList.kriffCoalOre);
		
		// Copper
		registerOre("oreCopper", BlockList.edenCopperOre,
				BlockList.zolCopperOre, BlockList.kriffCopperOre,
				BlockList.purgCopperOre);
		
		// Desh
		registerOre("oreDesh", BlockList.edenDeshOre);
		
		// Diamond
		registerOre("oreDiamond", BlockList.edenDiamondOre,
				BlockList.purgDiamondOre);
		
		// Emerald
		registerOre("oreEmerald", BlockList.edenEmeraldOre);
		
		// Gold
		registerOre("oreGold", BlockList.edenGoldOre, BlockList.zolGoldOre,
				BlockList.kriffGoldOre, BlockList.purgGoldOre);
		
		// Iron
		registerOre("oreIron", BlockList.edenIronOre, BlockList.zolIronOre,
				BlockList.kriffIronOre, BlockList.purgIronOre);
		
		// Meteoric Iron
		registerOre("oreMeteoricIron", BlockList.edenMeteoricIronOre);
		
		// Redstone
		registerOre("oreRedstone", BlockList.edenRedstoneOre,
				BlockList.kriffRedstoneOre);
		
		// Lapis
		registerOre("oreLapis", BlockList.edenLapisOre);
		
		// Tin
		registerOre("oreTin", BlockList.edenTinOre, BlockList.zolTinOre);
		
		// Virinium
		registerOre("oreVirinium", BlockList.edenViriOre);
		
		// Heartium
		registerOre("oreHeartium", BlockList.zolHeartOre);
		
		// Cobalt
		registerOre("oreCobalt", BlockList.kriffCobaltOre);
		
		// Blocks (Trees)
		registerOre("plankWood", BlockList.edenWoodPlanks);
		registerOre("logWood", BlockList.edenWoodLog);
		registerOre("treeLeaves", BlockList.edenWoodLeaves);
		registerOre("treeSapling", BlockList.edenWoodSapling);
		
		// Items (Ingots)
		registerOre("ingotCobalt", ItemList.ingotCobalt);
		registerOre("ingotViri", ItemList.ingotViri);
		
		// Items (Dust)
		registerOre("dustAluminum", ItemList.dustAluminum);
		registerOre("dustCobalt", ItemList.dustCobalt);
		registerOre("dustDiamond", ItemList.dustDiamond);
		
		NovaHelper.echo("Loaded a total of " + totalEntries
				+ " Ore Dictionary entries.");
	}
	
	public static void registerOre(String strName, Item item) {
		OreDictionary.registerOre(strName, new ItemStack(item, 1));
		totalEntries++;
	}
	
	public static void registerOre(String strName, Block block) {
		OreDictionary.registerOre(strName, new ItemStack(block, 1));
		totalEntries++;
	}
	
	public static void registerOre(String strName, Block... blocks) {
		for (Block novaBlock : blocks) {
			registerOre(strName, novaBlock);
		}
	}
	
	public static void registerOre(String strName, Item... items) {
		for (Item novaItem : items) {
			registerOre(strName, novaItem);
		}
	}
	
}