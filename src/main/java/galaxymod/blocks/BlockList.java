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

package galaxymod.blocks;

import galaxymod.blocks.coreblocks.BlockHealingStation;
import galaxymod.blocks.eden.BlockEdenTreasureChest;
import galaxymod.blocks.eden.BlockEdenWoodLeaves;
import galaxymod.blocks.eden.BlockEdenWoodLog;
import galaxymod.blocks.eden.BlockEdenWoodSapling;
import galaxymod.blocks.eden.BlockEdenZollusPortal;
import galaxymod.blocks.eden.BlockWinterrock;
import galaxymod.blocks.eden.BloodSand;
import galaxymod.blocks.eden.EdenBritestone;
import galaxymod.blocks.eden.EdenFlower;
import galaxymod.blocks.eden.EdenGrass;
import galaxymod.blocks.eden.EdenGravel;
import galaxymod.blocks.eden.EdenMagmaRock;
import galaxymod.blocks.eden.EdenRock;
import galaxymod.blocks.eden.EdenSoil;
import galaxymod.blocks.eden.EdenSurfaceRock;
import galaxymod.blocks.eden.EdenTallGrass;
import galaxymod.blocks.eden.MultiBlockGlass;
import galaxymod.blocks.eden.SpaceFruitBlock;
import galaxymod.blocks.eden.ores.EdenCoalOre;
import galaxymod.blocks.eden.ores.EdenDeshOre;
import galaxymod.blocks.eden.ores.EdenDiamondOre;
import galaxymod.blocks.eden.ores.EdenEmeraldOre;
import galaxymod.blocks.eden.ores.EdenLapisOre;
import galaxymod.blocks.eden.ores.EdenMeteoricIronOre;
import galaxymod.blocks.eden.ores.EdenRedstoneOre;
import galaxymod.blocks.eden.ores.EdenViriniumOre;
import galaxymod.blocks.kriffus.BlockZollusKriffonPortal;
import galaxymod.blocks.kriffus.KriffStone;
import galaxymod.blocks.kriffus.ores.KriffCoalOre;
import galaxymod.blocks.kriffus.ores.KriffRedstoneOre;
import galaxymod.blocks.oasis.BlockPurgotOasisPortal;
import galaxymod.blocks.oasis.OasisGrass;
import galaxymod.blocks.oasis.OasisRock;
import galaxymod.blocks.oasis.OasisTallGrass;
import galaxymod.blocks.purgot.BlackRock;
import galaxymod.blocks.purgot.BlockKriffonPurgotPortal;
import galaxymod.blocks.purgot.PurgStone;
import galaxymod.blocks.purgot.WhiteRock;
import galaxymod.blocks.purgot.ores.PurgDiamondOre;
import galaxymod.blocks.purgot.ores.PurgEmeraldOre;
import galaxymod.blocks.xathius.XathiusGrass;
import galaxymod.blocks.xathius.ores.XathiusPrometheanOre;
import galaxymod.blocks.zollus.BlockZolniumCrystals;
import galaxymod.blocks.zollus.ZolStone;
import galaxymod.blocks.zollus.ZolarBlock;
import galaxymod.blocks.zollus.ores.ZolCoalOre;
import galaxymod.blocks.zollus.ores.ZolHeartiumOre;
import galaxymod.utils.NovaHelper;
import galaxymod.utils.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockList {
	
	static int totalBlocks = 0;
	
	public static final Block zolarBlock = new ZolarBlock();
	public static final Block zolCobbleRock = new BlockNova("zolcobblerock",
			Material.rock).setHardResist(1.0F, 6.5F);
	public static final Block zolstone = new ZolStone();
	public static final Block zolniumCrystals = new BlockZolniumCrystals();
	public static final Block zolCoalOre = new ZolCoalOre();
	public static final Block zolCopperOre = ((BlockNovaOre) new BlockNovaOre(
			"zolcopperore").setHardResist(1.2F)).setExpDrop(4, 6);
	public static final Block zolIronOre = ((BlockNovaOre) new BlockNovaOre(
			"zolironore").setHardResist(1.5F)).setExpDrop(1, 2);
	public static final Block zolGoldOre = ((BlockNovaOre) new BlockNovaOre(
			"zolgoldore").setHardResist(1.6F)).setExpDrop(3, 4);
	public static final Block zolTinOre = ((BlockNovaOre) new BlockNovaOre(
			"zoltinore").setHardResist(0.4F)).setExpDrop(2, 4);
	public static final Block zolHeartOre = new ZolHeartiumOre();
	public static final Block zolDirt = ((BlockNova) new BlockNova("zoldirt",
			Material.ground).setHardResist(0.6F))
			.setSoundType(Block.soundTypeGravel);
	public static final Block zolRockBricks = new BlockNova("zolrockbricks",
			Material.rock).setHardResist(0.9F, 9.8F);
	public static final Block edenZollusPortal = new BlockEdenZollusPortal();
	
	public static final Block edenCobbleRock = new BlockNova("edencobblerock",
			Material.rock).setHardResist(1.2F);
	public static final Block edenRock = new EdenRock();
	public static final Block edenRockBricks = new BlockNova("edenrockbricks",
			Material.rock).setHardResist(0.9F, 9.8F);
	public static final Block edenIronOre = ((BlockNovaOre) new BlockNovaOre(
			"edenironore").setHardResist(2.5F)).setExpDrop(2, 4);
	public static final Block edenCopperOre = new BlockNovaOre("edencopperore");
	public static final Block edenTinOre = new BlockNovaOre("edentinore");
	public static final Block edenMeteoricIronOre = new EdenMeteoricIronOre();
	public static final Block edenDiamondOre = new EdenDiamondOre();
	public static final Block edenEmeraldOre = new EdenEmeraldOre();
	public static final Block edenGoldOre = ((BlockNovaOre) new BlockNovaOre(
			"edengoldore").setHardResist(3.5F)).setExpDrop(3, 5);
	public static final Block edenCoalOre = new EdenCoalOre();
	public static final Block edenRedstoneOre = new EdenRedstoneOre();
	public static final Block edenLapisOre = new EdenLapisOre();
	public static final Block edenDeshOre = new EdenDeshOre();
	public static final Block edenAluminumOre = new BlockNovaOre(
			"edenaluminumore").setHardResist(3.0F, 6.0F);
	public static final Block edenViriOre = new EdenViriniumOre();
	public static final Block edenSoil = new EdenSoil();
	public static final Block edenSurfaceRock = new EdenSurfaceRock();
	public static final Block edenFlower = new EdenFlower("");
	public static final Block edenFlowerBlue = new EdenFlower("blue");
	public static final Block edenFlowerRed = new EdenFlower("red");
	public static final Block edenFlowerOrange = new EdenFlower("orange");
	public static final Block edenFlowerYellow = new EdenFlower("yellow");
	public static final Block edenFlowerPurple = new EdenFlower("purple");
	public static final Block edenFlowerCyan = new EdenFlower("cyan");
	public static final Block edenFlowerGreen = new EdenFlower("green");
	public static final Block edenGrass = new EdenGrass();
	public static final Block edenTallGrass = new EdenTallGrass();
	public static final Block edenBloodSand = new BloodSand();
	public static final Block edenBloodStone = new BlockNova("bloodstone",
			Material.rock).setHardResist(2F);
	public static final Block edenBoneStone = new BlockNova("bonestone",
			Material.rock).setHardResist(3.0F);
	public static final Block edenSacredStone = new BlockNova(
			"edensacredstone", Material.rock).setHardResist(1.4F, 6.0F)
			.setStepSound(BlockNova.soundTypeXeno);
	public static final Block edenGlass = new MultiBlockGlass();
	public static final Block edenWoodPlanks = ((BlockNova) new BlockNova(
			"edentreeplanks", Material.wood).setHardResist(1.5F, 6.0F)
			.setStepSound(Block.soundTypeWood)).setBlockHarvestLevel("axe", 1);
	public static final Block edenWoodLog = new BlockEdenWoodLog();
	public static final Block edenWoodLeaves = new BlockEdenWoodLeaves();
	public static final Block edenWoodSapling = new BlockEdenWoodSapling();
	public static final Block edenMagmaRock = new EdenMagmaRock();
	public static final Block edenGravel = new EdenGravel();
	public static final Block edenWinterRock = new BlockWinterrock();
	public static final Block edenSpaceFruit = new SpaceFruitBlock();
	public static final Block edenTreasureChest = new BlockEdenTreasureChest();
	public static final Block edenBrightStone = new EdenBritestone();
	public static final Block edenViriBlock = new BlockNova("viriblock",
			Material.iron).setHardResist(2.0F).setStepSound(
			Block.soundTypeMetal);
	
	public static final Block zollusKriffonPortal = new BlockZollusKriffonPortal();
	
	public static final Block kriffCobbleRock = new BlockNovaOre(
			"kriffcobblerock").setHardResist(1.0F, 9.5F);
	public static final Block kriffRock = new BlockNova("kriffrock",
			Material.rock).setHardResist(0.4F, 0.8F);
	public static final Block kriffStone = new KriffStone();
	public static final Block kriffCoalOre = new KriffCoalOre();
	public static final Block kriffCopperOre = new BlockNovaOre(
			"kriffcopperore").setHardResist(2.0F);
	public static final Block kriffRedstoneOre = new KriffRedstoneOre();
	public static final Block kriffIronOre = new BlockNovaOre("kriffironore")
			.setHardResist(1.2F);
	public static final Block kriffGoldOre = new BlockNovaOre("kriffgoldore")
			.setHardResist(1.5F);
	public static final Block kriffCobaltOre = new BlockNovaOre(
			"kriffcobaltore").setHardResist(1.8F);
	public static final Block kriffDirt = new BlockNovaDirt("kriffdirt", 0.6F);
	public static final Block kriffRockBricks = new BlockNova(
			"kriffrockbricks", Material.rock).setHardResist(0.9F, 9.8F);
	public static final Block kriffonPurgotPortal = new BlockKriffonPurgotPortal();
	
	public static final Block purgRock = new BlockNova("purgrock",
			Material.rock).setHardResist(0.9F);
	public static final Block purgCobbleRock = new BlockNova("purgcobblerock",
			Material.rock).setHardResist(1.0F, 10.0F);
	public static final Block purgStone = new PurgStone();
	public static final Block purgDirt = new BlockNovaDirt("purgdirt");
	public static final Block purgWhiteRock = new WhiteRock();
	public static final Block purgBlackRock = new BlackRock();
	public static final Block purgIronOre = new BlockNovaOre("purgironore")
			.setHardResist(1.4F);
	public static final Block purgGoldOre = new BlockNovaOre("purggoldore")
			.setHardResist(1.6F);
	public static final Block purgCopperOre = new BlockNovaOre("purgcopperore")
			.setHardResist(1.2F);
	public static final Block purgDiamondOre = new PurgDiamondOre();
	public static final Block purgEmeraldOre = new PurgEmeraldOre();
	public static final Block purgEveOre = ((BlockNovaOre) new BlockNovaOre(
			"purgeveniumore").setHardResist(1.4F)).setExpDrop(6, 8);
	public static final Block purgCobaltOre = ((BlockNovaOre) new BlockNovaOre(
			"purgcobaltore").setHardResist(3.4F)).setExpDrop(6, 8);
	public static final Block purgRockBricks = new BlockNova("purgrockbricks",
			Material.rock).setHardResist(0.9F, 9.8F);
	public static final Block purgotOasisPortal = new BlockPurgotOasisPortal();
	
	public static final Block xathRock = new BlockNova("xathrock",
			Material.rock).setHardResist(1.9F, 0.1F);
	public static final Block xathCobbleRock = new BlockNova("xathcobblerock",
			Material.rock).setHardResist(0.5F, 7.2F);
	public static final Block xathStone = new BlockNova("xathstone",
			Material.rock).setHardResist(0.8F, 4.2F);
	public static final Block xathDirt = new BlockNovaDirt("xathdirt", 0.4F);
	public static final Block xathGrass = new XathiusGrass();
	public static final Block xathPrometheanOre = new XathiusPrometheanOre();
	
	public static Block oasisGrass = new OasisGrass();
	public static Block oasisDirt = new BlockNovaDirt("oasisdirt", 0.4F);
	public static Block oasisCobbleRock = new BlockNova("oasiscobblerock",
			Material.rock).setHardResist(0.8f, 4.2f);
	public static Block oasisStone = new OasisRock();
	public static Block oasisTallGrass = new OasisTallGrass();
	
	public static Block healingStation = new BlockHealingStation();
	
	public static void init() {
		addBlock(zolarBlock);
		addBlock(zolCobbleRock);
		addBlock(zolstone);
		addBlock(zolniumCrystals);
		addBlock(zolCoalOre);
		addBlock(zolCopperOre);
		addBlock(zolIronOre);
		addBlock(zolGoldOre);
		addBlock(zolTinOre);
		addBlock(zolHeartOre);
		addBlock(zolDirt);
		addBlock(zolRockBricks);
		
		addBlock(edenZollusPortal);
		
		addBlock(edenCobbleRock);
		addBlock(edenRock);
		addBlock(edenRockBricks);
		addBlock(edenIronOre);
		addBlock(edenCopperOre);
		addBlock(edenTinOre);
		addBlock(edenMeteoricIronOre);
		addBlock(edenDiamondOre);
		addBlock(edenEmeraldOre);
		addBlock(edenGoldOre);
		addBlock(edenCoalOre);
		addBlock(edenRedstoneOre);
		addBlock(edenLapisOre);
		addBlock(edenDeshOre);
		addBlock(edenAluminumOre);
		addBlock(edenViriOre);
		addBlock(edenSurfaceRock);
		addBlock(edenSoil);
		addBlock(edenFlower);
		addBlock(edenFlowerBlue);
		addBlock(edenFlowerRed);
		addBlock(edenFlowerOrange);
		addBlock(edenFlowerYellow);
		addBlock(edenFlowerPurple);
		addBlock(edenFlowerCyan);
		addBlock(edenFlowerGreen);
		addBlock(edenGrass);
		addBlock(edenTallGrass);
		addBlock(edenBloodSand);
		addBlock(edenBloodStone);
		addBlock(edenBoneStone);
		addBlock(edenSacredStone);
		addBlock(edenGlass);
		addBlock(edenWoodPlanks);
		addBlock(edenWoodLog);
		addBlock(edenWoodLeaves);
		addBlock(edenWoodSapling);
		addBlock(edenMagmaRock);
		addBlock(edenGravel);
		addBlock(edenWinterRock);
		addBlock(edenSpaceFruit);
		addBlock(edenBrightStone);
		addBlock(edenTreasureChest);
		addBlock(edenViriBlock);
		
		addBlock(zollusKriffonPortal);
		
		addBlock(kriffRock);
		addBlock(kriffCobbleRock);
		addBlock(kriffStone);
		addBlock(kriffCoalOre);
		addBlock(kriffCopperOre);
		addBlock(kriffRedstoneOre);
		addBlock(kriffIronOre);
		addBlock(kriffGoldOre);
		addBlock(kriffCobaltOre);
		addBlock(kriffDirt);
		addBlock(kriffonPurgotPortal);
		addBlock(kriffRockBricks);
		
		addBlock(purgRock);
		addBlock(purgCobbleRock);
		addBlock(purgStone);
		addBlock(purgDirt);
		addBlock(purgWhiteRock);
		addBlock(purgBlackRock);
		addBlock(purgIronOre);
		addBlock(purgGoldOre);
		addBlock(purgCopperOre);
		addBlock(purgDiamondOre);
		addBlock(purgEmeraldOre);
		addBlock(purgEveOre);
		addBlock(purgCobaltOre);
		addBlock(purgRockBricks);
		addBlock(purgotOasisPortal);
		
		addBlock(xathRock);
		addBlock(xathCobbleRock);
		addBlock(xathStone);
		addBlock(xathDirt);
		addBlock(xathGrass);
		addBlock(xathPrometheanOre);
		
		addBlock(oasisStone);
		addBlock(oasisCobbleRock);
		addBlock(oasisDirt);
		addBlock(oasisGrass);
		addBlock(oasisTallGrass);
		
		addBlock(healingStation);
		
		NovaHelper.echo("Loaded a total of " + totalBlocks + " new blocks.");
	}
	
	public static void addBlock(Block par1Block) {
		RegisterHelper.registerBlock(par1Block);
		totalBlocks++;
	}
}