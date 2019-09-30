package zollerngalaxy.blocks;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import zollerngalaxy.blocks.eden.EdenFlower;
import zollerngalaxy.blocks.eden.EdenFruit;
import zollerngalaxy.blocks.oasis.OasisFlower;
import zollerngalaxy.blocks.sweetblocks.CandyCubeBlock;
import zollerngalaxy.blocks.sweetblocks.CookieBlock;
import zollerngalaxy.blocks.sweetblocks.IceCreamSandwichBlock;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBlocks {
	
	private static int totalBlocks = 0;
	
	// These have to be declared up top or else weird things happen.
	public static final Block edenWoodSapling = new ZGBlockSapling("edentreesapling");
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
	public static final Block oasisFlower = new OasisFlower();
	
	// Zollus
	public static final Block zolCobbleRock = new ZGBlockBase("zolcobblerock", 1.2F).setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block zolStone = new ZGPlanetStone("zolstone", 1.6F, ZGBlocks.zolCobbleRock);
	public static final Block zolSurfaceRock = new ZGBlockBase("zolsurfacerock", 1.2F);
	public static final Block zolDirt = new ZGBlockDirt("zoldirt");
	public static final Block zolRockBricks = new ZGBlockBase("zolrockbricks", 1.2F);
	public static final Block zolCoalOre = new ZGOreGem("zolcoalore", 1.4F, Items.COAL);
	public static final Block zolCopperOre = new ZGBlockOre("zolcopperore", 1.7F);
	public static final Block zolGoldOre = new ZGBlockOre("zolgoldore", 1.8F);
	public static final Block zolHeartOre = new ZGOreGem("zolheartore", 1.5F, ZGItems.heartOfZol);
	public static final Block zolTinOre = new ZGBlockOre("zoltinore", 1.2F);
	public static final Block zolIronOre = new ZGBlockOre("zolironore", 1.4F);
	public static final Block zolCrystals = new ZolniumCrystals();
	
	// Kriffon
	public static final Block kriffCobbleRock = new ZGBlockBase("kriffcobblerock", 1.4F)
			.setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block kriffStone = new ZGPlanetStone("kriffstone", 1.6F, ZGBlocks.kriffCobbleRock);
	public static final Block kriffSurfaceRock = new ZGBlockBase("kriffrock", 1.6F);
	public static final Block kriffDirt = new ZGBlockDirt("kriffdirt");
	public static final Block kriffRockBricks = new ZGBlockBase("kriffrockbricks", 1.4F);
	public static final Block kriffMagmaRock = ((ZGBlockBase) new ZGBlockBase("magmarock", 2.6F).setIsHotBlock(true)
			.setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block kriffBlazeRock = ((ZGBlockBase) new ZGBlockBase("blazerock", 3.4F).setIsHotBlock(true)
			.setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block kriffCoalOre = new ZGOreGem("kriffcoalore", 1.6F, Items.COAL).setShouldExplode(true, 90);
	public static final Block kriffCopperOre = new ZGBlockOre("kriffcopperore", 1.7F).setShouldExplode(true, 80);
	public static final Block kriffIronOre = new ZGBlockOre("kriffironore", 1.4F).setShouldExplode(true, 70);
	public static final Block kriffGoldOre = new ZGBlockOre("kriffgoldore", 1.7F).setShouldExplode(true, 50);
	public static final Block kriffCobaltOre = new ZGBlockOre("kriffcobaltore", 1.9F).setShouldExplode(true, 10);
	public static final Block kriffRedstoneOre = new ZGOreGem("kriffredstoneore", 1.8F, Items.REDSTONE).setShouldExplode(
			true, 35);
	
	// Purgot
	public static final Block purgCobbleRock = new ZGBlockBase("purgcobblerock", 2.0F)
			.setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block purgStone = new ZGPlanetStone("purgstone", 2.5F, ZGBlocks.purgCobbleRock);
	public static final Block purgRockBricks = new ZGBlockBase("purgrockbricks", 1.6F);
	public static final Block purgSurfaceRock = new ZGBlockBase("purgrock", 1.7F);
	public static final Block purgDirt = new ZGBlockDirt("purgdirt");
	public static final Block purgGravel = new ZGGravel("purggravel", 2.3F);
	public static final Block purgBlackRock = new ZGBlockBase("blackrock", 1.2F);
	public static final Block purgWhiteRock = new ZGBlockBase("whiterock", 1.2F);
	public static final Block purgMeteoricIronOre = new ZGOreGem("purgmeteoricironore", 3.6F, GCItems.meteoricIronRaw)
			.setShouldGivePotionEffect(true, MobEffects.LEVITATION);
	public static final Block purgCobaltOre = ((ZGBlockBase) new ZGBlockOre("purgcobaltore", 2.8F)
			.setShouldGivePotionEffect(true, MobEffects.BLINDNESS)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgIronOre = ((ZGBlockBase) new ZGBlockOre("purgironore", 2.6F).setShouldGivePotionEffect(
			true, MobEffects.INVISIBILITY)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgGoldOre = ((ZGBlockBase) new ZGBlockOre("purggoldore", 2.6F).setShouldGivePotionEffect(
			true, MobEffects.HUNGER)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgCopperOre = ((ZGBlockBase) new ZGBlockOre("purgcopperore", 2.1F)
			.setShouldGivePotionEffect(true, MobEffects.UNLUCK)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgDiamondOre = ((ZGBlockBase) new ZGOreGem("purgdiamondore", 2.9F, Items.DIAMOND)
			.setShouldGivePotionEffect(true, MobEffects.SLOWNESS)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgEmeraldOre = ((ZGBlockBase) new ZGOreGem("purgemeraldore", 3.0F, Items.EMERALD)
			.setShouldGivePotionEffect(true, MobEffects.HEALTH_BOOST)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgEveniumOre = ((ZGBlockBase) new ZGBlockOre("purgeveniumore", 2.9F)
			.setShouldGivePotionEffect(true, MobEffects.GLOWING)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgAluminumOre = ((ZGBlockBase) new ZGBlockOre("purgaluminumore", 2.6F)
			.setShouldGivePotionEffect(true, MobEffects.JUMP_BOOST)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgTinOre = ((ZGBlockBase) new ZGBlockOre("purgtinore", 1.6F).setShouldGivePotionEffect(true,
			MobEffects.NIGHT_VISION)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgLeadOre = ((ZGBlockBase) new ZGBlockOre("purgleadore", 1.8F).setShouldGivePotionEffect(
			true, MobEffects.HASTE)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.COBALT.getHarvestLevel());
	public static final Block purgRedstoneOre = ((ZGBlockBase) new ZGOreGem("purgredstoneore", 1.5F, Items.REDSTONE)
			.setShouldGivePotionEffect(true, MobEffects.REGENERATION)).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.COBALT.getHarvestLevel());
	
	// Eden
	public static final Block edenSurfaceRock = new ZGBlockBase("edensurfacerock", 2.1F);
	public static final Block edenSoil = new ZGBlockDirt("edensoil", 1.6F);
	public static final Block edenGrass = new ZGBlockGrassEden("edengrass");
	public static final Block edenTallGrass = new ZGBlockTallGrass("edentallgrass");
	public static final Block edenSwampGrass = new ZGBlockGrassEden("edenswampgrass");
	public static final Block edenSnow = new ZGBlockGrassEden("edengrass_snow").setSound(SoundType.SNOW);
	public static final Block edenGoldenGrass = new ZGBlockGrassEden("edengoldengrass");
	public static final Block edenCobbleRock = new ZGBlockBase("edencobblerock", 1.5F)
			.setBlockType(EnumBlockType.COBBLESTONE);
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
	public static final Block edenWoodLog = new ZGBlockLog("edenwoodlog");
	public static final Block edenWoodLeaves = new ZGBlockLeaves("edenwoodleaves");
	public static final Block edenWoodPlanks = new ZGBlockPlanks("edenwoodplanks");
	public static final Block blockCrater = new ZGBlockBase("crater_rock", 2.4F);
	public static final Block edenAluminumOre = new ZGBlockOre("edenaluminumore", 1.5F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenSteelOre = new ZGBlockOre("edensteelore", 3.0F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenBronzeOre = new ZGBlockOre("edenbronzeore", 2.8F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenInvarOre = new ZGBlockOre("edeninvarore", 2.8F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenElectrumOre = new ZGBlockOre("edenelectrumore", 2.8F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenPlatinumOre = new ZGBlockOre("edenplatinumore", 4.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCoalOre = new ZGOreGem("edencoalore", 1.5F, Items.COAL).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCopperOre = new ZGBlockOre("edencopperore", 1.4F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenDeshOre = new ZGOreGem("edendeshore", 2.4F, MarsItems.marsItemBasic).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenDiamondOre = new ZGOreGem("edendiamondore", 2.0F, Items.DIAMOND).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenEmeraldOre = new ZGOreGem("edenemeraldore", 2.5F, Items.EMERALD).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenGoldOre = new ZGBlockOre("edengoldore", 1.5F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenSilverOre = new ZGBlockOre("edensilverore", 1.6F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenIronOre = new ZGBlockOre("edenironore", 1.4F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenLapisOre = ((ZGBlockBase) new ZGOreGem("edenlapisore", 1.2F, Items.DYE).setDropMeta(4,
			true)).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenMeteoricIronOre = new ZGOreGem("edenmeteoricironore", 3.4F, GCItems.meteoricIronRaw)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenRedstoneOre = new ZGOreGem("edenredstoneore", 1.6F, Items.REDSTONE).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenTinOre = new ZGBlockOre("edentinore", 1.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenLeadOre = new ZGBlockOre("edenleadore", 1.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenNickelOre = new ZGBlockOre("edennickleore", 1.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenViriniumOre = new ZGOreGem("edenviriore", 2.6F, ZGItems.dustVirinium)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenCobaltOre = new ZGBlockOre("edencobaltore", 2.6F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenEveniumOre = new ZGBlockOre("edeneveniumore", 2.8F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	public static final Block edenHeartiumOre = new ZGOreGem("edenheartiumore", 2.8F, ZGItems.heartOfZol)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.EVENIUM.getHarvestLevel());
	
	// Xathius
	public static final Block xathRock = new ZGBlockBase("xathrock");
	public static final Block xathCobble = new ZGBlockBase("xathcobblerock").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block xathStone = new ZGPlanetStone("xathstone", 3.1F, ZGBlocks.xathCobble);
	public static final Block xathRockBricks = new ZGBlockBase("xathrockbricks", 2.1F);
	public static final Block xathDirt = new ZGBlockDirt("xathdirt");
	public static final Block xathTallGrass = new ZGBlockTallGrass("xathtallgrass");
	public static final Block xathGrass = new ZGBlockGrassXath("xathgrass");
	public static final Block xathGravel = new ZGGravel("xathgravel");
	public static final Block xathPrometheanOre = ((ZGBlockOre) new ZGOreGem("xathprometheanore", 3.6F,
			ZGItems.prometheanCrystal).setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(),
			EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(true, 15);
	public static final Block xathEmeraldOre = ((ZGBlockOre) new ZGOreGem("xathemeraldore", 3.4F, Items.EMERALD)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.INVISIBILITY);
	public static final Block xathDiamondOre = ((ZGBlockOre) new ZGOreGem("xathdiamondore", 3.2F, Items.DIAMOND)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel()))
			.setShouldExplode(true, 25);
	public static final Block xathRedstoneOre = ((ZGBlockOre) new ZGOreGem("xathredstoneore", 2.6F, Items.REDSTONE)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.NAUSEA);
	public static final Block xathIronOre = ((ZGBlockOre) new ZGBlockOre("xathironore", 3.1F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(
			true, 31);
	public static final Block xathGoldOre = ((ZGBlockOre) new ZGBlockOre("xathgoldore", 3.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel()))
			.setShouldGivePotionEffect(true, MobEffects.HUNGER);
	public static final Block xathTinOre = ((ZGBlockOre) new ZGBlockOre("xathtinore", 3.4F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel())).setShouldExplode(
			true, 30);
	public static final Block xathAzuriteOre = new ZGOreGem("xathazuriteore", 9.6F, ZGItems.azurite).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
	// Oasis
	public static final Block oasisRock = new ZGBlockBase("oasisrock");
	public static final Block oasisCobble = new ZGBlockBase("oasiscobblerock").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block oasisStone = new ZGPlanetStone("oasisstone", 2.6F, ZGBlocks.oasisCobble);
	public static final Block oasisRockBricks = new ZGBlockBase("oasisrockbricks", 2.1F);
	public static final Block oasisDirt = new ZGBlockDirt("oasisdirt");
	public static final Block oasisTallGrass = new ZGBlockTallGrass("oasistallgrass");
	public static final Block oasisGrass = new ZGBlockGrassOasis("oasisgrass");
	public static final Block oasisGravel = new ZGGravel("oasisgravel", 2.4F);
	public static final Block oasisSuperChargedCoalOre = new ZGOreGem("oasissuperchargedcoalore", 4.6F,
			ZGItems.superChargedCoal).setBlockHarvestLevel(EnumHarvestToolZG.OMNITOOL.getHarvestTool(),
			EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisCoalOre = new ZGOreGem("oasiscoalore", 2.1F, Items.COAL).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisIronOre = new ZGBlockOre("oasisironore", 2.5F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisGoldOre = new ZGBlockOre("oasisgoldore", 2.3F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisRedstoneOre = new ZGOreGem("oasisredstoneore", 3.5F, Items.REDSTONE)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisDiamondOre = new ZGOreGem("oasisdiamondore", 4.2F, Items.DIAMOND).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisTinOre = new ZGBlockOre("oasistinore", 2.3F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block oasisLeadOre = new ZGBlockOre("oasisleadore", 2.9F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	
	// Xantheon
	public static final Block xantheonRock = new ZGBlockBase("xantheonrock", 5.1F);
	public static final Block xantheonChrome = new ZGBlockMetal("xantheonchrome", 4.2F);
	public static final Block xantheonStone = new ZGBlockBase("xantheonstone", 5.6F);
	public static final Block xantheonCoalOre = new ZGOreGem("xantheoncoalore", 5.6F, Items.COAL).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonIronOre = new ZGBlockOre("xantheonironore", 5.7F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonCopperOre = new ZGBlockOre("xantheoncopperore", 5.3F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonNickelOre = new ZGBlockOre("xantheonnickelore", 5.7F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonPlutoniumOre = new ZGOreGem("xantheonplutoniumore", 6.0F, ZGItems.plutoniumCrystal)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonFueltoniumOre = new ZGOreGem("xantheonfueltoniumore", 6.1F, ZGItems.dustFueltonium)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block xantheonAmaranthOre = new ZGBlockOre("xantheonamaranthore", 6.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	public static final Block xantheonConstructBlock = new ZGBlockMetal("constructblock", 8.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.VIRINIUM.getHarvestLevel());
	
	// Atheon
	public static final Block atheonRock = new ZGBlockMetal("atheonrock", 6.2F);
	public static final Block atheonLuxrock = new ZGBlockMetal("atheonluxrock", 6.3F);
	public static final Block atheonCobble = new ZGBlockBase("atheoncobble").setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block atheonStone = new ZGPlanetStone("atheonstone", 4.5F, ZGBlocks.atheonCobble);
	public static final Block atheonRockBricks = new ZGBlockBase("atheonrockbricks", 6.5F).setLightLevel(1.0F);
	public static final Block atheonAmaranthOre = new ZGBlockOre("atheonamaranthore", 6.4F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonRedstoneOre = new ZGOreGem("atheonredstoneore", 5.6F, Items.REDSTONE)
			.setBlockHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonTinOre = new ZGBlockOre("atheontinore", 5.4F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonDiamondOre = new ZGOreGem("atheondiamondore", 6.2F, Items.DIAMOND).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonZollerniumOre = new ZGBlockOre("atheonzollerniumore", 7.2F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	public static final Block atheonZincOre = new ZGBlockOre("atheonzincore", 6.7F).setBlockHarvestLevel(
			EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.AMARANTH.getHarvestLevel());
	
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
	
	// Glow Blocks
	public static final Block blockShinestone = new ZGShineBlock("shinestone", 1.6F, ZGItems.dustShinestone);
	public static final Block blockShinestoneCrystal = new ZGShineBlock("shinestonecrystal", 1.8F);
	public static final Block blockShinestonePolished = new ZGShineBlock("polishedshinestone", 1.4F);
	public static final Block blockShinestoneCrystalBricks = new ZGShineBlock("shinestonecrystalbricks", 2.4F);
	
	// Compressed Metals
	public static final Block blockCompressedHeartium = new ZGBlockCompressed("compressedheartiumblock");
	public static final Block blockCompressedViri = new ZGBlockCompressed("compressedviriniumblock");
	public static final Block blockCompressedEve = new ZGBlockCompressed("compressedeveniumblock");
	public static final Block blockCompressedCobalt = new ZGBlockCompressed("compressedcobaltblock");
	public static final Block blockCompressedPromethean = new ZGBlockCompressed("compressedprometheanblock");
	public static final Block blockCompressedSuperChargedCoal = new ZGBlockCompressed("compressedsuperchargedcoalblock");
	
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
	public static final Block blockChocolate = new ZGBlockBase("chocolateblock", 1.6F);
	public static final Block blockChocolateBricks = new ZGBlockBase("chocolatebricks", 1.8F);
	public static final Block blockCookie = new CookieBlock();
	public static final Block blockBrownie = ((ZGBlockBase) ((ZGBlockBase) new ZGBlockBase("brownieblock", 1.8F)
			.setMaterial(Material.CLOTH)).setSound(SoundType.CLOTH)).setBlockType(EnumBlockType.SWEET);
	public static final Block blockIceCreamSandwich = new IceCreamSandwichBlock();
	public static final Block blockSugarCube = new ZGBlockBase("sugarcube", 0.6F).setBlockType(EnumBlockType.SWEET);
	
	public static void init() {
		ZGBlocks.registerBlocks(edenWoodSapling, edenFruit, edenFlower, edenFlowerBlack, edenFlowerBlue, edenFlowerCyan,
				edenFlowerGreen, edenFlowerOrange, edenFlowerPink, edenFlowerPurple, edenFlowerRed, edenFlowerYellow,
				edenFlowerWhite, oasisFlower, zolStone, zolCobbleRock, zolSurfaceRock, zolDirt, zolRockBricks, zolCoalOre,
				zolCopperOre, zolGoldOre, zolHeartOre, zolTinOre, zolIronOre, zolCrystals, kriffSurfaceRock, kriffStone,
				kriffCobbleRock, kriffDirt, kriffRockBricks, kriffMagmaRock, kriffBlazeRock, kriffCoalOre, kriffCopperOre,
				kriffIronOre, kriffGoldOre, kriffRedstoneOre, kriffCobaltOre, purgCobbleRock, purgStone, purgRockBricks,
				purgWhiteRock, purgBlackRock, purgSurfaceRock, purgDirt, purgGravel, purgMeteoricIronOre, purgCobaltOre,
				purgIronOre, purgGoldOre, purgCopperOre, purgDiamondOre, purgEmeraldOre, purgEveniumOre, purgAluminumOre,
				purgTinOre, purgLeadOre, purgRedstoneOre, edenSurfaceRock, edenTallGrass, edenGrass, edenSoil, edenStone,
				edenSacredStone, edenCobbleRock, edenRockBricks, edenGoldenGrass, edenSwampGrass, edenSnow, edenWinterRock,
				edenBloodSand, edenBloodStone, edenBoneStone, edenGravel, edenBrightStone, edenWoodLog, edenWoodLeaves,
				edenWoodPlanks, edenDungeonBricks, edenAluminumOre, edenSteelOre, edenBronzeOre, edenInvarOre,
				edenElectrumOre, edenPlatinumOre, edenCoalOre, edenCopperOre, edenDeshOre, edenDiamondOre, edenEmeraldOre,
				edenGoldOre, edenSilverOre, edenIronOre, edenLapisOre, edenMeteoricIronOre, edenRedstoneOre, edenTinOre,
				edenLeadOre, edenNickelOre, edenViriniumOre, edenCobaltOre, edenEveniumOre, edenHeartiumOre, xathRock,
				xathCobble, xathStone, xathRockBricks, xathGrass, xathDirt, xathGravel, xathTallGrass, xathPrometheanOre,
				xathEmeraldOre, xathDiamondOre, xathRedstoneOre, xathIronOre, xathGoldOre, xathTinOre, xathAzuriteOre,
				oasisRock, oasisStone, oasisRockBricks, oasisCobble, oasisDirt, oasisTallGrass, oasisGrass, oasisGravel,
				oasisSuperChargedCoalOre, oasisCoalOre, oasisIronOre, oasisGoldOre, oasisRedstoneOre, oasisDiamondOre,
				oasisTinOre, oasisLeadOre, xantheonRock, xantheonChrome, xantheonStone, xantheonCoalOre, xantheonIronOre,
				xantheonCopperOre, xantheonNickelOre, xantheonPlutoniumOre, xantheonFueltoniumOre, xantheonAmaranthOre,
				xantheonConstructBlock, atheonRock, atheonLuxrock, atheonStone, atheonCobble, atheonRockBricks,
				atheonAmaranthOre, atheonRedstoneOre, atheonTinOre, atheonDiamondOre, atheonZollerniumOre, atheonZincOre,
				blockViri, blockCobalt, blockEve, blockPromethean, blockCrater, blockSuperChargedCoal, blockPlutonium,
				blockFueltonium, blockChargium, blockShinium, blockAmaranth, blockAzurite, blockZollernium, blockZinc,
				blockShinestone, blockShinestoneCrystal, blockShinestonePolished, blockShinestoneCrystalBricks,
				blockCompressedHeartium, blockCompressedViri, blockCompressedEve, blockCompressedCobalt,
				blockCompressedPromethean, blockCompressedSuperChargedCoal, candyCubeWhite, candyCubeBlack, candyCubeGray,
				candyCubeOrange, candyCubeBrown, candyCubeRed, candyCubeBlue, candyCubeYellow, candyCubePurple,
				candyCubeCyan, candyCubePink, candyCubeGreen, blockChocolate, blockChocolateBricks, blockCookie,
				blockBrownie, blockIceCreamSandwich, blockSugarCube);
		ZGHelper.Log("Loaded a total of " + totalBlocks + " new blocks.");
	}
	
	private static void addBlock(Block block) {
		CommonZGRegisterHelper.registerBlock(block);
		totalBlocks++;
	}
	
	private static void registerBlocks(Block... blocks) {
		for (Block b : blocks) {
			ZGBlocks.addBlock(b);
		}
	}
}