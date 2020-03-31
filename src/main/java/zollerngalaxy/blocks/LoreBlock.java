/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.blocks;

import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.LoreBook;
import zollerngalaxy.util.ZGLore;
import zollerngalaxy.util.ZGUtils;

public class LoreBlock extends ZGBlockBase {
	
	private IProxy proxy = ZollernGalaxyCore.proxy;
	
	public LoreBlock() {
		super("loreblock");
		this.setBlockUnbreakable();
		this.setBlockType(EnumBlockType.SPACE);
		this.setLightLevel(1.0F);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if (playerIn.getHeldItem(hand).getItem() == ZGItems.OMNITOOL) {
				try {
					LoreBook loreBook = ZGLore.getRandomLoreBook();
					int bookID = loreBook.getBookID();
					ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
					
					NBTTagCompound nbt = new NBTTagCompound();
					NBTTagList bookPages = new NBTTagList();
					book.setTagInfo("author", new NBTTagString("Zollern Wolf"));
					book.setTagInfo("title", new NBTTagString("Lore Book #" + bookID + ": " + loreBook.getTitle()));
					
					List<String> pages = loreBook.getPages();
					
					pages.forEach((String page) -> {
						ITextComponent cmp = new TextComponentString(page);
						String strPage = ITextComponent.Serializer.componentToJson(cmp);
						NBTTagString strNBT = new NBTTagString(strPage);
						bookPages.appendTag(strNBT);
					});
					
					NBTTagCompound cmp = book.getTagCompound();
					cmp.setTag("pages", bookPages);
					
					String txtFormat = TextFormatting.GOLD + "" + TextFormatting.BOLD;
					
					playerIn.addItemStackToInventory(book);
					worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
					proxy.sendChatMessage(playerIn, txtFormat + ZGUtils.translate("tooltips.loreblock6"));
					proxy.sendChatMessage(playerIn, txtFormat + ZGUtils.translate("tooltips.loreblock7") + " " + loreBook.getTitle());
				} catch (IllegalArgumentException ex) {
					proxy.sendChatMessage(playerIn, TextFormatting.GRAY + ZGUtils.translate("tooltips.loreblock5"));
				}
			} else {
				proxy.sendChatMessage(playerIn, TextFormatting.AQUA + ZGUtils.translate("tooltips.loreblock4"));
			}
		}
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World player, List<String> tooltip, ITooltipFlag advanced) {
		if (CommonZGRegisterHelper.isControlKeyDown() || CommonZGRegisterHelper.isShiftKeyDown()) {
			tooltip.add(ZGUtils.translate("tooltips.loreblock"));
			tooltip.add(ZGUtils.translate("tooltips.loreblock2"));
			tooltip.add(ZGUtils.translate("tooltips.loreblock3"));
		} else {
			tooltip.add(ZGUtils.translate("tooltips.holdshift"));
		}
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return false;
	}
}