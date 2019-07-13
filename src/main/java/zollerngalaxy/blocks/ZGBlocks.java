package zollerngalaxy.blocks;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBlocks {
	
	private static int totalBlocks = 0;
	
	// Zollus
	public static final Block zolCobbleRock = new ZGBlockBase("zolcobblerock", 1.2F);
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
	public static final Block kriffCobbleRock = new ZGBlockBase("kriffcobblerock", 1.4F);
	public static final Block kriffStone = new ZGPlanetStone("kriffstone", 1.6F,
			ZGBlocks.kriffCobbleRock);
	public static final Block kriffSurfaceRock = new ZGBlockBase("kriffrock", 1.6F);
	public static final Block kriffDirt = new ZGBlockDirt("kriffdirt");
	public static final Block kriffRockBricks = new ZGBlockBase("kriffrockbricks", 1.4F);
	public static final Block kriffMagmaRock = ((ZGBlockBase) new ZGBlockBase("magmarock", 2.6F)
			.setIsHotBlock(true).setLightLevel(1.0F)).setShouldAlwaysBurn(true);
	public static final Block kriffCoalOre = new ZGOreGem("kriffcoalore", 1.6F, Items.COAL);
	public static final Block kriffCopperOre = new ZGBlockOre("kriffcopperore", 1.7F);
	public static final Block kriffIronOre = new ZGBlockOre("kriffironore", 1.4F);
	public static final Block kriffGoldOre = new ZGBlockOre("kriffgoldore", 1.7F);
	public static final Block kriffCobaltOre = new ZGBlockOre("kriffcobaltore", 1.9F);
	public static final Block kriffRedstoneOre = new ZGOreGem("kriffredstoneore", 1.8F,
			Items.REDSTONE);
	
	// Purgot
	public static final Block purgCobbleRock = new ZGBlockBase("purgcobblerock", 2.0F);
	public static final Block purgStone = new ZGPlanetStone("purgstone", 2.5F,
			ZGBlocks.purgCobbleRock);
	public static final Block purgRockBricks = new ZGBlockBase("purgrockbricks", 1.6F);
	public static final Block purgSurfaceRock = new ZGBlockBase("purgrock", 1.7F);
	public static final Block purgDirt = new ZGBlockDirt("purgdirt");
	public static final Block purgBlackRock = new ZGBlockBase("blackrock", 1.2F);
	public static final Block purgWhiteRock = new ZGBlockBase("whiterock", 1.2F);
	public static final Block purgMeteoricIronOre = new ZGOreGem("purgmeteoricironore", 3.6F,
			GCItems.meteoricIronRaw);
	public static final Block purgCobaltOre = new ZGBlockOre("purgcobaltore", 2.8F);
	public static final Block purgIronOre = new ZGBlockOre("purgironore", 2.6F);
	public static final Block purgGoldOre = new ZGBlockOre("purggoldore", 2.6F);
	public static final Block purgCopperOre = new ZGBlockOre("purgcopperore", 2.1F);
	public static final Block purgDiamondOre = new ZGOreGem("purgdiamondore", 2.9F, Items.DIAMOND);
	public static final Block purgEmeraldOre = new ZGOreGem("purgemeraldore", 3.0F, Items.EMERALD);
	public static final Block purgEveniumOre = new ZGBlockOre("purgeveniumore", 2.9F);
	public static final Block purgAluminumOre = new ZGBlockOre("purgaluminumore", 2.6F);
	public static final Block purgTinOre = new ZGBlockOre("purgtinore", 1.6F);
	public static final Block purgLeadOre = new ZGBlockOre("purgleadore", 1.8F);
	public static final Block purgRedstoneOre = new ZGOreGem("purgredstoneore", 1.5F,
			Items.REDSTONE);
	
	public static void init() {
		ZGBlocks.registerBlocks(zolStone, zolCobbleRock, zolSurfaceRock, zolDirt, zolRockBricks,
				zolCoalOre, zolCopperOre, zolGoldOre, zolHeartOre, zolTinOre, zolIronOre,
				zolCrystals, kriffSurfaceRock, kriffStone, kriffCobbleRock, kriffDirt,
				kriffRockBricks, kriffMagmaRock, kriffCoalOre, kriffCopperOre, kriffIronOre,
				kriffGoldOre, kriffRedstoneOre, kriffCobaltOre, purgCobbleRock, purgStone,
				purgRockBricks, purgWhiteRock, purgBlackRock, purgSurfaceRock, purgDirt,
				purgMeteoricIronOre, purgCobaltOre, purgIronOre, purgGoldOre, purgCopperOre,
				purgDiamondOre, purgEmeraldOre, purgEveniumOre, purgAluminumOre, purgTinOre,
				purgLeadOre, purgRedstoneOre);
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