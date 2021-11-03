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
import zollerngalaxy.biomes.providers.BiomeProviderAstros;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.IZollernBody;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderAstros;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderAstros;

public class WorldProviderAstros extends WorldProviderMoonZG {
	
	@Override
	public float getGravity() {
		return 0.075F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return ConfigManagerZG.meteorGenEden;
	}
	
	@Override
	public float getSolarSize() {
		return 1.21F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 1.4D;
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
		return -0.2F;
	}
	
	@Override
	public float getMoonTemp() {
		IZollernBody moon = this.getMoon();
		float moonTemp = moon.getBodyTemperature();
		if (!this.isDaytime()) {
			moonTemp /= 1.2F;
		}
		return moonTemp;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.moonAstros;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 1.0045;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.30F);
		
		if (f2 < 0.0F) {
			f2 = 0.5F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		return f2 * f2 * 0.8F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(1.0F);
		float f2 = 0.9F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.3F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 1.0F;
	}
	
	@Override
	public double getHorizon() {
		return 54.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 62;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(2F / 255F * f, 128F / 255F * f, 248F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 1.15F - this.getStarBrightness(1.0F);
		return new Vector3(120 / 255F * f, 21 / 255F * f, 161 / 255F * f);
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
		return 12000L;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		return null;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> list = new LinkedList<>();
		list.add(ZGBlocks.astrosRock);
		list.add(ZGBlocks.astrosDirt);
		return list;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderAstros(this));
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
		BiomeAdaptive.setBodyMultiBiome(ZGPlanets.moonAstros);
		return BiomeProviderAstros.class;
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.ASTROS;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 90;
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
		return ChunkProviderAstros.class;
	}
	
}