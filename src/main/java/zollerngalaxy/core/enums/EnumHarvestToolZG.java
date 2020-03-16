/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
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