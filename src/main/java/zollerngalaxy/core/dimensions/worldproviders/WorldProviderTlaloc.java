/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
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
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderTlaloc;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderTlaloc;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderTlaloc;
import zollerngalaxy.worldgen.structures.dungeons.RoomTreasureZG;

public class WorldProviderTlaloc extends WorldProviderPlanetZG {
	
	@Override
	public float getGravity() {
		return 0.064F;
	}
	
	@Override
	public float getSolarSize() {
		return 1.02F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return ConfigManagerZG.meteorGenTlaloc;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 5.4D;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.55F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 0.8F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return -0.1F;
	}
	
	@Override
	public float getWindLevel() {
		return this.getPlanet().getWindLevel();
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 5.75;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 92;
	}
	
	@Override
	public float getCloudHeight() {
		return 128F;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(80F / 255F * f, 80F / 255F * f, 88F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 1.15F - this.getStarBrightness(1.0F);
		return new Vector3(100F / 255F * f, 100F / 255F * f, 100F / 255F * f);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return this.getPlanet().getHasRain();
	}
	
	@Override
	public boolean hasSunset() {
		return true;
	}
	
	@Override
	public long getDayLength() {
		return 57216L;
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
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.30F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		return f2 * f2 * 0.2F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.world.getCelestialAngle(1.0F);
		float f2 = 0.9F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 1.5F;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetTlaloc;
	}
	
	@Override
	public double getHorizon() {
		return 62.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 62;
	}
	
	@Override
	public boolean canCoordinateBeSpawn(int var1, int var2) {
		return true;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		return RoomTreasureZG.MOONCHEST;
	}
	
	@Override
	public int getDungeonSpacing() {
		return 800;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		List<Block> blockList = new LinkedList<>();
		blockList.add(ZGBlocks.tlalocRock);
		blockList.add(ZGBlocks.tlalocChrome);
		blockList.add(ZGBlocks.atheonConstructBlock);
		return blockList;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderTlaloc(this));
	}
	
	@Override
	protected void renderCloud() {
		this.setCloudRenderer(new CloudRenderer());
	}
	
	@Override
	protected void renderWeather() {
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.TLALOC;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		BiomeAdaptive.setBodyMultiBiome(ZGPlanets.planetTlaloc);
		return BiomeProviderTlaloc.class;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderTlaloc.class;
	}
}