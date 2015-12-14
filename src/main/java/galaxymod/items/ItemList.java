package galaxymod.items;

import galaxymod.items.eden.ItemEdenDungeonKey;
import galaxymod.items.food.CookedFood;
import galaxymod.items.food.ItemFruit;
import galaxymod.items.food.RawFood;
import galaxymod.lib.RegisterHelper;
import net.minecraft.item.Item;

public class ItemList {
	
	public static final Item alienBeefRaw = new RawFood("alienbeefraw");
	public static final Item alienBeefCooked = new CookedFood("alienbeefcooked");
	public static final Item alienBaconRaw = new RawFood("alienbaconraw");
	public static final Item alienBaconCooked = new CookedFood(
			"alienbaconcooked");
	public static final ItemNova hud = new ItemHUD();
	public static final Item spaceFruit = new ItemFruit("fruitofeden");
	public static final ItemNova edenDungeonKey = new ItemEdenDungeonKey();
	public static final ItemNova brightStoneDust = new ItemNova(
			"brightstonedust");
	public static final ItemNova rawViri = new ItemNova("rawviri");
	public static final ItemNova ingotViri = new ItemNova("ingotviri");
	
	public static void init() {
		addItem(alienBeefRaw);
		addItem(alienBeefCooked);
		addItem(alienBaconRaw);
		addItem(alienBaconCooked);
		addItem(hud);
		addItem(spaceFruit);
		addItem(brightStoneDust);
		addItem(edenDungeonKey);
		addItem(rawViri);
		addItem(ingotViri);
	}
	
	public static void addItem(Item par1Item) {
		RegisterHelper.registerItem(par1Item);
	}
}