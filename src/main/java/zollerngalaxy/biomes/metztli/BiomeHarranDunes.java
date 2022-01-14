/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.metztli;

import net.minecraft.entity.monster.EntityStray;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityScorpion;

public class BiomeHarranDunes extends BiomeHarranBase {
	
	public BiomeHarranDunes(BiomeProperties props) {
		super("harran_dunes", props);
		this.setupBiome(props);
	}
	
	public BiomeHarranDunes(String singleName, BiomeProperties props) {
		super(singleName, props);
		this.setupBiome(props);
	}
	
	private void setupBiome(BiomeProperties props) {
		this.setTempCategory(TempCategory.WARM);
		props.setBaseHeight(1.4F);
		props.setHeightVariation(1.5F);
		props.setTemperature(9.0F);
		this.setTemp(75F);
		this.setBiomeHeight(82);
		this.setBiomeType(EnumBiomeTypeZG.DESERT);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityStray.class, 80, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMummy.class, 100, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityScorpion.class, 100, 1, 4));
		this.enableSnow = false;
		this.biomeDecor.generateFalls = true;
		this.biomeDecor.generateCacti = true;
		this.biomeDecor.generateDeadBushes = true;
		this.biomeDecor.generateTrees = false;
		this.biomeDecor.generateMushroomTrees = false;
		this.biomeDecor.generateTallGrass = false;
		this.biomeDecor.generateFerns = false;
		this.biomeDecor.generateWaterLilies = false;
		this.biomeDecor.waterLakesPerChunk = 1;
		this.biomeDecor.lavaLakesPerChunk = 6;
		this.biomeDecor.deadBushesPerChunk = 8;
		this.grassFoliageColor = 0x345a83;
		this.waterColor = 0x00008b;
		this.topBlock = Blocks.SAND.getDefaultState();
		this.fillerBlock = Blocks.SANDSTONE.getDefaultState();
		this.stoneBlock = Blocks.STONE;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0xcc3a4b;
	}
}