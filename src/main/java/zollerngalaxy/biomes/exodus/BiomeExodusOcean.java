/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.exodus;

import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityJellyfish;

public class BiomeExodusOcean extends BiomeExodusBase {
	
	public BiomeExodusOcean(BiomeProperties props) {
		super("exodusocean", props);
		props.setRainDisabled();
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(5.0F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(5.0F);
		this.setBiomeHeight(63);
		this.setBlocks(Blocks.AIR);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 100, 1, 2));
		this.spawnableWaterCreatureList.add(new SpawnListEntry(EntityJellyfish.class, 100, 1, 2));
		this.biomeDecor.tallGrassPerChunk = 6;
		this.biomeDecor.flowersPerChunk = 5;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateLakes = true;
		this.biomeDecor.lavaLakesPerChunk = 0;
		this.biomeDecor.deadBushPerChunk = 0;
		this.biomeDecor.waterLakesPerChunk = 6;
		this.biomeDecor.battleTowersPerChunk = 0;
		this.enableSnow = false;
		this.grassFoliageColor = 0x009f00;
		this.waterColor = 0x00009f;
		this.stoneBlock = ZGBlocks.exodusStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x2e002e;
	}
}