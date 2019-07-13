package zollerngalaxy.items;

import net.minecraft.item.Item;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGItems {
	
	private static int totalItems = 0;
	
	public static final Item heartOfZol = new ZGItemBase("heartofzol");
	public static final Item zolCrystal = new ZGItemBase("zolluscrystal");
	public static final Item rawViri = new ZGItemBase("rawviri");
	public static final Item dustCobalt = new ZGItemBase("cobaltdust");
	public static final Item dustEve = new ZGItemBase("eveniumdust");
	public static final Item ingotViri = new ZGItemBase("ingotviri");
	public static final Item ingotCobalt = new ZGItemBase("ingotcobalt");
	public static final Item ingotEve = new ZGItemBase("ingotevenium");
	
	public static void init() {
		ZGItems.registerItems(heartOfZol, zolCrystal, rawViri, dustEve, dustCobalt, ingotViri,
				ingotCobalt, ingotEve);
		ZGHelper.Log("Loaded a total of " + totalItems + " new items.");
	}
	
	private static void addItem(Item item) {
		CommonZGRegisterHelper.registerItem(item);
		totalItems++;
	}
	
	private static void registerItems(Item... items) {
		for (Item i : items) {
			ZGItems.addItem(i);
		}
	}
	
}