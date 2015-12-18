package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EdenTallGrass extends EdenFlower {
	
	@SideOnly(Side.CLIENT)
	private IIcon blockIcon;
	
	public EdenTallGrass() {
		super("");
		this.setBlockName("galaxymod_edentallgrass");
		this.setBlockTextureName("galaxymod:edentallgrass");
		setHardness(0.1F);
		setResistance(0.1F);
		setStepSound(soundTypeGrass);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 1.0D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderColor(int p_149741_1_) {
		return this.getBlockColor();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_,
			int p_149720_3_, int p_149720_4_) {
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		
		for (int k1 = -1; k1 <= 1; ++k1) {
			for (int l1 = -1; l1 <= 1; ++l1) {
				int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1,
						p_149720_4_ + k1).getBiomeFoliageColor(
						p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
				l += (i2 & 16711680) >> 16;
				i1 += (i2 & 65280) >> 8;
				j1 += i2 & 255;
			}
		}
		
		return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess world, int x, int y, int z) {
		return true;
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
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return null;
	}
}