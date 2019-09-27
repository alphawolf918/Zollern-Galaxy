package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;

public class ZGBlockDirt extends ZGBlockBase {
	
	public ZGBlockDirt(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setMaterial(Material.GROUND);
		this.setSoundType(SoundType.GROUND);
		this.setBlockType(EnumBlockType.DIRT);
	}
	
	public ZGBlockDirt(String blockName) {
		this(blockName, 0.9F);
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return EnumHarvestLevelZG.IRON.getHarvestLevel();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return EnumHarvestToolZG.SHOVEL.getHarvestTool();
	}
	
}