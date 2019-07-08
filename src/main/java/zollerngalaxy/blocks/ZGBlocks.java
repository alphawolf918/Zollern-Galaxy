package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import zollerngalaxy.blocks.items.ZGItems;
import zollerngalaxy.blocks.zollus.ZolniumCrystals;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGBlocks {
	
	private static int totalBlocks = 0;
	
	// Zollus
	public static final Block zolCobbleRock = new ZGBlockBase("zolcobblerock",
			1.2F);
	public static final Block zolStone = new ZGPlanetStone("zolstone", 1.6F,
			ZGBlocks.zolCobbleRock);
	public static final Block zolSurfaceRock = new ZGBlockBase(
			"zolsurfacerock", 1.2F);
	public static final Block zolDirt = new ZGBlockDirt("zoldirt");
	public static final Block zolRockBricks = new ZGBlockBase("zolrockbricks",
			1.2F);
	public static final Block zolCoalOre = new ZGOreGem("zolcoalore", 1.4F,
			Items.COAL);
	public static final Block zolCopperOre = new ZGBlockOre("zolcopperore",
			1.7F);
	public static final Block zolGoldOre = new ZGBlockOre("zolgoldore", 1.8F);
	public static final Block zolHeartOre = new ZGOreGem("zolheartore", 1.5F,
			ZGItems.heartOfZol);
	public static final Block zolTinOre = new ZGBlockOre("zoltinore", 1.2F);
	public static final Block zolIronOre = new ZGBlockOre("zolironore", 1.4F);
	public static final Block zolCrystals = new ZolniumCrystals();
	
	// Kriffon
	public static final Block kriffCobbleRock = new ZGBlockBase(
			"kriffcobblerock", 1.4F);
	public static final Block kriffStone = new ZGPlanetStone("kriffstone",
			1.6F, ZGBlocks.kriffCobbleRock);
	public static final Block kriffSurfaceRock = new ZGBlockBase("kriffrock",
			1.6F);
	public static final Block kriffDirt = new ZGBlockDirt("kriffdirt");
	public static final Block kriffRockBricks = new ZGBlockBase(
			"kriffrockbricks", 1.4F);
	public static final Block kriffMagmaRock = ((ZGBlockBase) new ZGBlockBase(
			"magmarock", 2.6F).setIsHotBlock(true).setLightLevel(1.0F))
			.setShouldAlwaysBurn(true);
	public static final Block kriffCoalOre = new ZGOreGem("kriffcoalore", 1.6F,
			Items.COAL);
	public static final Block kriffCopperOre = new ZGBlockOre("kriffcopperore",
			1.7F);
	public static final Block kriffIronOre = new ZGBlockOre("kriffironore",
			1.4F);
	public static final Block kriffGoldOre = new ZGBlockOre("kriffgoldore",
			1.7F);
	public static final Block kriffCobaltOre = new ZGBlockOre("kriffcobaltore",
			1.9F);
	public static final Block kriffRedstoneOre = new ZGOreGem(
			"kriffredstoneore", 1.8F, Items.REDSTONE);
	
	public static void init() {
		ZGBlocks.registerBlocks(zolStone, zolCobbleRock, zolSurfaceRock,
				zolDirt, zolRockBricks, zolCoalOre, zolCopperOre, zolGoldOre,
				zolHeartOre, zolTinOre, zolIronOre, zolCrystals,
				kriffSurfaceRock, kriffStone, kriffCobbleRock, kriffDirt,
				kriffRockBricks, kriffMagmaRock, kriffCoalOre, kriffCopperOre,
				kriffIronOre, kriffGoldOre, kriffRedstoneOre, kriffCobaltOre);
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