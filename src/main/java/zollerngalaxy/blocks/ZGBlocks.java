/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.lang.reflect.Constructor;
import com.google.common.collect.ObjectArrays;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.core.items.ItemBlockDesc;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.astros.AstrosSapphireOre;
import zollerngalaxy.blocks.caligro.BlockShadowBossSpawner;
import zollerngalaxy.blocks.caligro.BlockSpiderEgg;
import zollerngalaxy.blocks.caligro.corrupted.ZGBlockOreCorrupted;
import zollerngalaxy.blocks.caligro.corrupted.ZGCorruptBlock;
import zollerngalaxy.blocks.caligro.corrupted.ZGOreGemCorrupted;
import zollerngalaxy.blocks.caligro.corrupted.ZGPlanetStoneCorrupted;
import zollerngalaxy.blocks.centotl.BlockFacehuggerEgg;
import zollerngalaxy.blocks.containers.ZGBlockTreasureChestTier10;
import zollerngalaxy.blocks.containers.ZGBlockTreasureChestTier4;
import zollerngalaxy.blocks.crops.BlockCropBlackberry;
import zollerngalaxy.blocks.crops.BlockCropBlueberry;
import zollerngalaxy.blocks.crops.BlockCropCorn;
import zollerngalaxy.blocks.crops.BlockCropCucumber;
import zollerngalaxy.blocks.crops.BlockCropGarlic;
import zollerngalaxy.blocks.crops.BlockCropGrape;
import zollerngalaxy.blocks.crops.BlockCropOnion;
import zollerngalaxy.blocks.crops.BlockCropPeas;
import zollerngalaxy.blocks.crops.BlockCropRadish;
import zollerngalaxy.blocks.crops.BlockCropStrawberry;
import zollerngalaxy.blocks.crops.BlockCropTomato;
import zollerngalaxy.blocks.crops.nether.BlockNetherCropGhostPepper;
import zollerngalaxy.blocks.crystals.BlockStormCrystals;
import zollerngalaxy.blocks.crystals.ZGCrystalBlock;
import zollerngalaxy.blocks.eden.BlockRedshroom;
import zollerngalaxy.blocks.eden.EdenFlower;
import zollerngalaxy.blocks.eden.EdenFruit;
import zollerngalaxy.blocks.eden.ZGBlockGrassEden;
import zollerngalaxy.blocks.exodus.ZGBlockGrassExodus;
import zollerngalaxy.blocks.harran.ZGBlockCherryGrassHarran;
import zollerngalaxy.blocks.harran.ZGBlockGrassHarran;
import zollerngalaxy.blocks.infected.ZGBlockInfectedTallGrass;
import zollerngalaxy.blocks.infected.ZGInfectedDirt;
import zollerngalaxy.blocks.infected.ZGInfectedGrass;
import zollerngalaxy.blocks.oasis.BlockMudClay;
import zollerngalaxy.blocks.oasis.ZGBlockGrassOasis;
import zollerngalaxy.blocks.oasis.ZGFlower;
import zollerngalaxy.blocks.perdita.LostCactus;
import zollerngalaxy.blocks.perdita.LostReeds;
import zollerngalaxy.blocks.perdita.ZGBlockGrassPerdita;
import zollerngalaxy.blocks.perdita.ZGDeadBush;
import zollerngalaxy.blocks.sirens.BlockDiamondSiren;
import zollerngalaxy.blocks.sirens.BlockEmeraldSiren;
import zollerngalaxy.blocks.sirens.BlockGoldSiren;
import zollerngalaxy.blocks.sirens.BlockIronSiren;
import zollerngalaxy.blocks.spawners.ZGBlockBossSpawnerEden;
import zollerngalaxy.blocks.spawners.ZGBlockBossSpawnerTlaloc;
import zollerngalaxy.blocks.stationblocks.BlockBlueprintStation;
import zollerngalaxy.blocks.stationblocks.BlockHealingStation;
import zollerngalaxy.blocks.sweetblocks.CandyCubeBlock;
import zollerngalaxy.blocks.sweetblocks.CookieBlock;
import zollerngalaxy.blocks.sweetblocks.IceCreamSandwichBlock;
import zollerngalaxy.blocks.xathius.ZGBlockGrassXath;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockTier;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.tileentities.TileEntityTier10TreasureChestZG;
import zollerngalaxy.tileentities.TileEntityTier4TreasureChestZG;
import zollerngalaxy.tileentities.dungeons.TileEntityDungeonSpawnerEden;
import zollerngalaxy.tileentities.dungeons.TileEntityDungeonSpawnerTlaloc;
import zollerngalaxy.util.RegisterUtilsZG;
import zollerngalaxy.worldgen.WorldGenTreeGiantZG;
import zollerngalaxy.worldgen.WorldGenZGTree;
import zollerngalaxy.worldgen.eden.WorldGenEdenTrees;
import zollerngalaxy.worldgen.exodus.WorldGenExoTrees;
import zollerngalaxy.worldgen.perdita.WorldGenPalmwoodTrees;

public class ZGBlocks {
	
	private static ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	
	private static int totalBlocks = 0;
	
	public static final Block edenWoodLog = new ZGBlockLog("edenwoodlog");
	public static final Block edenWoodLeaves = new ZGBlockLeaves("edenwoodleaves", ZGBlocks.edenWoodSapling);
	private static WorldGenerator edenTreeGen = new WorldGenEdenTrees(true, ZGHelper.rngInt(5, 15), ZGBlocks.edenWoodLog.getDefaultState(), ZGBlocks.edenWoodLeaves.getDefaultState(), false);
	
	public static final Block edenParadiseWoodLog = new ZGBlockLog("paradisewoodlog");
	public static final Block edenParadiseWoodLeaves = new ZGBlockLeaves("paradisewoodleaves", ZGBlocks.edenParadiseWoodSapling);
	private static WorldGenerator edenParadiseTreeGen = new WorldGenEdenTrees(true, ZGHelper.rngInt(5, 7), ZGBlocks.edenParadiseWoodLog.getDefaultState(), ZGBlocks.edenParadiseWoodLeaves.getDefaultState(), false);
	
	public static final Block edenGoldenWoodLog = new ZGBlockLog("goldenwoodlog");
	public static final Block edenGoldenWoodLeaves = new ZGBlockLeaves("goldenwoodleaves", ZGBlocks.edenGoldenWoodSapling);
	private static WorldGenerator edenGoldenTreeGen = new WorldGenEdenTrees(true, ZGHelper.rngInt(4, 8), ZGBlocks.edenGoldenWoodLog.getDefaultState(), ZGBlocks.edenGoldenWoodLeaves.getDefaultState(), false);
	
	public static final Block edenLovetreeLog = new ZGBlockLog("lovetreelog");
	public static final Block edenLovetreeLeaves = new ZGBlockLeaves("lovetreeleaves", ZGBlocks.edenLovetreeSapling);
	public static WorldGenerator edenLovetreeGen = new WorldGenEdenTrees(true, 5, ZGBlocks.edenLovetreeLog.getDefaultState(), ZGBlocks.edenLovetreeLeaves.getDefaultState(), false);
	
	public static final Block xathWoodLog = new ZGBlockLog("xathwoodlog").setShouldAlwaysBurn(false).setResistance(10.0F);
	public static final Block xathWoodLeaves = new ZGBlockLeaves("xathwoodleaves", ZGBlocks.xathWoodSapling).setShouldAlwaysBurn(false).setResistance(10.0F);
	public static WorldGenerator xathWoodTreeGen = new WorldGenTreeGiantZG(true, 5, ZGBlocks.xathWoodLog.getDefaultState(), ZGBlocks.xathWoodLeaves.getDefaultState(), false);
	
	public static final Block perdWoodLogs = new ZGBlockLog("palmwoodlog");
	public static final Block perdWoodLeaves = new ZGFruitLeaves("palmwoodleaves", ZGBlocks.perdTreeSapling, ZGItems.perdPeach);
	public static final Block perdWoodPlanks = new ZGBlockPlanks("palmwoodplanks");
	private static WorldGenerator palmWoodTreeGen = new WorldGenPalmwoodTrees(true, ZGHelper.rngInt(5, 15), ZGBlocks.perdWoodLogs.getDefaultState(), ZGBlocks.perdWoodLeaves.getDefaultState(), false);
	
	public static final Block exoWoodLogs = new ZGBlockLog("exoduswoodlog");
	public static final Block exoWoodLeaves = new ZGBlockLeaves("exoduswoodleaves", ZGBlocks.exoWoodSapling);
	public static final Block exoWoodPlanks = new ZGBlockPlanks("exoduswoodplanks");
	public static final WorldGenerator exoWoodTreeGen = new WorldGenExoTrees(true, 5, ZGBlocks.exoWoodLogs.getDefaultState(), ZGBlocks.exoWoodLeaves.getDefaultState(), false);
	
	// Fruit Trees (Cherry)
	public static final Block cherryWoodLog = new ZGBlockLog("cherrylog");
	public static final Block cherryWoodLeaves = new ZGFruitLeaves("cherryleaves", ZGBlocks.cherryWoodSapling, ZGItems.cherry);
	public static final Block cherryWoodPlanks = new ZGBlockPlanks("cherryplanks");
	public static final WorldGenAbstractTree cherryWoodGen = new WorldGenZGTree(true, 6, ZGBlocks.cherryWoodLog.getDefaultState(), ZGBlocks.cherryWoodLeaves.getDefaultState(), false);
	
	// Fruit Trees (Banana)
	public static final Block bananaLog = new ZGBlockLog("bananalog");
	public static final Block bananaLeaves = new ZGFruitLeaves("bananaleaves", ZGBlocks.bananaSapling, ZGItems.banana);
	public static final Block bananaPlanks = new ZGBlockPlanks("bananaplanks");
	public static final WorldGenAbstractTree bananaGen = new WorldGenZGTree(true, 8, ZGBlocks.bananaLog.getDefaultState(), ZGBlocks.bananaLeaves.getDefaultState(), false);
	
