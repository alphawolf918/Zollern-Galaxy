/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders.orbit;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.Constants;
import micdoodle8.mods.galacticraft.core.dimension.WorldProviderOverworldOrbit;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.celestial.spacestations.ZGSpaceStations;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderOrbitZG;
import zollerngalaxy.lib.ZGInfo;

public class WorldProviderOrbitXantheon extends WorldProviderOverworldOrbit {
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGSpaceStations.XANTHEON_SPACE_STATION;
	}
	
	@Override
	public float getSolarSize() {
		return 0.01F;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(60F / 255F * f, 60F / 255F * f, 60F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 0);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return false;
	}
	
	@Override
	public boolean hasSunset() {
		return false;
	}
	
	@Override
	public long getDayLength() {
		return 106020L;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderOrbitZG.class;
	}
	
	@Override
	public boolean isDaytime() {
		final float a = this.world.getCelestialAngle(0F);
		return a < 0.42F || a > 0.58F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		final float var2 = this.world.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * Constants.twoPI) * 2.0F + 0.25F);
		
		if (var3 < 0.0F) {
			var3 = 0.0F;
		}
		
		if (var3 > 1.0F) {
			var3 = 1.0F;
		}
		
		return var3 * var3 * 0.5F + 0.3F;
	}
	
	@Override
	public boolean isSkyColored() {
		return false;
	}
	
	@Override
	public double getHorizon() {
		return 44.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 44;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public float getGravity() {
		return 0.073F;// 0.073F;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 0;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 1.0D;
	}
	
	@Override
	public String getPlanetToOrbit() {
		return "planet.xantheon";
	}
	
	@Override
	public String getSaveFolder() {
		return ZGInfo.SPACE_STATION_PFX + "/xantheon";
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return ConfigManagerCore.spaceStationEnergyScalar;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier > ZGPlanets.planetXantheon.getTierRequirement();
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.4F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 50.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 0;
	}
	
	@Override
	public float getWindLevel() {
		return 0.1F;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.XANTHEON_ORBIT;
	}
}