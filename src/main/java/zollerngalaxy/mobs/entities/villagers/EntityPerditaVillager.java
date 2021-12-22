/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.mobs.entities.villagers;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityPerditaVillager extends EntityZGVillagerBase {
	
	public EntityPerditaVillager(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.5375F, this.height * 1.5375F);
		this.setPriceItem(new ItemStack(ZGItems.perdDiamond, ZGHelper.rngInt(1, 4)), new ItemStack(ZGItems.perdGlowdust, ZGHelper.rngInt(1, 4)));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.325165798D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(45.50D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F - 0.2F;
	}
	
	@Override
	protected ITradeList[] getTradeList() {
		ITradeList[] TRADE_LIST = new ITradeList[] { new ListVillagerItems(new ItemStack(ZGItems.opal, 1), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.topaz, 1), new PriceInfo(1, 2)), new ListVillagerItems(new ItemStack(ZGItems.ingotFueltonium, 1), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.ingotEtrium, 1), new PriceInfo(1, 2)) };
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