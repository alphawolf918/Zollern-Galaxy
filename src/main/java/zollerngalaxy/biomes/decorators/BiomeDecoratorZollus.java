package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.zollus.WorldGenZolniumCrystals;

public class BiomeDecoratorZollus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator packedIceGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator heartiumGen;
	private WorldGenerator coalGen;
	
	public int zolCrystalsPerChunk = 2;
	
	public BiomeDecoratorZollus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.zolDirt, ZGBlocks.zolSurfaceRock, EnumOreGenZG.DIRT);
		this.packedIceGen = new WorldGenMinableZG(Blocks.PACKED_ICE, ZGBlocks.zolSurfaceRock, EnumOreGenZG.PACKED_ICE);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.zolTinOre, ZGBlocks.zolStone, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.zolCopperOre, ZGBlocks.zolStone, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.zolIronOre, ZGBlocks.zolStone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.zolGoldOre, ZGBlocks.zolStone, EnumOreGenZG.GOLD);
		this.heartiumGen = new WorldGenMinableZG(ZGBlocks.zolHeartOre, ZGBlocks.zolStone, EnumOreGenZG.HEARTIUM);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.zolCoalOre, ZGBlocks.zolStone, EnumOreGenZG.COAL);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.heartiumGen, EnumOreGenZG.HEARTIUM, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.packedIceGen, EnumOreGenZG.PACKED_ICE, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		
		int i;
		boolean hasSpawned = false;
		for (i = 0; i < this.zolCrystalsPerChunk; ++i) {
			ZGDecorateHelper.generatePlants(new WorldGenZolniumCrystals(ZGBlocks.zolCrystals.getDefaultState()), world,
					rand, this.chunkPos);
		}
	}
}