package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class EdenSurfaceRock extends BlockNova {
	
	public EdenSurfaceRock() {
		super(Material.rock);
		this.setNameAndTexture("edensurfaceblock");
		this.setHardResist(1.1F, 3.8F);
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