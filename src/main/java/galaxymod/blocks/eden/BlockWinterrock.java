/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockNova;
import galaxymod.lib.NGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockWinterrock extends BlockNova {
	public BlockWinterrock() {
		super(Material.snow);
		NGHelper.setNameAndTexture(this, "edenwinterrock");
		this.setHardness(0.4F);
		this.setResistance(0.4F);
		this.setStepSound(soundTypeSnow);
		this.setHarvestLevel("shovel", 1);
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
	public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_,
			int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
		this.func_150155_m(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
	}
	
	private boolean func_150155_m(World p_150155_1_, int p_150155_2_,
			int p_150155_3_, int p_150155_4_) {
		if (!this.canPlaceBlockAt(p_150155_1_, p_150155_2_, p_150155_3_,
				p_150155_4_)) {
			p_150155_1_.setBlockToAir(p_150155_2_, p_150155_3_, p_150155_4_);
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public void harvestBlock(World p_149636_1_, EntityPlayer p_149636_2_,
			int p_149636_3_, int p_149636_4_, int p_149636_5_, int p_149636_6_) {
		super.harvestBlock(p_149636_1_, p_149636_2_, p_149636_3_, p_149636_4_,
				p_149636_5_, p_149636_6_);
		p_149636_1_.setBlockToAir(p_149636_3_, p_149636_4_, p_149636_5_);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return Items.snowball;
	}
	
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 1;
	}
}