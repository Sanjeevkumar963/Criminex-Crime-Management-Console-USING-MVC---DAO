package Controller.DTO;
import java.util.Date;
public class PrisonerDetails 
{
	private String prison_id;
	private String prisoner_id;
	private String suspect_id;
	private Date date_of_imprisonment;
	private Date date_of_release;
	
	public PrisonerDetails(String prison_id, String prisoner_id, String suspect_id, Date date_of_improsinment,Date date_of_release) 
	{
		this.prison_id = prison_id;
		this.prisoner_id = prisoner_id;
		this.suspect_id = suspect_id;
		this.date_of_imprisonment = date_of_improsinment;
		this.date_of_release = date_of_release;
	}

	public PrisonerDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getPrison_id() 
	{
		return prison_id;
	}

	public void setPrison_id(String prison_id)
	{
		this.prison_id = prison_id;
	}

	public String getPrisoner_id() 
	{
		return prisoner_id;
	}

	public void setPrisoner_id(String prisoner_id) 
	{
		this.prisoner_id = prisoner_id;
	}

	public String getSuspect_id() 
	{
		return suspect_id;
	}

	public void setSuspect_id(String suspect_id) 
	{
		this.suspect_id = suspect_id;
	}

	public Date getDate_of_imprisonment() 
	{
		return date_of_imprisonment;
	}

	public void setDate_of_imprisonment(Date date_of_improsinment) 
	{
		this.date_of_imprisonment = date_of_improsinment;
	}

	public Date getDate_of_release() 
	{
		return date_of_release;
	}

	public void setDate_of_release(Date date_of_release)
	{
		this.date_of_release = date_of_release;
	}	

	
}
