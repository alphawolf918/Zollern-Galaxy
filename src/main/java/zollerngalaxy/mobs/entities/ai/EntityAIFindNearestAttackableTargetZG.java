/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Team;

public class EntityAIFindNearestAttackableTargetZG extends EntityAIBase {
	
	private static final Logger LOGGER = LogManager.getLogger();
	private final EntityLiving entityLiving;
	private final Predicate<Entity> predicate;
	private final EntityAIFindNearestAttackableTargetZG.Sorter sorter;
	private EntityLivingBase entityTarget;
	
	public EntityAIFindNearestAttackableTargetZG(EntityLiving entityLivingIn) {
		this.entityLiving = entityLivingIn;
		
		this.predicate = new Predicate<Entity>() {
			@Override
			public boolean apply(@Nullable Entity entityIn) {
				if (!(entityIn instanceof EntityPlayer)) {
					return false;
				} else if (((EntityPlayer) entityIn).capabilities.disableDamage) {
					return false;
				} else {
					double d0 = EntityAIFindNearestAttackableTargetZG.this.maxTargetRange();
					
					if (entityIn.isSneaking()) {
						d0 *= 0.800000011920929D;
					}
					
					if (entityIn.isInvisible()) {
						float f = ((EntityPlayer) entityIn).getArmorVisibility();
						
						if (f < 0.1F) {
							f = 0.1F;
						}
						
						d0 *= 0.7F * f;
					}
					
					return entityIn.getDistance(EntityAIFindNearestAttackableTargetZG.this.entityLiving) > d0 ? false : EntityAITarget.isSuitableTarget(EntityAIFindNearestAttackableTargetZG.this.entityLiving, (EntityLivingBase) entityIn, false, true);
				}
			}
		};
		this.sorter = new EntityAIFindNearestAttackableTargetZG.Sorter(entityLivingIn);
	}
	
	@Override
	public boolean shouldExecute() {
		double d0 = this.maxTargetRange();
		List<EntityPlayer> list = this.entityLiving.world.<EntityPlayer> getEntitiesWithinAABB(EntityPlayer.class, this.entityLiving.getEntityBoundingBox().grow(d0, 4.0D, d0), this.predicate);
		Collections.sort(list, this.sorter);
		
		if (list.isEmpty()) {
			return false;
		} else {
			this.entityTarget = list.get(0);
			return true;
		}
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		EntityLivingBase entitylivingbase = this.entityLiving.getAttackTarget();
		
		if (entitylivingbase == null) {
			return false;
		} else if (!entitylivingbase.isEntityAlive()) {
			return false;
		} else if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).capabilities.disableDamage) {
			return false;
		} else {
			Team team = this.entityLiving.getTeam();
			Team team1 = entitylivingbase.getTeam();
			
			if (team != null && team1 == team) {
				return false;
			} else {
				double d0 = this.maxTargetRange();
				
				if (this.entityLiving.getDistanceSq(entitylivingbase) > d0 * d0) {
					return false;
				} else {
					return !(entitylivingbase instanceof EntityPlayerMP) || !((EntityPlayerMP) entitylivingbase).interactionManager.isCreative();
				}
			}
		}
	}
	
	@Override
	public void startExecuting() {
		this.entityLiving.setAttackTarget(this.entityTarget);
		super.startExecuting();
	}
	
	@Override
	public void resetTask() {
		this.entityLiving.setAttackTarget((EntityLivingBase) null);
		super.startExecuting();
	}
	
	protected double maxTargetRange() {
		IAttributeInstance iattributeinstance = this.entityLiving.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
		return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
	}
	
	public static class Sorter implements Comparator<Entity> {
		private final Entity entity;
		
		public Sorter(Entity entityIn) {
			this.entity = entityIn;
		}
		
		@Override
		public int compare(Entity p_compare_1_, Entity p_compare_2_) {
			double d0 = this.entity.getDistanceSq(p_compare_1_);
			double d1 = this.entity.getDistanceSq(p_compare_2_);
			
			if (d0 < d1) {
				return -1;
			} else {
				return d0 > d1 ? 1 : 0;
			}
		}
	}
}