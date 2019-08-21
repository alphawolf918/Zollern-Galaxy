package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorXathius extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator prometheanGen;
	
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
		
		this.generateOre(this.dirtGen, EnumOreGenZG.DIRT, world, rand);
		this.generateOre(this.prometheanGen, EnumOreGenZG.PROMETHEAN, world, rand);
	}
}