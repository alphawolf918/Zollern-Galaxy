package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.items.ZGItems;

public class SmeltingRecipes {
	
	public static void init() {
		// Zollus
		SmeltingRecipes.SmeltBlock(ZGBlocks.zolcobblerock, ZGBlocks.zolstone,
				1.5F); // Zolstone
		SmeltingRecipes.SmeltBlockToItem(ZGBlocks.zolIronOre, Items.IRON_INGOT,
				2.1F); // Iron
		SmeltingRecipes.SmeltBlockToItem(ZGBlocks.zolGoldOre, Items.GOLD_INGOT,
				2.4F); // Gold
		SmeltingRecipes.SmeltBlockToItem(ZGBlocks.zolCopperOre, new ItemStack(
				GCItems.basicItem, 1, 3), 2.4F); // Copper
		SmeltingRecipes.SmeltBlockToItem(ZGBlocks.zolTinOre, new ItemStack(
				GCItems.basicItem, 1, 4), 2.4F); // Tin
		
		// Eden
		SmeltingRecipes.SmeltItem(ZGItems.rawViri, ZGItems.ingotViri, 3.6F);
	}
	
	public static void SmeltBlock(Block blockIn, Block blockOut, float xp) {
		GameRegistry.addSmelting(blockIn, new ItemStack(blockOut), xp);
	}
	
	public static void SmeltBlock(Block blockIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(blockIn, stackOut, xp);
	}
	
	public static void SmeltItem(Item itemIn, Item itemOut, float xp) {
		GameRegistry.addSmelting(itemIn, new ItemStack(itemOut), xp);
	}
	
	public static void SmeltItem(Item itemIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(itemIn, stackOut, xp);
	}
	
	public static void SmeltBlockToItem(Block blockIn, Item itemOut, float xp) {
		GameRegistry.addSmelting(blockIn, new ItemStack(itemOut), xp);
	}
	
	public static void SmeltBlockToItem(Block blockIn, ItemStack stackOut,
			float xp) {
		GameRegistry.addSmelting(blockIn, stackOut, xp);
	}
	
}