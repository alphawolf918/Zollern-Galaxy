/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import micdoodle8.mods.galacticraft.api.block.IDetectableResource;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNovaOre extends BlockNova implements IDetectableResource {
	
	public BlockNovaOre() {
		super(Material.rock);
		this.setDefaults();
	}
	
	public BlockNovaOre(String strTexture) {
		super(Material.rock);
		this.setDefaults();
		this.setNameAndTexture(strTexture);
	}
	
	public BlockNovaOre(String strTexture, float hardness, float resistance) {
		super(Material.rock);
		this.setDefaults();
	}
	
	public Block setDefaults() {
		this.setHardResist(2.5F, 4.0F);
		this.setHarvestLevel("pickaxe", 3);
		this.setStepSound(soundTypeStone);
		return this;
	}
	
	@Override
	public boolean isValueable(int metadata) {
		return true;
	}
	
}