/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.lib.helpers;

import java.io.File;
import java.util.Random;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import micdoodle8.mods.galacticraft.core.util.DamageSourceGC;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.creativetabs.CreativeTabsHelper;
import zollerngalaxy.creativetabs.ZGTabs;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.util.ZGDamageSrc;

public final class ZGHelper {
	
	private static final Logger LOGGER = LogManager.getLogger(ZGInfo.OFFICIAL_NAME);
	
	private static Random rand = new Random();
	
	/**
	 * Get block at this position.
	 * 
	 * @param world
	 * @param pos
	 * @return
	 */
	public static Block getBlock(World world, BlockPos pos) {
		return ZGHelper.getBlockState(world, pos).getBlock();
	}
	
	public static IBlockState getBlockState(World world, BlockPos pos) {
		return world.getBlockState(pos);
	}
	
	/**
	 * Spawn an Entity into the world.
	 * 
	 * @param entityIn
	 *            The Entity to spawn.
	 * @param worldIn
	 *            The World to spawn it in.
	 * @param x
	 *            X Coord
	 * @param y
	 *            Y Coord
	 * @param z
	 *            Z Coord
	 */
	public static void spawnEntity(Entity entityIn, World worldIn, double x, double y, double z) {
		ZGHelper.spawnEntity(entityIn, worldIn, x, y, z, 0, 0);
	}
	
	/**
	 * Spawn an Entity into the world.
	 * 
	 * @param entityIn
	 *            The Entity to spawn.
	 * @param worldIn
	 *            The World to spawn it in.
	 * @param x
	 *            X Coord
	 * @param y
	 *            Y Coord
	 * @param z
	 *            Z Coord
	 * @param pitch
	 *            Entity pitch
	 * @param yaw
	 *            Entity yaw
	 */
	public static void spawnEntity(Entity entityIn, World worldIn, double x, double y, double z, float pitch, float yaw) {
		entityIn.setLocationAndAngles(x, y, z, pitch, yaw);
		worldIn.spawnEntity(entityIn);
	}
	
	/**
	 * Spawn an Entity into the world.
	 * 
	 * @param entityIn
	 * @param worldIn
	 * @param pos
	 */
	public static void spawnEntity(Entity entityIn, World worldIn, BlockPos pos) {
		entityIn.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
		worldIn.spawnEntity(entityIn);
	}
	
	/**
	 * Spawn an Entity into the world.
	 * 
	 * @param entityIn
	 * @param worldIn
	 * @param pos
	 * @param pitch
	 * @param yaw
	 */
	public static void spawnEntity(Entity entityIn, World worldIn, BlockPos pos, float pitch, float yaw) {
		entityIn.setLocationAndAngles(pos.getX(), pos.getY(), pos.getZ(), pitch, yaw);
		worldIn.spawnEntity(entityIn);
	}
	
	public static void dropItem(Item droppedItem, World worldObj, Entity theEntity) {
		if (!worldObj.isRemote) {
			ItemStack itemStack = new ItemStack(droppedItem, rngInt(1, 2));
			EntityItem itemEntity = new EntityItem(worldObj, theEntity.posX, theEntity.posY, theEntity.posZ, itemStack);
			worldObj.spawnEntity(itemEntity);
		}
	}
	
	public static void dropItem(Item droppedItem, World worldObj, BlockPos pos) {
		if (!worldObj.isRemote) {
			ItemStack itemStack = new ItemStack(droppedItem, rngInt(1, 2));
			EntityItem itemEntity = new EntityItem(worldObj, pos.getX(), pos.getY(), pos.getZ(), itemStack);
			worldObj.spawnEntity(itemEntity);
		}
	}
	
	public static void dropItem(ItemStack itemStack, World worldObj, Entity theEntity) {
		if (!worldObj.isRemote) {
			EntityItem itemEntity = new EntityItem(worldObj, theEntity.posX, theEntity.posY, theEntity.posZ, itemStack);
			worldObj.spawnEntity(itemEntity);
		}
	}
	
	public static void dropItem(ItemStack itemStack, World worldObj, BlockPos pos) {
		if (!worldObj.isRemote) {
			EntityItem itemEntity = new EntityItem(worldObj, pos.getX(), pos.getY(), pos.getZ(), itemStack);
			worldObj.spawnEntity(itemEntity);
		}
	}
	
	public static Random getRNG() {
		return rand;
	}
	
	public static boolean getRNGChance(int min, int max) {
		assert min >= max : "Min can't be greater than max!";
		int randInt = rand.nextInt(max);
		if (randInt == min) {
			return true;
		}
		return false;
	}
	
	public static int rngInt(int min, int max) {
		assert min >= max : "Min can't be greater than max!";
		int randInt = rand.nextInt(max);
		if (randInt < min) {
			randInt = min;
		}
		return randInt;
	}
	
