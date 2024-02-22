package Controller.DTO;

public class LoginDetails 
{
	private String email;
	private String password;
	private String aadhar_number;
	private String phone_number;
	private String role;
	
	public LoginDetails(String email, String password, String aadhar_number, String phone_number, String role)
	{
		this.email = email;
		this.password = password;
		this.aadhar_number = aadhar_number;
		this.phone_number = phone_number;
		this.role = role;
	}

	public LoginDetails() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getAadhar_number() 
	{
		return aadhar_number;
	}

	public void setAadhar_number(String aadhar_number) 
	{
		this.aadhar_number = aadhar_number;
	}

	public String getPhone_number() 
	{
		return phone_number;
	}

	public void setPhone_number(String phone_number) 
	{
		this.phone_number = phone_number;
	}

	public String getRole() 
	{
		return role;
	}

	public void setRole(String role) 
	{
		this.role = role;
	}
	
	

}
