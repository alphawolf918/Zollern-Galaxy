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

package galaxymod.blocks.coreblocks;

import galaxymod.blocks.BlockNova;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockHealingStation extends BlockNova {
	
	public BlockHealingStation() {
		super("heartblock", Material.anvil);
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
			float maxHealth = player.getMaxHealth();
			player.setHealth(maxHealth);
		}
		return true;
	}
	
}
