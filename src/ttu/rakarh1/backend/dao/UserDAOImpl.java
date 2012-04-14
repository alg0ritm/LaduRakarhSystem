package ttu.rakarh1.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.forms.LoginForm;

public class UserDAOImpl implements UserDAO
{
	String sql;
	Connection db;
	PreparedStatement ps;
	Statement st;
	ResultSet ResultRset;
	ttu.rakarh1.backend.dao.dbconnection dbconnection;
	int result = 0;

	@Override
	public User getAuth(LoginForm loginForm)
	{
		User user = null;
		try
		{
			String username = loginForm.getUsername();
			String password = loginForm.getPassword();
			db = dbconnection.getConnection();
			sql = "SELECT E.employee,UA.user_account, UA.username, P.first_name, P.last_name FROM employee E INNER JOIN user_account UA ON E.employee = UA.subject_fk INNER JOIN person P ON E.person_fk = P.person WHERE UA.username='"
				+ username + "' AND UA.passw='" + password+ "'";
			MyLogger.LogMessage("Login sql" + sql);
			ps = db.prepareStatement(sql);
			ResultRset = ps.executeQuery();

			while (ResultRset.next())
			{
				user = new User();
				user.setUserName(ResultRset.getString("username"));
				user.setFirstName(ResultRset.getString("first_name"));
				user.setLastName(ResultRset.getString("last_name"));
				user.setUserAccount(ResultRset.getInt("user_account"));
			}
			MyLogger.LogMessage("UserLogged");
		}
		catch (Exception E)
		{
			MyLogger.Log("getAuth", E.getMessage());
		}
		return user;
	}

	@Override
	public void setDbConnection(dbconnection dbconnection)
	{
		this.dbconnection = dbconnection;
	}
}
