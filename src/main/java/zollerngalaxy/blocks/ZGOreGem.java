package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGOreGem extends ZGBlockOre {
	
	protected int minDropped = 2;
	protected int maxDropped = 4;
	protected Item itemToDrop;
	
	protected int droppedMetadata = 0;
	protected boolean itemHasMetadata = false;
	
	public ZGOreGem(String blockName, float hardResist, Item gemItem) {
		super(blockName, hardResist);
		this.itemToDrop = gemItem;
	}
	
	public Block setDropMeta(int droppedMeta, boolean hasMeta) {
		this.itemHasMetadata = hasMeta;
		if (this.itemHasMetadata) {
			this.droppedMetadata = droppedMeta;
		}
		return this;
	}
	
	public Block setDroppedItemHasMetadata(boolean hasMetadata) {
		this.itemHasMetadata = hasMetadata;
		return this;
	}
	
	public boolean getDroppedItemHasMetadata() {
		return this.itemHasMetadata;
	}
	
	public Block setDroppedMetadata(int md) {
		this.droppedMetadata = md;
		return this;
	}
	
	public int getDroppedMetadata() {
		return this.droppedMetadata;
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return this.itemToDrop;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos,
			IBlockState state, int fortune) {
		int j = ZGHelper.rngNumber(this.getMinDropped(), this.getMaxDropped());
		for (int k = 0; k < j; ++k) {
			drops.add(new ItemStack(itemToDrop, 1, this.droppedMetadata));
		}
	}
	
	public Block setMinMaxDropped(int minD, int maxD) {
		this.setMinDropped(minD);
		this.setMaxDropped(maxD);
		return this;
	}
	
	public Block setMaxDropped(int md) {
		this.maxDropped = md;
		return this;
	}
	
	public Block setMinDropped(int md) {
		this.minDropped = md;
		return this;
	}
	
	public int getMinDropped() {
		return this.minDropped;
	}
	
	public int getMaxDropped() {
		return this.maxDropped;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int numDropped = 1;
		switch (this.getBlockTier()) {
		default:
			numDropped = ZGHelper.rngNumber(1, 1);
			break;
		case ONE:
			numDropped = ZGHelper.rngNumber(minDropped, maxDropped);
			break;
		case TWO:
			numDropped = ZGHelper.rngNumber(maxDropped, maxDropped + 2);
			break;
		case THREE:
			numDropped = ZGHelper.rngNumber(maxDropped + 2, maxDropped + 3);
			break;
		case FOUR:
			numDropped = ZGHelper.rngNumber(maxDropped + 4, maxDropped + 5);
			break;
		}
		return numDropped;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0
				&& Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState()
						.getValidStates().iterator().next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 0;
			}
			
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
	
	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos,
			int fortune) {
		Random rand = world instanceof World ? ((World) world).rand : new Random();
		return MathHelper.getInt(rand, 3, 7);
	}
	
}