package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.Fluid;

public class ChargiumLiquidBlock extends ZGFluidBase {
	
	public ChargiumLiquidBlock(Fluid fluid) {
		super("chargium", fluid, Material.LAVA);
		this.setQuantaPerBlock(6);
	}
	
	public void init() {
		this.setRegistryName("fluid_chargium");
		ItemBlock itemBlock = new ItemBlock(this);
		itemBlock.setRegistryName(this.getRegistryName());
	}
	
}