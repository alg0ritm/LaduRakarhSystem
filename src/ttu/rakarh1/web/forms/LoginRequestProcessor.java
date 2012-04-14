package ttu.rakarh1.web.forms;

import javax.servlet.http.HttpServletRequest;

public class LoginRequestProcessor
{

	public LoginForm getFormDataFromRequest(HttpServletRequest request)
	{
		LoginForm loginForm = null;
		if(request.getParameter("username")!=null)
			if(request.getParameter("password")!=null)
			{
				loginForm = new LoginForm();
				loginForm.setUsername(request.getParameter("username"));
				loginForm.setPassword(request.getParameter("password"));
				loginForm.setModelDataOK();
			}
		
		return loginForm;
		
	}

}
