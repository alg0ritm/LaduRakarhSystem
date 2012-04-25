package ttu.rakarh1.web.control;

import java.util.ArrayList;
import java.util.HashMap;

import ttu.rakarh1.backend.enums.StateEnum;
import ttu.rakarh1.backend.model.data.HorisontalMenu;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.web.control.command.Command;

public class StateHandler
{
	HorisontalMenu horisontalMenu;
	private Product lastProduct;
	private StateEnum lastState;


	private HashMap<String, String> map;
	private ArrayList<Command> negativeResultCommands = new ArrayList<Command>();
	private final HashMap<String, String> popupNotifications = new HashMap<String,String>();
	private ProductCatalog selectedCatalog;


	public void addNegativeResultCommandExecutions(final Command negativeResultCommand)
	{
		negativeResultCommands.add(negativeResultCommand);

	}

	public void addPopupNotification(final String key, final String value)
	{
		popupNotifications.put(key, value);

	}

	public HorisontalMenu getHorisontalMenu()
	{
		return horisontalMenu;
	}

	public Product getLastProduct()
	{
		return lastProduct;
	}

	public StateEnum getLastState()
	{
		return lastState;
	}

	public HorisontalMenu getMenuVisibility() {

		horisontalMenu = new HorisontalMenu();
		horisontalMenu.setSelectedCatalog(selectedCatalog);
		if(selectedCatalog==null) {
			horisontalMenu.setBasicSearch(true);
		}
		horisontalMenu.setSelectedProduct(lastProduct);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "testik");
		this.map = map;
		horisontalMenu.setMap(map);
		if(lastState==null)
		{
			lastState = StateEnum.INIT;
		}

		switch(lastState) {
			case INIT:
				horisontalMenu.setAdd(false);
				horisontalMenu.setLogOut(true);
				horisontalMenu.setMove(false);
				horisontalMenu.setRemoveFromTheAccount(false);
				horisontalMenu.setSearch(true);
				horisontalMenu.setTakeOnTheAccount(false);
				horisontalMenu.setRemoveItems(false);
				break;
			case SEARCH:
				horisontalMenu.setAdd(true);
				horisontalMenu.setLogOut(true);
				horisontalMenu.setMove(false);
				horisontalMenu.setRemoveFromTheAccount(false);
				horisontalMenu.setSearch(true);
				horisontalMenu.setTakeOnTheAccount(false);
				horisontalMenu.setRemoveItems(true);
				break;
			case EDIT:
				horisontalMenu.setAdd(false);
				horisontalMenu.setLogOut(true);
				horisontalMenu.setMove(true);
				horisontalMenu.setRemoveFromTheAccount(true);
				horisontalMenu.setSearch(true);
				horisontalMenu.setTakeOnTheAccount(true);
				horisontalMenu.setRemoveItems(false);
				break;
			case MOVE:
				horisontalMenu.setAdd(true);
				horisontalMenu.setLogOut(true);
				horisontalMenu.setMove(false);
				horisontalMenu.setRemoveFromTheAccount(false);
				horisontalMenu.setSearch(true);
				horisontalMenu.setTakeOnTheAccount(false);
				horisontalMenu.setRemoveItems(false);
				break;
			case TAKEN_ON_THE_ACCOUNT:
				horisontalMenu.setAdd(true);
				horisontalMenu.setLogOut(true);
				horisontalMenu.setMove(true);
				horisontalMenu.setRemoveFromTheAccount(true);
				horisontalMenu.setSearch(true);
				horisontalMenu.setTakeOnTheAccount(false);
				horisontalMenu.setRemoveItems(true);
				break;

		}

		return horisontalMenu;

	}

	public ArrayList<Command> getNegativeResultCommands()
	{
		return negativeResultCommands;
	}

	public HashMap<String, String> getPopupNotifications()
	{
		return popupNotifications;
	}

	public ProductCatalog getSelectedCatalog()
	{
		return selectedCatalog;
	}

	public void setHorisontalMenu(final HorisontalMenu horisontalMenu)
	{
		this.horisontalMenu = horisontalMenu;
	}

	public void setLastProduct(final Product lastProduct)
	{
		this.lastProduct = lastProduct;
	}

	public void setLastState(final StateEnum lastState)
	{
		this.lastState = lastState;
	}

	public void setNegativeResultCommands(final ArrayList<Command> negativeResultCommands)
	{
		this.negativeResultCommands = negativeResultCommands;
	}

	public void setSelectedCatalog(final ProductCatalog selectedCatalog)
	{
		this.selectedCatalog = selectedCatalog;
	}


}
