package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.blocks.BlockList;
import galaxymod.lib.ModInfo;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockEdenRock extends BlockNova {
	public BlockEdenRock() {
		super(Material.rock);
		this.setBlockName(ModInfo.MODID + "_edenrock");
		this.setResistance(9.8F);
		this.setHardness(1.8F);
		this.setBlockTextureName(ModInfo.MODID + ":edenrock");
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Item.getItemFromBlock(BlockList.edenCobbleRock);
	}
}