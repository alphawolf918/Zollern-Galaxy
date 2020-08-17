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
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import zollerngalaxy.creativetabs.CreativeTabsHelper;
import zollerngalaxy.creativetabs.ZGTabs;

public abstract class ZGHelper {
	
	private static final Logger LOGGER = LogManager.getLogger("Zollern Galaxy");
	
	private static Random rand = new Random();
	
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
		spawnEntity(entityIn, worldIn, x, y, z, 0, 0);
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
		player.sendMessage(new TextComponentString(text));
	}
	
	public static void Log(Level level, String strMessage) {
		if (level == Level.INFO) {
			LOGGER.info(strMessage);
		}
	}
	
	public static void Log(String str) {
		Log(Level.INFO, str);
	}
	
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
	
	public static void repairItemStack(ItemStack item) {
		item.setItemDamage(item.getMaxDamage());
	}
	
	public static DimensionType registerDimension(String dimName, String dimUnlocalizedName, int dimID,
			Class<? extends WorldProvider> worldProvider) {
		DimensionType dim = DimensionType.register(dimName, dimUnlocalizedName, dimID, worldProvider, false);
		DimensionManager.registerDimension(dimID, dim);
		return dim;
	}
}