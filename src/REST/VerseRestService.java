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
	
	@GET
	@Path("/get/{book}/{chapterNumber}/{verseNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Verse> getVerse(@PathParam("book") String book, @PathParam("chapterNumber") int chapterNumber, @PathParam("verseNumber") int verseNumber) 
	{
		System.out.println("API was /getVerse: I recieved request for verse: " + book + " " + chapterNumber + " " + verseNumber);
		Verse verse = new Verse();
		verse.setBook(book);
		verse.setChapterNumber(chapterNumber);
		verse.setVerseNumber(verseNumber);
		return service.searchVerses(verse);
	}
}
