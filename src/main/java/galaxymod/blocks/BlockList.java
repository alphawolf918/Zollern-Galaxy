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
import galaxymod.blocks.eden.BlockEdenWoodLeaves;
import galaxymod.blocks.eden.BlockEdenWoodLog;
import galaxymod.blocks.eden.BlockEdenWoodPlanks;
import galaxymod.blocks.eden.BlockEdenWoodSapling;
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
import galaxymod.blocks.kriffus.KriffRock;
import galaxymod.blocks.kriffus.KriffStone;
import galaxymod.blocks.zollus.BlockZollus;
import galaxymod.blocks.zollus.BlockZolstone;
import galaxymod.lib.RegisterHelper;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {
	
	public static final Block solarBlock = new BlockZollus();
	public static final Block zolstone = new BlockZolstone();
	
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
	
	public static final Block kriffRock = new KriffRock();
	public static final Block kriffStone = new KriffStone();
	
	public static void init() {
		addBlock(solarBlock, "Zollus Rock");
		addBlock(zolstone, "Zolstone");
		addBlock(edenRock, "Eden Rock");
		addBlock(edenCobbleRock, "Eden Cobble Rock");
		addBlock(edenRockBricks, "Edenrock Bricks");
		addBlock(edenIronOre, "Eden Iron Ore");
		addBlock(edenCopperOre, "Eden Copper Ore");
		addBlock(edenTinOre, "Eden Tin Ore");
		addBlock(edenMeteoricIronOre, "Eden Meteoric Iron Ore");
		addBlock(edenDiamondOre, "Eden Diamond Ore");
		addBlock(edenEmeraldOre, "Eden Emerald Ore");
		addBlock(edenGoldOre, "Eden Gold Ore");
		addBlock(edenCoalOre, "Eden Coal Ore");
		addBlock(edenDeshOre, "Eden Desh Ore");
		addBlock(edenSurfaceRock, "Eden Surface Rock");
		addBlock(edenSoil, "Eden Soil");
		addBlock(edenFlower, "Eden Flower");
		addBlock(edenFlowerBlue, "Eden Blue Flower");
		addBlock(edenFlowerRed, "Eden Red Flower");
		addBlock(edenFlowerOrange, "Eden Orange Flower");
		addBlock(edenFlowerYellow, "Eden Yellow Flower");
		addBlock(edenFlowerPurple, "Eden Purple Flower");
		addBlock(edenFlowerCyan, "Eden Cyan Flower");
		addBlock(edenFlowerGreen, "Eden Green Flower");
		addBlock(edenGrass, "Eden Grass");
		addBlock(edenTallGrass, "Eden Tall Grass");
		addBlock(edenBloodSand, "Eden Blood Sand");
		addBlock(edenBloodStone, "Eden Bloodstone");
		addBlock(edenBoneStone, "Eden Bone Stone");
		addBlock(edenSacredStone, "Eden's Sacred Stone");
		addBlock(edenGlass, "Eden Glass");
		addBlock(edenWoodPlanks, "Edenwood Planks");
		addBlock(edenWoodLog, "Edenwood Log");
		addBlock(edenWoodLeaves, "Edenwood Leaves");
		addBlock(edenWoodSapling, "Edenwood Sapling");
		addBlock(edenMagmaRock, "Eden's Magrock");
		addBlock(edenGravel, "Eden's Gravel");
		addBlock(edenWinterRock, "Eden's Winterrock");
		addBlock(edenSpaceFruit, "Eden's Space Fruit");
		addBlock(edenBrightStone, "Eden's Brightstone");
		RegisterHelper.registerBlock(edenTreasureChest);
		addBlock(kriffRock, "Kriffrock");
		addBlock(kriffStone, "Kriffstone");
	}
	
	public static void addBlock(Block block, String name) {
		GameRegistry.registerBlock(block, name);
	}
}