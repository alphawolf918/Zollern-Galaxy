/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.altum;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeAltumOcean extends BiomeAltumBase {
	
	public BiomeAltumOcean(BiomeProperties props) {
		super("altumocean", props);
		props.setBaseHeight(0.0F);
		props.setHeightVariation(0.0F);
		props.setTemperature(5.2F);
		this.setTempCategory(TempCategory.OCEAN);
		this.setTemp(65.21F);
		this.setBiomeHeight(52);
		this.setBlocks(Blocks.AIR);
		this.setBiomeType(EnumBiomeTypeZG.OCEAN);
		this.clearAllNonMonsterSpawning();
		this.addWaterSpawns();
		this.grassFoliageColor = 0x009f8b;
		this.stoneBlock = ZGBlocks.altumStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float tempIn) {
		return 0x00aa2e;
	}
}