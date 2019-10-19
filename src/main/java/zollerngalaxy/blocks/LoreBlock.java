package zollerngalaxy.blocks;

import java.util.List;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.LoreBook;
import zollerngalaxy.util.ZGLore;

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
				LoreBook loreBook = ZGLore.getRandomLoreBook();
				ItemStack book = new ItemStack(Items.WRITTEN_BOOK);
				
				NBTTagCompound nbt = new NBTTagCompound();
				NBTTagList bookPages = new NBTTagList();
				
				book.setTagInfo("pages", bookPages);
				book.setTagInfo("author", new NBTTagString("Zollern Wolf"));
				book.setTagInfo("title", new NBTTagString(loreBook.getTitle()));
				
				List<String> pages = loreBook.getPages();
				
				for (String p : pages) {
					bookPages.appendTag(new NBTTagString(p));
				}
				
				playerIn.addItemStackToInventory(book);
				worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
				proxy.sendChatMessage(playerIn,
						TextFormatting.GOLD + "You have discovered lore! Book: " + loreBook.getTitle());
			} else {
				proxy.sendChatMessage(playerIn, TextFormatting.DARK_BLUE + "You will need an Omnitool to access this.");
			}
		}
		return true;
	}
	
	@Override
	public boolean shouldJSONIgnore() {
		return false;
	}
}