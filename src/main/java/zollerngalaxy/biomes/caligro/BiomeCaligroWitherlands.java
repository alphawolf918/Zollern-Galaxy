/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.caligro;

import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class BiomeCaligroWitherlands extends BiomeCaligroBase {
	
	public BiomeCaligroWitherlands(BiomeProperties props) {
		super("witherlands", props);
		props.setBaseHeight(-1.5F);
		props.setHeightVariation(0.2F);
		props.setTemperature(10.0F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(10.0F);
		this.setBiomeHeight(62);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitherSkeleton.class, 80, 1, 4));
		this.enableSnow = false;
		this.biomeDecor.generateFalls = false;
		this.grassFoliageColor = 0xeee;
		this.waterColor = 0xeee;
		this.topBlock = ZGBlocks.witherrack.getDefaultState();
		this.fillerBlock = ZGBlocks.caligroStone.getDefaultState();
		this.stoneBlock = ZGBlocks.caligroStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x0d0;
	}
}