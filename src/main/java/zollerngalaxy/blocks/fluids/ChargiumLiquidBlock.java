/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class ChargiumLiquidBlock extends ZGFluidBase {
	
	public ChargiumLiquidBlock(Fluid fluid) {
		super("chargium", fluid, Material.LAVA);
		this.setQuantaPerBlock(6);
	}
	
}