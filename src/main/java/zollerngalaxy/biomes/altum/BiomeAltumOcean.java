/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.altum;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntitySquidlus;

public class BiomeAltumOcean extends BiomeAltumBase {
	
	public BiomeAltumOcean(BiomeProperties props) {
		super("altumocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(15.2F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(15.2F);
		this.setBiomeHeight(52);
		this.setBlocks(Blocks.AIR);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityBlubberFish.class, 90, 13, 16));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 75, 2, 4));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquidlus.class, 85, 4, 8));
		this.biomeDecor.waterLakesPerChunk = 6;
		this.grassFoliageColor = 0x009f8b;
		this.stoneBlock = ZGBlocks.altumStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x00aa2e;
	}
}