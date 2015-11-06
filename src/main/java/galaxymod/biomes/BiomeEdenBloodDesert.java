package galaxymod.biomes;

import galaxymod.blocks.BlockList;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenBloodDesert extends BiomeGenBase {
	public BiomeEdenBloodDesert(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Blood Desert");
		this.setHeight(height_MidHills);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.waterColorMultiplier = 0x8b009f;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.temperature = 8F;
		this.topBlock = BlockList.edenBloodSand;
		this.fillerBlock = BlockList.edenBloodStone;
	}

	@Override
	public int getModdedBiomeFoliageColor(int original) {
		return 0xbf0000;
	}

	@Override
	public int getModdedBiomeGrassColor(int original) {
		return 0x8b0000;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}