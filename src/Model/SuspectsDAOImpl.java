package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.SuspectsDAO;
import Controller.DTO.Suspects;
import Database.DBConnection;

public class SuspectsDAOImpl implements SuspectsDAO
{

	@Override
	//retrieve all
	public List<Suspects> retrieveAll() throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Suspects";
		List<Suspects> suspect=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) 
		{
			Suspects s=new Suspects();
			s.setSuspect_id(rs.getString("suspect_id"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setDate_of_Birth(rs.getDate("date_of_birth"));
			s.setNo_of_cases(rs.getInt("no_of_cases"));
			suspect.add(s);
		}
		return suspect;
	}

	@Override
	//insert
	public int insert(Suspects suspect) throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO Suspects (suspect_id,name,gender,date_of_birth,no_of_cases) VALUES(?, ?, ?, ?, ?)";		
		PreparedStatement ps=con.prepareStatement(sql);	
		ps.setString(1, suspect.getSuspect_id());
		ps.setString(2, suspect.getName());
		ps.setString(3, suspect.getGender());
	    java.sql.Date sqlDate = new java.sql.Date(suspect.getDate_of_Birth().getTime());
		ps.setDate(4, sqlDate);
		ps.setInt(5, suspect.getNo_of_cases());
		int result=ps.executeUpdate();
		return result;
	}
	
	//retrieve by id
	public Suspects retrieveSuspectById(String suspectId) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT * FROM Suspects WHERE suspect_id = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, suspectId);
	    ResultSet rs = ps.executeQuery();
		Suspects s=new Suspects();
	    if (rs.next()) 
	    {
	    	s.setSuspect_id(rs.getString("suspect_id"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setDate_of_Birth(rs.getDate("date_of_birth"));
			s.setNo_of_cases(rs.getInt("no_of_cases"));
	    }
	    return s;
	}


	@Override
	public int update(Suspects suspect,String change) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE Suspects set no_of_cases = ? where suspect_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, suspect.getNo_of_cases());
		ps.setString(2, suspect.getSuspect_id());
		int result = ps.executeUpdate();
		return result;
	}

	@Override
	public int delete(Suspects suspect) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM Suspects WHERE suspect_id= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, suspect.getSuspect_id());
		int result = ps.executeUpdate();
		return result;
	}


	@Override
	public List<Suspects> retrieveAllByGender(String gender) throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM Suspects where gender = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, gender);
		List<Suspects> suspect=new ArrayList<>();
		ResultSet rs=ps.executeQuery();
		while(rs.next()) 
		{
			Suspects s=new Suspects();
			s.setSuspect_id(rs.getString("suspect_id"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setDate_of_Birth(rs.getDate("date_of_birth"));
			s.setNo_of_cases(rs.getInt("no_of_cases"));
			suspect.add(s);
		}
		return suspect;
	}
	
	public List<Suspects> retrieveAllSuspectsByGuiltyStatus(String guiltyStatus) throws SQLException {
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT s.* " +
	                 "FROM Suspects s " +
	                 "INNER JOIN CrimeDetails cd ON s.suspect_id = cd.suspect_id " +
	                 "WHERE cd.guilty_status = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, guiltyStatus);
	    List<Suspects> suspectsList = new ArrayList<>();
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) 
	    {
	    	Suspects s=new Suspects();
	    	s.setSuspect_id(rs.getString("suspect_id"));
			s.setName(rs.getString("name"));
			s.setGender(rs.getString("gender"));
			s.setDate_of_Birth(rs.getDate("date_of_birth"));
			s.setNo_of_cases(rs.getInt("no_of_cases"));
	        suspectsList.add(s);
	    }
	    return suspectsList;
	}


}
