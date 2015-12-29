/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.items;

import galaxymod.blocks.BlockList;
import galaxymod.items.eden.ItemEdenDungeonKey;
import galaxymod.items.food.CookedFood;
import galaxymod.items.food.ItemFruit;
import galaxymod.items.food.RawFood;
import galaxymod.lib.NovaHelper;
import galaxymod.lib.RegisterHelper;
import net.minecraft.item.Item;

public class ItemList {
	
	static int totalItems = 0;
	
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
	public static final ItemNova ancientEssenceEden = new ItemNova("alienstone");
	public static final ItemNova edenCrystal = new ItemNova("edencrystal");
	public static final ItemNova edenZollusTablet = new ItemTablet(
			"edenzollustablet", BlockList.edenZollusPortal);
	public static final ItemNova edenCompressedVirinium = new ItemNova(
			"compressedvirinium");
	
	public static final ItemNova zollusCrystal = new ItemNova("zolluscrystal");
	public static final ItemNova zollusHeartium = new ItemNova("heartofzol");
	public static final ItemNova zollusCompressedHeartium = new ItemNova(
			"compressedheartium");
	public static final ItemNova zollusCompressedVyrex = new ItemNova(
			"compressedvyrex");
	public static final ItemNova zollusKriffonTablet = new ItemTablet(
			"zolluskriffontablet", BlockList.zollusKriffonPortal);
	
	public static final ItemNova aluminumDust = new ItemNova("aluminumdust");
	
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
		addItem(ancientEssenceEden);
		addItem(edenCrystal);
		addItem(edenZollusTablet);
		addItem(edenCompressedVirinium);
		
		addItem(zollusCrystal);
		addItem(zollusHeartium);
		addItem(zollusCompressedHeartium);
		addItem(zollusCompressedVyrex);
		addItem(zollusKriffonTablet);
		
		addItem(aluminumDust);
		
		NovaHelper.echo("Loaded a total of " + totalItems + " items.");
	}
	
	public static void addItem(Item par1Item) {
		RegisterHelper.registerItem(par1Item);
		totalItems++;
	}
}