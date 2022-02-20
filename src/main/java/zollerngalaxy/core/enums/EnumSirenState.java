/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from,
 * but do not claim it as your own, and
 * do not redistribute it.
 */
package zollerngalaxy.core.enums;

public enum EnumSirenState {
	
	OFF(0), ON(1);
	
	private EnumSirenState st;
	private int intState;
	
	private EnumSirenState(int st) {
		intState = st;
	}
	
	private EnumSirenState(EnumSirenState st) {
		this.st = st;
	}
	
	public void setState(int st) {
		intState = st;
	}
	
	public void setState(EnumSirenState st) {
		this.st = st;
	}
	
	public int getState() {
		return intState;
	}
	
	public EnumSirenState getActualState() {
		return st;
	}
}