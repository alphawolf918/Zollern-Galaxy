package galaxymod.biomes.decorators;

import net.minecraft.world.World;
import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;

public class BiomeDecoratorNova extends BiomeDecoratorSpace {

	protected World worldObj;

	@Override
	protected void decorate() {
		
	}

	@Override
	protected void setCurrentWorld(World world) {
		this.worldObj = world;
	}

	@Override
	protected World getCurrentWorld() {
		return this.worldObj;
	}
}