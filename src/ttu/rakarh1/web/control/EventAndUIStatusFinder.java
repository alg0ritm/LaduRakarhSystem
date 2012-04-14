package ttu.rakarh1.web.control;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.log.MyLogger;

public class EventAndUIStatusFinder
{

	public HashMap find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		HashMap events_and_statuses = new HashMap();
		int selected_product_catalog = 0;
		try
		{
			String username = "";
			String passw = "";
			if (request.getParameter("username") != null)
			{
				MyLogger.LogMessage("Login command 1");
				username = request.getParameter("username");
			}

			if (request.getParameter("password") != null)
			{
				MyLogger.LogMessage("Login command 2");
				passw = request.getParameter("password");
			}

			if ((!(username.equals(""))) && (!(passw.equals(""))))
			{
				MyLogger.LogMessage("Login command added to events/statuses");
				events_and_statuses.put("login_user", "ui_status");
			}
			if(request.getParameter("logout")!=null)
			{
				MyLogger.LogMessage("Logout command added to events/statuses");
				events_and_statuses.put("logout_user", "ui_status");
			}

			if (request.getParameter("catalog") != null)
			{
				try
				{
					String catalog_id = request.getParameter("catalog");
					selected_product_catalog = Integer.parseInt(catalog_id);
					events_and_statuses.put("show_products_in_catalog", "ui_status");
					MyLogger.LogMessage("put catalog id to events and statuses");
				} catch (Exception ex)
				{
					MyLogger.Log("EventAndUIStatusFinder.find() - not numeric catalog id:",
							ex.getMessage());
				}
			}

			if (request.getParameter("product_id") != null)
			{
				if (request.getParameter("user_action") == null)
				{
					MyLogger.LogMessage("User action");
					try
					{
						String product_id = request.getParameter("product_id");
						Integer.parseInt(product_id);
					} catch (Exception ex)
					{
						MyLogger.Log("EventAndUIStatusFinder.find() - not numeric product id:",
								ex.getMessage());
					}

					events_and_statuses.put("show_product", "ui_status");
					events_and_statuses.put("show_item_type_attributes", "ui_status");

					MyLogger.LogMessage("added both parameters in ui");
				}
			}

			if (request.getParameter("searchform") != null)
			{
				MyLogger.LogMessage("Search Form");
				events_and_statuses.put("search_products", "ui_status");
				if (request.getParameter("catalog") != null)
				{
					events_and_statuses.put("show_item_type_attributes", "ui_status");
					MyLogger.LogMessage("added both parameters in ui");
				}

			}

			/*
			 * if(request.getParameter("show_item_type_attributes")!=null) {
			 * events_and_statuses.put("show_item_type_attributes","ui_status");
			 * }
			 */
			if (request.getParameter("user_action") != null)
			{
				String user_action = request.getParameter("user_action");

				if ((user_action.equals("new_product_form")) && (selected_product_catalog != 0))
				{
					events_and_statuses.put("new_product_form", "event");
					events_and_statuses.put("show_item_type_attributes", "ui_status");
				}

				if (user_action.equals("insert_product"))
				{

					events_and_statuses.put("show_item_type_attributes", "ui_status");
					events_and_statuses.put("insert_product", "event");
				}

				if (user_action.equals("update_product"))
				{
					MyLogger.LogMessage("Update Product");
					events_and_statuses.put("update_product", "event");
					if (request.getParameter("catalog") != null)
					{
						events_and_statuses.put("show_item_type_attributes", "ui_status");
						MyLogger.LogMessage("added item_type_attributes status");
					}
				}
				if (user_action.equals("move_product_form"))
				{
					MyLogger.LogMessage("Move Product");
					events_and_statuses.put("move_product_form", "event");
				}
				if (user_action.equals("take_product_form"))
				{
					MyLogger.LogMessage("Take Product");
					events_and_statuses.put("take_product_form", "event");
				}
				if (user_action.equals("take_product"))
				{
					MyLogger.LogMessage("Take Product");
					events_and_statuses.put("take_product", "event");
				}
				if (user_action.equals("remove_product_form"))
				{
					MyLogger.LogMessage("Remove Product");
					events_and_statuses.put("remove_product_form", "event");
				}
				if (user_action.equals("remove_product"))
				{
					MyLogger.LogMessage("Remove Product");
					events_and_statuses.put("remove_product", "event");
				}
				if (user_action.equals("move_product"))
				{
					MyLogger.LogMessage("Move Product");
					events_and_statuses.put("move_product", "event");
				}
				if(user_action.equals("remove_items_form")) {
					MyLogger.LogMessage("Remove items form initialization");
					events_and_statuses.put("remove_items_form", "event");
				}
				if(user_action.equals("remove_items")) {
					MyLogger.LogMessage("Remove items action");
					events_and_statuses.put("remove_items", "event");
				}


			}

		} catch (Exception ex)
		{
			MyLogger.Log("EventAndUIStatusFinder.find():", ex.getMessage());
		}
		return events_and_statuses;
	}
}
