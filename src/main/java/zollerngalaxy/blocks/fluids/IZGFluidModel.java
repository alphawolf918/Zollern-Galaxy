package zollerngalaxy.blocks.fluids;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IZGFluidModel {
	
	@SideOnly(Side.CLIENT)
	public void registerModels();
	
}