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

import galaxymod.lib.NovaHelper.KeyHelper;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHUD extends ItemNova {
	
	public ItemHUD() {
		super("hud");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_,
			List list, boolean p_77624_4_) {
		if (KeyHelper.isCtrlKeyDown() || KeyHelper.isShiftKeyDown()) {
			list.add(EnumChatFormatting.ITALIC
					+ "Passively shows all planetary");
			list.add(EnumChatFormatting.ITALIC + "and biome data.");
			list.add(EnumChatFormatting.ITALIC
					+ " Works by being in inventory.");
		} else {
			list.add("Hold LSHIFT for more information.");
		}
	}
}