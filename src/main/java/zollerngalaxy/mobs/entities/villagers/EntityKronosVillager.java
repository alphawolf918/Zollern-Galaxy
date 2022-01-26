/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.villagers;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityKronosVillager extends EntityZGVillagerBase {
	
	public EntityKronosVillager(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.0F, this.height * 1.0F);
		this.setPriceItem(new ItemStack(Items.GHAST_TEAR, ZGHelper.rngInt(1, 5)));
		this.isImmuneToFire = true;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.521D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F;
	}
	
	@Override
	protected ITradeList[] getTradeList() {
		ITradeList[] TRADE_LIST = new ITradeList[] { new ListVillagerItems(new ItemStack(Items.MAGMA_CREAM, 1), new PriceInfo(1, 2)), new ListVillagerItems(new ItemStack(ZGItems.garnetFire, 2), new PriceInfo(1, 2)), new ListVillagerItems(new ItemStack(Items.QUARTZ, ZGHelper.rngInt(1, 64)), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(Items.BLAZE_POWDER, 4), new PriceInfo(1, 2)), new ListVillagerItems(new ItemStack(ZGItems.ingotObsidian, 1), new PriceInfo(1, 2)) };
		return TRADE_LIST;
	}
	
	private void populateBuyingList() {
		if (this.buyingList == null) {
			this.buyingList = new MerchantRecipeList();
		}
		
		for (ITradeList tradeList : this.getTradeList()) {
			tradeList.modifyMerchantRecipeList(this.buyingList, this.rand);
		}
	}
}