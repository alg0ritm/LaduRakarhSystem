package ttu.rakarh1.backend.model.service;

import java.util.HashMap;
import java.util.List;

import ttu.rakarh1.backend.dao.ProductDAO;
import ttu.rakarh1.backend.dao.ProductDAOImpl;
import ttu.rakarh1.backend.dao.UserDAO;
import ttu.rakarh1.backend.dao.UserDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.web.forms.LoginForm;

public class LoginServiceImpl implements LoginService
{
	int actionResult = 0 ;
	@Override
	public User authUser(LoginForm loginForm)
	{
		UserDAO userDAO = new UserDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		userDAO.setDbConnection(dbconnection);
		User user = null;
		user = userDAO.getAuth(loginForm);
		dbconnection.close();
		if(user!=null)
			actionResult=1;
		return user;

	}

	@Override
	public int getActionResult()
	{
		return actionResult;
	}

	@Override
	public int getUserById(int loggedUserId)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getErrors()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
