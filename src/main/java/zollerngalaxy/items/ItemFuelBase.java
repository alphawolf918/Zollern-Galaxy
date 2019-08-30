package zollerngalaxy.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFuelBase extends ZGItemBase {
	
	private int burnTime = 1600;
	
	public ItemFuelBase(String itemName, int timeBurn) {
		super(itemName);
		this.setItemBurnTime(timeBurn);
	}
	
	public ItemFuelBase(String itemName) {
		this(itemName, 1600);
	}
	
	@Override
	public int getItemBurnTime(ItemStack stack) {
		return this.burnTime;
	}
	
	public Item setItemBurnTime(int timeBurn) {
		this.burnTime = timeBurn;
		return this;
	}
	
}