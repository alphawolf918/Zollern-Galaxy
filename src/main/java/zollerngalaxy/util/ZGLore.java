package zollerngalaxy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGLore {
	
	private static int totalLoreBooks = 0;
	
	private static List<LoreBook> loreBooks = new ArrayList<LoreBook>();
	
	public static LoreBook BOOK_ONE;
	
	public static void init() {
		BOOK_ONE = createLoreBook(
				"The Vranor",
				"The Vranor (now known simply as \"Alien Villagers\") were once a militaristic race of hyper-advanced beings who ruled the galaxy. ",
				"This rule ended when an unknown force " + "devolved them back to their primitive, Neanderthal-like state. ",
				"Since then, they simply wander planets, building villages and offering goods to anyone who will barter. ",
				"Oddly enough, they are known for their peacefulness. ",
				"However, they still remain a target for many other alien races.");
		ZGHelper.Log("Loaded a total of " + totalLoreBooks + " lore books.");
	}
	
	public static LoreBook createLoreBook(String bookTitle, String... pages) {
		LoreBook book = new LoreBook(bookTitle);
		for (String p : pages) {
			book.addPage(p);
		}
		registerLoreBook(book);
		totalLoreBooks++;
		return book;
	}
	
	public static void registerLoreBook(LoreBook book) {
		loreBooks.add(book);
	}
	
	public static List<LoreBook> getLoreBooks() {
		return loreBooks;
	}
	
	public static LoreBook getRandomLoreBook() {
		Random rand = new Random();
		int randNum = rand.nextInt(loreBooks.size());
		LoreBook book = loreBooks.get(randNum);
		loreBooks.remove(randNum);
		return book;
	}
}