/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import galaxymod.core.config.ConfigManagerNova;
import galaxymod.dimensions.providers.eden.TeleporterEdenZollus;
import galaxymod.utils.NovaHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEdenZollusPortal extends BlockPortal {
	
	public BlockEdenZollusPortal() {
		NovaHelper.setNameAndTexture(this, "edenzollusportal");
		this.setTickRandomly(true);
		this.setLightLevel(1F);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon("galaxymod:edenzollusportal");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return this.blockIcon;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		if (par5Entity.ridingEntity == null
				&& par5Entity.riddenByEntity == null
				&& par5Entity instanceof EntityPlayerMP) {
			EntityPlayerMP player = (EntityPlayerMP) par5Entity;
			
			MinecraftServer mServer = MinecraftServer.getServer();
			
			if (player.timeUntilPortal > 0) {
				player.timeUntilPortal = 10;
			} else if (player.dimension != ConfigManagerNova.planetZollusDimensionId) {
				player.timeUntilPortal = 10;
				
				player.mcServer
						.getConfigurationManager()
						.transferPlayerToDimension(
								player,
								ConfigManagerNova.planetZollusDimensionId,
								new TeleporterEdenZollus(
										mServer.worldServerForDimension(ConfigManagerNova.planetZollusDimensionId)));
			} else {
				player.timeUntilPortal = 10;
				player.mcServer
						.getConfigurationManager()
						.transferPlayerToDimension(
								player,
								ConfigManagerNova.planetEdenDimensionId,
								new TeleporterEdenZollus(
										mServer.worldServerForDimension(ConfigManagerNova.planetEdenDimensionId)));
			}
		}
	}
	
	@Override
	public boolean func_150000_e(World par1World, int par2, int par3, int par4) {
		byte b0 = 0;
		byte b1 = 0;
		
		if (par1World.getBlock(par2 - 1, par3, par4) == BlockList.edenSacredStone
				|| par1World.getBlock(par2 + 1, par3, par4) == BlockList.edenSacredStone) {
			b0 = 1;
		}
		
		if (par1World.getBlock(par2, par3, par4 - 1) == BlockList.edenSacredStone
				|| par1World.getBlock(par2, par3, par4 + 1) == BlockList.edenSacredStone) {
			b1 = 1;
		}
		
		if (b0 == b1) {
			return false;
		} else {
			if (par1World.isAirBlock(par2 - b0, par3, par4 - b1)) {
				par2 -= b0;
				par4 -= b1;
			}
			
			int l;
			int i1;
			
			for (l = -1; l <= 2; ++l) {
				for (i1 = -1; i1 <= 3; ++i1) {
					boolean flag = l == -1 || l == 2 || i1 == -1 || i1 == 3;
					
					if (l != -1 && l != 2 || i1 != -1 && i1 != 3) {
						Block j1 = par1World.getBlock(par2 + b0 * l, par3 + i1,
								par4 + b1 * l);
						boolean isAirBlock = par1World.isAirBlock(
								par2 + b0 * l, par3 + i1, par4 + b1 * l);
						
						if (flag) {
							if (j1 != BlockList.edenSacredStone) {
								return false;
							}
						} else if (!isAirBlock && j1 != Blocks.fire) {
							return false;
						}
					}
				}
			}
			
			for (l = 0; l < 2; ++l) {
				for (i1 = 0; i1 < 3; ++i1) {
					par1World.setBlock(par2 + b0 * l, par3 + i1, par4 + b1 * l,
							this, 0, 2);
				}
			}
			
			return true;
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		byte b0 = 0;
		byte b1 = 1;
		
		if (par1World.getBlock(par2 - 1, par3, par4) == this
				|| par1World.getBlock(par2 + 1, par3, par4) == this) {
			b0 = 1;
			b1 = 0;
		}
		
		int i1;
		
		for (i1 = par3; par1World.getBlock(par2, i1 - 1, par4) == this; --i1) {
			;
		}
		
		if (par1World.getBlock(par2, i1 - 1, par4) != BlockList.edenSacredStone) {
			par1World.setBlockToAir(par2, par3, par4);
		} else {
			int j1;
			
			for (j1 = 1; j1 < 4
					&& par1World.getBlock(par2, i1 + j1, par4) == this; ++j1) {
				;
			}
			
			if (j1 == 3
					&& par1World.getBlock(par2, i1 + j1, par4) == BlockList.edenSacredStone) {
				boolean flag = par1World.getBlock(par2 - 1, par3, par4) == this
						|| par1World.getBlock(par2 + 1, par3, par4) == this;
				boolean flag1 = par1World.getBlock(par2, par3, par4 - 1) == this
						|| par1World.getBlock(par2, par3, par4 + 1) == this;
				
				if (flag && flag1) {
					par1World.setBlockToAir(par2, par3, par4);
				} else {
					if ((par1World.getBlock(par2 + b0, par3, par4 + b1) != BlockList.edenSacredStone || par1World
							.getBlock(par2 - b0, par3, par4 - b1) != this)
							&& (par1World.getBlock(par2 - b0, par3, par4 - b1) != BlockList.edenSacredStone || par1World
									.getBlock(par2 + b0, par3, par4 + b1) != this)) {
						par1World.setBlockToAir(par2, par3, par4);
					}
				}
			} else {
				par1World.setBlockToAir(par2, par3, par4);
			}
		}
	}
}