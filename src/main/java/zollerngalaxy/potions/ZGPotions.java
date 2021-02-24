/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.potions;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.proxy.IProxy;

public class ZGPotions extends Potion {
	
	private static ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	private static IProxy proxy = core.proxy;
	
	private static int totalEntries = 0;
	
	/**
	 * Protects the Player from Shadow damage. Also applied to an entity when
	 * whacked with a weapon enchanted with the custom Enlightened enchantment,
	 * which will damage shadow (IShadeEntity) mobs.
	 */
	public static Potion radiance;
	
	/**
	 * Causes viral harm to the Player, and spreads to any other Players around
	 * them.
	 */
	public static Potion infected;
	
	/**
	 * Protects the Player from Corruption damage.
	 */
	public static Potion antiCorruption;
	
	/**
	 * Causes Corruption damage.
	 */
	public static Potion corruption;
	
	public static Potion stormProtection;
	
	// Radiance variables.
	public static final int radianceTime = 6000;
	public static final float shadowDamage = 5.0F;
	
	// Infection variables.
	public static final int infectionTime = 400;
	public static final float infectionDamage = 2.0F;
	
	// Anti-Corruption variables.
	public static final int antiCorruptionTime = 6000;
	
	// Corruption variables
	public static final int corruptionTime = 500;
	
	// Storm protection variables
	public static final int protectionTime = 24000;
	
	// The color of our Potion's liquid. Included here for convenience.
	protected int potionColor = 0xffffff;
	
	/**
	 * Instantiate a new Potion type for this mod.
	 * 
	 * @param potionName
	 *            The name of the Potion.
	 * @param potionIsBadEffect
	 *            Whether or not the Potion is a bad (harmful) effect.
	 * @param potionEffectiveness
	 *            The effectiveness of the Potion.
	 * @param potionLiquidColor
	 *            The color of the Potion's liquid.
	 */
	public ZGPotions(String potionName, boolean potionIsBadEffect, int potionEffectiveness, int potionLiquidColor) {
		super(potionIsBadEffect, potionLiquidColor);
		
		// Add our mod's ID on to the actual Potion name, to prevent any future
		// compatibility issues.
		this.setPotionName(ZGInfo.MOD_ID + "_" + potionName);
		
		// Apply the specified liquid color.
		this.setLiquidColor(potionLiquidColor);
		
		// This part is probably pointless, considering we tell it not to use an
		// icon at all. But let's play it safe.
		this.setIconIndex(0, 0);
		
		// Increment the total number of potions.
		this.totalEntries++;
	}
	
	// Make sure you call this init BEFORE your items or it will crash when you
	// use a custom potion!
	public static void init() {
		ZGHelper.Log("Initializing new Potion effects..");
		
		// Now let's actually initialize them.
		radiance = new ZGPotions("radiance", false, 13458603, 0xeeee00);
		antiCorruption = new ZGPotions("anticorruption", false, 13215621, 0xff00ff);
		corruption = new ZGPotions("corruption", false, 13584621, 0x8b008b);
		infected = new ZGPotions("infected", true, 13615421, 0x000000);
		stormProtection = new ZGPotions("stormprotection", false, 13621621, 0x0099ff);
		
		ZGHelper.Log("Successfully loaded " + totalEntries + " new Potion effects.");
	}
	
	/**
	 * This is where we actually program the 'effect' for the Potion.
	 * Note: We must call this manually! I do it through the LivingUpdate event
	 * in the Minecraft Forge event bus. Note that I call this through the proxy,
	 * just to be on the safe side.
	 */
	@Override
	public void performEffect(EntityLivingBase par1LivingBase, int par2Amplifier) {
		if (par1LivingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) par1LivingBase;
			
			// Sending it through the proxy eliminates any client-on-server
			// issues we may have.
			proxy.doPotionEffect(player, this);
		}
	}
	
	/**
	 * Returns the color of the potion's liquid.
	 */
	@Override
	public int getLiquidColor() {
		return this.potionColor;
	}
	
	/**
	 * Sets the liquid color for the Potion.
	 * 
	 * @param par1PotionColor
	 */
	public Potion setLiquidColor(int par1PotionColor) {
		this.potionColor = par1PotionColor;
		return this;
	}
	
	// This just gets rid of those status icons that our Potion could have.
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasStatusIcon() {
		return false;
	}
	
}