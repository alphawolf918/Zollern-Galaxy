package zollerngalaxy.lib.helpers;

import java.io.File;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import zollerngalaxy.lib.ZGInfo;

public class ZollernHelper {
	
	private static final Logger LOGGER = (Logger) LogManager.getLogger();
	
	public static void dropItem(Item droppedItem, World worldObj,
			Entity theEntity) {
		ItemStack itemStack = new ItemStack(droppedItem, rngNumber(1, 2));
		EntityItem itemEntity = new EntityItem(worldObj, theEntity.posX,
				theEntity.posY, theEntity.posZ, itemStack);
		worldObj.spawnEntity(itemEntity);
	}
	
	public static boolean getRNGChance(int min, int max) {
		if (min >= max) {
			return false;
		}
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		if (randInt <= min) {
			return true;
		}
		return false;
	}
	
	public static int rngNumber(int min, int max) {
		assert min >= max : " Min can't be lower than max!";
		Random rand = new Random();
		int randInt = rand.nextInt(max);
		if (randInt < min) {
			randInt = min;
		}
		return randInt;
	}
	
	// public static void setTab(Block block) {
	// block.setCreativeTab(ZollernTabs.zTab);
	// }
	//
	// public static void setTab(Item item) {
	// item.setCreativeTab(ZollernTabs.zTab);
	// }
	
	public static void setName(Block block, String strName) {
		block.setRegistryName(ZGInfo.MOD_ID + "_" + strName);
		block.setUnlocalizedName(ZGInfo.MOD_ID + "_" + strName);
	}
	
	public static void setName(Item item, String strName) {
		item.setRegistryName(ZGInfo.MOD_ID + "_" + strName);
		item.setUnlocalizedName(ZGInfo.MOD_ID + "_" + strName);
	}
	
	public static void setHardResist(Block block, float hardness,
			float resistance) {
		block.setHardness(hardness);
		block.setResistance(resistance);
	}
	
	public static void setHardResist(Block block, float hardResist) {
		ZollernHelper.setHardResist(block, hardResist, hardResist);
	}
	
	public static boolean getConfig(Configuration config,
			String configCategory, String configKey,
			boolean configDefaultValue, String configComment) {
		return config.get(configCategory, configKey, configDefaultValue,
				configComment).getBoolean();
	}
	
	public static int getConfig(Configuration config, String configCategory,
			String configKey, int configDefaultValue, String configComment) {
		return config.get(configCategory, configKey, configDefaultValue,
				configComment).getInt();
	}
	
	public static File getFilePath(FMLPreInitializationEvent event) {
		return new File(event.getModConfigurationDirectory().getAbsolutePath()
				+ "ZollernGalaxy/");
	}
	
	/**
	 * Send a chat message to the Player. Call this from your ClientProxy!
	 * 
	 * @param player
	 * @param text
	 */
	public static void addChatMessage(EntityPlayer player, String text) {
		player.sendMessage(new TextComponentString(text));
	}
	
	public static void log(Level level, String strMessage) {
		if (level == Level.INFO) {
			LOGGER.info("[" + ZGInfo.officialName + "] " + strMessage);
		}// else if (level == Level.DEBUG) {
			// if (ZEConfig.enableDebugMode) {
		// LOGGER.debug("[DEB:" + ZGInfo.officialName + "] "
		// + strMessage);
		// }
		// }
	}
	
	public static void logInfo(String str) {
		log(Level.INFO, str);
	}
	
	// public static void logDebug(String str) {
	// if (ZEConfig.enableDebugMode) {
	// log(Level.DEBUG, str);
	// }
	// }
	
	public static void damageItemStack(Item item, float damageAmount,
			EntityPlayer player) {
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
	
	public static DimensionType registerDimension(String dimName,
			String dimUnlocalizedName, int dimID,
			Class<? extends WorldProvider> worldProvider) {
		DimensionType dim = DimensionType.register(dimName, dimUnlocalizedName,
				dimID, worldProvider, false);
		DimensionManager.registerDimension(dimID, dim);
		return dim;
	}
}