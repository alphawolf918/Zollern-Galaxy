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

package galaxymod.mobs.entities.kriffon;

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
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMagmos extends EntityMob implements IEntityBreathable {
	
	private int field_70846_g;
	
	public EntityMagmos(World par1World) {
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
		this.isImmuneToFire = true;
		this.experienceValue = 50;
	}
	
	@Override
	protected String getLivingSound() {
		return "mob.blaze.breathe";
	}
	
	@Override
	protected String getHurtSound() {
		return "mob.blaze.hit";
	}
	
	@Override
	protected String getDeathSound() {
		return "mob.blaze.death";
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender(float par1) {
		return 16828890;
	}
	
	@Override
	public float getBrightness(float par1) {
		return 5.0F;
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
			if (this.isWet()) {
				this.attackEntityFrom(DamageSource.drown, 2.0F);
			}
			BiomeGenBase currentBiome = this.worldObj.getBiomeGenForCoords(
					this.chunkCoordX, chunkCoordZ);
			if (currentBiome.temperature <= 7F) {
				this.attackEntityFrom(ZGDamageSource.deathTempCold, 2.0F);
			}
			if (this.rand.nextInt(24) == 0) {
				this.worldObj.playSoundEffect(this.posX + 0.5D,
						this.posY + 0.5D, this.posZ + 0.5D, "fire.fire",
						1.0F + this.rand.nextFloat(),
						this.rand.nextFloat() * 0.7F + 0.3F);
			}
			for (int i = 0; i < 2; ++i) {
				this.worldObj.spawnParticle("largesmoke", this.posX
						+ (this.rand.nextDouble() - 0.5D) * this.width,
						this.posY + this.rand.nextDouble() * this.height,
						this.posZ + (this.rand.nextDouble() - 0.5D)
								* this.width, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	@Override
	protected boolean isValidLightLevel() {
		return true;
	}
	
	@Override
	protected void attackEntity(Entity p_70785_1_, float p_70785_2_) {
		if (this.attackTime <= 0 && p_70785_2_ < 2.0F
				&& p_70785_1_.boundingBox.maxY > this.boundingBox.minY
				&& p_70785_1_.boundingBox.minY < this.boundingBox.maxY) {
			this.attackTime = 20;
			this.attackEntityAsMob(p_70785_1_);
		} else if (p_70785_2_ < 30.0F) {
			double d0 = p_70785_1_.posX - this.posX;
			double d1 = p_70785_1_.boundingBox.minY + p_70785_1_.height / 2.0F
					- (this.posY + this.height / 2.0F);
			double d2 = p_70785_1_.posZ - this.posZ;
			
			if (this.attackTime == 0) {
				++this.field_70846_g;
				
				if (this.field_70846_g == 1) {
					this.attackTime = 60;
				} else if (this.field_70846_g <= 4) {
					this.attackTime = 6;
				} else {
					this.attackTime = 100;
					this.field_70846_g = 0;
				}
				
				if (this.field_70846_g > 1) {
					float f1 = MathHelper.sqrt_float(p_70785_2_) * 0.5F;
					this.worldObj.playAuxSFXAtEntity((EntityPlayer) null, 1009,
							(int) this.posX, (int) this.posY, (int) this.posZ,
							0);
					
					for (int i = 0; i < 1; ++i) {
						EntityLargeFireball entitysmallfireball = new EntityLargeFireball(
								this.worldObj, this, d0
										+ this.rand.nextGaussian() * f1, d1, d2
										+ this.rand.nextGaussian() * f1);
						entitysmallfireball.posY = this.posY + this.height
								/ 2.0F + 0.5D;
						this.worldObj.spawnEntityInWorld(entitysmallfireball);
					}
				}
			}
			
			this.rotationYaw = (float) (Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
			this.hasAttacked = true;
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
	protected boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(65.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange)
				.setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.15D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(11.0D);
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
	
}