package zollerngalaxy.core.enums;

public enum EnumHarvestToolZG {
	
	PICKAXE("pickaxe"), SHOVEL("shovel"), AXE("axe"), OMNITOOL("omnitool");
	
	private String harvestTool = "pickaxe";
	
	private EnumHarvestToolZG(String toolClass) {
		this.harvestTool = toolClass;
	}
	
	public String getHarvestTool() {
		return this.harvestTool;
	}
	
}