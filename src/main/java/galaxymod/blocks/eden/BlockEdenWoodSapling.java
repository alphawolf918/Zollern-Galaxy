/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import galaxymod.lib.NGHelper;
import galaxymod.worldgen.WorldGenTreeNG;
import java.util.Random;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEdenWoodSapling extends BlockBush implements IGrowable {
	public static final String field_149882_a = "";
	private static IIcon field_149881_b;
	
	public BlockEdenWoodSapling() {
		NGHelper.setTab(this);
		NGHelper.setName(this, "edenwoodsapling");
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F,
				0.5F + f);
		this.setHardness(0.0F);
	}
	
	/**
	 * Ticks the block if it's been scheduled
	 */
	@Override
	public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_,
			int p_149674_4_, Random p_149674_5_) {
		if (!p_149674_1_.isRemote) {
			super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_,
					p_149674_4_, p_149674_5_);
			
			if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1,
					p_149674_4_) >= 9 && p_149674_5_.nextInt(7) == 0) {
				this.func_149879_c(p_149674_1_, p_149674_2_, p_149674_3_,
						p_149674_4_, p_149674_5_);
			}
		}
	}
	
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		p_149691_2_ &= 7;
		return field_149881_b;
	}
	
	public void func_149879_c(World p_149879_1_, int p_149879_2_,
			int p_149879_3_, int p_149879_4_, Random p_149879_5_) {
		int l = p_149879_1_.getBlockMetadata(p_149879_2_, p_149879_3_,
				p_149879_4_);
		
		if ((l & 8) == 0) {
			p_149879_1_.setBlockMetadataWithNotify(p_149879_2_, p_149879_3_,
					p_149879_4_, l | 8, 4);
		} else {
			this.func_149878_d(p_149879_1_, p_149879_2_, p_149879_3_,
					p_149879_4_, p_149879_5_);
		}
	}
	
	public void func_149878_d(World world, int x, int y, int z, Random random) {
		int meta = world.getBlockMetadata(x, y, z);
		Object obj = null;
		random.nextInt(8);
		
		if (obj == null) {
			obj = new WorldGenTreeNG(BlockList.edenWoodLog,
					BlockList.edenWoodLeaves, 0, 0, false, 6, 4, true);
		}
		
		if (obj != null) {
			world.setBlockToAir(x, y, z);
			
			if (!((WorldGenerator) obj).generate(world, random, x, y, z)) {
				world.setBlock(x, y, z, this, meta, 2);
			}
		}
	}
	
	public boolean func_149880_a(World p_149880_1_, int p_149880_2_,
			int p_149880_3_, int p_149880_4_, int p_149880_5_) {
		return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this
				&& (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_,
						p_149880_4_) & 7) == p_149880_5_;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		field_149881_b = p_149651_1_.registerIcon("galaxymod:edentreesapling");
	}
	
	@Override
	public boolean func_149851_a(World p_149851_1_, int p_149851_2_,
			int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
		return true;
	}
	
	@Override
	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_,
			int p_149852_3_, int p_149852_4_, int p_149852_5_) {
		return p_149852_1_.rand.nextFloat() < 0.45D;
	}
	
	@Override
	public void func_149853_b(World p_149853_1_, Random p_149853_2_,
			int p_149853_3_, int p_149853_4_, int p_149853_5_) {
		this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_,
				p_149853_2_);
	}
}