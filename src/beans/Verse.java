package beans;

public class Verse {

	private String book;
	private int chapterNumber;
	private int verseNumber;
	private String verse;
	
	/**
	 * 
	 * @param book
	 * @param chapterNnumber
	 * @param verseNumber
	 * @param verse
	 */
	public Verse(String book, int chapterNumber, int verseNumber, String verse) {
		super();
		this.book = book;
		this.chapterNumber = chapterNumber;
		this.verseNumber = verseNumber;
		this.verse = verse;
	}


	public Verse() {
		// TODO Auto-generated constructor stub
	}


	public String getBook() {
		return book;
	}


	public void setBook(String book) {
		this.book = book;
	}


	public int getChapterNumber() {
		return chapterNumber;
	}


	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}


	public int getVerseNumber() {
		return verseNumber;
	}


	public void setVerseNumber(int verseNumber) {
		this.verseNumber = verseNumber;
	}


	public String getVerse() {
		return verse;
	}


	public void setVerse(String verse) {
		this.verse = verse;
	}


	@Override
	public String toString() {
		return "Verse book: " + book + ", chapterNumber: " + chapterNumber + ", verseNumber: " + verseNumber + ", verse: "
				+ verse;
	}
	
	
	
	
	
}
