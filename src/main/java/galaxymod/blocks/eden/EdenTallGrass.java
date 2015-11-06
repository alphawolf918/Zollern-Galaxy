package galaxymod.blocks.eden;

import java.util.Random;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EdenTallGrass extends EdenFlower {

	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;

	public EdenTallGrass() {
		super("");
		NGHelper.setTab(this);
		this.setBlockName("galaxymod_edentallgrass");
		this.setBlockTextureName("galaxymod:edentallgrass");
		setHardness(0.1F);
		setResistance(0.1F);
		setStepSound(soundTypeGrass);
	}

	@Override
	protected boolean canPlaceBlockOn(Block p_149854_1_) {
		return p_149854_1_ == Blocks.grass || p_149854_1_ == Blocks.dirt
				|| p_149854_1_ == Blocks.farmland
				|| p_149854_1_ == BlockList.edenSurfaceRock
				|| p_149854_1_ == BlockList.edenGrass
				|| p_149854_1_ == BlockList.edenSoil;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return null;
	}
}