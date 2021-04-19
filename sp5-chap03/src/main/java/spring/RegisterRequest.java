package spring;

public class RegisterRequest {
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password) 
	{
		this.password= password;
	}
	
	public String getPassword() 
	{
		return this.password;
	}
	
	
	public String getConfirmPassword()
	{
		return password;
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		this.confirmPassword = confirmPassword;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public boolean isPasswordEqualToConfirmPassword() 
	{
		return this.confirmPassword.equals(this.password);
	}

}
