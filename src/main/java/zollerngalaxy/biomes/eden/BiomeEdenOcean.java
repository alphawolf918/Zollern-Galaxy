package zollerngalaxy.biomes.eden;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntitySquidlus;

public class BiomeEdenOcean extends BiomeEdenBase {
	
	public BiomeEdenOcean(BiomeProperties props) {
		super("edenocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(5.0F);
		this.setBiomeHeight(63);
		this.setBlocks(Blocks.AIR);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 100, 1, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquidlus.class, 100, 1, 4));
		this.biomeDecor.edenTallGrassPerChunk = 6;
		this.biomeDecor.edenFlowersPerChunk = 5;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.generateTowers = false;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.deadBushPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 6;
		this.enableSnow = false;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x00009f;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00002e;
	}
}