/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.worldgen.eden.treasure;

import galaxymod.items.ItemList;
import java.util.ArrayList;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

public final class TreasureGenEden {
	
	public static ArrayList<String> chestTypes = new ArrayList<String>();
	
	private static WeightedRandomChestContent item5 = new WeightedRandomChestContent(
			new ItemStack(Items.gold_ingot, (new Random()).nextInt(64)), 50,
			65, 2);
	private static WeightedRandomChestContent item6 = new WeightedRandomChestContent(
			new ItemStack(Items.iron_ingot, (new Random()).nextInt(64)), 50,
			65, 2);
	private static WeightedRandomChestContent item7 = new WeightedRandomChestContent(
			new ItemStack(Items.diamond, (new Random()).nextInt(64)), 50, 65, 2);
	private static WeightedRandomChestContent item8 = new WeightedRandomChestContent(
			new ItemStack(Items.emerald, (new Random()).nextInt(64)), 50, 65, 2);
	private static WeightedRandomChestContent item9 = new WeightedRandomChestContent(
			new ItemStack(Items.redstone, (new Random()).nextInt(60)), 50, 65,
			2);
	private static WeightedRandomChestContent item10 = new WeightedRandomChestContent(
			new ItemStack(GCItems.meteoricIronIngot, (new Random()).nextInt(64)),
			50, 65, 2);
	private static WeightedRandomChestContent item11 = new WeightedRandomChestContent(
			new ItemStack(ItemList.ingotViri, (new Random()).nextInt(64)), 50,
			65, 2);
	
	public static void init() {
		addChestTypes();
		addItems();
	}
	
	private static void addItems() {
		addChestItem(item5);
		addChestItem(item6);
		addChestItem(item7);
		addChestItem(item8);
		addChestItem(item9);
		addChestItem(item10);
	}
	
	private static void addChestItem(WeightedRandomChestContent item) {
		int i;
		for (i = 0; i < chestTypes.size(); i++) {
			ChestGenHooks.addItem(chestTypes.get(i), item);
		}
	}
	
	public static void addChest(int i, int j, int k, Random rand, World world) {
		init();
		int chestX = i;
		int chestY = j;
		int chestZ = k;
		boolean isBigChest = (rand.nextInt(4) == 1) ? true : false;
		String spawnChestType = pickChestType();
		spawnChest(world, rand, chestX, chestY, chestZ, isBigChest,
				spawnChestType);
	}
	
	public static void spawnChest(World world, Random rand, int i, int j,
			int k, boolean isBigChest, String chestType) {
		world.setBlock(i, j, k, Blocks.chest);
		if (isBigChest) {
			world.setBlock(i + 1, j, k, Blocks.chest);
		}
		TileEntityChest tileentitychest = (TileEntityChest) world
				.getTileEntity(i, j, k);
		if (tileentitychest != null) {
			ChestGenHooks info = ChestGenHooks.getInfo(chestType);
			WeightedRandomChestContent.generateChestContents(rand,
					info.getItems(rand), tileentitychest, info.getCount(rand));
		}
	}
	
	public static void addChestTypes() {
		chestTypes.add(ChestGenHooks.DUNGEON_CHEST);
		chestTypes.add(ChestGenHooks.MINESHAFT_CORRIDOR);
		chestTypes.add(ChestGenHooks.PYRAMID_DESERT_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_CHEST);
		chestTypes.add(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CORRIDOR);
		chestTypes.add(ChestGenHooks.STRONGHOLD_CROSSING);
		chestTypes.add(ChestGenHooks.STRONGHOLD_LIBRARY);
		chestTypes.add(ChestGenHooks.VILLAGE_BLACKSMITH);
		chestTypes.add(EdenGenHooks.DROP_SHIP);
	}
	
	public static String pickChestType() {
		int randChestType = (new Random()).nextInt(chestTypes.size());
		randChestType = (randChestType >= 0) ? 0 : randChestType;
		return chestTypes.get(randChestType);
	}
}