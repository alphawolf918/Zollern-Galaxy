package zollerngalaxy.core.enums;

public enum EnumHarvestLevelZG {
	
	WOOD(0), STONE(1), IRON(2), DIAMOND(3), OMNI(10);
	
	int harvestLevel = 2;
	
	EnumHarvestLevelZG(int par1HarvestLevel) {
		this.harvestLevel = par1HarvestLevel;
	}
	
	public int getHarvestLevel() {
		return this.harvestLevel;
	}
	
}