package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlockTallGrass;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.lib.helpers.ZGDecorateHelper;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;
import zollerngalaxy.worldgen.WorldGenTallGrassZG;

public class BiomeDecoratorXathius extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator prometheanGen;
	
	public int waterLakesPerChunk = 4;
	public int lavaLakesPerChunk = 1;
	public int xathTallGrassPerChunk = 8;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateCraters = false;
	
	public BiomeDecoratorXathius() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.xathDirt, ZGBlocks.xathRock,
				EnumOreGenZG.DIRT);
		this.prometheanGen = new WorldGenMinableZG(ZGBlocks.xathPrometheanOre, ZGBlocks.xathStone,
				EnumOreGenZG.PROMETHEAN);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		Block BLOCK_STONE = ZGBlocks.xathStone;
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.prometheanGen, EnumOreGenZG.PROMETHEAN, world, rand);
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		if (this.generateLakes && this.waterLakesPerChunk > 0) {
			for (int i = 0; i < this.waterLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? Blocks.ICE
						: Blocks.WATER;
				
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand,
						this.chunkPos.add(x, y, z));
			}
			
			if (this.waterlilyPerChunk > 0) {
				for (int i = 0; i < this.waterlilyPerChunk; ++i) {
					(new WorldGenWaterlily()).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.generateLakes && this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(100) <= 5) {
					(new WorldGenLakesZG(Blocks.LAVA, BLOCK_STONE)).generate(world, rand,
							this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.xathTallGrassPerChunk > 0) {
			for (int i = 0; i < this.xathTallGrassPerChunk + 4; ++i) {
				ZGDecorateHelper.generatePlants(new WorldGenTallGrassZG(
						(ZGBlockTallGrass) ZGBlocks.xathTallGrass), world, rand, this.chunkPos);
			}
		}
	}
}