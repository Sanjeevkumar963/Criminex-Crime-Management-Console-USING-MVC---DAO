package Controller.DAO;

import Controller.DTO.*;
import java.sql.SQLException;
import java.util.List;


public interface SuspectsDAO extends DAO<Suspects>
{
	List<Suspects> retrieveAllByGender(String gender) throws SQLException;
	List<Suspects> retrieveAllSuspectsByGuiltyStatus(String guiltyStatus) throws SQLException;
	Suspects retrieveSuspectById(String suspectId) throws SQLException; 
}
