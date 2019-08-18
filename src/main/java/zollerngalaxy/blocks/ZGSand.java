package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGSand extends ZGBlockFalling {
	
	public ZGSand(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setSoundType(SoundType.SAND);
		this.setBlockType(EnumBlockType.SAND);
	}
	
}