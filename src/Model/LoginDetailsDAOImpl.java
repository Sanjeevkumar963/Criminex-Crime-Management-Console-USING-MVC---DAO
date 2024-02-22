package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.LoginDetailsDAO;
import Controller.DTO.LoginDetails;
import Database.DBConnection;

public class LoginDetailsDAOImpl implements LoginDetailsDAO
{

	@Override
	public LoginDetails getByEmail(String email,String password) throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql = "SELECT * FROM LoginDetails WHERE email = ? AND password = ?";		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		LoginDetails login = new LoginDetails();
		while(rs.next())
		{
			login.setEmail(rs.getString("email"));
			login.setPassword(rs.getString("password"));
			login.setAadhar_number(rs.getString("aadhar_number"));
			login.setPhone_number(rs.getString("phone_number"));
			login.setRole(rs.getString("role"));
		}
		return login;
	}

	@Override
	//RETRIEVE all
	public List<LoginDetails> retrieveAll() throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql="SELECT * FROM LoginDetails";

		List<LoginDetails> Logins=new ArrayList<>();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()) 
		{
			LoginDetails login = new LoginDetails();
			login.setEmail(rs.getString("email"));
			login.setPassword(rs.getString("password"));
			login.setAadhar_number(rs.getString("aadhar_number"));
			login.setPhone_number(rs.getString("phone_number"));
			login.setRole(rs.getString("role"));
			Logins.add(login);
		}

		return Logins;
	}

	@Override
	public int insert(LoginDetails login) throws SQLException 
	{
		Connection con=DBConnection.getConnection();
		String sql = "INSERT INTO LoginDetails (email,password,aadhar_number,phone_number,role) VALUES(?, ?, ?, ?, ?)";		
		PreparedStatement ps=con.prepareStatement(sql);	
		ps.setString(1, login.getEmail());
		ps.setString(2, login.getPassword());
		ps.setString(3, login.getAadhar_number());
		ps.setString(4, login.getPhone_number());
		ps.setString(5, login.getRole());
		int result=ps.executeUpdate();
		return result;
	}

	@Override
	public int update(LoginDetails login,String change) throws SQLException
	{
		Connection con = DBConnection.getConnection();

		if(change.equals("Phone number"))
		{
			String sql = "UPDATE LoginDetails set phone_number = ? where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, login.getPhone_number());
			ps.setString(2, login.getEmail());
			int result = ps.executeUpdate();
			return result;
		}
		else if(change.equals("Password"))
		{
			String sql = "UPDATE LoginDetails set password = ? where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, login.getPassword());
			ps.setString(2, login.getEmail());
			int result = ps.executeUpdate();
			return result;
		}
		return 0;
	}

	@Override
	public int delete(LoginDetails login) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM LoginDetails WHERE email= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login.getEmail());
		int result = ps.executeUpdate();
		return result;
	}

}
