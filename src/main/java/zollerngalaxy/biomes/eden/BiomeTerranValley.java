package zollerngalaxy.biomes.eden;

import static net.minecraftforge.common.BiomeDictionary.Type.LUSH;
import static net.minecraftforge.common.BiomeDictionary.Type.WET;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityOinkus;

public class BiomeTerranValley extends BiomeGenEdenBase {
	
	public static int grassFoilageColorMultiplier = 0x8b0000;
	
	public BiomeTerranValley(BiomeProperties props) {
		super("terranvalley", props);
		this.setTempCategory(TempCategory.MEDIUM);
		props.setBaseHeight(1.2F);
		props.setHeightVariation(0.5F);
		props.setTemperature(4.0F);
		this.setTemp(4F);
		this.setBiomeHeight(52);
		this.enableSnow = false;
		this.decorator.generateFalls = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.edenTallGrassPerChunk = 14;
		this.biomeDecor.edenFlowersPerChunk = 8;
		this.biomeDecor.edenTreesPerChunk = 1;
		this.grassFoilageColorMultiplier = 0x00008b;
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
	
	@Override
	public void registerTypes(Biome biome) {
		CommonZGRegisterHelper.registerBiomeType(biome, LUSH, WET);
	}
}