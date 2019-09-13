package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorXantheon extends BiomeDecoratorZG {
	
	private static final Block STONE = ZGBlocks.xantheonStone;
	
	private WorldGenerator chromeGen;
	private WorldGenerator ironGen;
	private WorldGenerator copperGen;
	private WorldGenerator coalGen;
	private WorldGenerator nickelGen;
	private WorldGenerator plutoniumGen;
	
	public BiomeDecoratorXantheon() {
		this.chromeGen = new WorldGenMinableZG(ZGBlocks.xantheonChrome, ZGBlocks.xantheonRock,
				EnumOreGenZG.DIRT.setBlockCount(45));
		this.ironGen = new WorldGenMinableZG(ZGBlocks.xantheonIronOre, STONE, EnumOreGenZG.IRON);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.xantheonCopperOre, STONE, EnumOreGenZG.COPPER);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.xantheonCoalOre, STONE, EnumOreGenZG.COAL);
		this.nickelGen = new WorldGenMinableZG(ZGBlocks.xantheonNickelOre, STONE, EnumOreGenZG.NICKEL);
		this.plutoniumGen = new WorldGenMinableZG(ZGBlocks.xantheonPlutoniumOre, STONE, EnumOreGenZG.PLUTONIUM);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.chromeGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.nickelGen, EnumOreGenZG.NICKEL, world, rand);
		this.generateOre(this.plutoniumGen, EnumOreGenZG.PLUTONIUM, world, rand);
		
		int genY = 248;
		int y = genY;
		
	}
}