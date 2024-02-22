package Controller.DAO;

import java.sql.SQLException;

import Controller.DTO.LoginDetails;

public interface LoginDetailsDAO extends DAO<LoginDetails>
{
	LoginDetails getByEmail(String email,String password) throws SQLException;
}
