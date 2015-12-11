package galaxymod.worldgen.eden.treasure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;

public class EdenGenHooks extends ChestGenHooks {
	
	public static final String DROP_SHIP = "dropShip";
	public static final String BOSS_CHEST = "bossChest";
	
	public static final WeightedRandomChestContent[] dropShipChestContents = new WeightedRandomChestContent[] {
			new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10),
			new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 5, 10),
			new WeightedRandomChestContent(Items.diamond, 0, 1, 5, 10),
			new WeightedRandomChestContent(Items.emerald, 0, 1, 5, 10),
			new WeightedRandomChestContent(Items.quartz, 0, 1, 5, 10),
			new WeightedRandomChestContent(Items.coal, 0, 1, 5, 10),
			new WeightedRandomChestContent(GCItems.meteoricIronIngot, 0, 1, 5,
					10) };
	
	public static final WeightedRandomChestContent[] bossChestContents = new WeightedRandomChestContent[] { new WeightedRandomChestContent(
			GCItems.meteoricIronIngot, 32, 64, 10, 10) };
	
	private static final HashMap<String, EdenGenHooks> chestInfo = new HashMap<String, EdenGenHooks>();
	private static boolean hasInit = false;
	static {
		init();
	}
	
	private static void init() {
		if (hasInit) {
			return;
		}
		
		hasInit = true;
		
		addInfo(DROP_SHIP, dropShipChestContents, 3, 7);
		
		ItemStack book = new ItemStack(Items.enchanted_book, 1, 0);
		WeightedRandomChestContent tmp = new WeightedRandomChestContent(book,
				1, 1, 1);
		getInfo(DROP_SHIP).addItem(tmp);
	}
	
	static void addDungeonLoot(EdenGenHooks dungeon, ItemStack item,
			int weight, int min, int max) {
		dungeon.addItem(new WeightedRandomChestContent(item, min, max, weight));
	}
	
	private static void addInfo(String category,
			WeightedRandomChestContent[] items, int min, int max) {
		chestInfo.put(category, new EdenGenHooks(category, items, min, max));
	}
	
	/**
	 * Retrieves, or creates the info class for the specified category.
	 *
	 * @param category
	 *            The category name
	 * @return A instance of ChestGenHooks for the specified category.
	 */
	public static EdenGenHooks getInfo(String category) {
		if (!chestInfo.containsKey(category)) {
			chestInfo.put(category, new EdenGenHooks(category));
		}
		return chestInfo.get(category);
	}
	
	/**
	 * Generates an array of items based on the input min/max count. If the
	 * stack can not hold the total amount, it will be split into stacks of size
	 * 1.
	 *
	 * @param rand
	 *            A random number generator
	 * @param source
	 *            Source item stack
	 * @param min
	 *            Minimum number of items
	 * @param max
	 *            Maximum number of items
	 * @return An array containing the generated item stacks
	 */
	public static ItemStack[] generateStacks(Random rand, ItemStack source,
			int min, int max) {
		int count = min + (rand.nextInt(max - min + 1));
		
		ItemStack[] ret;
		if (source.getItem() == null) {
			ret = new ItemStack[0];
		} else if (count > source.getMaxStackSize()) {
			ret = new ItemStack[count];
			for (int x = 0; x < count; x++) {
				ret[x] = source.copy();
				ret[x].stackSize = 1;
			}
		} else {
			ret = new ItemStack[1];
			ret[0] = source.copy();
			ret[0].stackSize = count;
		}
		return ret;
	}
	
	// shortcut functions, See the non-static versions below
	public static WeightedRandomChestContent[] getItems(String category,
			Random rnd) {
		return getInfo(category).getItems(rnd);
	}
	
	public static int getCount(String category, Random rand) {
		return getInfo(category).getCount(rand);
	}
	
	public static void addItem(String category, WeightedRandomChestContent item) {
		getInfo(category).addItem(item);
	}
	
	public static void removeItem(String category, ItemStack item) {
		getInfo(category).removeItem(item);
	}
	
	public static ItemStack getOneItem(String category, Random rand) {
		return getInfo(category).getOneItem(rand);
	}
	
	private String category;
	private int countMin = 0;
	private int countMax = 0;
	// TO-DO: Privatize this once again when we remove the Deprecated stuff in
	// DungeonHooks
	ArrayList<WeightedRandomChestContent> contents = new ArrayList<WeightedRandomChestContent>();
	
	public EdenGenHooks(String category) {
		super(category);
		this.category = category;
	}
	
	public EdenGenHooks(String category, WeightedRandomChestContent[] items,
			int min, int max) {
		this(category);
		for (WeightedRandomChestContent item : items) {
			contents.add(item);
		}
		countMin = min;
		countMax = max;
	}
	
	/**
	 * Adds a new entry into the possible items to generate.
	 *
	 * @param item
	 *            The item to add.
	 */
	@Override
	public void addItem(WeightedRandomChestContent item) {
		contents.add(item);
	}
	
	/**
	 * Removes all items that match the input item stack, Only metadata and item
	 * ID are checked. If the input item has a metadata of -1, all metadatas
	 * will match.
	 *
	 * @param item
	 *            The item to check
	 */
	@Override
	public void removeItem(ItemStack item) {
		Iterator<WeightedRandomChestContent> itr = contents.iterator();
		while (itr.hasNext()) {
			WeightedRandomChestContent cont = itr.next();
			if (item.isItemEqual(cont.theItemId)
					|| (item.getItemDamage() == OreDictionary.WILDCARD_VALUE && item == cont.theItemId)) {
				itr.remove();
			}
		}
	}
	
	/**
	 * Gets an array of all random objects that are associated with this
	 * category.
	 *
	 * @return The random objects
	 */
	@Override
	public WeightedRandomChestContent[] getItems(Random rnd) {
		ArrayList<WeightedRandomChestContent> ret = new ArrayList<WeightedRandomChestContent>();
		
		for (WeightedRandomChestContent orig : contents) {
			Item item = orig.theItemId.getItem();
			
			if (item != null) {
				WeightedRandomChestContent n = item.getChestGenBase(this, rnd,
						orig);
				if (n != null) {
					ret.add(n);
				}
			}
		}
		
		return ret.toArray(new WeightedRandomChestContent[ret.size()]);
	}
	
	/**
	 * Gets a random number between countMin and countMax.
	 *
	 * @param rand
	 *            A RNG
	 * @return A random number where countMin <= num <= countMax
	 */
	@Override
	public int getCount(Random rand) {
		return countMin < countMax ? countMin
				+ rand.nextInt(countMax - countMin) : countMin;
	}
	
	/**
	 * Returns a single ItemStack from the possible items in this registry,
	 * Useful if you just want a quick and dirty random Item.
	 *
	 * @param rand
	 *            A Random Number gen
	 * @return A single ItemStack, or null if it could not get one.
	 */
	@Override
	public ItemStack getOneItem(Random rand) {
		WeightedRandomChestContent[] items = getItems(rand);
		WeightedRandomChestContent item = (WeightedRandomChestContent) WeightedRandom
				.getRandomItem(rand, items);
		ItemStack[] stacks = EdenGenHooks.generateStacks(rand, item.theItemId,
				item.theMinimumChanceToGenerateItem,
				item.theMaximumChanceToGenerateItem);
		return (stacks.length > 0 ? stacks[0] : null);
	}
	
	// Accessors
	@Override
	public int getMin() {
		return countMin;
	}
	
	@Override
	public int getMax() {
		return countMax;
	}
	
	@Override
	public void setMin(int value) {
		countMin = value;
	}
	
	@Override
	public void setMax(int value) {
		countMax = value;
	}
}