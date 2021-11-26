/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.celestial;

import java.util.ArrayList;
import java.util.Random;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import zollerngalaxy.biomes.BiomeSpace;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderMoonZG;
import zollerngalaxy.core.dimensions.worldproviders.WorldProviderPlanetZG;
import zollerngalaxy.core.enums.EnumBodyClass;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGMoon extends Moon implements IZollernBody {
	
	private EnumBodyClass bodyClass;
	
	private Star bodyStar;
	
	private float baseTemp;
	private float baseRadiation;
	private float baseToxicity;
	private float windLevel;
	private float density;
	
	private boolean breathable;
	private boolean rains;
	
	private AtmosphereInfo atmosphere;
	private ArrayList<EnumAtmosphericGas> bodyGasses = new ArrayList<EnumAtmosphericGas>();
	
	private WorldProviderPlanetZG spaceProvider = null;
	
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	
	public ZGMoon(String moonName) {
		super(moonName);
		this.setPhaseShift(0.0F);
		this.setRelativeSize(1.0F);
		this.addChecklistKeys("thermal_padding", "equip_oxygen_suit", "equip_parachute");
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance, scaledDistance));
		return this;
	}
	
	public CelestialBody setRelativeDistanceFromCenter(float scaledDistance1, float scaledDistance2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(scaledDistance1, scaledDistance2));
		return this;
	}
	
	public ZGMoon setBodyStar(Star systemStar) {
		this.bodyStar = systemStar;
		return this;
	}
	
	/**
	 * Sets the Body's
	 * bioclassification. This is purely for classification*
	 * and visual purposes.<br>
	 * *<br>
	 * *Categories:<br>
	 * *<br>
	 * *D:
	 * A small, rock-
	 * based body, typically
	 * a heavily-
	 * cratered asteroid, moon,*
	 * or bodyoid
	 * with little
	 * or no atmosphere.<br>
	 * *<br>
	 * *H:
	 * A characteristically
	 * lifeless body, uninhabitable
	 * by humans.Could*
	 * contain gasses
	 * Oxygen and Argon.<br>
	 * *<br>
	 * *J:
	 * Typically a
	 * gas giant, usually
	 * with wind
	 * speeds of over 10
	 * k kmph.Also*
	 * should contain
	 * Fluorine gas
	 * in its atmosphere.<br>
	 * *<br>
	 * *K:
	 * A typically
	 * uninhabitable world
	 * made sustainable
	 * by pressure
	 * domes and*life-
	 * support systems.<br>
	 * *<br>
	 * *L:
	 * A barely
	 * habitable world
	 * or moon
	 * that usually
	 * consists of an*Oxygen/
	 * Argon atmosphere.
	 * Typically rich
	 * with flora, but
	 * no fauna.<br>
	 * *<br>
	 * *M:
	 * A habitable
	 * world suitable for
	 * sustaining human life,
	 * with little or*
	 * no terraforming
	 * required.Atmosphere is
	 * usually composed
	 * of Nitrogen,*
	 * Oxygen and
	 * other trace elements,
	 * usually those required for life.These*
	 * worlds are
	 * usually abundant
	 * with water, flora, and fauna,
	 * with a core*
	 * rich in
	 * Nickel and
	 * Iron.Some of
	 * these worlds
	 * can emit electromagnetic*
	 * radiation. Usually has
	 * its own
	 * entire ecosystem
	 * and amino acids.<br>
	 * *<br>
	 * *N:
	 * A world
	 * with very
	 * little gravity, rich
	 * in minable,volatile resources,*
	 * typically used
	 * in explosives.<br>
	 * *<br>
	 * *T:
	 * A type
	 * of gas giant,
	 * typically home
	 * to dark
	 * matter life.<br>
	 * *<br>
	 * *R:
	 * A lesser
	 * bioclassification of
	 * a Class
	 * M body, these
	 * worlds are*
	 * generally habitable, however
	 * they lack
	 * some or
	 * most of the*characteristics for
	 * a terrestrial body.<br>
	 * *<br>
	 * *Y:
	 * A world
	 * characterized by
	 * a toxic atmosphere,
	 * thermionic radiation*
	 * discharges and
	 * surface temperatures
	 * at or
	 * above five
	 * hundred Kelvin,*
	 * nicknamed the"demon class."
	 * Typically hazardous
	 * to both
	 * humans and*starships.<br>
	 * *<br>
	 * *NINE:
	 * Another type
	 * of gas giant,
	 * usually located
	 * in the
	 * home star system*
	 * of a
	 * hostile race.<br>
	 * *<br>
	 * *Exotic:
	 * A strange
	 * world that
	 * is uniquely
	 * proportioned and
	 * makes no*
	 * logical sense;
	 * an anomaly.<br>
	 * *<br>
	 * *Abandoned:
	 * A desolate void,
	 * long abandoned
	 * due to
	 * catastrophe or other*hostility.<br>
	 * **
	 * 
	 * @param
	 * 			pClass*The
	 *            bioclassification
	 *            of the Body.*@return
	 *            The Body
	 *            to apply this
	 *            bioclassification to.
	 */
	public ZGMoon setBodyClass(EnumBodyClass pClass) {
		this.bodyClass = pClass;
		return this;
	}
	
	/**
	 * Sets the body's base temperature.
	 * 
	 * @param bodyTemp
	 *            The temperature to set.
	 * @return The Body to apply this effect to.
	 */
	public ZGMoon setBodyTemperature(float bodyTemp) {
		this.baseTemp = bodyTemp;
		return this;
	}
	
	/**
	 * Sets the body's base radiation level. Anything >= 10.0 requires the
	 * radiation protection blueprint.
	 * 
	 * @param bodyRad
	 *            The radiation level to set.
	 * @return The Body to apply this effect to.
	 */
	public ZGMoon setBodyRadiation(float bodyRad) {
		this.baseRadiation = bodyRad;
		return this;
	}
	
	/**
	 * Sets the body's base toxicity level. Anything >= 15.0 requires the
	 * toxicity protection blueprint.
	 * 
	 * @param bodyTox
	 *            The toxicity level of the body.
	 * @return The Body to apply this effect to.
	 */
	public ZGMoon setBodyToxicity(float bodyTox) {
		this.baseToxicity = bodyTox;
		return this;
	}
	
	public ZGMoon setBreathable(boolean canBreathe) {
		this.breathable = canBreathe;
		return this;
	}
	
	public ZGMoon setHasRain(boolean hasRain) {
		this.rains = hasRain;
		return this;
	}
	
	public ZGMoon setWindLevel(float windLvl) {
		this.windLevel = windLvl;
		return this;
	}
	
	public ZGMoon setDensity(float denseLvl) {
		this.density = denseLvl;
		return this;
	}
	
	/**
	 * Sets the body's atmosphere. Atmosphere is determined by several
	 * factors: Is the body breathable? Does the body have rain? Is the
	 * body corrosive (radioactive or toxic)? What's the body's temperature?
	 * How strong is the wind level? How strong is the density level?
	 * 
	 * @return The body of the atmosphere being set on.
	 */
	public ZGMoon setAtmosphere() {
		this.atmosphere = new AtmosphereInfo(this.getIsBreathable(), this.getHasRain(), this.getIsCorrosive(), this.getBodyTemperature(), this.getWindLevel(),
				this.getAtmosphericDensity());
		return this;
	}
	
	public ZGMoon setBodyGasses(EnumAtmosphericGas... gasses) {
		for (EnumAtmosphericGas gas : gasses) {
			if (gas != null) {
				this.atmosphereComponent(gas);
				this.bodyGasses.add(gas);
			}
		}
		return this;
	}
	
	public ZGMoon setDisableRockets(boolean disableRockets, int bodyTier) {
		if (disableRockets) {
			this.setTierRequired(-1);
		} else {
			this.setTierRequired(bodyTier);
		}
		return this;
	}
	
	public ZGMoon setDisableRockets() {
		this.setTierRequired(-1);
		return this;
	}
	
	public ZGMoon setDistanceFromCenter(float par1, float par2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(par1, par2));
		return this;
	}
	
	public ZGMoon setDistanceFromCenter(float par1) {
		this.setDistanceFromCenter(par1, par1);
		return this;
	}
	
	public ZGMoon setBodyIcon(String bodyTexture) {
		this.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/" + bodyTexture + ".png"));
		return this;
	}
	
	public ZGMoon setSpaceProvider(WorldProviderPlanetZG provider) {
		this.spaceProvider = provider;
		return this;
	}
	
	public WorldProviderPlanetZG getSpaceProvider() {
		return this.spaceProvider;
	}
	
	public Star getBodyStar() {
		return this.bodyStar;
	}
	
	@Override
	public float getRadiationLevel() {
		return this.baseRadiation;
	}
	
	@Override
	public float getToxicLevel() {
		return this.baseToxicity;
	}
	
	/**
	 * Get the Body's bioclassification. This is purely for classification and
	 * visual purposes.<br>
	 * <br>
	 * Categories:<br>
	 * <br>
	 * D: A small, rock-based body, typically a heavily-cratered asteroid, moon,
	 * or bodyoid with little or no atmosphere. <br>
	 * <br>
	 * H: A characteristically lifeless body, uninhabitable by humans. Could
	 * contain gasses Oxygen and Argon.<br>
	 * <br>
	 * J: Typically a gas giant, usually with wind speeds of over 10k kmph. Also
	 * should contain Fluorine gas in its atmosphere.<br>
	 * <br>
	 * K: A typically uninhabitable world made sustainable by pressure domes and
	 * life-support systems.<br>
	 * <br>
	 * L: A barely habitable world or moon that usually consists of an
	 * Oxygen/Argon atmosphere. Typically rich with flora, but no fauna.<br>
	 * <br>
	 * M: A habitable world suitable for sustaining human life, with little or
	 * no terraforming required. Atmosphere is usually composed of Nitrogen,
	 * Oxygen and other trace elements, usually those required for life. These
	 * worlds are usually abundant with water, flora, and fauna, with a core
	 * rich in Nickel and Iron. Some of these worlds can emit electromagnetic
	 * radiation. Usually has its own entire ecosystem and amino acids.<br>
	 * <br>
	 * N: A world with very little gravity, rich in minable, volatile resources,
	 * typically used in explosives. <br>
	 * <br>
	 * T: A type of gas giant, typically home to dark matter life. <br>
	 * <br>
	 * R: A lesser bioclassification of a Class M body, these worlds are
	 * generally habitable, however they lack some or most of the
	 * characteristics for a terrestrial body.<br>
	 * <br>
	 * Y: A world characterized by a toxic atmosphere, thermionic radiation
	 * discharges and surface temperatures at or above five hundred Kelvin,
	 * nicknamed the "demon class." Typically hazardous to both humans and
	 * starships.<br>
	 * <br>
	 * NINE: Another type of gas giant, usually located in the home star system
	 * of a hostile race.<br>
	 * <br>
	 * Exotic: A strange world that is uniquely proportioned and makes no
	 * logical sense; an anomaly.<br>
	 * <br>
	 * Abandoned: A desolate void, long abandoned due to catastrophe or other
	 * hostility.<br>
	 * 
	 * @return The bioclassification of the Body.
	 */
	@Override
	public EnumBodyClass getBodyClass() {
		return this.bodyClass;
	}
	
	/**
	 * Gets all gasses in a body's atmosphere.
	 * 
	 * @return All gasses in a body's atmosphere.
	 */
	@Override
	public String getGasses() {
		String gasList = "";
		ArrayList<EnumAtmosphericGas> bodyAtmosphere = this.bodyGasses;
		int ch = 0;
		for (EnumAtmosphericGas bodyGas : bodyAtmosphere) {
			ch++;
			gasList += ZGHelper.capitalizeFirstLetter(bodyGas.toString().substring(0, 3).toLowerCase());
			if (ch < bodyAtmosphere.size()) {
				gasList += ", ";
			}
		}
		bodyAtmosphere = null;
		return gasList;
	}
	
	/**
	 * Returns true if the temp is >= 115.
	 * 
	 * @return
	 */
	@Override
	public boolean getIsHotBody() {
		return this.baseTemp >= 115.0F;
	}
	
	/**
	 * Returns true if the temp is <= -25.
	 * 
	 * @return
	 */
	@Override
	public boolean getIsColdBody() {
		return this.baseTemp <= -25.0F;
	}
	
	/**
	 * Returns true if the radioacitivity is >= 10.
	 * 
	 * @return
	 */
	public boolean getIsRadioactiveBody() {
		return this.baseRadiation >= 10.0F;
	}
	
	/**
	 * Returns true if the toxicity is >= 15.
	 * 
	 * @return
	 */
	public boolean getIsToxicBody() {
		return this.baseToxicity >= 15.0F;
	}
	
	@Override
	public boolean getIsBreathable() {
		return this.breathable;
	}
	
	@Override
	public boolean getHasRain() {
		return this.rains;
	}
	
	@Override
	public float getWindLevel() {
		return this.windLevel;
	}
	
	@Override
	public float getAtmosphericDensity() {
		return this.density;
	}
	
	/**
	 * Whether or not the body corrodes armor.
	 * 
	 * @return True/False
	 */
	@Override
	public boolean getIsCorrosive() {
		return (this.getIsToxicBody() || this.getIsRadioactiveBody());
	}
	
	@Override
	public float getBodyTemperature() {
		float bodyTemp = this.baseTemp;
		return bodyTemp;
	}
	
	@Override
	public float getBodyTemperature(World world, BlockPos pos) {
		float bodyTemp = this.baseTemp;
		int multiplier = 6;
		float maxTemp = (bodyTemp * multiplier);
		float minTemp = (bodyTemp / multiplier);
		Biome biome = world.getBiomeForCoordsBody(pos);
		if (biome instanceof BiomeSpace) {
			WorldProviderMoonZG spaceProvider = (WorldProviderMoonZG) world.provider;
			boolean isDaytime = spaceProvider.isDaytime();
			BiomeSpace spaceBiome = (BiomeSpace) biome;
			float biomeTemp = spaceBiome.getBiomeTemp();
			boolean isHotBiome = spaceBiome.getIsHotBiome();
			boolean isColdBiome = spaceBiome.getIsColdBiome();
			Random rand = new Random();
			if (rand.nextInt(100) <= 32) {
				if (isHotBiome) {
					bodyTemp += (biomeTemp * 1.5);
				} else if (isColdBiome) {
					bodyTemp -= (biomeTemp * 1.5);
				} else {
					if (isDaytime) {
						bodyTemp += biomeTemp;
					} else {
						bodyTemp -= biomeTemp;
					}
				}
				if (bodyTemp > maxTemp) {
					bodyTemp = maxTemp;
				} else if (bodyTemp < minTemp) {
					bodyTemp = minTemp;
				}
			}
		}
		return bodyTemp;
	}
}