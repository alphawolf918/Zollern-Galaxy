package zollerngalaxy.blocks.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.items.ZGItems;
import zollerngalaxy.lib.helpers.ZollernHelper;

public class ZGTabs {
	
	public static CreativeTabs zgItemsTab;
	public static CreativeTabs zgBlocksTab;
	
	public static void init() {
		zgBlocksTab = ZollernHelper.createCreativeTabs("ZollernGalaxyBlocks",
				new ItemStack(ZGBlocks.zolSurfaceRock));
		zgItemsTab = ZollernHelper.createCreativeTabs("ZollernGalaxyItems",
				new ItemStack(ZGItems.ingotViri));
	}
}