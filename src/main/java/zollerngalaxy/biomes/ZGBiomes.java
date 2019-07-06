package zollerngalaxy.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import java.util.LinkedList;
import java.util.List;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGBiomes {
	
	public static final List<BiomeGenBaseGC> biomeList = new LinkedList<>();
	
	public static Biome ZOLLUS = new ZGBiomeBase("zollus", new BiomeProperties(
			"Zollus").setRainfall(0.0F));
	
	public static void init() {
		ZGBiomes.addBiome(ZGBiomes.ZOLLUS, COLD, DEAD, DRY);
	}
	
	private static void addBiome(Biome biome, BiomeDictionary.Type... biomeType) {
		CommonZGRegisterHelper.registerBiome(biome);
		CommonZGRegisterHelper.registerBiomeType(biome, biomeType);
	}
	
}