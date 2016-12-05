/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemMultitool extends ItemPickaxe {
	
	protected String toolMode = "pickaxe";
	
	public ItemMultitool(Item.ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setHarvestLevel("multitool", 6);
	}
	
	/**
	 * Accepted modes: pickaxe, shovel, axe, hoe.
	 * 
	 * @param mode
	 *            The mode that the tool is set to.
	 * @return
	 */
	public ItemMultitool setToolMode(String mode) {
		this.toolMode = mode;
		return this;
	}
	
	/**
	 * Returns the current tool mode (pickaxe, shovel, axe or hoe).
	 * 
	 * @return The current mode of the multi-tool.
	 */
	public String getToolMode() {
		return this.toolMode;
	}
	
}