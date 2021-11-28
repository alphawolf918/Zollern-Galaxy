/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.eden;

import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityPigShroom;

public class BiomeShroomHills extends BiomeEdenBase {
	
	public BiomeShroomHills(BiomeProperties props) {
		super("shroomhills", props);
		props.setRainDisabled();
		props.setBaseHeight(-0.5F);
		props.setHeightVariation(1.1F);
		props.setTemperature(5.5F);
		this.setTempCategory(TempCategory.MEDIUM);
		this.setTemp(5.5F);
		this.setBiomeHeight(52);
		this.setBiomeType(EnumBiomeTypeZG.WEIRD);
		this.clearAllNonMonsterSpawning();
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPigShroom.class, 100, 1, 2));
		if (ConfigManagerZG.canEarthAnimalsSpawnOnEden) {
			this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 100, 1, 2));
		}
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCraters = true;
		this.biomeDecor.generateMushroomTrees = true;
		this.biomeDecor.waterLakesPerChunk = 2;
		this.biomeDecor.lavaLakesPerChunk = 1;
		this.biomeDecor.edenTallGrassPerChunk = 0;
		this.biomeDecor.edenFlowersPerChunk = 0;
		this.biomeDecor.edenTreesPerChunk = 0;
		this.biomeDecor.mushroomTreesPerChunk = 5;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x002bcc;
		this.topBlock = ZGBlocks.blockRedshroom.getDefaultState();
		this.fillerBlock = ZGBlocks.blockRedshroomStem.getDefaultState();
		this.stoneBlock = ZGBlocks.edenStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xff2ad8;
	}
}