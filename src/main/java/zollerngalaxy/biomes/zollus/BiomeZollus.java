package zollerngalaxy.biomes.zollus;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorZollus;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeZollus extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x00008b;
	protected Block stoneBlock;
	protected byte topMeta;
	protected byte fillerMeta;
	protected byte stoneMeta;
	public BiomeDecoratorZollus biomeDecor = this.getBiomeDecorator();
	
	public BiomeZollus(BiomeProperties props) {
		super("zollus", props);
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
		this.stoneBlock = ZGBlocks.zolStone;
		this.setPlanetForBiome(ZGPlanets.planetZollus);
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, COLD, DEAD, DRY);
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