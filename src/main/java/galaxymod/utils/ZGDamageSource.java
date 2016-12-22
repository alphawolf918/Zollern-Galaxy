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

package galaxymod.utils;

import net.minecraft.util.DamageSource;

public class ZGDamageSource extends DamageSource {
	
	public static ZGDamageSource deathTempCold = new ZGDamageSource("deathcold");
	public static float baseColdDamage = 1.5f;
	
	public static ZGDamageSource deathTempHot = new ZGDamageSource("deathhot");
	public static float baseHotDamage = 2.5f;
	
	public static ZGDamageSource deathRadiation = new ZGDamageSource(
			"radiation");
	public static float baseRadDamage = 0.6f;
	
	public static ZGDamageSource deathToxic = new ZGDamageSource("toxic");
	public static float baseToxDamage = 0.5f;
	
	public ZGDamageSource(String par1) {
		super(par1);
	}
	
}