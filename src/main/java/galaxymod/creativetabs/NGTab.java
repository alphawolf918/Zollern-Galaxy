package galaxymod.creativetabs;

import galaxymod.blocks.BlockList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class NGTab extends CreativeTabs {

	public NGTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockList.edenFlower);
	}
}