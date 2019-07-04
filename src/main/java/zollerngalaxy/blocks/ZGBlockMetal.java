package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;

public class ZGBlockMetal extends ZGBlockBase {
	
	public ZGBlockMetal(String strTexture) {
		super(strTexture, 2.1F);
		this.setSoundType(SoundType.METAL);
	}
	
}