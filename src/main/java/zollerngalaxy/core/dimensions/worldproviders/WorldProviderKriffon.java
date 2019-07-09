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
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.biomes.providers.BiomeProviderKriffon;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.dimensions.ZGDimensions;
import zollerngalaxy.core.dimensions.chunkproviders.ChunkProviderKriffon;
import zollerngalaxy.core.skyproviders.SkyProviderKriffon;
import zollerngalaxy.planets.ZGPlanet;
import zollerngalaxy.planets.ZGPlanets;

public class WorldProviderKriffon extends WorldProviderZG {
	
	@Override
	public float getGravity() {
		return 0.065F;
	}
	
	@Override
	public double getMeteorFrequency() {
		return 70.0;
	}
	
	@Override
	public float getSolarSize() {
		return 4.0F;
	}
	
	@Override
	public double getFuelUsageMultiplier() {
		return 1.2D;
	}
	
	@Override
	public float getFallDamageModifier() {
		return 0.46F;
	}
	
	@Override
	public float getSoundVolReductionAmount() {
		return 2.0F;
	}
	
	@Override
	public float getThermalLevelModifier() {
		ZGPlanet planet = this.getPlanet();
		float planetTemp = planet.getPlanetTemperature();
		if (this.isDaytime()) {
			planetTemp += 10.1F;
		} else {
			planetTemp -= 4.2F;
		}
		return planetTemp;
	}
	
	@Override
	public CelestialBody getCelestialBody() {
		return ZGPlanets.planetKriffon;
	}
	
	@Override
	public double getSolarEnergyMultiplier() {
		return 2.0F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getStarBrightness(float par1) {
		float var2 = this.world.getCelestialAngle(par1);
		float var3 = 0.1F - (MathHelper.cos(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);
		
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
		float f2 = 2.5F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.2F);
		
		if (f2 < 0.0F) {
			f2 = 0.6F;
		}
		if (f2 > 1.0F) {
			f2 = 0.95F;
		}
		f2 = 0.95F - f2;
		return f2 * 2.5F;
	}
	
	@Override
	public double getHorizon() {
		return 44.0D;
	}
	
	@Override
	public int getAverageGroundLevel() {
		return 68;
	}
	
	@Override
	public Vector3 getFogColor() {
		float f = 1.0F - this.getStarBrightness(1.0F);
		return new Vector3(80 / 255F * f, 0 / 255F * f, 0 / 255F * f);
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
		return 6000L;
	}
	
	@Override
	public ResourceLocation getDungeonChestType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Block> getSurfaceBlocks() {
		ArrayList<Block> blockList = new ArrayList<Block>();
		blockList.add(ZGBlocks.kriffSurfaceRock);
		return blockList;
	}
	
	@Override
	protected void renderSky() {
		this.setSkyRenderer(new SkyProviderKriffon(this));
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
		this.biomeProvider = new BiomeProviderKriffon();
	}
	
	@Override
	public DimensionType getDimensionType() {
		return ZGDimensions.KRIFFON;
	}
	
	@Override
	public double getYCoordinateToTeleport() {
		return 120;
	}
	
	@Override
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public BiomeProvider getBiomeProvider() {
		return new BiomeProviderKriffon();
	}
	
	@Override
	public Class<? extends IChunkGenerator> getChunkProviderClass() {
		return ChunkProviderKriffon.class;
	}
	
}