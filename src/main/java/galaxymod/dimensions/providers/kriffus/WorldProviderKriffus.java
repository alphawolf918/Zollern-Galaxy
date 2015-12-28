/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.dimensions.providers.kriffus;

import galaxymod.core.NGPlanets;
import galaxymod.dimensions.chunkmanagers.WorldChunkManagerKriffus;
import galaxymod.dimensions.providers.renderers.SkyProviderKriffus;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.WorldProviderSpace;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.api.world.IExitHeight;
import micdoodle8.mods.galacticraft.api.world.ISolarLevel;
import micdoodle8.mods.galacticraft.core.client.CloudRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.client.IRenderHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderKriffus extends WorldProviderSpace implements
		IExitHeight, ISolarLevel {
	
	@Override
	public float getGravity() {
		return 0.054F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 9.0;
	}
	
	@Override
	public float getSolarSize() {
		return 8.0F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 5.4D;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 4;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.04F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 4F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		if (this.isDaytime()) {
			return 10.0F;
		} else {
			return 5.0F;
		}
	}
	
	@Override
	public float getWindLevel() {
		return 0;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return NGPlanets.planetKriffon;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 20.45;
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
			var3 = 0.75F;
		}
		return var3 * var3 * 0.5F + 0.2F;
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
		return f2 * 4.2F;
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
		return new Vector3(20 / 255F * f, 27 / 255F * f, 64 / 255F * f);
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
		return 4600L;
	}
	
	@Override
	public IRenderHandler getCloudRenderer() {
		return new CloudRenderer();
	}
	
	@Override
	public IRenderHandler getSkyRenderer() {
		return new SkyProviderKriffus(this);
	}
	
	@Override
	public boolean shouldForceRespawn() {
		return true;
	}
	
	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderKriffus.class;
	}
	
	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerKriffus.class;
	}
}