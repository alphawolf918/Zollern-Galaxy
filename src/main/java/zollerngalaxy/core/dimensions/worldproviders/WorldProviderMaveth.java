/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders;

import java.util.LinkedList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderMaveth;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.IZollernBody;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderMaveth;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderMaveth;

public class WorldProviderMaveth extends WorldProviderPlanetZG {
	
	@Override
	public float getGravity() {
		return 0.024F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return ConfigManagerZG.meteorGenMaveth;
	}
	
	@Override
	public float getSolarSize() {
		return 0.02F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 0.8D;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.44F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 2.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return -2.1F;
	}
	
	@Override
	public float getBodyTemp() {
		IZollernBody planet = this.getPlanet();
		float planetTemp = planet.getBodyTemperature();
		if (!this.isDaytime()) {
			planetTemp /= 4.8F;
		}
		return planetTemp;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetMaveth;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.0045;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float var2 = this.world.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);
		
		if (var3 < 0.0F) {
			var3 = 0.25F;
		}
		if (var3 > 1.0F) {
			var3 = 0.75F;
		}
		return var3 * var3 * 0.6F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(1.0F);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.6F;
		}
		if (f2 > 1.0F) {
			f2 = 0.95F;
		}
		f2 = 0.95F - f2;
		return f2 * 0.34F;
	}
	
	@Override
	public double getHorizon() {
		return 54.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 68;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(1F / 255F * f, 1F / 255F * f, 24F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 1.05F - this.getStarBrightness(1.0F);
		return new Vector3(1F / 255F * f, 4F / 255F * f, 48F / 255F * f);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return false;
	}
	
	@Override
	public boolean hasSunset() {
		return true;
	}
	
	@Override
	public long getDayLength() {
		return 680100L;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ZGBlocks.mavethSand);
		list.add(ZGBlocks.mavethRock);
		return list;
	}
	
	@Override
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderMaveth(this));
	}
	
	@Override
	protected void renderCloud() {
		this.setCloudRenderer(new CloudRenderer());
	}
	
	@Override
	protected void renderWeather() {
	}
	
	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		BiomeAdaptive.setBodyMultiBiome(ZGPlanets.planetMaveth);
		return BiomeProviderMaveth.class;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.MAVETH;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 120;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderMaveth.class;
	}
}