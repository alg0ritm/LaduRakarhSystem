package ttu.rakarh1.web.control.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.web.control.StateHandler;

public class RemoveFromTheAccountCommand implements Command
{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{

		return 0;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
