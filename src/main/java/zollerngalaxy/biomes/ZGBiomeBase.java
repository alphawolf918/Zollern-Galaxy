package zollerngalaxy.biomes;

import static net.minecraftforge.common.BiomeDictionary.Type.COLD;
import static net.minecraftforge.common.BiomeDictionary.Type.DEAD;
import static net.minecraftforge.common.BiomeDictionary.Type.DRY;
import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import zollerngalaxy.lib.helpers.CommonZGRegisterHelper;

public class ZGBiomeBase extends BiomeGenBaseGC {
	
	protected TempCategory tempBiomeCtg = TempCategory.COLD;
	protected boolean hasMutation = false;
	protected boolean enableSnow = false;
	protected int waterColor = 0x0000ff;
	protected int foliageColor = 0x00ff00;
	protected int grassColor = 0x00ff00;
	protected int skyColor = 0x0099ff;
	private String singleName = "";
	
	public ZGBiomeBase(BiomeProperties properties) {
		super(properties, true);
		ZGBiomes.biomeList.add(this);
	}
	
	public ZGBiomeBase(String singleName, BiomeProperties properties) {
		this(properties);
		this.singleName = singleName;
	}
	
	@Override
	public void registerTypes(Biome biome) {
		if (this.singleName.equals("diona")) {
			CommonZGRegisterHelper.registerBiomeType(biome, COLD, DEAD, DRY);
		}
	}
	
	public Biome setSkyColor(int par1SkyColor) {
		this.skyColor = par1SkyColor;
		return this;
	}
	
	@Override
	public int getSkyColorByTemp(float temp) {
		return this.skyColor;
	}
	
	public Biome setGrassAndFoliageColor(int par1FoliageGrassColor) {
		this.setFoliageColor(par1FoliageGrassColor);
		this.setGrassColor(par1FoliageGrassColor);
		return this;
	}
	
	public Biome setGrassAndFoliageColor(int par1FoliageColor,
			int par2GrassColor) {
		this.setFoliageColor(par1FoliageColor);
		this.setGrassColor(par2GrassColor);
		return this;
	}
	
	public Biome setGrassColor(int par1GrassColor) {
		this.grassColor = par1GrassColor;
		return this;
	}
	
	@Override
	public int getGrassColorAtPos(BlockPos pos) {
		return this.grassColor;
	}
	
	public Biome setFoliageColor(int par1FoliageColor) {
		this.foliageColor = par1FoliageColor;
		return this;
	}
	
	@Override
	public int getFoliageColorAtPos(BlockPos pos) {
		return this.foliageColor;
	}
	
	public Biome setEnableSnow(boolean shouldSnow) {
		this.enableSnow = shouldSnow;
		return this;
	}
	
	@Override
	public boolean getEnableSnow() {
		return this.enableSnow;
	}
	
	public Biome setWaterColor(int par1WaterColor) {
		this.waterColor = par1WaterColor;
		return this;
	}
	
	@Override
	public int getWaterColorMultiplier() {
		return this.waterColor;
	}
	
	@Override
	public boolean isMutation() {
		return hasMutation;
	}
	
	public Biome setHasMutation(boolean isMutated) {
		this.hasMutation = isMutated;
		return this;
	}
	
	public Biome clearAllSpawning() {
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		return this;
	}
	
	public Biome clearAllNonMonsterSpawning() {
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		return this;
	}
	
	public Biome setNoRain(Biome.BiomeProperties props) {
		props.setRainfall(0.0F);
		props.setRainDisabled();
		return this;
	}
	
	public Biome setBlocks(Block block) {
		this.setBlocks(block, block);
		return this;
	}
	
	public Biome setBlocks(Block topBlock, Block fillerBlock) {
		this.setTopBlock(topBlock);
		this.setFillerBlock(fillerBlock);
		return this;
	}
	
	public Biome setFillerBlock(Block b) {
		this.fillerBlock = b.getDefaultState();
		return this;
	}
	
	public Block getFillerBlock() {
		return this.fillerBlock.getBlock();
	}
	
	public Biome setTopBlock(Block b) {
		this.topBlock = b.getDefaultState();
		return this;
	}
	
	public Block getTopBlock() {
		return this.topBlock.getBlock();
	}
	
	public Biome setTempCategory(TempCategory tc) {
		this.tempBiomeCtg = tc;
		return this;
	}
	
	@Override
	public TempCategory getTempCategory() {
		return this.tempBiomeCtg;
	}
	
	public static enum Type {
		NORMAL, EXTRA_TREES, MUTATED, HILLS;
	}
	
}