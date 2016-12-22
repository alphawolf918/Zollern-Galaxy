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

package galaxymod.items.food;

import galaxymod.ProjectNovaCore;
import galaxymod.utils.ZGHelper;
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
		ZGHelper.setTab(this);
		ZGHelper.setNameAndTexture(this, strTexture);
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