/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.blocks.eden;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import galaxymod.lib.NGHelper;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class SpaceFruitBlock extends Block {
	
	public SpaceFruitBlock() {
		super(Material.gourd);
		NGHelper.setTab(this);
		NGHelper.setNameAndTexture(this, "fruitofedenblock");
		this.setBlockBounds(0.2F, 0.2F, 0.2F, 0.6F, 0.6F, 0.6F);
		this.setTickRandomly(true);
		this.setHardness(0.6F);
		this.setStepSound(soundTypePiston);
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this,
				this.tickRate(par1World));
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3,
			int par4, Block par5) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this,
				this.tickRate(par1World));
	}
	
	@Override
	public void updateTick(World world, int par2, int par3, int par4,
			Random rand) {
		if (!world.isRemote) {
			if (!(world.getBlock(par2, par3 + 1, par4) == BlockList.edenWoodLeaves)) {
				this.tryToFall(world, par2, par3, par4);
			}
		}
	}
	
	private void tryToFall(World par1World, int par2, int par3, int par4) {
		if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0) {
			par1World.setBlock(par2, par3, par4, Blocks.air, 0, 3);
			
			while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0) {
				--par3;
			}
			if (par3 > 0) {
				par1World.setBlock(par2, par3, par4, this, 0, 3);
			}
		}
	}
	
	public static boolean canFallBelow(World par0World, int par1, int par2,
			int par3) {
		Block var4 = par0World.getBlock(par1, par2, par3);
		
		if (var4.getMaterial() == Material.air) {
			return true;
		} else if (var4 == Blocks.fire) {
			return true;
		} else {
			Material var5 = var4.getMaterial();
			return var5 == Material.water ? true : var5 == Material.lava;
		}
	}
	
	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4,
			Entity par5Entity, float par6) {
		if (!par1World.isRemote && par1World.rand.nextInt(100) == 0) {
			par1World.playSoundEffect(par2, par3, par4, "dig.wood", 5.0F, 1.2F);
			// par1World.setBlock(par2, par3, par4, FronosBlocks.coconut_milk);
		}
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_,
			int p_149650_3_) {
		return ItemList.spaceFruit;
	}
	
}