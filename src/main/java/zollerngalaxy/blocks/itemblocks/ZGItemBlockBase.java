package zollerngalaxy.blocks.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ZGItemBlockBase extends ItemBlock {
	
	public ZGItemBlockBase(Block block) {
		super(block);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return super.getUnlocalizedName();
	}
}