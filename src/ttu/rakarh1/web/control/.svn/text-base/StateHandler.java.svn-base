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
	private StateEnum lastState;
	HorisontalMenu horisontalMenu;
	private Product lastProduct;


	private ProductCatalog selectedCatalog;
	private HashMap<String, String> map;
	private HashMap<String, String> popupNotifications = new HashMap<String,String>();
	private ArrayList<Command> negativeResultCommands = new ArrayList<Command>();


	public ArrayList<Command> getNegativeResultCommands()
	{
		return negativeResultCommands;
	}

	public void setNegativeResultCommands(ArrayList<Command> negativeResultCommands)
	{
		this.negativeResultCommands = negativeResultCommands;
	}

	public Product getLastProduct()
	{
		return lastProduct;
	}

	public ProductCatalog getSelectedCatalog()
	{
		return selectedCatalog;
	}

	public void setSelectedCatalog(ProductCatalog selectedCatalog)
	{
		this.selectedCatalog = selectedCatalog;
	}

	public void setLastProduct(Product lastProduct)
	{
		this.lastProduct = lastProduct;
	}

	public HorisontalMenu getHorisontalMenu()
	{
		return horisontalMenu;
	}

	public void setHorisontalMenu(HorisontalMenu horisontalMenu)
	{
		this.horisontalMenu = horisontalMenu;
	}

	public StateEnum getLastState()
	{
		return lastState;
	}

	public void setLastState(StateEnum lastState)
	{
		this.lastState = lastState;
	}

	public HorisontalMenu getMenuVisibility() {

		horisontalMenu = new HorisontalMenu();
		horisontalMenu.setSelectedCatalog(selectedCatalog);
		horisontalMenu.setSelectedProduct(lastProduct);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("test", "testik");
		this.map = map;
		horisontalMenu.setMap(map);
		if(lastState==null)
			lastState = StateEnum.INIT;

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

	public HashMap<String, String> getPopupNotifications()
	{
		return popupNotifications;
	}

	public void addPopupNotification(String key, String value)
	{
		popupNotifications.put(key, value);

	}

	public void addNegativeResultCommandExecutions(Command negativeResultCommand)
	{
		negativeResultCommands.add(negativeResultCommand);

	}


}
