package ttu.rakarh1.web.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.HorisontalMenu;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.command.Command;
import ttu.rakarh1.web.control.command.CommandFactory;

public class Controller extends HttpServlet
{

	public void init()
	{

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,
			IOException
	{

		try
		{

			EventAndUIStatusFinder EventAndUIStatusFinder = null;
			List<Command> CommandList = null;
			Command Command = null;
			int commandExecutionResult = 0;

			StateHandler stateHandler = new StateHandler();

			EventAndUIStatusFinder = new EventAndUIStatusFinder();

			CommandFactory CommandFactory = new CommandFactory();
			HttpSession session = req.getSession(true);


			CommandList = CommandFactory.getCommands(EventAndUIStatusFinder.find(req, res));
			System.out.println("JREBEL PROSNIS");
			for (int i = 0; i < CommandList.size(); i++)
			{
				Command = CommandList.get(i);
				commandExecutionResult = Command.execute(req, res, stateHandler);
				if(commandExecutionResult == 0) {
					Command.supplyFormWithErrors(req, res, stateHandler);
					break;
				}
			}

			HorisontalMenu menu = stateHandler.getMenuVisibility();
			HashMap<String, String> popupNotifications = stateHandler.getPopupNotifications();
			menu.setMenuResult();
			req.setAttribute(Constant.POPUP_NOTIFICATIONS, popupNotifications);
			req.setAttribute(Constant.HORISONTAL_MENU, menu);

			ServletContext context = getServletConfig().getServletContext();
			context.getRequestDispatcher("/jsp/product.jsp").forward(req, res);

		}

		catch (Exception ex)
		{
			MyLogger.Log("Controller.doGet():", ex.getMessage());
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException,
			ServletException
	{
		doGet(req, res);
	}

}