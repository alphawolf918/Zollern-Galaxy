package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class ZGShineBlock extends ZGBlockBase {
	
	private Item droppedItem;
	
	public ZGShineBlock(String blockName, Item itemToDrop) {
		this(blockName, 1.2F, itemToDrop);
	}
	
	public ZGShineBlock(String blockName, float hardResist, Item itemToDrop) {
		super(blockName, hardResist);
		this.setLightLevel(1.0F);
		this.setMaterial(Material.GLASS);
		this.setSound(SoundType.GLASS);
		this.droppedItem = itemToDrop;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.droppedItem;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int randInt = rand.nextInt(6);
		return (randInt > 0) ? randInt : 1;
	}
}