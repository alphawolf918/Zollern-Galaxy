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
				"This rule ended when an unknown force devolved them back to their primitive, Neanderthal-like state.",
				"Since then, they simply wander planets, building villages and offering goods to anyone who will barter.",
				"Oddly enough, they are known for their peacefulness.",
				"However, they still remain a target for many other alien races.");
		
		BOOK_TWO = ZGLore.createLoreBook(2, "Nature Beings",
				"Magmos and Frost Giants are actually considered part of the planet itself.",
				"Magmos thrive on the scalding hot temperatures in Kriffon, while Frost Giants"
						+ " survive off of extreme cold on Zollus.",
				"If a Magmos gets too cold, or a Frost Giant too hot, they will die.",
				"Though sentient and very strong, they are nothing more than essentially the protectors of their planets.",
				"They do not like things that do not belong, such as the Player, or the Vranor.");
		
		BOOK_THREE = ZGLore.createLoreBook(3, "Tech Planets",
				"Planets Xantheon and Atheon are artificial planets that were created by the Grays.",
				"The planets are generally void of most life, though the Grays do still inhabit them.",
				"These worlds are typically very hostile to the Player.", "They also contain resources with extreme value.",
				"Constructed planets were created from asteroids, "
						+ "using the energy of a Dyson sphere and arduous terraforming.",
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
		
		BOOK_SEVEN = ZGLore.createLoreBook(7, "Planet Eden", "Eden is a paradise planet in the Psios-6 system.",
				"It orbits a blue star with its three other planetary neighbors.",
				"It is a multi-biome planet with unique fauna and environmental factors.",
				"It has been hypothesized that humans actually hail from planet Eden, "
						+ "and were banished to Earth millennia ago, though the reasons remain unclear.",
				"Nevertheless, The Garden (a biome of Eden) is a lushful place, full of life and growth.");
		
		BOOK_EIGHT = ZGLore.createLoreBook(8, "Planet Zollus",
				"Zollus is a barren, icy planet, and the home of the Frost Giants.",
				"It is the furthermost planet from Psios-6.", "Many space explorers tend to begin their journies here.",
				"Not all of them survive, and those that do, simply make it on to the next harsh planet.",
				"Paradise awaits a Player that can trudge through ice and hellscape successfully.",
				"Zollus Crystals grow here, which are believed to have been formed "
						+ "from the planet's crust in its conception.",
				"They grow as plants, stemming from deep into the ground.",
				"The Heart of Zol, or Heartium, can also be found here.",
				"Zol was believed to be the first Frost Giant, and therefore the planet is named after him.");
		
		BOOK_NINE = ZGLore.createLoreBook(9, "Planet Kriffon", "Kriffon is a bright but gloomy hellscape, "
				+ "populated by volcanic entities called the Magmos.", "The metal Cobalt can be found here.",
				"The planet was named after the Kriff: "
						+ "a race of red-skinned entities that drove their planet to extinction with their rapid evolution "
						+ "and then had to escape.",
				"They are said to be a plague, conquering planet after planet within days.",
				"Kriffon is the closest to its star in the Psios-6 system.");
		
		BOOK_TEN = ZGLore.createLoreBook(10, "Planet Purgot",
				"Purgot was once believed to be a separate dimension called Purgatory.",
				"This likely comes from the name of one of its biomes, " + "with another biome being called Limbo.",
				"It is an icy planet, but it is rich with fauna.", "The primary metal here is Evenium, "
						+ "and can be found deep inside of its caves.", "Ancient astronauts used to tell stories to "
						+ "humans of how trapped souls would be sent here either to learn a lesson,"
						+ " or to await their judgment.");
		
		BOOK_ELEVEN = ZGLore.createLoreBook(11, "Planet Xathius", "Xathius is a strange but beautiful planet, "
				+ "located in the Praedyth system.", "Its colors are primarily purple and blue, "
				+ "but there are also some yellows and occasional reds thrown in there as well.",
				"Xathius is primarily known for its abundance of Promethean Ore, "
						+ "which is a very powerful metal in the creation of Star Gates.",
				"It also has some of the biggest oceans.");
		
		BOOK_TWELVE = ZGLore.createLoreBook(12, "Planet Oasis",
				"Oasis is a paradise planet located in the Praedyth system.",
				"Some adventurers have reported finding oceans of Destabilized Redstone, "
						+ "while others report simple red oceans. Its best qualities are its colors, "
						+ "and its abundance of Super Charged Coal.",
				"Some of the brightest and most vibrant sunsets and sunrises in the universe occur here.",
				"A lot of explorers even say that they believe the planet to still be growing.");
		
		BOOK_THIRTEEN = ZGLore.createLoreBook(13, "Fueltonium",
				"Fueltonium is a reactant metal that has been used inside of Big Reactors, "
						+ "and as a replacement for Uranium.", "It is believed to be a greener, cleaner alternative.",
				"It can also be melted down into a lava-like substance, " + "though its use is currently undocumented.",
				"This metal can be found on the artificially-constructed planet, Xantheon, along with Amaranth Ore.",
				"It can also be used inside of Turbines.");
		
		BOOK_FOURTEEN = ZGLore.createLoreBook(14, "Planet Candora", "Candora is considered an Exotic class planet, "
				+ "which is a rare class that is usually only found by strange means.",
				"It is often jokingly referred to as the Birthday Planet.", "It is filled with a Candy Cube landscape, "
						+ "and has an ocean comprised entirely of melted chocolate.",
				"No one knows how this is even possible.", "It usually is used as a partying planet, "
						+ "and one of celebration.", "Many sweets can be found here, as can many strange anomalies.");
		
		BOOK_FIFTEEN = ZGLore.createLoreBook(15, "Plutonium",
				"Plutonium, often used in Turbines, can be found on planet Xantheon.",
				"It is a rare commodity amongst space traders due to its secrecy.",
				"It also is used in the crafting of a Star Gate to get to planet Atheon, "
						+ "where the super-metal Zollernium can be found.");
		
		BOOK_SIXTEEN = ZGLore.createLoreBook(16, "Ayanna's Father", "Ayanna called to her father in the stars, "
				+ "but alas he could not hear her.",
				"He was entranced at the beauty of what he saw, " + "and what he felt.",
				"\"There are so many of them,\" he had said to his daughter.",
				"\"I think I'll go into one now, for I am tired, my dear.\"",
				"After that, he had vanished into a peaceful slumber.",
				"Legend says that Ayanna still searches for her father in the stars, "
						+ "and that one day, she hopes to bring him home.");
		
		BOOK_SEVENTEEN = ZGLore.createLoreBook(17, "Dark Galaxy",
				"The Dark Galaxy is rumored to be at the center of the universe, "
						+ "destroying or corrupting all things that it touches.",
				"Legend tells of adventurers that made it to this place, "
						+ "but when they came back, they were somehow...different.",
				"They looked, sounded, acted differently, "
						+ "as if they were given a task or some menacing purpose to fulfill.",
				"It's said that they serve whoever or whatever is inside of that galaxy: sentient dark matter.");
		
		BOOK_EIGHTEEN = ZGLore.createLoreBook(18, "Ayanna's Moon", "The moon spoke to Ayanna. It said sweet things to her.",
				"In that moment, she thought, maybe, it was her father; "
						+ "that he was still alive. But she had given that hope up long ago.",
				"She used to look at the moon with such reverence, " + "but now she only feels spite.",
				"She wonders how much of her memory is real, and how much of it a fantasy.",
				"She grabs the crystal on her necklace and says, \"I'm going to find out.\"");
		
		BOOK_NINETEEN = ZGLore.createLoreBook(19, "Star Queen", "Ayanna's search ended bitterly, "
				+ "for she did not find her father.", "Instead, she came face-to-face with the Dark Galaxy: "
				+ "a whole cluster of dark-matter stars.", "They corrupted and changed her into something else.",
				"She no longer went by Ayanna anymore, but by Mytra, the Star Queen.", "Every fifty years, "
						+ "she ventures out of her galaxy to dispatch " + "darkness across the universe.",
				"When an adventurer finds it, they too are transformed, "
						+ "and they spread her will around even further. These are the Agents of Darkness.");
		
		BOOK_TWENTY = ZGLore.createLoreBook(20, "Planet Caligro", "Caligro was once a paradise planet like Oasis.",
				"It was full of beautiful, vibrant colors, "
						+ "carving its own path in the universe as one of its most beautiful planets.",
				"But, something had occurred on this planet.", "The darkness had consumed it entirely.",
				"It was no longer a place of beauty, but of death and gloom.",
				"Its old name was Forma, named for its beauty.", "But now... Now it brought death to all who set "
						+ "foot upon it.", "It is one of the few worlds where the Dark Agents have succeeded.");
		
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