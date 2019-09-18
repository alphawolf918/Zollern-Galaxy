package zollerngalaxy.blocks.sweetblocks;

import net.minecraft.block.Block;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;

public class CandyCubeBlock extends ZGBlockBase {
	
	protected String color = "white";
	
	public CandyCubeBlock(String colorIn) {
		super("candycube_" + colorIn, 1.2F);
		this.setLightLevel(0.4F);
		this.setBlockType(EnumBlockType.CANDY);
		this.setHarvestLevel(EnumHarvestToolZG.PICKAXE.getHarvestTool(), EnumHarvestLevelZG.DIAMOND.getHarvestLevel());
		this.setCandyColor(colorIn);
	}
	
	public Block setCandyColor(String colorIn) {
		this.color = colorIn;
		return this;
	}
	
	public String getCandyColor() {
		return this.color;
	}
	
}