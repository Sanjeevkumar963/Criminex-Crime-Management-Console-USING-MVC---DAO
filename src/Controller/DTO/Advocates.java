package Controller.DTO;
public class Advocates 
{
	private String advocate_id;
	private String advocate_name;
	private String advocate_phone_number;
	
	public Advocates(String advocate_id, String advocate_name, String advocate_phone_number)
	{
		this.advocate_id = advocate_id;
		this.advocate_name = advocate_name;
		this.advocate_phone_number = advocate_phone_number;
	}
	
	public Advocates() {
		// TODO Auto-generated constructor stub
	}

	public String getAdvocate_id() 
	{
		return advocate_id;
	}
	
	public void setAdvocate_id(String advocate_id) 
	{
		this.advocate_id = advocate_id;
	}
	
	public String getAdvocate_name()
	{
		return advocate_name;
	}
	
	public void setAdvocate_name(String advocate_name) 
	{
		this.advocate_name = advocate_name;
	}
	
	public String getAdvocate_phone_number() 
	{
		return advocate_phone_number;
	}
	
	public void setAdvocate_phone_number(String advocate_phone_number) 
	{
		this.advocate_phone_number = advocate_phone_number;
	}
	
	

}
