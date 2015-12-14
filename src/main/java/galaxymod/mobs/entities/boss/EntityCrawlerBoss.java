/*******************************************************************************
 * Copyright 2015 Zollern Wolf - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod You CAN: - Learn from it - Use it to get ideas and
 * concepts You CAN'T: - Redistribute it - Claim it as your own
 ******************************************************************************/

package galaxymod.mobs.entities.boss;

import galaxymod.items.ItemList;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import micdoodle8.mods.galacticraft.core.entities.IBoss;
import micdoodle8.mods.galacticraft.core.tile.TileEntityDungeonSpawner;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityCrawlerBoss extends EntitySpider implements IBoss,
		IBossDisplayData {
	
	private TileEntityDungeonSpawner spawner;
	
	public Entity thrownEntity;
	public Entity targetEntity;
	public int deathTicks = 0;
	
	private Vector3 roomCoords;
	private Vector3 roomSize;
	
	public EntityCrawlerBoss(World par1World) {
		super(par1World);
		this.setSize(1.5F, 4.0F);
		this.isImmuneToFire = true;
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this,
				EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this,
				EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_,
			int p_145780_3_, Block p_145780_4_) {
		this.playSound("mob.spider.step", 0.30F, 0.5F);
	}
	
	public EntityCrawlerBoss(World world, Vector3 vec) {
		this(world);
		this.setPosition(vec.x, vec.y, vec.z);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(210.0F * ConfigManagerCore.dungeonBossHealthMod);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.25F);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
				.setBaseValue(5.25F);
	}
	
	@Override
	public void setRoom(Vector3 roomCoords, Vector3 roomSize) {
		this.roomCoords = roomCoords;
		this.roomSize = roomSize;
	}
	
	@Override
	public void onBossSpawned(TileEntityDungeonSpawner spawner) {
		this.spawner = spawner;
	}
	
	@Override
	public void knockBack(Entity par1Entity, float par2, double par3,
			double par5) {
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}
	
	@Override
	public void setDead() {
		if (this.spawner != null) {
			this.spawner.isBossDefeated = false;
			this.spawner.boss = null;
			this.spawner.spawned = false;
		}
		super.setDead();
	}
	
	public float getExperienceToSpawn() {
		return 60.0F;
	}
	
	public double getDistanceToSpawn() {
		return 40.0D;
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		super.writeEntityToNBT(nbt);
		
		if (this.roomCoords != null) {
			nbt.setDouble("roomCoordsX", this.roomCoords.x);
			nbt.setDouble("roomCoordsY", this.roomCoords.y);
			nbt.setDouble("roomCoordsZ", this.roomCoords.z);
			nbt.setDouble("roomSizeX", this.roomSize.x);
			nbt.setDouble("roomSizeY", this.roomSize.y);
			nbt.setDouble("roomSizeZ", this.roomSize.z);
		}
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		super.readEntityFromNBT(nbt);
		this.roomCoords = new Vector3();
		this.roomCoords.x = nbt.getDouble("roomCoordsX");
		this.roomCoords.y = nbt.getDouble("roomCoordsY");
		this.roomCoords.z = nbt.getDouble("roomCoordsZ");
		this.roomSize = new Vector3();
		this.roomSize.x = nbt.getDouble("roomSizeX");
		this.roomSize.y = nbt.getDouble("roomSizeY");
		this.roomSize.z = nbt.getDouble("roomSizeZ");
	}
	
	@Override
	public EntityItem entityDropItem(ItemStack par1ItemStack, float par2) {
		final EntityItem entityitem = new EntityItem(this.worldObj, this.posX,
				this.posY + par2, this.posZ, par1ItemStack);
		entityitem.motionY = -2.0D;
		entityitem.delayBeforeCanPickup = 10;
		if (this.captureDrops) {
			this.capturedDrops.add(entityitem);
		} else {
			this.worldObj.spawnEntityInWorld(entityitem);
		}
		return entityitem;
	}
	
	@Override
	protected Item getDropItem() {
		return ItemList.edenDungeonKey;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2) {
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	
	@Override
	protected String getLivingSound() {
		return "mob.crawler.say";
	}
	
	@Override
	protected String getHurtSound() {
		return "mob.crawler.hurt";
	}
	
	@Override
	public boolean isInWater() {
		return false;
	}
	
	@Override
	public boolean handleWaterMovement() {
		return false;
	}
	
}