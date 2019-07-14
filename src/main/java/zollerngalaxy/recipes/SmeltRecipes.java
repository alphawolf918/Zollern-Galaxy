package zollerngalaxy.recipes;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ModHelperBase;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalfoundation.init.TFItems;

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
		SmeltRecipes.SmeltBlock(ZGBlocks.purgCobbleRock, ZGBlocks.purgStone, 1.5F); // Purgrock
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgIronOre, Items.IRON_INGOT, 2.1F); // Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.purgLeadOre, new ItemStack(GCItems.basicItem, 1, 1),
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
		
		// Eden
		SmeltRecipes.SmeltBlock(ZGBlocks.edenCobbleRock, ZGBlocks.edenStone, 1.5F); // Eden
																					// Stone
		SmeltRecipes.SmeltBlock(ZGBlocks.edenBloodSand, Blocks.GLASS, 0.5F);
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenIronOre, Items.IRON_INGOT, 2.1F); // Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenGoldOre, Items.GOLD_INGOT, 2.4F); // Gold
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenCopperOre,
				new ItemStack(GCItems.basicItem, 1, 3), 2.4F); // Copper
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenTinOre, new ItemStack(GCItems.basicItem, 1, 4),
				2.4F); // Tin
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenAluminumOre, new ItemStack(GCItems.basicItem, 1,
				5), 2.4F); // Aluminum
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenMeteoricIronOre, new ItemStack(
				GCItems.itemBasicMoon), 4.0F); // Meteoric Iron
		SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenLeadOre, new ItemStack(GCItems.basicItem, 1, 1),
				2.4F); // Lead
		
		// Other mod metals
		if (ModHelperBase.useCofh) {
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenSilverOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSilver), 1,
							130), 3.7F); // Silver
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenNickleOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotNickel), 1,
							133), 3.5F); // Nickle
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenSteelOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotSteel), 1,
							160), 4.2F); // Steel
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenBronzeOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotBronze), 1,
							163), 4.2F); // Bronze
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenElectrumOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotElectrum),
							1, 161), 4.2F); // Electrum
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenInvarOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotInvar), 1,
							162), 4.2F); // Invar
			SmeltRecipes.SmeltBlockToItem(ZGBlocks.edenPlatinumOre,
					new ItemStack(ItemHelper.getItemFromStack(TFItems.itemMaterial.ingotPlatinum),
							1, 134), 4.2F); // Platinum
		}
		
		// Xathius
		// TODO
		
		// Oasis
		// TODO
		
		// Dust -> Ingots/Gems
		SmeltRecipes.SmeltItem(ZGItems.dustDiamond, Items.DIAMOND, 2.6F);
		SmeltRecipes.SmeltItem(ZGItems.dustEmerald, Items.EMERALD, 3.2F);
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