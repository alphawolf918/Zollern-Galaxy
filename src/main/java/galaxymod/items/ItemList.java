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

import galaxymod.items.eden.ItemEdenDungeonKey;
import galaxymod.items.eden.ItemTabletEden;
import galaxymod.items.food.CookedFood;
import galaxymod.items.food.ItemFruit;
import galaxymod.items.food.RawFood;
import galaxymod.items.kriffon.ItemKriffonTablet;
import galaxymod.items.zollus.ItemAncientZollusTablet;
import galaxymod.utils.NovaHelper;
import galaxymod.utils.RegisterHelper;
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
	public static final ItemNova edenZollusTablet = new ItemTabletEden();
	public static final ItemNova edenCompressedVirinium = new ItemNova(
			"compressedvirinium");
	
	public static final ItemNova zollusCrystal = new ItemNova("zolluscrystal");
	public static final ItemNova zollusHeartium = new ItemNova("heartofzol");
	public static final ItemNova zollusCompressedHeartium = new ItemNova(
			"compressedheartium");
	public static final ItemNova zollusCompressedVyrex = new ItemNova(
			"compressedvyrex");
	public static final ItemNova zollusKriffonTablet = new ItemAncientZollusTablet();
	
	public static final ItemNova ingotCobalt = new ItemNova("ingotcobalt");
	public static final ItemNova compressedCobalt = new ItemNova(
			"compressedcobalt");
	public static final ItemNova compressedKriffonium = new ItemNova(
			"compressedkriffonium");
	public static final ItemNova kriffonCrystal = new ItemNova("kriffoncrystal");
	public static final ItemNova kriffonPurgotTablet = new ItemKriffonTablet();
	
	public static final ItemNova ingotEvenium = new ItemNova("ingotevenium");
	public static final ItemNova compressedEvenium = new ItemNova(
			"compressedevenium");
	
	public static final ItemNova dustAluminum = new ItemNova("aluminumdust");
	public static final ItemNova dustCobalt = new ItemNova("pulverizedcobalt");
	public static final ItemNova dustDiamond = new ItemNova("diamonddust");
	public static final ItemNova dustEmerald = new ItemNova("emeralddust");
	public static final ItemNova dustEvenium = new ItemNova("eveniumdust");
	
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
		
		addItem(ingotCobalt);
		addItem(compressedCobalt);
		addItem(compressedKriffonium);
		addItem(kriffonCrystal);
		addItem(kriffonPurgotTablet);
		
		addItem(ingotEvenium);
		addItem(compressedEvenium);
		
		addItem(dustAluminum);
		addItem(dustCobalt);
		addItem(dustDiamond);
		addItem(dustEmerald);
		addItem(dustEvenium);
		
		NovaHelper.echo("Loaded a total of " + totalItems + " new items.");
	}
	
	public static void addItem(Item par1Item) {
		RegisterHelper.registerItem(par1Item);
		totalItems++;
	}
}