package business;

import java.util.List;

import beans.Verse;

public interface VerseBusinessInterface<T> {

	/**
	 * passing a verse for the dataService to be able to run a query on
	 * @param verse
	 * @return
	 */
	public List<T> searchVerses(Verse verse);
}
