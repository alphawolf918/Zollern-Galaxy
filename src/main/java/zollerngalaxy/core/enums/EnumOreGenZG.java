/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumOreGenZG {
	
	F(0, 0, 0, 0),
	COAL(15, 15, 0, 128),
	IRON(18, 10, 0, 128),
	QUARTZ(16, 10, 0, 46),
	CERTUS_QUARTZ(10, 6, 0, 36),
	FLUIX(5, 4, 0, 24),
	GOLD(14, 6, 0, 41),
	REDSTONE(8, 8, 0, 26),
	LAPIS(7, 5, 11, 26),
	DIAMOND(8, 4, 0, 16),
	EMERALD(4, 4, 0, 12),
	SAPPHIRE(14, 6, 0, 32),
	RUBY(18, 4, 0, 36),
	HEARTIUM(10, 4, 0, 16),
	VIRINIUM(10, 4, 0, 20),
	EVENIUM(5, 4, 0, 12),
	DESH(4, 5, 0, 32),
	METEORIC_IRON(4, 11, 0, 32),
	DIRT(16, 16, 0, 128),
	SAND(16, 14, 0, 128),
	STONE(20, 15, 0, 128),
	CANDY(35, 10, 0, 128),
	SWEET(15, 10, 0, 128),
	PACKED_ICE(32, 15, 0, 128),
	MAGMA(15, 15, 0, 128),
	BLAZE(11, 5, 0, 56),
	GRAVEL(21, 8, 0, 128),
	SILICON(7, 3, 0, 25),
	ALUMINUM(11, 4, 0, 70),
	TIN(11, 4, 0, 70),
	COPPER(11, 8, 0, 75),
	SILVER(5, 5, 0, 42),
	LEAD(6, 10, 0, 36),
	NICKEL(8, 5, 0, 36),
	COBALT(5, 4, 0, 24),
	STEEL(9, 6, 0, 32),
	BRONZE(6, 6, 0, 24),
	INVAR(8, 6, 0, 24),
	ELECTRUM(6, 6, 0, 24),
	PLATINUM(4, 4, 0, 24),
	SHINIUM(15, 4, 0, 44),
	PROMETHEAN(4, 4, 0, 45),
	OBSIDIAN(20, 25, 0, 45),
	SUPER_CHARGED_COAL(8, 15, 0, 35),
	PLUTONIUM(6, 5, 0, 15),
	SHINESTONE(15, 15, 10, 52),
	FUELTONIUM(5, 4, 0, 17),
	AMARANTH(11, 4, 0, 27),
	CONSTRUCTED(16, 10, 0, 128),
	AZURITE(11, 10, 0, 47),
	ZOLLERNIUM(15, 4, 0, 16),
	ZANIUM(13, 2, 0, 64),
	RADITE(8, 4, 0, 34),
	ZOGITE(8, 4, 0, 24),
	VIBRANIUM(8, 5, 0, 62),
	ZINC(16, 4, 0, 26),
	SPECIAL_STONE(20, 10, 0, 32),
	PRISMARINE(15, 10, 0, 74),
	RHODIUM(6, 4, 0, 20),
	RADIUM(10, 4, 0, 15),
	POWER_GEM(16, 4, 0, 36);
	
	private int genCount = 5;
	private int blockCount = 4;
	private int minHeight = 0;
	private int maxHeight = 64;
	
	/**
	 * Set generation chance percentage, amount of blocks to spawn, minimum height, and maximum
	 * height.
	 */
	private EnumOreGenZG(int genCount, int blockCount, int minHeight, int maxHeight) {
		this.genCount = genCount;
		this.blockCount = blockCount;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	
	/**
	 * Set gen percentage, block count, min height and max height.
	 * 
	 * @param genCount
	 * @param blockCount
	 * @param minHeight
	 * @param maxHeight
	 * @return
	 */
	public EnumOreGenZG FactoryOreGen(int genCount, int blockCount, int minHeight, int maxHeight) {
		this.setGenCount(genCount);
		this.setBlockCount(blockCount);
		this.setMinHeight(minHeight);
		this.setMaxHeight(maxHeight);
		return this;
	}
	
	/**
	 * Set gen percentage, block count and max height.
	 * 
	 * @param genCount
	 * @param blockCount
	 * @param minMaxHeight
	 * @return
	 */
	public EnumOreGenZG FactoryOreGen(int genCount, int blockCount, int minMaxHeight) {
		this.setGenCount(genCount);
		this.setBlockCount(blockCount);
		this.setMinMaxHeight(minMaxHeight);
		return this;
	}
	
	/**
	 * Get spawn generation percentage.
	 * 
	 * @return
	 */
	public int getGenCount() {
		return this.genCount;
	}
	
	/**
	 * Get amount of blocks allowed to spawn per vein.
	 * 
	 * @return
	 */
	public int getBlockCount() {
		return this.blockCount;
	}
	
	/**
	 * Get the min height for this ore to spawn.
	 * 
	 * @return
	 */
	public int getMinHeight() {
		return this.minHeight;
	}
	
	/**
	 * Get the max height for this ore to spawn.
	 * 
	 * @return
	 */
	public int getMaxHeight() {
		return this.maxHeight;
	}
	
	/**
	 * Set generation precentage.
	 * 
	 * @param genCount
	 * @return
	 */
	public int setGenCount(int genCount) {
		this.blockCount = genCount;
		return genCount;
	}
	
	/**
	 * Set minimum spawn height.
	 * 
	 * @param minHeight
	 * @return
	 */
	public int setMinHeight(int minHeight) {
		this.minHeight = minHeight;
		return minHeight;
	}
	
	/**
	 * Set maximum spawn height.
	 * 
	 * @param maxHeight
	 * @return
	 */
	public int setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
		return maxHeight;
	}
	
	/**
	 * Set minimum AND maximum spawn height.
	 * 
	 * @param minHeight
	 * @param maxHeight
	 */
	public void setMinMaxHeight(int minHeight, int maxHeight) {
		this.setMaxHeight(maxHeight);
		this.setMinHeight(minHeight);
	}
	
	/**
	 * Set minimum AND maximum spawn height.
	 * 
	 * @param minMax
	 */
	public void setMinMaxHeight(int minMax) {
		this.setMinMaxHeight(minMax, minMax);
	}
	
	/**
	 * Set max amount of blocks to spawn per vein.
	 * 
	 * @param countBlock
	 * @return
	 */
	public int setBlockCount(int countBlock) {
		this.blockCount = countBlock;
		return blockCount;
	}
	
	/**
	 * Instance of EnumOreGenZG.
	 * 
	 * @return An instance of EnumOreGenZG.
	 */
	public EnumOreGenZG instance() {
		return this;
	}
}