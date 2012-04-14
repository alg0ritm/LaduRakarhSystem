package ttu.rakarh1.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public class ItemStoreDAOImpl implements ItemStoreDAO
{

	String sql ;
	Connection db ;
	Statement  st ;
	PreparedStatement ps;
    ttu.rakarh1.backend.dao.dbconnection dbconnection ;

    public void setDbConnection(dbconnection dbconnection)
	{
	this.dbconnection = dbconnection ;
	}

	@Override
	public ArrayList<ItemStore> getAvItemStores() throws SQLException
	{
		ItemStore itemStore = null;
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		db = dbconnection.getConnection();
		sql = "Select s.store, s.name from store s" ;
		try{
			ps = db.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				itemStore = new ItemStore();
				itemStore.setStore(rs.getInt("store"));
				itemStore.setName(rs.getString("name"));
				storeList.add(itemStore);
				cnt =  cnt + 1;
			}
			String sql = "";

		}catch(Exception E)
		{
			MyLogger.LogMessage("getAvItemStores() Some error occured");
		}

		return storeList;

	}

	@Override
	public ArrayList<ItemStore> getStoreForItem(Product product)
	{
		ItemStore itemStore = null;
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();

		sql = "Select s.store, s.name, i.item, i.producer_code, iss.item_count from store s inner join item_store iss on iss.store_fk = s.store"+
			" inner join item i on i.item = iss.item_fk where i.item =" + product.getProduct();
		MyLogger.LogMessage("sql " + sql);
		try{
			db = dbconnection.getConnection();
			MyLogger.LogMessage("Before sql Exec");
			ps = db.prepareStatement(sql);
			//ps.setInt(1, product.getProduct());

			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				itemStore = new ItemStore();
				itemStore.setStore(rs.getInt("store"));
				itemStore.setName(rs.getString("name"));
				itemStore.setCount(rs.getInt("item_count"));
				itemStore.setProduct(product);
				storeList.add(itemStore);
			}
		}
		catch(Exception E)
		{
			MyLogger.LogMessage("getStoreForItem() Wrong Store parameters // sql Error");
		}

		return storeList;
	}

	@Override
	public int updateItemStoreCmpl(ItemStore prevStore, ItemStore newStore, Product product)
	{
		ItemStore itemStore = null;
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		int opResult=0;
		try{
			UpdateItemStore(prevStore, product);
			UpdateItemStore(newStore, product);
		}
		catch(Exception E)
		{
			MyLogger.LogMessage("getStoreForItem() Wrong Store parameters // sql Error");
		}
		return opResult;

	}

	public int UpdateItemStore(ItemStore store, Product product)
	{
		ItemStore itemStore = null;
		ArrayList<ItemStore> storeList = new ArrayList<ItemStore>();
		int opResult= 0;
		db = dbconnection.getConnection();
		sql = "Update item_store iss set item_count =? where iss.store_fk = ? and item_fk = ? returning Item_store";
		try{
			ps = db.prepareStatement(sql);
			ps.setInt(1, store.getCount());
			ps.setInt(2, store.getStore());
			ps.setInt(3, product.getProduct());
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				opResult = 1;

		}
		catch(Exception E)
		{
			MyLogger.LogMessage("UpdateItemStore() Wrong Store parameters // sql Error");
		}
		return opResult;
	}

	@Override
	public ItemStore getStoreById(int id)
	{
		ItemStore itemStore = null;
		db = dbconnection.getConnection();
		sql = "Select s.store, s.name from store s where s.store =?" ;
		try{
			ps = db.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				itemStore = new ItemStore();
				itemStore.setStore(rs.getInt("store"));
				itemStore.setName(rs.getString("name"));
			}
			String sql = "";

		}catch(Exception E)
		{
			MyLogger.LogMessage("getAvItemStores() Some error occured");
		}

		return itemStore;
	}

	@Override
	public int takeProductOnTheAccount(TakeOnTheAccountForm takeOnTheAccountForm)
	{
		// TODO Auto-generated method stub
		return 0;
	}


}


