package zollerngalaxy.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;

public class OreDictRegistry {
	
	public static void init() {
		// Copper
		registerOre("oreCopper", ZGBlocks.edenCopperOre, ZGBlocks.kriffCopperOre,
				ZGBlocks.purgCopperOre, ZGBlocks.zolCopperOre);
		
		// Tin
		registerOre("oreTin", ZGBlocks.edenTinOre, ZGBlocks.purgTinOre, ZGBlocks.zolTinOre);
		
		// Lead
		registerOre("oreLead", ZGBlocks.edenLeadOre, ZGBlocks.purgLeadOre);
		
		// Silver
		registerOre("oreSilver", ZGBlocks.edenSilverOre);
		
		// Lapis
		registerOre("oreLapis", ZGBlocks.edenLapisOre);
		
		// Dirt
		registerOre("dirt", ZGBlocks.edenSoil, ZGBlocks.kriffDirt, ZGBlocks.purgDirt,
				ZGBlocks.zolDirt);
		
		// Gravel
		registerOre("gravel", ZGBlocks.edenGravel, ZGBlocks.purgGravel);
		
		// Grass
		registerOre("grass", ZGBlocks.edenGoldenGrass, ZGBlocks.edenGrass, ZGBlocks.edenSwampGrass);
		
		// Logs
		registerOre("logWood", ZGBlocks.edenWoodLog);
		
		// Leaves
		registerOre("treeLeaves", ZGBlocks.edenWoodLeaves);
		
		// Saplings
		registerOre("treeSapling", ZGBlocks.edenWoodSapling);
		
		// Planks
		registerOre("plankWood", ZGBlocks.edenWoodPlanks);
		
		// Stone
		registerOre("stone", ZGBlocks.edenStone, ZGBlocks.kriffStone, ZGBlocks.purgStone,
				ZGBlocks.zolStone);
		
		// Stone Bricks
		registerOre("stonebrick", ZGBlocks.edenRockBricks, ZGBlocks.kriffRockBricks,
				ZGBlocks.purgRockBricks, ZGBlocks.zolRockBricks);
		
		// Glowstone
		registerOre("glowstone", ZGBlocks.edenBrightStone);
		
		// Sand
		registerOre("sand", ZGBlocks.edenBloodSand);
		
		// Cobble
		registerOre("cobblestone", ZGBlocks.edenCobbleRock, ZGBlocks.kriffCobbleRock,
				ZGBlocks.purgCobbleRock, ZGBlocks.zolCobbleRock);
		
		// Coal
		registerOre("oreCoal", ZGBlocks.edenCoalOre, ZGBlocks.kriffCoalOre, ZGBlocks.zolCoalOre);
		
		// Iron
		registerOre("oreIron", ZGBlocks.edenIronOre, ZGBlocks.kriffIronOre, ZGBlocks.purgIronOre,
				ZGBlocks.zolIronOre);
		
		// Gold
		registerOre("oreGold", ZGBlocks.edenGoldOre, ZGBlocks.kriffGoldOre, ZGBlocks.purgGoldOre,
				ZGBlocks.zolGoldOre);
		
		// Nickle
		registerOre("oreNickel", ZGBlocks.edenNickleOre);
		
		// Diamond
		registerOre("oreDiamond", ZGBlocks.edenDiamondOre, ZGBlocks.purgDiamondOre);
		registerOre("dustDiamond", ZGItems.dustDiamond);
		
		// Emerald
		registerOre("oreEmerald", ZGBlocks.edenEmeraldOre, ZGBlocks.purgEmeraldOre);
		registerOre("dustEmerald", ZGItems.dustEmerald);
		
		// Redstone
		registerOre("oreRedstone", ZGBlocks.edenRedstoneOre, ZGBlocks.kriffRedstoneOre,
				ZGBlocks.purgRedstoneOre);
		
		// Steel
		registerOre("oreSteel", ZGBlocks.edenSteelOre);
		
		// Platinum
		registerOre("orePlatinum", ZGBlocks.edenPlatinumOre);
		
		// Electrum
		registerOre("oreElectrum", ZGBlocks.edenElectrumOre);
		
		// Invar
		registerOre("oreInvar", ZGBlocks.edenInvarOre);
		
		// Bronze
		registerOre("oreBronze", ZGBlocks.edenBronzeOre);
		
		// Desh
		registerOre("oreDesh", ZGBlocks.edenDeshOre);
		
		// Meteoric Iron
		registerOre("oreMeteoricIron", ZGBlocks.edenMeteoricIronOre, ZGBlocks.purgMeteoricIronOre);
		
		// Aluminum
		registerOre("oreAluminum", ZGBlocks.edenAluminumOre, ZGBlocks.purgAluminumOre);
		
		// Heartium
		registerOre("oreHeartium", ZGBlocks.edenHeartiumOre, ZGBlocks.zolHeartOre);
		registerOre("gemHeartium", ZGItems.heartOfZol);
		
		// Cobalt
		registerOre("oreCobalt", ZGBlocks.edenCobaltOre, ZGBlocks.kriffCobaltOre,
				ZGBlocks.purgCobaltOre);
		registerOre("dustCobalt", ZGItems.dustCobalt);
		registerOre("ingotCobalt", ZGItems.ingotCobalt);
		registerOre("blockCobalt", ZGBlocks.blockCobalt);
		
		// Evenium
		registerOre("oreEvenium", ZGBlocks.edenEveniumOre, ZGBlocks.purgEveniumOre);
		registerOre("dustEvenium", ZGItems.dustEve);
		registerOre("ingotEvenium", ZGItems.ingotEve);
		registerOre("blockEvenium", ZGBlocks.blockEve);
		
		// Virinium
		registerOre("oreVirinium", ZGBlocks.edenViriniumOre);
		registerOre("dustVirinium", ZGItems.dustViri);
		registerOre("ingotVirinium", ZGItems.ingotViri);
		registerOre("blockVirinium", ZGBlocks.blockViri);
		
		// Titanium
		// TODO
		
		// TODO: Add More
	}
	
	private static void registerOre(String strName, Item... items) {
		for (Item i : items) {
			OreDictionary.registerOre(strName, i);
		}
	}
	
	private static void registerOre(String strName, Block... blocks) {
		for (Block b : blocks) {
			OreDictionary.registerOre(strName, b);
		}
	}
}