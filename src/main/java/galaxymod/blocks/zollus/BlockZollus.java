package galaxymod.blocks.zollus;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.ModInfo;
import net.minecraft.block.material.Material;

public class BlockZollus extends BlockNova {
	public BlockZollus() {
		super(Material.rock);
		this.setBlockName(ModInfo.MODID + "_solarblock");
		this.setResistance(5.6F);
		this.setHardness(1.1F);
		this.setBlockTextureName(ModInfo.MODID + ":solarblock");
	}
}