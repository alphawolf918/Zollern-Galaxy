package zollerngalaxy.lib.helpers.integration;

import com.mjr.planetprogression.item.PlanetProgression_Items;
import com.mjr.planetprogression.item.ResearchPaper;

public class ZGResearchPapers {
	
	public static void AddResearchPaper(String celestialName) {
		int number = ZGResearchPapers.getNumResearchPapers() + 100;
		PlanetProgression_Items.researchPapers.add(new ResearchPaper(celestialName, number));
	}
	
	private static int getNumResearchPapers() {
		int numPapers = PlanetProgression_Items.researchPapers.size();
		return numPapers;
	}
}