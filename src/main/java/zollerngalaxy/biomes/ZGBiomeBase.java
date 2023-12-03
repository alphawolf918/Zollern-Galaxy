/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.biomes;

import micdoodle8.mods.galacticraft.api.world.BiomeGenBaseGC;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import zollerngalaxy.core.enums.EnumBiomeTypeZG;

public class ZGBiomeBase extends BiomeGenBaseGC {
	
	protected TempCategory tempBiomeCtg = TempCategory.COLD;
	protected EnumBiomeTypeZG biomeType = EnumBiomeTypeZG.SPACE;
	
	protected boolean hasMutation = false;
	protected boolean enableSnow = false;
	protected int waterColor = 0x0000ff;
	protected int foliageColor = 0x00ff00;
	protected int grassColor = 0x00ff00;
	protected int skyColor = 0x0099ff;
	protected float temp = 0.0F;
	protected int BIOME_HEIGHT = 72;
	
	private String singleName = "";
	
	protected Block stoneBlock;
	
	public ZGBiomeBase(BiomeProperties properties) {
		super(properties, true);
		this.clearAllSpawning();
		ZGBiomes.biomeList.add(this);
	}
	
	public ZGBiomeBase(String singleName, BiomeProperties properties) {
		this(properties);
		this.singleName = singleName;
	}
	
	public ZGBiomeBase(String singleName) {
		this(new BiomeProperties(singleName));
	}
	
	/**
	 * Set ChunkProvider height for this biome.
	 * 
	 * @param biomeHeight
	 *            The height value.
	 * @return Instance of Biome.
	 */
	public Biome setBiomeHeight(int biomeHeight) {
		this.BIOME_HEIGHT = biomeHeight;
		return this;
	}
	
	/**
	 * Get ChunkProvider height for the requested biome.
	 * 
	 * @return
	 */
	public int getBiomeHeight() {
		return this.BIOME_HEIGHT;
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
	
	public Biome setGrassAndFoliageColor(int par1FoliageColor, int par2GrassColor) {
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
		return this.hasMutation;
	}
	
	public Biome setHasMutation(boolean isMutated) {
		this.hasMutation = isMutated;
		return this;
	}
	
	public Biome clearAllSpawning() {
		this.clearAllNonMonsterSpawning();
		this.clearMonsterSpawning();
		return this;
	}
	
	public Biome clearAllNonMonsterSpawning() {
		this.clearCreatureSpawning();
		this.clearCaveCreatureSpawning();
		this.clearWaterSpawning();
		return this;
	}
	
	public Biome clearCreatureSpawning() {
		this.spawnableCreatureList.clear();
		return this;
	}
	
	public Biome clearCaveCreatureSpawning() {
		this.spawnableCaveCreatureList.clear();
		return this;
	}
	
	public Biome clearWaterSpawning() {
		this.spawnableWaterCreatureList.clear();
		return this;
	}
	
	public Biome clearMonsterSpawning() {
		this.spawnableMonsterList.clear();
		return this;
	}
	
	/**
	 * Completely prevents rain in this biome.
	 * 
	 * @param props
	 * @return
	 */
	public Biome setNoRain(Biome.BiomeProperties props) {
		props.setRainfall(0.0F);
		props.setRainDisabled();
		return this;
	}
	
	/**
	 * Set top and bottom blocks as the same block.
	 * 
	 * @param block
	 * @return
	 */
	public Biome setBlocks(Block block) {
		this.setBlocks(block, block);
		return this;
	}
	
	/**
	 * Set top and bottom blocks for this biome.
	 * 
	 * @param topBlock
	 * @param fillerBlock
	 * @return
	 */
	public Biome setBlocks(Block topBlock, Block fillerBlock) {
		this.setTopBlock(topBlock);
		this.setFillerBlock(fillerBlock);
		return this;
	}
	
	/**
	 * Set bottom block for this biome.
	 * 
	 * @param b
	 * @return
	 */
	public Biome setFillerBlock(Block b) {
		this.fillerBlock = b.getDefaultState();
		return this;
	}
	
	/**
	 * Get bottom block for this biome.
	 * 
	 * @return
	 */
	public Block getFillerBlock() {
		return this.fillerBlock.getBlock();
	}
	
	/**
	 * Set top block for this biome.
	 * 
	 * @param b
	 * @return
	 */
	public Biome setTopBlock(Block b) {
		this.topBlock = b.getDefaultState();
		return this;
	}
	
	/**
	 * Get the top block for this biome.
	 * 
	 * @return
	 */
	public Block getTopBlock() {
		return this.topBlock.getBlock();
	}
	
	/**
	 * Set the stone block for this biome. Should be the same for all biomes on a planet, but
	 * sometimes the
	 * inheritance doesn't work correctly.
	 * 
	 * @param b
	 * @return
	 */
	public Biome setStoneBlock(Block b) {
		this.stoneBlock = b;
		return this;
	}
	
	/**
	 * Get the stone block for this biome. Should be the same for all biomes on a planet, but
	 * sometimes the inheritance doesn't work correctly.
	 * 
	 * @return
	 */
	public Block getStoneBlock() {
		return this.stoneBlock;
	}
	
	public Biome setTempCategory(TempCategory tc) {
		this.tempBiomeCtg = tc;
		return this;
	}
	
	@Override
	public TempCategory getTempCategory() {
		return this.tempBiomeCtg;
	}
	
	/**
	 * Get what type of Biome this is.
	 * Used for conditional operations.
	 * 
	 * @return Biome Type
	 */
	public EnumBiomeTypeZG getBiomeType() {
		return this.biomeType;
	}
	
	/**
	 * Set Biome Type for Biome.
	 * Used for conditional operations.
	 * 
	 * @param t
	 *            Biome Type
	 * @return Biome
	 */
	public Biome setBiomeType(EnumBiomeTypeZG t) {
		this.biomeType = t;
		return this;
	}
}