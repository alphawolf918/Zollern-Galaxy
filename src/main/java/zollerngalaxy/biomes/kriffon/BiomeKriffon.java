package zollerngalaxy.biomes.kriffon;

import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import static net.minecraftforge.common.BiomeDictionary.Type.HOT;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorKriffon;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeKriffon extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorKriffon biomeDecor = this.getBiomeDecorator();
	
	public BiomeKriffon(BiomeProperties props) {
		super("kriffon", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.WARM);
		this.enableSnow = false;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.topBlock = ZGBlocks.kriffSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.kriffDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.kriffStone;
		this.setPlanetForBiome(ZGPlanets.planetKriffon);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, HOT, DEAD, DRY);
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorKriffon();
	}
	
	protected BiomeDecoratorKriffon getBiomeDecorator() {
		return (BiomeDecoratorKriffon) this.decorator;
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