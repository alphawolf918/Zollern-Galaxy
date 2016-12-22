/*******************************************************************************
 * Copyright 2016 Zollern Wolf
 * - Zollern Galaxy
 * Galacticraft Add-On Mod
 * You CAN:
 * - Learn from it
 * - Use it to get ideas and concepts
 * You CAN'T:
 * - Redistribute it
 * - Claim it as your own
 * Steve Kung's "More Planets" mod was a big help.
 *******************************************************************************/

package galaxymod.worldgen.zollus;

import galaxymod.blocks.BlockList;
import galaxymod.mobs.entities.zollus.EntityFrostGiant;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenZolnium extends WorldGenerator {
	
	private Block field_150552_a;
	private int field_150551_b;
	private static final String __OBFID = "CL_00000410";
	boolean frostGiantSpawned = false;
	
	public WorldGenZolnium() {
		this.field_150552_a = BlockList.zolniumCrystals;
		this.frostGiantSpawned = false;
	}
	
	public void func_150550_a(Block p_150550_1_, int p_150550_2_) {
		this.field_150552_a = p_150550_1_;
		this.field_150551_b = p_150550_2_;
	}
	
	@Override
	public boolean generate(World currentWorld, Random p_76484_2_,
			int p_76484_3_, int p_76484_4_, int p_76484_5_) {
		for (int l = 0; l < 64; ++l) {
			int x = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
			int y = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
			int z = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
			
			if (currentWorld.isAirBlock(x, y, z)
					&& (!currentWorld.provider.hasNoSky || y < 255)
					&& this.field_150552_a.canBlockStay(currentWorld, x, y, z)) {
				currentWorld.setBlock(x, y, z, this.field_150552_a,
						this.field_150551_b, 2);
				if (!frostGiantSpawned) {
					EntityFrostGiant frostGiant = new EntityFrostGiant(
							currentWorld);
					frostGiant.setLocationAndAngles(x, y, z,
							frostGiant.rotationYaw, frostGiant.rotationPitch);
					currentWorld.spawnEntityInWorld(frostGiant);
					frostGiantSpawned = true;
				}
			}
		}
		return true;
	}
	
}