package business;

import beans.Verse;
import data.DataAccessInterface;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Session Bean implementation class VerseBusinessService
 */
@Stateless
@Local(VerseBusinessInterface.class)
@LocalBean
public class VerseBusinessService implements VerseBusinessInterface<Verse> {
	
	@Inject
	DataAccessInterface<Verse> dataService;
	
    /**
     * Default constructor. 
     */
    public VerseBusinessService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see VerseBusinessInterface#getVerses()
     */
    public List<Verse> searchVerses(Verse verse) {
        // TODO Auto-generated method stub
		return dataService.searchAll(verse);
    }

}
