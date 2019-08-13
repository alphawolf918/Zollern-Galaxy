package zollerngalaxy.blocks;

import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.mars.items.MarsItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import zollerngalaxy.blocks.eden.EdenFlower;
import zollerngalaxy.blocks.eden.EdenFruit;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.core.enums.EnumBlockType;
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
	
	// Zollus
	public static final Block zolCobbleRock = new ZGBlockBase("zolcobblerock", 1.2F)
			.setBlockType(EnumBlockType.COBBLESTONE);
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
	public static final Block kriffStone = new ZGPlanetStone("kriffstone", 1.6F,
			ZGBlocks.kriffCobbleRock);
	public static final Block kriffSurfaceRock = new ZGBlockBase("kriffrock", 1.6F);
	public static final Block kriffDirt = new ZGBlockDirt("kriffdirt");
	public static final Block kriffRockBricks = new ZGBlockBase("kriffrockbricks", 1.4F);
	public static final Block kriffMagmaRock = ((ZGBlockBase) new ZGBlockBase("magmarock", 2.6F)
			.setIsHotBlock(true).setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block kriffCoalOre = new ZGOreGem("kriffcoalore", 1.6F, Items.COAL)
			.setShouldExplode(true, 90);
	public static final Block kriffCopperOre = new ZGBlockOre("kriffcopperore", 1.7F)
			.setShouldExplode(true, 80);
	public static final Block kriffIronOre = new ZGBlockOre("kriffironore", 1.4F).setShouldExplode(
			true, 70);
	public static final Block kriffGoldOre = new ZGBlockOre("kriffgoldore", 1.7F).setShouldExplode(
			true, 50);
	public static final Block kriffCobaltOre = new ZGBlockOre("kriffcobaltore", 1.9F)
			.setShouldExplode(true, 10);
	public static final Block kriffRedstoneOre = new ZGOreGem("kriffredstoneore", 1.8F,
			Items.REDSTONE).setShouldExplode(true, 35);
	
	// Purgot
	public static final Block purgCobbleRock = new ZGBlockBase("purgcobblerock", 2.0F)
			.setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block purgStone = new ZGPlanetStone("purgstone", 2.5F,
			ZGBlocks.purgCobbleRock);
	public static final Block purgRockBricks = new ZGBlockBase("purgrockbricks", 1.6F);
	public static final Block purgSurfaceRock = new ZGBlockBase("purgrock", 1.7F);
	public static final Block purgDirt = new ZGBlockDirt("purgdirt");
	public static final Block purgGravel = new ZGGravel("purggravel", 2.3F);
	public static final Block purgBlackRock = new ZGBlockBase("blackrock", 1.2F);
	public static final Block purgWhiteRock = new ZGBlockBase("whiterock", 1.2F);
	public static final Block purgMeteoricIronOre = new ZGOreGem("purgmeteoricironore", 3.6F,
			GCItems.meteoricIronRaw).setShouldGivePotionEffect(true, MobEffects.LEVITATION);
	public static final Block purgCobaltOre = new ZGBlockOre("purgcobaltore", 2.8F)
			.setShouldGivePotionEffect(true, MobEffects.BLINDNESS);
	public static final Block purgIronOre = new ZGBlockOre("purgironore", 2.6F)
			.setShouldGivePotionEffect(true, MobEffects.INVISIBILITY);
	public static final Block purgGoldOre = new ZGBlockOre("purggoldore", 2.6F)
			.setShouldGivePotionEffect(true, MobEffects.HUNGER);
	public static final Block purgCopperOre = new ZGBlockOre("purgcopperore", 2.1F);
	public static final Block purgDiamondOre = new ZGOreGem("purgdiamondore", 2.9F, Items.DIAMOND)
			.setShouldGivePotionEffect(true, MobEffects.SLOWNESS);
	public static final Block purgEmeraldOre = new ZGOreGem("purgemeraldore", 3.0F, Items.EMERALD)
			.setShouldGivePotionEffect(true, MobEffects.HEALTH_BOOST);
	public static final Block purgEveniumOre = new ZGBlockOre("purgeveniumore", 2.9F)
			.setShouldGivePotionEffect(true, MobEffects.GLOWING);
	public static final Block purgAluminumOre = new ZGBlockOre("purgaluminumore", 2.6F)
			.setShouldGivePotionEffect(true, MobEffects.JUMP_BOOST);
	public static final Block purgTinOre = new ZGBlockOre("purgtinore", 1.6F)
			.setShouldGivePotionEffect(true, MobEffects.NIGHT_VISION);
	public static final Block purgLeadOre = new ZGBlockOre("purgleadore", 1.8F)
			.setShouldGivePotionEffect(true, MobEffects.HASTE);
	public static final Block purgRedstoneOre = new ZGOreGem("purgredstoneore", 1.5F,
			Items.REDSTONE).setShouldGivePotionEffect(true, MobEffects.REGENERATION);
	
	// Eden
	public static final Block edenSurfaceRock = new ZGBlockBase("edensurfacerock", 2.1F);
	public static final Block edenGrass = new ZGBlockGrass("edengrass", 1.2F);
	public static final Block edenSwampGrass = new ZGBlockGrass("edenswampgrass", 1.2F);
	public static final Block edenTallGrass = new ZGBlockTallGrass("edentallgrass");
	public static final Block edenSoil = new ZGBlockDirt("edensoil", 1.6F);
	public static final Block edenCobbleRock = new ZGBlockBase("edencobblerock", 1.5F)
			.setBlockType(EnumBlockType.COBBLESTONE);
	public static final Block edenStone = new ZGPlanetStone("edenrock", 2.6F,
			ZGBlocks.edenCobbleRock);
	public static final Block edenSacredStone = new ZGBlockBase("edensacredstone", 3.2F);
	public static final Block edenDungeonBricks = new ZGBlockBase("edendungeonbricks", 3.4F);
	public static final Block edenRockBricks = new ZGBlockBase("edenrockbricks", 1.4F);
	public static final Block edenWinterRock = new ZGBlockBase("edenwinterrock", 1.6F);
	public static final Block edenBloodSand = new ZGSand("bloodsand", 1.4F);
	public static final Block edenBloodStone = new ZGBlockBase("bloodstone", 1.4F);
	public static final Block edenBoneStone = new ZGBlockBase("bonestone", 1.8F);
	public static final Block edenGravel = new ZGGravel("edengravel", 2.1F);
	public static final Block edenBrightStone = new ZGShineBlock("brightstone",
			ZGItems.dustBrightstone);
	public static final Block edenSnow = new ZGBlockGrass("edengrass_snow", 1.2F)
			.setSound(SoundType.SNOW);
	public static final Block edenGoldenGrass = new ZGBlockGrass("edengoldengrass", 1.2F);
	public static final Block edenWoodLog = new ZGBlockLog("edenwoodlog");
	public static final Block edenWoodLeaves = new ZGBlockLeaves("edenwoodleaves");
	public static final Block edenWoodPlanks = new ZGBlockPlanks("edenwoodplanks");
	public static final Block edenAluminumOre = new ZGBlockOre("edenaluminumore", 1.5F);
	public static final Block edenSteelOre = new ZGBlockOre("edensteelore", 3.0F);
	public static final Block edenBronzeOre = new ZGBlockOre("edenbronzeore", 2.8F);
	public static final Block edenInvarOre = new ZGBlockOre("edeninvarore", 2.8F);
	public static final Block edenElectrumOre = new ZGBlockOre("edenelectrumore", 2.8F);
	public static final Block edenPlatinumOre = new ZGBlockOre("edenplatinumore", 4.2F);
	public static final Block edenCoalOre = new ZGOreGem("edencoalore", 1.5F, Items.COAL);
	public static final Block edenCopperOre = new ZGBlockOre("edencopperore", 1.4F);
	public static final Block edenDeshOre = new ZGOreGem("edendeshore", 2.4F,
			MarsItems.marsItemBasic);
	public static final Block edenDiamondOre = new ZGOreGem("edendiamondore", 2.0F, Items.DIAMOND);
	public static final Block edenEmeraldOre = new ZGOreGem("edenemeraldore", 2.5F, Items.EMERALD);
	public static final Block edenGoldOre = new ZGBlockOre("edengoldore", 1.5F);
	public static final Block edenSilverOre = new ZGBlockOre("edensilverore", 1.6F);
	public static final Block edenIronOre = new ZGBlockOre("edenironore", 1.4F);
	public static final Block edenLapisOre = new ZGOreGem("edenlapisore", 1.2F, Items.DYE)
			.setDropMeta(4, true);
	public static final Block edenMeteoricIronOre = new ZGOreGem("edenmeteoricironore", 3.4F,
			GCItems.meteoricIronRaw);
	public static final Block edenRedstoneOre = new ZGOreGem("edenredstoneore", 1.6F,
			Items.REDSTONE);
	public static final Block edenTinOre = new ZGBlockOre("edentinore", 1.2F);
	public static final Block edenLeadOre = new ZGBlockOre("edenleadore", 1.2F);
	public static final Block edenNickleOre = new ZGBlockOre("edennickleore", 1.2F);
	public static final Block edenViriniumOre = new ZGOreGem("edenviriore", 2.6F, ZGItems.dustViri);
	public static final Block edenCobaltOre = new ZGBlockOre("edencobaltore", 2.6F);
	public static final Block edenEveniumOre = new ZGBlockOre("edeneveniumore", 2.8F);
	public static final Block edenHeartiumOre = new ZGOreGem("edenheartiumore", 2.8F,
			ZGItems.heartOfZol);
	
	// Metals
	public static final Block blockViri = new ZGBlockMetal("viriblock");
	public static final Block blockEve = new ZGBlockMetal("eveniumblock");
	public static final Block blockCobalt = new ZGBlockMetal("cobaltblock");
	
	// Other
	public static final Block blockCrater = new ZGBlockBase("crater_rock", 2.4F);
	
	// Next release...
	// Oasis
	// TODO
	
	// Next release...
	// Xathius
	// TODO
	
	public static void init() {
		ZGBlocks.registerBlocks(edenWoodSapling, edenFruit, edenFlower, edenFlowerBlack,
				edenFlowerBlue, edenFlowerCyan, edenFlowerGreen, edenFlowerOrange, edenFlowerPink,
				edenFlowerPurple, edenFlowerRed, edenFlowerYellow, edenFlowerWhite, zolStone,
				zolCobbleRock, zolSurfaceRock, zolDirt, zolRockBricks, zolCoalOre, zolCopperOre,
				zolGoldOre, zolHeartOre, zolTinOre, zolIronOre, zolCrystals, kriffSurfaceRock,
				kriffStone, kriffCobbleRock, kriffDirt, kriffRockBricks, kriffMagmaRock,
				kriffCoalOre, kriffCopperOre, kriffIronOre, kriffGoldOre, kriffRedstoneOre,
				kriffCobaltOre, purgCobbleRock, purgStone, purgRockBricks, purgWhiteRock,
				purgBlackRock, purgSurfaceRock, purgDirt, purgGravel, purgMeteoricIronOre,
				purgCobaltOre, purgIronOre, purgGoldOre, purgCopperOre, purgDiamondOre,
				purgEmeraldOre, purgEveniumOre, purgAluminumOre, purgTinOre, purgLeadOre,
				purgRedstoneOre, edenSurfaceRock, edenTallGrass, edenGrass, edenSoil, edenStone,
				edenSacredStone, edenCobbleRock, edenRockBricks, edenGoldenGrass, edenSwampGrass,
				edenSnow, edenWinterRock, edenBloodSand, edenBloodStone, edenBoneStone, edenGravel,
				edenBrightStone, edenWoodLog, edenWoodLeaves, edenWoodPlanks, edenDungeonBricks,
				edenAluminumOre, edenSteelOre, edenBronzeOre, edenInvarOre, edenElectrumOre,
				edenPlatinumOre, edenCoalOre, edenCopperOre, edenDeshOre, edenDiamondOre,
				edenEmeraldOre, edenGoldOre, edenSilverOre, edenIronOre, edenLapisOre,
				edenMeteoricIronOre, edenRedstoneOre, edenTinOre, edenLeadOre, edenNickleOre,
				edenViriniumOre, edenCobaltOre, edenEveniumOre, edenHeartiumOre, blockViri,
				blockCobalt, blockEve, blockCrater);
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