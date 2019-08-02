package zollerngalaxy.util;

import net.minecraft.util.DamageSource;

public class ZGDamageSrc extends DamageSource {
	
	public static ZGDamageSrc deathTempCold = new ZGDamageSrc("deathcold");
	public static float baseColdDamage = 1.5f;
	
	public static ZGDamageSrc deathTempHot = new ZGDamageSrc("deathhot");
	public static float baseHotDamage = 2.5f;
	
	public static ZGDamageSrc deathRadiation = new ZGDamageSrc("radiation");
	public static float baseRadDamage = 0.6f;
	
	public static ZGDamageSrc deathToxic = new ZGDamageSrc("toxic");
	public static float baseToxDamage = 0.5f;
	
	public ZGDamageSrc(String par1) {
		super(par1);
	}
	
}