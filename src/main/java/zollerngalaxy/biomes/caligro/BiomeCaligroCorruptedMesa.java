/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.caligro;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityFaceless;

public class BiomeCaligroCorruptedMesa extends BiomeCaligroBase {
	
	public BiomeCaligroCorruptedMesa(BiomeProperties props) {
		super("corruptedmesa", props);
		props.setBaseHeight(4.5F);
		props.setHeightVariation(2.2F);
		props.setTemperature(0.1F);
		this.setTempCategory(TempCategory.COLD);
		this.setTemp(0.1F);
		this.setBiomeHeight(92);
		this.setBiomeType(EnumBiomeTypeZG.ABANDONED);
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFaceless.class, 40, 1, 4));
		this.enableSnow = false;
		this.biomeDecor.generateFalls = false;
		this.grassFoliageColor = 0x000;
		this.waterColor = 0x8bcc8b;
		this.topBlock = ZGBlocks.corruptRock.getDefaultState();
		this.fillerBlock = ZGBlocks.corruptCobble.getDefaultState();
		this.stoneBlock = ZGBlocks.corruptStone;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float p_76731_1_) {
		return 0x8bcc8b;
	}
}