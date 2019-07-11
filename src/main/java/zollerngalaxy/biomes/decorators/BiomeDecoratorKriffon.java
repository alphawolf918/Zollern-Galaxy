package zollerngalaxy.biomes.decorators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumOreGenZG;
import zollerngalaxy.worldgen.WorldGenMinableZG;

public class BiomeDecoratorKriffon extends BiomeDecoratorZG {
	
	private WorldGenerator dirtGen;
	private WorldGenerator magmaGen;
	private WorldGenerator ironGen;
	private WorldGenerator goldGen;
	private WorldGenerator copperGen;
	private WorldGenerator cobaltGen;
	private WorldGenerator redstoneGen;
	private WorldGenerator coalGen;
	
	public BiomeDecoratorKriffon() {
		this.dirtGen = new WorldGenMinableZG(ZGBlocks.kriffDirt, ZGBlocks.kriffSurfaceRock,
				EnumOreGenZG.DIRT);
		this.magmaGen = new WorldGenMinableZG(ZGBlocks.kriffMagmaRock, ZGBlocks.kriffSurfaceRock,
				EnumOreGenZG.MAGMA);
		this.copperGen = new WorldGenMinableZG(ZGBlocks.kriffCopperOre, ZGBlocks.kriffStone,
				EnumOreGenZG.COPPER);
		this.ironGen = new WorldGenMinableZG(ZGBlocks.kriffIronOre, ZGBlocks.kriffStone,
				EnumOreGenZG.IRON);
		this.goldGen = new WorldGenMinableZG(ZGBlocks.kriffGoldOre, ZGBlocks.kriffStone,
				EnumOreGenZG.GOLD);
		this.cobaltGen = new WorldGenMinableZG(ZGBlocks.kriffCobaltOre, ZGBlocks.kriffStone,
				EnumOreGenZG.COBALT);
		this.coalGen = new WorldGenMinableZG(ZGBlocks.kriffCoalOre, ZGBlocks.kriffStone,
				EnumOreGenZG.COAL);
		this.redstoneGen = new WorldGenMinableZG(ZGBlocks.kriffRedstoneOre, ZGBlocks.kriffStone,
				EnumOreGenZG.REDSTONE);
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
		this.generateOre(this.coalGen, EnumOreGenZG.COAL, world, rand);
		this.generateOre(this.redstoneGen, EnumOreGenZG.REDSTONE, world, rand);
	}
}