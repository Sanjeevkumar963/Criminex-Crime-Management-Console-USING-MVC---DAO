package Controller.DTO;
import java.util.Date;
public class CaseDetails 
{
	private String case_no;
	private String fir_no;
	private Date filing_date;
	private Date case_date;
	private String advocate_id;
	private String judgement; // imprisoned,released,next session,reappeal
	
	public CaseDetails(String case_no, String fir_no, Date filing_date, Date case_date, String advocate_id,String judgement) 
	{
		this.case_no = case_no;
		this.fir_no = fir_no;
		this.filing_date = filing_date;
		this.case_date = case_date;
		this.advocate_id = advocate_id;
		this.judgement = judgement;
	}

	public CaseDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getCase_no() 
	{
		return case_no;
	}

	public void setCase_no(String case_no) 
	{
		this.case_no = case_no;
	}

	public String getFir_no() 
	{
		return fir_no;
	}

	public void setFir_no(String fir_no) 
	{
		this.fir_no = fir_no;
	}

	public Date getFiling_date() 
	{
		return filing_date;
	}

	public void setFiling_date(Date filing_date)
	{
		this.filing_date = filing_date;
	}

	public Date getCase_date() 
	{
		return case_date;
	}

	public void setCase_date(Date case_date) 
	{
		this.case_date = case_date;
	}

	public String getAdvocate_id() 
	{
		return advocate_id;
	}

	public void setAdvocate_id(String advocate_id) 
	{
		this.advocate_id = advocate_id;
	}

	public String getJudgement() 
	{
		return judgement;
	}

	public void setJudgement(String judgement) 
	{
		this.judgement = judgement;
	}
	
	
}
