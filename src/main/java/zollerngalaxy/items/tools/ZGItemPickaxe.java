package zollerngalaxy.items.tools;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGItemPickaxe extends ItemPickaxe implements ISingleZGItemRender {
	
	protected String toolType = "pickaxe";
	protected int harvestLvl = 3;
	
	public ZGItemPickaxe(String toolMetalName, int harvestLevel) {
		super(ToolMaterial.DIAMOND);
		this.setItemName(this, toolMetalName + "_" + this.toolType);
		this.setMaxDamage(this.getDiamondMaxUses() * harvestLevel);
		this.setHarvestLevel(this.toolType, harvestLevel);
		this.harvestLvl = harvestLevel;
		this.initJSONFactory();
	}
	
	private void initJSONFactory() {
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			if (this.getName() != "" && this.getName() != null) {
				JSONFactory.registerItem(this.getName());
			}
		}
	}
	
	private int getDiamondMaxUses() {
		return ToolMaterial.DIAMOND.getMaxUses();
	}
	
	@Override
	public int getItemEnchantability() {
		return ToolMaterial.DIAMOND.getEnchantability() * harvestLvl;
	}
	
	public void setItemName(final Item item, final String itemName) {
		item.setUnlocalizedName(itemName);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTab() {
		return ZGTabs.zgItemsTab;
	}
	
	@Override
	public String getName() {
		return this.getUnlocalizedName().substring(5);
	}
	
	@Override
	public boolean canHarvestBlock(IBlockState stateIn) {
		boolean canHarvest = false;
		Block block = stateIn.getBlock();
		int harvestLevel = block.getHarvestLevel(stateIn);
		canHarvest = (harvestLevel >= this.harvestLvl);
		return canHarvest;
	}
}