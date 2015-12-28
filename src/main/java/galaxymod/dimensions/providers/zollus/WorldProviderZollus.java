package galaxymod.dimensions.providers.zollus;

import galaxymod.core.NGPlanets;
import galaxymod.dimensions.chunkmanagers.WorldChunkManagerZollus;
import galaxymod.dimensions.providers.renderers.SkyProviderZollus;
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

public class WorldProviderZollus extends WorldProviderSpace implements
		IExitHeight, ISolarLevel {
	
	@Override
	public float getGravity() {
		return 0.04F;
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
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 4;
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
		if (this.isDaytime()) {
			return -2.1F;
		} else {
			return -4.2F;
		}
	}
	
	@Override
	public float getWindLevel() {
		return 2;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return NGPlanets.planetZollus;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.045;
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
		return var3 * var3 * 0.2F + 0.1F;
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
		return f2 * 1.2F;
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
		return 46019L;
	}
	
	@Override
	public IRenderHandler getCloudRenderer() {
		return new CloudRenderer();
	}
	
	@Override
	public IRenderHandler getSkyRenderer() {
		return new SkyProviderZollus(this);
	}
	
	@Override
	public boolean shouldForceRespawn() {
		return true;
	}
	
	@Override
	public Class<? extends IChunkProvider> getChunkProviderClass() {
		return ChunkProviderZollus.class;
	}
	
	@Override
	public Class<? extends WorldChunkManager> getWorldChunkManagerClass() {
		return WorldChunkManagerZollus.class;
	}
	
}