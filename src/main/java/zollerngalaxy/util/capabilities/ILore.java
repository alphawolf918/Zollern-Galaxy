package zollerngalaxy.util.capabilities;

import java.util.List;
import zollerngalaxy.util.LoreBook;

public interface ILore {
	
	public void addLoreBook(LoreBook book);
	
	public boolean hasLoreBook(LoreBook book);
	
	public List<Integer> getLoreBooks();
	
}