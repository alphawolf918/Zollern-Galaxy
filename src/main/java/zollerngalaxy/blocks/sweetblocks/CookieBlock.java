package zollerngalaxy.blocks.sweetblocks;

import java.util.Random;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;

public class CookieBlock extends ZGBlockBase {
	
	public CookieBlock() {
		super("cookieblock", 3.2F);
		this.setMaterial(Material.CLOTH);
		this.setSoundType(SoundType.CLOTH);
		this.setBlockType(EnumBlockType.SWEET);
		this.setHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
	}
	
	@Override
	public Item getItemDropped(IBlockState par1BlockState, Random rand, int fortune) {
		return Items.COOKIE;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		int numDropped = rand.nextInt(5);
		numDropped = (numDropped < 1) ? 1 : numDropped;
		return numDropped;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0
				&& Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator()
						.next(), random, fortune)) {
			int i = random.nextInt(fortune + 2) - 1;
			
			if (i < 0) {
				i = 0;
			}
			
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}
}