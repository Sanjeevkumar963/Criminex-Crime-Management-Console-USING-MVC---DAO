package Controller.DTO;
import java.util.Date;
public class DeathSentences 
{
	private String prisoner_id;
	private Date date_of_hanging;
	private String witness_name;
	
	public DeathSentences(String prisoner_id, Date date_of_hanging, String witness_name) 
	{
		this.prisoner_id = prisoner_id;
		this.date_of_hanging = date_of_hanging;
		this.witness_name = witness_name;
	}

	public DeathSentences() {
		// TODO Auto-generated constructor stub
	}

	public String getPrisoner_id() 
	{
		return prisoner_id;
	}

	public void setPrisoner_id(String prisoner_id) 
	{
		this.prisoner_id = prisoner_id;
	}

	public Date getDate_of_hanging() 
	{
		return date_of_hanging;
	}

	public void setDate_of_hanging(Date date_of_hanging) 
	{
		this.date_of_hanging = date_of_hanging;
	}

	public String getWitness_name() 
	{
		return witness_name;
	}

	public void setWitness_name(String witness_name)
	{
		this.witness_name = witness_name;
	}

	
}
