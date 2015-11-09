package galaxymod.biomes;

import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenBloodDesert extends BiomeGenNovaBase {
	public BiomeEdenBloodDesert(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Blood Desert");
		this.setHeight(height_MidHills);
		this.setChunkHeightModifier(16);
		this.grassFoilageColorMultiplier = 0xbf0000;
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.deadBushPerChunk = 2;
		this.waterColorMultiplier = 0x8b009f;
		this.temperature = 8F;
		this.topBlock = BlockList.edenBloodSand;
		this.fillerBlock = BlockList.edenBloodStone;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}