package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.enums.EnumHarvestLevel;

public class ZGBlockDirt extends ZGBlockBase {
	
	public ZGBlockDirt(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setMaterial(Material.GROUND);
		this.setSoundType(SoundType.GROUND);
		this.setBlockHarvestLevel("shovel",
				EnumHarvestLevel.IRON.getHarvestLevel());
	}
	
	public ZGBlockDirt(String blockName) {
		this(blockName, 0.9F);
	}
	
}