package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EdenFlower extends BlockBush {

	public EdenFlower(String strTexture) {
		super(Material.plants);
		NGHelper.setTab(this);
		this.setBlockName("galaxymod_edenflower");
		this.setBlockTextureName("galaxymod:edenflower_" + strTexture);
		setHardness(0.1F);
		setResistance(0.0F);
		setStepSound(soundTypeGrass);
	}

	@Override
	protected boolean canPlaceBlockOn(Block plantBlock) {
		return plantBlock == Blocks.grass || plantBlock == Blocks.dirt
				|| plantBlock == Blocks.farmland
				|| plantBlock == BlockList.edenSurfaceRock
				|| plantBlock == BlockList.edenGrass
				|| plantBlock == BlockList.edenSoil;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}
}