package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenLakesZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorKriffon extends BiomeDecoratorZG {
	
	private static final Block SURFACE = ZGBlocks.kriffSurfaceRock;
	private static final Block STONE = ZGBlocks.kriffStone;
	private static final Block MAGMA = ZGBlocks.kriffMagmaRock;
	
	private WorldGenerator dirtGen;
	private WorldGenerator magmaGen;
	private WorldGenerator magmaGen2;
	private WorldGenerator blazeGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator copperGen;
	private WorldGenerator cobaltGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator coalGen;
	
	public int lavaLakesPerChunk = ConfigManagerZG.kriffonLavaLakesPerChunk;
	
	public BiomeDecoratorKriffon() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.kriffDirt, SURFACE, EnumOreGenZG.DIRT);
		this.magmaGen = new WorldGenMinableZG(MAGMA, SURFACE, EnumOreGenZG.MAGMA);
		this.magmaGen2 = new WorldGenMinableZG(MAGMA, STONE, EnumOreGenZG.MAGMA);
		this.blazeGen = new WorldGenMinableZG(ZGBlocks.kriffBlazeRock, STONE, EnumOreGenZG.BLAZE);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.kriffCopperOre, STONE, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.kriffIronOre, STONE, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.kriffGoldOre, STONE, EnumOreGenZG.GOLD);
		this.cobaltGen = new WorldGenMinableZG(ZGBlocks.kriffCobaltOre, STONE, EnumOreGenZG.COBALT);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.kriffCoalOre, STONE, EnumOreGenZG.COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.kriffRedstoneOre, STONE, EnumOreGenZG.REDSTONE);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.goldGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.cobaltGen, EnumOreGenZG.COBALT, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.magmaGen, EnumOreGenZG.MAGMA, world, rand);
		this.generateOre(this.magmaGen2, EnumOreGenZG.MAGMA, world, rand);
		this.generateOre(this.blazeGen, EnumOreGenZG.BLAZE, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
		
		int genY = 128;
		int y = genY;
		
		if (this.lavaLakesPerChunk > 0) {
			for (int i = 0; i < this.lavaLakesPerChunk; ++i) {
				y = rand.nextInt(rand.nextInt(genY) + 8);
				
				if (rand.nextInt(100) <= ConfigManagerZG.kriffonLavaLakesGenChance) {
					(new WorldGenLakesZG(Blocks.LAVA, STONE)).generate(world, rand, this.chunkPos.add(x, y, z));
				}
			}
		}
	}
}