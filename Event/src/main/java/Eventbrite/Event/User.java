package Eventbrite.Event;



public class User {
	private String firstName, lastName, username, password, email;
	private boolean adminRights, corporate;
	
	public User()
	{
		
	}
	
	public User(String first, String last, String uName)
	{
		firstName = first;
		lastName = last;
		username = uName;
	}
	
	public User(String first, String last, String userName, String pw, String emailAddress, boolean corp, boolean admin) {
		username = userName;
		password = pw;
		firstName = first;
		lastName = last;
		email = emailAddress;
		corporate = corp;
		adminRights = admin;
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
	
	public Boolean isCorporate() {
		return corporate;
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
	
	public void setCorporate(Boolean corporate)
	{
		this.corporate = corporate;
	}
	
	public boolean getCorporate()
	{
		return corporate;
	}
//	private void encryptPassword()
//	{
//		
//	}

}
