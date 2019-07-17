package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.MOUNTAIN;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorEden;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeStoneMountains extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeDecoratorEden biomeDecor = this.getBiomeDecorator();
	
	public BiomeStoneMountains(BiomeProperties props) {
		super("stonemountains", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(7.2F);
		this.setBiomeHeight(120);
		this.enableSnow = false;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 1;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x0000ff;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ZGBlocks.edenStone.getDefaultState();
		this.fillerBlock = ZGBlocks.edenCobbleRock.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
		this.setPlanetForBiome(ZGPlanets.planetEden);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2ad8;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, MOUNTAIN, DEAD);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorEden();
	}
	
	protected BiomeDecoratorEden getBiomeDecorator() {
		return (BiomeDecoratorEden) this.decorator;
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