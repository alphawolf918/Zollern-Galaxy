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

package galaxymod.blocks.eden;

import galaxymod.ZollernGalaxyCore;
import galaxymod.blocks.BlockList;
import galaxymod.utils.ZGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class EdenFlower extends BlockBush {
	
	public EdenFlower(String strTexture) {
		super(Material.plants);
		ZGHelper.setNameAndTexture(this, "edenflower_" + strTexture);
		ZGHelper.setHardResist(this, 0.1F);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block plantBlock) {
		return plantBlock == Blocks.grass || plantBlock == Blocks.dirt
				|| plantBlock == Blocks.farmland
				|| plantBlock == BlockList.edenSurfaceRock
				|| plantBlock == BlockList.edenGrass
				|| plantBlock == BlockList.edenSoil;
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}
	
	@Override
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZollernGalaxyCore.novaTabBlocks;
	}
}