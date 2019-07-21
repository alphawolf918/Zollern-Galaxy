package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevel;

public class ZGSand extends ZGBlockFalling {
	
	public ZGSand(String strTexture, float hardResist) {
		super(strTexture, hardResist);
		this.setMaterial(Material.SAND);
		this.setHarvestLevel("shovel", EnumHarvestLevel.IRON.getHarvestLevel());
		this.setSoundType(SoundType.SAND);
		this.setBlockType(EnumBlockType.SAND);
	}
	
}