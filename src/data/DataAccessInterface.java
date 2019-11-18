package data;

import java.util.List;

import beans.Verse;

public interface DataAccessInterface<T> {

	public List<T> searchAll(Verse verse);
	
}
