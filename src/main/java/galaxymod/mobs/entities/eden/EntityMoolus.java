/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.mobs.entities.eden;

import galaxymod.biomes.BiomeList;
import galaxymod.items.ItemList;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityMoolus extends EntityCow implements IEntityBreathable {
	
	public EntityMoolus(World p_i1683_1_) {
		super(p_i1683_1_);
		this.setSize(this.width, this.height);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3,
				new EntityAITempt(this, 1.25D, Items.wheat, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this,
				EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 2;
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(15.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.30000000298023224D);
	}
	
	@Override
	protected String getLivingSound() {
		return "mob.cow.say";
	}
	
	@Override
	protected String getHurtSound() {
		return "mob.cow.hurt";
	}
	
	@Override
	protected String getDeathSound() {
		return "mob.cow.hurt";
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.cow.step", 0.15F, 1.0F);
	}
	
	@Override
	protected float getSoundVolume() {
		return 0.8F;
	}
	
	@Override
	protected Item getDropItem() {
		return Items.leather;
	}
	
	@Override
	protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
		int j = this.rand.nextInt(3) + this.rand.nextInt(1 + p_70628_2_);
		int k;
		
		for (k = 0; k < j; ++k) {
			this.dropItem(Items.leather, 1);
		}
		
		j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_);
		
		for (k = 0; k < j; ++k) {
			if (this.isBurning()) {
				this.dropItem(ItemList.alienBeefCooked, 1);
			} else {
				this.dropItem(ItemList.alienBeefRaw, 1);
			}
		}
	}
	
	@Override
	public boolean interact(EntityPlayer p_70085_1_) {
		return false;
	}
	
	@Override
	public EntityMoolus createChild(EntityAgeable p_90011_1_) {
		return new EntityMoolus(this.worldObj);
	}
	
	@Override
	public boolean getCanSpawnHere() {
		BiomeGenBase currentBiome = worldObj.getBiomeGenForCoords(chunkCoordX,
				chunkCoordZ);
		return (currentBiome.equals(BiomeList.biomeEden) || currentBiome
				.equals(BiomeList.biomeEdenTerranValley));
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}