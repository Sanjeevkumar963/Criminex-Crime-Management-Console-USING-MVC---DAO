package Controller.DAO;

import java.sql.SQLException;
import java.util.List;

import Controller.DTO.*;

public interface CaseDetailsDAO extends DAO<CaseDetails> 
{
	int getNumberOfCasesByFirNo(String suspectId) throws SQLException;
	
    CaseDetails getCaseDetailsByCaseNo(String caseNo) throws SQLException;
    
    List<CaseDetails> retrieveCasesByJudgement(String judgement) throws SQLException;

}
