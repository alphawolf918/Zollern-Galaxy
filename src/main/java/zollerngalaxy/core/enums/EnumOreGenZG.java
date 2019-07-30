package zollerngalaxy.core.enums;

public enum EnumOreGenZG {
	
	COAL(15, 20, 0, 256), IRON(11, 20, 0, 70), GOLD(16, 6, 0, 41), REDSTONE(11, 10, 0, 26), LAPIS(
			7, 7, 16, 26), DIAMOND(8, 4, 0, 16), EMERALD(4, 6, 0, 12), HEARTIUM(10, 8, 0, 16), VIRINIUM(
			10, 7, 0, 20), EVENIUM(5, 6, 0, 12), DESH(4, 15, 0, 32), METEORIC_IRON(4, 13, 0, 32), DIRT(
			20, 20, 0, 256), PACKED_ICE(53, 20, 0, 256), MAGMA(53, 35, 0, 256), GRAVEL(33, 8, 0,
			256), SILICON(7, 3, 0, 25), ALUMINUM(11, 18, 0, 70), TIN(11, 22, 0, 70), COPPER(11, 24,
			0, 75), SILVER(5, 16, 0, 42), LEAD(4, 20, 0, 36), NICKLE(8, 14, 0, 36), COBALT(5, 14,
			0, 24), STEEL(9, 15, 0, 32), BRONZE(6, 6, 0, 24), INVAR(8, 6, 0, 24), ELECTRUM(6, 6, 0,
			24), PLATINUM(4, 4, 0, 24);
	
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