package business;

import java.util.List;

import beans.Verse;

public interface VerseBusinessInterface<T> {

	public List<T> searchVerses(Verse verse);
}
