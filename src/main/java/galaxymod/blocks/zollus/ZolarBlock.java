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

package galaxymod.blocks.zollus;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.BlockNova;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ZolarBlock extends BlockNova {
	
	public ZolarBlock() {
		super(Material.rock);
		this.setNameAndTexture("solarblock");
		this.setHardResist(1.5F, 6.5F);
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z,
			ForgeDirection direction, IPlantable plantable) {
		if (plantable.equals(BlockList.zolniumCrystals)) {
			return true;
		}
		return false;
	}
	
}