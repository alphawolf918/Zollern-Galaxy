package zollerngalaxy.core.enums;

public enum EnumOreGenZG {
	
	COAL(17, 20, 0, 128), IRON(9, 20, 0, 64), GOLD(16, 6, 0, 32), REDSTONE(8,
			8, 0, 16), LAPIS(7, 1, 16, 16), DIAMOND(8, 4, 0, 16), HEARTIUM(10,
			5, 0, 16), VIRINIUM(10, 7, 0, 20), EVENIUM(5, 6, 0, 12), DESH(4,
			15, 0, 32), METEORIC_IRON(2, 10, 0, 32), DIRT(33, 10, 0, 256), PACKED_ICE(
			53, 20, 0, 256), MAGMA(65, 35, 0, 256), GRAVEL(33, 8, 0, 256), SILICON(
			7, 3, 0, 25), ALUMINUM(7, 18, 0, 45), TIN(7, 22, 0, 60), COPPER(7,
			24, 0, 75), COBALT(5, 14, 0, 24);
	
	private int genCount;
	private int blockCount;
	private int minHeight;
	private int maxHeight;
	
	private EnumOreGenZG(int genCount, int blockCount, int minHeight,
			int maxHeight) {
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