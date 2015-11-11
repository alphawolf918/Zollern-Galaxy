package galaxymod.biomes.decorators;

import micdoodle8.mods.galacticraft.api.prefab.world.gen.BiomeDecoratorSpace;
import net.minecraft.world.World;

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