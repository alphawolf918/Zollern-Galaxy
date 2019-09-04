package zollerngalaxy.blocks.oasis;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockFlower;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class OasisFlower extends ZGBlockFlower {
	
	private static String blockName = "oasisflower";
	
	public OasisFlower() {
		super(blockName);
		this.setupFlower();
	}
	
	private void setupFlower() {
		this.setMaterial(Material.VINE);
		JSONFactory.registerFlowerBlock(blockName);
	}
	
	@Override
	public boolean canBlockStay(World world, BlockPos pos, IBlockState state) {
		BlockPos posD = pos.down();
		IBlockState stateD = world.getBlockState(posD);
		Block blockD = stateD.getBlock();
		return (blockD instanceof ZGBlockGrass || blockD instanceof ZGBlockDirt);
	}
	
}