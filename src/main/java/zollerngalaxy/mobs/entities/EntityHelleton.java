/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;

public class EntityHelleton extends EntityWitherSkeleton implements IEntityBreathable {
	
	public EntityHelleton(World worldIn) {
		super(worldIn);
		this.setSize(0.7F * 1.4F, 2.4F * 1.4F);
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ZGItems.swordZollernium));
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		IEntityLivingData ientitylivingdata = super.onInitialSpawn(difficulty, livingdata);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
		this.setCombatTask();
		return ientitylivingdata;
	}
	
	@Override
	public float getEyeHeight() {
		return 3.33F;
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entityIn) {
		if (!super.attackEntityAsMob(entityIn)) {
			return false;
		} else {
			if (entityIn instanceof EntityLivingBase && ZGHelper.getRNG().nextInt(3) == 0) {
				((EntityLivingBase) entityIn).setFire(5);
			}
			
			return true;
		}
	}
	
	@Override
	public void onLivingUpdate() {
		if (this.isInWater()) {
			this.attackEntityFrom(DamageSource.DROWN, 10.0F);
		}
		super.onLivingUpdate();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return 15728890;
	}
	
	@Override
	public float getBrightness() {
		return 6.0F;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}