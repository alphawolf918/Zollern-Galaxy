package zollerngalaxy.blocks.items;

import net.minecraft.item.Item;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGItems {
	
	public static final Item heartOfZol = new ZGItemBase("heartofzol");
	public static final Item zolCrystal = new ZGItemBase("zolluscrystal");
	public static final Item rawViri = new ZGItemBase("rawviri");
	public static final Item ingotViri = new ZGItemBase("ingotviri");
	
	public static void init() {
		ZGItems.addItem(heartOfZol);
		ZGItems.addItem(zolCrystal);
		ZGItems.addItem(rawViri);
		ZGItems.addItem(ingotViri);
	}
	
	private static void addItem(Item item) {
		CommonZGRegisterHelper.registerItem(item);
	}
	
}