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

package galaxymod.core;

import galaxymod.biomes.BiomeSpace;
import galaxymod.utils.ModInfo;
import galaxymod.utils.ZGHelper;
import java.util.ArrayList;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.world.IAtmosphericGas;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class PlanetNova extends Planet implements IZollernPlanet {
	
	private EnumPlanetClass planetClass;
	private Star planetStar;
	
	private float baseTemp;
	private float baseRadiation;
	private float baseToxicity;
	
	public PlanetNova(String planetName) {
		super(planetName);
		this.setPlanetTemperature(baseTemp);
		this.setPlanetRadiation(baseRadiation);
		this.setPlanetToxicity(baseToxicity);
	}
	
	public BiomeSpace getBiomeForPlanet(World worldObj, int parX, int parZ) {
		return (BiomeSpace) worldObj.getBiomeGenForCoords(parX, parZ);
	}
	
	public PlanetNova setPlanetStar(Star systemStar) {
		this.planetStar = systemStar;
		return this;
	}
	
	public Star getPlanetStar() {
		return this.planetStar;
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
	 * K: A typically uninhabitable world made sustainable by pressure domes
	 * and life-support systems.<br>
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
	public PlanetNova setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
		return this;
	}
	
	/**
	 * Set multiple gasses at once using this method.
	 * 
	 * @param gasses
	 *            All gasses to be added to this Planet.
	 * @return The Planet to add these gasses to.
	 */
	public PlanetNova setPlanetGasses(IAtmosphericGas... gasses) {
		for (IAtmosphericGas gas : gasses) {
			this.atmosphereComponent(gas);
		}
		return this;
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
	 * K: A typically uninhabitable world made sustainable by pressure domes
	 * and life-support systems.<br>
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
	 * Gets all gasses in a planet's atmosphere.
	 * 
	 * @return All gasses in a planet's atmosphere.
	 */
	public String getGasses() {
		String gasList = "";
		ArrayList<IAtmosphericGas> planetAtmosphere = this.atmosphere;
		int ch = 0;
		for (IAtmosphericGas planetGas : planetAtmosphere) {
			ch++;
			gasList += ZGHelper.capitalizeFirstLetter(planetGas.toString()
					.substring(0, 3).toLowerCase());
			if (ch < planetAtmosphere.size()) {
				gasList += ", ";
			}
		}
		planetAtmosphere = null;
		return gasList;
	}
	
	@Override
	public float getPlanetTemperature() {
		return this.baseTemp;
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
	
	public PlanetNova setDistanceFromCenter(float par1, float par2) {
		this.setRelativeDistanceFromCenter(new ScalableDistance(par1, par2));
		return this;
	}
	
	public PlanetNova setDistanceFromCenter(float par1) {
		this.setDistanceFromCenter(par1, par1);
		return this;
	}
	
	public PlanetNova setPlanetIcon(String planetTexture) {
		this.setBodyIcon(new ResourceLocation(ModInfo.MODID + ":textures/gui/"
				+ planetTexture + ".png"));
		return this;
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
	 * Returns true if the temp is <= 5.
	 * 
	 * @return
	 */
	public boolean getIsColdPlanet() {
		return this.baseTemp <= 5.0f;
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
	
}