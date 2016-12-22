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

package galaxymod.dimensions.providers.oasis;

import galaxymod.core.ZGPlanets;
import galaxymod.dimensions.chunkmanagers.WorldChunkManagerOasis;
import galaxymod.dimensions.providers.WorldProviderNova;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldProviderOasis extends WorldProviderNova {
	
	@Override
	public float getGravity() {
		return 0.05F;
	}
	
	@Override
	public World getWorldObj() {
		return this.worldObj;
	}
	
	@Override
	public float getSolarSize() {
		return 2.0F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 5.0;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 6.8D;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 3;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return true;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 1.0F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		return 0.0F;
	}
	
	@Override
	public float getWindLevel() {
		return 2.5F;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetOasis;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 4.68;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 420;
	}
	
	@Override
	public boolean canBlockFreeze(int x, int y, int z, boolean byWater) {
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
		float f1 = this.worldObj.getCelestialAngle(par1);
		float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.30F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		return f2 * f2 * 0.6F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getSunBrightness(float par1) {
		float f1 = this.worldObj.getCelestialAngle(1.0F);
		float f2 = 0.9F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.0F;
		}
		if (f2 > 1.0F) {
			f2 = 1.0F;
		}
		f2 = 1.0F - f2;
		return f2 * 1.0F;
	}
	
	@Override
	public double getHorizon() {
		return 64.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 64;
	}
	
	@Override
	public float getCloudHeight() {
		return 218F;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.1F - this.getStarBrightness(1.0F);
		return new Vector3(248F / 255F * f, 255F / 255F * f, 248F / 255F * f);
	}
	
	@Override
	public Vector3 getSkyColor() {
		if (this.worldObj.isRaining()) {
			float f = 1.15F - this.getStarBrightness(1.0F);
			return new Vector3(195 / 255F * f, 170 / 255F * f, 190 / 255F * f);
		}
		float f = 1.15F - this.getStarBrightness(1.0F);
		return new Vector3(120 / 255F * f, 161 / 255F * f, 120 / 255F * f);
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
		return 36000L;
	}
	
	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderOasis.class;
	}
	
	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerOasis.class;
	}
}