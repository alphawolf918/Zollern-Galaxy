/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.boss;

import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.blocks.centotl.BlockFacehuggerEgg;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityXenomorph;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;

public class EntityXenomorphQueen extends EntityXenomorph {
	
	private int maxHealth = 2500;
	private int xp = 12500;
	private double attackDamage = 15.0D;
	private BlockPos entPos = this.getPosition();
	ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	private IProxy proxy = core.proxy;
	
	public EntityXenomorphQueen(World worldIn) {
		super(worldIn);
		this.setSize(0.6F * 9.0F, 1.95F * 10.5F);
		this.setCanPickUpLoot(true);
		this.entPos = this.getPosition();
		this.experienceValue = this.xp;
		this.scoreValue = this.xp;
		this.stepHeight = 4F;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_XENO_QUEEN_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_XENO_QUEEN_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_XENO_QUEEN_DEATH;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(2500.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(55.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.36257213517232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(this.attackDamage);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20.0D);
	}
	
	@Override
	public void onLivingUpdate() {
		this.entPos = this.getPosition();
		Random rand = new Random();
		int randInt = rand.nextInt(1000);
		World world = this.world;
		if (randInt <= 25) {
			this.layEgg(world, entPos);
		}
		if (this.getHealth() <= 550 && rand.nextInt(1000) <= 20) {
			double atkDmg = this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getBaseValue();
			double maxAtkDmg = (this.attackDamage * 2);
			if (atkDmg < maxAtkDmg) {
				this.attackDamage += 1.0D;
				this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(this.attackDamage);
			}
		}
		this.entPos = this.getPosition();
		super.onLivingUpdate();
	}
	
	protected void layEgg(World world, BlockPos pos) {
		IBlockState posDown = world.getBlockState(pos.down());
		IBlockState AIR = Blocks.AIR.getDefaultState();
		IBlockState blockState = world.getBlockState(pos);
		if (blockState == AIR && posDown != AIR && posDown != ZGBlocks.facehuggerEgg.getDefaultState()) {
			BlockFacehuggerEgg egg = (BlockFacehuggerEgg) ZGBlocks.facehuggerEgg;
			world.setBlockState(pos, egg.getDefaultState());
			if (ZGHelper.rngInt(0, 100) <= 25) {
				egg.hatchEgg(world, pos);
			}
		}
	}
	
	@Override
	public void onKillEntity(EntityLivingBase par1EntityLivingBase) {
		super.onKillEntity(par1EntityLivingBase);
		float health = this.maxHealth;
		if (health <= (maxHealth / 2)) {
			int randInt = rand.nextInt(150);
			this.setHealth((this.maxHealth / 2) + randInt);
		}
	}
	
	@Override
	protected float getSoundVolume() {
		return 5.0F;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 18828890;
	}
	
	@Override
	public float getBrightness() {
		return 5.0F;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	public float getEyeHeight() {
		float f = 5.74F;
		return f;
	}
	
	@Override
	public boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	public boolean getCanSpawnHere() {
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
	}
	
	@Override
	public void onDeath(DamageSource par1) {
		super.onDeath(par1);
		if (attackingPlayer != null) {
			this.proxy.sendChatMessage(attackingPlayer, ZGUtils.translate("tooltips.xenobossbeaten"));
			this.onDefeat(attackingPlayer, world, entPos, rand);
		}
	}
	
	public void onDefeat(EntityPlayer player, World world, BlockPos chestPos, Random rand) {
		ZGLootTables.generateChest(world, chestPos, rand, ZGLootTables.CHEST_XENO_BOSS);
		String txtFormat = TextFormatting.GOLD + "" + TextFormatting.BOLD;
		String primeMsg = txtFormat + ZGUtils.translate("tooltips.treasurespawned");
		int chestX = chestPos.getX();
		int chestY = chestPos.getY();
		int chestZ = chestPos.getZ();
		String chestPosStr = " (" + chestX + " " + chestY + " " + chestZ + ")";
		String fullMsg = primeMsg + chestPosStr;
		this.proxy.sendChatMessage(player, fullMsg);
	}
	
	@Override
	public boolean isNonBoss() {
		return false;
	}
	
	private final BossInfoServer bossInfo = new BossInfoServer(this.getDisplayName(), BossInfo.Color.RED, BossInfo.Overlay.PROGRESS);
	
	@Override
	public void addTrackingPlayer(EntityPlayerMP player) {
		super.addTrackingPlayer(player);
		this.bossInfo.addPlayer(player);
	}
	
	@Override
	public void removeTrackingPlayer(EntityPlayerMP player) {
		super.removeTrackingPlayer(player);
		this.bossInfo.removePlayer(player);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
	}
	
}