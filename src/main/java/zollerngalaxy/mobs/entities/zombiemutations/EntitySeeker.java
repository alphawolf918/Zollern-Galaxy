/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.zombiemutations;

import java.util.Calendar;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import zollerngalaxy.mobs.entities.base.EntityMutantZombie;

public class EntitySeeker extends EntityMutantZombie {
	
	public EntitySeeker(World world) {
		super(world);
		this.setMutantMultiplyChance(14);
		this.setMutantName("Seeker");
		this.setMutantFireTime(0);
		this.setMutantScale(0.8F);
		this.setSize(this.width * 0.8F, this.height * 0.8F);
	}
	
	@Override
	public float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.5F;
	}
	
	@Override
	protected float getSoundVolume() {
		return 1.5F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.36611110417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}
	
	@Override
	protected boolean shouldBurnInDay() {
		return false;
	}
	
	@Override
	public void onKillEntity(EntityLivingBase entityLivingIn) {
		super.onKillEntity(entityLivingIn);
		
		if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && entityLivingIn instanceof EntityVillager) {
			if (this.world.getDifficulty() != EnumDifficulty.HARD && this.rand.nextBoolean()) {
				return;
			}
			
			EntityVillager entityvillager = (EntityVillager) entityLivingIn;
			EntitySeeker entityzombievillager = new EntitySeeker(this.world);
			entityzombievillager.copyLocationAndAnglesFrom(entityvillager);
			this.world.removeEntity(entityvillager);
			entityzombievillager.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entityzombievillager)), new EntitySeeker.GroupData(false));
			entityzombievillager.setChild(entityvillager.isChild());
			entityzombievillager.setNoAI(entityvillager.isAIDisabled());
			
			if (entityvillager.hasCustomName()) {
				entityzombievillager.setCustomNameTag(entityvillager.getCustomNameTag());
				entityzombievillager.setAlwaysRenderNameTag(entityvillager.getAlwaysRenderNameTag());
			}
			
			this.world.spawnEntity(entityzombievillager);
			this.world.playEvent((EntityPlayer) null, 1026, new BlockPos(this), 0);
		}
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		
		if (livingdata == null) {
			livingdata = new EntitySeeker.GroupData(this.world.rand.nextFloat() < ForgeModContainer.zombieBabyChance);
		}
		
		if (livingdata instanceof EntitySeeker.GroupData) {
			EntitySeeker.GroupData entityzombie$groupdata = (EntitySeeker.GroupData) livingdata;
			
			if (entityzombie$groupdata.isChild) {
				this.setChild(true);
			}
		}
		
		this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
		this.setEquipmentBasedOnDifficulty(difficulty);
		this.setEnchantmentBasedOnDifficulty(difficulty);
		
		if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty()) {
			Calendar calendar = this.world.getCurrentDate();
			
			if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31 && this.rand.nextFloat() < 0.25F) {
				this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
				this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
			}
		}
		
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE)
				.applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
		double d0 = this.rand.nextDouble() * 1.5D * f;
		
		if (d0 > 1.0D) {
			this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
		}
		
		if (this.rand.nextFloat() < f * 0.05F) {
			this.getEntityAttribute(SPAWN_REINFORCEMENTS_CHANCE).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 0.25D + 0.5D, 0));
			this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH)
					.applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
			this.setBreakDoorsAItask(true);
		}
		
		return livingdata;
	}
	
	class GroupData implements IEntityLivingData {
		public boolean isChild;
		
		private GroupData(boolean p_i47328_2_) {
			this.isChild = p_i47328_2_;
		}
	}
}