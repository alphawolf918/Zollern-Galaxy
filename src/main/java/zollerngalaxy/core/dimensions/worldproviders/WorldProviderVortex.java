/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeAdaptive;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderVortex;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.celestial.ZGPlanets;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderVortex;
import zollerngalaxy.core.dimensions.skyproviders.SkyProviderVortex;

public class WorldProviderVortex extends WorldProviderZG {
	
	private long timeCurrentOffset = 0L;
	public long preTickTime = Long.MIN_VALUE;
	private long saveTCO = 0L;
	static Field tickCounter;
	
	static {
		try {
			tickCounter = VillageCollection.class.getDeclaredField(GCCoreUtil.isDeobfuscated() ? "tickCounter" : "field_75553_e");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public float getGravity() {
		return 0.024F;
	}
	
	@Override
	public float getSolarSize() {
		return 1.8F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 15.0;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 6.2D;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.24F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return -0.5F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 0.0F;
	}
	
	@Override
	public float getWindLevel() {
		return 4.5F;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 6.55;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 150;
	}
	
	@Override
	public float getCloudHeight() {
		return 128F;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(200F / 255F * f, 6F / 255F * f, 248F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		float f = 1.15F - this.getStarBrightness(1.0F);
		return new Vector3(10 / 255F * f, 1F / 255F * f, 251 / 255F * f);
	}
	
	@Override
	public boolean canRainOrSnow() {
		return true;
	}
	
	@Override
	public boolean hasSunset() {
		return true;
	}
	
	@Override
	public long getDayLength() {
		return 16000L;
	}
	
	@Override
	public boolean shouldDisablePrecipitation() {
		return false;
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
		return f2 * f2 * 1.4F;
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
		return f2 * 0.6F;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetVortex;
	}
	
	@Override
	public double getHorizon() {
		return 82.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 82;
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
		blockList.add(ZGBlocks.vortexSurfaceRock);
		return blockList;
	}
	
	@Override
	public void updateWeather() {
		if (!this.world.isRemote) {
			long newTime = world.getWorldInfo().getWorldTime();
			if (this.preTickTime == Long.MIN_VALUE) {
				// First tick: get the timeCurrentOffset from saved ticks in villages.dat :)
				int savedTick = 0;
				try {
					tickCounter.setAccessible(true);
					savedTick = tickCounter.getInt(this.world.villageCollection);
					if (savedTick < 0)
						savedTick = 0;
				} catch (Exception ignore) {
				}
				this.timeCurrentOffset = savedTick - newTime;
			} else {
				// Detect jumps in world time (e.g. because of bed use on Overworld) and reverse
				// them for this world
				long diff = (newTime - this.preTickTime);
				if (diff > 1L) {
					this.timeCurrentOffset -= diff - 1L;
					this.saveTime();
				}
			}
			this.preTickTime = newTime;
			this.saveTCO = 0L;
		}
		
		if (this.shouldDisablePrecipitation()) {
			this.world.getWorldInfo().setRainTime(0);
			this.world.getWorldInfo().setRaining(false);
			this.world.getWorldInfo().setThunderTime(0);
			this.world.getWorldInfo().setThundering(false);
			this.world.rainingStrength = 0F;
			this.world.thunderingStrength = 0F;
		} else {
			this.updateWeatherOverride();
			this.world.getWorldInfo().setRainTime(20);
			this.world.getWorldInfo().setRaining(true);
			this.world.getWorldInfo().setThunderTime(20);
			this.world.getWorldInfo().setThundering(true);
			this.world.rainingStrength = 1.0F;
			this.world.thunderingStrength = 1.0F;
		}
	}
	
	private void saveTime() {
		try {
			VillageCollection vc = this.world.villageCollection;
			tickCounter.setAccessible(true);
			tickCounter.setInt(vc, (int) (this.getWorldTime()));
			vc.markDirty();
		} catch (Exception ignore) {
		}
	}
	
	@Override
	protected void updateWeatherOverride() {
		super.updateWeatherOverride();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderVortex(this));
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
		return ZGDimensions.VORTEX;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public Class<? extends BiomeProvider> getBiomeProviderClass() {
		BiomeAdaptive.setBodyMultiBiome(ZGPlanets.planetVortex);
		return BiomeProviderVortex.class;
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderVortex.class;
	}
}