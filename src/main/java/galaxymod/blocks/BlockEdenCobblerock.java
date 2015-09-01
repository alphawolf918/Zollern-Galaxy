package galaxymod.blocks;

import galaxymod.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockEdenCobblerock extends Block {
	public BlockEdenCobblerock(){
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(ModInfo.MODID+"_edencobblerock");
		this.setResistance(9.9F);
		this.setHardness(1.2F);
		this.setBlockTextureName(ModInfo.MODID+":edencobblerock");
	}
}