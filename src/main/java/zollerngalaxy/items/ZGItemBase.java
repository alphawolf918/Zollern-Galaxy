package zollerngalaxy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.creativetabs.ZGTabs;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.lib.helpers.json.JSONRegistryHelper;

public class ZGItemBase extends Item implements ISingleZGItemRender {
	
	public ZGItemBase(String name) {
		super();
		setItemName(this, name);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONRegistryHelper.registerItem(name);
		}
	}
	
	public void setItemName(final Item item, final String itemName) {
		item.setUnlocalizedName(itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZGTabs.zgItemsTab;
	}
	
	@Override
	public String getName() {
		return this.getUnlocalizedName().substring(5);
	}
}