package galaxymod.blocks;

import galaxymod.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockZollus extends Block {
	public BlockZollus(){
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(ModInfo.MODID+"_solarblock");
		this.setResistance(5.6F);
		this.setHardness(1.1F);
		this.setBlockTextureName(ModInfo.MODID+":solarblock");
	}
}