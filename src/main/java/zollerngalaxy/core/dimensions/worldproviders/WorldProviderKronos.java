/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderKronos;
import zollerngalaxy.celestial.IZollernBody;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderKronos;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderKronos;

public class WorldProviderKronos extends WorldProviderPlanetZG {
	
	@Override
	public boolean doesWaterVaporize() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return true;
	}
	
	@Override
	public float getGravity() {
		return 0.055F;
	}
	
	@Override
	public float getSolarSize() {
		return 0.12F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return ConfigManagerZG.meteorGenKronos;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 21.2D;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return this.getPlanet().getIsBreathable();
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.36F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 4.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 3.2F;
	}
	
	@Override
	public float getBodyTemp() {
		IZollernBody planet = this.getPlanet();
		float planetTemp = planet.getBodyTemperature();
		if (this.isDaytime()) {
			planetTemp += 10.13F;
		} else {
			planetTemp -= 3.2F;
		}
		return planetTemp;
	}
	
	@Override
	public float getWindLevel() {
		return this.getPlanet().getWindLevel();
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.5F;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 74;
	}
	
	@Override
	public float getCloudHeight() {
		return 128F;
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 0.6F - this.getStarBrightness(1.0F);
		return new Vector3(80 / 255F * f, 0 / 255F * f, 0 / 255F * f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) {
		return new Vec3d(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return this.getPlanet().getHasRain();
	}
	
	@Override
	public boolean hasSunset() {
		return false;
	}
	
	@Override
	public long getDayLength() {
		return 68010L;
	}
	
	@Override
	public boolean shouldDisablePrecipitation() {
		return !this.canRainOrSnow();
	}
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return this.canRainOrSnow();
	}
	
	@Override
	public boolean canRespawnHere() {
		return this.shouldForceRespawn();
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetKronos;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(par1);
		float f2 = 0.5F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.30F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		return f2 * f2 * 0.05F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(1.0F);
		float f2 = 0.5F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 0.1F;
	}
	
	@Override
	public double getMovementFactor() {
		return 16.0D;
	}
	
	@Override
	public float calculateCelestialAngle(long par1, float par3) {
		return 0.5F;
	}
	
	@Override
	public WorldBorder createWorldBorder() {
		return new WorldBorder() {
			@Override
			public double getCenterX() {
				return super.getCenterX() / 16.0D;
			}
			
			@Override
			public double getCenterZ() {
				return super.getCenterZ() / 16.0D;
			}
		};
	}
	
	@Override
	protected void generateLightBrightnessTable() {
		float f = 0.1F;
		
		for (int i = 0; i <= 15; ++i) {
			float f1 = 1.0F - i / 15.0F;
			this.lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * 0.9F + 0.1F;
		}
	}
	
	@Override
	public double getHorizon() {
		return 75.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 58;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		ArrayList<Block> blockList = new ArrayList<Block>();
		blockList.add(Blocks.NETHERRACK);
		return blockList;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderKronos(this));
	}
	
	@Override
	protected void renderCloud() {
		this.setCloudRenderer(new CloudRenderer());// WorldProviderHell
	}
	
	@Override
	protected void renderWeather() {
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.KRONOS;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		BiomeAdaptive.setBodyMultiBiome(ZGPlanets.planetKronos);
		return BiomeProviderKronos.class;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderKronos.class;
	}
}