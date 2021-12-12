/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.base;

import java.util.Calendar;
import javax.annotation.Nullable;
import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import micdoodle8.mods.galacticraft.core.entities.EntityAlienVillager;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.ai.EntityAIMutantAttack;

public class EntityMutantZombie extends EntityZombie implements IEntityBreathable {
	
	private static String mutantName;
	private static int mutantMultiplyChance;
	private static int mutantFireTime;
	private static float mutantScale;
	
	private int conversionTime;
	private boolean isBreakDoorsTaskSet = false;
	
	public EntityMutantZombie(World worldIn) {
		super(worldIn);
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIMutantAttack(this, 2.5D, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 2.2D));
		this.tasks.addTask(7, new EntityAIWander(this, 2.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.setMutantName("Mutant");
		this.setMutantMultiplyChance(20);
		this.setMutantFireTime(10);
		this.setSize(this.width * this.getMutantScale(), this.height * this.getMutantScale());
		this.setCanPickUpLoot(true);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean getAlwaysRenderNameTagForRender() {
		boolean showNameTags = ConfigManagerZG.enableMutantNameTags;
		return showNameTags;
	}
	
	@Override
	public float getRenderSizeModifier() {
		return this.getMutantScale();
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_ZOMBIE_AMBIENT;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ZOMBIE_HURT;
	}
	
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ZOMBIE_DEATH;
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		
		if (this.rand.nextFloat() < (this.world.getDifficulty() == EnumDifficulty.HARD ? 0.05F : 0.01F)) {
			int i = this.rand.nextInt(3);
			
			if (i == 0) {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ZGItems.swordAzurite));
			} else {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(ZGItems.swordAmaranth));
			}
		}
	}
	
	@Override
	public int getTotalArmorValue() {
		int i = super.getTotalArmorValue() + 2;
		
		if (i > 20) {
			i = 20;
		}
		
		return i;
	}
	
	@Override
	protected void applyEntityAI() {
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[] { EntityPigZombie.class }));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityAlienVillager.class, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZGVillagerBase.class, false));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityGrayAlien.class, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		float f = difficulty.getClampedAdditionalDifficulty();
		this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
		
		if (livingdata == null) {
			livingdata = new EntityMutantZombie.GroupData(this.world.rand.nextFloat() < net.minecraftforge.common.ForgeModContainer.zombieBabyChance);
		}
		
		if (livingdata instanceof EntityMutantZombie.GroupData) {
			EntityMutantZombie.GroupData entityzombie$groupdata = (EntityMutantZombie.GroupData) livingdata;
			
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
	
	public void setMutantScale(float scale) {
		this.mutantScale = scale;
	}
	
	public float getMutantScale() {
		return this.mutantScale;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}
	
	@Override
	public double getMountedYOffset() {
		return this.height * 0.5F;
	}
	
	@Override
	public boolean isBreakDoorsTaskSet() {
		return this.isBreakDoorsTaskSet;
	}
	
	/**
	 * Sets the entity name of this mutant. Used for custom name tags.
	 * 
	 * @param strMutantName
	 */
	public void setMutantName(String strMutantName) {
		this.mutantName = strMutantName;
	}
	
	/**
	 * Gets the entity name of this mutant. Used for custom name tags.
	 * 
	 * @return The name of this mutant.
	 */
	public String getMutantName() {
		return this.mutantName;
	}
	
	/**
	 * Sets the chance for this mutant to multiply when attacked. Lower numbers
	 * mean higher chances (1 in N chance).
	 * 
	 * @param chance
	 *            The chance of this creature to create more of itself or other
	 *            zombies (changeable in the config).
	 */
	public void setMutantMultiplyChance(int chance) {
		this.mutantMultiplyChance = chance;
	}
	
	/**
	 * Gets the chance of this mutant to multiply.
	 * 
	 * @return The chance of this creature to create more of itself or other
	 *         zombies (changeable in the config).
	 */
	public int getMutantMultiplyChance() {
		return this.mutantMultiplyChance;
	}
	
	public void setMutantFireTime(int fireTime) {
		if (fireTime <= 0) {
			this.isImmuneToFire = true;
		}
		this.mutantFireTime = fireTime;
	}
	
	public int getMutantFireTime() {
		return this.mutantFireTime;
	}
	
	@Override
	public float getBlockPathWeight(BlockPos pos) {
		return this.world.getLightBrightness(pos) - 0.5F;
	}
	
	@Override
	public boolean canBreath() {
		return true;
	}
}