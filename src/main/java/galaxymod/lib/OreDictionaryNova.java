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

package galaxymod.lib;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryNova {
	
	static int totalEntries = 0;
	
	public static void init() {
		
		// Blocks
		registerOre("oreCoal", BlockList.edenCoalOre);
		registerOre("oreCoal", BlockList.zolCoalOre);
		registerOre("oreCoal", BlockList.kriffCoalOre);
		
		registerOre("oreCopper", BlockList.edenCopperOre);
		registerOre("oreCopper", BlockList.zolCopperOre);
		registerOre("oreCopper", BlockList.kriffCopperOre);
		
		registerOre("oreDesh", BlockList.edenDeshOre);
		
		registerOre("oreDiamond", BlockList.edenDiamondOre);
		
		registerOre("oreEmerald", BlockList.edenEmeraldOre);
		
		registerOre("oreGold", BlockList.edenGoldOre);
		registerOre("oreGold", BlockList.zolGoldOre);
		registerOre("oreGold", BlockList.kriffGoldOre);
		
		registerOre("oreIron", BlockList.edenIronOre);
		registerOre("oreIron", BlockList.zolIronOre);
		registerOre("oreIron", BlockList.kriffIronOre);
		
		registerOre("oreMeteoricIron", BlockList.edenMeteoricIronOre);
		
		registerOre("oreRedstone", BlockList.edenRedstoneOre);
		
		registerOre("oreTin", BlockList.edenTinOre);
		registerOre("oreTin", BlockList.zolTinOre);
		
		registerOre("oreVirinium", BlockList.edenViriOre);
		
		registerOre("oreHeartium", BlockList.zolHeartOre);
		
		registerOre("plankWood", BlockList.edenWoodPlanks);
		registerOre("logWood", BlockList.edenWoodLog);
		registerOre("treeLeaves", BlockList.edenWoodLeaves);
		registerOre("treeSapling", BlockList.edenWoodSapling);
		
		// Items
		registerOre("ingotViri", ItemList.ingotViri);
		registerOre("dustAluminum", ItemList.aluminumDust);
		
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
	
}