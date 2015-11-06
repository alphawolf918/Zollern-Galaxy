package galaxymod.items;

import galaxymod.items.food.CookedFood;
import galaxymod.items.food.RawFood;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static final Item alienBeefRaw = new RawFood("alienbeefraw");
	public static final Item alienBeefCooked = new CookedFood("alienbeefcooked");

	public static void init() {
		addItem(alienBeefRaw, "Raw Alien Beef");
		addItem(alienBeefCooked, "Cooked Alien Beef");
	}

	public static void addItem(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}
}