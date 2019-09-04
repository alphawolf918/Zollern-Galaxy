package zollerngalaxy.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.lib.ZGInfo;

public class CreativeTabsHelper extends CreativeTabs {
	
	private ItemStack itemStack;
	
	public CreativeTabsHelper(String name, ItemStack itemStack) {
		super(CreativeTabs.getNextID(), name);
		this.itemStack = itemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return this.itemStack;
	}
	
	@Override
	public ItemStack getTabIconItem() {
		return this.itemStack;
	}
	
	@Override
	public boolean hasSearchBar() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ResourceLocation getBackgroundImage() {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/gui/container/zg_creative_tab_search.png");
	}
	
}