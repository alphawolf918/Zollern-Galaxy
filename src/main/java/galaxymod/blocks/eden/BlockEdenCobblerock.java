package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.ModInfo;
import net.minecraft.block.material.Material;

public class BlockEdenCobblerock extends BlockNova {
	public BlockEdenCobblerock() {
		super(Material.rock);
		this.setBlockName(ModInfo.MODID + "_edencobblerock");
		this.setResistance(9.9F);
		this.setHardness(1.2F);
		this.setBlockTextureName(ModInfo.MODID + ":edencobblerock");
	}
}