package ttu.rakarh1.backend.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public interface ItemStoreDAO
{
	public ArrayList<ItemStore> getAvItemStores() throws SQLException;
	public ArrayList<ItemStore> getStoreForItem(Product product);
	public int UpdateItemStore(ItemStore store, Product product);
	int updateItemStoreCmpl(ItemStore prevStore, ItemStore newStore, Product product);
	public void setDbConnection(dbconnection dbconnection);
	public ItemStore getStoreById(int id);
	public int takeProductOnTheAccount(TakeOnTheAccountForm takeOnTheAccountForm);



}
