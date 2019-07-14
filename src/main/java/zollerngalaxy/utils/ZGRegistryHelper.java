package zollerngalaxy.utils;

import javax.annotation.Nonnull;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ZGRegistryHelper {
	
	public static void registerOre(String name, Item ore) {
		registerOre(name, new ItemStack(ore));
	}
	
	public static void registerOre(String name, Block ore) {
		registerOre(name, new ItemStack(ore));
	}
	
	public static void registerOre(String name, @Nonnull ItemStack ore) {
		OreDictionary.registerOre(name, ore);
	}
}