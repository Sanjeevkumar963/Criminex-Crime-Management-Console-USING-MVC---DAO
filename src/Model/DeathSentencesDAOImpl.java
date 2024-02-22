package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.DAO.DeathSentencesDAO;
import Controller.DTO.DeathSentences;
import Database.DBConnection;

public class DeathSentencesDAOImpl implements DeathSentencesDAO 
{

	@Override
	public List<DeathSentences> retrieveAll() throws SQLException 
	{
		List<DeathSentences> deathSentencesList = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM DeathSentences");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) 
		{
			DeathSentences deathSentence = new DeathSentences();
			deathSentence.setPrisoner_id(rs.getString("prisoner_id"));
			deathSentence.setDate_of_hanging(rs.getDate("date_of_hanging"));
			deathSentence.setWitness_name(rs.getString("witness_name"));
			deathSentencesList.add(deathSentence);
		}
		return deathSentencesList;
	}

	@Override
	public int insert(DeathSentences deathSentence) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("INSERT INTO DeathSentences (prisoner_id, date_of_hanging, witness_name) VALUES (?, ?, ?)");
		ps.setString(1, deathSentence.getPrisoner_id());
		ps.setDate(2, new java.sql.Date(deathSentence.getDate_of_hanging().getTime()));
		ps.setString(3, deathSentence.getWitness_name());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int update(DeathSentences deathSentence, String change) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("UPDATE DeathSentences SET witness_name = ? WHERE prisoner_id = ?");
		ps.setString(1, change);
		ps.setString(2, deathSentence.getPrisoner_id());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}

	@Override
	public int delete(DeathSentences deathSentence) throws SQLException 
	{
		Connection con = DBConnection.getConnection();
		PreparedStatement ps = con.prepareStatement("DELETE FROM DeathSentences WHERE prisoner_id = ?");
		ps.setString(1, deathSentence.getPrisoner_id());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}


}
