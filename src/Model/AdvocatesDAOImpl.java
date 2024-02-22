package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.AdvocatesDAO;
import Controller.DTO.Advocates;
import Database.DBConnection;

public class AdvocatesDAOImpl implements AdvocatesDAO 
{

    @Override
    public List<Advocates> retrieveAll() throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM Advocates";
        List<Advocates> advocatesList = new ArrayList<>();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) 
        {
            Advocates advocate = new Advocates();
            advocate.setAdvocate_id(rs.getString("advocate_id"));
            advocate.setAdvocate_name(rs.getString("advocate_name"));
            advocate.setAdvocate_phone_number(rs.getString("advocate_phone_number"));
            advocatesList.add(advocate);
        }
        return advocatesList;
    }


    @Override
    public int insert(Advocates advocate) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "INSERT INTO Advocates (advocate_id, advocate_name, advocate_phone_number) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, advocate.getAdvocate_id());
        ps.setString(2, advocate.getAdvocate_name());
        ps.setString(3, advocate.getAdvocate_phone_number());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int update(Advocates advocate, String change) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "UPDATE Advocates SET advocate_name = ?, advocate_phone_number = ? WHERE advocate_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, advocate.getAdvocate_name());
        ps.setString(2, advocate.getAdvocate_phone_number());
        ps.setString(3, advocate.getAdvocate_id());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int delete(Advocates advocate) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "DELETE FROM Advocates WHERE advocate_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, advocate.getAdvocate_id());
        int result = ps.executeUpdate();
        return result;
    }


	
}
