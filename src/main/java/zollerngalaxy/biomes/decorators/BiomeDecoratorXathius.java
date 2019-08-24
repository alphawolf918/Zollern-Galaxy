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
	
	public static final Block STONE = ZGBlocks.xathStone;
	
	private WorldGenerator dirtGen;
	private WorldGenerator gravelGen;
	private WorldGenerator obsidianGen;
	private WorldGenerator prometheanGen;
	private WorldGenerator emeraldGen;
	private WorldGenerator diamondGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	
	public int waterLakesPerChunk = 4;
	public int lavaLakesPerChunk = 1;
	public int oilLakesPerChunk = 4;
	public int obsidianLakesPerChunk = 2;
	public int xathTallGrassPerChunk = 8;
	
	public boolean generateLakes = true;
	public boolean generateVines = false;
	public boolean generateCraters = false;
	
	public BiomeDecoratorXathius() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.xathDirt, STONE, EnumOreGenZG.DIRT);
		this.prometheanGen = new WorldGenMinableZG(ZGBlocks.xathPrometheanOre, STONE,
				EnumOreGenZG.PROMETHEAN);
		this.emeraldGen = new WorldGenMinableZG(ZGBlocks.xathEmeraldOre, STONE,
				EnumOreGenZG.EMERALD.setGenCount(10));
		this.diamondGen = new WorldGenMinableZG(ZGBlocks.xathDiamondOre, STONE,
				EnumOreGenZG.DIAMOND.setGenCount(15));
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.xathRedstoneOre, STONE,
				EnumOreGenZG.REDSTONE.setGenCount(30));
		this.ironGen = new WorldGenMinableZG(ZGBlocks.xathIronOre, STONE,
				EnumOreGenZG.IRON.setGenCount(25));
		this.goldGen = new WorldGenMinableZG(ZGBlocks.xathGoldOre, STONE,
				EnumOreGenZG.GOLD.setGenCount(35));
		this.tinGen = new WorldGenMinableZG(ZGBlocks.xathTinOre, STONE,
				EnumOreGenZG.TIN.setGenCount(45));
		this.obsidianGen = new WorldGenMinableZG(Blocks.OBSIDIAN, STONE,
				EnumOreGenZG.OBSIDIAN.setGenCount(46));
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.prometheanGen, EnumOreGenZG.PROMETHEAN, world, rand);
		this.generateOre(this.emeraldGen, EnumOreGenZG.EMERALD, world, rand);
		this.generateOre(this.diamondGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.obsidianGen, EnumOreGenZG.OBSIDIAN, world, rand);
		
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
					(new WorldGenLakesZG(Blocks.LAVA, STONE)).generate(world, rand,
							this.chunkPos.add(x, y, z));
				}
			}
		}
		
		if (this.generateLakes && this.obsidianLakesPerChunk > 0) {
			for (int i = 0; i < this.obsidianLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(100) <= 10) {
					(new WorldGenLakesZG(Blocks.OBSIDIAN, STONE)).generate(world, rand,
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