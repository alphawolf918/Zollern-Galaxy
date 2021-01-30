/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumBodyClass {
	
	D("D"),
	H("H"),
	J("J"),
	K("K"),
	L("L"),
	M("M"),
	N("N"),
	R("R"),
	T("T"),
	Y("Y"),
	NINE("9"),
	EXOTIC("Exotic"),
	ABANDONED("Abandoned"),
	CONSTRUCTED("Constructed"),
	DESERT("Desert"),
	OCEAN("Ocean"),
	DARK("Dark");
	
	private EnumBodyClass planetClass;
	private String planetClassStr;
	
	private EnumBodyClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	private EnumBodyClass(EnumBodyClass pClass) {
		this.planetClass = pClass;
	}
	
	public void setPlanetStrClass(String strClass) {
		this.planetClassStr = strClass;
	}
	
	public void setPlanetClass(EnumBodyClass pClass) {
		this.planetClass = pClass;
	}
	
	public String getPlanetStrClass() {
		return this.planetClassStr;
	}
	
	public EnumBodyClass getPlanetClass() {
		return this.planetClass;
	}
}