/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 ******************************************************************************/

package galaxymod.items.eden;

import galaxymod.items.ItemNova;
import micdoodle8.mods.galacticraft.api.item.IKeyItem;
import net.minecraft.item.ItemStack;

public class ItemEdenDungeonKey extends ItemNova implements IKeyItem {
	
	public ItemEdenDungeonKey() {
		super("edendungeonkey");
	}
	
	@Override
	public int getTier(ItemStack stack) {
		return 3;
	}
}