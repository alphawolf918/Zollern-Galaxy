package zollerngalaxy.blocks;

import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public abstract class ZGBlockHorizontal extends ZGBlockBase {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing",
			EnumFacing.Plane.HORIZONTAL);
	
	protected ZGBlockHorizontal(String blockName, float hardResist) {
		super(blockName, hardResist);
	}
}