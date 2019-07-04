package zollerngalaxy.planets;

import java.util.ArrayList;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.world.AtmosphereInfo;
import micdoodle8.mods.galacticraft.api.world.EnumAtmosphericGas;
import net.minecraft.util.ResourceLocation;
import zollerngalaxy.core.enums.EnumPlanetClass;
import zollerngalaxy.lib.ZGInfo;

public class ZGPlanet extends Planet implements IZollernPlanet {
	
	private EnumPlanetClass planetClass;
	private Star planetStar;
	
	private float baseTemp;
	private float baseRadiation;
	private float baseToxicity;
	
	private boolean breathable;
	private boolean rains;
	private float windLevel;
	private float density;
	
	private AtmosphereInfo atmosphere;
	
	private ArrayList<EnumAtmosphericGas> planetGasses;
	
	public ZGPlanet(String planetName) {
		super(planetName);
		this.setPlanetTemperature(65.0F);
		this.setPlanetRadiation(0.0F);
		this.setPlanetToxicity(0.0F);
		this.setBreathable(false);
		this.setHasRain(false);
		this.setWindLevel(0.0F);
		this.setAtmosphere();
		// if (planetGasses != null) {
		// SpaceRegistryHelper.setAtmosphereComponentList(this, planetGasses);
		// }
	}
	
	public ZGPlanet setPlanetStar(Star systemStar) {
		this.planetStar = systemStar;
		return this;
	}
	
	/**
	 * Sets the Planet's bioclassification. This is purely for classification
	 * and visual purposes.<br>
	 * <br>
	 * Categories:<br>
	 * <br>
	 * D: A small, rock-based body, typically a heavily-cratered asteroid, moon,
	 * or planetoid with little or no atmosphere. <br>
	 * <br>
	 * H: A characteristically lifeless planet, uninhabitable by humans. Could
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
	 * R: A lesser bioclassification of a Class M planet, these worlds are
	 * generally habitable, however they lack some or most of the
	 * characteristics for a terrestrial planet.<br>
	 * <br>
	 * Y: A world characterized by a toxic atmosphere, thermionic radiation
	 * discharges and surface temperatures at or above five hundred Kelvin,
	 * nicknamed the "demon class." Typically hazardous to both humans and
	 * starships.<br>
	 * <br>
	 * NINE: Another type of gas giant, usually located in the home star system
	 * of a hostile race.
	 * 
	 * @param pClass
	 *            The bioclassification of the Planet.
	 * @return The Planet to apply this bioclassification to.
	 */
	public ZGPlanet setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
		return this;
	}
	
	/**
	 * Sets the planet's base temperature.
	 * 
	 * @param planetTemp
	 *            The temperature to set.
	 * @return The Planet to apply this effect to.
	 */
	public Planet setPlanetTemperature(float planetTemp) {
		this.baseTemp = planetTemp;
		return this;
	}
	
	/**
	 * Sets the planet's base radiation level. Anything >= 10.0 requires the
	 * radiation protection blueprint.
	 * 
	 * @param planetRad
	 *            The radiation level to set.
	 * @return The Planet to apply this effect to.
	 */
	public Planet setPlanetRadiation(float planetRad) {
		this.baseRadiation = planetRad;
		return this;
	}
	
	/**
	 * Sets the planet's base toxicity level. Anything >= 15.0 requires the
	 * toxicity protection blueprint.
	 * 
	 * @param planetTox
	 *            The toxicity level of the planet.
	 * @return The Planet to apply this effect to.
	 */
	public Planet setPlanetToxicity(float planetTox) {
		this.baseToxicity = planetTox;
		return this;
	}
	
	public Planet setBreathable(boolean canBreathe) {
		this.breathable = canBreathe;
		return this;
	}
	
	public Planet setHasRain(boolean hasRain) {
		this.rains = hasRain;
		return this;
	}
	
	public Planet setWindLevel(float windLvl) {
		this.windLevel = windLvl;
		return this;
	}
	
	public Planet setDensity(float denseLvl) {
		this.density = denseLvl;
		return this;
	}
	
	/**
	 * Sets the planet's atmosphere. Atmosphere is determined by several
	 * factors: Is the planet breathable? Does the planet have rain? Is the
	 * planet corrosive (radioactive or toxic)? What's the planet's temperature?
	 * How strong is the wind level? How strong is the density level?
	 * 
	 * @return The planet of the atmosphere being set on.
	 */
	public Planet setAtmosphere() {
		atmosphere = new AtmosphereInfo(this.getIsBreathable(),
				this.getHasRain(),
				(this.getIsRadioactivePlanet() || this.getIsToxicPlanet()),
				this.getPlanetTemperature(), this.getWindLevel(),
				this.getAtmosphericDensity());
		return this;
	}
	
	public Planet setPlanetGasses(EnumAtmosphericGas... gasses) {
		for (EnumAtmosphericGas gas : gasses) {
			planetGasses.add(gas);
		}
		return this;
	}
	
	public ZGPlanet setDistanceFromCenter(float par1, float par2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(par1, par2));
		return this;
	}
	
	public ZGPlanet setDistanceFromCenter(float par1) {
		this.setDistanceFromCenter(par1, par1);
		return this;
	}
	
	public ZGPlanet setPlanetIcon(String planetTexture) {
		this.setBodyIcon(new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/"
				+ planetTexture + ".png"));
		return this;
	}
	
	public Star getPlanetStar() {
		return this.planetStar;
	}
	
	@Override
	public float getRadiationLevel() {
		return this.baseRadiation;
	}
	
	@Override
	public float getToxicLevel() {
		return this.baseToxicity;
	}
	
	@Override
	public float getPlanetTemperature() {
		return this.baseTemp;
	}
	
	/**
	 * Get the Planet's bioclassification. This is purely for classification and
	 * visual purposes.<br>
	 * <br>
	 * Categories:<br>
	 * <br>
	 * D: A small, rock-based body, typically a heavily-cratered asteroid, moon,
	 * or planetoid with little or no atmosphere. <br>
	 * <br>
	 * H: A characteristically lifeless planet, uninhabitable by humans. Could
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
	 * R: A lesser bioclassification of a Class M planet, these worlds are
	 * generally habitable, however they lack some or most of the
	 * characteristics for a terrestrial planet.<br>
	 * <br>
	 * Y: A world characterized by a toxic atmosphere, thermionic radiation
	 * discharges and surface temperatures at or above five hundred Kelvin,
	 * nicknamed the "demon class." Typically hazardous to both humans and
	 * starships.<br>
	 * <br>
	 * NINE: Another type of gas giant, usually located in the home star system
	 * of a hostile race.
	 * 
	 * @return The bioclassification of the Planet.
	 */
	public EnumPlanetClass getPlanetClass() {
		return this.planetClass;
	}
	
	/**
	 * Returns true if the temp is >= 115.
	 * 
	 * @return
	 */
	public boolean getIsHotPlanet() {
		return this.baseTemp >= 115.0f;
	}
	
	/**
	 * Returns true if the temp is <= 0.
	 * 
	 * @return
	 */
	public boolean getIsColdPlanet() {
		return this.baseTemp <= 0.0f;
	}
	
	/**
	 * Returns true if the radioacitivity is >= 10.
	 * 
	 * @return
	 */
	public boolean getIsRadioactivePlanet() {
		return this.baseRadiation >= 10.0f;
	}
	
	/**
	 * Returns true if the toxicity is >= 15.
	 * 
	 * @return
	 */
	public boolean getIsToxicPlanet() {
		return this.baseToxicity >= 15.0f;
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
	
}