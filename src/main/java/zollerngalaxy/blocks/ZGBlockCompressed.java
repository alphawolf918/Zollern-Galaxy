package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockCompressed extends ZGBlockMetal {
	
	public ZGBlockCompressed(String strTexture) {
		super(strTexture);
		this.setHardResist(3.2F);
		this.setSoundType(SoundType.STONE);
		this.setBlockType(EnumBlockType.COMPRESSED);
	}
	
}