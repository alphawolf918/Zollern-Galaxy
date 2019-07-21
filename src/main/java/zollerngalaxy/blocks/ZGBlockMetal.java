package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockMetal extends ZGBlockBase {
	
	public ZGBlockMetal(String strTexture) {
		super(strTexture, 2.1F);
		this.setSoundType(SoundType.METAL);
		this.setBlockType(EnumBlockType.METAL);
	}
	
}