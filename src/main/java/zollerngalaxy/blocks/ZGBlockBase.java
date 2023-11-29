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
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.caligro.corrupted.ICorruptBlock;
import zollerngalaxy.blocks.infected.IInfectedBlock;
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
	protected boolean enableExtremeMode = ConfigManagerZG.enableExtremeMode;
	protected boolean enableExplosiveOres = ConfigManagerZG.enableExplosiveOres;
	protected boolean enablePotionEffectOres = ConfigManagerZG.enablePotionEffectOres;
	protected boolean chainReactionEnabled = ConfigManagerZG.shouldExplosiveBlocksExplodeOtherBlocks;
	protected boolean isExplosive = false;
	protected int explosionWeight = (this.enableExtremeMode) ? 20 : 40;
	protected boolean hasPotionEffect = false;
	protected Potion blockPotionEffect;
	protected boolean shouldAlwaysBurn = false;
	protected boolean isHotFloorBlock = false;
	protected boolean hasInfo = false;
	protected boolean shouldJSONIgnore = false;
	protected boolean isSolidColor = true;
	protected boolean hasParticles = false;
	protected boolean isFireproof = false;
	protected EnumParticleTypes particleType = EnumParticleTypes.SMOKE_NORMAL;
	protected EnumParticleTypes particleType2 = EnumParticleTypes.REDSTONE;
	protected String[] blockInfo;
	protected static String name;
	protected int harvestLvl = EnumHarvestLevelZG.DIAMOND.getHarvestLevel();
	protected Random rand = new Random();
	
	public ZGBlockBase(String blockName, float hardResist) {
		super(Material.ROCK);
		hardResist *= (this.enableExtremeMode) ? 2 : 1;
		this.name = blockName;
		this.setBlockName(this, blockName);
		this.setHardResist(hardResist);
		this.setSoundType(blockSound);
		this.setBlockType(blockType);
		this.setTickRandomly(true);
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
		// Heat Damage
		boolean isLivingBase = (entityIn instanceof EntityLivingBase);
		boolean immuneToFire = entityIn.isImmuneToFire();
		boolean hasFrostWalkerEnchantment = isLivingBase ? EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn) : false;
		boolean isHotBlock = this.getIsHotBlock();
		
		if (!immuneToFire && isLivingBase && !hasFrostWalkerEnchantment && isHotBlock) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, (this.enableExtremeMode) ? 8.2F : 4.5F);
		}
		
		if (entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entityIn;
			if (!(player.capabilities.isCreativeMode)) {
				// Corruption Damage
				if (this instanceof ICorruptBlock) {
					ICorruptBlock corruptBlock = (ICorruptBlock) this;
					if (corruptBlock.canCorrupt()) {
						ZGDamageSrc corruption = ZGDamageSrc.deathCorruption;
						if (!player.isPotionActive(ZGPotions.antiCorruption)) {
							Item blueprintItem = ZGItems.blueprintCorruption;
							ZGHelper.performBlueprintCheck(rand, blueprintItem, player, corruption);
						}
						
					}
					// Infected Damage
				} else if (this instanceof IInfectedBlock) {
					IInfectedBlock infectedBlock = (IInfectedBlock) this;
					if (infectedBlock.canInfect()) {
						int timerIncrease = ((this.enableExtremeMode) ? 300 : 0);
						int infectionTimer = (ZGPotions.infectionTime + timerIncrease);
						Potion potionInfected = ZGPotions.infected;
						PotionEffect infectedEffect = new PotionEffect(potionInfected, infectionTimer, 1);
						if (!player.isPotionActive(potionInfected)) {
							player.addPotionEffect(infectedEffect);
						}
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
		if (this.enableExplosiveOres) {
			this.explosionWeight = par1ExplosionChance;
		}
		
		return this;
	}
	
	/**
	 * Gets the chance this block has to explode. Higher numbers mean a lower
	 * chance.
	 * 
	 * @return int
	 */
	public int getExplosionChance() {
		if (this.enableExplosiveOres) {
			int scaleBy = (this.enableExtremeMode) ? 10 : 0;
			int expWeight = (this.explosionWeight - scaleBy);
			expWeight = (expWeight < 0) ? 1 : expWeight;
			return expWeight;
		} else {
			return 0;
		}
	}
	
	public Block setShouldExplode(boolean shouldExplode, int explodeChance) {
		if (this.enableExplosiveOres) {
			this.setShouldExplode(shouldExplode);
			this.setExplosionChance(explodeChance);
		}
		return this;
	}
	
	public Block setShouldExplode(boolean shouldExplode) {
		this.isExplosive = (shouldExplode && this.enableExplosiveOres);
		return this;
	}
	
	public boolean getShouldExplode() {
		return (this.isExplosive && this.enableExplosiveOres);
	}
	
	public Block setShouldGivePotionEffect(boolean shouldGivePotionEffect, Potion potionEffect) {
		if (this.enablePotionEffectOres) {
			this.hasPotionEffect = shouldGivePotionEffect;
			this.blockPotionEffect = potionEffect;
		}
		return this;
	}
	
	public boolean getShouldGivePotionEffect() {
		return (this.hasPotionEffect && this.enablePotionEffectOres);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode()) {
				if (rand.nextInt(100) <= this.getExplosionChance() && this.enableExplosiveOres) {
					float explosionStrength = (this.enableExtremeMode) ? 6.0F : 2.5F;
					worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), explosionStrength, true);
				}
			}
			
			if (this.getShouldGivePotionEffect() && this.enablePotionEffectOres) {
				boolean determineCondition = (this.enableExtremeMode) ? (rand.nextInt(5) <= 2) : (rand.nextInt(10) <= 5);
				if (determineCondition) {
					EntityPlayer player = worldIn.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 2.5D, false);
					if (player != null && this.blockPotionEffect != null) {
						int duration = (this.enableExtremeMode) ? 400 : 200;
						player.addPotionEffect(new PotionEffect(this.blockPotionEffect, duration));
					}
				}
			}
		}
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
		if (!worldIn.isRemote) {
			if (this.getShouldExplode() && this.chainReactionEnabled && this.enableExplosiveOres) {
				int chainReactionChance = (this.enableExtremeMode) ? 4 : 8;
				if (rand.nextInt(this.getExplosionChance()) <= 8) {
					float explosionStrength = (this.enableExtremeMode) ? 8.4F : 3.2F;
					worldIn.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), explosionStrength, true);
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
		this.blockMaterial = material;
		return this;
	}
	
	public Block setTransparent() {
		this.setIsOpaque(false);
		return this;
	}
	
	public Block setIsOpaque(boolean isSolidColorIn) {
		this.isSolidColor = isSolidColorIn;
		return this;
	}
	
	@Override
	public Material getMaterial(IBlockState block) {
		return this.blockMaterial;
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
	
	public Block setSlipperiness(float slipRate) {
		this.slipperiness = slipRate;
		return this;
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
	
	public Block setHasParticles(boolean hasParticlesIn) {
		this.hasParticles = hasParticlesIn;
		return this;
	}
	
	public Block setHasParticles(boolean hasParticlesIn, EnumParticleTypes particleTypeIn) {
		this.setHasParticles(hasParticlesIn);
		this.particleType = particleTypeIn;
		return this;
	}
	
	public boolean getHasParticles() {
		return this.hasParticles;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		if (this.getHasParticles()) {
			this.spawnParticles(worldIn, pos);
		}
	}
	
	@Override
	public int tickRate(World worldIn) {
		return 30;
	}
	
	private void spawnParticles(World worldIn, BlockPos pos) {
		if (this.getHasParticles()) {
			Random random = worldIn.rand;
			double d0 = 0.0625D;
			
			for (int i = 0; i < 6; ++i) {
				double d1 = pos.getX() + random.nextFloat();
				double d2 = pos.getY() + random.nextFloat();
				double d3 = pos.getZ() + random.nextFloat();
				
				if (i == 0 && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
					d2 = pos.getY() + 0.0625D + 1.0D;
				}
				
				if (i == 1 && !worldIn.getBlockState(pos.down()).isOpaqueCube()) {
					d2 = pos.getY() - 0.0625D;
				}
				
				if (i == 2 && !worldIn.getBlockState(pos.south()).isOpaqueCube()) {
					d3 = pos.getZ() + 0.0625D + 1.0D;
				}
				
				if (i == 3 && !worldIn.getBlockState(pos.north()).isOpaqueCube()) {
					d3 = pos.getZ() - 0.0625D;
				}
				
				if (i == 4 && !worldIn.getBlockState(pos.east()).isOpaqueCube()) {
					d1 = pos.getX() + 0.0625D + 1.0D;
				}
				
				if (i == 5 && !worldIn.getBlockState(pos.west()).isOpaqueCube()) {
					d1 = pos.getX() - 0.0625D;
				}
				
				if (d1 < pos.getX() || d1 > pos.getX() + 1 || d2 < 0.0D || d2 > pos.getY() + 1 || d3 < pos.getZ() || d3 > pos.getZ() + 1) {
					worldIn.spawnParticle(this.particleType2, d1, d2, d3, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}