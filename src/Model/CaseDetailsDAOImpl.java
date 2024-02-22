package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.CaseDetailsDAO;
import Controller.DTO.CaseDetails;
import Database.DBConnection;

public class CaseDetailsDAOImpl implements CaseDetailsDAO 
{

    @Override
    public List<CaseDetails> retrieveAll() throws SQLException 
    {
        List<CaseDetails> caseDetailsList = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM CaseDetails";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) 
        {
        	CaseDetails caseDetails = new CaseDetails();
            caseDetails.setCase_no(rs.getString("case_no"));
            caseDetails.setFir_no("fir_no");
            caseDetails.setFiling_date(rs.getDate("filing_date"));
            caseDetails.setCase_date(rs.getDate("case_date"));
            caseDetails.setAdvocate_id(rs.getString("advocate_id"));
            caseDetails.setJudgement(rs.getString("judgement"));
            caseDetailsList.add(caseDetails);
        }
        return caseDetailsList;
    }

    @Override
    public int insert(CaseDetails caseDetails) throws SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;

        String sql = "INSERT INTO CaseDetails (case_no, fir_no, filing_date, case_date, advocate_id, judgement) VALUES (?, ?, ?, ?, ?, ?)";
        ps = con.prepareStatement(sql);
        ps.setString(1, caseDetails.getCase_no());
        ps.setString(2, caseDetails.getFir_no());
        ps.setDate(3, new java.sql.Date(caseDetails.getFiling_date().getTime()));
        ps.setDate(4, new java.sql.Date(caseDetails.getCase_date().getTime()));
        ps.setString(5, caseDetails.getAdvocate_id());
        ps.setString(6, caseDetails.getJudgement());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int update(CaseDetails caseDetails, String change) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE CaseDetails SET judgement = ? WHERE case_no = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, change);
        ps.setString(2, caseDetails.getCase_no());
        int result = ps.executeUpdate();
        return result;
    }

    @Override
    public int delete(CaseDetails caseDetails) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM CaseDetails WHERE case_no = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, caseDetails.getCase_no());
        int result = ps.executeUpdate();
        return result;
    }
    
    @Override
    public int getNumberOfCasesByFirNo(String suspectId) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT COUNT(DISTINCT cd.fir_no) AS num_cases " +"FROM caseDetails cd " +"INNER JOIN crimeDetails cr ON cd.fir_no = cr.fir_no " +"WHERE cr.suspect_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, suspectId);
        ResultSet rs = ps.executeQuery();
        int numCases = 0;
        if (rs.next()) 
        {
            numCases = rs.getInt("num_cases");
        }
        return numCases;
    }

    
    @Override
    public CaseDetails getCaseDetailsByCaseNo(String caseNo) throws SQLException 
    {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM CaseDetails WHERE case_no = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, caseNo);
        ResultSet rs = ps.executeQuery();
        CaseDetails caseDetails = null;
        caseDetails = new CaseDetails();
        if (rs.next()) 
        {
            caseDetails.setCase_no(rs.getString("case_no"));
            caseDetails.setFir_no(rs.getString("fir_no"));
            caseDetails.setFiling_date(rs.getDate("filing_date"));
            caseDetails.setCase_date(rs.getDate("case_date"));
            caseDetails.setAdvocate_id(rs.getString("advocate_id"));
            caseDetails.setJudgement(rs.getString("judgement"));
        }
        return caseDetails;
    }
    
    @Override
    public List<CaseDetails> retrieveCasesByJudgement(String judgement) throws SQLException {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM CaseDetails WHERE judgement = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, judgement);
        ResultSet rs = ps.executeQuery();
        List<CaseDetails> caseDetailsList = new ArrayList<>();
        while (rs.next()) 
        {
            CaseDetails caseDetails = new CaseDetails(); 
        	caseDetails.setCase_no(rs.getString("case_no"));
            caseDetails.setFir_no(rs.getString("fir_no"));
            caseDetails.setFiling_date(rs.getDate("filing_date"));
            caseDetails.setCase_date(rs.getDate("case_date"));
            caseDetails.setAdvocate_id(rs.getString("advocate_id"));
            caseDetails.setJudgement(rs.getString("judgement"));
            caseDetailsList.add(caseDetails);
        }
        return caseDetailsList;
    }

    

}
