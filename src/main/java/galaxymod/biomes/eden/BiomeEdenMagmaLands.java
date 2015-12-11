/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.core.NGCore;
import net.minecraft.entity.monster.EntityBlaze;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenMagmaLands extends BiomeGenEdenBase {
	public BiomeEdenMagmaLands(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Magma Lands");
		this.setPlanetForBiome(NGCore.eden);
		this.setHeightBaseModifier(226);
		this.setHeight(new Height(0.5F, 0.6F));
		this.setDisableRain();
		this.setChunkHeightModifier(10);
		this.biomeDecor.edenLakesPerChunk = 8;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenWoodTreesPerChunk = 0;
		this.biomeDecor.edenDeadBushPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x009f44;
		this.waterColorMultiplier = 0x009f9f;
		this.temperature = 8.5F;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 5,
				2, 4));
		this.topBlock = BlockList.edenMagmaRock;
		this.fillerBlock = BlockList.edenMagmaRock;
	}
	
	@Override
	public float getSpawningChance() {
		return 5.0F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x4f0000;
	}
}