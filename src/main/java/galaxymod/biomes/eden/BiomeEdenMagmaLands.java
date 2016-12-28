/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.biomes.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.blocks.BlockList;
import galaxymod.core.ZGPlanets;
import net.minecraft.entity.monster.EntityBlaze;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeEdenMagmaLands extends BiomeGenEdenBase {
	public BiomeEdenMagmaLands(int par1) {
		super(par1);
		this.setColor(BiomeList.biomeColor);
		this.setBiomeName("Magma Lands");
		this.setPlanetForBiome(ZGPlanets.planetEden);
		this.setDisableRain();
		this.biomeDecor.edenLakesPerChunk = 8;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenWoodTreesPerChunk = 0;
		this.biomeDecor.edenDeadBushPerChunk = 0;
		this.grassFoilageColorMultiplier = 0x000;
		this.waterColorMultiplier = 0x000000;
		this.temperature = 8.5F;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class,
				100, 1, 2));
		this.topBlock = BlockList.edenMagmaRock;
		this.fillerBlock = BlockList.edenRock;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x000000;
	}
}