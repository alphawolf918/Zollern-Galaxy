package zollerngalaxy.items;

import net.minecraft.item.Item;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGItems {
	
	private static int totalItems = 0;
	
	public static final Item heartOfZol = new ZGItemBase("heartofzol");
	public static final Item zolCrystal = new ZGItemBase("zolluscrystal");
	public static final Item kriffCrystal = new ZGItemBase("kriffoncrystal");
	public static final Item purgCrystal = new ZGItemBase("purgotcrystal");
	public static final Item edenCrystal = new ZGItemBase("edencrystal");
	public static final Item purgEssence = new ZGItemBase("purgotessence");
	public static final Item prometheanCrystal = new ZGItemBase("prometheancrystal");
	public static final Item plutoniumCrystal = new ZGItemBase("plutoniumcrystal");
	
	public static final Item dustViri = new ZGItemBase("rawviri");
	public static final Item dustCobalt = new ZGItemBase("cobaltdust");
	public static final Item dustEve = new ZGItemBase("eveniumdust");
	public static final Item dustDiamond = new ZGItemBase("diamonddust");
	public static final Item dustEmerald = new ZGItemBase("emeralddust");
	public static final Item dustBrightstone = new ZGItemBase("brightstonedust");
	
	public static final Item ingotViri = new ZGItemBase("ingotviri");
	public static final Item ingotCobalt = new ZGItemBase("ingotcobalt");
	public static final Item ingotEve = new ZGItemBase("ingotevenium");
	public static final Item hud = new ItemHUD();
	public static final Item alienStone = new ZGItemBase("alienstone");
	
	public static final Item compressedCobalt = new ZGItemBase("compressedcobalt");
	public static final Item compressedDiamond = new ZGItemBase("compresseddiamond");
	public static final Item compressedEmerald = new ZGItemBase("compressedemerald");
	public static final Item compressedEvenium = new ZGItemBase("compressedevenium");
	public static final Item compressedGold = new ZGItemBase("compressedgold");
	public static final Item compressedHeartium = new ZGItemBase("compressedheartium");
	public static final Item compressedKriffonium = new ZGItemBase("compressedkriffonium");
	public static final Item compressedVirinium = new ZGItemBase("compressedvirinium");
	public static final Item compressedVyrex = new ZGItemBase("compressedvyrex");
	
	public static final Item rawAlienBacon = new ZGItemFood("alienbaconraw", 2, 1.5F, true);
	public static final Item rawAlienBeef = new ZGItemFood("alienbeefraw", 2, 1.5F, true);
	public static final Item cookedAlienBacon = new ZGItemFood("alienbaconcooked", 6, 4.0F, true);
	public static final Item cookedAlienBeef = new ZGItemFood("alienbeefcooked", 6, 4.0F, true);
	public static final Item edenFruit = new ZGItemFood("fruitofeden", 4, 2.5F, false);
	
	public static final Item edenDungeonKey = new ZGItemBase("edendungeonkey");
	
	public static final Item starGateTier1 = new ItemStargate(1);
	public static final Item starGateTier2 = new ItemStargate(2);
	public static final Item starGateTier3 = new ItemStargate(3);
	public static final Item starGateTier4 = new ItemStargate(4);
	public static final Item starGateTier5 = new ItemStargate(5);
	public static final Item starGateTier6 = new ItemStargate(6);
	public static final Item starGateTier7 = new ItemStargate(7);
	public static final Item starGateTier8 = new ItemStargate(8);
	public static final Item starGateTier9 = new ItemStargate(9);
	public static final Item starGateTier10 = new ItemStargate(10);
	
	public static void init() {
		ZGItems.registerItems(heartOfZol, zolCrystal, kriffCrystal, purgCrystal, edenCrystal, purgEssence,
				prometheanCrystal, plutoniumCrystal, dustBrightstone, dustViri, dustEve, dustCobalt, dustDiamond,
				dustEmerald, ingotViri, ingotCobalt, ingotEve, hud, alienStone, compressedCobalt, compressedDiamond,
				compressedEmerald, compressedEvenium, compressedGold, compressedHeartium, compressedKriffonium,
				compressedVirinium, compressedVyrex, rawAlienBacon, cookedAlienBacon, rawAlienBeef, cookedAlienBeef,
				edenFruit, edenDungeonKey, starGateTier1, starGateTier2, starGateTier3, starGateTier4, starGateTier5,
				starGateTier6, starGateTier7, starGateTier8, starGateTier9, starGateTier10);
		ZGHelper.Log("Loaded a total of " + totalItems + " new items.");
	}
	
	private static void addItem(Item item) {
		CommonZGRegisterHelper.registerItem(item);
		totalItems++;
	}
	
	private static void registerItems(Item... items) {
		for (Item i : items) {
			ZGItems.addItem(i);
		}
	}
	
}