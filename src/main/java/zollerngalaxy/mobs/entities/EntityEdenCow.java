/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import zollerngalaxy.blocks.fluids.ZGFluids;
import zollerngalaxy.core.ZGLootTables;
import zollerngalaxy.items.ZGItems;

public class EntityEdenCow extends EntityCow implements IEntityBreathable {
	
	public EntityEdenCow(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.7F, this.height * 1.7F);
	}
	
	public static void registerFixesCow(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityEdenCow.class);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, ZGItems.strawberry, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2000000298023224D);
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		if (itemstack.getItem() == Items.BUCKET && !this.isChild()) {
			ItemStack filledBucket = FluidUtil.getFilledBucket(new FluidStack(FluidRegistry.getFluid(ZGFluids.fluidSpaceMilk.getName()), Fluid.BUCKET_VOLUME));
			player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
			
			if (!player.capabilities.isCreativeMode) {
				itemstack.shrink(1);
			}
			
			if (itemstack.isEmpty()) {
				
				player.setHeldItem(hand, filledBucket);
			} else if (!player.inventory.addItemStackToInventory(filledBucket)) {
				player.dropItem(filledBucket, false);
			}
			
			return true;
		} else {
			return super.processInteract(player, hand);
		}
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_COW_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_COW_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_COW_DEATH;
	}
	
	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}
	
	@Override
	protected float getSoundVolume() {
		return 0.4F;
	}
	
	@Override
	protected float getSoundPitch() {
		return 0.5F;
	}
	
	@Override
	@Nullable
	protected ResourceLocation getLootTable() {
		return ZGLootTables.ENTITY_MOOLUS;
	}
	
	@Override
	public EntityEdenCow createChild(EntityAgeable ageable) {
		return new EntityEdenCow(this.world);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
}