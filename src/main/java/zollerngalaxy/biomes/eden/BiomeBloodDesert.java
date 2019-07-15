package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
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

public class BiomeBloodDesert extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeDecoratorEden biomeDecor = this.getBiomeDecorator();
	
	public BiomeBloodDesert(BiomeProperties props) {
		super("greenlands", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(8.0F);
		this.setBiomeHeight(102);
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.decorator.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.deadBushPerChunk = 2;
		this.enableSnow = false;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.biomeDecor.edenTallGrassPerChunk = 1;
		this.biomeDecor.edenFlowersPerChunk = 4;
		this.grassFoilageColorMultiplier = 0x009f00;
		this.waterColor = 0x00009f;
		this.topBlock = ZGBlocks.edenBloodSand.getDefaultState();
		this.fillerBlock = ZGBlocks.edenBloodStone.getDefaultState();
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
		CommonZGRegisterHelper.registerBiomeType(biome, HOT, DEAD, DRY, MOUNTAIN);
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