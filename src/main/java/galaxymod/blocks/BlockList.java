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

import galaxymod.blocks.eden.BlockEdenTreasureChest;
import galaxymod.blocks.eden.BlockEdenWoodLeaves;
import galaxymod.blocks.eden.BlockEdenWoodLog;
import galaxymod.blocks.eden.BlockEdenWoodSapling;
import galaxymod.blocks.eden.BlockEdenZollusPortal;
import galaxymod.blocks.eden.BlockWinterrock;
import galaxymod.blocks.eden.BloodSand;
import galaxymod.blocks.eden.EdenFlower;
import galaxymod.blocks.eden.EdenGrass;
import galaxymod.blocks.eden.EdenGravel;
import galaxymod.blocks.eden.EdenMagmaRock;
import galaxymod.blocks.eden.EdenSoil;
import galaxymod.blocks.eden.EdenSurfaceRock;
import galaxymod.blocks.eden.EdenTallGrass;
import galaxymod.blocks.eden.MultiBlockGlass;
import galaxymod.blocks.eden.SpaceFruitBlock;
import galaxymod.blocks.kriffus.BlockZollusKriffonPortal;
import galaxymod.blocks.zollus.BlockZolniumCrystals;
import galaxymod.items.ItemList;
import galaxymod.lib.NovaHelper;
import galaxymod.lib.RegisterHelper;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockList {
	
	static int totalBlocks = 0;
	
	public static final Block zolarBlock = ((BlockNova) new BlockNova(
			"solarblock", Material.rock).setHardResist(1.5F, 5.6F))
			.setPlantToSustain(BlockList.zolniumCrystals);
	public static final Block zolCobbleRock = new BlockNova("zolcobblerock",
			Material.rock).setHardResist(1.0F, 6.5F);
	public static final Block zolstone = ((BlockNova) new BlockNova("zolstone",
			Material.rock).setHardResist(4.1F, 9.8F)).setDropItem(Item
			.getItemFromBlock(BlockList.zolCobbleRock));
	public static final Block zolniumCrystals = new BlockZolniumCrystals();
	public static final Block zolCoalOre = ((BlockNova) new BlockNovaOre(
			"zolcoalore").setHardResist(4.0F)).setDropItem(Items.coal, 2, 4);
	public static final Block zolCopperOre = ((BlockNova) new BlockNovaOre(
			"zolcopperore").setHardResist(1.2F)).setExpDrop(4, 6);
	public static final Block zolIronOre = ((BlockNova) new BlockNovaOre(
			"zolironore").setHardResist(1.5F)).setExpDrop(1, 2);
	public static final Block zolGoldOre = ((BlockNova) new BlockNovaOre(
			"zolgoldore").setHardResist(1.6F)).setExpDrop(3, 4);
	public static final Block zolTinOre = ((BlockNova) new BlockNovaOre(
			"zoltinore").setHardResist(0.4F)).setExpDrop(2, 4);
	public static final Block zolHeartOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"zolheartore").setHardResist(4.5F)).setDropItem(
			ItemList.zollusHeartium, 1, 2)).setExpDrop(8, 10);
	public static final Block zolDirt = new BlockNova("zoldirt",
			Material.ground).setHardResist(0.6F);
	
	public static final Block edenZollusPortal = new BlockEdenZollusPortal();
	
	public static final Block edenCobbleRock = new BlockNova("edencobblerock",
			Material.rock).setHardResist(1.2F);
	public static final Block edenRock = ((BlockNova) new BlockNova("edenrock",
			Material.rock).setHardResist(1.0F, 9.8F)).setDropItem(Item
			.getItemFromBlock(BlockList.edenCobbleRock));
	public static final Block edenRockBricks = new BlockNova("edenrockbricks",
			Material.rock).setHardResist(0.9F, 9.8F);
	public static final Block edenIronOre = ((BlockNova) new BlockNovaOre(
			"edenironore").setHardResist(2.5F)).setExpDrop(2, 4);
	public static final Block edenCopperOre = new BlockNovaOre("edencopperore");
	public static final Block edenTinOre = new BlockNovaOre("edentinore");
	public static final Block edenMeteoricIronOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edenmeteoricironore").setHardResist(3.0F, 8.0F)).setDropItem(
			GCItems.meteoricIronRaw, 1, 2)).setExpDrop(6, 11);
	public static final Block edenDiamondOre = ((BlockNova) new BlockNovaOre(
			"edendiamondore").setHardResist(4.0F, 4.6F)).setDropItem(
			Items.diamond, 1, 2);
	public static final Block edenEmeraldOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edenemeraldore").setHardResist(4.0F, 4.6F)).setDropItem(
			Items.emerald, 1, 2)).setExpDrop(8, 11);
	public static final Block edenGoldOre = ((BlockNova) new BlockNovaOre(
			"edengoldore").setHardResist(3.5F)).setExpDrop(3, 5);
	public static final Block edenCoalOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edencoalore").setHardResist(1.5F)).setDropItem(Items.coal, 2, 4))
			.setExpDrop(1, 2);
	public static final Block edenRedstoneOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edenredstoneore").setHardResist(3.2F)).setDropItem(Items.redstone,
			3, 5)).setExpDrop(5, 7);
	public static final Block edenDeshOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edendeshore").setHardResist(4.0F)).setDropItem(
			MarsItems.marsItemBasic, 1, 2)).setExpDrop(6, 8);
	public static final Block edenAluminumOre = new BlockNovaOre(
			"edenaluminumore").setHardResist(3.0F, 6.0F);
	public static final Block edenViriOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"edenviriore").setHardResist(2.0F, 6.0F)).setDropItem(
			ItemList.rawViri, 1, 2)).setExpDrop(9, 10);
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
	public static final Block edenBrightStone = ((BlockNova) ((BlockNova) new BlockNova(
			"brightstone", Material.glass).setLightLevel(1.0F))
			.setHardResist(0.6F)).setDropItem(ItemList.brightStoneDust, 2, 3)
			.setStepSound(Block.soundTypeGlass);
	public static final Block edenViriBlock = new BlockNova("viriblock",
			Material.iron).setHardResist(2.0F).setStepSound(
			Block.soundTypeMetal);
	
	public static final Block zollusKriffonPortal = new BlockZollusKriffonPortal();
	
	public static final Block kriffRock = new BlockNova("kriffrock",
			Material.rock).setHardResist(0.4F, 0.8F);
	public static final Block kriffStone = new BlockNova("kriffstone",
			Material.rock);
	public static final Block kriffCoalOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"kriffcoalore").setHardResist(4.4F)).setDropItem(Items.coal, 4, 6))
			.setExpDrop(5, 8);
	public static final Block kriffCopperOre = new BlockNovaOre(
			"kriffcopperore").setHardResist(2.0F);
	public static final Block kriffRedstoneOre = ((BlockNova) ((BlockNova) new BlockNovaOre(
			"kriffredstoneore").setHardResist(1.5F)).setDropItem(
			Items.redstone, 6, 80)).setExpDrop(8, 10);
	public static final Block kriffIronOre = new BlockNovaOre("kriffironore")
			.setHardResist(1.2F);
	public static final Block kriffGoldOre = new BlockNovaOre("kriffgoldore")
			.setHardResist(1.5F);
	public static final Block kriffDirt = new BlockNova("kriffdirt",
			Material.ground).setHardResist(0.6F);
	
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
		addBlock(kriffStone);
		addBlock(kriffCoalOre);
		addBlock(kriffCopperOre);
		addBlock(kriffRedstoneOre);
		addBlock(kriffIronOre);
		addBlock(kriffGoldOre);
		addBlock(kriffDirt);
		
		NovaHelper.echo("Loaded a total of " + totalBlocks + " blocks.");
	}
	
	public static void addBlock(Block par1Block) {
		RegisterHelper.registerBlock(par1Block);
		totalBlocks++;
	}
}