package zollerngalaxy.lib.helpers;

import java.util.Arrays;
import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap.Builder;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.enums.EnumStateMapper;

@SideOnly(Side.CLIENT)
public class ClientZGRegisterHelper {
	
	public static void registerEntityRendering(Class<? extends Entity> entity, IRenderFactory render) {
		RenderingRegistry.registerEntityRenderingHandler(entity, render);
	}
	
	public static void registerTileEntityItemStackRendering(TileEntity tile) {
		ClientZGRegisterHelper.registerTileEntityItemStackRendering(tile, 0.0D);
	}
	
	public static void registerTileEntityItemStackRendering(TileEntity tile, double yOffset) {
		TileEntityRendererDispatcher.instance.render(tile, 0.0D, yOffset, 0.0D, 0.0F);
	}
	
	public static void registerVariantsName(Item item, String... variant) {
		for (String name : variant) {
			ModelBakery.registerItemVariants(item, new ModelResourceLocation("zollerngalaxy:"
					+ name, "inventory"));
		}
	}
	
	public static void registerVariantsName(Item item, Class<? extends Enum> enumClass) {
		String[] enumNameList = Arrays.stream(enumClass.getEnumConstants()).map(Enum::name)
				.toArray(String[]::new);
		
		for (String name : enumNameList) {
			ClientZGRegisterHelper.registerVariantsName(item, name.toLowerCase());
		}
	}
	
	public static void registerVariantsName(Block block, String... variant) {
		ClientZGRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant);
	}
	
	public static void registerVariantsName(Block block, Class<? extends Enum> enumClass) {
		String[] enumNameList = Arrays.stream(enumClass.getEnumConstants()).map(Enum::name)
				.toArray(String[]::new);
		
		for (String name : enumNameList) {
			ClientZGRegisterHelper.registerVariantsName(block, name.toLowerCase());
		}
	}
	
	public static void registerModelRender(Block block, int meta, String variantName) {
		ClientZGRegisterHelper.registerModelRender(Item.getItemFromBlock(block), meta, variantName);
	}
	
	public static void registerModelRender(Block block, Class<? extends Enum> enumClass) {
		ClientZGRegisterHelper.registerModelRender(Item.getItemFromBlock(block), enumClass);
	}
	
	public static void registerModelRender(Block block, String variantName) {
		ClientZGRegisterHelper.registerModelRender(Item.getItemFromBlock(block), 0, variantName);
	}
	
	public static void registerModelRender(Item item, int meta, String variantName) {
		Minecraft
				.getMinecraft()
				.getRenderItem()
				.getItemModelMesher()
				.register(item, meta,
						new ModelResourceLocation("zollerngalaxy:" + variantName, "inventory"));
	}
	
	public static void registerModelRender(Item item, Class<? extends Enum> enumClass) {
		for (Enum enumObj : enumClass.getEnumConstants()) {
			ClientZGRegisterHelper.registerModelRender(item, enumObj.ordinal(), enumObj.name()
					.toLowerCase());
		}
	}
	
	public static void registerModelRender(Item item, ItemMeshDefinition itemMesh) {
		ModelLoader.setCustomMeshDefinition(item, itemMesh);
	}
	
	public static void registerModelRender(Block block, ItemMeshDefinition itemMesh) {
		ClientZGRegisterHelper.registerModelRender(Item.getItemFromBlock(block), itemMesh);
	}
	
	public static void registerModelRender(Item item, String variantName) {
		ClientZGRegisterHelper.registerModelRender(item, 0, variantName);
	}
	
	public static void registerToolsModelRender(Item sword, Item shovel, Item pickaxe, Item axe,
			Item hoe, String toolName) {
		ClientZGRegisterHelper.registerModelRender(sword, 0, toolName + "_sword");
		ClientZGRegisterHelper.registerModelRender(shovel, 0, toolName + "_shovel");
		ClientZGRegisterHelper.registerModelRender(pickaxe, 0, toolName + "_pickaxe");
		ClientZGRegisterHelper.registerModelRender(axe, 0, toolName + "_axe");
		ClientZGRegisterHelper.registerModelRender(hoe, 0, toolName + "_hoe");
	}
	
	public static void registerArmorModelRender(Item helmet, Item chestplate, Item leggings,
			Item boots, String toolName) {
		ClientZGRegisterHelper.registerModelRender(helmet, 0, toolName + "_helmet");
		ClientZGRegisterHelper.registerModelRender(chestplate, 0, toolName + "_chestplate");
		ClientZGRegisterHelper.registerModelRender(leggings, 0, toolName + "_leggings");
		ClientZGRegisterHelper.registerModelRender(boots, 0, toolName + "_boots");
	}
	
	public static void registerStateMapper(Block block, EnumStateMapper mapper) {
		ClientZGRegisterHelper.registerStateMapper(block, new Builder()
				.ignore(mapper.getProperty()).build());
	}
	
	public static void registerStateMapper(Block block, IStateMapper mapper) {
		ModelLoader.setCustomStateMapper(block, mapper);
	}
	
	public static void registerStateMapperSplitVariants(Block block, IProperty property) {
		ClientZGRegisterHelper.registerStateMapper(block, new Builder().withName(property).build());
	}
	
	public static void registerStateMapper(Block block, IProperty... property) {
		ClientZGRegisterHelper.registerStateMapper(block, new Builder().ignore(property).build());
	}
	
	public static void registerSpriteTexture(TextureStitchEvent.Pre event, String texture) {
		event.getMap().registerSprite(new ResourceLocation("zollerngalaxy:" + texture));
	}
	
	public static void registerBlockColor(IBlockColor blockColor, Block block) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(blockColor, block);
	}
	
	public static void registerItemColor(IItemColor blockColor, Block block) {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(blockColor, block);
	}
	
	public static void registerItemColor(IItemColor blockColor, Item item) {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(blockColor, item);
	}
	
	private static void registerVariantsName(Block block, String variant) {
		ClientZGRegisterHelper.registerVariantsName(Item.getItemFromBlock(block), variant);
	}
	
	private static void registerVariantsName(Item item, String variant) {
		ModelBakery.registerItemVariants(item, new ModelResourceLocation(
				"zollerngalaxy:" + variant, "inventory"));
	}
	
}