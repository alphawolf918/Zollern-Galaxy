/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import galaxymod.blocks.eden.BlockEdenBrightStone;
import galaxymod.blocks.eden.BlockEdenCobblerock;
import galaxymod.blocks.eden.BlockEdenRock;
import galaxymod.blocks.eden.BlockEdenRockBricks;
import galaxymod.blocks.eden.BlockEdenTreasureChest;
import galaxymod.blocks.eden.BlockEdenViri;
import galaxymod.blocks.eden.BlockEdenWoodLeaves;
import galaxymod.blocks.eden.BlockEdenWoodLog;
import galaxymod.blocks.eden.BlockEdenWoodPlanks;
import galaxymod.blocks.eden.BlockEdenWoodSapling;
import galaxymod.blocks.eden.BlockEdenZollusPortal;
import galaxymod.blocks.eden.BlockWinterrock;
import galaxymod.blocks.eden.BloodSand;
import galaxymod.blocks.eden.BloodStone;
import galaxymod.blocks.eden.BoneBlock;
import galaxymod.blocks.eden.EdenFlower;
import galaxymod.blocks.eden.EdenGrass;
import galaxymod.blocks.eden.EdenGravel;
import galaxymod.blocks.eden.EdenMagmaRock;
import galaxymod.blocks.eden.EdenSacredStone;
import galaxymod.blocks.eden.EdenSoil;
import galaxymod.blocks.eden.EdenSurfaceRock;
import galaxymod.blocks.eden.EdenTallGrass;
import galaxymod.blocks.eden.MultiBlockGlass;
import galaxymod.blocks.eden.SpaceFruitBlock;
import galaxymod.blocks.eden.ores.EdenCoalOre;
import galaxymod.blocks.eden.ores.EdenCopperOre;
import galaxymod.blocks.eden.ores.EdenDeshOre;
import galaxymod.blocks.eden.ores.EdenDiamondOre;
import galaxymod.blocks.eden.ores.EdenEmeraldOre;
import galaxymod.blocks.eden.ores.EdenGoldOre;
import galaxymod.blocks.eden.ores.EdenIronOre;
import galaxymod.blocks.eden.ores.EdenMeteoricIronOre;
import galaxymod.blocks.eden.ores.EdenTinOre;
import galaxymod.blocks.eden.ores.EdenViriOre;
import galaxymod.blocks.kriffus.KriffRock;
import galaxymod.blocks.kriffus.KriffStone;
import galaxymod.blocks.zollus.BlockZolCobbleRock;
import galaxymod.blocks.zollus.BlockZollus;
import galaxymod.blocks.zollus.BlockZolniumCrystals;
import galaxymod.blocks.zollus.BlockZolstone;
import galaxymod.blocks.zollus.ores.ZollusCoalOre;
import galaxymod.blocks.zollus.ores.ZollusCopperOre;
import galaxymod.blocks.zollus.ores.ZollusGoldOre;
import galaxymod.blocks.zollus.ores.ZollusIronOre;
import galaxymod.blocks.zollus.ores.ZollusTinOre;
import galaxymod.lib.RegisterHelper;
import net.minecraft.block.Block;

public class BlockList {
	
	public static final Block zolarBlock = new BlockZollus();
	public static final Block zolstone = new BlockZolstone();
	public static final Block zolCobbleRock = new BlockZolCobbleRock();
	public static final Block zolniumCrystals = new BlockZolniumCrystals();
	public static final Block zolCoalOre = new ZollusCoalOre();
	public static final Block zolCopperOre = new ZollusCopperOre();
	public static final Block zolIronOre = new ZollusIronOre();
	public static final Block zolGoldOre = new ZollusGoldOre();
	public static final Block zolTinOre = new ZollusTinOre();
	
	public static final Block edenZollusPortal = new BlockEdenZollusPortal();
	
	public static final Block edenRock = new BlockEdenRock();
	public static final Block edenCobbleRock = new BlockEdenCobblerock();
	public static final Block edenRockBricks = new BlockEdenRockBricks();
	public static final Block edenIronOre = new EdenIronOre();
	public static final Block edenCopperOre = new EdenCopperOre();
	public static final Block edenTinOre = new EdenTinOre();
	public static final Block edenMeteoricIronOre = new EdenMeteoricIronOre();
	public static final Block edenDiamondOre = new EdenDiamondOre();
	public static final Block edenEmeraldOre = new EdenEmeraldOre();
	public static final Block edenGoldOre = new EdenGoldOre();
	public static final Block edenCoalOre = new EdenCoalOre();
	public static final Block edenDeshOre = new EdenDeshOre();
	public static final Block edenViriOre = new EdenViriOre();
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
	public static final Block edenBloodStone = new BloodStone();
	public static final Block edenBoneStone = new BoneBlock();
	public static final Block edenSacredStone = new EdenSacredStone();
	public static final Block edenGlass = new MultiBlockGlass();
	public static final Block edenWoodPlanks = new BlockEdenWoodPlanks();
	public static final Block edenWoodLog = new BlockEdenWoodLog();
	public static final Block edenWoodLeaves = new BlockEdenWoodLeaves();
	public static final Block edenWoodSapling = new BlockEdenWoodSapling();
	public static final Block edenMagmaRock = new EdenMagmaRock();
	public static final Block edenGravel = new EdenGravel();
	public static final Block edenWinterRock = new BlockWinterrock();
	public static final Block edenSpaceFruit = new SpaceFruitBlock();
	public static final Block edenTreasureChest = new BlockEdenTreasureChest();
	public static final Block edenBrightStone = new BlockEdenBrightStone();
	public static final Block edenViriBlock = new BlockEdenViri();
	
	public static final Block kriffRock = new KriffRock();
	public static final Block kriffStone = new KriffStone();
	
	public static void init() {
		addBlock(zolarBlock);
		addBlock(zolstone);
		addBlock(zolCobbleRock);
		addBlock(zolniumCrystals);
		addBlock(zolCoalOre);
		addBlock(zolCopperOre);
		addBlock(zolIronOre);
		addBlock(zolGoldOre);
		addBlock(zolTinOre);
		
		addBlock(edenZollusPortal);
		
		addBlock(edenRock);
		addBlock(edenCobbleRock);
		addBlock(edenRockBricks);
		addBlock(edenIronOre);
		addBlock(edenCopperOre);
		addBlock(edenTinOre);
		addBlock(edenMeteoricIronOre);
		addBlock(edenDiamondOre);
		addBlock(edenEmeraldOre);
		addBlock(edenGoldOre);
		addBlock(edenCoalOre);
		addBlock(edenDeshOre);
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
		
		addBlock(kriffRock);
		addBlock(kriffStone);
	}
	
	public static void addBlock(Block par1Block) {
		RegisterHelper.registerBlock(par1Block);
	}
}