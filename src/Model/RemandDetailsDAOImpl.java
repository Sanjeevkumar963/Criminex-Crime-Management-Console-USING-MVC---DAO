package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.RemandDetailsDAO;
import Controller.DTO.RemandDetails;
import Database.DBConnection;

public class RemandDetailsDAOImpl implements RemandDetailsDAO {

    @Override
    public List<RemandDetails> retrieveAll() throws SQLException 
    {
        List<RemandDetails> remandDetailsList = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM RemandDetails";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
        {
            RemandDetails remandDetails = new RemandDetails();
            remandDetails.setSuspect_id(rs.getString("suspect_id"));
            remandDetails.setStation_id(rs.getString("station_id"));
            remandDetails.setRemand_till_date(rs.getDate("remand_till_date"));
            remandDetailsList.add(remandDetails);
        }
        return remandDetailsList;
    }

    @Override
    public int insert(RemandDetails remandDetail) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO RemandDetails (suspect_id, station_id, remand_till_date) VALUES (?, ?, ?)");
        ps.setString(1, remandDetail.getSuspect_id());
        ps.setString(2, remandDetail.getStation_id());
        ps.setDate(3, new java.sql.Date(remandDetail.getRemand_till_date().getTime()));
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    @Override
    public int update(RemandDetails remandDetail, String change) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE RemandDetails SET station_id = ?, remand_till_date = ? WHERE suspect_id = ?");
        ps.setString(1, remandDetail.getStation_id());
        ps.setDate(2, new java.sql.Date(remandDetail.getRemand_till_date().getTime()));
        ps.setString(3, remandDetail.getSuspect_id());
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    @Override
    public int delete(RemandDetails remandDetail) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("DELETE FROM RemandDetails WHERE suspect_id = ?");
        ps.setString(1, remandDetail.getSuspect_id());
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

}

