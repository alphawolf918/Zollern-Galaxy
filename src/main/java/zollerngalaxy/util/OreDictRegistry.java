/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;

public class OreDictRegistry {
	
	public static void init() {
		// Amber
		registerOre("blockAmber", ZGBlocks.blockAmber);
		registerOre("oreAmber", ZGBlocks.caligroAmberOre, ZGBlocks.harranAmberOre);
		registerOre("gemAmber", ZGItems.amber);
		
		// Topaz
		registerOre("blockTopaz", ZGBlocks.blockTopaz);
		registerOre("oreTopaz", ZGBlocks.caligroTopazOre, ZGBlocks.harranTopazOre);
		registerOre("gemTopaz", ZGItems.topaz);
		
		// Opal
		registerOre("blockOpal", ZGBlocks.blockOpal);
		registerOre("oreOpal", ZGBlocks.caligroOpalOre, ZGBlocks.harranOpalOre);
		registerOre("gemOpal", ZGItems.opal);
		
		// Aquamarine
		registerOre("blockAquamarine", ZGBlocks.blockAquamarine);
		registerOre("oreAquamarine", ZGBlocks.caligroAquamarineOre, ZGBlocks.harranAquamarineOre);
		registerOre("gemAquamarine", ZGItems.aquamarine);
		
		// Garnet
		registerOre("blockGarnet", ZGBlocks.blockGarnet);
		registerOre("oreGarnet", ZGBlocks.caligroGarnetOre, ZGBlocks.harranGarnetOre);
		registerOre("gemGarnet", ZGItems.garnet);
		
		// Ruby
		registerOre("blockRuby", ZGBlocks.blockRuby);
		registerOre("oreRuby", ZGBlocks.caligroRubyOre, ZGBlocks.harranRubyOre, ZGBlocks.netherRubyOre);
		registerOre("gemRuby", ZGItems.ruby);
		registerOre("pickaxeRuby", ZGItems.pickaxeRuby);
		registerOre("shovelRuby", ZGItems.shovelRuby);
		registerOre("hoeRuby", ZGItems.hoeRuby);
		registerOre("axeRuby", ZGItems.axeRuby);
		registerOre("swordRuby", ZGItems.swordRuby);
		
		// Sapphire
		registerOre("blockSapphire", ZGBlocks.blockSapphire);
		registerOre("oreSapphire", ZGBlocks.astrosSapphireOre, ZGBlocks.harranSapphireOre, ZGBlocks.netherSapphireOre);
		registerOre("gemSapphire", ZGItems.sapphire);
		registerOre("pickaxeSapphire", ZGItems.pickaxeSapphire);
		registerOre("shovelSapphire", ZGItems.shovelSapphire);
		registerOre("hoeSapphire", ZGItems.hoeSapphire);
		registerOre("axeSapphire", ZGItems.axeSapphire);
		registerOre("swordSapphire", ZGItems.swordSapphire);
		
		// Static Amber
		registerOre("blockAmberStatic", ZGBlocks.blockAmberStatic);
		registerOre("gemAmberStatic", ZGItems.amberStatic);
		
		// Icy Aquamarine
		registerOre("blockAquamarineIcy", ZGBlocks.blockAquamarineIcy);
		registerOre("gemAquamarineIcy", ZGItems.aquamarineIcy);
		
		// Garnet
		registerOre("blockGarnetFire", ZGBlocks.blockGarnetFire);
		registerOre("gemGarnetFire", ZGItems.garnetFire);
		
		// Quartz
		registerOre("oreQuartz", ZGBlocks.tociQuartzOre, ZGBlocks.tlalocQuartzOre);
		
		// Certus Quartz
		registerOre("oreCertusQuartz", ZGBlocks.tlalocCertusQuartzOre);
		
		// Fluix
		registerOre("oreFluix", ZGBlocks.tlalocFluixOre);
		
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
		registerOre("fluidRadium", ZGFluids.blockRadiumFluid);
		registerOre("gemRadium", ZGItems.radium);
		registerOre("ingotRadium", ZGItems.ingotRadium);
		
		// Ascendium
		registerOre("oreAscendium", ZGBlocks.corruptAscendiumOre);
		registerOre("gemAscendium", ZGItems.ascendium);
		
		// Copper
		registerOre("oreCopper", ZGBlocks.edenCopperOre, ZGBlocks.kriffCopperOre, ZGBlocks.purgCopperOre, ZGBlocks.zolCopperOre, ZGBlocks.xantheonCopperOre, ZGBlocks.caligroCopperOre, ZGBlocks.exodusCopperOre, ZGBlocks.vortexCopperOre, ZGBlocks.tociCopperOre, ZGBlocks.netherCopperOre);
		
		// Tin
		registerOre("oreTin", ZGBlocks.edenTinOre, ZGBlocks.purgTinOre, ZGBlocks.zolTinOre, ZGBlocks.xathTinOre, ZGBlocks.oasisTinOre, ZGBlocks.atheonTinOre, ZGBlocks.caligroTinOre, ZGBlocks.astrosTinOre, ZGBlocks.tociTinOre, ZGBlocks.netherTinOre);
		
		// Lead
		registerOre("oreLead", ZGBlocks.edenLeadOre, ZGBlocks.purgLeadOre, ZGBlocks.oasisLeadOre, ZGBlocks.caligroLeadOre, ZGBlocks.tociLeadOre, ZGBlocks.netherLeadOre);
		
		// Silver
		registerOre("oreSilver", ZGBlocks.edenSilverOre, ZGBlocks.caligroSilverOre, ZGBlocks.tociSilverOre, ZGBlocks.netherSilverOre);
		
		// Lapis
		registerOre("oreLapis", ZGBlocks.edenLapisOre, ZGBlocks.caligroLapisOre, ZGBlocks.netherLapisOre);
		registerOre("ingotLapis", ZGItems.ingotLapis);
		
		// Dirt
		registerOre("dirt", ZGBlocks.edenSoil, ZGBlocks.kriffDirt, ZGBlocks.purgDirt, ZGBlocks.zolDirt, ZGBlocks.xathDirt, ZGBlocks.oasisDirt, ZGBlocks.perdCreepDirt, ZGBlocks.perdSoil, ZGBlocks.altumDirt, ZGBlocks.caligroDirt, ZGBlocks.caligroCreepdirt, ZGBlocks.exodusDirt, ZGBlocks.astrosDirt, ZGBlocks.centoDirt, ZGBlocks.tociDirt, ZGBlocks.harranSoil, ZGBlocks.netherDirt,
				ZGBlocks.mavethInfectedSoil);
		
		// Constructed
		registerOre("blockConstructed", ZGBlocks.xantheonConstructBlock, ZGBlocks.atheonConstructBlock);
		
		// Space Station
		registerOre("blockSpaceStation", ZGBlocks.blockSpaceStation);
		
		// Gravel
		registerOre("gravel", ZGBlocks.zolGravel, ZGBlocks.edenGravel, ZGBlocks.purgGravel, ZGBlocks.xathGravel, ZGBlocks.oasisGravel, ZGBlocks.perdGravel, ZGBlocks.altumGravel, ZGBlocks.caligroGravel, ZGBlocks.exodusGravel, ZGBlocks.astrosGravel, ZGBlocks.centoGravel, ZGBlocks.mavethGravel);
		
		// Grass
		registerOre("grass", ZGBlocks.edenGoldenGrass, ZGBlocks.edenGrass, ZGBlocks.edenSwampGrass, ZGBlocks.edenFallGrass, ZGBlocks.xathGrass, ZGBlocks.oasisGrass, ZGBlocks.perdGrass, ZGBlocks.exodusGrass, ZGBlocks.harranGrassCherry, ZGBlocks.harranGrass, ZGBlocks.mavethInfectedGrass);
		
		// Ice
		registerOre("ice", ZGBlocks.astrosIce, ZGBlocks.zolIce);
		
		// Logs
		registerOre("logWood", ZGBlocks.edenWoodLog, ZGBlocks.perdWoodLogs, ZGBlocks.edenParadiseWoodLog, ZGBlocks.edenGoldenWoodLog, ZGBlocks.edenLovetreeLog, ZGBlocks.exoWoodLogs, ZGBlocks.cherryWoodLog, ZGBlocks.bananaLog, ZGBlocks.guavaLog, ZGBlocks.peachLog, ZGBlocks.grapefruitLog, ZGBlocks.orangeLog, ZGBlocks.lemonLog, ZGBlocks.limeLog, ZGBlocks.limonLog,
				ZGBlocks.xathWoodLog);
		
		// Planks
		registerOre("plankWood", ZGBlocks.edenWoodPlanks, ZGBlocks.perdWoodPlanks, ZGBlocks.edenParadiseWoodPlanks, ZGBlocks.edenGoldenWoodPlanks, ZGBlocks.edenLovetreePlanks, ZGBlocks.exoWoodPlanks, ZGBlocks.cherryWoodPlanks, ZGBlocks.bananaPlanks, ZGBlocks.guavaPlanks, ZGBlocks.peachPlanks, ZGBlocks.grapefruitPlanks, ZGBlocks.orangePlanks, ZGBlocks.lemonPlanks,
				ZGBlocks.limePlanks, ZGBlocks.limonPlanks, ZGBlocks.xathPlanks);
		
		// Leaves
		registerOre("treeLeaves", ZGBlocks.edenWoodLeaves, ZGBlocks.perdWoodLeaves, ZGBlocks.edenParadiseWoodLeaves, ZGBlocks.edenGoldenWoodLeaves, ZGBlocks.edenLovetreeLeaves, ZGBlocks.exoWoodLeaves, ZGBlocks.cherryWoodLeaves, ZGBlocks.bananaLeaves, ZGBlocks.guavaLeaves, ZGBlocks.peachLeaves, ZGBlocks.grapefruitLeaves, ZGBlocks.orangeLeaves, ZGBlocks.lemonLeaves,
				ZGBlocks.limeLeaves, ZGBlocks.limonLeaves, ZGBlocks.xathWoodLeaves);
		
		// Saplings
		registerOre("treeSapling", ZGBlocks.edenWoodSapling, ZGBlocks.perdTreeSapling, ZGBlocks.edenParadiseWoodSapling, ZGBlocks.edenGoldenWoodSapling, ZGBlocks.edenLovetreeSapling, ZGBlocks.exoWoodSapling, ZGBlocks.cherryWoodSapling, ZGBlocks.bananaSapling, ZGBlocks.guavaSapling, ZGBlocks.peachSapling, ZGBlocks.grapefruitSapling, ZGBlocks.orangeSapling, ZGBlocks.lemonSapling,
				ZGBlocks.limeSapling, ZGBlocks.limonSapling, ZGBlocks.xathWoodSapling);
		
		// Stone
		registerOre("stone", ZGBlocks.edenStone, ZGBlocks.kriffStone, ZGBlocks.purgStone, ZGBlocks.zolStone, ZGBlocks.xathStone, ZGBlocks.oasisStone, ZGBlocks.xantheonStone, ZGBlocks.atheonStone, ZGBlocks.perdStone, ZGBlocks.perdCreepStone, ZGBlocks.perdCaveStone, ZGBlocks.altumStone, ZGBlocks.caligroStone, ZGBlocks.caligroCreepstone, ZGBlocks.corruptStone,
				ZGBlocks.corruptCreepstone, ZGBlocks.exodusStone, ZGBlocks.vortexStone, ZGBlocks.astrosStone, ZGBlocks.centoStone, ZGBlocks.tociStone, ZGBlocks.tlalocStone, ZGBlocks.mavethStone);
		
		// Stone Bricks
		registerOre("stonebrick", ZGBlocks.edenRockBricks, ZGBlocks.kriffRockBricks, ZGBlocks.purgRockBricks, ZGBlocks.zolRockBricks, ZGBlocks.xathRockBricks, ZGBlocks.oasisRockBricks, ZGBlocks.blockShinestoneCrystalBricks, ZGBlocks.atheonRockBricks, ZGBlocks.perdRockBricks, ZGBlocks.perdCaveStoneBricks, ZGBlocks.caligroStoneBricks, ZGBlocks.corruptStoneBricks,
				ZGBlocks.tociStoneBricks, ZGBlocks.mavethStoneBricks);
		
		// Glowstone
		registerOre("glowstone", ZGBlocks.edenBrightStone, ZGBlocks.blockShinestone, ZGBlocks.perdGlowstone);
		
		// Sand
		registerOre("sand", ZGBlocks.edenBloodSand, ZGBlocks.perdSand, ZGBlocks.altumSand, ZGBlocks.exodusSand, ZGBlocks.tociSand, ZGBlocks.tociStarSand, ZGBlocks.oasisSand);
		
		// Cobblestone
		registerOre("cobblestone", ZGBlocks.edenCobbleRock, ZGBlocks.kriffCobbleRock, ZGBlocks.purgCobbleRock, ZGBlocks.zolCobbleRock, ZGBlocks.xathCobble, ZGBlocks.oasisCobble, ZGBlocks.atheonCobble, ZGBlocks.perdCobble, ZGBlocks.altumCobble, ZGBlocks.caligroCobblestone, ZGBlocks.caligroCobblestoneMossy, ZGBlocks.corruptCobble, ZGBlocks.exodusCobblestone,
				ZGBlocks.vortexCobblestone, ZGBlocks.astrosCobblestone, ZGBlocks.centoCobblestone, ZGBlocks.tociCobblestone, ZGBlocks.tociMossyCobblestone, ZGBlocks.mavethCobblestone);
		
		// Obsidian
		registerOre("dustObsidian", ZGItems.dustObsidian);
		registerOre("ingotObsidian", ZGItems.ingotObsidian);
		registerOre("blockObsidian", Blocks.OBSIDIAN);
		
		// Coal
		registerOre("oreCoal", ZGBlocks.edenCoalOre, ZGBlocks.kriffCoalOre, ZGBlocks.zolCoalOre, ZGBlocks.oasisCoalOre, ZGBlocks.xantheonCoalOre, ZGBlocks.altumCoalOre, ZGBlocks.astrosCoalOre, ZGBlocks.tociCoalOre, ZGBlocks.netherCoalOre);
		registerOre("coal", ZGItems.superChargedCoal);
		
		// Iron
		registerOre("oreIron", ZGBlocks.edenIronOre, ZGBlocks.kriffIronOre, ZGBlocks.purgIronOre, ZGBlocks.zolIronOre, ZGBlocks.xathIronOre, ZGBlocks.oasisIronOre, ZGBlocks.xantheonIronOre, ZGBlocks.perdIronOre, ZGBlocks.altumIronOre, ZGBlocks.caligroIronOre, ZGBlocks.exodusIronOre, ZGBlocks.vortexIronOre, ZGBlocks.astrosIronOre, ZGBlocks.centoIronOre, ZGBlocks.tociIronOre,
				ZGBlocks.netherIronOre, ZGBlocks.mavethIronOre);
		
		// Gold
		registerOre("oreGold", ZGBlocks.edenGoldOre, ZGBlocks.kriffGoldOre, ZGBlocks.purgGoldOre, ZGBlocks.zolGoldOre, ZGBlocks.xathGoldOre, ZGBlocks.oasisGoldOre, ZGBlocks.perdGoldOre, ZGBlocks.altumGoldOre, ZGBlocks.caligroGoldOre, ZGBlocks.exodusGoldOre, ZGBlocks.vortexGoldOre, ZGBlocks.astrosGoldOre, ZGBlocks.centoGoldOre, ZGBlocks.tociGoldOre, ZGBlocks.netherGoldOre);
		
		// Nickel
		registerOre("oreNickel", ZGBlocks.edenNickelOre, ZGBlocks.xantheonNickelOre, ZGBlocks.caligroNickelOre, ZGBlocks.tociNickelOre, ZGBlocks.netherNickleOre);
		
		// Diamond
		registerOre("oreDiamond", ZGBlocks.edenDiamondOre, ZGBlocks.purgDiamondOre, ZGBlocks.xathDiamondOre, ZGBlocks.oasisDiamondOre, ZGBlocks.atheonDiamondOre, ZGBlocks.perdDiamondOre, ZGBlocks.altumDiamondOre, ZGBlocks.caligroDiamondOre, ZGBlocks.exodusDiamondOre, ZGBlocks.vortexDiamondOre, ZGBlocks.astrosDiamondOre, ZGBlocks.tociDiamondOre, ZGBlocks.netherDiamondOre);
		registerOre("dustDiamond", ZGItems.dustDiamond);
		
		// Emerald
		registerOre("oreEmerald", ZGBlocks.edenEmeraldOre, ZGBlocks.purgEmeraldOre, ZGBlocks.xathEmeraldOre, ZGBlocks.caligroEmeraldOre, ZGBlocks.astrosEmeraldOre, ZGBlocks.tociEmeraldOre, ZGBlocks.netherEmeraldOre);
		registerOre("dustEmerald", ZGItems.dustEmerald);
		
		// Redstone
		registerOre("oreRedstone", ZGBlocks.edenRedstoneOre, ZGBlocks.kriffRedstoneOre, ZGBlocks.purgRedstoneOre, ZGBlocks.xathRedstoneOre, ZGBlocks.oasisRedstoneOre, ZGBlocks.atheonRedstoneOre, ZGBlocks.altumRedstoneOre, ZGBlocks.caligroRedstoneOre, ZGBlocks.exodusRedstoneOre, ZGBlocks.vortexRedstoneOre, ZGBlocks.astrosRedstoneOre, ZGBlocks.tociRedstoneOre,
				ZGBlocks.tlalocRedstoneOre, ZGBlocks.netherRedstoneOre);
		
		// Steel
		registerOre("oreSteel", ZGBlocks.edenSteelOre, ZGBlocks.netherSteelOre);
		
		// Platinum
		registerOre("orePlatinum", ZGBlocks.edenPlatinumOre, ZGBlocks.caligroShiniumOre, ZGBlocks.centoShiniumOre, ZGBlocks.tlalocShiniumOre, ZGBlocks.netherShiniumOre);
		registerOre("dustPlatinum", ZGItems.dustShinium);
		registerOre("ingotPlatinum", ZGItems.ingotShinium);
		registerOre("blockPlatinum", ZGBlocks.blockShinium);
		
		// Shinium
		registerOre("dustShinium", ZGItems.dustShinium);
		registerOre("ingotShinium", ZGItems.ingotShinium);
		registerOre("oreShinium", ZGBlocks.caligroShiniumOre, ZGBlocks.centoShiniumOre, ZGBlocks.tlalocShiniumOre, ZGBlocks.netherShiniumOre);
		registerOre("blockShinium", ZGBlocks.blockShinium);
		
		// Chargium
		registerOre("oreChargium", ZGBlocks.corruptChargiumOre);
		registerOre("blockChargium", ZGBlocks.blockChargium);
		registerOre("fluidChargium", ZGFluids.blockChargiumFluid);
		registerOre("dustChargium", ZGItems.dustChargium);
		registerOre("ingotChargium", ZGItems.ingotChargium);
		
		// Shinestone
		registerOre("dustShinestone", ZGItems.dustShinestone);
		registerOre("ingotShinestone", ZGItems.ingotShinestone);
		registerOre("blockShinestone", ZGBlocks.blockShinestone);
		
		// Electrum
		registerOre("oreElectrum", ZGBlocks.edenElectrumOre, ZGBlocks.mavethElectrumOre);
		
		// Invar
		registerOre("oreInvar", ZGBlocks.edenInvarOre);
		
		// Bronze
		registerOre("oreBronze", ZGBlocks.edenBronzeOre, ZGBlocks.tociBronzeOre);
		
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
		registerOre("oreEvenium", ZGBlocks.edenEveniumOre, ZGBlocks.purgEveniumOre, ZGBlocks.altumEveniumOre, ZGBlocks.vortexEveniumOre);
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
		registerOre("oreAmaranth", ZGBlocks.xantheonAmaranthOre, ZGBlocks.atheonAmaranthOre, ZGBlocks.altumAmaranthOre, ZGBlocks.caligroAmaranthOre, ZGBlocks.tociAmaranthOre, ZGBlocks.harranAmaranthOre, ZGBlocks.netherAmaranthOre, ZGBlocks.mavethAmaranthOre);
		registerOre("dustAmaranth", ZGItems.dustAmaranth);
		registerOre("ingotAmaranth", ZGItems.ingotAmaranth);
		registerOre("blockAmaranth", ZGBlocks.blockAmaranth);
		registerOre("pickaxeAmaranth", ZGItems.pickaxeAmaranth);
		registerOre("shovelAmaranth", ZGItems.shovelAmaranth);
		registerOre("axeAmaranth", ZGItems.axeAmaranth);
		registerOre("hoeAmaranth", ZGItems.hoeAmaranth);
		registerOre("swordAmaranth", ZGItems.swordAmaranth);
		
		// Azurite
		registerOre("oreAzurite", ZGBlocks.xathAzuriteOre, ZGBlocks.azuriteOre);
		registerOre("gemAzurite", ZGItems.azurite);
		registerOre("blockAzurite", ZGBlocks.blockAzurite);
		registerOre("pickaxeAzurite", ZGItems.pickaxeAzurite);
		registerOre("shovelAzurite", ZGItems.shovelAzurite);
		registerOre("axeAzurite", ZGItems.axeAzurite);
		registerOre("hoeAzurite", ZGItems.hoeAzurite);
		registerOre("swordAzurite", ZGItems.swordAzurite);
		
		// Zollernium
		registerOre("oreZollernium", ZGBlocks.atheonZollerniumOre, ZGBlocks.perdZollerniumOre, ZGBlocks.altumZollerniumOre, ZGBlocks.astrosZollerniumOre, ZGBlocks.centoZollerniumOre, ZGBlocks.tlalocZollerniumOre, ZGBlocks.mavethZollerniumOre);
		registerOre("dustZollernium", ZGItems.dustZollernium);
		registerOre("ingotZollernium", ZGItems.ingotZollernium);
		registerOre("blockZollernium", ZGBlocks.blockZollernium);
		registerOre("pickaxeZollernium", ZGItems.pickaxeZollernium);
		registerOre("shovelZollernium", ZGItems.shovelZollernium);
		registerOre("axeZollernium", ZGItems.axeZollernium);
		registerOre("hoeZollernium", ZGItems.hoeZollernium);
		registerOre("swordZollernium", ZGItems.swordZollernium);
		
		// Zinc
		if (ConfigManagerZG.registerZincOreDict) {
			registerOre("oreZinc", ZGBlocks.atheonZincOre, ZGBlocks.caligroZincOre, ZGBlocks.tociZincOre, ZGBlocks.harranZincOre, ZGBlocks.netherZincOre);
			registerOre("dustZinc", ZGItems.dustZinc);
			registerOre("ingotZinc", ZGItems.ingotZinc);
			registerOre("blockZinc", ZGBlocks.blockZinc);
		} else {
			registerOre("oreZincium", ZGBlocks.atheonZincOre, ZGBlocks.caligroZincOre, ZGBlocks.tociZincOre, ZGBlocks.harranZincOre, ZGBlocks.netherZincOre);
			registerOre("dustZincium", ZGItems.dustZinc);
			registerOre("ingotZincium", ZGItems.ingotZinc);
			registerOre("blockZincium", ZGBlocks.blockZinc);
		}
		
		// Promethean
		registerOre("orePromethean", ZGBlocks.xathPrometheanOre);
		registerOre("gemPromethean", ZGItems.prometheanCrystal);
		registerOre("blockPromethean", ZGBlocks.blockPromethean);
		
		// Super Charged Coal
		registerOre("oreSuperChargedCoal", ZGBlocks.oasisSuperChargedCoalOre, ZGBlocks.caligroSuperChargedCoalOre, ZGBlocks.vortexSuperChargedCoalOre, ZGBlocks.astrosSuperChargedCoalOre, ZGBlocks.tociSuperChargedCoalOre, ZGBlocks.tlalocSuperChargedCoalOre, ZGBlocks.harranSuperChargedCoalOre, ZGBlocks.netherSuperChargedCoalOre);
		registerOre("gemSuperChargedCoal", ZGItems.superChargedCoal);
		registerOre("blockSuperChargedCoal", ZGBlocks.blockSuperChargedCoal);
		
		// Uranium
		if (ConfigManagerZG.fueltoniumIsUranium) {
			registerOre("oreUranium", ZGBlocks.xantheonFueltoniumOre, ZGBlocks.perdFueltoniumOre, ZGBlocks.caligroFueltoniumOre, ZGBlocks.vortexFueltoniumOre, ZGBlocks.centoFueltoniumOre, ZGBlocks.tociFueltoniumOre, ZGBlocks.tlalocFueltoniumOre, ZGBlocks.harranFueltoniumOre, ZGBlocks.netherFueltoniumOre);
			registerOre("ingotUranium", ZGItems.ingotFueltonium);
			registerOre("dustUranium", ZGItems.dustFueltonium);
			registerOre("blockUranium", ZGBlocks.blockFueltonium);
			registerOre("fluidUranium", ZGFluids.blockFueltoniumFluid);
		}
		
		// Fueltonium
		registerOre("oreFueltonium", ZGBlocks.xantheonFueltoniumOre, ZGBlocks.perdFueltoniumOre, ZGBlocks.caligroFueltoniumOre, ZGBlocks.vortexFueltoniumOre, ZGBlocks.centoFueltoniumOre, ZGBlocks.tociFueltoniumOre, ZGBlocks.tlalocFueltoniumOre, ZGBlocks.harranFueltoniumOre, ZGBlocks.netherFueltoniumOre);
		registerOre("ingotFueltonium", ZGItems.ingotFueltonium);
		registerOre("dustFueltonium", ZGItems.dustFueltonium);
		registerOre("blockFueltonium", ZGBlocks.blockFueltonium);
		registerOre("fluidFueltonium", ZGFluids.blockFueltoniumFluid);
		
		// Plutonium
		registerOre("orePlutonium", ZGBlocks.xantheonPlutoniumOre, ZGBlocks.tlalocPlutoniumOre);
		registerOre("gemPlutonium", ZGItems.plutoniumCrystal);
		registerOre("ingotPlutonium", ZGItems.ingotPlutonium);
		registerOre("dustPlutonium", ZGItems.dustPlutonium);
		registerOre("blockPlutonium", ZGBlocks.blockPlutonium);
		
		// Zucrite
		registerOre("blockZucrite", ZGBlocks.blockZucrite);
		registerOre("ingotZucrite", ZGItems.ingotZucrite);
		registerOre("dustZucrite", ZGItems.dustZucrite);
		
		// Rhodium
		registerOre("blockRhodium", ZGBlocks.blockRhodium);
		registerOre("ingotRhodium", ZGItems.ingotRhodium);
		registerOre("dustRhodium", ZGItems.dustRhodium);
		
		// Zanium
		registerOre("oreZanium", ZGBlocks.netherZaniumOre);
		registerOre("blockZanium", ZGBlocks.blockZanium);
		registerOre("gemZanium", ZGItems.zanium);
		registerOre("pickaxeZanium", ZGItems.pickaxeZanium);
		registerOre("shovelZanium", ZGItems.shovelZanium);
		registerOre("hoeZanium", ZGItems.hoeZanium);
		registerOre("axeZanium", ZGItems.axeZanium);
		registerOre("swordZanium", ZGItems.swordZanium);
		
		// Radite
		registerOre("oreRadite", ZGBlocks.netherRaditeOre);
		registerOre("blockRadite", ZGBlocks.blockRadite);
		registerOre("fluidRadite", ZGFluids.blockFluidRadite);
		registerOre("ingotRadite", ZGItems.ingotRadite);
		registerOre("dustRadite", ZGItems.dustRadite);
		
		// Zogite
		registerOre("oreZogite", ZGBlocks.netherZogiteOre);
		registerOre("blockZogite", ZGBlocks.blockZogite);
		registerOre("ingotZogite", ZGItems.ingotZogite);
		registerOre("dustZogite", ZGItems.dustZogite);
		
		// Zogradite
		registerOre("blockZogradite", ZGBlocks.blockZogradite);
		registerOre("ingotZogradite", ZGItems.ingotZogradite);
		registerOre("dustZogradite", ZGItems.dustZogradite);
		
		// Vibranium
		registerOre("oreVibranium", ZGBlocks.mavethVibraniumOre);
		registerOre("blockVibranium", ZGBlocks.blockVibranium);
		registerOre("ingotVibranium", ZGItems.ingotVibranium);
		registerOre("dustVibranium", ZGItems.dustVibranium);
		
		// Blazerock
		registerOre("blockBlazePowder", ZGBlocks.blazeRock);
		registerOre("gemBlazePowder", Items.BLAZE_POWDER);
		
		// Perdita Glowstone
		registerOre("blockLostGlowstone", ZGBlocks.perdGlowstone);
		registerOre("dustLostGlowstone", ZGItems.perdGlowdust);
		
		// Cactus
		registerOre("blockCactus", ZGBlocks.perdCactus);
		
		// Reeds
		registerOre("reeds", ZGBlocks.perdReeds);
		
		// Clay
		registerOre("blockClay", Blocks.CLAY, ZGBlocks.mudClayBlock);
		registerOre("clay", Items.CLAY_BALL, ZGItems.mudClayBall);
		
		// Crops (Farmable)
		registerOre("cropStrawberry", ZGItems.strawberry);
		registerOre("cropBlackberry", ZGItems.blackberry);
		registerOre("cropBlueberry", ZGItems.blueberry);
		registerOre("cropGrape", ZGItems.grape);
		registerOre("cropTomato", ZGItems.tomato);
		registerOre("cropCorn", ZGItems.corn);
		registerOre("cropRadish", ZGItems.radish);
		registerOre("cropOnion", ZGItems.onion);
		registerOre("cropPeas", ZGItems.peas);
		registerOre("cropPea", ZGItems.peas);
		registerOre("cropGarlic", ZGItems.garlic);
		registerOre("cropGhostPepper", ZGItems.ghostPepper);
		registerOre("cropPepper", ZGItems.ghostPepper);
		
		// Crops (Trees)
		registerOre("cropCherry", ZGItems.cherry);
		registerOre("cropBanana", ZGItems.banana);
		registerOre("cropGuava", ZGItems.guava);
		registerOre("cropPeach", ZGItems.peach);
		registerOre("cropGrapefruit", ZGItems.grapefruit);
		registerOre("cropOrange", ZGItems.orange);
		registerOre("cropLemon", ZGItems.lemon);
		registerOre("cropLime", ZGItems.lime);
		registerOre("cropLimon", ZGItems.limon);
		
		// Food (listAll)
		registerOre("listAllIceCream", ZGItems.iceCream);
		
		// Other Fluids
		registerOre("fluidSpaceMilk", ZGFluids.blockSpaceMilk);
		registerOre("fluidWhiteLava", ZGFluids.blockWhiteLavaFluid);
		registerOre("fluidChocolate", ZGFluids.blockChocolateFluid);
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