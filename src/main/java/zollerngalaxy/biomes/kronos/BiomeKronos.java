/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes.kronos;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;
import zollerngalaxy.mobs.entities.EntityMagmos;

public class BiomeKronos extends BiomeKronosBase {
	
	public BiomeKronos(BiomeProperties props) {
		super("kronos_main", props);
		props.setRainDisabled();
		this.setBiomeHeight(120);
		this.setTempCategory(TempCategory.WARM);
		this.setTemp(40F);
		this.setBiomeType(EnumBiomeTypeZG.NETHER);
		this.setBlocks(STONE.getBlock());
		this.enableSnow = false;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmos.class, 25, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 25, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 25, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWitherSkeleton.class, 25, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 25, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 25, 1, 2));
		this.stoneBlock = STONE.getBlock();
	}
}