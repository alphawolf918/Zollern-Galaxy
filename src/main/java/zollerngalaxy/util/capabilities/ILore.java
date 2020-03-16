/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util.capabilities;

import java.util.List;
import zollerngalaxy.util.LoreBook;

public interface ILore {
	
	public void addLoreBook(LoreBook book);
	
	public boolean hasLoreBook(LoreBook book);
	
	public List<Integer> getLoreBooks();
	
}