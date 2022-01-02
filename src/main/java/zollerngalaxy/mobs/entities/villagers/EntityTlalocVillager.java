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
import zollerngalaxy.blocks.ZGBlocks;
import zollerngalaxy.items.ZGItems;
import zollerngalaxy.lib.helpers.ZGHelper;
import zollerngalaxy.mobs.entities.base.EntityZGVillagerBase;

public class EntityTlalocVillager extends EntityZGVillagerBase {
	
	public EntityTlalocVillager(World worldIn) {
		super(worldIn);
		this.setSize(this.width * 1.2375F, this.height * 1.2375F);
		this.setPriceItem(new ItemStack(ZGItems.plutoniumCrystal, ZGHelper.rngInt(2, 6)));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.321D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
	}
	
	@Override
	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.01F;
	}
	
	@Override
	protected ITradeList[] getTradeList() {
		ITradeList[] TRADE_LIST = new ITradeList[] { new ListVillagerItems(new ItemStack(ZGItems.ingotPlutonium, 1), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.compressedRhodium, 1), new PriceInfo(3, 4)), new ListVillagerItems(new ItemStack(ZGItems.oxygenTankTier6, 1), new PriceInfo(3, 4)),
				new ListVillagerItems(new ItemStack(ZGItems.garnetFire, 1), new PriceInfo(3, 4)), new ListVillagerItems(new ItemStack(ZGItems.perdDiamond, 4), new PriceInfo(1, 2)),
				new ListVillagerItems(new ItemStack(ZGItems.ingotZucrite, 5), new PriceInfo(2, 4)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.perdBerry, 24), new PriceInfo(1, 1), new ItemStack(ZGItems.edenFruit, 64)),
				new ListVillagerItems(new ItemStack(ZGItems.garnet, 1), new PriceInfo(3, 4)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.compressedAmaranth, 1), new PriceInfo(3, 5), new ItemStack(ZGItems.azurite, 1)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.dustChargium, 1), new PriceInfo(3, 5), new ItemStack(ZGBlocks.blockLore, 1)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.healingHeart, 8), new PriceInfo(1, 1), new ItemStack(ZGItems.opal, 6)),
				new ItemAndSapphireToItem(new ItemStack(ZGItems.healingHeartForce, 4), new PriceInfo(1, 1), new ItemStack(ZGItems.topaz, 2)),
				new TradeGoodsForItems(new ItemStack(ZGItems.edenCrystal, 2), new PriceInfo(1, 1)),
				new TradeGoodsForItems(new ItemStack(ZGItems.superChargedCoal, ZGHelper.rngInt(8, 12)), new PriceInfo(1, 1)) };
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
	
	@Override
	public float getEyeHeight() {
		float f = 1.2375F;
		
		if (this.isChild()) {
			f = (float) (f - 0.81D);
		}
		
		return f;
	}
	
}