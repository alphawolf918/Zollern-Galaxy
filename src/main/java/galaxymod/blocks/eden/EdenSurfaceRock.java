package galaxymod.blocks.eden;

import galaxymod.lib.ModInfo;
import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class EdenSurfaceRock extends Block {
	public EdenSurfaceRock() {
		super(Material.rock);
		NGHelper.setTab(this);
		this.setBlockName(ModInfo.MODID + "_edensurfaceblock");
		this.setResistance(3.8F);
		this.setHardness(1.1F);
		this.setBlockTextureName(ModInfo.MODID + ":edensurfaceblock");
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z,
			ForgeDirection direction, IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);
		EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
		if (plantType == EnumPlantType.Plains
				|| plantType == EnumPlantType.Crop) {
			return true;
		}
		return false;
	}
}