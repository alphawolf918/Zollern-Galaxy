/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.blocks.caligro;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlockBase;
import zollerngalaxy.core.ZollernGalaxyCore;
import zollerngalaxy.core.enums.EnumBlockType;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.boss.EntityShadowAlien;
import zollerngalaxy.proxy.IProxy;
import zollerngalaxy.util.ZGUtils;

public class BlockShadowBossSpawner extends ZGBlockBase {
	
	protected Item unlockItem = ZGItems.shadeKey;
	protected String unlockMsg = ZGUtils.translate("tooltips.shadekey");
	
	private IProxy proxy = ZollernGalaxyCore.instance().proxy;
	
	public BlockShadowBossSpawner() {
		super("shadowspawner", 10.0F);
		this.setBlockUnbreakable();
		this.setMaterial(Material.IRON);
		this.setSoundType(SoundType.ANVIL);
		this.setBlockType(EnumBlockType.SPAWNER);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
		EnumHand currentHand = playerIn.getActiveHand();
		if (currentHand != null) {
			ItemStack heldItemStack = playerIn.getHeldItem(currentHand);
			Item heldItem = heldItemStack.getItem();
			if (heldItemStack != null && heldItem == ZGItems.shadeKey) {
				InventoryPlayer playerInventory = playerIn.inventory;
				if (playerInventory.hasItemStack(new ItemStack(ZGItems.shadeKey)) && !playerIn.capabilities.isCreativeMode) {
					int invSlot = playerInventory.getSlotFor(new ItemStack(ZGItems.shadeKey));
					playerInventory.clearMatchingItems(ZGItems.shadeKey, -1, 1, null);
				}
				this.spawnMob(worldIn, playerIn, pos.getX(), pos.getY(), pos.getZ());
			} else {
				proxy.sendChatMessage(playerIn, unlockMsg);
			}
		} else {
			proxy.sendChatMessage(playerIn, unlockMsg);
		}
		
		return true;
	}
	
	public void spawnMob(World worldIn, EntityPlayer playerIn, double x, double y, double z) {
		if (!worldIn.isRemote) {
			if (worldIn.getDifficulty() != EnumDifficulty.PEACEFUL) {
				EntityShadowAlien shadowBoss = new EntityShadowAlien(worldIn);
				ZGHelper.spawnEntity(shadowBoss, worldIn, x, y, z);
				proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.beastawoken"));
				worldIn.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState());
			} else {
				proxy.sendChatMessage(playerIn, ZGUtils.translate("tooltips.mobnotpeaceful"));
			}
		}
	}
	
	public Item getUnlockItem() {
		return this.unlockItem;
	}
	
	public Block setUnlockItem(Item itemIn) {
		this.unlockItem = itemIn;
		return this;
	}
	
}