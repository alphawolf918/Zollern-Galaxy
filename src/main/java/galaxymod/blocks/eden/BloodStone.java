package galaxymod.blocks.eden;

import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BloodStone extends Block {
	public BloodStone() {
		super(Material.rock);
		NGHelper.setTab(this);
		NGHelper.setNameAndTexture(this, "bloodstone");
		this.setResistance(2F);
		this.setHardness(2F);
	}
}