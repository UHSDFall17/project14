package Eventbrite.Event;



public class User {
	private String firstName, lastName, username, password, email;
	private Boolean adminRights;
	
	public User()
	{
		
	}
	
	public User(String first, String last, String userName, String pw, String emailAddress) {
		username = userName;
		password = pw;
		firstName = first;
		lastName = last;
		email = emailAddress;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public Boolean getAdminRights()
	{
		return adminRights;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	public void setPassword(String password)
	{
		//password = encryptPassword();
		this.password = password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setAdminRights(Boolean adminRights)
	{
		this.adminRights = adminRights;
	}
	
//	private void encryptPassword()
//	{
//		
//	}

}
