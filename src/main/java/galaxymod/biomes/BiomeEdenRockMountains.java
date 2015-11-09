package galaxymod.biomes;

import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenRockMountains extends BiomeGenNovaBase {
	public BiomeEdenRockMountains(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Rock Mountains");
		this.setHeight(height_HighPlateaus);
		this.setChunkHeightModifier(10);
		this.theBiomeDecorator.generateLakes = false;
		this.grassFoilageColorMultiplier = 0x009f44;
		this.waterColorMultiplier = 0x009f9f;
		this.temperature = 6F;
		this.topBlock = BlockList.edenRock;
		this.fillerBlock = BlockList.edenCobbleRock;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}