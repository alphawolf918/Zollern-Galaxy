package galaxymod.blocks;

import galaxymod.lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockEdenRock extends Block {
	public BlockEdenRock(){
		super(Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setBlockName(ModInfo.MODID+"_edenrock");
		this.setResistance(9.8F);
		this.setHardness(4.1F);
		this.setBlockTextureName(ModInfo.MODID+":edenrock");
	}
}