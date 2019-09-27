package zollerngalaxy.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import zollerngalaxy.core.enums.EnumBlockTier;
import zollerngalaxy.core.enums.EnumBlockType;

public class ZGBlockOre extends ZGBlockBase {
	
	protected EnumBlockTier oreTier = EnumBlockTier.ONE;
	
	protected boolean isExplosive = false;
	protected int explosionWeight = 40;
	protected boolean hasPotionEffect = false;
	protected Potion blockPotionEffect;
	protected Random rand = new Random();
	
	public ZGBlockOre(String blockName, float hardResist) {
		super(blockName, hardResist);
		this.setBlockType(EnumBlockType.ORE);
	}
	
	public Block setShouldGivePotionEffect(boolean shouldGivePotionEffect, Potion potionEffect) {
		this.hasPotionEffect = shouldGivePotionEffect;
		this.blockPotionEffect = potionEffect;
		return this;
	}
	
	public boolean getShouldGivePotionEffect() {
		return this.hasPotionEffect;
	}
	
	/**
	 * Sets the chance for this block to go kablooey. Higher numbers mean a
	 * lower chance.
	 * 
	 * @param par1ExplosionChance
	 *            int
	 * @return Block
	 */
	public Block setExplosionChance(int par1ExplosionChance) {
		this.explosionWeight = par1ExplosionChance;
		return this;
	}
	
	/**
	 * Gets the chance this block has to explode. Higher numbers mean a lower
	 * chance.
	 * 
	 * @return int
	 */
	public int getExplosionChance() {
		return this.explosionWeight;
	}
	
	public Block setShouldExplode(boolean shouldExplode, int explodeChance) {
		this.setShouldExplode(shouldExplode);
		this.setExplosionChance(explodeChance);
		return this;
	}
	
	public Block setShouldExplode(boolean shouldExplode) {
		isExplosive = shouldExplode;
		return this;
	}
	
	public boolean getShouldExplode() {
		return isExplosive;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode()) {
				if (rand.nextInt(this.getExplosionChance()) <= 4) {
					worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 2.5F, true);
				}
			}
		}
		if (this.getShouldGivePotionEffect()) {
			if (rand.nextInt(10) <= 5) {
				EntityPlayer player = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 2.5D, false);
				if (player != null && this.blockPotionEffect != null) {
					player.addPotionEffect(new PotionEffect(this.blockPotionEffect, 200));
				}
			}
		}
	}
	
	public EnumBlockTier getBlockTier() {
		return this.oreTier;
	}
	
	public Block setBlockTier(EnumBlockTier variantType) {
		this.oreTier = variantType;
		return this;
	}
}