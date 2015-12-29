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

package galaxymod.items.food;

import galaxymod.ProjectNovaCore;
import galaxymod.lib.NovaHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class CookedFood extends ItemFood {
	
	private static boolean isWolfFavoriteMeat = false;
	
	public CookedFood(String strTexture) {
		super(10, 10F, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	@Override
	public CreativeTabs getCreativeTab() {
		return ProjectNovaCore.novaTabItems;
	}
	
	public void setDefaults(String strTexture) {
		NovaHelper.setTab(this);
		NovaHelper.setNameAndTexture(this, strTexture);
		setMaxStackSize(64);
	}
	
	public CookedFood(String strTexture, int par1) {
		super(par1, 10F, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, float par1) {
		super(10, par1, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, int par1, float par2) {
		super(par1, par2, getFavoriteWolfMeat());
		this.setDefaults(strTexture);
	}
	
	public CookedFood(String strTexture, boolean wolfFavorite) {
		super(10, 10F, wolfFavorite);
		this.setFavoriteWolfMeat(wolfFavorite);
		this.setDefaults(strTexture);
	}
	
	public static void setFavoriteWolfMeat(boolean par1) {
		isWolfFavoriteMeat = par1;
	}
	
	public static boolean getFavoriteWolfMeat() {
		return isWolfFavoriteMeat;
	}
	
	@Override
	public boolean isWolfsFavoriteMeat() {
		return getFavoriteWolfMeat();
	}
}