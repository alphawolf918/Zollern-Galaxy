/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.utils;

import net.minecraft.util.DamageSource;

public class NGDamageSource extends DamageSource {
	
	public static NGDamageSource deathTempCold = new NGDamageSource("deathcold");
	public static NGDamageSource deathTempHot = new NGDamageSource("deathhot");
	
	public NGDamageSource(String par1) {
		super(par1);
	}
	
}