package zollerngalaxy.blocks;

import net.minecraft.block.Block;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGBlocks {
	
	public static Block zolstone;
	public static Block zolSurfaceRock;
	public static Block zolDirt;
	
	public static void init() {
		zolstone = new ZGBlockBase("zolstone", 1.6F);
		zolSurfaceRock = new ZGBlockBase("zolsurfacerock", 1.2F);
		zolDirt = new ZGBlockDirt("zoldirt", 0.6F);
		
		CommonZGRegisterHelper.registerBlock(zolstone);
		CommonZGRegisterHelper.registerBlock(zolSurfaceRock);
		CommonZGRegisterHelper.registerBlock(zolDirt);
	}
}