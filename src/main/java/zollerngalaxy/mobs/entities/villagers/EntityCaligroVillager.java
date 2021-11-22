/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.villagers;

import micdoodle8.mods.galacticraft.core.GCItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityCaligroVillager extends EntityZGVillagerBase {
	
	private static final ITradeList[] TRADE_LIST = new ITradeList[] { new ListItemForEmeralds(new ItemStack(ZGItems.shadowBone, 1), new PriceInfo(1, 2)),
			new ListItemForEmeralds(new ItemStack(ZGItems.swordZollernium, 1), new PriceInfo(3, 4)),
			new ListItemForEmeralds(new ItemStack(ZGItems.darkEssence, 1), new PriceInfo(3, 4)),
			new ListItemForEmeralds(new ItemStack(ZGItems.chestAmaranth, 1), new PriceInfo(3, 4)),
			new ListItemForEmeralds(new ItemStack(ZGItems.ingotChargium, 1), new PriceInfo(1, 2)),
			new ListItemForEmeralds(new ItemStack(ZGItems.azurite, 5), new PriceInfo(2, 4)),
			new ItemAndEmeraldToItem(new ItemStack(ZGItems.cookedAlienBeef, 1), new PriceInfo(1, 1), new ItemStack(ZGItems.edenFruit, 1)),
			new ListItemForEmeralds(new ItemStack(ZGItems.starGateCandy, 1), new PriceInfo(3, 4)),
			new ItemAndEmeraldToItem(new ItemStack(ZGItems.compressedRiven, 1), new PriceInfo(3, 5), new ItemStack(GCItems.schematic, 1, 1)),
			new ItemAndEmeraldToItem(new ItemStack(ZGItems.dustZinc, 1), new PriceInfo(3, 5), new ItemStack(ZGBlocks.blockLore, 1)),
			new ItemAndEmeraldToItem(new ItemStack(ZGBlocks.blockLore, 2), new PriceInfo(1, 1), new ItemStack(ZGItems.healingHeart, 1)),
			new ItemAndEmeraldToItem(new ItemStack(ZGItems.healingHeartForce, 2), new PriceInfo(1, 1), new ItemStack(ZGBlocks.blockLore, 1)),
			new EmeraldForItems(new ItemStack(ZGBlocks.exoWoodSapling, 1), new PriceInfo(11, 39)),
			new EmeraldForItems(new ItemStack(ZGItems.superChargedCoal, ZGHelper.rngInt(4, 6)), new PriceInfo(11, 39)) };
	
	public EntityCaligroVillager(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.6375F, this.height * 1.6375F);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.521D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(180.0D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.01F;
	}
	
	private void populateBuyingList() {
		if (this.buyingList == null) {
			this.buyingList = new MerchantRecipeList();
		}
		
		for (EntityCaligroVillager.ITradeList tradeList : TRADE_LIST) {
			tradeList.modifyMerchantRecipeList(this.buyingList, this.rand);
		}
	}
	
	@Override
	public float getEyeHeight() {
		float f = 1.6375F;
		
		if (this.isChild()) {
			f = (float) (f - 0.81D);
		}
		
		return f;
	}
	
}