package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;

public class SmeltRecipes {
	
	public static void init() {
		// Zollus
		SmeltRecipes.SmeltBlock(ZGBlocks.zolCobbleRock, ZGBlocks.zolStone, 1.5F); // Zolstone
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.zolIronOre, Items.IRON_INGOT, 2.1F); // Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.zolGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.zolCopperOre,
				new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.zolTinOre, new ItemStack(GCItems.basicItem, 1, 4),
				2.4F); // Tin
		
		// Kriffon
		SmeltRecipes.SmeltBlock(ZGBlocks.kriffCobbleRock, ZGBlocks.kriffStone, 1.5F); // Kriffstone
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.kriffIronOre, Items.IRON_INGOT, 2.1F); // Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.kriffGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.kriffCopperOre, new ItemStack(GCItems.basicItem, 1,
				3), 2.4F); // Copper
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.kriffCobaltOre, ZGItems.ingotCobalt, 1.6F); // Cobalt
		
		// Purgot
		SmeltRecipes.SmeltBlock(ZGBlocks.purgCobbleRock, ZGBlocks.purgSurfaceRock, 1.5F); // Purgrock
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgIronOre, Items.IRON_INGOT, 2.1F); // Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgTinOre, new ItemStack(GCItems.basicItem, 1, 1),
				2.4F); // Lead
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgCopperOre,
				new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgTinOre, new ItemStack(GCItems.basicItem, 1, 4),
				2.4F); // Tin
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgAluminumOre, new ItemStack(GCItems.basicItem, 1,
				5), 2.4F); // Aluminum
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgMeteoricIronOre, new ItemStack(
				GCItems.itemBasicMoon), 4.0F); // Meteoric Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgCobaltOre, ZGItems.ingotCobalt, 1.6F); // Cobalt
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgEveniumOre, ZGItems.ingotEve, 3.6F); // Evenium
		
		// Lead
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgLeadOre, new ItemStack(GCItems.basicItem, 1, 1),
				1.5F);
		
		// Dust -> Ingots
		SmeltRecipes.SmeltItem(ZGItems.dustCobalt, ZGItems.ingotCobalt, 2.4F);
		SmeltRecipes.SmeltItem(ZGItems.dustEve, ZGItems.ingotEve, 2.8F);
		SmeltRecipes.SmeltItem(ZGItems.rawViri, ZGItems.ingotViri, 2.6F);
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
	
	public static void SmeltBlockToItem(Block blockIn, ItemStack stackOut, float xp) {
		GameRegistry.addSmelting(blockIn, stackOut, xp);
	}
	
}