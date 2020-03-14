package zollerngalaxy.util;

import net.minecraft.util.DamageSource;

public class ZGDamageSrc extends DamageSource {
	
	protected float damageBase = 1.0F;
	
	public static ZGDamageSrc deathTempCold = new ZGDamageSrc("deathcold", 1.5F, true);
	public static ZGDamageSrc deathTempHot = new ZGDamageSrc("deathhot", 2.5F, true);
	public static ZGDamageSrc deathRadiation = new ZGDamageSrc("radiation", 0.6F, true);
	public static ZGDamageSrc deathToxic = new ZGDamageSrc("toxic", 0.5F, true);
	public static ZGDamageSrc deathBladeFish = new ZGDamageSrc("bladefish", 1.2F);
	public static ZGDamageSrc deathSharkAttack = new ZGDamageSrc("sharkattack", 6.0F);
	
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