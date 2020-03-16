/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumToolMaterialZG {
	
	OMNI(EnumHarvestLevelZG.OMNI.getHarvestLevel(), 99999, 16.0F, 13.0F, 0);
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	
	private EnumToolMaterialZG(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float damageVsEntityIn, int enchantabilityIn) {
		this.harvestLevel = harvestLevelIn;
		this.maxUses = maxUsesIn;
		this.efficiency = efficiencyIn;
		this.attackDamage = damageVsEntityIn;
		this.enchantability = enchantabilityIn;
	}
	
}
