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
		BOOK_ONE = ZGLore.createLoreBook(1, "The Vranor",
				"The Vranor were once a militaristic race of hyper-advanced beings who ruled the galaxy.",
				"This rule ended when an unknown force " + "devolved them back to their primitive, Neanderthal-like state.",
				"Since then, they simply wander planets, building villages and offering goods to anyone who will barter.",
				"Oddly enough, they are known for their peacefulness.",
				"However, they still remain a target for many other alien races.");
		
		BOOK_TWO = ZGLore.createLoreBook(2, "Sentient Temperatures",
				"Magmos and Frost Giants are actually considered part of the planet itself.",
				"Magmos thrive on the scalding hot temperatures in Kriffon,",
				"while Frost Giants survive off of extreme cold on Zollus. If a Magmos gets too cold, or a "
						+ "Frost Giant too hot, they will die.",
				"Though sentient and very strong, they are nothing more than essentially the protectors of their planets.",
				"They do not like things that do not belong, such as the Player, or the Vranor.");
		
		BOOK_THREE = ZGLore.createLoreBook(3, "Constructed Planets",
				"Planets Xantheon and Atheon are artificially-constructed, "
						+ "genetically-spliced planets that were created by the Grays.",
				"These planets are generally void of most life, " + "though the Grays do still inhabit them. ",
				"These worlds are typically very hostile to the Player.",
				"They also contain resources with extreme value. Constructed planets were created from asteroids, "
						+ " using the energy of a Dyson-sphere and arduous terraforming.",
				"These worlds ride through space until they are caught in the orbit of a star system, "
						+ "which they then consider home.");
		
		BOOK_FOUR = ZGLore.createLoreBook(4, "The Grays", "The Grays are a race of extraterrestrials "
				+ "from an unknown dimension.", "They are incredibly smart, and though not hostile, "
				+ " they should be considered enemies to the Player.",
				"One day, they will rise up and begin their attempt to rule the galaxy.",
				"They employ their robotic workers, the Galactic Sentry Guards, to protect "
						+ "themselves from external dangers.", "It is believed that the Grays visited Earth long ago, "
						+ "and actually interfered with human DNA, intertwining their own with a "
						+ "primitive version of our own species.",
				"The question raises, then - if they created us, who, or what, created them?");
		
		BOOK_FIVE = ZGLore.createLoreBook(5, "Super Charged Coal",
				"Super Charged Coal is a version of regular Coal that has been amplified by the elements found in the planet's core, "
						+ "causing them to retain a temporary, electric current.",
				"This enables a single piece of Super Charged Coal to burn at twice the rate as a regular piece of Coal.",
				"It can therefore smelt twice as much and last twice as long.",
				"It was first encountered on the planet Oasis by ancient cavemen,"
						+ " who then created their civilization's first fire using Super Charged Coal.",
				"Due to the electric current, these cavemen received a drastic boost in their intelligence, "
						+ "and began evolving rapidly, leaving their star system and "
						+ "exploring others within under 100 years.",
				"It is unknown what they were called or where they are now.");
		
		BOOK_SIX = ZGLore.createLoreBook(6, "Star Gates",
				"Star Gates are a method of traveling vast distances of space almost instantaneously.",
				"Each Star Gate is specifically bound to two different worlds,"
						+ " and only two (e.g. Planet A and Planet B, or moons).",
				"If used on Planet/Moon A, the Player will be transported to Planet/Moon B.",
				"If used on Planet/Moon B, or anywhere else in the universe, the Player is transported"
						+ " back to Planet/Moon A.", "Each one has a specific protocol that it follows - "
						+ "that protocol being those two worlds, or moons.",
				"They were invented by an Earth scientist that spliced the DNA "
						+ "of a captured Gray into human technology, making more advances possible.");
		
		ZGHelper.Log("Loaded a total of " + totalLoreBooks + " lore books.");
	}
	
	public static LoreBook createLoreBook(int bookID, String bookTitle, String... pages) {
		LoreBook book = new LoreBook(bookID, bookTitle);
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