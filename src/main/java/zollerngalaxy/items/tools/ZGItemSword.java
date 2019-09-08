package zollerngalaxy.items.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGItemSword extends ItemSword implements ISingleZGItemRender {
	
	protected String toolType = "sword";
	protected float strengthMultiplier = 4.0F;
	protected int harvestLvl = 3;
	
	public ZGItemSword(String toolMetalName, int harvestLevel) {
		super(ToolMaterial.DIAMOND);
		this.setItemName(this, toolMetalName + "_" + this.toolType);
		this.setMaxDamage(this.getDiamondMaxUses() * harvestLevel);
		this.setHarvestLevel(this.toolType, harvestLevel);
		this.strengthMultiplier = (harvestLevel + 2) * 1.0F;
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
		return ToolMaterial.DIAMOND.getEnchantability() * this.harvestLvl;
	}
	
	@Override
	public float getAttackDamage() {
		return ToolMaterial.DIAMOND.getAttackDamage() * this.strengthMultiplier;
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
	
}