package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import zollerngalaxy.blocks.items.ZGItems;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGBlocks {
	
	public static final Block zolcobblerock = new ZGBlockBase("zolcobblerock",
			1.2F);
	public static final Block zolstone = new ZGPlanetStone("zolstone", 1.6F,
			ZGBlocks.zolcobblerock);
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
	
	public static void init() {
		ZGBlocks.addBlock(zolstone);
		ZGBlocks.addBlock(zolcobblerock);
		ZGBlocks.addBlock(zolSurfaceRock);
		ZGBlocks.addBlock(zolDirt);
		ZGBlocks.addBlock(zolRockBricks);
		ZGBlocks.addBlock(zolCoalOre);
		ZGBlocks.addBlock(zolCopperOre);
		ZGBlocks.addBlock(zolGoldOre);
		ZGBlocks.addBlock(zolHeartOre);
		ZGBlocks.addBlock(zolTinOre);
		ZGBlocks.addBlock(zolIronOre);
	}
	
	private static void addBlock(Block block) {
		CommonZGRegisterHelper.registerBlock(block);
	}
}