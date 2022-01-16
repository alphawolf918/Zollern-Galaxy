/**
 * Zollern Galaxy by @author Zollern Wolf
 * Copyright 2016 - 2025
 * You may use this code to learn from, but do not
 * claim it as your own, and do not
 * redistribute it.
 */
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
	
	public static LoreBook BOOK_TWENTYONE;
	public static LoreBook BOOK_TWENTYTWO;
	public static LoreBook BOOK_TWENTYTHREE;
	public static LoreBook BOOK_TWENTYFOUR;
	public static LoreBook BOOK_TWENTYFIVE;
	
	public static LoreBook BOOK_TWENTYSIX;
	public static LoreBook BOOK_TWENTYSEVEN;
	public static LoreBook BOOK_TWENTYEIGHT;
	public static LoreBook BOOK_TWENTYNINE;
	public static LoreBook BOOK_THIRTY;
	
	public static LoreBook BOOK_THIRTYONE;
	public static LoreBook BOOK_THIRTYTWO;
	public static LoreBook BOOK_THIRTYTHREE;
	public static LoreBook BOOK_THIRTYFOUR;
	public static LoreBook BOOK_THIRTYFIVE;
	
	public static LoreBook BOOK_THIRTYSIX;
	public static LoreBook BOOK_THIRTYSEVEN;
	public static LoreBook BOOK_THIRTYEIGHT;
	public static LoreBook BOOK_THIRTYNINE;
	public static LoreBook BOOK_FOURTY;
	
	public static LoreBook BOOK_FOURTYONE;
	public static LoreBook BOOK_FOURTYTWO;
	public static LoreBook BOOK_FOURTYTHREE;
	public static LoreBook BOOK_FOURTYFOUR;
	public static LoreBook BOOK_FOURTYFIVE;
	
	public static LoreBook BOOK_FOURTYSIX;
	public static LoreBook BOOK_FOURTYSEVEN;
	public static LoreBook BOOK_FOURTYEIGHT;
	public static LoreBook BOOK_FOURTYNINE;
	public static LoreBook BOOK_FIFTY;
	
	public static void init() {
		BOOK_ONE = ZGLore.createLoreBook(1, "The Vranor", "The Vranor were once a militaristic race of hyper-advanced beings who ruled the galaxy.",
				"This rule ended when an unknown force devolved them back to their primitive, Neanderthal-like state.",
				"Since then, they simply wander planets, building villages and offering goods to anyone who will barter.", "Oddly enough, they are known for their peacefulness.",
				"However, they still remain a target for many other alien races.");
		
		BOOK_TWO = ZGLore.createLoreBook(2, "Nature Beings", "Magmos and Frost Giants are actually considered part of the planet itself.",
				"Magmos thrive on the scalding hot temperatures in Kriffon, while Frost Giants" + " survive off of extreme cold on Zollus.",
				"If a Magmos gets too cold, or a Frost Giant too hot, they will die.", "Though sentient and very strong, they are nothing more than essentially the protectors of their planets.",
				"They do not like things that do not belong, such as the Player, or the Vranor.");
		
		BOOK_THREE = ZGLore.createLoreBook(3, "Tech Planets", "Planets Xantheon and Atheon are artificial planets that were created by the Grays.",
				"The planets are generally void of most life, though the Grays do still inhabit them.", "These worlds are typically very hostile to the Player.",
				"They also contain resources with extreme value.", "Constructed planets were created from asteroids, " + "using the energy of a Dyson sphere and arduous terraforming.",
				"These worlds ride through space until they are caught in the orbit of a star system, " + "which they then consider home.");
		
		BOOK_FOUR = ZGLore.createLoreBook(4, "The Grays", "The Grays are a race of extraterrestrials " + "from an unknown dimension.",
				"They are incredibly smart, and though not hostile, " + " they should be considered enemies to the Player.", "One day, they will rise up and begin their attempt to rule the galaxy.",
				"They employ their robotic workers, the Galactic Sentry Guards, to protect " + "themselves from external dangers.",
				"It is believed that the Grays visited Earth long ago, " + "and actually interfered with human DNA, intertwining their own with a " + "primitive version of our own species.",
				"The question raises, then - if they created us, who, or what, created them?");
		
		BOOK_FIVE = ZGLore.createLoreBook(5, "Super Charged Coal",
				"Super Charged Coal is a version of regular Coal that has been amplified by the elements found in the planet's core, " + "causing them to retain a temporary, electric current.",
				"This enables a single piece of Super Charged Coal to burn at twice the rate as a regular piece of Coal.", "It can therefore smelt twice as much and last twice as long.",
				"It was first encountered on the planet Oasis by ancient cavemen," + " who then created their civilization's first fire using Super Charged Coal.",
				"Due to the electric current, these cavemen received a drastic boost in their intelligence, " + "and began evolving rapidly, leaving their star system and "
						+ "exploring others within under 100 years.",
				"It is unknown what they were called or where they are now.");
		
		BOOK_SIX = ZGLore.createLoreBook(6, "Star Gates", "Star Gates are a method of traveling vast distances of space almost instantaneously.",
				"Each Star Gate is specifically bound to two different worlds," + " and only two (e.g. Planet A and Planet B, or moons).",
				"If used on Planet/Moon A, the Player will be transported to Planet/Moon B.",
				"If used on Planet/Moon B, or anywhere else in the universe, the Player is transported" + " back to Planet/Moon A.",
				"Each one has a specific protocol that it follows - " + "that protocol being those two worlds, or moons.",
				"They were invented by an Earth scientist that spliced the DNA " + "of a captured Gray into human technology, making more advances possible.");
		
		BOOK_SEVEN = ZGLore.createLoreBook(7, "Planet Eden", "Eden is a paradise planet in the Psios-6 system.", "It orbits a blue star with its three other planetary neighbors.",
				"It is a multi-biome planet with unique fauna and environmental factors.",
				"It has been hypothesized that humans actually hail from planet Eden, " + "and were banished to Earth millennia ago, though the reasons remain unclear.",
				"Nevertheless, The Garden (a biome of Eden) is a lushful place, full of life and growth.");
		
		BOOK_EIGHT = ZGLore.createLoreBook(8, "Planet Zollus", "Zollus is a barren, icy planet, and the home of the Frost Giants.", "It is the furthermost planet from Psios-6.",
				"Many space explorers tend to begin their journies here.", "Not all of them survive, and those that do, simply make it on to the next harsh planet.",
				"Paradise awaits a Player that can trudge through ice and hellscape successfully.",
				"Zollus Crystals grow here, which are believed to have been formed " + "from the planet's crust in its conception.", "They grow as plants, stemming from deep into the ground.",
				"The Heart of Zol, or Heartium, can also be found here.", "Zol was believed to be the first Frost Giant, and therefore the planet is named after him.");
		
		BOOK_NINE = ZGLore.createLoreBook(9, "Planet Kriffon", "Kriffon is a bright but gloomy hellscape, " + "populated by volcanic entities called the Magmos.",
				"The metal Cobalt can be found here.",
				"The planet was named after the Kriff: " + "a race of red-skinned entities that drove their planet to extinction with their rapid evolution " + "and then had to escape.",
				"They are said to be a plague, conquering planet after planet within days.", "Kriffon is the closest to its star in the Psios-6 system.");
		
		BOOK_TEN = ZGLore.createLoreBook(10, "Planet Purgot", "Purgot was once believed to be a separate dimension called Purgatory.",
				"This likely comes from the name of one of its biomes, " + "with another biome being called Limbo.", "It is an icy planet, but it is rich with fauna.",
				"The primary metal here is Evenium, " + "and can be found deep inside of its caves.",
				"Ancient astronauts used to tell stories to " + "humans of how trapped souls would be sent here either to learn a lesson," + " or to await their judgment.");
		
		BOOK_ELEVEN = ZGLore.createLoreBook(11, "Planet Xathius", "Xathius is a strange but beautiful planet, " + "located in the Praedyth system.",
				"Its colors are primarily purple and blue, " + "but there are also some yellows and occasional reds thrown in there as well.",
				"Xathius is primarily known for its abundance of Promethean Ore, " + "which is a very powerful metal in the creation of Star Gates.", "It also has some of the biggest oceans.");
		
		BOOK_TWELVE = ZGLore.createLoreBook(12, "Planet Oasis", "Oasis is a paradise planet located in the Praedyth system.",
				"Some adventurers have reported finding oceans of Destabilized Redstone, " + "while others report simple red oceans. Its best qualities are its colors, "
						+ "and its abundance of Super Charged Coal.",
				"Some of the brightest and most vibrant sunsets and sunrises in the universe occur here.", "A lot of explorers even say that they believe the planet to still be growing.");
		
		BOOK_THIRTEEN = ZGLore.createLoreBook(13, "Fueltonium", "Fueltonium is a reactant metal that has been used inside of Big Reactors, " + "and as a replacement for Uranium.",
				"It is believed to be a greener, cleaner alternative.", "It can also be melted down into a lava-like substance, " + "though its use is currently undocumented.",
				"This metal can be found on the artificially-constructed planet, Xantheon, along with Amaranth Ore.", "It can also be used inside of Turbines.");
		
		BOOK_FOURTEEN = ZGLore.createLoreBook(14, "Planet Candora", "Candora is considered an Exotic class planet, " + "which is a rare class that is usually only found by strange means.",
				"It is often jokingly referred to as the Birthday Planet.", "It is filled with a Candy Cube landscape, " + "and has an ocean comprised entirely of melted chocolate.",
				"No one knows how this is even possible.", "It usually is used as a partying planet, " + "and one of celebration.", "Many sweets can be found here, as can many strange anomalies.");
		
		BOOK_FIFTEEN = ZGLore.createLoreBook(15, "Plutonium", "Plutonium, often used in Turbines, can be found on planet Xantheon.", "It is a rare commodity amongst space traders due to its secrecy.",
				"It also is used in the crafting of a Star Gate to get to planet Atheon, " + "where the super-metal Zollernium can be found.");
		
		BOOK_SIXTEEN = ZGLore.createLoreBook(16, "Ayanna's Father", "Ayanna called to her father in the stars, " + "but alas he could not hear her.",
				"He was entranced at the beauty of what he saw, " + "and what he felt.", "\"There are so many of them,\" he had said to his daughter.",
				"\"I think I'll go into one now, for I am tired, my dear.\"", "After that, he had vanished into a peaceful slumber.",
				"Legend says that Ayanna still searches for her father in the stars, " + "and that one day, she hopes to bring him home.");
		
		BOOK_SEVENTEEN = ZGLore.createLoreBook(17, "Dark Galaxy", "The Dark Galaxy is rumored to be at the center of the universe, " + "destroying or corrupting all things that it touches.",
				"Legend tells of adventurers that made it to this place, " + "but when they came back, they were somehow...different.",
				"They looked, sounded, acted differently, " + "as if they were given a task or some menacing purpose to fulfill.",
				"It's said that they serve whoever or whatever is inside of that galaxy: sentient dark matter.");
		
		BOOK_EIGHTEEN = ZGLore.createLoreBook(18, "Ayanna's Moon", "The moon spoke to Ayanna. It said sweet things to her.",
				"In that moment, she thought, maybe, it was her father; " + "that he was still alive. But she had given that hope up long ago.",
				"She used to look at the moon with such reverence, " + "but now she only feels spite.", "She wonders how much of her memory is real, and how much of it a fantasy.",
				"She grabs the crystal on her necklace and says, \"I'm going to find out.\"");
		
		BOOK_NINETEEN = ZGLore.createLoreBook(19, "Star Queen", "Ayanna's search ended bitterly, " + "for she did not find her father.",
				"Instead, she came face-to-face with the Dark Galaxy: " + "a whole cluster of dark-matter stars.", "They corrupted and changed her into something else.",
				"She no longer went by Ayanna anymore, but by Mytra, the Star Queen.", "Every fifty years, " + "she ventures out of her galaxy to dispatch " + "darkness across the universe.",
				"When an adventurer finds it, they too are transformed, " + "and they spread her will around even further. These are the Agents of Darkness.");
		
		BOOK_TWENTY = ZGLore.createLoreBook(20, "Planet Caligro", "Caligro was once a paradise planet like Oasis.",
				"It was full of beautiful, vibrant colors, " + "carving its own path in the universe as one of its most beautiful planets.", "But, something had occurred on this planet.",
				"The darkness had consumed it entirely.", "It was no longer a place of beauty, but of death and gloom.", "Its old name was Forma, named for its beauty.",
				"But now... Now it brought death to all who set " + "foot upon it.", "It is one of the few worlds where the Dark Agents have succeeded.");
		
		BOOK_TWENTYONE = ZGLore.createLoreBook(21, "Class D Planets",
				"Class D planets are a small, rock-based body, " + "typically a heavily-cratered asteroid, moon, or planetoid with little or no atmosphere.");
		
		BOOK_TWENTYTWO = ZGLore.createLoreBook(22, "Class H Planets", "Class H planets are a characteristically lifeless planet, uninhabitable by humans.", "Could contain gasses Oxygen and Argon.");
		
		BOOK_TWENTYTHREE = ZGLore.createLoreBook(23, "Class J Planets", "Class J planets are typically a gas giant, " + "usually with wind speeds of over 10k kmph.",
				"Also should contain Fluorine gas in its atmosphere.");
		
		BOOK_TWENTYFOUR = ZGLore.createLoreBook(24, "Class K Planets", "Class K planets are a typically uninhabitable world " + "made sustainable by pressure domes and life-support systems.");
		
		BOOK_TWENTYFIVE = ZGLore.createLoreBook(25, "Class L Planets", "Class L planets are a barely habitable world or moon that usually " + "consists of an Oxygen/Argon atmosphere.",
				"Typically rich with flora, but no fauna.");
		
		BOOK_TWENTYSIX = ZGLore.createLoreBook(26, "Class M Planets", "Class M planets are a habitable world suitable for sustaining human life, " + "with little or no terraforming required.",
				"Atmosphere is usually composed of Nitrogen, Oxygen and other trace elements, " + "usually those required for life.",
				"These worlds are usually abundant with water, flora, and fauna," + " with a core rich in Nickel and Iron.", "Some of these worlds can emit electromagnetic radiation.",
				"Usually has its own entire ecosystem and amino acids.");
		
		BOOK_TWENTYSEVEN = ZGLore.createLoreBook(27, "Class N Planets",
				"Class N planets are a world with very little gravity, " + "rich in minable, volatile resources, typically used in explosives.");
		
		BOOK_TWENTYEIGHT = ZGLore.createLoreBook(28, "Class T Planets", "Class T planets are a type of gas giant, typically home to dark matter life.");
		
		BOOK_TWENTYNINE = ZGLore.createLoreBook(29, "Class R Planets", "Class R planets are a lesser bioclassification of a Class M planet," + " these worlds are generally habitable, "
				+ "however they lack some or most of the characteristics for a terrestrial planet.");
		
		BOOK_THIRTY = ZGLore.createLoreBook(30, "Class Y Planets", "Class Y planets are a world characterized by a toxic atmosphere, " + "thermionic radiation discharges and surface temperatures "
				+ "at or above five hundred Kelvin, " + "nicknamed the \"demon class.\"", "Typically hazardous to both humans and starships.");
		
		BOOK_THIRTYONE = ZGLore.createLoreBook(31, "Class 9 Planets", "Class NINE planets are another type of gas giant, " + "usually located in the home star system of a hostile race.");
		
		BOOK_THIRTYTWO = ZGLore.createLoreBook(32, "Exotic Planets", "Class Exotic planets are a strange world that is uniquely proportioned " + "and makes no logical sense; an anomaly.");
		
		BOOK_THIRTYTHREE = ZGLore.createLoreBook(33, "Abandoned Planets", "Class Abandoned planets are a desolate void, long abandoned due to catastrophe or other hostility.");
		
		BOOK_THIRTYFOUR = ZGLore.createLoreBook(34, "Metamorphasis 1", "At one point, for several months (Earth time), " + "all planets seemed to give off a uniquely intense thermal level.",
				"It was as if the galaxy had somehow been supercharged, " + "and it is now cooling down.",
				"While not yet known what caused it, " + "Earth's best scientists are trying to figure it out.", "It should also be noted that drastic changes have affected Kriffon and Zollus.",
				"They seem to be undergoing some kind of metamorphasis.", "End log. - Star Captain Hohen");
		
		BOOK_THIRTYFIVE = ZGLore.createLoreBook(35, "Planet Perdita", "Perdita is the planet of loss. ", "Though it is beautiful and magestic, it carries with it a heavy history.",
				"Many lost souls ended up in this world, and were converted to Dark Agents.", "The planet's beauty is simply a lie; one that covers its darkest essence.",
				"Traveler, may you wander safely.");
		
		BOOK_THIRTYSIX = ZGLore.createLoreBook(36, "Mummies",
				"Mummies are Wanderers who were consumed by the darkness of the planet, " + "and then converted to darkness through its metamorphic abilities.",
				"They are mindless, and will attack anything that they perceive to be a threat - which is everything.");
		
		BOOK_THIRTYSEVEN = ZGLore.createLoreBook(37, "Scorpions", "Scorpions are a new breed of spider evolution.", "They are said to have evolved from Cave Spiders who were dumped on Perdita.",
				"Darkness envelops these creatures as well, and they are incredibly poisonous.");
		
		BOOK_THIRTYEIGHT = ZGLore.createLoreBook(38, "Mega Creepers", "Mega Creepers... These terrifying beings... By the stars, I wish them dead.", "Ayanna, what have you done?",
				"Their explosions are growing; their speed, increasing.", "I fear that these creatures could destroy planets! ", "Oh, my lover, I am so sorry.",
				"Perhaps if I can find you, we can discuss your pain.", "We can end this. I'm on my way.", "Please, still have some humanity left in you. - Star Captain Hohen");
		
		BOOK_THIRTYNINE = ZGLore.createLoreBook(39, "Metamorphasis 2", "The metamorphasis is rapidly increasing.", "Zollus and Kriffon, they... they've completely changed.",
				"The worlds have rewrote themselves.", "What force could be strong enough to force planets to redesign themselves?",
				"It's as if the galaxy knows what's coming, and is adapting itself to fight back. - Star Captain Hohen");
		
		BOOK_FOURTY = ZGLore.createLoreBook(40, "Planet Altum", "Altum was the first ever encountered water planet. It is also filled with treasure: in its oceans; its caves.",
				"The planet is also lush with unique fauna and minerals.", "Perhaps most unique are its inhabitants, the Abyssal Villagers.");
		
		BOOK_FOURTYONE = ZGLore.createLoreBook(41, "Dark Arrival 1", "\"Sir!\" the private called. \"What is it, Flinsky?\" Hohen barked back.",
				"\"There is a vessel of some sort approaching. We hailed its captain.\" There was a long pause.",
				"\"And?\" Flinsky sighed. \"She says she's from something called the Dark Galaxy. Her name is Ayanna.\"",
				"Hohen's eyes widened, and his heart sank to his chest. \"My God... They're here.\"");
		
		BOOK_FOURTYTWO = ZGLore.createLoreBook(42, "Dark Arrival 2", "\"That ship... it's unlike anything I've ever seen,\" Hohen said as he geared up to board the approaching craft.",
				"\"Sir, I still don't think this is a good idea,\" one of his crew members stated.",
				"\"If the rumors are true, you could be infected. The last thing we want is for this thing to spread across the galaxy.",
				"Please, just, be careful. Don't go.\" She began to tear up, and he kissed her forehead.",
				"\"Don't worry, Daisy. I'll be careful. You just do your part here. Remember what I taught you.",
				"I'm coming back, and when I do,\" he chuckled, \"we're gonna have one heck of a party.\"", "Daisy hugged him, and then he was off to board the vessel.");
		
		BOOK_FOURTYTHREE = ZGLore.createLoreBook(43, "Dark Arrival 3", "Hohen landed his craft on top the ship wrecklessly, rocking it. \"Not my best,\" he said to himself.",
				"He picked up his radio and spoke into it: \"This is Star Captain Hohen; I have boarded the Dark Vessel.",
				"Also... I'm uh, pretty sure they know I'm here,\" he said with a chuckle. \"Going in now.\"",
				"He found an entrance through the back of the ship and climbed aboard. What awaited him was far more than he anticipated.",
				"\"Greetings, Traveler,\" a female voice echoed throughout the ship, as the Sentries stood guard.", "\"A sailor among the stars, ever so entranced by their luminescence.",
				"You seek answers to something that you could not possibly understand.", "But if it is an audience that you desire, you shall have it.\" The Sentries began approaching him.");
		
		BOOK_FOURTYFOUR = ZGLore.createLoreBook(44, "Dark Arrival 4", "\"What are these things?!\" Hohen asked the noncorporeal voice.",
				"\"They are my servants, and my protectors. These Galactic Sentries do my bidding, ", "as I have given purpose to each world I take them from.",
				"They were once as you are now: unawakened.", "I think I can help you with that,\" spoke Ayanna, ",
				"as she came into view, her red hair falling to the middle of her back, clutching the crystal necklace.",
				"Her misty-pink dress shimmered as she walked. \"Then, maybe you can help me,\" she said, releasing dark essence from her fingertips.");
		
		BOOK_FOURTYFIVE = ZGLore.createLoreBook(45, "Diablo", "Diablo is one of the four Swords of Triumph. Each sword has a power.",
				"For this one: fire! Shoot it at your enemies, or set them ablaze when they taste the fiery blade.");
		
		BOOK_FOURTYSIX = ZGLore.createLoreBook(46, "Thor", "Thor is one of the four Swords of Triumph. Each sword has a power.",
				"For this one: thunder! Should you be worthy, you may summon it from the Heavens, and strike your enemies down!");
		
		BOOK_FOURTYSEVEN = ZGLore.createLoreBook(47, "Ender", "Ender is one of the four Swords of Triumph. Each sword has a power.",
				"For this one: teleportation! Use it to be as an Enderman: teleport short distances in a single moment. Also good for climbing!");
		
		BOOK_FOURTYEIGHT = ZGLore.createLoreBook(48, "Glacies", "Glacies is one of the four Swords of Triumph. Each sword has a power.",
				"For this one: ice! Freeze your enemies with a touch of the blade, or summon a beam of ice at whence you look.");
		
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