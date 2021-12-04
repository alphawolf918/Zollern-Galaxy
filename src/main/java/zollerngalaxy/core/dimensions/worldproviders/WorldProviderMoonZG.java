/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.dimensions.worldproviders;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.celestial.ZGMoon;

public abstract class WorldProviderMoonZG extends WorldProviderZG {
	
	private static WorldProviderMoonZG instance;
	
	public WorldProviderMoonZG() {
		instance = this;
	}
	
	public static WorldProviderMoonZG instance() {
		return instance;
	}
	
	@Override
	public String getSaveFolder() {
		return "moons/" + this.getMoon().getName();
	}
	
	@Override
	public World getWorldObj() {
		return this.world;
	}
	
	@Override
	public boolean shouldForceRespawn() {
		return !ConfigManagerCore.forceOverworldRespawn;
	}
	
	public ZGMoon getMoon() {
		CelestialBody moon = this.getCelestialBody();
		ZGMoon moonNova = (ZGMoon) moon;
		return moonNova;
	}
	
	@Override
	public float getSolarSize() {
		return 1.0F;
	}
	
	@Override
	public Vector3 getFogColor() {
		return new Vector3(0, 0, 0);
	}
	
	@Override
	public boolean canBlockFreeze(BlockPos pos, boolean byWater) {
		return this.getMoon().getIsColdBody();
	}
	
	@Override
	public void updateWeather() {
		World worldObj = this.getWorldObj();
		WorldInfo worldInfo = worldObj.getWorldInfo();
		if (!this.shouldDisablePrecipitation()) {
			super.updateWeather();
		} else {
			worldInfo.setRainTime(0);
			worldInfo.setRaining(false);
			worldInfo.setThunderTime(0);
			worldInfo.setThundering(false);
			worldObj.rainingStrength = 0.0F;
			worldObj.thunderingStrength = 0.0F;
		}
	}
	
	@Override
	public float getWindLevel() {
		return this.getMoon().getWindLevel();
	}
	
	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 0);
	}
	
	@Override
	public boolean canRespawnHere() {
		if (EventHandlerGC.bedActivated) {
			EventHandlerGC.bedActivated = false;
			return true;
		}
		return false;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 0.5D;
	}
	
	@Override
	public double getMeteorFrequency() {
		return this.getMoon().getAtmosphericDensity();
	}
	
	@Override
	public float getArrowGravity() {
		return 0.003F;
	}
	
	@Override
	public int getDungeonSpacing() {
		return 704;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return this.getMoon().getIsBreathable();
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= this.getMoon().getTierRequirement();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getSkyRenderer() {
		if (super.getSkyRenderer() == null) {
			this.renderSky();
		}
		return super.getSkyRenderer();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getCloudRenderer() {
		if (super.getCloudRenderer() == null) {
			this.renderCloud();
		}
		return super.getCloudRenderer();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IRenderHandler getWeatherRenderer() {
		if (super.getWeatherRenderer() == null) {
			this.renderWeather();
		}
		return super.getWeatherRenderer();
	}
	
	@Override
	public boolean hasSkyLight() {
		return true;
	}
	
	@Override
	protected abstract void renderSky();
	
	@Override
	protected abstract void renderCloud();
	
	@Override
	protected abstract void renderWeather();
	
	public float getBodyTemp() {
		ZGMoon moon = this.getMoon();
		float planetTemp = moon.getBodyTemperature();
		
		if (this.isDaytime()) {
			planetTemp /= 2.2F;
		} else {
			planetTemp = moon.getBodyTemperature();
		}
		
		return planetTemp;
	}
	
	@Override
	public abstract Class<? extends IChunkGenerator> getChunkProviderClass();
	
}