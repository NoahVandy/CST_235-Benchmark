package data;

import beans.Verse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class VerseDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class VerseDataService implements DataAccessInterface<Verse> {

    /**
     * Default constructor. 
     */
    public VerseDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#searchAll(Verse)
     */
    public List<Verse> searchAll(Verse verse) {
        // TODO Auto-generated method stub
    	Connection conn = null;
    	List<Verse> Verses = new ArrayList<Verse>();
		String url = "jdbc:mysql://localhost:3306/benchmark_cst-235";
		String username = "root";
		String password = "root";
		String sql = String.format("SELECT * FROM `bible` WHERE `BOOK` = '%s' AND `CHAPTER_NUMBER` = '%d' AND `VERSE_NUMBER` = '%d'", verse.getBook(), verse.getChapterNumber(), verse.getVerseNumber());
		try 
		{
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				Verses.add(new Verse(rs.getString("BOOK"), rs.getInt("CHAPTER_NUMBER"), rs.getInt("VERSE_NUMBER"), rs.getString("VERSE")));
			}
			rs.close();
			System.out.println("Connected to the database");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(conn != null)
			{
				try
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		for (Verse v : Verses) 
		{
			System.out.println(v.toString());
		}
    	return Verses;
    }

}
