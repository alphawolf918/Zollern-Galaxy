package zollerngalaxy.core.dimensions.worldproviders;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.event.EventHandlerGC;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.planets.ZGPlanet;

public abstract class WorldProviderZG extends WorldProviderSpace implements
		ISolarLevel, IExitHeight {
	
	@Override
	public String getSaveFolder() {
		return "planets/" + this.getCelestialBody().getName();
	}
	
	public World getWorldObj() {
		return this.world;
	}
	
	@Override
	public boolean shouldForceRespawn() {
		return true;
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
		return 0.9D;
	}
	
	@Override
	public double getMeteorFrequency() {
		CelestialBody planet = this.getCelestialBody();
		float d;
		if (planet instanceof ZGPlanet) {
			ZGPlanet planetNova = (ZGPlanet) planet;
			d = ((ZGPlanet) planet).getAtmosphericDensity();
			return d;
		}
		d = planet.atmosphere.relativeDensity();
		if (d <= 0.0F) {
			return 10.0D;
		}
		return d * 110D;
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
		CelestialBody planet = this.getCelestialBody();
		if (planet instanceof ZGPlanet) {
			ZGPlanet planetNova = (ZGPlanet) planet;
			return planetNova.getIsBreathable();
		}
		return false;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier <= this.getCelestialBody().getTierRequirement();
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
	
	protected abstract void renderSky();
	
	protected abstract void renderCloud();
	
	protected abstract void renderWeather();
	
	@Override
	public abstract void init();
	
	@Override
	public abstract Class<? extends IChunkGenerator> getChunkProviderClass();
	
}