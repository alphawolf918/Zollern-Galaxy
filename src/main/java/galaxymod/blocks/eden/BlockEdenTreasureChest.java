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

package galaxymod.blocks.eden;

import galaxymod.ProjectNovaCore;
import galaxymod.blocks.BlockContainerNG;
import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import galaxymod.utils.ZGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockEdenTreasureChest extends BlockContainerNG {
	
	protected Random random = new Random();
	
	public BlockEdenTreasureChest() {
		super(Material.rock);
		ZGHelper.setNameAndTexture(this, "edentreasurechest");
		this.setResistance(10000000.0F);
		this.setHardness(-1.0F);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
	
	@Override
	public void breakBlock(World par1World, int par2, int par3, int par4,
			Block par5, int par6) {
		final TileEntityTreasureChestEden var7 = (TileEntityTreasureChestEden) par1World
				.getTileEntity(par2, par3, par4);
		
		if (var7 != null) {
			for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8) {
				final ItemStack var9 = var7.getStackInSlot(var8);
				
				if (var9 != null) {
					final float var10 = this.random.nextFloat() * 0.8F + 0.1F;
					final float var11 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem var14;
					
					for (final float var12 = this.random.nextFloat() * 0.8F + 0.1F; var9.stackSize > 0; par1World
							.spawnEntityInWorld(var14)) {
						int var13 = this.random.nextInt(21) + 10;
						
						if (var13 > var9.stackSize) {
							var13 = var9.stackSize;
						}
						
						var9.stackSize -= var13;
						var14 = new EntityItem(par1World, par2 + var10, par3
								+ var11, par4 + var12, new ItemStack(
								var9.getItem(), var13, var9.getItemDamage()));
						final float var15 = 0.05F;
						var14.motionX = (float) this.random.nextGaussian()
								* var15;
						var14.motionY = (float) this.random.nextGaussian()
								* var15 + 0.2F;
						var14.motionZ = (float) this.random.nextGaussian()
								* var15;
						
						if (var9.hasTagCompound()) {
							var14.getEntityItem().setTagCompound(
									(NBTTagCompound) var9.getTagCompound()
											.copy());
						}
					}
				}
			}
		}
		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}
	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityTreasureChestEden();
	}
	
	@Override
	public int getRenderType() {
		return ProjectNovaCore.proxy.getBlockRender(this);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4,
			EntityLivingBase par5EntityLiving, ItemStack stack) {
		byte var10 = 0;
		int var11 = MathHelper
				.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
		
		if (var11 == 0) {
			var10 = 2;
		}
		if (var11 == 1) {
			var10 = 5;
		}
		if (var11 == 2) {
			var10 = 3;
		}
		if (var11 == 3) {
			var10 = 4;
		}
		par1World.setBlockMetadataWithNotify(par2, par3, par4, var10, 3);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3,
			int par4, EntityPlayer par5EntityPlayer, int par6, float par7,
			float par8, float par9) {
		Object var10 = par1World.getTileEntity(par2, par3, par4);
		
		if (var10 == null) {
			return true;
		} else if (par1World.isSideSolid(par2, par3 + 1, par4,
				ForgeDirection.DOWN)) {
			return true;
		} else if (par1World.getBlock(par2 - 1, par3, par4) == this
				&& par1World.isSideSolid(par2 - 1, par3 + 1, par4,
						ForgeDirection.DOWN)) {
			return true;
		} else if (par1World.getBlock(par2 + 1, par3, par4) == this
				&& par1World.isSideSolid(par2 + 1, par3 + 1, par4,
						ForgeDirection.DOWN)) {
			return true;
		} else if (par1World.getBlock(par2, par3, par4 - 1) == this
				&& par1World.isSideSolid(par2, par3 + 1, par4 - 1,
						ForgeDirection.DOWN)) {
			return true;
		} else if (par1World.getBlock(par2, par3, par4 + 1) == this
				&& par1World.isSideSolid(par2, par3 + 1, par4 + 1,
						ForgeDirection.DOWN)) {
			return true;
		} else {
			if (par1World.isRemote) {
				return true;
			} else {
				par5EntityPlayer.displayGUIChest((IInventory) var10);
				return true;
			}
		}
	}
}