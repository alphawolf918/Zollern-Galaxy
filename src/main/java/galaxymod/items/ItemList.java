package galaxymod.items;

import galaxymod.items.eden.ItemEdenDungeonKey;
import galaxymod.items.food.CookedFood;
import galaxymod.items.food.ItemFruit;
import galaxymod.items.food.RawFood;
import galaxymod.lib.RegisterHelper;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {
	
	public static final Item alienBeefRaw = new RawFood("alienbeefraw");
	public static final Item alienBeefCooked = new CookedFood("alienbeefcooked");
	public static final Item alienBaconRaw = new RawFood("alienbaconraw");
	public static final Item alienBaconCooked = new CookedFood(
			"alienbaconcooked");
	public static final Item hud = new ItemHUD();
	public static final Item spaceFruit = new ItemFruit("fruitofeden");
	public static final Item edenDungeonKey = new ItemEdenDungeonKey();
	public static final Item brightStoneDust = new ItemNova("brightstonedust");
	
	public static void init() {
		addItem(alienBeefRaw, "Raw Alien Beef");
		addItem(alienBeefCooked, "Cooked Alien Beef");
		addItem(alienBaconRaw, "Raw Alien Bacon");
		addItem(alienBaconCooked, "Cooked Alien Bacon");
		addItem(hud, "HUD");
		addItem(spaceFruit, "Fruit of Eden");
		addItem(brightStoneDust, "Brightstone Dust");
		RegisterHelper.registerItem(edenDungeonKey);
	}
	
	public static void addItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}
}