package zollerngalaxy.biomes;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.decorators.BiomeDecoratorZollus;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeZollus extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorZollus biomeDecor = this.getBiomeDecorator();
	
	public BiomeZollus(BiomeProperties props) {
		super(props);
		props.setRainDisabled();
		this.enableSnow = true;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ZGBlocks.zolSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.zolDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.zolstone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorZollus();
	}
	
	protected BiomeDecoratorZollus getBiomeDecorator() {
		return (BiomeDecoratorZollus) this.decorator;
	}
	
	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
	
	@Override
	public int getModdedBiomeGrassColor(int original) {
		return this.grassFoilageColorMultiplier;
	}
}