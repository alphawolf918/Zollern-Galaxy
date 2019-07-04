package zollerngalaxy.core.enums;

public enum EnumPlanetClass {
	
	D("D"), H("H"), J("J"), K("K"), L("L"), M("M"), N("N"), R("R"), T("T"), Y(
			"Y"), NINE("9");
	
	private EnumPlanetClass planetClass;
	private String planetClassStr;
	
	private EnumPlanetClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	private EnumPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
	}
	
	public void setPlanetStrClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	public void setPlanetClass(EnumPlanetClass pClass) {
		this.planetClass = pClass;
	}
	
	public String getPlanetStrClass() {
		return this.planetClassStr;
	}
	
	public EnumPlanetClass getPlanetClass() {
		return this.planetClass;
	}
}