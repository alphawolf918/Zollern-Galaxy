/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
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
		// Amber
		registerOre("blockAmber", ZGBlocks.blockAmber);
		registerOre("oreAmber", ZGBlocks.caligroAmberOre);
		registerOre("gemAmber", ZGItems.amber);
		
		// Topaz
		registerOre("blockTopaz", ZGBlocks.blockTopaz);
		registerOre("oreTopaz", ZGBlocks.caligroTopazOre);
		registerOre("gemTopaz", ZGItems.topaz);
		
		// Opal
		registerOre("blockOpal", ZGBlocks.blockOpal);
		registerOre("oreOpal", ZGBlocks.caligroOpalOre);
		registerOre("gemOpal", ZGItems.opal);
		
		// Aquamarine
		registerOre("blockAquamarine", ZGBlocks.blockAquamarine);
		registerOre("oreAquamarine", ZGBlocks.caligroAquamarineOre);
		registerOre("gemAquamarine", ZGItems.aquamarine);
		
		// Garnet
		registerOre("blockGarnet", ZGBlocks.blockGarnet);
		registerOre("oreGarnet", ZGBlocks.caligroGarnetOre);
		registerOre("gemGarnet", ZGItems.garnet);
		
		// Garnet
		registerOre("blockRuby", ZGBlocks.blockRuby);
		registerOre("oreRuby", ZGBlocks.caligroRubyOre);
		registerOre("gemRuby", ZGItems.ruby);
		
		// Static Amber
		registerOre("blockAmberStatic", ZGBlocks.blockAmberStatic);
		registerOre("gemAmberStatic", ZGItems.amberStatic);
		
		// Icy Aquamarine
		registerOre("blockAquamarineIcy", ZGBlocks.blockAquamarineIcy);
		registerOre("gemAquamarineIcy", ZGItems.aquamarineIcy);
		
		// Garnet
		registerOre("blockGarnetFire", ZGBlocks.blockGarnetFire);
		registerOre("gemGarnetFire", ZGItems.garnetFire);
		
		// Witherite
		registerOre("blockWitherite", ZGBlocks.blockWitherite);
		registerOre("oreWitherite", ZGBlocks.caligroWitheriteOre);
		registerOre("gemWitherite", ZGItems.witherite);
		
		// Netheridium
		registerOre("blockNetheridium", ZGBlocks.blockNetheridium);
		registerOre("gemNetheridium", ZGItems.netheridium);
		
		// Radium
		registerOre("blockRadium", ZGBlocks.blockRadium);
		registerOre("oreRadium", ZGBlocks.caligroRadiumOre);
		registerOre("gemRadium", ZGItems.radium);
		registerOre("ingotRadium", ZGItems.ingotRadium);
		
		// Ascendium
		registerOre("oreAscendium", ZGBlocks.corruptAscendiumOre);
		registerOre("gemAscendium", ZGItems.ascendium);
		
		// Copper
		registerOre("oreCopper", ZGBlocks.edenCopperOre, ZGBlocks.kriffCopperOre, ZGBlocks.purgCopperOre, ZGBlocks.zolCopperOre, ZGBlocks.xantheonCopperOre,
				ZGBlocks.caligroCopperOre, ZGBlocks.exodusCopperOre);
		
		// Tin
		registerOre("oreTin", ZGBlocks.edenTinOre, ZGBlocks.purgTinOre, ZGBlocks.zolTinOre, ZGBlocks.xathTinOre, ZGBlocks.oasisTinOre, ZGBlocks.atheonTinOre,
				ZGBlocks.caligroTinOre);
		
		// Lead
		registerOre("oreLead", ZGBlocks.edenLeadOre, ZGBlocks.purgLeadOre, ZGBlocks.oasisLeadOre, ZGBlocks.caligroLeadOre);
		
		// Silver
		registerOre("oreSilver", ZGBlocks.edenSilverOre, ZGBlocks.caligroSilverOre);
		
		// Lapis
		registerOre("oreLapis", ZGBlocks.edenLapisOre, ZGBlocks.caligroLapisOre);
		
		// Dirt
		registerOre("dirt", ZGBlocks.edenSoil, ZGBlocks.kriffDirt, ZGBlocks.purgDirt, ZGBlocks.zolDirt, ZGBlocks.xathDirt, ZGBlocks.oasisDirt,
				ZGBlocks.perdCreepDirt, ZGBlocks.perdSoil, ZGBlocks.altumDirt, ZGBlocks.caligroDirt, ZGBlocks.caligroCreepdirt, ZGBlocks.exodusDirt);
		
		// Constructed
		registerOre("blockConstructed", ZGBlocks.xantheonConstructBlock, ZGBlocks.atheonConstructBlock);
		
		// Space Station
		registerOre("blockSpaceStation", ZGBlocks.blockSpaceStation);
		
		// Gravel
		registerOre("gravel", ZGBlocks.edenGravel, ZGBlocks.purgGravel, ZGBlocks.xathGravel, ZGBlocks.oasisGravel, ZGBlocks.perdGravel, ZGBlocks.altumGravel,
				ZGBlocks.caligroGravel, ZGBlocks.exodusGravel);
		
		// Grass
		registerOre("grass", ZGBlocks.edenGoldenGrass, ZGBlocks.edenGrass, ZGBlocks.edenSwampGrass, ZGBlocks.edenFallGrass, ZGBlocks.xathGrass, ZGBlocks.oasisGrass,
				ZGBlocks.perdGrass, ZGBlocks.exodusGrass);
		
		// Logs
		registerOre("logWood", ZGBlocks.edenWoodLog, ZGBlocks.perdWoodLogs, ZGBlocks.edenParadiseWoodLog, ZGBlocks.edenGoldenWoodLog, ZGBlocks.edenLovetreeLog,
				ZGBlocks.exoWoodLogs);
		
		// Leaves
		registerOre("treeLeaves", ZGBlocks.edenWoodLeaves, ZGBlocks.perdWoodLeaves, ZGBlocks.edenParadiseWoodLeaves, ZGBlocks.edenGoldenWoodLeaves,
				ZGBlocks.edenLovetreeLeaves, ZGBlocks.exoWoodLeaves);
		
		// Saplings
		registerOre("treeSapling", ZGBlocks.edenWoodSapling, ZGBlocks.perdTreeSapling, ZGBlocks.edenParadiseWoodSapling, ZGBlocks.edenGoldenWoodSapling,
				ZGBlocks.edenLovetreeSapling, ZGBlocks.exoWoodSapling);
		
		// Planks
		registerOre("plankWood", ZGBlocks.edenWoodPlanks, ZGBlocks.perdWoodPlanks, ZGBlocks.edenParadiseWoodPlanks, ZGBlocks.edenGoldenWoodPlanks,
				ZGBlocks.edenLovetreePlanks, ZGBlocks.exoWoodPlanks);
		
		// Stone
		registerOre("stone", ZGBlocks.edenStone, ZGBlocks.kriffStone, ZGBlocks.purgStone, ZGBlocks.zolStone, ZGBlocks.xathStone, ZGBlocks.oasisStone,
				ZGBlocks.xantheonStone, ZGBlocks.atheonStone, ZGBlocks.perdStone, ZGBlocks.perdCreepStone, ZGBlocks.perdCaveStone, ZGBlocks.altumStone,
				ZGBlocks.caligroStone, ZGBlocks.caligroCreepstone, ZGBlocks.corruptStone, ZGBlocks.corruptCreepstone, ZGBlocks.exodusStone);
		
		// Stone Bricks
		registerOre("stonebrick", ZGBlocks.edenRockBricks, ZGBlocks.kriffRockBricks, ZGBlocks.purgRockBricks, ZGBlocks.zolRockBricks, ZGBlocks.xathRockBricks,
				ZGBlocks.oasisRockBricks, ZGBlocks.blockShinestoneCrystalBricks, ZGBlocks.atheonRockBricks, ZGBlocks.perdRockBricks, ZGBlocks.perdCaveStoneBricks,
				ZGBlocks.caligroStoneBricks, ZGBlocks.corruptStoneBricks);
		
		// Glowstone
		registerOre("glowstone", ZGBlocks.edenBrightStone, ZGBlocks.blockShinestone, ZGBlocks.perdGlowstone);
		
		// Sand
		registerOre("sand", ZGBlocks.edenBloodSand, ZGBlocks.perdSand, ZGBlocks.altumSand, ZGBlocks.exodusSand);
		
		// Cobblestone
		registerOre("cobblestone", ZGBlocks.edenCobbleRock, ZGBlocks.kriffCobbleRock, ZGBlocks.purgCobbleRock, ZGBlocks.zolCobbleRock, ZGBlocks.xathCobble,
				ZGBlocks.oasisCobble, ZGBlocks.atheonCobble, ZGBlocks.perdCobble, ZGBlocks.altumCobble, ZGBlocks.caligroCobblestone,
				ZGBlocks.caligroCobblestoneMossy, ZGBlocks.corruptCobble, ZGBlocks.exodusCobblestone);
		
		// Coal
		registerOre("oreCoal", ZGBlocks.edenCoalOre, ZGBlocks.kriffCoalOre, ZGBlocks.zolCoalOre, ZGBlocks.oasisCoalOre, ZGBlocks.xantheonCoalOre,
				ZGBlocks.altumCoalOre);
		
		// Iron
		registerOre("oreIron", ZGBlocks.edenIronOre, ZGBlocks.kriffIronOre, ZGBlocks.purgIronOre, ZGBlocks.zolIronOre, ZGBlocks.xathIronOre, ZGBlocks.oasisIronOre,
				ZGBlocks.xantheonIronOre, ZGBlocks.perdIronOre, ZGBlocks.altumIronOre, ZGBlocks.caligroIronOre, ZGBlocks.exodusIronOre);
		
		// Gold
		registerOre("oreGold", ZGBlocks.edenGoldOre, ZGBlocks.kriffGoldOre, ZGBlocks.purgGoldOre, ZGBlocks.zolGoldOre, ZGBlocks.xathGoldOre, ZGBlocks.oasisGoldOre,
				ZGBlocks.perdGoldOre, ZGBlocks.altumGoldOre, ZGBlocks.caligroGoldOre, ZGBlocks.exodusGoldOre);
		
		// Nickel
		registerOre("oreNickel", ZGBlocks.edenNickelOre, ZGBlocks.xantheonNickelOre, ZGBlocks.caligroNickelOre);
		
		// Diamond
		registerOre("oreDiamond", ZGBlocks.edenDiamondOre, ZGBlocks.purgDiamondOre, ZGBlocks.xathDiamondOre, ZGBlocks.oasisDiamondOre, ZGBlocks.atheonDiamondOre,
				ZGBlocks.perdDiamondOre, ZGBlocks.altumDiamondOre, ZGBlocks.caligroDiamondOre, ZGBlocks.exodusDiamondOre);
		registerOre("dustDiamond", ZGItems.dustDiamond);
		
		// Emerald
		registerOre("oreEmerald", ZGBlocks.edenEmeraldOre, ZGBlocks.purgEmeraldOre, ZGBlocks.xathEmeraldOre, ZGBlocks.caligroEmeraldOre);
		registerOre("dustEmerald", ZGItems.dustEmerald);
		
		// Redstone
		registerOre("oreRedstone", ZGBlocks.edenRedstoneOre, ZGBlocks.kriffRedstoneOre, ZGBlocks.purgRedstoneOre, ZGBlocks.xathRedstoneOre,
				ZGBlocks.oasisRedstoneOre, ZGBlocks.atheonRedstoneOre, ZGBlocks.altumRedstoneOre, ZGBlocks.caligroRedstoneOre, ZGBlocks.exodusRedstoneOre);
		
		// Steel
		registerOre("oreSteel", ZGBlocks.edenSteelOre);
		
		// Platinum
		registerOre("orePlatinum", ZGBlocks.edenPlatinumOre, ZGBlocks.caligroShiniumOre);
		registerOre("dustPlatinum", ZGItems.dustShinium);
		registerOre("ingotPlatinum", ZGItems.ingotShinium);
		registerOre("blockPlatinum", ZGBlocks.blockShinium);
		
		// Shinium
		registerOre("dustShinium", ZGItems.dustShinium);
		registerOre("ingotShinium", ZGItems.ingotShinium);
		registerOre("oreShinium", ZGBlocks.caligroShiniumOre);
		registerOre("blockShinium", ZGBlocks.blockShinium);
		
		// Chargium
		registerOre("dustChargium", ZGItems.dustChargium);
		registerOre("ingotChargium", ZGItems.ingotChargium);
		registerOre("oreChargium", ZGBlocks.corruptChargiumOre);
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
		registerOre("oreEtrium", ZGBlocks.perdEtriumOre, ZGBlocks.corruptEtriumOre);
		registerOre("blockEtrium", ZGBlocks.blockPerdEtrium);
		registerOre("ingotEtrium", ZGItems.ingotEtrium);
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
		registerOre("oreEvenium", ZGBlocks.edenEveniumOre, ZGBlocks.purgEveniumOre, ZGBlocks.altumEveniumOre);
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
		registerOre("oreAmaranth", ZGBlocks.xantheonAmaranthOre, ZGBlocks.atheonAmaranthOre, ZGBlocks.altumAmaranthOre, ZGBlocks.caligroAmaranthOre);
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
		registerOre("oreZollernium", ZGBlocks.atheonZollerniumOre, ZGBlocks.perdZollerniumOre, ZGBlocks.altumZollerniumOre);
		registerOre("dustZollernium", ZGItems.dustZollernium);
		registerOre("ingotZollernium", ZGItems.ingotZollernium);
		registerOre("blockZollernium", ZGBlocks.blockZollernium);
		registerOre("pickaxeZollernium", ZGItems.pickaxeZollernium);
		registerOre("shovelZollernium", ZGItems.shovelZollernium);
		registerOre("axeZollernium", ZGItems.axeZollernium);
		registerOre("hoeZollernium", ZGItems.hoeZollernium);
		registerOre("swordZollernium", ZGItems.swordZollernium);
		
		// Zinc
		registerOre("oreZinc", ZGBlocks.atheonZincOre, ZGBlocks.caligroZincOre);
		registerOre("dustZinc", ZGItems.dustZinc);
		registerOre("ingotZinc", ZGItems.ingotZinc);
		registerOre("blockZinc", ZGBlocks.blockZinc);
		
		// Promethean
		registerOre("orePromethean", ZGBlocks.xathPrometheanOre);
		registerOre("gemPromethean", ZGItems.prometheanCrystal);
		registerOre("blockPromethean", ZGBlocks.blockPromethean);
		
		// Super Charged Coal
		registerOre("oreSuperChargedCoal", ZGBlocks.oasisSuperChargedCoalOre, ZGBlocks.caligroSuperChargedCoalOre);
		registerOre("gemSuperChargedCoal", ZGItems.superChargedCoal);
		registerOre("blockSuperChargedCoal", ZGBlocks.blockSuperChargedCoal);
		
		// Uranium
		if (ConfigManagerZG.fueltoniumIsUranium) {
			registerOre("oreUranium", ZGBlocks.xantheonFueltoniumOre, ZGBlocks.perdFueltoniumOre, ZGBlocks.caligroFueltoniumOre);
			registerOre("ingotUranium", ZGItems.ingotFueltonium);
			registerOre("dustUranium", ZGItems.dustFueltonium);
			registerOre("blockUranium", ZGBlocks.blockFueltonium);
		}
		
		// Fueltonium
		registerOre("oreFueltonium", ZGBlocks.xantheonFueltoniumOre, ZGBlocks.perdFueltoniumOre, ZGBlocks.caligroFueltoniumOre);
		registerOre("ingotFueltonium", ZGItems.ingotFueltonium);
		registerOre("dustFueltonium", ZGItems.dustFueltonium);
		registerOre("blockFueltonium", ZGBlocks.blockFueltonium);
		
		// Plutonium
		registerOre("orePlutonium", ZGBlocks.xantheonPlutoniumOre);
		registerOre("gemPlutonium", ZGItems.plutoniumCrystal);
		registerOre("blockPlutonium", ZGBlocks.blockPlutonium);
		
		// Zucrite
		registerOre("blockZucrite", ZGBlocks.blockZucrite);
		registerOre("ingotZucrite", ZGItems.ingotZucrite);
		registerOre("dustZucrite", ZGItems.dustZucrite);
		
		// Rhodium
		registerOre("blockRhodium", ZGBlocks.blockRhodium);
		registerOre("ingotRhodium", ZGItems.ingotRhodium);
		registerOre("dustRhodium", ZGItems.dustRhodium);
		
		// Blazerock
		registerOre("blockBlazePowder", ZGBlocks.kriffBlazeRock);
		registerOre("gemBlazePowder", Items.BLAZE_POWDER);
		
		// Perdita Glowstone
		registerOre("blockLostGlowstone", ZGBlocks.perdGlowstone);
		registerOre("dustLostGlowstone", ZGItems.perdGlowdust);
		
		// Cactus
		registerOre("blockCactus", ZGBlocks.perdCactus);
		
		// Reeds
		registerOre("reeds", ZGBlocks.perdReeds);
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