package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.PrisonerDetailsDAO;
import Controller.DTO.PrisonerDetails;
import Database.DBConnection;

public class PrisonerDetailsDAOImpl implements PrisonerDetailsDAO 
{

    @Override
    public List<PrisonerDetails> retrieveAll() throws SQLException 
    {
        List<PrisonerDetails> prisonerDetailsList = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM PrisonerDetails";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
        {
            PrisonerDetails prisonerDetails = new PrisonerDetails();
            prisonerDetails.setPrison_id(rs.getString("prison_id"));
            prisonerDetails.setPrisoner_id(rs.getString("prisoner_id"));
            prisonerDetails.setSuspect_id(rs.getString("suspect_id"));
            prisonerDetails.setDate_of_imprisonment(rs.getDate("date_of_imprisonment"));
            prisonerDetails.setDate_of_release(rs.getDate("date_of_release"));
            prisonerDetailsList.add(prisonerDetails);
        }
        return prisonerDetailsList;
    }

    @Override
    public int insert(PrisonerDetails prisonerDetail) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO PrisonerDetails (prison_id, prisoner_id, suspect_id, date_of_imprisonment, date_of_release) VALUES (?, ?, ?, ?, ?)");
        ps.setString(1, prisonerDetail.getPrison_id());
        ps.setString(2, prisonerDetail.getPrisoner_id());
        ps.setString(3, prisonerDetail.getSuspect_id());
        ps.setDate(4, new java.sql.Date(prisonerDetail.getDate_of_imprisonment().getTime()));
        ps.setDate(5, new java.sql.Date(prisonerDetail.getDate_of_release().getTime()));
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    @Override
    public int update(PrisonerDetails prisonerDetail, String change) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE PrisonerDetails SET date_of_release = ? WHERE prisoner_id = ?");
        ps.setDate(1, new java.sql.Date(prisonerDetail.getDate_of_release().getTime()));
        ps.setString(2, prisonerDetail.getPrisoner_id());
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    @Override
    public int delete(PrisonerDetails prisonerDetail) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM PrisonerDetails WHERE prisoner_id = ?");
        ps.setString(1, prisonerDetail.getPrisoner_id());
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}
