package zollerngalaxy.biomes.kriffon;

import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.world.biome.BiomeDecorator;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.biomes.decorators.BiomeDecoratorKriffon;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMagmos;
import zollerngalaxy.planets.ZGPlanets;

public class BiomeKriffon extends BiomeSpace {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeDecoratorKriffon biomeDecor = this.getBiomeDecorator();
	
	public BiomeKriffon(BiomeProperties props) {
		super("kriffon", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.WARM);
		this.setBiomeType(EnumBiomeTypeZG.VOLCANIC);
		this.enableSnow = false;
		this.decorator.flowersPerChunk = -999;
		this.decorator.treesPerChunk = -999;
		this.decorator.grassPerChunk = -999;
		this.decorator.mushroomsPerChunk = -999;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityAlienVillager.class, 5, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmos.class, 25, 1, 2));
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