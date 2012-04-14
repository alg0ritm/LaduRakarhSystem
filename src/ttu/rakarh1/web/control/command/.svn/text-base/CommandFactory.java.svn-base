package ttu.rakarh1.web.control.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.log.MyLogger;

public class CommandFactory
{

	HashMap my_events_and_statuses = null;

	public List<Command> getCommands(HashMap events_and_statuses)
	{
		my_events_and_statuses = events_and_statuses;
		System.out.println("TEST JREBEl");

		List<Command> CommandList = new ArrayList<Command>();
		Command Command = null;

		try
		{
			Command = new getProductCatalogTreeCommand();
			CommandList.add(Command);

			if (getStatusOrEventByName("login_user"))
			{
				Command = new getUserAuthenticationCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("logout_user"))
			{
				Command = new getUserLogoutCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("new_product_form"))
			{
				Command = new newProductFormCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("insert_product"))
			{
				Command = new insertProductCommand();
				CommandList.add(Command);

			}

			if (getStatusOrEventByName("update_product"))
			{
				Command = new updateProductCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("remove_items_form"))
			{
				Command = new getRemoveItemsCommand();
				CommandList.add(Command);
			}



			if (getStatusOrEventByName("show_products_in_catalog"))
			{
				Command = new getProductsByCatalogCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("remove_items"))
			{
				Command = new RemoveItemsCommand();
				CommandList.add(Command);
			}

			if (getStatusOrEventByName("search_products"))
			{
				Command = new searchProductCommand();
				CommandList.add(Command);
			}


			if (getStatusOrEventByName("show_product"))
			{
				Command = new getProductCommand();
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("show_item_type_attributes"))
			{
				Command = new getItemTypeAttributesCommand();
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("take_product_form"))
			{
				Command = new getTakeOnTheAccountCommand(ProductTransactionTypes.TAKE);
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("take_product"))
			{
				Command = new TakeOnTheAccountCommand(ProductTransactionTypes.TAKE);
				CommandList.add(Command);
				Command = new getProductCommand();
				CommandList.add(Command);
				Command = new getItemTypeAttributesCommand();
				CommandList.add(Command);
				Command = new getProductsByCatalogCommand();
				CommandList.add(Command);

			}
			if (getStatusOrEventByName("remove_product_form"))
			{
				Command = new getTakeOnTheAccountCommand(ProductTransactionTypes.REMOVE);
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("move_product_form"))
			{
				Command = new getTakeOnTheAccountCommand(ProductTransactionTypes.MOVE);
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("move_product"))
			{
				Command = new TakeOnTheAccountCommand(ProductTransactionTypes.MOVE);
				CommandList.add(Command);
				Command = new getProductCommand();
				CommandList.add(Command);
				Command = new getItemTypeAttributesCommand();
				CommandList.add(Command);
				Command = new getProductsByCatalogCommand();
				CommandList.add(Command);
			}
			if (getStatusOrEventByName("remove_product"))
			{
				Command = new TakeOnTheAccountCommand(ProductTransactionTypes.REMOVE);
				CommandList.add(Command);
				Command = new getProductCommand();
				CommandList.add(Command);
				Command = new getItemTypeAttributesCommand();
				CommandList.add(Command);
				Command = new getProductsByCatalogCommand();
				CommandList.add(Command);

			}

		} catch (Exception ex)
		{
			MyLogger.Log("CommandFactory.getCommands():", ex.getMessage());
		}
		return CommandList;
	}

	private boolean getStatusOrEventByName(String event_or_status_name)
	{
		String event_name = null;
		boolean is_event_or_status_with_this_name = false;
		if (my_events_and_statuses != null)
		{
			event_name = (String) my_events_and_statuses.get(event_or_status_name);
			if (event_name != null)
			{
				is_event_or_status_with_this_name = true;
			}

		}

		return is_event_or_status_with_this_name;
	}
}
