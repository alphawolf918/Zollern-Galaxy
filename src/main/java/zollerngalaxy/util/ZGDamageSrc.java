/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util;

import net.minecraft.util.DamageSource;

public class ZGDamageSrc extends DamageSource {
	
	protected float damageBase = 2.0F;
	
	public static final ZGDamageSrc deathTempCold = new ZGDamageSrc("deathcold", 1.5F, true);
	public static final ZGDamageSrc deathTempHot = new ZGDamageSrc("deathhot", 2.5F, true);
	public static final ZGDamageSrc deathRadiation = new ZGDamageSrc("radiation", 0.6F, true);
	public static final ZGDamageSrc deathToxic = new ZGDamageSrc("toxic", 0.5F, true);
	public static final ZGDamageSrc deathBladeFish = new ZGDamageSrc("bladefish", 1.2F);
	public static final ZGDamageSrc deathSharkAttack = new ZGDamageSrc("sharkattack", 6.0F);
	public static final ZGDamageSrc deathJellyfish = new ZGDamageSrc("jellyfishsting", 4.5F);
	
	public ZGDamageSrc(String par1, float baseDamage) {
		super(par1);
		this.damageBase = baseDamage;
	}
	
	public ZGDamageSrc(String par1, float baseDamage, boolean bypassesArmor) {
		this(par1, baseDamage);
		if (bypassesArmor) {
			this.setDamageBypassesArmor();
		}
	}
	
	public float getDamageBase() {
		return this.damageBase;
	}
	
}