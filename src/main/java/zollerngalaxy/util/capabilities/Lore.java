/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
package zollerngalaxy.util.capabilities;

import java.util.ArrayList;
import java.util.List;
import zollerngalaxy.util.LoreBook;

public class Lore implements ILore {
	
	List<Integer> bookList = new ArrayList<Integer>();
	
	@Override
	public void addLoreBook(LoreBook book) {
		bookList.add(book.getBookID());
	}
	
	@Override
	public boolean hasLoreBook(LoreBook book) {
		bookList.contains(book.getBookID());
		return false;
	}
	
	@Override
	public List<Integer> getLoreBooks() {
		return bookList;
	}
	
}