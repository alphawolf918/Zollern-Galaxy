package galaxymod.blocks.eden;

import galaxymod.lib.ModInfo;
import galaxymod.lib.NGHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class EdenSoil extends Block {
	public EdenSoil() {
		super(Material.grass);
		NGHelper.setTab(this);
		this.setBlockName(ModInfo.MODID + "_edensoil");
		this.setResistance(0.8F);
		this.setHardness(0.8F);
		this.setBlockTextureName(ModInfo.MODID + ":edensoil");
		this.setStepSound(soundTypeGravel);
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