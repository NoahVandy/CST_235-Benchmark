package data;

import java.util.List;

import beans.Verse;

public interface DataAccessInterface<T> {

	/**
	 * taking the verse that was passed into from the businessService and running a query with the information that the verse posseses
	 * @param verse
	 * @return
	 */
	public List<T> searchAll(Verse verse);
	
}
