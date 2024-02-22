package Controller.DTO;
import java.util.Date;
public class RemandDetails 
{
	private String suspect_id;
	private String station_id;
	private Date remand_till_date;
	
	public RemandDetails(String suspect_id, String station_id, Date remand_till_date) 
	{
		this.suspect_id = suspect_id;
		this.station_id = station_id;
		this.remand_till_date = remand_till_date;
	}

	public RemandDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getSuspect_id() 
	{
		return suspect_id;
	}

	public void setSuspect_id(String suspect_id) 
	{
		this.suspect_id = suspect_id;
	}

	public String getStation_id() 
	{
		return station_id;
	}

	public void setStation_id(String station_id)
	{
		this.station_id = station_id;
	}

	public Date getRemand_till_date() 
	{
		return remand_till_date;
	}

	public void setRemand_till_date(Date remand_till_date) 
	{
		this.remand_till_date = remand_till_date;
	}
	
	
	
	
}
