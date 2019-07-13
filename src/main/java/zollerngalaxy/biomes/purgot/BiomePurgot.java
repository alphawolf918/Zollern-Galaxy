package zollerngalaxy.biomes.purgot;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorPurgot;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.planets.ZGPlanets;

public class BiomePurgot extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x000000;
	
	public BiomePurgot(BiomeProperties props) {
		super("purgot", props);
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
		this.topBlock = ZGBlocks.purgSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.purgDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.purgStone;
		this.setPlanetForBiome(ZGPlanets.planetPurgot);
	}
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, COLD, DEAD, DRY);
	}
	
	@Override
	public float getSpawningChance() {
		return 0.01F;
	}
	
	@Override
	public BiomeDecorator createBiomeDecorator() {
		return new BiomeDecoratorPurgot();
	}
}