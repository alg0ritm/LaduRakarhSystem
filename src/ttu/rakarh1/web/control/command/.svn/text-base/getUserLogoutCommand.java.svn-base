package ttu.rakarh1.web.control.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.StateHandler;

public class getUserLogoutCommand implements Command
{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
		if(session!=null)
		{
			MyLogger.LogMessage("session invalidated");
			session.invalidate();
		}
		return 0;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
