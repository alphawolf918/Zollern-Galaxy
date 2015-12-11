package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenRockMountains extends BiomeGenEdenBase {
	public BiomeEdenRockMountains(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Rock Mountains");
		this.setHeightBaseModifier(236);
		this.setHeight(new Height(0.5F, 0.6F));
		this.setChunkHeightModifier(10);
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.theBiomeDecorator.generateLakes = false;
		this.grassFoilageColorMultiplier = 0x009f44;
		this.waterColorMultiplier = 0x009f9f;
		this.temperature = 6F;
		this.enableRain = false;
		this.topBlock = BlockList.edenRock;
		this.fillerBlock = BlockList.edenCobbleRock;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2ad8;
	}
}