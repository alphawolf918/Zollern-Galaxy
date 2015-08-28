package galaxymod.blocks;

import galaxymod.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockZolstone extends Block {
	public BlockZolstone(){
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(ModInfo.MODID+"_zolstone");
		this.setResistance(9.8F);
		this.setHardness(4.1F);
		this.setBlockTextureName(ModInfo.MODID+":zolstone");
	}
}