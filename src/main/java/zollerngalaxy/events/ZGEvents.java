package zollerngalaxy.events;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import zollerngalaxy.blocks.ZGBlockDirt;
import zollerngalaxy.blocks.ZGBlockGrass;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.EntityBladeFish;
import zollerngalaxy.mobs.entities.EntityBlubberFish;
import zollerngalaxy.mobs.entities.EntityGrayAlien;
import zollerngalaxy.mobs.entities.EntityMegaCreeper;
import zollerngalaxy.mobs.entities.EntityMoolus;
import zollerngalaxy.mobs.entities.EntityMummy;
import zollerngalaxy.mobs.entities.EntityOinkus;
import zollerngalaxy.mobs.entities.EntityScorpion;
import zollerngalaxy.mobs.entities.EntityShark;
import zollerngalaxy.mobs.entities.interfaces.IShadeEntity;
import zollerngalaxy.util.CachedEnum;

public class ZGEvents {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		Entity theEntity = event.getEntityLiving();
		World worldObj = theEntity.world;
		Random rand = new Random();
		int randInt = rand.nextInt(100);
		
		// Moolus (Alien Cow)
		if (theEntity instanceof EntityMoolus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBeef, worldObj, theEntity);
			}
		}
		
		// Oinkus (Alien Pig)
		if (theEntity instanceof EntityOinkus) {
			for (int i = 0; i < ZGHelper.rngInt(1, 4); i++) {
				ZGHelper.dropItem(ZGItems.rawAlienBacon, worldObj, theEntity);
			}
		}
		
		// Gray Alien
		if (theEntity instanceof EntityGrayAlien) {
			for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
				ZGHelper.dropItem(ZGItems.alienStone, worldObj, theEntity);
			}
		}
		
		// Mega Creeper
		if (theEntity instanceof EntityMegaCreeper) {
			for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
				ZGHelper.dropItem(ZGItems.superChargedCoal, worldObj, theEntity);
			}
		}
		
		// Mummy
		if (theEntity instanceof EntityMummy) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(Items.PAPER, worldObj, theEntity);
				}
			}
			
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.perdGlowdust, worldObj, theEntity);
				}
			}
		}
		
		// Scorpion
		if (theEntity instanceof EntityScorpion) {
			if (ZGHelper.getRNGChance(5, 20)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.dustEmerald, worldObj, theEntity);
				}
			}
		}
		
		// Blubber Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawBlubberFish, worldObj, theEntity);
		}
		
		// Gypsy Fish
		if (theEntity instanceof EntityBlubberFish) {
			ZGHelper.dropItem(ZGItems.rawGypsyFish, worldObj, theEntity);
		}
		
		// Blade Fish
		if (theEntity instanceof EntityBladeFish) {
			ZGHelper.dropItem(ZGItems.rawBladeFish, worldObj, theEntity);
		}
		
		// Shark
		if (theEntity instanceof EntityShark) {
			// Shagreen (Shark Leather)
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.shagreen, worldObj, theEntity);
				}
			}
			
			// Shark Tooth
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 3); i++) {
					ZGHelper.dropItem(ZGItems.sharkTooth, worldObj, theEntity);
				}
			}
		}
		
		// Shade Entities
		if (theEntity instanceof IShadeEntity) {
			if (ZGHelper.getRNGChance(5, 10)) {
				for (int i = 0; i < ZGHelper.rngInt(1, 2); i++) {
					ZGHelper.dropItem(ZGItems.darkEssence, worldObj, theEntity);
				}
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onUseHoe(UseHoeEvent event) {
		if (event.getResult() != Result.DEFAULT || event.isCanceled()) {
			return;
		}
		
		World world = event.getWorld();
		BlockPos pos = event.getPos();
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();
		
		if (world.isAirBlock(pos.up())) {
			if (block instanceof ZGBlockGrass || block instanceof ZGBlockDirt) {
				this.setFarmland(event, world, pos, Blocks.FARMLAND);
			}
		}
	}
	
	private void setFarmland(UseHoeEvent event, World world, BlockPos pos, Block farmland) {
		world.setBlockState(pos, farmland.getDefaultState());
		event.setResult(Result.ALLOW);
		world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundType.GROUND.getStepSound(), SoundCategory.BLOCKS,
				(SoundType.GROUND.getVolume() + 1.0F) / 2.0F, SoundType.GROUND.getPitch() * 0.8F);
		
		for (EnumHand hand : CachedEnum.valuesHandCached()) {
			event.getEntityPlayer().swingArm(hand);
		}
	}
}