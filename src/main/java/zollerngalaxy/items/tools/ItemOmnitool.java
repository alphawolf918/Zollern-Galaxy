package zollerngalaxy.items.tools;

import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ISingleZGItemRender;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import com.google.common.collect.Sets;

public class ItemOmnitool extends ItemTool implements ISingleZGItemRender {
	
	private static final String OMNITOOL_NAME = "omnitool";
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE,
			Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB,
			Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE,
			Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK,
			Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE,
			Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE, ZGBlocks.zolCrystals);
	
	public ItemOmnitool() {
		super(16.0F, 2.0F, ToolMaterial.DIAMOND, EFFECTIVE_ON); // FIXME
		this.setItemName(this, OMNITOOL_NAME);
		this.setMaxStackSize(1);
		this.setMaxDamage(0);
		this.initJSONFactory();
	}
	
	private void initJSONFactory() {
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerItem(OMNITOOL_NAME);
		}
	}
	
	// TODO: Add different layers and types of Omnitools
	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return (material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super
				.getDestroySpeed(stack, state) : this.efficiency) * 0.8F;
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
		return true;
	}
	
}