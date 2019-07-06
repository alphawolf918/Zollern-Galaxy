package zollerngalaxy.core.dimensions.worldproviders;

import java.util.ArrayList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderZollus;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderZollus;
import zollerngalaxy.core.skyproviders.SkyProviderZollus;
import zollerngalaxy.planets.ZGPlanet;
import zollerngalaxy.planets.ZGPlanets;

public class WorldProviderZollus extends WorldProviderZG {
	
	@Override
	public float getGravity() {
		return 0.02F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 6.0;
	}
	
	@Override
	public void updateWeather() {
		if (this.canRainOrSnow()) {
			super.updateWeather();
		} else {
			this.world.getWorldInfo().setRainTime(0);
			this.world.getWorldInfo().setRaining(false);
			this.world.getWorldInfo().setThunderTime(0);
			this.world.getWorldInfo().setThundering(false);
			this.world.rainingStrength = 0.0F;
			this.world.thunderingStrength = 0.0F;
		}
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public float getSolarSize() {
		return 1.0F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 0.4D;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.44F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 2F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		CelestialBody planet = this.getCelestialBody();
		if (planet instanceof ZGPlanet) {
			ZGPlanet planetNova = (ZGPlanet) planet;
			float planetTemp = planetNova.getPlanetTemperature();
			if (this.isDaytime()) {
				planetTemp -= -2.1F;
			} else {
				planetTemp -= -4.2F;
			}
			return planetTemp;
		}
		if (this.isDaytime()) {
			return -2.1F;
		} else {
			return -4.2F;
		}
	}
	
	@Override
	public float getWindLevel() {
		CelestialBody planet = this.getCelestialBody();
		if (planet instanceof ZGPlanet) {
			ZGPlanet planetNova = (ZGPlanet) planet;
			return ((ZGPlanet) planet).getWindLevel();
		}
		return 2.0F;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetZollus;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.045;
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
		return var3 * var3 * 0.2F + 0.1F;
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
		return f2 * 1.1F;
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
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(20 / 255F * f, 27 / 255F * f, 45 / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		return new Vector3(0, 0, 210);
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
		return 46010L;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		ArrayList<Block> blockList = new ArrayList<Block>();
		blockList.add(ZGBlocks.zolSurfaceRock);
		return blockList;
	}
	
	@Override
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderZollus(this));
	}
	
	@Override
	protected void renderCloud() {
		this.setCloudRenderer(new CloudRenderer());
	}
	
	@Override
	protected void renderWeather() {
	}
	
	@Override
	public void init() {
		this.biomeProvider = new BiomeProviderZollus();
	}
	
	@Override
	public IChunkGenerator createChunkGenerator() {
		return new ChunkProviderZollus(this.world, this.world.getSeed());
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.ZOLLUS;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 120;
	}
	
}