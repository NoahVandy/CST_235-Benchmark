package REST;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.Verse;
import business.VerseBusinessInterface;

@RequestScoped
@Path("/verses")
public class VerseRestService {

	@Inject
	VerseBusinessInterface<Verse> service;
	
	/**
	 * this method uses the GET method because it does not pass any valuable information through the URL bar
	 * this returns the businessService.searchVerses which returns a List<Verse> that is pulled from the dataService which runs a query that uses the params that were passed in through the URL bar and binded to an object in the method itself
	 * 
	 * @param book
	 * @param chapterNumber
	 * @param verseNumber
	 * @return
	 */
	@GET
	@Path("/get/{book}/{chapterNumber}/{verseNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verse> getVerse(@PathParam("book") String book, @PathParam("chapterNumber") int chapterNumber, @PathParam("verseNumber") int verseNumber) 
	{
		System.out.println("API was /getVerse: I recieved request for verse: " + book + " " + chapterNumber + " " + verseNumber);
		//make a new Verse object
		Verse verse = new Verse();
		//bind all of the params that were passed in
		verse.setBook(book);
		verse.setChapterNumber(chapterNumber);
		verse.setVerseNumber(verseNumber);
		//return the List<Verse> that come from the businessService
		return service.searchVerses(verse);
	}
}
