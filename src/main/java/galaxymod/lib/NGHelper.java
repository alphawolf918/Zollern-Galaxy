package galaxymod.lib;

import galaxymod.blocks.BlockList;
import galaxymod.creativetabs.ModTabs;

import java.io.File;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class NGHelper {

	public static void setTab(Block block) {
		block.setCreativeTab(ModTabs.ngTab);
	}

	public static void setTab(Item item) {
		item.setCreativeTab(ModTabs.ngTab);
	}

	public static void setName(Block block, String strName) {
		block.setBlockName(ModInfo.MODID + "_" + strName);
	}

	public static void setName(Item item, String strName) {
		item.setUnlocalizedName(ModInfo.MODID + "_" + strName);
	}

	public static void setTexture(Block block, String strTexture) {
		block.setBlockTextureName(ModInfo.MODID + ":" + strTexture);
	}

	public static void setTexture(Item item, String strTexture) {
		item.setTextureName(ModInfo.MODID + ":" + strTexture);
	}

	public static void setNameAndTexture(Block block, String strName,
			String strTexture) {
		setName(block, strName);
		setTexture(block, strTexture);
	}

	public static void setNameAndTexture(Item item, String strName,
			String strTexture) {
		setName(item, strName);
		setTexture(item, strTexture);
	}

	public static void setNameAndTexture(Block block, String strBoth) {
		setName(block, strBoth);
		setTexture(block, strBoth);
	}

	public static void setNameAndTexture(Item item, String strBoth) {
		setName(item, strBoth);
		setTexture(item, strBoth);
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
				+ "galaxymod/");
	}

	public static void addChatMessage(EntityPlayer player, String text) {
		player.addChatMessage(new ChatComponentText(text));
	}

	public static void echo(String str) {
		System.out.println(str);
	}

	public static void Log(String str) {
		echo("[Nova Galactic] " + str);
	}

	public static void genEdenFlowers(World p_76728_1_, Random p_76728_2_,
			int p_76728_3_, int p_76728_4_) {
		Block flowerBlock;
		Random r = new Random();
		int flowerType = r.nextInt(5);
		switch (flowerType) {
		default:
		case 0:
			flowerBlock = BlockList.edenFlower;
			break;
		case 1:
			flowerBlock = BlockList.edenFlowerBlue;
			break;
		case 2:
			flowerBlock = BlockList.edenFlowerCyan;
			break;
		case 3:
			flowerBlock = BlockList.edenFlowerOrange;
			break;
		case 4:
			flowerBlock = BlockList.edenFlowerPurple;
			break;
		case 5:
			flowerBlock = BlockList.edenFlowerRed;
			break;
		case 6:
			flowerBlock = BlockList.edenFlowerYellow;
			break;
		}
		if (p_76728_2_.nextInt(80) == 0) {
			int k = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
			int l = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
			WorldGenFlowers edenFlower = new WorldGenFlowers(flowerBlock);
			edenFlower.generate(p_76728_1_, p_76728_2_, k,
					p_76728_1_.getHeightValue(k, l) + 1, l);
		}
	}
}