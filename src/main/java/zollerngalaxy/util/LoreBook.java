package zollerngalaxy.util;

import java.util.ArrayList;
import java.util.List;

public final class LoreBook {
	
	private String bookTitle;
	private List<String> pages = new ArrayList<String>();
	
	public LoreBook(String strTitle) {
		this.bookTitle = strTitle;
	}
	
	public LoreBook(String strTitle, String... pages) {
		this.setTitle(strTitle);
		this.addPages(pages);
	}
	
	public LoreBook() {
		
	}
	
	public void addPage(String pageText) {
		this.pages.add(pageText);
	}
	
	public void addPages(String... pages) {
		for (String p : pages) {
			this.addPage(p);
		}
	}
	
	public List<String> getPages() {
		return this.pages;
	}
	
	public String getPage(int pageNum) {
		if (pageNum <= 0) {
			pageNum = 1;
		}
		return this.pages.get(pageNum);
	}
	
	public String getTitle() {
		return this.bookTitle;
	}
	
	public void setTitle(String strTitle) {
		this.bookTitle = strTitle;
	}
}