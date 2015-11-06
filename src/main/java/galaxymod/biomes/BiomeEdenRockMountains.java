package galaxymod.biomes;

import java.awt.Color;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import galaxymod.blocks.BlockList;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;

public class BiomeEdenRockMountains extends BiomeGenBase {
	public BiomeEdenRockMountains(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Rock Mountains");
		this.setHeight(height_HighPlateaus);
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.flowersPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.grassPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = -999;
		this.waterColorMultiplier = 0x009f9f;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.temperature = 6F;
		this.topBlock = BlockList.edenRock;
		this.fillerBlock = BlockList.edenCobbleRock;
	}

	public int getModdedBiomeFoliageColor(int original) {
		return 0x009fbb;
	}

	public int getModdedBiomeGrassColor(int original) {
		return 0x009f44;
	}

	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f2a00;
	}
}