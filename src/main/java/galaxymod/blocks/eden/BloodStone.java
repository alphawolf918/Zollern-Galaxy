package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import net.minecraft.block.material.Material;

public class BloodStone extends BlockNova {
	public BloodStone() {
		super(Material.rock);
		NGHelper.setNameAndTexture(this, "bloodstone");
		this.setResistance(2F);
		this.setHardness(2F);
	}
}