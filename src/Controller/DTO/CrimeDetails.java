package Controller.DTO;
import java.util.Date;
public class CrimeDetails 
{
	private String fir_no;
	private String suspect_id;
	private String crime;
	private String guilty_status; // initially Not Proven then based on judgement Proven Guilty (or) Proven Guiltless 
	private Date date_of_arrest;
	
	
	public CrimeDetails(String fir_no, String suspect_id, String crime, String guilty_status, Date date_of_arrest)
	{
		this.fir_no = fir_no;
		this.suspect_id = suspect_id;
		this.crime = crime;
		this.guilty_status = guilty_status;
		this.date_of_arrest = date_of_arrest;
	}


	public CrimeDetails() {
		// TODO Auto-generated constructor stub
	}


	public String getFir_no() 
	{
		return fir_no;
	}


	public void setFir_no(String fir_no) 
	{
		this.fir_no = fir_no;
	}


	public String getSuspect_id() 
	{
		return suspect_id;
	}


	public void setSuspect_id(String suspect_id) 
	{
		this.suspect_id = suspect_id;
	}


	public String getCrime() 
	{
		return crime;
	}


	public void setCrime(String crime) 
	{
		this.crime = crime;
	}


	public String getGuilty_status() 
	{
		return guilty_status;
	}


	public void setGuilty_status(String guilty_status) 
	{
		this.guilty_status = guilty_status;
	}


	public Date getDate_of_arrest() 
	{
		return date_of_arrest;
	}


	public void setDate_of_arrest(Date date_of_arrest)
	{
		this.date_of_arrest = date_of_arrest;
	}

}
