/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumHarvestLevelZG {
	
	WOOD(0), STONE(1), IRON(2), RUBY(2), DIAMOND(3), SAPPHIRE(3), COBALT(4), EVENIUM(5), VIRINIUM(6), AMARANTH(7), AZURITE(8), ZOLLERNIUM(9), OMNI(10), ZANIUM(11);
	
	protected int harvestLevel = 2;
	
	private EnumHarvestLevelZG(int par1HarvestLevel) {
		this.harvestLevel = par1HarvestLevel;
	}
	
	public int getHarvestLevel() {
		return this.harvestLevel;
	}
}