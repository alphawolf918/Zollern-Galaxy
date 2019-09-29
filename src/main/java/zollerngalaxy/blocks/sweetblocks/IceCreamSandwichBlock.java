package zollerngalaxy.blocks.sweetblocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.EnumBlockType;

public class IceCreamSandwichBlock extends ZGBlockBase {
	
	public IceCreamSandwichBlock() {
		super("icecreamsandwichblock", 1.6F);
		this.setMaterial(Material.CLOTH);
		this.setSoundType(SoundType.CLOTH);
		this.setBlockType(EnumBlockType.SWEET);
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
	
}