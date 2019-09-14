package zollerngalaxy.biomes.xantheon;

import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorXantheon;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeXantheon extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x000000;
	
	public BiomeDecoratorXantheon biomeDecor = this.getBiomeDecorator();
	
	public BiomeXantheon(BiomeProperties props) {
		super("xantheon", props);
		props.setRainDisabled();
		this.setBiomeType(EnumBiomeTypeZG.TECHY);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(-26.5F);
		this.enableSnow = false;
		this.biomeDecor.flowersPerChunk = -999;
		this.biomeDecor.treesPerChunk = -999;
		this.biomeDecor.grassPerChunk = -999;
		this.biomeDecor.mushroomsPerChunk = -999;
		this.clearAllNonMonsterSpawning();
		this.topBlock = ZGBlocks.xantheonRock.getDefaultState();
		this.fillerBlock = ZGBlocks.xantheonChrome.getDefaultState();
		this.stoneBlock = ZGBlocks.xantheonStone;
		this.setPlanetForBiome(ZGPlanets.planetXantheon);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorXantheon();
	}
	
	protected BiomeDecoratorXantheon getBiomeDecorator() {
		return (BiomeDecoratorXantheon) this.decorator;
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