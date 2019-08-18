package zollerngalaxy.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;

public class ZGBlockPlanks extends ZGBlockBase {
	
	public ZGBlockPlanks(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setMaterial(Material.WOOD);
		this.setSoundType(SoundType.WOOD);
		this.setBlockType(EnumBlockType.WOOD);
	}
	
	public ZGBlockPlanks(String blockName) {
		this(blockName, 1.8F);
	}
	
	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return EnumHarvestLevelZG.IRON.getHarvestLevel();
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return EnumHarvestToolZG.AXE.getHarvestTool();
	}
}