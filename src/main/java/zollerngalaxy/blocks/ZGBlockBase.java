/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.Random;
import micdoodle8.mods.galacticraft.api.block.ITerraformableBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.caligro.corrupted.ICorruptBlock;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.core.enums.EnumHarvestLevelZG;
import zollerngalaxy.core.enums.EnumHarvestToolZG;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.lib.helpers.json.JSONFactory;
import zollerngalaxy.potions.ZGPotions;
import zollerngalaxy.util.ZGDamageSrc;

public class ZGBlockBase extends Block implements ISingleZGBlockRender, IJSONBlock, ITerraformableBlock {
	
	protected static Material blockMaterial = Material.ROCK;
	protected static SoundType blockSound = SoundType.STONE;
	protected EnumBlockType blockType = EnumBlockType.NORMAL;
	
	protected boolean isExplosive = false;
	protected int explosionWeight = 40;
	
	protected boolean hasPotionEffect = false;
	protected Potion blockPotionEffect;
	
	protected boolean shouldAlwaysBurn = false;
	protected boolean isHotFloorBlock = false;
	
	protected boolean hasInfo = false;
	
	protected boolean shouldJSONIgnore = false;
	
	protected boolean chainReactionEnabled = ConfigManagerZG.shouldExplosiveBlocksExplodeOtherBlocks;
	
	protected String[] blockInfo;
	protected static String name;
	
	protected int harvestLvl = EnumHarvestLevelZG.DIAMOND.getHarvestLevel();
	
	protected Random rand = new Random();
	
	public ZGBlockBase(String blockName, float hardResist) {
		super(Material.ROCK);
		this.name = blockName;
		this.setBlockName(this, blockName);
		this.setHardResist(hardResist);
		this.setSoundType(blockSound);
		this.setBlockType(blockType);
		this.translucent = false;
		
		if (!this.shouldJSONIgnore()) {
			JSONFactory.registerBlock(blockName);
		}
	}
	
	public ZGBlockBase(String blockName) {
		this(blockName, 2.6F);
	}
	
	public void setBlockName(Block block, final String blockName) {
		block.setUnlocalizedName(blockName);
	}
	
	public Block setSound(SoundType bSound) {
		this.blockSoundType = bSound;
		return this;
	}
	
	public SoundType getSound() {
		return this.blockSound;
	}
	
	public boolean hasInfo() {
		return this.hasInfo;
	}
	
	public String[] getInfo() {
		return this.blockInfo;
	}
	
	public Block setInfo(String... info) {
		this.blockInfo = info;
		return this;
	}
	
	public Block setHardResist(float hard, float resist) {
		this.setHardness(hard);
		this.setResistance(resist);
		return this;
	}
	
	public Block setHardResist(float hardResist) {
		this.setHardness(hardResist);
		this.setResistance(hardResist);
		return this;
	}
	
	public Block setIsHotBlock(boolean par1HotBlock) {
		this.isHotFloorBlock = par1HotBlock;
		return this;
	}
	
	public boolean getIsHotBlock() {
		return this.isHotFloorBlock;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
				&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn) && this.getIsHotBlock()) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 4.5F);
		}
		
		// Corruption Damage
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if (!(player.capabilities.isCreativeMode) && (this instanceof ICorruptBlock)) {
				ICorruptBlock corruptBlock = (ICorruptBlock) this;
				if (corruptBlock.canCorrupt()) {
					ZGDamageSrc corruption = ZGDamageSrc.deathCorruption;
					if (!player.isPotionActive(ZGPotions.antiCorruption)) {
						Item blueprintItem = ZGItems.blueprintCorruption;
						ZGHelper.performBlueprintCheck(rand, blueprintItem, player, corruption);
					}
				}
			}
		}
		
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	
	@Override
	public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
		if (this.getShouldAlwaysBurn() && side == EnumFacing.UP) {
			return true;
		}
		return false;
	}
	
	public Block setShouldAlwaysBurn(boolean shouldBurn) {
		this.shouldAlwaysBurn = shouldBurn;
		return this;
	}
	
	public boolean getShouldAlwaysBurn() {
		return this.shouldAlwaysBurn;
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
	
	public Block setShouldGivePotionEffect(boolean shouldGivePotionEffect, Potion potionEffect) {
		this.hasPotionEffect = shouldGivePotionEffect;
		this.blockPotionEffect = potionEffect;
		return this;
	}
	
	public boolean getShouldGivePotionEffect() {
		return this.hasPotionEffect;
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode()) {
				if (rand.nextInt(100) <= this.getExplosionChance()) {
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
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode() && this.chainReactionEnabled) {
				if (rand.nextInt(this.getExplosionChance()) <= 8) {
					worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 3.2F, true);
				}
			}
		}
	}
	
	public Block setBlockHarvestLevel(String toolClass, int level) {
		this.harvestLvl = level;
		this.setHarvestLevel(toolClass, level, this.getDefaultState());
		return this;
	}
	
	public Block setMaterial(Material material) {
		blockMaterial = material;
		return this;
	}
	
	@Override
	public Material getMaterial(IBlockState block) {
		return blockMaterial;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public CreativeTabs getCreativeTabToDisplayOn() {
		return ZGTabs.zgBlocksTab;
	}
	
	@Override
	public String getName() {
		return this.name.toLowerCase();
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return false;
	}
	
	/**
	 * Prevent the JSON generator from overwriting this block's files.
	 * 
	 * @param ignore
	 *            Whether or not this block should be ignored by the JSON generator.
	 * @return Block
	 */
	public Block setShouldJSONIgnore(boolean ignore) {
		this.shouldJSONIgnore = ignore;
		return this;
	}
	
	public Block setBlockType(EnumBlockType bType) {
		this.blockType = bType;
		return this;
	}
	
	public EnumBlockType getBlockType() {
		return this.blockType;
	}
	
	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return true;
	}
	
	@Override
	public boolean isCollidable() {
		return true;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return true;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return FULL_BLOCK_AABB;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return this.harvestLvl;
	}
	
	@Override
	public String getHarvestTool(IBlockState state) {
		return EnumHarvestToolZG.PICKAXE.getHarvestTool();
	}
	
	@Override
	public boolean isTerraformable(World world, BlockPos pos) {
		return true;
	}
}