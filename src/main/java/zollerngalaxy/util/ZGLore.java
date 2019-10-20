package zollerngalaxy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import zollerngalaxy.lib.helpers.ZGHelper;

public class ZGLore {
	
	private static int totalLoreBooks = 0;
	
	private static List<LoreBook> loreBooks = new ArrayList<LoreBook>();
	
	public static LoreBook BOOK_ONE;
	public static LoreBook BOOK_TWO;
	public static LoreBook BOOK_THREE;
	public static LoreBook BOOK_FOUR;
	public static LoreBook BOOK_FIVE;
	
	public static LoreBook BOOK_SIX;
	public static LoreBook BOOK_SEVEN;
	public static LoreBook BOOK_EIGHT;
	public static LoreBook BOOK_NINE;
	public static LoreBook BOOK_TEN;
	
	public static LoreBook BOOK_ELEVEN;
	public static LoreBook BOOK_TWELVE;
	public static LoreBook BOOK_THIRTEEN;
	public static LoreBook BOOK_FOURTEEN;
	public static LoreBook BOOK_FIFTEEN;
	
	public static LoreBook BOOK_SIXTEEN;
	public static LoreBook BOOK_SEVENTEEN;
	public static LoreBook BOOK_EIGHTEEN;
	public static LoreBook BOOK_NINETEEN;
	public static LoreBook BOOK_TWENTY;
	
	public static void init() {
		BOOK_ONE = createLoreBook("The Vranor",
				"The Vranor were once a militaristic race of hyper-advanced beings who ruled the galaxy.",
				"This rule ended when an unknown force " + "devolved them back to their primitive, Neanderthal-like state.",
				"Since then, they simply wander planets, building villages and offering goods to anyone who will barter.",
				"Oddly enough, they are known for their peacefulness.",
				"However, they still remain a target for many other alien races.");
		
		BOOK_TWO = createLoreBook(
				"Sentient Temperatures",
				"Magmos and Frost Giants are actually considered part of the planet itself.",
				"Magmos thrive on the scalding hot temperatures in Kriffon,",
				"while Frost Giants survive off of extreme cold on Zollus. If a Magmos gets too cold, or a Frost Giant too hot, they will die.",
				"Though sentient and very strong, they are nothing more than essentially the protectors of their planets.",
				"They do not like things that do not belong, such as the Player, or the Vranor.");
		
		BOOK_THREE = createLoreBook(
				"Constructed Planets",
				"Planets Xantheon and Atheon are artificially-constructed, genetically-spliced planets that were created by the Grays.",
				"These planets are generally void of most life, though the Grays do still inhabit them. ",
				"These worlds are typically very hostile to the Player.",
				"They also contain resources with extreme value. Constructed planets were created from asteroids, using the energy of a Dyson-sphere and arduous terraforming.",
				"These worlds ride through space until they are caught in the orbit of a star system, which they then consider home.");
		
		ZGHelper.Log("Loaded a total of " + totalLoreBooks + " lore books.");
	}
	
	public static LoreBook createLoreBook(String bookTitle, String... pages) {
		LoreBook book = new LoreBook(bookTitle);
		book.addPages(pages);
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