package Controller.DAO;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> 
{
	List<T> retrieveAll() throws SQLException;

	int insert(T t) throws SQLException;

	int update(T t,String change) throws SQLException;

	int delete(T t) throws SQLException;
}