	// Fruit Trees (Guava)
	public static final Block guavaLog = new ZGBlockLog("guavalog");
	public static final Block guavaLeaves = new ZGFruitLeaves("guavaleaves", ZGBlocks.guavaSapling, ZGItems.guava);
	public static final Block guavaPlanks = new ZGBlockPlanks("guavaplanks");
	public static final WorldGenAbstractTree guavaGen = new WorldGenZGTree(true, 4, ZGBlocks.guavaLog.getDefaultState(), ZGBlocks.guavaLeaves.getDefaultState(), false);
	
	// Fruit Trees (Peach)
	public static final Block peachLog = new ZGBlockLog("peachlog");
	public static final Block peachLeaves = new ZGFruitLeaves("peachleaves", ZGBlocks.peachSapling, ZGItems.peach);
	public static final Block peachPlanks = new ZGBlockPlanks("peachplanks");
	public static final WorldGenAbstractTree peachGen = new WorldGenZGTree(true, 2, ZGBlocks.peachLog.getDefaultState(), ZGBlocks.peachLeaves.getDefaultState(), false);
	
	// Fruit Trees (Grapefruit)
	public static final Block grapefruitLog = new ZGBlockLog("grapefruitlog");
	public static final Block grapefruitLeaves = new ZGFruitLeaves("grapefruitleaves", ZGBlocks.grapefruitSapling, ZGItems.grapefruit);
	public static final Block grapefruitPlanks = new ZGBlockPlanks("grapefruitplanks");
	public static final WorldGenAbstractTree grapefruitGen = new WorldGenZGTree(true, 6, ZGBlocks.grapefruitLog.getDefaultState(), ZGBlocks.grapefruitLeaves.getDefaultState(), false);
	
	// Fruit Trees (Orange)
	public static final Block orangeLog = new ZGBlockLog("orangelog");
	public static final Block orangeLeaves = new ZGFruitLeaves("orangeleaves", ZGBlocks.orangeSapling, ZGItems.orange);
	public static final Block orangePlanks = new ZGBlockPlanks("orangeplanks");
	public static final WorldGenAbstractTree orangeGen = new WorldGenZGTree(true, 4, ZGBlocks.orangeLog.getDefaultState(), ZGBlocks.orangeLeaves.getDefaultState(), false);
	
	// Fruit Trees (Lemon)
	public static final Block lemonLog = new ZGBlockLog("lemonlog");
	public static final Block lemonLeaves = new ZGFruitLeaves("lemonleaves", ZGBlocks.lemonSapling, ZGItems.lemon);
	public static final Block lemonPlanks = new ZGBlockPlanks("lemonplanks");
	public static final WorldGenAbstractTree lemonGen = new WorldGenZGTree(true, 4, ZGBlocks.lemonLog.getDefaultState(), ZGBlocks.lemonLeaves.getDefaultState(), false);
	
	// Fruit Trees (Lime)
	public static final Block limeLog = new ZGBlockLog("limelog");
	public static final Block limeLeaves = new ZGFruitLeaves("limeleaves", ZGBlocks.limeSapling, ZGItems.lime);
	public static final Block limePlanks = new ZGBlockPlanks("limeplanks");
	public static final WorldGenAbstractTree limeGen = new WorldGenZGTree(true, 4, ZGBlocks.limeLog.getDefaultState(), ZGBlocks.limeLeaves.getDefaultState(), false);
	
	// Fruit Trees (Limon)
	public static final Block limonLog = new ZGBlockLog("limonlog");
	public static final Block limonLeaves = new ZGFruitLeaves("limonleaves", ZGBlocks.limonSapling, ZGItems.limon);
	public static final Block limonPlanks = new ZGBlockPlanks("limonplanks");
	public static final WorldGenAbstractTree limonGen = new WorldGenZGTree(true, 4, ZGBlocks.limonLog.getDefaultState(), ZGBlocks.limonLeaves.getDefaultState(), false);
	
	// These all have to be declared up top or else weird things happen.
	public static final Block perdTreeSapling = new ZGBlockSapling("palmtreesapling", palmWoodTreeGen);
	public static final Block edenWoodSapling = new ZGBlockSapling("edentreesapling", edenTreeGen);
	public static final Block edenParadiseWoodSapling = new ZGBlockSapling("paradisewoodsapling", edenParadiseTreeGen);
	public static final Block edenGoldenWoodSapling = new ZGBlockSapling("goldenwoodsapling", edenGoldenTreeGen);
	public static final Block edenLovetreeSapling = new ZGBlockSapling("lovetreesapling", edenLovetreeGen);
	public static final Block xathWoodSapling = new ZGBlockSapling("xathtreesapling", xathWoodTreeGen);
	public static final Block exoWoodSapling = new ZGBlockSapling("exoduswoodsapling", exoWoodTreeGen);
	public static final Block cherryWoodSapling = new ZGBlockSapling("cherrysapling", cherryWoodGen);
	public static final Block bananaSapling = new ZGBlockSapling("bananasapling", bananaGen);
	public static final Block guavaSapling = new ZGBlockSapling("guavasapling", guavaGen);
	public static final Block peachSapling = new ZGBlockSapling("peachsapling", peachGen);
	public static final Block grapefruitSapling = new ZGBlockSapling("grapefruitsapling", grapefruitGen);
	public static final Block orangeSapling = new ZGBlockSapling("orangesapling", orangeGen);
	public static final Block lemonSapling = new ZGBlockSapling("lemonsapling", lemonGen);
	public static final Block limeSapling = new ZGBlockSapling("limesapling", limeGen);
	public static final Block limonSapling = new ZGBlockSapling("limonsapling", limonGen);
	
	public static final Block edenFruit = new EdenFruit();
	public static final Block edenFlower = new EdenFlower();
	public static final Block edenFlowerBlack = new EdenFlower("black");
	public static final Block edenFlowerBlue = new EdenFlower("blue");
	public static final Block edenFlowerCyan = new EdenFlower("cyan");
	public static final Block edenFlowerGreen = new EdenFlower("green");
	public static final Block edenFlowerOrange = new EdenFlower("orange");
	public static final Block edenFlowerPink = new EdenFlower("pink");
	public static final Block edenFlowerPurple = new EdenFlower("purple");
	public static final Block edenFlowerRed = new EdenFlower("red");
	public static final Block edenFlowerYellow = new EdenFlower("yellow");
	public static final Block edenFlowerWhite = new EdenFlower("white");
	public static final Block oasisFlower = new ZGFlower("oasisflower");
	public static final Block exodusFlower = new ZGFlower("aster");
	
