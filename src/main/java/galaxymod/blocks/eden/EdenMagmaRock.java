/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EdenMagmaRock extends BlockNova {
	public EdenMagmaRock() {
		super(Material.rock);
		NGHelper.setNameAndTexture(this, "magmarock");
		this.setResistance(9.8F);
		this.setHardness(1.8F);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeStone);
	}
	
	@Override
	public int getFlammability(IBlockAccess world, int x, int y, int z,
			ForgeDirection face) {
		return 195;
	}
	
	@Override
	public boolean isFireSource(World world, int x, int y, int z,
			ForgeDirection side) {
		return true;
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z,
			ForgeDirection face) {
		return true;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z,
			ForgeDirection face) {
		return Blocks.fire.getEncouragement(this);
	}
}