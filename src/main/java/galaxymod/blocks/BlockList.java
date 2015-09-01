package galaxymod.blocks;

import galaxymod.blocks.ores.eden.EdenCoalOre;
import galaxymod.blocks.ores.eden.EdenCopperOre;
import galaxymod.blocks.ores.eden.EdenDiamondOre;
import galaxymod.blocks.ores.eden.EdenEmeraldOre;
import galaxymod.blocks.ores.eden.EdenGoldOre;
import galaxymod.blocks.ores.eden.EdenIronOre;
import galaxymod.blocks.ores.eden.EdenMeteoricIronOre;
import galaxymod.blocks.ores.eden.EdenTinOre;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {

	public static final Block solarBlock = new BlockZollus();
	public static final Block zolstone = new BlockZolstone();
	public static final Block edenRock = new BlockEdenRock();
	public static final Block edenCobbleRock = new BlockEdenCobblerock();
	public static final Block edenIronOre = new EdenIronOre();
	public static final Block edenCopperOre = new EdenCopperOre();
	public static final Block edenTinOre = new EdenTinOre();
	public static final Block edenMeteoricIronOre = new EdenMeteoricIronOre();
	public static final Block edenDiamondOre = new EdenDiamondOre();
	public static final Block edenEmeraldOre = new EdenEmeraldOre();
	public static final Block edenGoldOre = new EdenGoldOre();
	public static final Block edenCoalOre = new EdenCoalOre();

	public static void init() {
		addBlock(solarBlock, "Zollus Rock");
		addBlock(zolstone, "Zolstone");
		addBlock(edenRock, "Eden Rock");
		addBlock(edenIronOre, "Eden Iron Ore");
		addBlock(edenCopperOre, "Eden Copper Ore");
		addBlock(edenTinOre, "Eden Tin Ore");
		addBlock(edenMeteoricIronOre, "Eden Meteoric Iron Ore");
		addBlock(edenDiamondOre, "Eden Diamond Ore");
		addBlock(edenEmeraldOre, "Eden Emerald Ore");
		addBlock(edenGoldOre, "Eden Gold Ore");
		addBlock(edenCoalOre, "Eden Coal Ore");
		addBlock(edenCobbleRock, "Eden Cobble Rock");
	}

	public static void addBlock(Block block, String name) {
		GameRegistry.registerBlock(block, name);
	}
}