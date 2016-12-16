/*******************************************************************************
 * Copyright 2015 Zollern Wolf
 * - Project Nova / Nova Galactic Final Frontier
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 *******************************************************************************/

package galaxymod.events;

import galaxymod.biomes.BiomeSpace;
import galaxymod.core.PlanetNova;
import galaxymod.items.ItemList;
import galaxymod.mobs.entities.boss.EntityCrawlerBoss;
import galaxymod.utils.NGDamageSource;
import java.util.Random;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class NovaEvents {
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onLivingDropsEvent(LivingDropsEvent event) {
		EntityLivingBase theEntity = event.entityLiving;
		World worldObj = theEntity.worldObj;
		if (theEntity instanceof EntityCrawlerBoss) {
			EntityItem item = new EntityItem(worldObj, theEntity.posX,
					theEntity.posY, theEntity.posZ, new ItemStack(
							ItemList.edenDungeonKey, 1));
			worldObj.spawnEntityInWorld(item);
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
	public void onLivingUpdate(LivingUpdateEvent event) {
		EntityLivingBase livingBase = event.entityLiving;
		if (livingBase instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) livingBase;
			World world = player.worldObj;
			int playerX = (int) player.posX;
			int playerY = (int) player.posY;
			int playerZ = (int) player.posZ;
			Random rand = new Random();
			BiomeGenBase currentBiome = world.getBiomeGenForCoords(playerX,
					playerZ);
			if (currentBiome instanceof BiomeSpace) {
				BiomeSpace space = (BiomeSpace) currentBiome;
				PlanetNova planet = space.getPlanetForBiome();
				
				float toxLevel = planet.getToxicLevel();
				float radLevel = planet.getRadiationLevel();
				float planetTemp = space.getPlanetTemp();
				
				float toxDamage = (toxLevel * NGDamageSource.baseToxDamage) / 1.5f;
				float radDamage = (radLevel * NGDamageSource.baseRadDamage) / 2.2f;
				
				float hotTempDamage = 1.0f;
				hotTempDamage = (planetTemp * NGDamageSource.baseHotDamage) / 1.4f;
				
				float coldTempDamage = 1.0f;
				coldTempDamage = Math.abs((planetTemp
						* (NGDamageSource.baseColdDamage) * 2.0f) / 1.5f) - 4.6f;
				
				// Applies the survival mechanics.
				if (rand.nextInt(614) <= 392) {
					// Toxic Damage
					this.performSurvivalEffect(ItemList.blueprintTox,
							NGDamageSource.deathToxic, toxDamage, player,
							planet.getIsToxicPlanet());
					
					// Radiation Damage
					this.performSurvivalEffect(ItemList.blueprintRad,
							NGDamageSource.deathRadiation, radDamage, player,
							planet.getIsRadioactivePlanet());
				}
			}
		}
	}
	
	/**
	 * Perform the desired survival effect on the Player.
	 * 
	 * @param blueprintItem
	 * @param damageSource
	 * @param damageAmount
	 * @param player
	 * @param check
	 */
	private void performSurvivalEffect(Item blueprintItem,
			NGDamageSource damageSource, float damageAmount,
			EntityPlayer player, boolean check) {
		InventoryPlayer matrix = player.inventory;
		if (check) {
			if (!matrix.hasItem(blueprintItem)) {
				player.attackEntityFrom(damageSource, damageAmount);
			} else {
				this.damageItemStack(blueprintItem, damageAmount, player);
			}
		}
	}
	
	private void damageItemStack(Item blueprintItem, float damageAmount,
			EntityPlayer player) {
		InventoryPlayer matrix = player.inventory;
		for (int i = 0; i < matrix.getSizeInventory(); i++) {
			if (matrix.getStackInSlot(i) != null) {
				ItemStack stackNew = matrix.getStackInSlot(i);
				if (stackNew != null && stackNew.getItem() == blueprintItem) {
					ItemStack k = new ItemStack(blueprintItem);
					k.setItemDamage(k.getItemDamage() + (int) damageAmount);
					matrix.setInventorySlotContents(i, k);
				}
			}
		}
	}
}