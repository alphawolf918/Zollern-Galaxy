package zollerngalaxy.util;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;

public class OreDictRegistry {
	
	public static void init() {
		// Copper
		registerOre("oreCopper", ZGBlocks.edenCopperOre, ZGBlocks.kriffCopperOre, ZGBlocks.purgCopperOre, ZGBlocks.zolCopperOre,
				ZGBlocks.xantheonCopperOre);
		
		// Tin
		registerOre("oreTin", ZGBlocks.edenTinOre, ZGBlocks.purgTinOre, ZGBlocks.zolTinOre, ZGBlocks.xathTinOre,
				ZGBlocks.oasisTinOre, ZGBlocks.atheonTinOre);
		
		// Lead
		registerOre("oreLead", ZGBlocks.edenLeadOre, ZGBlocks.purgLeadOre, ZGBlocks.oasisLeadOre);
		
		// Silver
		registerOre("oreSilver", ZGBlocks.edenSilverOre);
		
		// Lapis
		registerOre("oreLapis", ZGBlocks.edenLapisOre);
		
		// Dirt
		registerOre("dirt", ZGBlocks.edenSoil, ZGBlocks.kriffDirt, ZGBlocks.purgDirt, ZGBlocks.zolDirt, ZGBlocks.xathDirt,
				ZGBlocks.oasisDirt, ZGBlocks.perdCreepDirt, ZGBlocks.perdSoil);
		
		// Constructed
		registerOre("blockConstructed", ZGBlocks.xantheonConstructBlock, ZGBlocks.atheonConstructBlock);
		
		// Space Station
		registerOre("blockSpaceStation", ZGBlocks.blockSpaceStation);
		
		// Gravel
		registerOre("gravel", ZGBlocks.edenGravel, ZGBlocks.purgGravel, ZGBlocks.xathGravel, ZGBlocks.oasisGravel,
				ZGBlocks.perdGravel);
		
		// Grass
		registerOre("grass", ZGBlocks.edenGoldenGrass, ZGBlocks.edenGrass, ZGBlocks.edenSwampGrass, ZGBlocks.xathGrass,
				ZGBlocks.oasisGrass);
		
		// Logs
		registerOre("logWood", ZGBlocks.edenWoodLog);
		
		// Leaves
		registerOre("treeLeaves", ZGBlocks.edenWoodLeaves);
		
		// Saplings
		registerOre("treeSapling", ZGBlocks.edenWoodSapling);
		
		// Planks
		registerOre("plankWood", ZGBlocks.edenWoodPlanks);
		
		// Stone
		registerOre("stone", ZGBlocks.edenStone, ZGBlocks.kriffStone, ZGBlocks.purgStone, ZGBlocks.zolStone, ZGBlocks.xathStone,
				ZGBlocks.oasisStone, ZGBlocks.xantheonStone, ZGBlocks.atheonStone, ZGBlocks.perdStone, ZGBlocks.perdCreepStone,
				ZGBlocks.perdCaveStone);
		
		// Stone Bricks
		registerOre("stonebrick", ZGBlocks.edenRockBricks, ZGBlocks.kriffRockBricks, ZGBlocks.purgRockBricks,
				ZGBlocks.zolRockBricks, ZGBlocks.xathRockBricks, ZGBlocks.oasisRockBricks, ZGBlocks.blockShinestoneCrystalBricks,
				ZGBlocks.atheonRockBricks, ZGBlocks.perdRockBricks, ZGBlocks.perdCaveStoneBricks);
		
		// Glowstone
		registerOre("glowstone", ZGBlocks.edenBrightStone, ZGBlocks.blockShinestone, ZGBlocks.perdGlowstone);
		
		// Sand
		registerOre("sand", ZGBlocks.edenBloodSand, ZGBlocks.perdSand);
		
		// Cobble
		registerOre("cobblestone", ZGBlocks.edenCobbleRock, ZGBlocks.kriffCobbleRock, ZGBlocks.purgCobbleRock,
				ZGBlocks.zolCobbleRock, ZGBlocks.xathCobble, ZGBlocks.oasisCobble, ZGBlocks.atheonCobble, ZGBlocks.perdCobble);
		
		// Coal
		registerOre("oreCoal", ZGBlocks.edenCoalOre, ZGBlocks.kriffCoalOre, ZGBlocks.zolCoalOre, ZGBlocks.oasisCoalOre,
				ZGBlocks.xantheonCoalOre);
		
		// Iron
		registerOre("oreIron", ZGBlocks.edenIronOre, ZGBlocks.kriffIronOre, ZGBlocks.purgIronOre, ZGBlocks.zolIronOre,
				ZGBlocks.xathIronOre, ZGBlocks.oasisIronOre, ZGBlocks.xantheonIronOre, ZGBlocks.perdIronOre);
		
		// Gold
		registerOre("oreGold", ZGBlocks.edenGoldOre, ZGBlocks.kriffGoldOre, ZGBlocks.purgGoldOre, ZGBlocks.zolGoldOre,
				ZGBlocks.xathGoldOre, ZGBlocks.oasisGoldOre, ZGBlocks.perdGoldOre);
		
		// Nickel
		registerOre("oreNickel", ZGBlocks.edenNickelOre, ZGBlocks.xantheonNickelOre);
		
		// Diamond
		registerOre("oreDiamond", ZGBlocks.edenDiamondOre, ZGBlocks.purgDiamondOre, ZGBlocks.xathDiamondOre,
				ZGBlocks.oasisDiamondOre, ZGBlocks.atheonDiamondOre, ZGBlocks.perdDiamondOre);
		registerOre("dustDiamond", ZGItems.dustDiamond);
		
		// Emerald
		registerOre("oreEmerald", ZGBlocks.edenEmeraldOre, ZGBlocks.purgEmeraldOre, ZGBlocks.xathEmeraldOre);
		registerOre("dustEmerald", ZGItems.dustEmerald);
		
		// Redstone
		registerOre("oreRedstone", ZGBlocks.edenRedstoneOre, ZGBlocks.kriffRedstoneOre, ZGBlocks.purgRedstoneOre,
				ZGBlocks.xathRedstoneOre, ZGBlocks.oasisRedstoneOre, ZGBlocks.atheonRedstoneOre);
		
		// Steel
		registerOre("oreSteel", ZGBlocks.edenSteelOre);
		
		// Platinum
		registerOre("orePlatinum", ZGBlocks.edenPlatinumOre);
		registerOre("dustPlatinum", ZGItems.dustShinium);
		registerOre("ingotPlatinum", ZGItems.ingotShinium);
		registerOre("blockPlatinum", ZGBlocks.blockShinium);
		
		// Shinium
		registerOre("dustShinium", ZGItems.dustShinium);
		registerOre("ingotShinium", ZGItems.ingotShinium);
		registerOre("blockShinium", ZGBlocks.blockShinium);
		
		// Chargium
		registerOre("dustChargium", ZGItems.dustChargium);
		registerOre("ingotChargium", ZGItems.ingotChargium);
		registerOre("blockChargium", ZGBlocks.blockChargium);
		
		// Shinestone
		registerOre("dustShinestone", ZGItems.dustShinestone);
		registerOre("ingotShinestone", ZGItems.ingotShinestone);
		registerOre("blockShinestone", ZGBlocks.blockShinestone);
		
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
		registerOre("gemHeartium", ZGItems.heartium);
		
		// Etrium
		registerOre("oreEtrium", ZGBlocks.perdEtriumOre);
		registerOre("blockEtrium", ZGBlocks.blockPerdEtrium);
		registerOre("gemEtrium", ZGItems.perdEtrium);
		
		// Lost Diamond
		registerOre("oreLostDiamond", ZGBlocks.perdDiamondOre);
		registerOre("blockLostDiamond", ZGBlocks.blockPerdDiamond);
		registerOre("gemLostDiamond", ZGItems.perdDiamond);
		
		// Cobalt
		if (ConfigManagerZG.registerCobaltOreDict) {
			registerOre("oreCobalt", ZGBlocks.edenCobaltOre, ZGBlocks.kriffCobaltOre, ZGBlocks.purgCobaltOre);
			registerOre("dustCobalt", ZGItems.dustCobalt);
			registerOre("ingotCobalt", ZGItems.ingotCobalt);
			registerOre("blockCobalt", ZGBlocks.blockCobalt);
			registerOre("pickaxeCobalt", ZGItems.pickaxeCobalt);
			registerOre("shovelCobalt", ZGItems.shovelCobalt);
			registerOre("axeCobalt", ZGItems.axeCobalt);
			registerOre("hoeCobalt", ZGItems.hoeCobalt);
			registerOre("swordCobalt", ZGItems.swordCobalt);
		} else {
			registerOre("oreCobaltium", ZGBlocks.edenCobaltOre, ZGBlocks.kriffCobaltOre, ZGBlocks.purgCobaltOre);
			registerOre("dustCobaltium", ZGItems.dustCobalt);
			registerOre("ingotCobaltium", ZGItems.ingotCobalt);
			registerOre("blockCobaltium", ZGBlocks.blockCobalt);
			registerOre("pickaxeCobaltium", ZGItems.pickaxeCobalt);
			registerOre("shovelCobaltium", ZGItems.shovelCobalt);
			registerOre("axeCobaltium", ZGItems.axeCobalt);
			registerOre("hoeCobaltium", ZGItems.hoeCobalt);
			registerOre("swordCobaltium", ZGItems.swordCobalt);
		}
		
		// Evenium
		registerOre("oreEvenium", ZGBlocks.edenEveniumOre, ZGBlocks.purgEveniumOre);
		registerOre("dustEvenium", ZGItems.dustEvenium);
		registerOre("ingotEvenium", ZGItems.ingotEvenium);
		registerOre("blockEvenium", ZGBlocks.blockEve);
		registerOre("pickaxeEvenium", ZGItems.pickaxeEvenium);
		registerOre("shovelEvenium", ZGItems.shovelEvenium);
		registerOre("axeEvenium", ZGItems.axeEvenium);
		registerOre("hoeEvenium", ZGItems.hoeEvenium);
		registerOre("swordEvenium", ZGItems.swordEvenium);
		
		// Virinium
		registerOre("oreVirinium", ZGBlocks.edenViriniumOre);
		registerOre("dustVirinium", ZGItems.dustVirinium);
		registerOre("ingotVirinium", ZGItems.ingotVirinium);
		registerOre("blockVirinium", ZGBlocks.blockViri);
		registerOre("pickaxeVirinium", ZGItems.pickaxeVirinium);
		registerOre("shovelVirinium", ZGItems.shovelVirinium);
		registerOre("axeVirinium", ZGItems.axeVirinium);
		registerOre("hoeVirinium", ZGItems.hoeVirinium);
		registerOre("swordVirinium", ZGItems.swordVirinium);
		
		// Amaranth
		registerOre("oreAmaranth", ZGBlocks.xantheonAmaranthOre, ZGBlocks.atheonAmaranthOre);
		registerOre("dustAmaranth", ZGItems.dustAmaranth);
		registerOre("ingotAmaranth", ZGItems.ingotAmaranth);
		registerOre("blockAmaranth", ZGBlocks.blockAmaranth);
		registerOre("pickaxeAmaranth", ZGItems.pickaxeAmaranth);
		registerOre("shovelAmaranth", ZGItems.shovelAmaranth);
		registerOre("axeAmaranth", ZGItems.axeAmaranth);
		registerOre("hoeAmaranth", ZGItems.hoeAmaranth);
		registerOre("swordAmaranth", ZGItems.swordAmaranth);
		
		// Azurite
		registerOre("oreAzurite", ZGBlocks.xathAzuriteOre);
		registerOre("gemAzurite", ZGItems.azurite);
		registerOre("blockAzurite", ZGBlocks.blockAzurite);
		registerOre("pickaxeAzurite", ZGItems.pickaxeAzurite);
		registerOre("shovelAzurite", ZGItems.shovelAzurite);
		registerOre("axeAzurite", ZGItems.axeAzurite);
		registerOre("hoeAzurite", ZGItems.hoeAzurite);
		registerOre("swordAzurite", ZGItems.swordAzurite);
		
		// Zollernium
		registerOre("oreZollernium", ZGBlocks.atheonZollerniumOre);
		registerOre("dustZollernium", ZGItems.dustZollernium);
		registerOre("ingotZollernium", ZGItems.ingotZollernium);
		registerOre("blockZollernium", ZGBlocks.blockZollernium);
		registerOre("pickaxeZollernium", ZGItems.pickaxeZollernium);
		registerOre("shovelZollernium", ZGItems.shovelZollernium);
		registerOre("axeZollernium", ZGItems.axeZollernium);
		registerOre("hoeZollernium", ZGItems.hoeZollernium);
		registerOre("swordZollernium", ZGItems.swordZollernium);
		
		// Zinc
		registerOre("oreZinc", ZGBlocks.atheonZincOre);
		registerOre("dustZinc", ZGItems.dustZinc);
		registerOre("ingotZinc", ZGItems.ingotZinc);
		registerOre("blockZinc", ZGBlocks.blockZinc);
		
		// Promethean
		registerOre("orePromethean", ZGBlocks.xathPrometheanOre);
		registerOre("gemPromethean", ZGItems.prometheanCrystal);
		registerOre("blockPromethean", ZGBlocks.blockPromethean);
		
		// Super Charged Coal
		registerOre("oreSuperChargedCoal", ZGBlocks.oasisSuperChargedCoalOre);
		registerOre("gemSuperChargedCoal", ZGItems.superChargedCoal);
		registerOre("blockSuperChargedCoal", ZGBlocks.blockSuperChargedCoal);
		
		// Uranium
		if (ConfigManagerZG.fueltoniumIsUranium) {
			registerOre("oreUranium", ZGBlocks.xantheonFueltoniumOre);
			registerOre("ingotUranium", ZGItems.ingotFueltonium);
			registerOre("dustUranium", ZGItems.dustFueltonium);
			registerOre("blockUranium", ZGBlocks.blockFueltonium);
		}
		
		// Fueltonium
		registerOre("oreFueltonium", ZGBlocks.xantheonFueltoniumOre);
		registerOre("ingotFueltonium", ZGItems.ingotFueltonium);
		registerOre("dustFueltonium", ZGItems.dustFueltonium);
		registerOre("blockFueltonium", ZGBlocks.blockFueltonium);
		
		// Plutonium
		registerOre("orePlutonium", ZGBlocks.xantheonPlutoniumOre);
		registerOre("gemPlutonium", ZGItems.plutoniumCrystal);
		registerOre("blockPlutonium", ZGBlocks.blockPlutonium);
		
		// Blazerock
		registerOre("blockBlazePowder", ZGBlocks.kriffBlazeRock);
		registerOre("gemBlazePowder", Items.BLAZE_POWDER);
		
		// Perdita Glowstone
		registerOre("dustLostGlowstone", ZGItems.perdGlowdust);
		
		// Cactus
		registerOre("blockCactus", ZGBlocks.perdCactus);
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