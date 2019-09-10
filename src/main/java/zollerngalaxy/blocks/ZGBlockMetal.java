package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockMetal extends ZGBlockBase {
	
	public ZGBlockMetal(String strTexture) {
		super(strTexture, 2.4F);
		this.setMaterial(Material.IRON);
		this.setSoundType(SoundType.METAL);
		this.setBlockType(EnumBlockType.METAL);
	}
	
	public ZGBlockMetal(String strTexture, float hardResist) {
		this(strTexture);
		this.setHardResist(hardResist);
	}
	
}