package zollerngalaxy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGItemFood extends ItemFood implements ISingleZGItemRender {
	
	public ZGItemFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		setItemName(this, name);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem(name);
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