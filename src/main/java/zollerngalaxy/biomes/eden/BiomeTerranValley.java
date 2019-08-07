package zollerngalaxy.biomes.eden;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;

public class BiomeTerranValley extends BiomeEdenBase {
	
	public BiomeTerranValley(BiomeProperties props) {
		super("terranvalley", props);
		this.setupBiome(props);
	}
	
	public BiomeTerranValley(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.setTemp(4F);
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.LUSH);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.edenTallGrassPerChunk = 14;
		this.biomeDecor.edenFlowersPerChunk = 8;
		this.biomeDecor.edenTreesPerChunk = 1;
		this.grassFoliageColor = 0x00008b;
		this.waterColor = 0x00008b;
		this.spawnableCreatureList.add(new SpawnListEntry(EntityMoolus.class, 100, 4, 6));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityOinkus.class, 100, 4, 6));
		this.topBlock = ZGBlocks.edenGrass.getDefaultState();
		this.fillerBlock = ZGBlocks.edenSoil.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x003a4b;
	}
}