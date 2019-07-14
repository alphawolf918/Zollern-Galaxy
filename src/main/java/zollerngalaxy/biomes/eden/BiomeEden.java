package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorEden;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeEden extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeDecoratorEden biomeDecor = this.getBiomeDecorator();
	
	public BiomeEden(BiomeProperties props) {
		super("greenlands", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5F);
		this.enableSnow = false;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.decorator.generateFalls = true;
		this.biomeDecor.edenTallGrassPerChunk = 1;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x009f9f;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ZGBlocks.edenSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.edenDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
		this.setPlanetForBiome(ZGPlanets.planetEden);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x004f2e;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, LUSH, WET);
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