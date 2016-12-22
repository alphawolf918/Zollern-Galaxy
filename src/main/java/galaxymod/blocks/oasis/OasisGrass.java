/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.blocks.oasis;

import galaxymod.blocks.BlockList;
import galaxymod.blocks.BlockNova;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OasisGrass extends BlockNova {
	
	private IIcon[] oasisGrassIcon;
	public IIcon blockIcon;
	
	public OasisGrass() {
		super(Material.grass);
		this.setBlockName("galaxymod_oasisgrass");
		this.setHardResist(0.4F);
		this.setTickRandomly(true);
		this.setHarvestLevel("shovel", 1);
		this.setStepSound(soundTypeGrass);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.oasisGrassIcon = new IIcon[7];
		this.oasisGrassIcon[0] = par1IconRegister
				.registerIcon("galaxymod:oasisdirt");
		this.oasisGrassIcon[1] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass");
		this.oasisGrassIcon[2] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass_side");
		this.oasisGrassIcon[3] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass_side");
		this.oasisGrassIcon[4] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass_side");
		this.oasisGrassIcon[5] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass_side");
		this.oasisGrassIcon[6] = par1IconRegister
				.registerIcon("galaxymod:oasisgrass_side");
		this.blockIcon = this.oasisGrassIcon[2];
	}
	
	@Override
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.oasisGrassIcon[1]
				: (par1 == 0 ? BlockList.oasisDirt
						.getBlockTextureFromSide(par1) : this.blockIcon);
	}
	
	@Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3,
			int par4, int par5) {
		Block block = par1IBlockAccess.getBlock(par2, par3 + 1, par4);
		
		if (par5 == 1) {
			return this.oasisGrassIcon[1];
		} else if (par5 == 0) {
			return BlockList.oasisDirt.getBlockTextureFromSide(par5);
		} else if (par5 == 2 || par5 == 3 || par5 == 4 || par5 == 5) {
			return this.oasisGrassIcon[2];
		}
		Material material = par1IBlockAccess.getBlock(par2, par3 + 1, par4)
				.getMaterial();
		return this.blockIcon;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBlockColor() {
		double d0 = 0.5D;
		double d1 = 0.1D;
		return ColorizerGrass.getGrassColor(d0, d1);
	}
	
	@Override
	public void updateTick(World world, int par2, int par3, int par4,
			Random par5Random) {
		if (!world.isRemote) {
			if (world.getBlockLightValue(par2, par3 + 1, par4) < 4
					&& world.getBlockLightOpacity(par2, par3 + 1, par4) > 2) {
				world.setBlock(par2, par3, par4, BlockList.oasisDirt);
			} else if (world.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
				for (int var6 = 0; var6 < 4; ++var6) {
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					Block var10 = world.getBlock(var7, var8 + 1, var9);
					
					if (world.getBlock(var7, var8, var9) == BlockList.oasisDirt
							&& world.getBlockMetadata(var7, var8, var9) == 0) {
						if (world.getBlockLightValue(var7, var8 + 1, var9) >= 4
								&& var10.getLightOpacity() <= 2) {
							world.setBlock(var7, var8, var9,
									BlockList.oasisGrass);
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
		if (plantType == EnumPlantType.Plains) {
			return true;
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(int par1, Random par2Random, int par3) {
		return Item.getItemFromBlock(BlockList.oasisDirt);
	}
}