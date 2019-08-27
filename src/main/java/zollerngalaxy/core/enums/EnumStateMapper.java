package zollerngalaxy.core.enums;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.properties.IProperty;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.helpers.ZGBlockStateHelper;

@SideOnly(Side.CLIENT)
public enum EnumStateMapper {
	FENCE_GATE(BlockFenceGate.POWERED), DOOR(BlockDoor.POWERED), FORGE_LEVEL(BlockFluidBase.LEVEL), VANILLA_LEVEL(
			BlockLiquid.LEVEL), FIRE(BlockFire.AGE), TNT(ZGBlockStateHelper.EXPLODE), LEAVES(ZGBlockStateHelper.CHECK_DECAY,
			ZGBlockStateHelper.DECAYABLE), PLANT_AGE(ZGBlockStateHelper.AGE);
	
	private IProperty[] property;
	
	private EnumStateMapper(IProperty... property) {
		this.property = property;
	}
	
	public IProperty[] getProperty() {
		return this.property;
	}
}