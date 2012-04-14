package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.model.data.User;
import ttu.rakarh1.backend.model.service.LoginService;
import ttu.rakarh1.backend.model.serviceErrors.LoginServiceErrors;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.LoginServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.LoginForm;
import ttu.rakarh1.web.forms.LoginRequestProcessor;


public class getUserAuthenticationCommand implements Command
{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException
	{
		HashMap AllErrors = null;
		HashMap ProductServiceErrors = null;
		User user = null;
		int loggedUserId = 0;
		int operation_result = 0;
		LoginServiceFactory loginServiceFactory = new LoginServiceFactory();
		LoginService loginService = null;
		LoginForm loginForm = null;
		LoginRequestProcessor loginRequestProcessor = null;
		loginRequestProcessor = new LoginRequestProcessor();
		loginForm = loginRequestProcessor.getFormDataFromRequest(request);
		MyLogger.LogMessage("Started LoginCommand execution");

		if (loginForm.getModelDataOK() == 1)
		{
			MyLogger.LogMessage("LoginForm.getModelDataOK() == 1");
			loginService = loginServiceFactory.getService();
			user = loginService.authUser(loginForm);
			if (loginService.getActionResult() == 1)
			{
				MyLogger.LogMessage("loginService.getActionResult() == 1");
				HttpSession session = request.getSession(true);
				/*session.setAttribute("user", user.getUserAccount());
				session.setAttribute("username", user.getUserName());
				session.setAttribute("first_name", user.getFirstName());
				session.setAttribute("last_name", user.getLastName());*/
				session.setAttribute("user", user);
				operation_result = 1;
			} else
			{

				AllErrors = new HashMap();

				if (loginService.getErrors() != null)
				{
					LoginServiceErrors loginServiceErrors = LoginServiceErrors.getErrors();
					AllErrors.putAll((Map) loginServiceErrors);
				}

				operation_result = 0;
			}
		}
		return operation_result;

	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}
}
