/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kriffon;

import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMagmos;

public class BiomeKriffon extends BiomeKriffonBase {
	
	public BiomeKriffon(BiomeProperties props) {
		super("kriffon", props);
		props.setRainDisabled();
		this.setTempCategory(TempCategory.WARM);
		this.setBiomeType(EnumBiomeTypeZG.VOLCANIC);
		this.enableSnow = false;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmos.class, 25, 1, 2));
		this.topBlock = ZGBlocks.kriffSurfaceRock.getDefaultState();
		this.fillerBlock = ZGBlocks.kriffDirt.getDefaultState();
		this.stoneBlock = ZGBlocks.kriffStone;
	}
	
	@Override
	public float getSpawningChance() {
		return 0.1F;
	}
	
}