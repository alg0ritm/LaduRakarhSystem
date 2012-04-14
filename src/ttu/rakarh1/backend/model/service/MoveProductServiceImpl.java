package ttu.rakarh1.backend.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import ttu.rakarh1.backend.dao.ItemStoreDAO;
import ttu.rakarh1.backend.dao.ItemStoreDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public class MoveProductServiceImpl implements MoveProductService
{

	/*public ItemStore getStoreFrom(int storeFrom, Product product)
	{
		ItemStore storeFrom = null;
		ItemStoreDAO itemStoreDAO = null;
		itemStoreDAO = new ItemStoreDAO();
		storeFrom = new ItemStore();
		itemStoreDAO.
		storeFrom = new
		return null;
	}*/

	@Override
	public ArrayList<ItemStore> getAvailStoresForItem(Product item)
	{

		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		ItemStoreDAO itemStoreDAO = new ItemStoreDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		itemStoreDAO.setDbConnection(dbconnection);
		storeList = itemStoreDAO.getStoreForItem(item);

		return storeList;
	}

	@Override
	public ArrayList<ItemStore> getAvailStores(ArrayList<ItemStore> itemStoreList)
	{
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		ItemStoreDAO itemStoreDAO = new ItemStoreDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		itemStoreDAO.setDbConnection(dbconnection);
		try
		{
			storeList = itemStoreDAO.getAvItemStores();
			recombinateStores(itemStoreList,storeList);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return storeList;

	}

	private void recombinateStores(ArrayList<ItemStore> itemStoreList,ArrayList<ItemStore> storeList)
	{
		int startIndexSelected = 0;
		int startIndexAvailable = 0;
		int nextIndex = 1;
		ItemStore selectedStore = itemStoreList.get(startIndexSelected);
		ItemStore avaialbleStore = storeList.get(startIndexAvailable);
		ItemStore nextAvailableStore = storeList.get(nextIndex);
		ItemStore tempStore = null;


		if(selectedStore.getStore() == avaialbleStore.getStore()) {
			tempStore = avaialbleStore;
			avaialbleStore = nextAvailableStore;
			nextAvailableStore = tempStore;
			storeList.set(startIndexSelected, avaialbleStore);
			storeList.set(nextIndex, nextAvailableStore);
		}

		/*var selectSourceIndex = document.getElementById(selectSource).selectedIndex;
		var selectSourceValue =document.getElementById(selectSource).options;
		var valueToHide = selectSourceValue[selectSourceIndex].text;

		var selectDestinationIndex=document.getElementById(selectDestination).selectedIndex;
		var selectDestinationValue=document.getElementById(selectDestination).options;
		var previousSelection = selectDestinationValue.length-1;
		var tempIndex;
		var tempValue;

		for(i=0; i<selectSourceValue.length; i++) {

		 if(selectDestinationValue[i].text == valueToHide) {
			 if(selectDestinationValue[selectDestinationIndex]==selectDestinationValue[i]) {
				 tempIndex = selectDestinationValue[selectDestinationIndex].index;
				 tempValue = selectDestinationValue[selectDestinationIndex].text;

			     selectDestinationValue[selectDestinationIndex].index = selectDestinationValue[previousSelection].index;
			     selectDestinationValue[selectDestinationIndex].text = selectDestinationValue[previousSelection].text;

			     selectDestinationValue[previousSelection].index = tempIndex;
			     selectDestinationValue[previousSelection].text = tempValue;
			     selectDestinationValue[previousSelection].style.display="none";
			 }
			 else
			 selectDestinationValue[i].style.display="none";
		}
		 else {
			selectDestinationValue[i].style.display="block";
		 	previousSelection = selectDestinationValue[i];
		 }
		}*/



	}

	@Override
	public ItemStore getStoreById(int chosenStore)
	{
		ItemStoreDAO itemStoreDAO = new ItemStoreDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		itemStoreDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		try
		{
			itemStore = itemStoreDAO.getStoreById(chosenStore);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return itemStore;
	}

	@Override
	public int takeProductOnTheAccount(TakeOnTheAccountForm takeOnTheAccountForm)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ItemStore> getAvailStores()
	{
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		ItemStoreDAO itemStoreDAO = new ItemStoreDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		itemStoreDAO.setDbConnection(dbconnection);
		try
		{
			storeList = itemStoreDAO.getAvItemStores();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return storeList;

	}



}
