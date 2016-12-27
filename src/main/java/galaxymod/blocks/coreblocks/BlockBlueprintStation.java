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

package galaxymod.blocks.coreblocks;

import galaxymod.blocks.BlockNova;
import galaxymod.items.ItemBlueprint;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockBlueprintStation extends BlockNova {
	
	public BlockBlueprintStation() {
		super("blueprintblock", Material.anvil);
		this.setHardResist(10.0F);
		this.setBlockUnbreakable();
		this.setStepSound(soundTypeMetal);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer,
				par6, par7, par8, par9);
		EntityPlayer player = par5EntityPlayer;
		if (!player.capabilities.isCreativeMode) {
			ItemStack heldItem = player.getHeldItem();
			if (heldItem != null) {
				if (heldItem.getItem() instanceof ItemBlueprint) {
					int blueprintDamage = heldItem.getItemDamage();
					int blueprintNewDamage = (blueprintDamage - 50);
					heldItem.setItemDamage(blueprintNewDamage);
				}
			}
		}
		return true;
	}
	
}