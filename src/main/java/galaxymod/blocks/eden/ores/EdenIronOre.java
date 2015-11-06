package galaxymod.blocks.eden.ores;

import galaxymod.lib.ModInfo;
import galaxymod.lib.NGHelper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class EdenIronOre extends Block {
	public EdenIronOre() {
		super(Material.rock);
		NGHelper.setTab(this);
		this.setBlockName(ModInfo.MODID+"_edenironore");
		this.setBlockTextureName(ModInfo.MODID+":edenironore");
		this.setHardness(4.0F);
		this.setResistance(2.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 3);
	}
	
	private Random rand = new Random();
	
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_,
			int p_149690_7_) {
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item
				.getItemFromBlock(this)) {
			int j1 = 0;
			j1 = MathHelper.getRandomIntegerInRange(rand, 6, 11);
			
			return j1;
		}
		return 0;
	}
}