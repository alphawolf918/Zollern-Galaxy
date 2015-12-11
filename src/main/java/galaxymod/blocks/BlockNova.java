/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks;

import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockNova extends Block {
	public BlockNova(Material par1Material) {
		super(par1Material);
		NGHelper.setTab(this);
		this.setHardResist(1.8F, 9.8F);
		this.setStepSound(soundTypeStone);
	}
	
	public void setHardResist(float par1Hardness, float par2Resistance) {
		NGHelper.setHardnessAndResistance(this, par1Hardness, par2Resistance);
	}
	
	public void setHardResist(float par1HardResist) {
		NGHelper.setHardnessAndResistance(this, par1HardResist);
	}
	
	public void setName(String strName) {
		NGHelper.setName(this, strName);
	}
	
	public void setTexture(String strTexture) {
		NGHelper.setTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strTexture) {
		NGHelper.setNameAndTexture(this, strTexture);
	}
	
	public void setNameAndTexture(String strName, String strTexture) {
		NGHelper.setNameAndTexture(this, strName, strTexture);
	}
}