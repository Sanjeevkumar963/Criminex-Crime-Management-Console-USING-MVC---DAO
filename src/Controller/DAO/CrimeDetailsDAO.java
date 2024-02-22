package Controller.DAO;
import Controller.DTO.CrimeDetails;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface CrimeDetailsDAO extends DAO<CrimeDetails>
{
	List<CrimeDetails> retrieveAllByGuiltyStatus(String guiltyStatus) throws SQLException ;

	List<CrimeDetails> retrieveAllByCrime(String crime) throws SQLException;

	String getSuspectId(String fir) throws SQLException;

	String getCrimeSuspectId(String fir) throws SQLException;

	Date calculateReleaseDate(String crimeDone, Date caseDate);
}
