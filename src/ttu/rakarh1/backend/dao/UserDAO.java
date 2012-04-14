package ttu.rakarh1.backend.dao;

import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.web.forms.LoginForm;

public interface UserDAO
{

	public User getAuth(LoginForm loginForm);
	public void setDbConnection(dbconnection dbconnection);
	
}
