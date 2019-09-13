package zollerngalaxy.blocks.fluids;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ISingleZGBlockRender;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.lib.ZGMapper;

public class ZGFluidBase extends BlockFluidClassic implements IZGFluidModel, ISingleZGBlockRender {
	
	protected String name;
	
	public ZGFluidBase(String fluidName, Fluid fluid, Material material) {
		super(fluid, material);
		this.name = fluidName;
		this.setUnlocalizedName(fluidName);
	}
	
	@Override
	public boolean canCreatureSpawn(IBlockState state, IBlockAccess world, BlockPos pos, EntityLiving.SpawnPlacementType type) {
		return false;
	}
	
	@Override
	public boolean canDisplace(IBlockAccess world, BlockPos pos) {
		if (world.getBlockState(pos).getMaterial().isLiquid()) {
			return false;
		} else {
			return super.canDisplace(world, pos);
		}
	}
	
	@Override
	public boolean displaceIfPossible(World world, BlockPos pos) {
		if (world.getBlockState(pos).getMaterial().isLiquid()) {
			return false;
		}
		return super.displaceIfPossible(world, pos);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		Item item = Item.getItemFromBlock(this);
		ZGMapper mapper = new ZGMapper(ZGInfo.MOD_ID, "fluid", name);
		
		// Item Model
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, mapper);
		
		// Block Model
		ModelLoader.setCustomStateMapper(this, mapper);
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
}