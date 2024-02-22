package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Controller.DAO.CrimeDetailsDAO;
import Controller.DTO.CrimeDetails;
import Database.DBConnection;

public class CrimeDetailsDAOImpl implements CrimeDetailsDAO
{

	@Override
	public List<CrimeDetails> retrieveAll() throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM CrimeDetails";
		List<CrimeDetails> crimeDetailsList=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()) 
		{
			CrimeDetails cr=new CrimeDetails();
			cr.setFir_no(rs.getString("fir_no"));
			cr.setSuspect_id(rs.getString("suspect_id"));
			cr.setCrime(rs.getString("crime"));
			cr.setGuilty_status(rs.getString("guilt_status"));
			cr.setDate_of_arrest(rs.getDate("date_of_arrest"));
			crimeDetailsList.add(cr);
		}
		return crimeDetailsList;
	}

	@Override
	public int insert(CrimeDetails crimeDetails) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "INSERT INTO CrimeDetails (fir_no, suspect_id, crime, guilty_status, date_of_arrest) VALUES (?, ?, ?, ?, ?)";
	    PreparedStatement ps = con.prepareStatement(sql);    
	    ps.setString(1, crimeDetails.getFir_no());
	    ps.setString(2, crimeDetails.getSuspect_id());
	    ps.setString(3, crimeDetails.getCrime());
	    ps.setString(4, crimeDetails.getGuilty_status());
	    java.sql.Date sqlDate = new java.sql.Date(crimeDetails.getDate_of_arrest().getTime());
	    ps.setDate(5, sqlDate);
	    int result = ps.executeUpdate();
	    return result;
	}


	@Override
	public int update(CrimeDetails crimeDetails, String change) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "UPDATE CrimeDetails SET guilty_status = ? WHERE fir_no = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, change);
	    ps.setString(2, crimeDetails.getFir_no());
	    int result = ps.executeUpdate();
	    return result;
	}


	@Override
	public int delete(CrimeDetails crimeDetails) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "DELETE FROM CrimeDetails WHERE fir_no = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, crimeDetails.getFir_no());
	    int result = ps.executeUpdate();
	    return result;
	}

	@Override
	public List<CrimeDetails> retrieveAllByGuiltyStatus(String guiltyStatus) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT * FROM CrimeDetails WHERE guilty_status = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, guiltyStatus);
	    List<CrimeDetails> crimeDetailsList = new ArrayList<>();
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) 
	    {
	    	CrimeDetails cr=new CrimeDetails();
	    	cr.setFir_no(rs.getString("fir_no"));
			cr.setSuspect_id(rs.getString("suspect_id"));
			cr.setCrime(rs.getString("crime"));
			cr.setGuilty_status(rs.getString("guilt_status"));
			cr.setDate_of_arrest(rs.getDate("date_of_arrest"));
			crimeDetailsList.add(cr);
	    }
	    return crimeDetailsList;
	}

	@Override
	public List<CrimeDetails> retrieveAllByCrime(String crime) throws SQLException 
	{
	    Connection con = DBConnection.getConnection();
	    String sql = "SELECT * FROM CrimeDetails WHERE crime = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, crime);
	    List<CrimeDetails> crimeDetailsList = new ArrayList<>();
	    ResultSet rs = ps.executeQuery();
	    while (rs.next()) 
	    {
	    	CrimeDetails cr=new CrimeDetails();
	    	cr.setFir_no(rs.getString("fir_no"));
			cr.setSuspect_id(rs.getString("suspect_id"));
			cr.setCrime(rs.getString("crime"));
			cr.setGuilty_status(rs.getString("guilt_status"));
			cr.setDate_of_arrest(rs.getDate("date_of_arrest"));
			crimeDetailsList.add(cr);
	    }
	    return crimeDetailsList;
	}
	
	@Override
	public String getSuspectId(String fir) throws SQLException
	{
		Connection con = DBConnection.getConnection();
	    String sql = "SELECT suspect_id FROM CrimeDetails WHERE fir_no = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, fir);
	    String res="";
	    ResultSet s=ps.executeQuery();
	    while (s.next()) 
	    {
	    	res=s.getString("suspect_id");
	    }
	    return res;
	}
	
	@Override
	public String getCrimeSuspectId(String fir) throws SQLException
	{
		Connection con = DBConnection.getConnection();
	    String sql = "SELECT crime FROM CrimeDetails WHERE fir_no = ?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, fir);
	    String res="";
	    ResultSet s=ps.executeQuery();
	    while (s.next()) 
	    {
	    	res=s.getString("crime");
	    }
	    return res;
	}
	
	
	public Date calculateReleaseDate(String crimeDone, Date caseDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(caseDate.getTime());

		switch (crimeDone) 
		{
			case "Murderer":
				calendar.add(Calendar.YEAR, 14);
				break;
			case "Rapist":
				calendar.add(Calendar.YEAR, 2);
				break;
			case "Fraud":
				calendar.add(Calendar.YEAR, 7);
				break;
			default:
				// more to be added
				break;
		}
		return new Date(calendar.getTimeInMillis());
	}
	
	
	

}
