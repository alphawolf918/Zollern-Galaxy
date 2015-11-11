package galaxymod.dimensions.providers.zollus;

import galaxymod.core.NGCore;
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
		return 5.0;
	}
	
	@Override
	public float getSolarSize() {
		return 2.0F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 0.4D;
	}
	
	@Override
	public boolean canSpaceshipTierPass(int tier) {
		return tier >= 3;
	}
	
	@Override
	public boolean hasBreathableAtmosphere() {
		return false;
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
			return 0.0F;
		} else {
			return -0.05F;
		}
	}
	
	@Override
	public float getWindLevel() {
		return 0;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return NGCore.zollus;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 0.45;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 400;
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
		return new Vector3(20 / 255F * f, 27 / 255F * f, 33 / 255F * f);
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
		return 46000L;
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
		return false;
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