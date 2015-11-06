package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class EdenGrass extends Block {
	private IIcon[] edenGrassIcon;

	public EdenGrass() {
		super(Material.grass);
		NGHelper.setTab(this);
		this.setBlockName("galaxymod:edengrass");
		this.setHardness(0.1F);
		this.setResistance(0.0F);
		this.setStepSound(soundTypeGrass);
		this.setTickRandomly(true);
	}

	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.edenGrassIcon = new IIcon[2];
		this.edenGrassIcon[0] = par1IconRegister
				.registerIcon("galaxymod:edensoil");
		this.edenGrassIcon[1] = par1IconRegister
				.registerIcon("galaxymod:edengrass");
	}

	@Override
	public IIcon getIcon(int par1, int par2) {
		if (par1 < 0 || par1 >= this.edenGrassIcon.length) {
			par1 = 1;
		}
		return this.edenGrassIcon[par1];
	}

	@Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3,
			int par4, int par5) {
		Block block = par1IBlockAccess.getBlock(par2, par3 + 1, par4);

		if (par5 == 1) {
			return this.edenGrassIcon[1];
		} else if (par5 == 0) {
			return BlockList.edenSoil.getBlockTextureFromSide(par5);
		} else if (par5 == 2 || par5 == 3 || par5 == 4 || par5 == 5) {
			return this.edenGrassIcon[0];
		}
		return this.blockIcon;
	}

	@Override
	public void updateTick(World world, int par2, int par3, int par4,
			Random par5Random) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(par2, par3 + 1, par4) < 4
					&& world.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
				world.setBlock(par2, par3, par4, BlockList.edenSoil);
			} else if (world.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
				for (int var6 = 0; var6 < 4; ++var6) {
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					Block var10 = world.getBlock(var7, var8 + 1, var9);

					if (world.getBlock(var7, var8, var9) == BlockList.edenSoil
							&& world.getBlockMetadata(var7, var8, var9) == 0) {
						if (world.getBlockLightValue(var7, var8 + 1, var9) >= 4
								&& var10.getLightOpacity() <= 2) {
							world.setBlock(var7, var8, var9,
									BlockList.edenGrass);
						}
					}
				}
			}
		}
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

	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(BlockList.edenSoil);
	}
}