	// Zollus
	public static final Block zolCobbleRock = new ZGBlockBase("zolcobblerock", 1.2F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block zolStone = new ZGPlanetStone("zolstone", 1.6F, ZGBlocks.zolCobbleRock);
	public static final Block zolSurfaceRock = new ZGBlockBase("zolsurfacerock", 1.2F);
	public static final Block zolRoyalRock = new ZGBlockBase("zolroyalrock", 3.4F);
	public static final Block zolSnow = ((ZGBlockBase) new ZGBlockBase("zolsnow", 0.6F).setSound(SoundType.SNOW)).setMaterial(Material.SNOW);
	public static final Block zolIce = new ZGBlockIce("zolice", 2.3F);
	public static final Block zolDirt = new ZGBlockDirt("zoldirt");
	public static final Block zolGravel = new ZGGravel("zolgravel");
	public static final Block zolRockBricks = new ZGBlockBase("zolrockbricks", 1.2F);
	public static final Block zolCoalOre = new ZGOreGem("zolcoalore", 1.4F, Items.COAL);
	public static final Block zolCopperOre = new ZGBlockOre("zolcopperore", 1.7F);
	public static final Block zolGoldOre = new ZGBlockOre("zolgoldore", 1.8F);
	public static final Block zolHeartOre = new ZGOreGem("zolheartore", 1.5F, ZGItems.heartium);
	public static final Block zolTinOre = new ZGBlockOre("zoltinore", 1.2F);
	public static final Block zolIronOre = new ZGBlockOre("zolironore", 1.4F);
	public static final Block zolCrystals = new ZolniumCrystals();
	
	// Kriffon
	public static final Block kriffCobbleRock = new ZGBlockBase("kriffcobblerock", 1.4F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block kriffStone = new ZGPlanetStone("kriffstone", 1.6F, ZGBlocks.kriffCobbleRock);
	public static final Block kriffSurfaceRock = new ZGBlockBase("kriffrock", 1.6F);
	public static final Block kriffDirt = new ZGBlockDirt("kriffdirt");
	public static final Block kriffRockBricks = new ZGBlockBase("kriffrockbricks", 1.4F);
	public static final Block kriffMagmaRock = ((ZGBlockBase) new ZGBlockBase("magmarock", 2.6F).setIsHotBlock(true).setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block blazeRock = ((ZGBlockBase) new ZGBlockBase("blazerock", 3.4F).setIsHotBlock(true).setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block kriffCoalOre = new ZGOreGem("kriffcoalore", 1.6F, Items.COAL).setShouldExplode(true, 90);
	public static final Block kriffCopperOre = new ZGBlockOre("kriffcopperore", 1.7F).setShouldExplode(true, 80);
	public static final Block kriffIronOre = new ZGBlockOre("kriffironore", 1.4F).setShouldExplode(true, 70);
	public static final Block kriffGoldOre = new ZGBlockOre("kriffgoldore", 1.7F).setShouldExplode(true, 50);
	public static final Block kriffCobaltOre = new ZGBlockOre("kriffcobaltore", 1.9F).setShouldExplode(true, 10);
	public static final Block kriffRedstoneOre = new ZGOreGem("kriffredstoneore", 1.8F, Items.REDSTONE).setShouldExplode(true, 35);
	
	// Purgot
	public static final Block purgCobbleRock = new ZGBlockBase("purgcobblerock", 2.0F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block purgStone = new ZGPlanetStone("purgstone", 2.5F, ZGBlocks.purgCobbleRock);
	public static final Block purgRockBricks = new ZGBlockBase("purgrockbricks", 1.6F);
	public static final Block purgSurfaceRock = new ZGBlockBase("purgrock", 1.7F);
	public static final Block purgDirt = new ZGBlockDirt("purgdirt");
	public static final Block purgGravel = new ZGGravel("purggravel", 2.3F);
	public static final Block purgBlackRock = new ZGBlockBase("blackrock", 1.2F);
	public static final Block purgWhiteRock = new ZGBlockBase("whiterock", 1.2F).setTransparent();
	public static final Block purgMeteoricIronOre = new ZGOreGem("purgmeteoricironore", 3.6F, GCItems.meteoricIronRaw).setShouldGivePotionEffect(true, MobEffects.LEVITATION);
	public static final Block purgCobaltOre = ((ZGBlockBase) new ZGBlockOre("purgcobaltore", 2.8F).setShouldGivePotionEffect(true, MobEffects.BLINDNESS)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgIronOre = ((ZGBlockBase) new ZGBlockOre("purgironore", 2.6F).setShouldGivePotionEffect(true, MobEffects.INVISIBILITY)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgGoldOre = ((ZGBlockBase) new ZGBlockOre("purggoldore", 2.6F).setShouldGivePotionEffect(true, MobEffects.HUNGER)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgCopperOre = ((ZGBlockBase) new ZGBlockOre("purgcopperore", 2.1F).setShouldGivePotionEffect(true, MobEffects.UNLUCK)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgDiamondOre = ((ZGBlockBase) new ZGOreGem("purgdiamondore", 2.9F, Items.DIAMOND).setShouldGivePotionEffect(true, MobEffects.SLOWNESS)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgEmeraldOre = ((ZGBlockBase) new ZGOreGem("purgemeraldore", 3.0F, Items.EMERALD).setShouldGivePotionEffect(true, MobEffects.HEALTH_BOOST)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgEveniumOre = ((ZGBlockBase) new ZGBlockOre("purgeveniumore", 2.9F).setShouldGivePotionEffect(true, MobEffects.GLOWING)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgAluminumOre = ((ZGBlockBase) new ZGBlockOre("purgaluminumore", 2.6F).setShouldGivePotionEffect(true, MobEffects.JUMP_BOOST)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgTinOre = ((ZGBlockBase) new ZGBlockOre("purgtinore", 1.6F).setShouldGivePotionEffect(true, MobEffects.NIGHT_VISION)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgLeadOre = ((ZGBlockBase) new ZGBlockOre("purgleadore", 1.8F).setShouldGivePotionEffect(true, MobEffects.HASTE)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgRedstoneOre = ((ZGBlockBase) new ZGOreGem("purgredstoneore", 1.5F, Items.REDSTONE).setShouldGivePotionEffect(true, MobEffects.REGENERATION)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	
	// Eden
	public static final Block edenSurfaceRock = new ZGBlockBase("edensurfacerock", 2.1F);
	public static final Block edenSoil = new ZGBlockDirt("edensoil", 1.6F);
	public static final Block edenGrass = new ZGBlockGrassEden("edengrass");
	public static final Block edenTallGrass = new ZGBlockTallGrass("edentallgrass");
	public static final Block edenSwampGrass = new ZGBlockGrassEden("edenswampgrass");
	public static final Block edenSnow = new ZGBlockGrassEden("edengrass_snow").setSound(SoundType.SNOW);
	public static final Block edenGoldenGrass = new ZGBlockGrassEden("edengoldengrass");
	public static final Block edenFallGrass = new ZGBlockGrassEden("edengrass_autumn");
	public static final Block edenCobbleRock = new ZGBlockBase("edencobblerock", 1.5F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block edenStone = new ZGPlanetStone("edenrock", 2.6F, ZGBlocks.edenCobbleRock);
	public static final Block edenSacredStone = new ZGBlockBase("edensacredstone", 3.2F);
	public static final Block edenDungeonBricks = new ZGBlockBase("edendungeonbricks", 3.4F);
	public static final Block edenRockBricks = new ZGBlockBase("edenrockbricks", 1.4F);
	public static final Block edenWinterRock = new ZGBlockBase("edenwinterrock", 1.6F);
	public static final Block edenBloodSand = new ZGSand("bloodsand", 1.4F);
	public static final Block edenBloodStone = new ZGBlockBase("bloodstone", 1.4F);
	public static final Block edenBoneStone = new ZGBlockBase("bonestone", 1.8F);
	public static final Block edenGravel = new ZGGravel("edengravel", 2.1F);
	public static final Block edenBrightStone = new ZGShineBlock("brightstone", ZGItems.dustBrightstone);
	public static final Block edenWoodPlanks = new ZGBlockPlanks("edenwoodplanks");
	public static final Block edenParadiseWoodPlanks = new ZGBlockPlanks("paradisewoodplanks");
	public static final Block edenGoldenWoodPlanks = new ZGBlockPlanks("goldenwoodplanks");
	public static final Block edenLovetreePlanks = new ZGBlockPlanks("lovetreeplanks");
	public static final Block blockCrater = new ZGBlockBase("crater_rock", 2.4F);
	public static final Block blockRedshroom = new BlockRedshroom();
	public static final Block blockRedshroomStem = new ZGBlockBase("redshroomstem", 0.6F).setBlockType(EnumBlockType.MUSHROOM);
	public static final Block edenAluminumOre = new ZGBlockOre("edenaluminumore", 1.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenSteelOre = new ZGBlockOre("edensteelore", 3.0F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenBronzeOre = new ZGBlockOre("edenbronzeore", 2.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenInvarOre = new ZGBlockOre("edeninvarore", 2.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenElectrumOre = new ZGBlockOre("edenelectrumore", 2.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenPlatinumOre = new ZGBlockOre("edenplatinumore", 4.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCoalOre = new ZGOreGem("edencoalore", 1.5F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCopperOre = new ZGBlockOre("edencopperore", 1.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenDeshOre = new ZGOreGem("edendeshore", 2.4F, MarsItems.marsItemBasic).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenDiamondOre = new ZGOreGem("edendiamondore", 2.0F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenEmeraldOre = new ZGOreGem("edenemeraldore", 2.5F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenGoldOre = new ZGBlockOre("edengoldore", 1.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenSilverOre = new ZGBlockOre("edensilverore", 1.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenIronOre = new ZGBlockOre("edenironore", 1.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenLapisOre = ((ZGBlockBase) new ZGOreGem("edenlapisore", 1.2F, Items.DYE).setDropMeta(4, true)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenMeteoricIronOre = new ZGOreGem("edenmeteoricironore", 3.4F, GCItems.meteoricIronRaw).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenRedstoneOre = new ZGOreGem("edenredstoneore", 1.6F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenTinOre = new ZGBlockOre("edentinore", 1.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenLeadOre = new ZGBlockOre("edenleadore", 1.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenNickelOre = new ZGBlockOre("edennickleore", 1.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenViriniumOre = new ZGOreGem("edenviriore", 2.6F, ZGItems.dustVirinium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCobaltOre = new ZGBlockOre("edencobaltore", 2.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenEveniumOre = new ZGBlockOre("edeneveniumore", 2.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenHeartiumOre = new ZGOreGem("edenheartiumore", 2.8F, ZGItems.heartium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	
	// Xathius
	public static final Block xathRock = new ZGBlockBase("xathrock");
	public static final Block xathCobble = new ZGBlockBase("xathcobblerock").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block xathStone = new ZGPlanetStone("xathstone", 3.1F, ZGBlocks.xathCobble);
	public static final Block xathRockBricks = new ZGBlockBase("xathrockbricks", 2.1F);
	public static final Block xathDirt = new ZGBlockDirt("xathdirt");
	public static final Block xathTallGrass = new ZGBlockTallGrass("xathtallgrass");
	public static final Block xathGrass = new ZGBlockGrassXath("xathgrass");
	public static final Block xathGravel = new ZGGravel("xathgravel");
	public static final Block xathPrometheanOre = ((ZGBlockOre) new ZGOreGem("xathprometheanore", 3.6F, ZGItems.prometheanCrystal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(true, 15);
	public static final Block xathEmeraldOre = ((ZGBlockOre) new ZGOreGem("xathemeraldore", 3.4F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldGivePotionEffect(true, MobEffects.INVISIBILITY);
	public static final Block xathDiamondOre = ((ZGBlockOre) new ZGOreGem("xathdiamondore", 3.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(true, 25);
	public static final Block xathRedstoneOre = ((ZGBlockOre) new ZGOreGem("xathredstoneore", 2.6F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldGivePotionEffect(true, MobEffects.NAUSEA);
	public static final Block xathIronOre = ((ZGBlockOre) new ZGBlockOre("xathironore", 3.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(true, 31);
	public static final Block xathGoldOre = ((ZGBlockOre) new ZGBlockOre("xathgoldore", 3.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldGivePotionEffect(true, MobEffects.HUNGER);
	public static final Block xathTinOre = ((ZGBlockOre) new ZGBlockOre("xathtinore", 3.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(true, 30);
	public static final Block xathAzuriteOre = new ZGOreGem("xathazuriteore", 9.6F, ZGItems.azurite).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block xathPlanks = new ZGBlockPlanks("xathplanks", 8.6F).setShouldAlwaysBurn(false).setResistance(10.0F);
	
	// Oasis
	public static final Block oasisRock = new ZGBlockBase("oasisrock");
	public static final Block oasisCobble = new ZGBlockBase("oasiscobblerock").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block oasisStone = new ZGPlanetStone("oasisstone", 2.6F, ZGBlocks.oasisCobble);
	public static final Block oasisRockBricks = new ZGBlockBase("oasisrockbricks", 2.1F);
	public static final Block oasisDirt = new ZGBlockDirt("oasisdirt");
	public static final Block oasisTallGrass = new ZGBlockTallGrass("oasistallgrass");
	public static final Block oasisGrass = new ZGBlockGrassOasis("oasisgrass");
	public static final Block oasisGravel = new ZGGravel("oasisgravel", 2.4F);
	public static final Block oasisSand = new ZGSand("oasissand");
	public static final Block oasisSuperChargedCoalOre = new ZGOreGem("oasissuperchargedcoalore", 4.6F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.OMNITOOL.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisCoalOre = new ZGOreGem("oasiscoalore", 2.1F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisIronOre = new ZGBlockOre("oasisironore", 2.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisGoldOre = new ZGBlockOre("oasisgoldore", 2.3F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisRedstoneOre = new ZGOreGem("oasisredstoneore", 3.5F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisDiamondOre = new ZGOreGem("oasisdiamondore", 4.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisTinOre = new ZGBlockOre("oasistinore", 2.3F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisLeadOre = new ZGBlockOre("oasisleadore", 2.9F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	
	// Xantheon
	public static final Block xantheonRock = new ZGBlockBase("xantheonrock", 5.1F);
	public static final Block xantheonChrome = new ZGBlockMetal("xantheonchrome", 4.2F);
	public static final Block xantheonStone = new ZGBlockBase("xantheonstone", 5.6F);
	public static final Block xantheonCoalOre = new ZGOreGem("xantheoncoalore", 5.6F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonIronOre = new ZGBlockOre("xantheonironore", 5.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonCopperOre = new ZGBlockOre("xantheoncopperore", 5.3F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonNickelOre = new ZGBlockOre("xantheonnickelore", 5.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonPlutoniumOre = new ZGOreGem("xantheonplutoniumore", 6.0F, ZGItems.plutoniumCrystal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonFueltoniumOre = new ZGOreGem("xantheonfueltoniumore", 6.1F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block xantheonAmaranthOre = new ZGBlockOre("xantheonamaranthore", 6.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonConstructBlock = new ZGBlockMetal("constructblock", 8.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	
	// Atheon
	public static final Block atheonRock = new ZGBlockMetal("atheonrock", 6.2F);
	public static final Block atheonLuxrock = new ZGBlockMetal("atheonluxrock", 6.3F);
	public static final Block atheonCobble = new ZGBlockBase("atheoncobble").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block atheonStone = new ZGPlanetStone("atheonstone", 4.5F, ZGBlocks.atheonCobble);
	public static final Block atheonRockBricks = new ZGBlockBase("atheonrockbricks", 6.5F).setLightLevel(1.0F);
	public static final Block atheonAmaranthOre = new ZGBlockOre("atheonamaranthore", 6.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonRedstoneOre = new ZGOreGem("atheonredstoneore", 5.6F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonTinOre = new ZGBlockOre("atheontinore", 5.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonDiamondOre = new ZGOreGem("atheondiamondore", 6.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonZollerniumOre = new ZGBlockOre("atheonzollerniumore", 7.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonZincOre = new ZGBlockOre("atheonzincore", 6.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonConstructBlock = new ZGBlockMetal("goldenconstructblock", 10.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	
	// Perdita
	public static final Block perdSand = new ZGSand("perdsand", 2.4F).setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdRock = new ZGBlockBase("perdrock").setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdTallGrass = new ZGBlockTallGrass("perdtallgrass");
	public static final Block perdDirt = ((ZGBlockBase) new ZGBlockDirt("perddirt").setLightLevel(0.5F)).setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdGrass = ((ZGBlockBase) new ZGBlockGrassPerdita("perdgrass").setLightLevel(0.7F)).setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCobble = new ZGBlockBase("perdcobble").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block perdStone = ((ZGBlockBase) new ZGPlanetStone("perdstone", 3.4F, ZGBlocks.perdCobble).setLightLevel(0.7F)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdRockBricks = ((ZGBlockBase) new ZGBlockBase("perdrockbricks", 3.6F).setLightLevel(1.0F)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdGravel = new ZGGravel("perdgravel").setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCreepDirt = new ZGBlockDirt("perdcreepdirt").setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdSoil = new ZGBlockDirt("perdsoil").setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCreepStone = ((ZGBlockBase) new ZGPlanetStone("perdcreepstone").setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel())).setShouldExplode(true, 20);
	public static final Block perdGlowstone = new ZGShineBlock("perdglowstone", ZGItems.perdGlowdust).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCaveStone = new ZGPlanetStone("perdcavestone").setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCaveStoneBricks = new ZGBlockBase("perdcavestonebricks", 3.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdCactus = new LostCactus();
	public static final Block perdReeds = new LostReeds();
	public static final Block perdDeadBush = new ZGDeadBush("perddeadbush");
	public static final Block perdDiamondOre = new ZGOreGem("perddiamondore", 7.2F, ZGItems.perdDiamond).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdEtriumOre = new ZGOreGem("perdetriumore", 7.5F, ZGItems.perdEtrium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdIronOre = new ZGBlockOre("perdironore", 6.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdGoldOre = new ZGBlockOre("perdgoldore", 5.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdZollerniumOre = new ZGBlockOre("perdzollerniumore", 6.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block perdFueltoniumOre = new ZGOreGem("perdfueltoniumore", 7.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	
	// Altum
	public static final Block altumRock = new ZGBlockBase("altumrock", 2.5F);
	public static final Block altumSand = new ZGSand("altumsand", 1.5F);
	public static final Block altumDirt = new ZGBlockDirt("altumdirt", 0.4F);
	public static final Block altumCobble = new ZGBlockBase("altumcobble", 1.4F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block altumStone = new ZGPlanetStone("altumstone", 3.5F, ZGBlocks.altumCobble).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumGravel = new ZGGravel("altumgravel");
	public static final Block altumSeaweed = new ZGWaterGrass("seaweed");
	public static final Block altumCoalOre = new ZGOreGem("altumcoalore", 6.2F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumIronOre = new ZGBlockOre("altumironore", 5.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumGoldOre = new ZGBlockOre("altumgoldore", 5.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumRedstoneOre = new ZGOreGem("altumredstoneore", 6.2F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumDiamondOre = new ZGOreGem("altumdiamondore", 6.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumZollerniumOre = new ZGBlockOre("altumzollerniumore", 7.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumEveniumOre = new ZGBlockOre("altumeveniumore", 6.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumRhodiumOre = new ZGBlockOre("altumrhodiumore", 8.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block altumAmaranthOre = new ZGBlockOre("altumamaranthore", 4.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	
	// Caligro
	public static final Block caligroSurfaceRock = new ZGBlockBase("caligrosurfacerock", 3.2F);
	public static final Block caligroRock = new ZGBlockBase("caligrorock", 4.2F);
	public static final Block caligroDirt = new ZGBlockDirt("caligrodirt");
	public static final Block witherrack = new ZGBlockBase("witherrack", 3.5F);
	public static final Block caligroCobblestone = new ZGBlockBase("caligrocobblestone").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block caligroCobblestoneMossy = new ZGBlockBase("caligrocobblemossy").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block caligroStone = new ZGPlanetStone("caligrostone", ZGBlocks.caligroCobblestone).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroStoneBricks = new ZGBlockBase("caligrostonebricks");
	public static final Block caligroGravel = new ZGGravel("caligrogravel");
	public static final Block caligroCreepstone = ((ZGBlockBase) new ZGPlanetStone("creepstone").setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel())).setShouldExplode(true, 20);
	public static final Block caligroCreepdirt = new ZGBlockDirt("creepdirt").setBlockHarvestLevel(EnumHarvestToolZG.SHOVEL.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroWitheriteOre = new ZGOreGem("witheriteore", 6.2F, ZGItems.witherite).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroShiniumOre = new ZGBlockOre("caligroshiniumore", 5.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroSilverOre = new ZGBlockOre("caligrosilverore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroNickelOre = new ZGBlockOre("caligronickelore", 2.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroLeadOre = new ZGBlockOre("caligroleadore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroTinOre = new ZGBlockOre("caligrotinore", 1.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroCopperOre = new ZGBlockOre("caligrocopperore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroIronOre = new ZGBlockOre("caligroironore", 3.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroGoldOre = new ZGBlockOre("caligrogoldore", 2.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroAmaranthOre = new ZGBlockOre("caligroamaranthore", 2.F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroZincOre = new ZGBlockOre("caligrozincore", 2.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroRedstoneOre = new ZGOreGem("caligroredstoneore", 3.2F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroAmberOre = new ZGOreGem("caligroamberore", 6.2F, ZGItems.amber).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroTopazOre = new ZGOreGem("caligrotopazore", 6.2F, ZGItems.topaz).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroOpalOre = new ZGOreGem("caligroopalore", 6.2F, ZGItems.opal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroAquamarineOre = new ZGOreGem("caligroaquaore", 6.2F, ZGItems.aquamarine).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroGarnetOre = new ZGOreGem("caligrogarnetore", 6.2F, ZGItems.garnet).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroSuperChargedCoalOre = new ZGOreGem("caligrosuperchargedcoalore", 6.2F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroFueltoniumOre = new ZGOreGem("caligrofueltoniumore", 6.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroDiamondOre = new ZGOreGem("caligrodiamondore", 3.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroEmeraldOre = new ZGOreGem("caligroemeraldore", 3.2F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroRadiumOre = new ZGOreGem("caligroradiumore", 8.2F, ZGItems.radium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroLapisOre = ((ZGBlockBase) new ZGOreGem("caligrolapisore", 3.2F, Items.DYE).setDropMeta(4, true)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroZollerniumOre = new ZGBlockOre("caligrozollerniumore", 3.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block caligroRubyOre = new ZGOreGem("caligrorubyore", 2.5F, ZGItems.ruby).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block spiderlingEgg = new BlockSpiderEgg();
	public static final Block shadowBossSpawner = new BlockShadowBossSpawner();
	
	// Caligro (Corruption)
	public static final Block corruptRock = new ZGCorruptBlock("corruptrock");
	public static final Block corruptCobble = new ZGCorruptBlock("corruptcobble").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block corruptStone = new ZGPlanetStoneCorrupted("corruptstone", corruptCobble);
	public static final Block corruptStoneBricks = new ZGCorruptBlock("corruptstonebricks");
	public static final Block corruptAscendiumOre = new ZGOreGemCorrupted("corruptascendiumore", 7.5F, ZGItems.ascendium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block corruptEtriumOre = new ZGOreGemCorrupted("corruptetriumore", 7.5F, ZGItems.perdEtrium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block corruptChargiumOre = new ZGBlockOreCorrupted("corruptchargiumore", 7.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block corruptCreepstone = new ZGCorruptBlock("corruptcreepstone");
	
	// Exodus
	public static final Block exodusTallGrass = new ZGBlockTallGrass("exodustallgrass");
	public static final Block exodusDirt = new ZGBlockDirt("exodusdirt");
	public static final Block exodusGrass = new ZGBlockGrassExodus("exodusgrass");
	public static final Block exodusCobblestone = new ZGBlockBase("exoduscobblestone").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block exodusStone = new ZGPlanetStone("exodusstone", 6.5F, ZGBlocks.exodusCobblestone).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block exodusGravel = new ZGGravel("exodusgravel");
	public static final Block exodusRock = new ZGBlockBase("exodusrock", 1.2F);
	public static final Block exodusSand = new ZGSand("exosand", 2.4F);
	public static final Block exodusIronOre = new ZGBlockOre("exodusironore", 5.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block exodusGoldOre = new ZGBlockOre("exodusgoldore", 6.3F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block exodusDiamondOre = new ZGOreGem("exodusdiamondore", 7.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block exodusRedstoneOre = new ZGOreGem("exodusredstoneore", 4.1F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block exodusCopperOre = new ZGBlockOre("exoduscopperore", 3.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
	// Vortex
	public static final Block vortexSurfaceRock = new ZGBlockBase("vortexsurfacerock", 3.2F);
	public static final Block vortexCobblestone = new ZGBlockBase("vortexcobblestone").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block vortexStone = new ZGPlanetStone("vortexstone", 6.5F, ZGBlocks.vortexCobblestone).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexVoltRock = new ZGBlockBase("vortexvoltrock", 6.5F);
	public static final Block vortexIronOre = new ZGBlockOre("vortexironore", 5.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexGoldOre = new ZGBlockOre("vortexgoldore", 6.3F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexDiamondOre = new ZGOreGem("vortexdiamondore", 7.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexRedstoneOre = new ZGOreGem("vortexredstoneore", 4.1F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexSuperChargedCoalOre = ((ZGBlockBase) new ZGOreGem("vortexsuperchargedcoalore", 8.1F, ZGItems.superChargedCoal).setBlockTier(EnumBlockTier.FOUR)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexCopperOre = new ZGBlockOre("vortexcopperore", 3.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexFueltoniumOre = new ZGOreGem("vortexfueltoniumore", 6.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block vortexEveniumOre = new ZGBlockOre("vortexeveniumore", 7.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	
	// Harran / Metztli
	public static final Block harranSoil = new ZGBlockDirt("harransoil");
	public static final Block harranGrass = new ZGBlockGrassHarran("harrangrass");
	public static final Block harranGrassCherry = new ZGBlockCherryGrassHarran("harrancherrygrass");
	public static final Block harranAquamarineOre = new ZGOreGem("harranaquamarineore", 6.2F, ZGItems.aquamarine).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranAmberOre = new ZGOreGem("harranamberore", 6.2F, ZGItems.amber).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranZincOre = new ZGBlockOre("harranzincore", 6.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranGarnetOre = new ZGOreGem("harrangarnetore", 6.2F, ZGItems.garnet).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranSuperChargedCoalOre = new ZGOreGem("harransuperchargedcoalore", 5.8F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranSapphireOre = new ZGOreGem("harransapphireore", 3.2F, ZGItems.sapphire).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranOpalOre = new ZGOreGem("harranopalore", 6.2F, ZGItems.opal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranRubyOre = new ZGOreGem("harranrubyore", 6.2F, ZGItems.ruby).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranAmaranthOre = new ZGBlockOre("harranamaranthore", 4.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranTopazOre = new ZGOreGem("harrantopazore", 6.2F, ZGItems.topaz).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	public static final Block harranFueltoniumOre = new ZGOreGem("harranfueltoniumore", 8.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	
	// Astros (Moon)
	public static final Block astrosRock = new ZGBlockBase("astrosrock", 2.4F);
	public static final Block astrosDirt = new ZGBlockDirt("astrosdirt");
	public static final Block astrosGravel = new ZGGravel("astrosgravel", 3.4F);
	public static final Block astrosCobblestone = new ZGBlockBase("astroscobblestone").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block astrosStone = new ZGPlanetStone("astrosstone", 4.5F, ZGBlocks.astrosCobblestone);
	public static final Block astrosIce = new ZGBlockIce("astrosice");
	public static final Block astrosIronOre = new ZGBlockOre("astrosironore", 3.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosGoldOre = new ZGBlockOre("astrosgoldore", 3.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosDiamondOre = new ZGOreGem("astrosdiamondore", 6.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosEmeraldOre = new ZGOreGem("astrosemeraldore", 6.2F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosRedstoneOre = new ZGOreGem("astrosredstoneore", 4.1F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosCoalOre = new ZGOreGem("astroscoalore", 6.2F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosSuperChargedCoalOre = new ZGOreGem("astrossuperchargedcoalore", 8.2F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosSapphireOre = new AstrosSapphireOre();
	public static final Block astrosTinOre = new ZGBlockOre("astrostinore", 1.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block astrosZollerniumOre = new ZGBlockOre("astroszollerniumore", 3.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
	// Centotl
	public static final Block centoRock = new ZGBlockBase("centorock", 6.8F);
	public static final Block centoCobblestone = new ZGBlockCobble("centocobblestone", 4.6F);
	public static final Block centoStone = new ZGPlanetStone("centostone", ZGBlocks.centoCobblestone);
	public static final Block centoDirt = new ZGBlockDirt("centodirt", 3.2F);
	public static final Block centoGravel = new ZGGravel("centogravel", 2.1F);
	public static final Block centoShiniumOre = new ZGBlockOre("centoshiniumore", 8.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block centoGoldOre = new ZGBlockOre("centogoldore", 5.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block centoIronOre = new ZGBlockOre("centoironore", 4.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block centoFueltoniumOre = new ZGBlockOre("centofueltoniumore", 7.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block centoZollerniumOre = new ZGBlockOre("centozollerniumore", 6.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block facehuggerEgg = new BlockFacehuggerEgg();
	
	// Toci
	public static final Block tociSand = new ZGSand("tocisand", 6.4F);
	public static final Block tociStarSand = new ZGSand("tocistarsand", 4.6F);
	public static final Block tociDirt = new ZGBlockDirt("tocidirt");
	public static final Block tociRock = new ZGBlockBase("tocirock", 2.4F);
	public static final Block tociCobblestone = new ZGBlockCobble("tocicobblestone");
	public static final Block tociMossyCobblestone = new ZGBlockCobble("tocicobblestonemossy");
	public static final Block tociStone = new ZGPlanetStone("tocistone", ZGBlocks.tociCobblestone);
	public static final Block tociStoneBricks = new ZGShineBlock("tocistonebrick", 2.1F);
	public static final Block tociGravel = new ZGGravel("tocigravel", 4.5F);
	public static final Block tociNickelOre = new ZGBlockOre("tocinickelore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociTinOre = new ZGBlockOre("tocitinore", 1.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociBronzeOre = new ZGBlockOre("tocibronzeore", 6.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociSilverOre = new ZGBlockOre("tocisilverore", 5.6F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociLeadOre = new ZGBlockOre("tocileadore", 4.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociCopperOre = new ZGBlockOre("tocicopperore", 1.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociZincOre = new ZGBlockOre("tocizincore", 8.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociSuperChargedCoalOre = new ZGOreGem("tocisupercoalore", 4.2F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociRedstoneOre = new ZGBlockOre("tociredstoneore", 3.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociGoldOre = new ZGBlockOre("tocigoldore", 2.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociAmaranthOre = new ZGBlockOre("tociamaranthore", 4.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociIronOre = new ZGBlockOre("tociironore", 2.0F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociEmeraldOre = new ZGOreGem("tociemeraldore", 6.2F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociCoalOre = new ZGOreGem("tocicoalore", 1.4F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociFueltoniumOre = new ZGOreGem("tocifueltoniumore", 7.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociDiamondOre = new ZGOreGem("tocidiamondore", 6.4F, Items.EMERALD).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	public static final Block tociQuartzOre = new ZGOreGem("tociquartzore", 7.5F, Items.QUARTZ).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZOLLERNIUM.getHarvestLevel());
	
	// Tlaloc
	public static final Block tlalocRock = new ZGBlockBase("tlalocrock", 9.4F);
	public static final Block tlalocChrome = new ZGBlockBase("tlalocchrome", 9.6F);
	public static final Block tlalocMechRock = new ZGBlockBase("tlalocmechrock", 9.2F);
	public static final Block tlalocDungeonBricks = new ZGBlockBase("tlalocdungeonbricks");
	public static final Block tlalocStone = new ZGPlanetStone("tlalocstone", 6.4F);
	public static final Block tlalocRedstoneOre = new ZGBlockOre("tlalocredstoneore", 3.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block tlalocZollerniumOre = new ZGBlockOre("tlaloczollerniumore", 7.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block tlalocShiniumOre = new ZGBlockOre("tlalocshiniumore", 4.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block tlalocSuperChargedCoalOre = ((ZGBlockOre) new ZGOreGem("tlalocsuperchargedcoalore", 4.2F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel())).setBlockTier(EnumBlockTier.FOUR);
	public static final Block tlalocFueltoniumOre = ((ZGBlockOre) new ZGOreGem("tlalocfueltoniumore", 8.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel())).setBlockTier(EnumBlockTier.FOUR);
	public static final Block tlalocQuartzOre = ((ZGBlockOre) new ZGOreGem("tlalocquartzore", 6.8F, Items.QUARTZ).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel())).setBlockTier(EnumBlockTier.FOUR);
	public static final Block tlalocCertusQuartzOre = new ZGBlockOre("tlaloccertusquartzore", 5.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block tlalocFluixOre = new ZGBlockOre("tlalocfluixore", 6.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block tlalocPlutoniumOre = new ZGBlockOre("tlalocplutoniumore", 7.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
	// Kronos
	public static final Block netherDirt = new ZGBlockDirt("netherdirt", 4.2F).setShouldAlwaysBurn(true);
	public static final Block magmaSlimeBlock = new ZGBlockMagmaSlime();
	public static final Block netherCoalOre = (((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("nethercoalore", 6.2F, Items.COAL).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 65));
	public static final Block netherFueltoniumOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("netherfueltoniumore", 8.2F, ZGItems.dustFueltonium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 85);
	public static final Block netherIronOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("netherironore", 4.1F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 25);
	public static final Block netherShiniumOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethershiniumore", 8.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 35);
	public static final Block netherSilverOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethersilverore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 5);
	public static final Block netherNickleOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethernickelore", 6.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 45);
	public static final Block netherLeadOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("netherleadore", 7.2F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 15);
	public static final Block netherTinOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethertinore", 3.4F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 5);
	public static final Block netherCopperOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethercopperore", 3.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 6);
	public static final Block netherLapisOre = ((ZGBlockBase) ((ZGBlockOre) ((ZGBlockBase) new ZGOreGem("netherlapisore", 3.2F, Items.DYE).setDropMeta(4, true)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldExplode(true, 1);
	public static final Block netherDiamondOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("netherdiamondore", 7.2F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 75);
	public static final Block netherEmeraldOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("netheremeraldore", 7.8F, Items.DIAMOND).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 95);
	public static final Block netherRedstoneOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("netherredstoneore", 4.1F, Items.REDSTONE).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 86);
	public static final Block netherGoldOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethergoldore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 50);
	public static final Block netherSteelOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("nethersteelore", 7.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 25);
	public static final Block netherRubyOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("netherrubyore", 2.2F, ZGItems.ruby).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 5);
	public static final Block netherSapphireOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("nethersapphireore", 2.4F, ZGItems.sapphire).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 6);
	public static final Block netherZincOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("netherzincore", 4.5F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 35);
	public static final Block netherAmaranthOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("netheramaranthore", 6.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 65);
	public static final Block netherSuperChargedCoalOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("nethersuperchargedcoalore", 8.2F, ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 99);
	public static final Block netherZaniumOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("zaniumore", 9.6F, ZGItems.zanium).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 90);
	public static final Block netherRaditeOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("raditeore", 9.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZANIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 5);
	public static final Block netherZogiteOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGBlockOre("zogiteore", 9.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.ZANIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(true, 5);
	public static final Block netherAzuriteOre = ((ZGBlockBase) ((ZGBlockBase) ((ZGBlockOre) new ZGOreGem("azuriteore", 2.4F, ZGItems.azurite).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setBlockTier(EnumBlockTier.FIVE)).setShouldAlwaysBurn(true)).setShouldExplode(false);
	
	// Ares
	// TODO
	
	// Icarus
	// TODO
	
	// Prometheus
	// TODO
	
	// Maveth
	public static final Block mavethSand = new ZGSand("mavethsand", 3.4F);
	public static final Block mavethRock = new ZGBlockBase("mavethrock", 6.2F);
	public static final Block mavethCobblestone = new ZGBlockCobble("mavethcobblestone", 3.4F);
	public static final Block mavethGravel = new ZGGravel("mavethgravel", 3.4F);
	public static final Block mavethInfectedSoil = new ZGInfectedDirt("infectedsoil");
	public static final Block mavethInfectedGrass = new ZGInfectedGrass("infectedgrass");
	public static final Block mavethInfectedTallGrass = new ZGBlockInfectedTallGrass("infectedtallgrass");
	// TODO
	
	public static final Block mavethStoneBricks = new ZGBlockBase("mavethstonebricks", 4.8F);
	public static final Block mavethStone = new ZGPlanetStone("mavethstone", 4.6F, ZGBlocks.mavethCobblestone).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.SAPPHIRE.getHarvestLevel());
	public static final Block mavethIronOre = new ZGBlockOre("mavethironore", 4.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block mavethElectrumOre = new ZGBlockOre("mavethelectrumore", 5.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block mavethAmaranthOre = new ZGBlockOre("mavethamaranthore", 5.8F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block mavethZollerniumOre = new ZGBlockOre("mavethzollerniumore", 6.7F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block mavethVibraniumOre = new ZGBlockOre("mavethvibraniumore", 9.9F).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
	// Asgard
	// TODO
	
	// Chroma Grass
	public static final Block chromaSoil = new ZGBlockDirt("chromasoil");
	public static final Block chromaGrassPink = new ZGChromaGrass("chroma_grass_pink");
	public static final Block chromaGrassBlue = new ZGChromaGrass("chroma_grass_blue");
	public static final Block chromaGrassGreen = new ZGChromaGrass("chroma_grass_green");
	public static final Block chromaGrassYellow = new ZGChromaGrass("chroma_grass_yellow");
	public static final Block chromaGrassRed = new ZGChromaGrass("chroma_grass_red");
	
	// Metals
	public static final Block blockViri = new ZGBlockMetal("viriblock");
	public static final Block blockEve = new ZGBlockMetal("eveniumblock");
	public static final Block blockCobalt = new ZGBlockMetal("cobaltblock");
	public static final Block blockPromethean = new ZGBlockMetal("prometheanblock");
	public static final Block blockSuperChargedCoal = new ZGBlockBase("superchargedcoalblock", 2.6F);
	public static final Block blockPlutonium = new ZGBlockMetal("plutoniumblock", 4.5F);
	public static final Block blockFueltonium = new ZGBlockMetal("fueltoniumblock", 3.2F);
	public static final Block blockChargium = new ZGBlockMetal("chargiumblock", 5.2F).setLightLevel(1.0F);
	public static final Block blockShinium = new ZGBlockMetal("shiniumblock", 2.3F).setLightLevel(1.0F);
	public static final Block blockAmaranth = new ZGBlockMetal("amaranthblock", 2.4F);
	public static final Block blockAzurite = new ZGBlockMetal("azuriteblock", 2.1F).setLightLevel(1.0F);
	public static final Block blockZollernium = new ZGBlockMetal("zollerniumblock", 2.5F);
	public static final Block blockZinc = new ZGBlockMetal("zincblock", 2.6F);
	public static final Block blockPerdDiamond = new ZGBlockMetal("perddiamondblock", 4.5F);
	public static final Block blockPerdEtrium = new ZGBlockMetal("perdetriumblock", 6.2F);
	public static final Block blockZucrite = new ZGBlockMetal("zucriteblock", 8.4F);
	public static final Block blockRhodium = new ZGBlockMetal("rhodiumblock", 9.2F);
	public static final Block blockAmber = new ZGBlockMetal("amberblock");
	public static final Block blockTopaz = new ZGBlockMetal("topazblock");
	public static final Block blockOpal = new ZGBlockMetal("opalblock");
	public static final Block blockAquamarine = new ZGBlockMetal("aquamarineblock");
	public static final Block blockGarnet = new ZGBlockMetal("garnetblock");
	public static final Block blockRuby = new ZGBlockMetal("rubyblock");
	public static final Block blockSapphire = new ZGBlockMetal("sapphireblock");
	public static final Block blockAmberStatic = new ZGBlockMetalShine("staticamberblock");
	public static final Block blockAquamarineIcy = new ZGBlockMetalShine("icyaquablock");
	public static final Block blockGarnetFire = new ZGBlockMetalShine("firegarnetblock");
	public static final Block blockWitherite = new ZGBlockMetal("witheriteblock");
	public static final Block blockRadium = new ZGBlockMetal("radiumblock");
	public static final Block blockNetheridium = new ZGBlockMetal("netheridiumblock");
	public static final Block blockNetherizedObsidian = new ZGBlockMetal("netherizedobsidian");
	public static final Block blockRedObsidian = new ZGBlockMetalShine("redobsidian");
	public static final Block blockShadowBone = new ZGBlockMetal("shadowboneblock");
	public static final Block blockZanium = new ZGBlockMetal("zaniumblock");
	public static final Block blockRadite = new ZGBlockMetal("raditeblock");
	public static final Block blockZogite = new ZGBlockMetal("zogiteblock");
	public static final Block blockZogradite = new ZGBlockMetal("zograditeblock");
	public static final Block blockVibranium = new ZGBlockMetal("vibraniumblock");
	
	// Glow Blocks
	public static final Block blockShinestone = new ZGShineBlock("shinestone", 1.6F, ZGItems.dustShinestone);
	public static final Block blockShinestoneCrystal = new ZGShineBlock("shinestonecrystal", 1.8F);
	public static final Block blockShinestonePolished = new ZGShineBlock("polishedshinestone", 1.4F);
	public static final Block blockShinestoneCrystalBricks = new ZGShineBlock("shinestonecrystalbricks", 2.4F);
	
	// Compressed Metal Blocks
	public static final Block blockCompressedHeartium = new ZGBlockCompressed("compressedheartiumblock");
	public static final Block blockCompressedViri = new ZGBlockCompressed("compressedviriniumblock");
	public static final Block blockCompressedEve = new ZGBlockCompressed("compressedeveniumblock");
	public static final Block blockCompressedCobalt = new ZGBlockCompressed("compressedcobaltblock");
	public static final Block blockCompressedPromethean = new ZGBlockCompressed("compressedprometheanblock");
	public static final Block blockCompressedSuperChargedCoal = new ZGBlockCompressed("compressedsuperchargedcoalblock");
	public static final Block blockCompressedZucrite = new ZGBlockCompressed("compressedzucriteblock");
	public static final Block blockCompressedRhodium = new ZGBlockCompressed("compressedrhodiumblock");
	
	// Candy Blocks
	public static final Block candyCubeWhite = new CandyCubeBlock("white");
	public static final Block candyCubeBlack = new CandyCubeBlock("black");
	public static final Block candyCubeGray = new CandyCubeBlock("gray");
	public static final Block candyCubeOrange = new CandyCubeBlock("orange");
	public static final Block candyCubeBrown = new CandyCubeBlock("brown");
	public static final Block candyCubeRed = new CandyCubeBlock("red");
	public static final Block candyCubeBlue = new CandyCubeBlock("blue");
	public static final Block candyCubeYellow = new CandyCubeBlock("yellow");
	public static final Block candyCubePurple = new CandyCubeBlock("purple");
	public static final Block candyCubeCyan = new CandyCubeBlock("cyan");
	public static final Block candyCubePink = new CandyCubeBlock("pink");
	public static final Block candyCubeGreen = new CandyCubeBlock("green");
	
	// Sweet Blocks
	public static final Block blockChocolate = new ZGBlockBase("chocolateblock", 1.6F).setBlockType(EnumBlockType.SWEET);
	public static final Block blockChocolateBricks = new ZGBlockBase("chocolatebricks", 1.8F).setBlockType(EnumBlockType.SWEET);
	public static final Block blockCookie = new CookieBlock();
	public static final Block blockBrownie = ((ZGBlockBase) ((ZGBlockBase) new ZGBlockBase("brownieblock", 1.8F).setMaterial(Material.CLOTH)).setSound(SoundType.CLOTH)).setBlockType(EnumBlockType.SWEET);
	public static final Block blockIceCreamSandwich = new IceCreamSandwichBlock();
	public static final Block blockSugarCube = new ZGBlockBase("sugarcube", 0.6F).setBlockType(EnumBlockType.SWEET);
	
	// Space Station Blocks
	public static final Block blockSpaceStation = new ZGBlockBase("spacestationblock", 1.5F).setBlockType(EnumBlockType.SPACE);
	public static final Block blockOutpost = new BlockOutpost();
	public static final Block blockLore = new LoreBlock();
	
	// Station Blocks
	public static final Block blockBlueprintStation = new BlockBlueprintStation();
	public static final Block blockHealingStation = new BlockHealingStation();
	
	// Crystal Blocks
	public static final Block blockCrystalsPlutonium = new ZGCrystalBlock("plutoniumcrystals", ZGItems.plutoniumCrystal);
	public static final Block blockCrystalsStorm = new BlockStormCrystals();
	public static final Block blockCrystalsEden = new ZGCrystalBlock("edencrystals", ZGItems.edenCrystal);
	
	// Ingot Stacks
	public static final Block blockIngotStackIron = new BlockIngotStack("iron", Items.IRON_INGOT);
	// public static final Block blockIngotStackGold = new BlockIngotStack2("gold",
	// Items.GOLD_INGOT);
	
	// Sirens
	public static final Block ironSirenON = new BlockIronSiren("ironsiren_on", ZGSoundEvents.ALARM_IRON, true);
	public static final Block ironSiren = new BlockIronSiren("ironsiren", ZGSoundEvents.ALARM_IRON, false);
	
	public static final Block goldSirenON = new BlockGoldSiren("goldsiren_on", ZGSoundEvents.ALARM_GOLD, true);
	public static final Block goldSiren = new BlockGoldSiren("goldsiren", ZGSoundEvents.ALARM_GOLD, false);
	
	public static final Block diamondSirenON = new BlockDiamondSiren("diamondsiren_on", ZGSoundEvents.ALARM_DIAMOND, true);
	public static final Block diamondSiren = new BlockDiamondSiren("diamondsiren", ZGSoundEvents.ALARM_DIAMOND, false);
	
	public static final Block emeraldSirenON = new BlockEmeraldSiren("emeraldsiren_on", ZGSoundEvents.ALARM_EMERALD, true);
	public static final Block emeraldSiren = new BlockEmeraldSiren("emeraldsiren", ZGSoundEvents.ALARM_EMERALD, false);
	
	// Chests
	public static final Block treasureChestT10 = new ZGBlockTreasureChestTier10();
	public static final Block treasureChestT4 = new ZGBlockTreasureChestTier4();
	
	// Boss Spawners
	public static final Block TLALOC_SPAWNER = new ZGBlockBossSpawnerTlaloc();
	public static final Block EDEN_SPAWNER = new ZGBlockBossSpawnerEden();
	
	//
	public static final Block mudClayBlock = new BlockMudClay();
	
	// Crops
	public static final Block cropStrawberry = new BlockCropStrawberry();
	public static final Block cropBlackberry = new BlockCropBlackberry();
	public static final Block cropBlueberry = new BlockCropBlueberry();
	public static final Block cropGrape = new BlockCropGrape();
	public static final Block cropTomato = new BlockCropTomato();
	public static final Block cropCorn = new BlockCropCorn();
	public static final Block cropCucumber = new BlockCropCucumber();
	public static final Block cropRadish = new BlockCropRadish();
	public static final Block cropOnion = new BlockCropOnion();
	public static final Block cropPea = new BlockCropPeas();
	public static final Block cropGarlic = new BlockCropGarlic();
	public static final Block cropGhostPepper = new BlockNetherCropGhostPepper();
	
	public static void init() {
		ZGBlocks.registerTileEntities();
		
		try {
			ZGBlocks.initSpawnerBlocks();
		} catch (NoSuchMethodException e) {
			ZGHelper.LogErr("Error initializing spawner blocks!");
			e.printStackTrace();
		}
		
		ZGBlocks.registerBlocks(edenLovetreeSapling, edenGoldenWoodSapling, edenParadiseWoodSapling, edenWoodSapling, edenFruit, edenFlower, edenFlowerBlack, edenFlowerBlue, edenFlowerCyan, edenFlowerGreen, edenFlowerOrange, edenFlowerPink, edenFlowerPurple, edenFlowerRed, edenFlowerYellow, edenFlowerWhite, oasisFlower, exodusFlower, zolStone, zolCobbleRock, zolSurfaceRock,
				zolRoyalRock, zolSnow, zolIce, zolDirt, zolGravel, zolRockBricks, zolCoalOre, zolCopperOre, zolGoldOre, zolHeartOre, zolTinOre, zolIronOre, zolCrystals);
		
		ZGBlocks.registerBlocks(kriffSurfaceRock, kriffStone, kriffCobbleRock, kriffDirt, kriffRockBricks, kriffMagmaRock, blazeRock, kriffCoalOre, kriffCopperOre, kriffIronOre, kriffGoldOre, kriffRedstoneOre, kriffCobaltOre);
		
		ZGBlocks.registerBlocks(purgCobbleRock, purgStone, purgRockBricks, purgWhiteRock, purgBlackRock, purgSurfaceRock, purgDirt, purgGravel, purgMeteoricIronOre, purgCobaltOre, purgIronOre, purgGoldOre, purgCopperOre, purgDiamondOre, purgEmeraldOre, purgEveniumOre, purgAluminumOre, purgTinOre, purgLeadOre, purgRedstoneOre, edenSurfaceRock, edenTallGrass, edenGrass, edenSoil,
				edenStone, edenSacredStone, edenCobbleRock, edenRockBricks, edenGoldenGrass, edenFallGrass, edenSwampGrass, edenSnow, edenWinterRock, edenBloodSand, edenBloodStone, edenBoneStone, edenGravel, edenBrightStone, edenWoodLog, edenWoodLeaves, edenWoodPlanks, edenParadiseWoodLog, edenParadiseWoodLeaves, edenParadiseWoodPlanks, edenGoldenWoodLog, edenGoldenWoodLeaves,
				edenGoldenWoodPlanks, edenLovetreeLog, edenLovetreeLeaves, edenLovetreePlanks, edenDungeonBricks, edenAluminumOre, edenSteelOre, edenBronzeOre, edenInvarOre, edenElectrumOre, edenPlatinumOre, edenCoalOre, edenCopperOre, edenDeshOre, edenDiamondOre, edenEmeraldOre, edenGoldOre, edenSilverOre, edenIronOre, edenLapisOre, edenMeteoricIronOre, edenRedstoneOre,
				edenTinOre, edenLeadOre, edenNickelOre, edenViriniumOre, edenCobaltOre, edenEveniumOre, edenHeartiumOre, xathRock, xathCobble, xathStone, xathRockBricks, xathGrass, xathDirt, xathGravel, xathTallGrass, xathPrometheanOre, xathEmeraldOre, xathDiamondOre, xathRedstoneOre, xathIronOre, xathGoldOre, xathTinOre, xathAzuriteOre, xathPlanks, oasisRock, oasisStone,
				oasisRockBricks, oasisCobble, oasisDirt, oasisTallGrass, oasisGrass, oasisGravel, oasisSand, oasisSuperChargedCoalOre, oasisCoalOre, oasisIronOre, oasisGoldOre, oasisRedstoneOre, oasisDiamondOre, oasisTinOre, oasisLeadOre, xantheonRock, xantheonChrome, xantheonStone, xantheonCoalOre, xantheonIronOre, xantheonCopperOre, xantheonNickelOre, xantheonPlutoniumOre,
				xantheonFueltoniumOre, xantheonAmaranthOre, xantheonConstructBlock, atheonRock, atheonLuxrock, atheonStone, atheonCobble, atheonRockBricks, atheonAmaranthOre, atheonRedstoneOre, atheonTinOre, atheonDiamondOre, atheonZollerniumOre, atheonZincOre, atheonConstructBlock, chromaSoil, chromaGrassPink, chromaGrassBlue, chromaGrassGreen, chromaGrassYellow,
				chromaGrassRed, blockViri, blockCobalt, blockEve, blockPromethean, blockCrater, blockRedshroom, blockRedshroomStem, blockSuperChargedCoal, blockPlutonium, blockFueltonium, blockChargium, blockShinium, blockAmaranth, blockAzurite, blockZollernium, blockZinc, blockPerdDiamond, blockPerdEtrium, blockZucrite, blockRhodium, blockAmber, blockTopaz, blockOpal,
				blockAquamarine, blockGarnet, blockRuby, blockSapphire, blockAmberStatic, blockAquamarineIcy, blockGarnetFire, blockWitherite, blockRadium, blockNetheridium, blockNetherizedObsidian, blockRedObsidian, blockShadowBone, blockZanium, blockRadite, blockZogite, blockZogradite, blockVibranium, blockShinestone, blockShinestoneCrystal, blockShinestonePolished,
				blockShinestoneCrystalBricks, blockCompressedHeartium, blockCompressedViri, blockCompressedEve, blockCompressedCobalt, blockCompressedPromethean, blockCompressedSuperChargedCoal, blockCompressedZucrite, blockCompressedRhodium, candyCubeWhite, candyCubeBlack, candyCubeGray, candyCubeOrange, candyCubeBrown, candyCubeRed, candyCubeBlue, candyCubeYellow,
				candyCubePurple, candyCubeCyan, candyCubePink, candyCubeGreen, blockChocolate, blockChocolateBricks, blockCookie, blockBrownie, blockIceCreamSandwich, blockSugarCube, blockSpaceStation, blockOutpost, blockLore, perdSand, perdRock, perdStone, perdCobble, perdRockBricks, perdGravel, perdCreepDirt, perdSoil, perdDirt, perdTallGrass, perdGrass, perdCreepStone,
				perdGlowstone, perdCaveStone, perdCaveStoneBricks, perdCactus, perdReeds, perdDeadBush, perdDiamondOre, perdEtriumOre, perdIronOre, perdGoldOre, perdZollerniumOre, perdFueltoniumOre, perdTreeSapling, perdWoodLogs, perdWoodLeaves, perdWoodPlanks, altumRock, altumSand, altumDirt, altumCobble, altumStone, altumGravel, altumSeaweed, altumCoalOre, altumIronOre,
				altumGoldOre, altumRedstoneOre, altumDiamondOre, altumZollerniumOre, altumEveniumOre, altumRhodiumOre, altumAmaranthOre, caligroSurfaceRock, caligroRock, caligroCobblestone, caligroCobblestoneMossy, caligroStone, caligroStoneBricks, caligroGravel, caligroDirt, witherrack, caligroCreepstone, caligroCreepdirt, caligroWitheriteOre, caligroShiniumOre,
				caligroSilverOre, caligroNickelOre, caligroLeadOre, caligroTinOre, caligroCopperOre, caligroIronOre, caligroGoldOre, caligroRedstoneOre, caligroAmaranthOre, caligroZincOre, caligroAmberOre, caligroTopazOre, caligroOpalOre, caligroAquamarineOre, caligroGarnetOre, caligroSuperChargedCoalOre, caligroFueltoniumOre, caligroDiamondOre, caligroEmeraldOre,
				caligroRadiumOre, caligroLapisOre, caligroZollerniumOre, caligroRubyOre, spiderlingEgg, shadowBossSpawner, corruptRock, corruptCobble, corruptStone, corruptStoneBricks, corruptAscendiumOre, corruptEtriumOre, corruptChargiumOre, corruptCreepstone, exodusTallGrass, exodusDirt, exodusGrass, exodusCobblestone, exodusStone, exodusGravel, exodusRock, exodusSand,
				exodusIronOre, exodusGoldOre, exodusDiamondOre, exodusRedstoneOre, exodusCopperOre, exoWoodLogs, exoWoodLeaves, exoWoodPlanks, exoWoodSapling, cherryWoodLog, bananaLog, guavaLog, peachLog, grapefruitLog, orangeLog, lemonLog, limeLog, limonLog, xathWoodLog, cherryWoodLeaves, bananaLeaves, guavaLeaves, peachLeaves, grapefruitLeaves, orangeLeaves, lemonLeaves,
				limeLeaves, limonLeaves, xathWoodLeaves, cherryWoodPlanks, bananaPlanks, guavaPlanks, peachPlanks, orangePlanks, grapefruitPlanks, lemonPlanks, limePlanks, limonPlanks, cherryWoodSapling, bananaSapling, guavaSapling, peachSapling, grapefruitSapling, orangeSapling, lemonSapling, limeSapling, limonSapling, xathWoodSapling, vortexSurfaceRock, vortexCobblestone,
				vortexStone, vortexVoltRock, vortexIronOre, vortexGoldOre, astrosRock, astrosDirt, astrosGravel, astrosCobblestone, astrosStone, astrosIce, astrosIronOre, astrosGoldOre, astrosDiamondOre, astrosEmeraldOre, astrosRedstoneOre, astrosCoalOre, astrosSuperChargedCoalOre, astrosTinOre, astrosZollerniumOre, astrosSapphireOre, centoRock, centoCobblestone, centoStone,
				centoDirt, centoGravel, centoShiniumOre, centoGoldOre, centoIronOre, centoFueltoniumOre, centoZollerniumOre, vortexDiamondOre, vortexRedstoneOre, vortexCopperOre, vortexSuperChargedCoalOre, vortexFueltoniumOre, vortexEveniumOre, harranGrass, harranGrassCherry, harranSoil, harranAquamarineOre, harranAmberOre, harranZincOre, harranGarnetOre,
				harranSuperChargedCoalOre, harranSapphireOre, harranOpalOre, harranRubyOre, harranAmaranthOre, harranTopazOre, harranFueltoniumOre, blockBlueprintStation, blockHealingStation, blockCrystalsPlutonium, blockCrystalsStorm, blockCrystalsEden, blockIngotStackIron, ironSirenON, goldSirenON, diamondSirenON, emeraldSirenON, ironSiren, goldSiren, diamondSiren,
				emeraldSiren, facehuggerEgg);
		//
		ZGBlocks.registerBlocks(tociSand, tociStarSand, tociDirt, tociRock, tociCobblestone, tociMossyCobblestone, tociStone, tociStoneBricks, tociGravel, tociNickelOre, tociTinOre, tociBronzeOre, tociSilverOre, tociLeadOre, tociCopperOre, tociZincOre, tociSuperChargedCoalOre, tociRedstoneOre, tociGoldOre, tociAmaranthOre, tociIronOre, tociEmeraldOre, tociCoalOre,
				tociFueltoniumOre, tociDiamondOre, tociQuartzOre);
		//
		//
		ZGBlocks.registerBlocks(tlalocRock, tlalocChrome, tlalocMechRock, tlalocDungeonBricks, tlalocStone, tlalocRedstoneOre, tlalocFueltoniumOre, tlalocShiniumOre, tlalocZollerniumOre, tlalocSuperChargedCoalOre, tlalocQuartzOre, tlalocCertusQuartzOre, tlalocFluixOre, tlalocPlutoniumOre, mudClayBlock);
		//
		//
		ZGBlocks.registerBlocks(netherDirt, magmaSlimeBlock, netherCoalOre, netherFueltoniumOre, netherIronOre, netherShiniumOre, netherNickleOre, netherSilverOre, netherLeadOre, netherTinOre, netherCopperOre, netherLapisOre, netherDiamondOre, netherEmeraldOre, netherRedstoneOre, netherGoldOre, netherSteelOre, netherRubyOre, netherSapphireOre, netherZincOre, netherAmaranthOre,
				netherSuperChargedCoalOre, netherZaniumOre, netherRaditeOre, netherZogiteOre, netherAzuriteOre);
		//
		//
		ZGBlocks.registerBlocks(mavethSand, mavethRock, mavethGravel, mavethInfectedGrass, mavethInfectedSoil, mavethInfectedTallGrass, mavethStoneBricks, mavethCobblestone, mavethStone, mavethIronOre, mavethElectrumOre, mavethAmaranthOre, mavethZollerniumOre, mavethVibraniumOre);
		//
		// Farmable Crops
		ZGBlocks.registerBlocks(cropStrawberry, cropBlackberry, cropBlueberry, cropGrape, cropTomato, cropCorn, cropCucumber, cropRadish, cropOnion, cropPea, cropGarlic, cropGhostPepper);
		//
		// Dungeon Chests
		ZGBlocks.addBlockItemDesc(treasureChestT10);
		ZGBlocks.addBlockItemDesc(treasureChestT4);
		//
		//
		ZGHelper.Log("Loaded a total of " + totalBlocks + " new blocks.");
	}
	
	public static void initSpawnerBlocks() throws NoSuchMethodException {
		registerSpecialBlock(TLALOC_SPAWNER, ItemBlockDefaultZG.class, "boss_spawner_t1");
		registerSpecialBlock(EDEN_SPAWNER, ItemBlockDefaultZG.class, "boss_spawner_t4");
	}
	
	private static void addBlock(Block block) {
		CommonZGRegisterHelper.registerBlock(block);
		totalBlocks++;
	}
	
	private static void addBlockItemDesc(Block block) {
		CommonZGRegisterHelper.registerBlock(block, ItemBlockDesc::new);
		totalBlocks++;
	}
	
	private static void registerBlocks(Block... blocks) {
		for (Block b : blocks) {
			ZGBlocks.addBlock(b);
		}
	}
	
	public static void registerSpecialBlock(Block block, Class<? extends ItemBlock> itemclass, String name, Object... itemCtorArgs) throws NoSuchMethodException {
		if (block.getRegistryName() == null) {
			block.setRegistryName(name);
		}
		core.blocksList.add(block);
		if (itemclass != null) {
			ItemBlock item = null;
			Class<?>[] ctorArgClasses = new Class<?>[itemCtorArgs.length + 1];
			ctorArgClasses[0] = Block.class;
			for (int idx = 1; idx < ctorArgClasses.length; idx++) {
				ctorArgClasses[idx] = itemCtorArgs[idx - 1].getClass();
			}
			
			try {
				Constructor<? extends ItemBlock> constructor = itemclass.getConstructor(ctorArgClasses);
				item = constructor.newInstance(ObjectArrays.concat(block, itemCtorArgs));
			} catch (Exception e) {
				e.printStackTrace();
			}
			core.itemList.add(item);
			if (item.getRegistryName() == null) {
				item.setRegistryName(name);
			}
		}
		totalBlocks++;
	}
	
	private static void registerTileEntities() {
		RegisterUtilsZG.registerTileEntity(TileEntityDungeonSpawnerEden.class, ZGInfo.MOD_ID + "ZG Eden Dungeon Spawner");
		RegisterUtilsZG.registerTileEntity(TileEntityDungeonSpawnerTlaloc.class, ZGInfo.MOD_ID + "ZG Tlaloc Dungeon Spawner");
		RegisterUtilsZG.registerTileEntity(TileEntityTier4TreasureChestZG.class, ZGInfo.MOD_ID + "Tier 4 Treasure Chest ZG");
		RegisterUtilsZG.registerTileEntity(TileEntityTier10TreasureChestZG.class, ZGInfo.MOD_ID + "Tier 10 Treasure Chest ZG");
	}
}