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

package galaxymod.worldgen.eden.dungeons;

import galaxymod.blocks.BlockList;
import galaxymod.items.ItemList;
import galaxymod.tileentities.eden.TileEntityTreasureChestEden;
import galaxymod.worldgen.eden.treasure.EdenGenHooks;
import java.util.HashSet;
import java.util.Random;
import micdoodle8.mods.galacticraft.core.items.GCItems;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.DungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.util.ForgeDirection;

public class RoomTreasureEden extends DungeonRoom {
	
	int sizeX;
	int sizeY;
	int sizeZ;
	
	private final HashSet<ChunkCoordinates> chests = new HashSet<ChunkCoordinates>();
	
	public RoomTreasureEden(MapGenDungeon dungeon, int posX, int posY,
			int posZ, ForgeDirection entranceDir) {
		super(dungeon, posX, posY, posZ, entranceDir);
		if (this.worldObj != null) {
			final Random rand = new Random(this.worldObj.getSeed() * posX
					* posY * 57 * posZ);
			this.sizeX = rand.nextInt(6) + 7;
			this.sizeY = rand.nextInt(2) + 5;
			this.sizeZ = rand.nextInt(6) + 7;
		}
	}
	
	@Override
	public void generate(Block[] chunk, byte[] meta, int cx, int cz) {
		for (int i = this.posX - 1; i <= this.posX + this.sizeX; i++) {
			for (int k = this.posZ - 1; k <= this.posZ + this.sizeZ; k++) {
				for (int j = this.posY - 1; j <= this.posY + this.sizeY; j++) {
					if (i == this.posX - 1 || i == this.posX + this.sizeX
							|| j == this.posY - 1
							|| j == this.posY + this.sizeY
							|| k == this.posZ - 1
							|| k == this.posZ + this.sizeZ) {
						this.placeBlock(chunk, meta, i, j, k, cx, cz,
								this.dungeonInstance.DUNGEON_WALL_ID,
								this.dungeonInstance.DUNGEON_WALL_META);
					} else {
						if ((i == this.posX || i == this.posX + this.sizeX - 1)
								&& (k == this.posZ || k == this.posZ
										+ this.sizeZ - 1)) {
							this.placeBlock(chunk, meta, i, j, k, cx, cz,
									BlockList.edenBrightStone, 0);
						} else {
							this.placeBlock(chunk, meta, i, j, k, cx, cz,
									Blocks.air, 0);
						}
					}
				}
			}
		}
		final int hx = (this.posX + this.posX + this.sizeX) / 2;
		final int hz = (this.posZ + this.posZ + this.sizeZ) / 2;
		
		if (this.placeBlock(chunk, meta, hx, this.posY, hz, cx, cz,
				BlockList.edenTreasureChest, 0)) {
			this.chests.add(new ChunkCoordinates(hx, this.posY, hz));
		}
	}
	
	@Override
	public DungeonBoundingBox getBoundingBox() {
		return new DungeonBoundingBox(this.posX, this.posZ, this.posX
				+ this.sizeX, this.posZ + this.sizeZ);
	}
	
	@Override
	protected DungeonRoom makeRoom(MapGenDungeon dungeon, int x, int y, int z,
			ForgeDirection dir) {
		return new RoomTreasureEden(dungeon, x, y, z, dir);
	}
	
	// TODO: Return portal gate crafting ingredient
	public ItemStack getGuaranteedLoot(Random rand) {
		switch (rand.nextInt(10)) {
			default:
				return new ItemStack(GCItems.meteoricIronIngot,
						(new Random()).nextInt(64));
			case 0:
				return new ItemStack(Items.gold_ingot, rand.nextInt(2) + 50, 0);
			case 1:
				return new ItemStack(Items.iron_ingot, 50, 0);
			case 2:
				return new ItemStack(Items.diamond, rand.nextInt(8) + 50, 0);
			case 3:
				return new ItemStack(Items.emerald, rand.nextInt(3) + 50, 1);
			case 4:
				return new ItemStack(Items.redstone, rand.nextInt(15) + 50, 0);
			case 5:
				return new ItemStack(ItemList.ingotViri, rand.nextInt(15) + 45,
						0);
			case 6:
				return new ItemStack(ItemList.edenCrystal, rand.nextInt(2) + 2,
						0);
		}
	}
	
	@Override
	protected void handleTileEntities(Random rand) {
		for (final ChunkCoordinates chestCoords : this.chests) {
			final TileEntity chest = this.worldObj.getTileEntity(
					chestCoords.posX, chestCoords.posY, chestCoords.posZ);
			
			if (chest != null && chest instanceof TileEntityTreasureChestEden) {
				final EdenGenHooks info = EdenGenHooks
						.getInfo(EdenGenHooks.DROP_SHIP);
				WeightedRandomChestContent.generateChestContents(rand,
						info.getItems(rand),
						(TileEntityTreasureChestEden) chest,
						info.getCount(rand));
				((TileEntityTreasureChestEden) chest).setInventorySlotContents(
						rand.nextInt(((TileEntityTreasureChestEden) chest)
								.getSizeInventory()), this
								.getGuaranteedLoot(rand));
			}
		}
	}
}