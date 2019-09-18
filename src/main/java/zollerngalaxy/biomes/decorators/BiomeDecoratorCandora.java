package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.TempCategory;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorCandora extends BiomeDecoratorZG {
	
	private WorldGenerator brownGen;
	private WorldGenerator redGen;
	private WorldGenerator whiteGen;
	private WorldGenerator orangeGen;
	private WorldGenerator blackGen;
	private WorldGenerator purpleGen;
	private WorldGenerator blueGen;
	private WorldGenerator yellowGen;
	private WorldGenerator cyanGen;
	private WorldGenerator greenGen;
	private WorldGenerator pinkGen;
	private WorldGenerator chocolateGen;
	private WorldGenerator cookieGen;
	private WorldGenerator brownieGen;
	private WorldGenerator iceCreamSandwichGen;
	private WorldGenerator sugarCubeGen;
	
	public int chocolateLakesPerChunk = 1;
	
	public boolean generateLakes = true;
	
	public BiomeDecoratorCandora() {
		this.brownGen = new WorldGenMinableZG(ZGBlocks.candyCubeBrown, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(35));
		this.redGen = new WorldGenMinableZG(ZGBlocks.candyCubeRed, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(45));
		this.whiteGen = new WorldGenMinableZG(ZGBlocks.candyCubeWhite, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(45));
		this.orangeGen = new WorldGenMinableZG(ZGBlocks.candyCubeOrange, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(35));
		this.blackGen = new WorldGenMinableZG(ZGBlocks.candyCubeBlack, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(30));
		this.purpleGen = new WorldGenMinableZG(ZGBlocks.candyCubeBrown, ZGBlocks.candyCubePurple,
				EnumOreGenZG.CANDY.setGenCount(35));
		this.blueGen = new WorldGenMinableZG(ZGBlocks.candyCubeBlue, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(30));
		this.yellowGen = new WorldGenMinableZG(ZGBlocks.candyCubeYellow, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(25));
		this.cyanGen = new WorldGenMinableZG(ZGBlocks.candyCubeCyan, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(15));
		this.greenGen = new WorldGenMinableZG(ZGBlocks.candyCubeGreen, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(15));
		this.pinkGen = new WorldGenMinableZG(ZGBlocks.candyCubePink, ZGBlocks.candyCubeGray,
				EnumOreGenZG.CANDY.setGenCount(35));
		this.chocolateGen = new WorldGenMinableZG(ZGBlocks.blockCookie, ZGBlocks.candyCubeGray,
				EnumOreGenZG.SWEET.setGenCount(25));
		this.cookieGen = new WorldGenMinableZG(ZGBlocks.blockChocolate, ZGBlocks.candyCubeGray,
				EnumOreGenZG.SWEET.setGenCount(16));
		this.brownieGen = new WorldGenMinableZG(ZGBlocks.blockBrownie, ZGBlocks.candyCubeGray,
				EnumOreGenZG.SWEET.setGenCount(18));
		this.sugarCubeGen = new WorldGenMinableZG(ZGBlocks.blockSugarCube, ZGBlocks.candyCubeGray,
				EnumOreGenZG.SWEET.setGenCount(20));
		this.iceCreamSandwichGen = new WorldGenMinableZG(ZGBlocks.blockIceCreamSandwich, ZGBlocks.candyCubeGray,
				EnumOreGenZG.SWEET.setGenCount(5));
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		int genY = 248;
		int y = genY;
		
		Block BLOCK_TOP = biome.topBlock.getBlock();
		Block BLOCK_FILL = biome.fillerBlock.getBlock();
		
		this.generateOre(this.brownGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.redGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.whiteGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.orangeGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.blackGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.purpleGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.blueGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.yellowGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.cyanGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.greenGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.pinkGen, EnumOreGenZG.CANDY, world, rand);
		this.generateOre(this.chocolateGen, EnumOreGenZG.SWEET, world, rand);
		this.generateOre(this.cookieGen, EnumOreGenZG.SWEET, world, rand);
		this.generateOre(this.brownieGen, EnumOreGenZG.SWEET, world, rand);
		this.generateOre(this.sugarCubeGen, EnumOreGenZG.SWEET, world, rand);
		this.generateOre(this.iceCreamSandwichGen, EnumOreGenZG.SWEET, world, rand);
		
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		
		if (this.generateLakes && this.chocolateLakesPerChunk > 0) {
			for (int i = 0; i < this.chocolateLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				Block blockToUse = (biome.getTempCategory() == TempCategory.COLD) ? ZGBlocks.candyCubeCyan
						: ZGFluids.blockChocolateFluid;
				
				(new WorldGenLakesZG(blockToUse, BLOCK_TOP)).generate(world, rand, this.chunkPos.add(x, y, z));
			}
		}
	}
}