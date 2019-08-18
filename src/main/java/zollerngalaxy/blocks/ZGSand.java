package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGSand extends ZGBlockFalling {
	
	public ZGSand(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setMaterial(Material.SAND);
		this.setHarvestLevel("shovel", 2);
		this.setSoundType(SoundType.SAND);
		this.setBlockType(EnumBlockType.SAND);
	}
	
}