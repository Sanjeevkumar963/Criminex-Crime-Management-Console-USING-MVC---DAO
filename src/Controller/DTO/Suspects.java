package Controller.DTO;
import java.util.Date;
public class Suspects 
{
	private String suspect_id;
	private String name;
	private String gender;
	private Date date_of_birth;
	private int no_of_cases;
	
	
	public Suspects(String suspect_id, String name, String gender, Date date_of_Birth,int no_of_cases) 
	{
		this.suspect_id = suspect_id;
		this.name = name;
		this.gender = gender;
		this.date_of_birth = date_of_Birth;
		this.no_of_cases=no_of_cases;
		
	}


	public Suspects() {
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


	public String getName() 
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}


	public String getGender() 
	{
		return gender;
	}


	public void setGender(String gender) 
	{
		this.gender = gender;
	}


	public Date getDate_of_Birth() 
	{
		return date_of_birth;
	}


	public void setDate_of_Birth(Date date_of_Birth) 
	{
		date_of_birth = date_of_Birth;
	}


	public int getNo_of_cases() 
	{
		return no_of_cases;
	}


	public void setNo_of_cases(int no_of_cases) 
	{
		this.no_of_cases = no_of_cases;
	}
	
	@Override
	public String toString() 
	{
		return "Suspects [suspect_id=" + suspect_id + ", name=" + name + ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", no_of_crimes=" + no_of_cases + "]";
	}

}
