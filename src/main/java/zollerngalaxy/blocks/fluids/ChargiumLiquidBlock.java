package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

public class ChargiumLiquidBlock extends ZGFluidBase {
	
	public ChargiumLiquidBlock(Fluid fluid) {
		super("chargium", fluid, Material.LAVA);
		this.setQuantaPerBlock(6);
	}
	
}