	public static double rngDbl(double min, double max) {
		assert min >= max : "Min can't be greater than max!";
		double randDbl = rand.nextDouble() * max;
		if (randDbl < min) {
			randDbl = min;
		}
		return randDbl;
	}
	
	public static float rngFloat(float min, float max) {
		assert min >= max : "Min can't be greater than max!";
		float randFlt = rand.nextFloat() * max;
		if (randFlt < min) {
			randFlt = min;
		}
		return randFlt;
	}
	
	public static String capitalizeFirstLetter(String original) {
		if (original == null || original.length() == 0) {
			return original;
		}
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
	
	public static void setTab(Block block) {
		block.setCreativeTab(ZGTabs.zgBlocksTab);
	}
	
	public static void setTab(Item item) {
		item.setCreativeTab(ZGTabs.zgItemsTab);
	}
	
	public static CreativeTabs createCreativeTabs(String name, ItemStack itemStack) {
		return new CreativeTabsHelper(name, itemStack);
	}
	
	public static void setName(Block block, String strName) {
		block.setUnlocalizedName(strName);
	}
	
	public static void setName(Item item, String strName) {
		item.setUnlocalizedName(strName);
	}
	
	public static void setHardResist(Block block, float hardness, float resistance) {
		block.setHardness(hardness);
		block.setResistance(resistance);
	}
	
	public static void setHardResist(Block block, float hardResist) {
		ZGHelper.setHardResist(block, hardResist, hardResist);
	}
	
	public static File getFilePath(FMLPreInitializationEvent event) {
		return new File(event.getModConfigurationDirectory().getAbsolutePath() + "ZollernGalaxy/");
	}
	
	/**
	 * Send a chat message to the Player. Call this from your ClientProxy!
	 * 
	 * @param player
	 *            The Player to send the message to.
	 * @param text
	 *            The message to send.
	 */
	public static void addChatMessage(EntityPlayer player, String text) {
		World world = player.world;
		if (!world.isRemote) {
			player.sendMessage(new TextComponentString(text));
		}
	}
	
	public static void Log(Level level, String strMessage) {
		if (level == Level.INFO) {
			LOGGER.info(strMessage);
		} else if (level == level.ERROR) {
			LOGGER.error(strMessage);
		} else if (level == level.WARN) {
			LOGGER.warn(strMessage);
		}
	}
	
	public static void Log(String str) {
		Log(Level.INFO, str);
	}
	
	public static void LogErr(String strErr) {
		Log(Level.ERROR, strErr);
	}
	
	public static void LogWarn(String strErr) {
		Log(Level.WARN, strErr);
	}
	
	public static ItemStack getItemStack(Item item, EntityPlayer player) {
		InventoryPlayer matrix = player.inventory;
		for (int i = 0; i < matrix.getSizeInventory(); i++) {
			if (matrix.getStackInSlot(i) != null) {
				ItemStack stackNew = matrix.getStackInSlot(i);
				if (stackNew != null && stackNew.getItem() == item) {
					ItemStack k = stackNew.copy();
					return k;
				}
			}
		}
		return null;
	}
	
	/**
	 * Set damage to the item.
	 * 
	 * @param item
	 *            The item of the stack to damage.
	 * @param damageAmount
	 *            The amount of damage.
	 * @param player
	 *            The EntityPlayer instance (the one playing the game).
	 */
	public static void damageItemStack(Item item, float damageAmount, EntityPlayer player) {
		InventoryPlayer matrix = player.inventory;
		for (int i = 0; i < matrix.getSizeInventory(); i++) {
			if (matrix.getStackInSlot(i) != null) {
				ItemStack stackNew = matrix.getStackInSlot(i);
				if (stackNew != null && stackNew.getItem() == item) {
					ItemStack k = new ItemStack(item);
					k.setItemDamage(k.getItemDamage() + (int) damageAmount);
					matrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
	
	/**
	 * Checks a Player's inventory for an item by looping through it.
	 * This way it shouldn't care about metadata.
	 * Probably a better way to do it, but oh well.
	 * 
	 * @param itemIn
	 *            The Item to check.
	 * @param playerIn
	 *            The Player to check the Inventory of.
	 * @return True or False if the Item is present or not.
	 */
	public static boolean checkInventoryForItem(Item itemIn, EntityPlayer playerIn) {
		InventoryPlayer matrix = playerIn.inventory;
		for (int i = 0; i < matrix.getSizeInventory(); i++) {
			if (matrix.getStackInSlot(i) != null) {
				ItemStack matrixStack = matrix.getStackInSlot(i);
				if (matrixStack != null && matrixStack.getItem().equals(itemIn)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Repair a damaged ItemStack, such as a Blueprint.
	 * 
	 * @param itemStack
	 *            The ItemStack instance to repair.
	 */
	public static void repairItemStack(ItemStack itemStack) {
		itemStack.setItemDamage(0);
	}
	
	/**
	 * Check for the supplied Blueprint Protection item, and if it's there, damage it instead of the
	 * Player.
	 * 
	 * @param rand
	 *            The Random to pass.
	 * @param blueprintItem
	 *            The Blueprint Item to look for and damage if found.
	 * @param player
	 *            The Player to affect.
	 * @param dSrc
	 *            The DamageSource; must be a ZGDamageSrc instance.
	 */
	public static void performBlueprintCheck(Random rand, Item blueprintItem, EntityPlayer player, ZGDamageSrc dSrc) {
		if (rand.nextInt(100) <= 5) {
			float dmg = dSrc.getDamageBase();
			if (!ZGHelper.checkInventoryForItem(blueprintItem, player)) {
				player.attackEntityFrom(dSrc, dmg);
			} else {
				if (rand.nextInt(100) <= 10) {
					int damage = (int) dmg;
					ZGHelper.damageBlueprint(blueprintItem, player, damage);
				}
			}
		}
	}
	
	/**
	 * Check for the supplied Blueprint Protection item, and if it's there, damage it instead of the
	 * Player.
	 * 
	 * @param rand
	 *            The Random to pass.
	 * @param blueprintItem
	 *            The Blueprint Item to look for and damage if found.
	 * @param player
	 *            The Player to affect.
	 * @param dSrc
	 *            The DamageSource; must be a DamageSourceGC instance.
	 * @param dmg
	 *            The amount of damage.
	 */
	public static void performBluePrintCheck(Random rand, Item blueprintItem, EntityPlayer player, DamageSourceGC dSrc, float dmg) {
		if (rand.nextInt(100) <= 5) {
			if (!ZGHelper.checkInventoryForItem(blueprintItem, player)) {
				player.attackEntityFrom(dSrc, dmg);
			} else {
				if (rand.nextInt(100) <= 10) {
					int damage = (int) dmg;
					ZGHelper.damageBlueprint(blueprintItem, player, damage);
				}
			}
		}
	}
	
	/**
	 * Check for the supplied Blueprint Protection item, and if it's there, damage it instead of the
	 * Player.
	 * 
	 * @param rand
	 *            The Random to pass.
	 * @param blueprintItem
	 *            The Blueprint Item to look for and damage if found.
	 * @param player
	 *            The Player to affect.
	 * @param dSrc
	 *            The DamageSource; must be a ZGDamageSrc instance.
	 * @param dmg
	 *            The amount of damage.
	 */
	public static void performBluePrintCheck(Random rand, Item blueprintItem, EntityPlayer player, DamageSource dSrc, float dmg) {
		if (rand.nextInt(100) <= 5) {
			if (!ZGHelper.checkInventoryForItem(blueprintItem, player)) {
				player.attackEntityFrom(dSrc, dmg);
			} else {
				if (rand.nextInt(100) <= 10) {
					int damage = (int) dmg;
					ZGHelper.damageBlueprint(blueprintItem, player, damage);
				}
			}
		}
	}
	
	/**
	 * Damage a Blueprint Protection item instead of the Player if it's available.
	 * 
	 * @param blueprintItem
	 *            The Item to damage.
	 * @param player
	 *            The Player to protect.
	 * @param damageAmount
	 *            The amount of damage to do.
	 */
	public static void damageBlueprint(Item blueprintItem, EntityPlayer player, int damageAmount) {
		ItemStack stack = ZGHelper.getItemStack(blueprintItem, player);
		stack.damageItem(damageAmount, player);
		ItemStack dmgStack = stack.copy();
		InventoryPlayer playerInventory = player.inventory;
		int invSlot = playerInventory.getSlotFor(stack);
		playerInventory.setInventorySlotContents(invSlot, dmgStack);
	}
	
	public static DimensionType registerDimension(String dimName, String dimUnlocalizedName, int dimID, Class<? extends WorldProvider> worldProvider) {
		DimensionType dim = DimensionType.register(dimName, dimUnlocalizedName, dimID, worldProvider, false);
		DimensionManager.registerDimension(dimID, dim);
		return dim;
	}
	
	public static Logger getLogger() {
		return LOGGER;
	}
	
	public static void setupMobSpawner(World world, Random rand, BlockPos pos, ResourceLocation mob) {
		world.setBlockState(pos, Blocks.MOB_SPAWNER.getDefaultState(), 2);
		TileEntityMobSpawner spawner = (TileEntityMobSpawner) world.getTileEntity(pos);
		if (spawner != null) {
			spawner.getSpawnerBaseLogic().setEntityId(mob);
		}
	}
	
	public static Block getRandomCrop(Random par1Random) {
		switch (par1Random.nextInt(5)) {
			case 0:
				return ZGBlocks.cropBlueberry;
			case 1:
				return ZGBlocks.cropBlackberry;
			case 2:
				return ZGBlocks.cropStrawberry;
			case 3:
				return ZGBlocks.cropGrape;
			case 4:
				return ZGBlocks.cropTomato;
			default:
				return Blocks.WHEAT;
		}
	}
}