/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import zollerngalaxy.config.ConfigManagerZG;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.worldgen.toci.WorldGenWandererHouse;

public class EntityWanderer extends EntityAgeable {
	
	protected int dangerSense = 0;
	protected boolean canInteract = true;
	protected ArrayList<String> sayings = new ArrayList<String>();
	protected int randNameInt = (new Random()).nextInt(100);
	protected String customName = "Wanderer";
	
	protected ZollernGalaxyCore core = ZollernGalaxyCore.instance();
	protected IProxy proxy = core.proxy;
	
	public EntityWanderer(World worldIn) {
		super(worldIn);
		this.setSize(0.7F, 2.0F);
		this.setCustomNameTag(this.customName);
		this.addSayings();
		((PathNavigateGround) this.getNavigator()).setBreakDoors(true);
		this.setCanPickUpLoot(true);
	}
	
	@Override
	public boolean canPickUpLoot() {
		return true;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMob.class, 8.0F, 0.6D, 0.6D));
		this.tasks.addTask(2, new EntityAIMoveIndoors(this));
		this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.6D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.6D));
		this.tasks.addTask(7, new EntityAIWatchClosest2(this, EntityLiving.class, 8.0F, 1.0F));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.34000000417232513D);
	}
	
	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		if (ConfigManagerZG.enableWandererHouses) {
			if (!this.world.isDaytime()) {
				if (!this.dangerSenseReached()) {
					this.increaseDangerSense();
				} else {
					this.avoidDanger();
				}
			} else {
				this.clearDangerSense();
			}
		}
	}
	
	public void increaseDangerSense(int byAmount) {
		this.dangerSense += byAmount;
	}
	
	public void increaseDangerSense() {
		this.increaseDangerSense(1);
	}
	
	public void clearDangerSense() {
		this.dangerSense = 0;
	}
	
	public boolean dangerSenseReached() {
		return (this.dangerSense >= 5000);
	}
	
	public void avoidDanger() {
		if (!this.hasHome()) {
			this.buildHouse(this.world, this.rand, this);
		}
	}
	
	public void buildHouse(World world, Random random, EntityWanderer entity) {
		if (entity.posY >= 60) {
			int entX = (int) entity.posX + 4;
			int entY = (int) entity.posY;
			int entZ = (int) entity.posZ + 4;
			BlockPos pos = new BlockPos(entX, entY, entZ);
			WorldGenWandererHouse wandererHouse = new WorldGenWandererHouse();
			wandererHouse.generate(world, random, pos);
			entity.setHomePosAndDistance(pos, 4);
			this.dangerSense = 0;
		}
	}
	
	public void addSayings() {
		addSaying("Hello there.");
		addSaying("How are you today?");
		addSaying("I sure do love mining.");
		addSaying("Dude, Mega Creepers freak me out.");
		addSaying("I'm so, like, bummed.");
		addSaying("The moon is full tonight.");
		addSaying("Fear Toci, lest it consume you.");
		addSaying("Legend says that Crystal Towers spawn, and that chests lie within them.");
		addSaying("You are of no interest to me.");
		if (this.hasHome()) {
			addSaying("I should get home...");
		} else {
			addSaying("I need a house...");
		}
		addSaying("Sometimes chests can be found underneath the dirt. There are usually crystals nearby.");
		addSaying("I need more zinc in my diet.");
		addSaying("Ugh, I seriously need water.");
		addSaying("I love trees.");
		addSaying("I am a busy, busy man.");
		addSaying("You're ugly.");
		addSaying("Well, look who crawled out from under a rock.");
		addSaying("You don't belong here.");
		addSaying("Welcome to Toci!");
		addSaying("Have you ever thought about exercising?");
		addSaying("Wow, you sure look good. *cough*");
	}
	
	public void addSaying(String par1Saying) {
		this.sayings.add(par1Saying);
	}
	
	public String pickSaying() {
		return sayings.get((new Random()).nextInt(sayings.size()));
	}
	
	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		World world = player.world;
		if (!world.isRemote) {
			String txtFormatGold = TextFormatting.GOLD + "";
			String txtFormatWhite = TextFormatting.WHITE + "";
			String nameTag = "<" + txtFormatGold + this.getCustomNameTag() + txtFormatWhite + "> ";
			String txt = nameTag + this.pickSaying();
			proxy.sendChatMessage(player, txt);
			return true;
		}
		return false;
	}
	
	@Override
	public void onDeath(DamageSource ds) {
		super.onDeath(ds);
		if (!this.world.isRemote && !this.world.isDaytime()) {
			EntityZombie zombie = new EntityZombie(this.world);
			zombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
			if (this.hasCustomName()) {
				zombie.setCustomNameTag(this.getCustomNameTag() + " Zombie");
			}
			zombie.setCanPickUpLoot(true);
			this.world.spawnEntity(zombie);
		}
		this.setDead();
	}
	
	@Override
	public EntityWanderer createChild(EntityAgeable ageable) {
		EntityWanderer entityWanderer = new EntityWanderer(this.world);
		entityWanderer.onInitialSpawn(this.world.getDifficultyForLocation(new BlockPos(entityWanderer)), (IEntityLivingData) null);
		return entityWanderer;
	}
	
}