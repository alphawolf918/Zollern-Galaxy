package zollerngalaxy.core.enums;

public enum EnumOreGenZG {
	
	COAL(17, 20, 0, 128), IRON(11, 20, 0, 64), GOLD(16, 6, 0, 32), REDSTONE(8, 8, 0, 16), LAPIS(7,
			1, 16, 16), DIAMOND(8, 4, 0, 16), EMERALD(2, 4, 0, 10), HEARTIUM(10, 5, 0, 16), VIRINIUM(
			10, 7, 0, 20), EVENIUM(5, 6, 0, 12), DESH(4, 15, 0, 32), METEORIC_IRON(4, 13, 0, 32), DIRT(
			4, 10, 0, 256), PACKED_ICE(53, 20, 0, 256), MAGMA(53, 35, 0, 256), GRAVEL(33, 8, 0, 256), SILICON(
			7, 3, 0, 25), ALUMINUM(7, 18, 0, 45), TIN(7, 22, 0, 60), COPPER(7, 24, 0, 75), SILVER(
			5, 16, 0, 42), LEAD(4, 20, 0, 36), NICKLE(4, 14, 0, 26), COBALT(5, 14, 0, 24), STEEL(6,
			15, 0, 32), BRONZE(4, 4, 0, 20), INVAR(4, 4, 0, 14), ELECTRUM(4, 4, 0, 10), PLATINUM(2,
			2, 0, 12);
	
	private int genCount;
	private int blockCount;
	private int minHeight;
	private int maxHeight;
	
	private EnumOreGenZG(int genCount, int blockCount, int minHeight, int maxHeight) {
		this.genCount = genCount;
		this.blockCount = blockCount;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
	}
	
	public int getGenCount() {
		return this.genCount;
	}
	
	public int getBlockCount() {
		return this.blockCount;
	}
	
	public int getMinHeight() {
		return this.minHeight;
	}
	
	public int getMaxHeight() {
		return this.maxHeight;
	}
}