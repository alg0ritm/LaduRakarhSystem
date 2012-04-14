package ttu.rakarh1.backend.model.data;

public class User
{
	private String firstName;
	private String lastName;
	private int userAccount;
	private String userName;
	
	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public int getUserAccount()
	{
		return userAccount;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
		
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
		
	}

	public void setUserAccount(int userAccount)
	{
		this.userAccount = userAccount;
		
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
		
	}

	public String getUserName()
	{
		return this.userName;
	}

}
