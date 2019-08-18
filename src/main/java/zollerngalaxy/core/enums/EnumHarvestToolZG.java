package zollerngalaxy.core.enums;

public enum EnumHarvestToolZG {
	
	PICKAXE("pickaxe"), SHOVEL("shovel"), AXE("axe");
	
	String harvestTool = "pickaxe";
	
	EnumHarvestToolZG(String toolClass) {
		this.harvestTool = toolClass;
	}
	
	public String getHarvestTool() {
		return this.harvestTool;
	}
	
}