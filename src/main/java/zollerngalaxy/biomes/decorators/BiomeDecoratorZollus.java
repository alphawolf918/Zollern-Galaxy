package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorZollus extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator tinGen;
	private WorldGenerator copperGen;
	private WorldGenerator heartiumGen;
	
	public BiomeDecoratorZollus() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.zolDirt,
				ZGBlocks.zolSurfaceRock, EnumOreGenZG.DIRT);
		this.tinGen = new WorldGenMinableZG(ZGBlocks.zolTinOre,
				ZGBlocks.zolstone, EnumOreGenZG.TIN);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.zolCopperOre,
				ZGBlocks.zolstone, EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.zolIronOre,
				ZGBlocks.zolstone, EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.zolGoldOre,
				ZGBlocks.zolstone, EnumOreGenZG.GOLD);
		this.heartiumGen = new WorldGenMinableZG(ZGBlocks.zolHeartOre,
				ZGBlocks.zolstone, EnumOreGenZG.DIAMOND);
	}
	
	@Override
	protected void generate(Biome biome, World world, Random rand) {
		int x = rand.nextInt(16) + 8;
		int z = rand.nextInt(16) + 8;
		
		this.generateOre(this.ironGen, EnumOreGenZG.IRON, world, rand);
		this.generateOre(this.ironGen, EnumOreGenZG.GOLD, world, rand);
		this.generateOre(this.tinGen, EnumOreGenZG.TIN, world, rand);
		this.generateOre(this.copperGen, EnumOreGenZG.COPPER, world, rand);
		this.generateOre(this.heartiumGen, EnumOreGenZG.DIAMOND, world, rand);
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
	}
}