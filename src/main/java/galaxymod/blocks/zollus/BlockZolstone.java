package galaxymod.blocks.zollus;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.BlockNova;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockZolstone extends BlockNova {
	public BlockZolstone() {
		super(Material.rock);
		this.setNameAndTexture("zolstone");
		this.setHardResist(4.1F, 9.8F);
		this.setDropItem(Item.getItemFromBlock(BlockList.zolCobbleRock));
	}
}