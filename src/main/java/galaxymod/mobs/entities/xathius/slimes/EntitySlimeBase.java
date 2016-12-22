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

package galaxymod.mobs.entities.xathius.slimes;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntitySlimeBase extends EntitySlime {
	
	private byte slimeHungerLevel = 10;
	private byte slimeAggressiveLevel = 0;
	private String slimeName;
	private SlimeType slimeType = SlimeType.BASE;
	
	public EntitySlimeBase(World world, SlimeType slimeType) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAIWatchClosest2(this,
				EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(30, Byte.valueOf((byte) 5));
		this.dataWatcher.addObject(29, Byte.valueOf((byte) 0));
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		super.writeEntityToNBT(p_70014_1_);
		p_70014_1_.setInteger("Hunger", this.getHungerLevel());
		p_70014_1_.setInteger("Aggression", this.getHungerLevel());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		super.readEntityFromNBT(p_70037_1_);
		int i = p_70037_1_.getInteger("Hunger");
		int i2 = p_70037_1_.getInteger("Aggression");
		this.setSlimeHungerLevel(i);
	}
	
	@Override
	public void onUpdate() {
		this.squishFactor += (this.squishAmount - this.squishFactor) * 0.5F;
		this.prevSquishFactor = this.squishFactor;
		boolean flag = this.onGround;
		super.onUpdate();
		int i;
		
		if (this.onGround && !flag) {
			i = this.getSlimeSize();
			
			for (int j = 0; j < i * 8; ++j) {
				float f = this.rand.nextFloat() * (float) Math.PI * 2.0F;
				float f1 = this.rand.nextFloat() * 0.5F + 0.5F;
				float f2 = MathHelper.sin(f) * i * 0.5F * f1;
				float f3 = MathHelper.cos(f) * i * 0.5F * f1;
				this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX
						+ f2, this.boundingBox.minY, this.posZ + f3, 0.0D,
						0.0D, 0.0D);
			}
			
			if (this.makesSoundOnLand()) {
				this.playSound(
						this.getJumpSound(),
						this.getSoundVolume(),
						((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}
			
			this.squishAmount = -0.5F;
		} else if (!this.onGround && flag) {
			this.squishAmount = 1.0F;
		}
		
		this.alterSquishAmount();
		
		if (this.worldObj.isRemote) {
			i = this.getSlimeSize();
			this.setSize(0.6F * i, 0.6F * i);
		}
	}
	
	@Override
	protected boolean canDamagePlayer() {
		return false;
	}
	
	public void setSlimeName(String slimeName) {
		this.slimeName = slimeName;
		this.setCustomNameTag(slimeName);
	}
	
	public String getSlimeName() {
		return this.slimeName;
	}
	
	public void setSlimeHungerLevel(int hungerLevel) {
		this.dataWatcher.updateObject(30, hungerLevel);
	}
	
	public byte getHungerLevel() {
		return this.dataWatcher.getWatchableObjectByte(30);
	}
	
	public void setSlimeAggressionLevel(int aggressionLevel) {
		this.dataWatcher.updateObject(29, aggressionLevel);
	}
	
	public byte getSlimeAggressionLevel() {
		return this.dataWatcher.getWatchableObjectByte(29);
	}
	
	public void setSlimeType(SlimeType slimeType) {
		this.slimeType = slimeType;
	}
	
	public SlimeType getSlimeType() {
		return this.slimeType;
	}
	
	public enum SlimeType {
		BASE, RASPBERRY, EXPLOSIVE, CANDY, FLAMING, ROCKY, ANIMAL;
	}
	
}