/**
 * ZG Galaxy by @author ZG Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.recipes;

import net.minecraft.item.Item;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGRecipeHelper;

public class ArmorRecipes {
	
	public static void init() {
		// Helmet
		addArmorSet(ZGItems.helmetAmaranth, ZGItems.ingotAmaranth, "helmet");
		addArmorSet(ZGItems.helmetZollernium, ZGItems.ingotZollernium, "helmet");
		addArmorSet(ZGItems.helmetAzurite, ZGItems.azurite, "helmet");
		addArmorSet(ZGItems.helmetRadium, ZGItems.radium, "helmet");
		
		// Chest
		addArmorSet(ZGItems.chestAmaranth, ZGItems.ingotAmaranth, "Chest");
		addArmorSet(ZGItems.chestZollernium, ZGItems.ingotZollernium, "Chest");
		addArmorSet(ZGItems.chestAzurite, ZGItems.azurite, "Chest");
		addArmorSet(ZGItems.chestRadium, ZGItems.radium, "Chest");
		
		// Legs
		addArmorSet(ZGItems.legsAmaranth, ZGItems.ingotAmaranth, "Legs");
		addArmorSet(ZGItems.legsZollernium, ZGItems.ingotZollernium, "Legs");
		addArmorSet(ZGItems.legsAzurite, ZGItems.azurite, "Legs");
		addArmorSet(ZGItems.legsRadium, ZGItems.radium, "Legs");
		
		// Feets
		addArmorSet(ZGItems.bootsAmaranth, ZGItems.ingotAmaranth, "boots");
		addArmorSet(ZGItems.bootsZollernium, ZGItems.ingotZollernium, "boots");
		addArmorSet(ZGItems.bootsAzurite, ZGItems.azurite, "boots");
		addArmorSet(ZGItems.bootsRadium, ZGItems.radium, "boots");
	}
	
	static void addArmorSet(Item par1Item, Item par2Item, String par3String) {
		ZGRecipeHelper.addArmorSet(par1Item, par2Item, par3String);
	}
	
}