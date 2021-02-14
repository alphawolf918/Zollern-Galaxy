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
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;
import zollerngalaxy.events.ZGSoundEvents;
import zollerngalaxy.mobs.entities.base.EntityMutantZombie;

public class EntityVolatile extends EntityMutantZombie {
	
	public EntityVolatile(World worldIn) {
		super(worldIn);
		this.setMutantMultiplyChance(6);
		this.setMutantName("Volatile");
		this.setMutantFireTime(20);
		this.setMutantScale(1.2F);
		this.applyEntityAI();
	}
	
	@Override
	public float getEyeHeight() {
		float f = 1.0F;
		
		if (this.isChild()) {
			f = (float) (f - 0.81D);
		}
		
		return f;
	}
	
	@Override
	public double getYOffset() {
		return this.isChild() ? 0.0D : -0.35D;
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return ZGSoundEvents.ENTITY_VOLATILE_SAY;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return ZGSoundEvents.ENTITY_VOLATILE_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return ZGSoundEvents.ENTITY_VOLATILE_DEATH;
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		
		if (livingdata == null) {
			livingdata = new EntityVolatile.GroupData(this.world.rand.nextFloat() < ForgeModContainer.zombieBabyChance);
		}
		
		if (livingdata instanceof EntityVolatile.GroupData) {
			EntityVolatile.GroupData entityzombie$groupdata = (EntityVolatile.GroupData) livingdata;
			
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