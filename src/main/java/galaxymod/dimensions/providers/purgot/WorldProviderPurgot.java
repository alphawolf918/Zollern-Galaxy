/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.dimensions.providers.purgot;

import galaxymod.core.ZGPlanets;
import galaxymod.dimensions.chunkmanagers.WorldChunkManagerPurgot;
import galaxymod.dimensions.providers.WorldProviderNova;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderPurgot extends WorldProviderNova {
	
	@Override
	public float getGravity() {
		return 0.068F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 8.0;
	}
	
	@Override
	public void updateWeather() {
		if (this.canRainOrSnow()) {
			super.updateWeather();
		} else {
			this.worldObj.getWorldInfo().setRainTime(0);
			this.worldObj.getWorldInfo().setRaining(false);
			this.worldObj.getWorldInfo().setThunderTime(0);
			this.worldObj.getWorldInfo().setThundering(false);
			this.worldObj.rainingStrength = 0.0F;
			this.worldObj.thunderingStrength = 0.0F;
		}
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return true;
	}
	
	@Override
	public float getSolarSize() {
		return 1.0F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 2.4D;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 5;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.44F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 4F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return -1.4F;
	}
	
	@Override
	public float getWindLevel() {
		return 0;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetPurgot;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.02;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 120;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float var2 = this.worldObj.getCelestialAngle(par1);
		float var3 = 1.0F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);
		
		if (var3 < 0.0F) {
			var3 = 0.25F;
		}
		if (var3 > 1.0F) {
			var3 = 0.45F;
		}
		return var3 * var3 * 0.8F + 0.6F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.worldObj.getCelestialAngle(1.0F);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.6F;
		}
		if (f2 > 1.0F) {
			f2 = 0.95F;
		}
		f2 = 0.95F - f2;
		return f2 * 1.4F;
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
		return new Vector3(20 / 255F * f, 20 / 255F * f, 20 / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		return new Vector3(50, 50, 50);
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
		return 22000L;
	}
	
	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderPurgot.class;
	}
	
	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerPurgot.class;
	}
	
}