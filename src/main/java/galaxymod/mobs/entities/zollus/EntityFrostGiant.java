/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.mobs.entities.zollus;

import galaxymod.utils.ZGDamageSource;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityFrostGiant extends EntityMob implements IEntityBreathable {
	
	public EntityFrostGiant(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIBreakDoor(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this,
				EntityPlayer.class, 2.0D, false));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this,
				EntityAlienVillager.class, 2.0D, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float par1) {
		return 15728890;
	}
	
	@Override
	public float getBrightness(float par1) {
		return 4.0F;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	public int getAttackStrength(Entity par1Entity) {
		return 10;
	}
	
	@Override
	protected void updateFallState(double par1, boolean par3) {
	}
	
	@Override
	protected void fall(float par1) {
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (!this.worldObj.isRemote) {
			BiomeGenBase currentBiome = this.worldObj.getBiomeGenForCoords(
					this.chunkCoordX, chunkCoordZ);
			if (currentBiome.temperature >= 4F) {
				this.attackEntityFrom(ZGDamageSource.deathTempHot, 2.0F);
			}
		}
	}
	
	@Override
	public int getTotalArmorValue() {
		int i = super.getTotalArmorValue() + 4;
		
		if (i > 20) {
			i = 20;
		}
		
		return i;
	}
	
	@Override
	protected String getHurtSound() {
		return "mob.blaze.hit";
	}
	
	@Override
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(60.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(10.0D);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
}