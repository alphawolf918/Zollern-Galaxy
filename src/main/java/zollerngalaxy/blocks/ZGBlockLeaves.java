/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.lib.helpers.json.JSONFactory;

public class ZGBlockLeaves extends ZGBlockBase implements IShearable {
	
	protected boolean CHECK_DECAY = false;
	protected boolean DECAYABLE = true;
	protected boolean leavesFancy;
	protected Block droppedSapling;
	protected Item droppedFruit = null;
	int[] surroundings;
	
	public ZGBlockLeaves(String blockName, float hardResist, Block sapling) {
		super(blockName, hardResist);
		this.setMaterial(Material.LEAVES);
		this.setSound(SoundType.PLANT);
		this.setBlockType(EnumBlockType.LEAVES);
		this.setTickRandomly(true);
		this.setLightOpacity(1);
		this.droppedSapling = sapling;
		this.setShouldJSONIgnore(true);
		if (ZollernGalaxyCore.instance().isInDevMode()) {
			JSONFactory.registerLeaves(blockName);
		}
	}
	
	public ZGBlockLeaves(String blockName, Block sapling) {
		this(blockName, 0.4F, sapling);
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		int i = 1;
		int j = 2;
		int k = pos.getX();
		int l = pos.getY();
		int i1 = pos.getZ();
		
		if (worldIn.isAreaLoaded(new BlockPos(k - 2, l - 2, i1 - 2), new BlockPos(k + 2, l + 2, i1 + 2))) {
			for (int j1 = -1; j1 <= 1; ++j1) {
				for (int k1 = -1; k1 <= 1; ++k1) {
					for (int l1 = -1; l1 <= 1; ++l1) {
						BlockPos blockpos = pos.add(j1, k1, l1);
						IBlockState iblockstate = worldIn.getBlockState(blockpos);
						
						if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
							iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			CHECK_DECAY = true;
			if (CHECK_DECAY && DECAYABLE) {
				int i = 4;
				int j = 5;
				int k = pos.getX();
				int l = pos.getY();
				int i1 = pos.getZ();
				int j1 = 32;
				int k1 = 1024;
				int l1 = 16;
				
				if (this.surroundings == null) {
					this.surroundings = new int[32768];
				}
				
				if (!worldIn.isAreaLoaded(pos, 1))
					return;
				if (worldIn.isAreaLoaded(pos, 6)) {
					BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
					
					for (int i2 = -4; i2 <= 4; ++i2) {
						for (int j2 = -4; j2 <= 4; ++j2) {
							for (int k2 = -4; k2 <= 4; ++k2) {
								IBlockState iblockstate = worldIn.getBlockState(blockpos$mutableblockpos.setPos(k + i2, l + j2, i1 + k2));
								Block block = iblockstate.getBlock();
								
								if (!block.canSustainLeaves(iblockstate, worldIn, blockpos$mutableblockpos.setPos(k + i2, l + j2, i1 + k2))) {
									if (block.isLeaves(iblockstate, worldIn, blockpos$mutableblockpos.setPos(k + i2, l + j2, i1 + k2))) {
										this.surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = -2;
									} else {
										this.surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = -1;
									}
								} else {
									this.surroundings[(i2 + 16) * 1024 + (j2 + 16) * 32 + k2 + 16] = 0;
								}
							}
						}
					}
					
					for (int i3 = 1; i3 <= 4; ++i3) {
						for (int j3 = -4; j3 <= 4; ++j3) {
							for (int k3 = -4; k3 <= 4; ++k3) {
								for (int l3 = -4; l3 <= 4; ++l3) {
									if (this.surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16] == i3 - 1) {
										if (this.surroundings[(j3 + 16 - 1) * 1024 + (k3 + 16) * 32 + l3 + 16] == -2) {
											this.surroundings[(j3 + 16 - 1) * 1024 + (k3 + 16) * 32 + l3 + 16] = i3;
										}
										
										if (this.surroundings[(j3 + 16 + 1) * 1024 + (k3 + 16) * 32 + l3 + 16] == -2) {
											this.surroundings[(j3 + 16 + 1) * 1024 + (k3 + 16) * 32 + l3 + 16] = i3;
										}
										
										if (this.surroundings[(j3 + 16) * 1024 + (k3 + 16 - 1) * 32 + l3 + 16] == -2) {
											this.surroundings[(j3 + 16) * 1024 + (k3 + 16 - 1) * 32 + l3 + 16] = i3;
										}
										
										if (this.surroundings[(j3 + 16) * 1024 + (k3 + 16 + 1) * 32 + l3 + 16] == -2) {
											this.surroundings[(j3 + 16) * 1024 + (k3 + 16 + 1) * 32 + l3 + 16] = i3;
										}
										
										if (this.surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + (l3 + 16 - 1)] == -2) {
											this.surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + (l3 + 16 - 1)] = i3;
										}
										
										if (this.surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16 + 1] == -2) {
											this.surroundings[(j3 + 16) * 1024 + (k3 + 16) * 32 + l3 + 16 + 1] = i3;
										}
									}
								}
							}
						}
					}
				}
				
				int l2 = this.surroundings[16912];
				
				if (l2 >= 0) {
					worldIn.setBlockState(pos, state, 4);
				} else {
					this.destroy(worldIn, pos);
				}
			}
			CHECK_DECAY = false;
		}
	}
	
	private void destroy(World worldIn, BlockPos pos) {
		this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
		worldIn.setBlockToAir(pos);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (worldIn.isRainingAt(pos.up()) && !worldIn.getBlockState(pos.down()).isTopSolid() && rand.nextInt(15) == 1) {
			double d0 = pos.getX() + rand.nextFloat();
			double d1 = pos.getY() - 0.05D;
			double d2 = pos.getZ() + rand.nextFloat();
			worldIn.spawnParticle(EnumParticleTypes.DRIP_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	@Override
	public int quantityDropped(Random random) {
		return random.nextInt(20) == 0 ? 1 : 0;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this.droppedSapling);
	}
	
	@Override
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}
	
	protected void dropFruit(World worldIn, BlockPos pos, IBlockState state, int chance) {
		// TODO
	}
	
	protected int getSaplingDropChance(IBlockState state) {
		return 40;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@SideOnly(Side.CLIENT)
	public void setGraphicsLevel(boolean fancy) {
		this.leavesFancy = fancy;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}
	
	@Override
	public boolean causesSuffocation(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public void beginLeavesDecay(IBlockState state, World world, BlockPos pos) {
		if (!this.CHECK_DECAY) {
			world.setBlockState(pos, state, 4);
		}
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = (world instanceof World) ? ((World) world).rand : new Random();
		int chance = this.getSaplingDropChance(state);
		
		if (fortune > 0) {
			chance -= 2 << fortune;
			if (chance < 10)
				chance = 10;
		}
		
		if (rand.nextInt(chance) == 0) {
			ItemStack drop = new ItemStack(getItemDropped(state, rand, fortune), 1, damageDropped(state));
			if (!drop.isEmpty())
				drops.add(drop);
		}
		
		chance = 200;
		if (fortune > 0) {
			chance -= 10 << fortune;
			if (chance < 40)
				chance = 40;
		}
		
		this.captureDrops(true);
		if (world instanceof World) {
			this.dropFruit((World) world, pos, state, chance);
		}
		drops.addAll(this.captureDrops(false));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return !this.leavesFancy && blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
	
	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return true;
	}
}