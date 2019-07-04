package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.core.ISingleZGBlockRender;

public class ZGBlockDirt extends ZGBlockBase implements ISingleZGBlockRender {
	
	public ZGBlockDirt(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.name = blockName;
		this.setMaterial(Material.GROUND);
		this.setSoundType(SoundType.GROUND);
		this.setBlockHarvestLevel("shovel", 0);
	}
	
	@Override
	public String getName() {
		return this.name.toLowerCase();
	}
	
}