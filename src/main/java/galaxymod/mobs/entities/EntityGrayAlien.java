/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic
 * Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * 	- Learn from it
 *  - Use it to get ideas and concepts
 * You CAN'T:
 *  - Redistribute it
 *  - Claim it as your own
 ******************************************************************************/

package galaxymod.mobs.entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGrayAlien extends EntityCreature {

	public EntityGrayAlien(World p_i1595_1_) {
		super(p_i1595_1_);
		this.setHealth(20F);
		this.setAIMoveSpeed(0.7F);
		this.setSize(0.5F, 0.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this,
				EntityPlayer.class, 3.0F, 1.0F));
		this.tasks.addTask(9, new EntityAIWatchClosest2(this,
				EntityGrayAlien.class, 5.0F, 0.02F));
		this.tasks.addTask(9, new EntityAIWander(this, 0.6D));
		this.tasks.addTask(10, new EntityAIWatchClosest(this,
				EntityLiving.class, 8.0F));
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setEnterDoors(true);
		this.scoreValue = 70;
		this.experienceValue = 80;
		this.stepHeight = 1F;
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
	protected void updateFallState(double par1, boolean par3) {
	}

	@Override
	protected void fall(float par1) {
	}

	@Override
	public boolean canBePushed() {
		return false;
	}

	@Override
	public boolean canPickUpLoot() {
		return true;
	}

	@Override
	protected String getLivingSound() {
		return "galaxymod:mob.alien.say";
	}

	@Override
	protected String getHurtSound() {
		return "galaxymod:mob.alien.hurt";
	}

	@Override
	protected float getSoundVolume() {
		return 0.2F;
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEFINED;
	}

	public int getAttackStrength(Entity par1Entity) {
		return 10;
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(
			IEntityLivingData par1EntityLivingData) {
		super.onSpawnWithEgg(par1EntityLivingData);
		this.addRandomArmor();
		this.enchantEquipment();
		return par1EntityLivingData;
	}
}