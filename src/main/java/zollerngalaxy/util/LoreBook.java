package zollerngalaxy.util;

import java.util.ArrayList;
import java.util.List;

public class LoreBook {
	
	private String bookTitle;
	private List<String> pages = new ArrayList<String>();
	private int bookID = 1;
	
	public LoreBook(String strTitle) {
		this.bookTitle = strTitle;
		this.bookID++;
	}
	
	public LoreBook(int ID, String strTitle) {
		this.bookTitle = strTitle;
		this.bookID = ID;
	}
	
	public LoreBook(int ID, String strTitle, String... pages) {
		this.setTitle(strTitle);
		this.addPages(pages);
		this.bookID = ID;
	}
	
	public LoreBook(String strTitle, String... pages) {
		this.setTitle(strTitle);
		this.addPages(pages);
		this.bookID++;
	}
	
	public LoreBook(int ID) {
		this.bookID = ID;
	}
	
	public LoreBook() {
		this.bookID++;
	}
	
	public void addPage(String pageText) {
		this.pages.add(pageText);
	}
	
	public void addPages(String... pages) {
		for (String p : pages) {
			this.addPage(p);
		}
	}
	
	public int getBookID() {
		return this.bookID;
	}
	
	public List<String> getPages() {
		return this.pages;
	}
	
	public String getPage(int pageNum) {
		return this.pages.get(pageNum);
	}
	
	public String getTitle() {
		return this.bookTitle;
	}
	
	public void setTitle(String strTitle) {
		this.bookTitle = strTitle;
	}
}