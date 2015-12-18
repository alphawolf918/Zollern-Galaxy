package galaxymod.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ProjectNovaTab extends CreativeTabs {
	
	protected ItemStack displayItem;
	
	public ProjectNovaTab(String label, ItemStack theItemStack) {
		super(CreativeTabs.getNextID(), label);
		this.displayItem = theItemStack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return this.displayItem;
	}
	
	@Override
	public Item getTabIconItem() {
		return null;
	}
}