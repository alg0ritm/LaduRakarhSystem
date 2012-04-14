package ttu.rakarh1.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductExistance;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.forms.OperationOnProductForm;

public class TakeOnTheAccountDAOImpl implements TakeOnTheAccountDAO
{

	String sql;
	Connection db;
	Statement st;
	PreparedStatement ps;
	ttu.rakarh1.backend.dao.dbconnection dbconnection;
	private String itemActionSql = "Insert into item_action(item_action_type_fk, item_fk, store_to_fk, action_date, created_by, item_count, action_price, action_note, created)" +
			"values(?,?,?,?,?,?,?,?,?) returning item_action";

	public void setDbConnection(dbconnection dbconnection)
	{
		this.dbconnection = dbconnection;
	}

	@Override
	public int takeOnTheAccount(Product product)
	{

		return 0;
	}

	@Override
	public Product recalculatePrice(Product product, OperationOnProductForm takeOnTheAccountForm)
	{
		int lisatavate_toote_arv = 0;
		float lisatava_toote_hind = 0;
		int toote_arv_enne_lisamist_kõikides_ladudes_kokku = 0;
		float toote_laohind_enne_lisamist = 0;
		int toote_arv_peale_lisamist = 0;
		float uus_lao_hind = 0;

		ProductDAO productDAO = new ProductDAOImpl();

		String sql = "SELECT SUM(item_count) as sum FROM item_store WHERE item_fk = ?";
		String storePriceSql = "SELECT SUM(iss.item_count) as sum, i.store_price FROM item_store iss "
				+ "inner join item i on i.item = iss.item_fk "
				+ "where i.item = ? "
				+ "group by i.store_price";

		int item = product.getProduct();

		/*
		 * uus_lao_hind=((lisatavate_toote_arv * lisatava_toote_hind) +
		 * (toote_arv_enne_lisamist_kõikides_ladudes_kokku *
		 * toote_laohind_enne_lisamist))/toote_arv_peale_lisamist
		 */

		/*
		 * toote_arv_enne_lisamist_kõikides_ladudes_kokku = SELECT
		 * SUM(item_count) FROM item_store WHERE item_fk = 1;
		 */

		// UPDATE item SET store_price=<uus lao hind> WHERE item=1;

		try
		{
			db = dbconnection.getConnection();
			ps = db.prepareStatement(storePriceSql);
			ps.setInt(1, item);
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				toote_arv_enne_lisamist_kõikides_ladudes_kokku = Integer.parseInt(rs
						.getString("sum"));
				toote_laohind_enne_lisamist = Float.parseFloat(rs.getString("store_price"));
			}

			lisatava_toote_hind = Integer.parseInt(takeOnTheAccountForm.getChosenCost());
			lisatavate_toote_arv = Integer.parseInt(takeOnTheAccountForm.getChosenAmount());
			toote_arv_peale_lisamist = lisatavate_toote_arv
					+ toote_arv_enne_lisamist_kõikides_ladudes_kokku;

			uus_lao_hind = ((lisatavate_toote_arv * lisatava_toote_hind) + (toote_arv_enne_lisamist_kõikides_ladudes_kokku * toote_laohind_enne_lisamist))
					/ toote_arv_peale_lisamist;

			product.setStore_price(uus_lao_hind);

			// productDAO.updateProduct(product);

		} catch (SQLException e)
		{
			MyLogger.LogMessage("recalculatePrice DAO error occuered");
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public int takeProductOnTheAccount(OperationOnProductForm takeOnTheAccountForm, Product product)
	{
		ItemStore itemStore = null;
		int opResult = 0;
		int itemActionResult= 0;
		db = dbconnection.getConnection();
		ArrayList<ItemStore> productItemStores = new ArrayList<ItemStore>();
		ItemStore currentStore = null;
		int currentStoreContainsProduct = 0;
		// float newPrice = recalculatePrice(product,
		// takeOnTheAccountForm.getChosenAmount());

		try
		{
			db.setAutoCommit(false);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// getting all stores where this poduct is registred
		String checkSql = "select iss.item_count,iss.store_fk,iss.item_fk from item_store as iss where iss.item_fk ="
				+ takeOnTheAccountForm.getProduct().getProduct();
		try
		{
			ps = db.prepareStatement(checkSql);
			MyLogger.LogMessage(sql);
			ResultSet itemStoreSelectedSet;
			itemStoreSelectedSet = ps.executeQuery();

			int cnt = 0;
			while (itemStoreSelectedSet.next())
			{
				currentStore = new ItemStore();
				if (itemStoreSelectedSet.getInt("store_fk") == Integer
						.parseInt(takeOnTheAccountForm.getChosenStore()))
					currentStoreContainsProduct = 1;
				currentStore.setStore(itemStoreSelectedSet.getInt("store_fk"));
				currentStore.setCount(itemStoreSelectedSet.getInt("item_count"));
				currentStore.setProduct(product);
				productItemStores.add(currentStore);
				cnt = cnt + 1;
			}
		} catch (Exception E)
		{
			MyLogger.LogMessage("takeProductOnTheAccount() Wrong Store parameters // sql Error");
		}


		try
		{
			itemActionResult = insertItemAction(itemActionSql, takeOnTheAccountForm);

		} catch (Exception E)
		{
			MyLogger.LogMessage("takeProductOnTheAccount() Wrong Store parameters // sql Error");
		}




		// if no stores are set
		if (currentStoreContainsProduct == 0 && itemActionResult==1)
		{
			sql = "Insert into item_store (item_count,store_fk, item_fk) VALUES("
					+ takeOnTheAccountForm.getChosenAmount() + ", "
					+ takeOnTheAccountForm.getChosenStore() + ", "
					+ takeOnTheAccountForm.getProduct().getProduct() + ") returning Item_store";

			try
			{

				/* creating item_store object */
				ps = db.prepareStatement(sql);
				MyLogger.LogMessage(sql);
				ResultSet itemStoreSet;
				itemStoreSet = ps.executeQuery();

				/*
				 * updateAttributes[i] = db.prepareStatement(sql);
				 * updateAttributes[i].executeUpdate();
				 */

				db.commit();

			} catch (Exception E)
			{
				MyLogger.LogMessage("takeProductOnTheAccount() Wrong Store parameters // sql Error");
			}

		}
		// at least 1 store contains selected product
		else
		{

			sql = "Update item_store set item_count=item_count + "
					+ takeOnTheAccountForm.getChosenAmount() + " where store_fk = "
					+ takeOnTheAccountForm.getChosenStore() + " and item_fk = "
					+ takeOnTheAccountForm.getProduct().getProduct() + " returning Item_store";

			try
			{

				/* creating item_store object */
				ps = db.prepareStatement(sql);
				MyLogger.LogMessage(sql);
				ResultSet itemStoreSet;
				itemStoreSet = ps.executeQuery();

				/*
				 * updateAttributes[i] = db.prepareStatement(sql);
				 * updateAttributes[i].executeUpdate();
				 */

				db.commit();

			} catch (Exception E)
			{
				MyLogger.LogMessage("takeProductOnTheAccount() Wrong Store parameters // sql Error");
			}

		}
		// transaction insert into product

		return opResult;
	}

	private int insertItemAction(String itemActionSql, OperationOnProductForm takeOnTheAccountForm)
	{
		/*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, calendar.getActualMinimum(Calendar.DATE));*/
		try
		{
			ps = db.prepareStatement(itemActionSql);
			ps.setInt(1, ProductTransactionTypes.TAKE.getValue());
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStore()));
			ps.setTimestamp(4, (new java.sql.Timestamp(new Date().getTime())));
			ps.setInt(5, takeOnTheAccountForm.getUser().getUserAccount());
			/*item_count, action_price, action_note, created*/
			ps.setInt(6, Integer.parseInt(takeOnTheAccountForm.getChosenAmount()));
			ps.setInt(7, Integer.parseInt(takeOnTheAccountForm.getChosenCost()));
			ps.setString(8, takeOnTheAccountForm.getComment());
			ps.setTimestamp(9, (new java.sql.Timestamp(new Date().getTime())));
			ps.executeQuery();

			//ps.executeQuery();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;


	}

	@Override
	public int removeProductFromTheAccount(OperationOnProductForm takeOnTheAccountForm,
			Product product, ProductExistance productExistance)
	{
		ItemStore itemStore = null;
		int itemActionResult = 0;
		int opResult = 0;
		db = dbconnection.getConnection();
		try
		{
			db.setAutoCommit(false);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// transaction insert into product

		int removedAmount = Integer.parseInt(takeOnTheAccountForm.getChosenAmount()) > productExistance
				.getAvailibility() ? productExistance.getAvailibility() : Integer
				.parseInt(takeOnTheAccountForm.getChosenAmount());

		try
		{


			itemActionResult = insertItemAction(itemActionSql, takeOnTheAccountForm);

			sql = "UPDATE item_store SET item_count=item_count - ? WHERE item_fk=? AND store_fk = ? returning Item_store";
			/* creating item_store object */
			ps = db.prepareStatement(sql);
			ps.setInt(1, removedAmount);
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStore()));
			MyLogger.LogMessage(sql);
			ResultSet itemStoreSet;
			itemStoreSet = ps.executeQuery();

			// float newPrice = recalculatePrice(product,
			// takeOnTheAccountForm.getChosenAmount());

			/*
			 * updateAttributes[i] = db.prepareStatement(sql);
			 * updateAttributes[i].executeUpdate();
			 */

			db.commit();

		} catch (Exception E)
		{
			MyLogger.LogMessage("removeProductFromTheAccount() Wrong Store parameters // sql Error");
		}

		return opResult;
	}

	@Override
	public int moveProduct(OperationOnProductForm takeOnTheAccountForm, Product product)
	{
		ItemStore itemStore = null;
		int opResult = 0;
		int initialItemStoreCount = 0;
		db = dbconnection.getConnection();
		int useInsert = 0;
		ResultSet itemStoreSet = null;
		String sqlFrom;
		String sqlTo;
		String sqlToInsert;
		int storeResult = 0;
		int itemActionResult = 0;

		// transaction insert into product

		sqlFrom = "UPDATE item_store SET item_count=item_count - ? WHERE item_fk=? AND store_fk = ? returning Item_store";

		sqlTo = "UPDATE item_store SET item_count=item_count + ? WHERE item_fk=? AND store_fk = ? returning Item_store";

		try
		{
			db.setAutoCommit(false);

			itemActionResult = insertItemAction(itemActionSql, takeOnTheAccountForm);

			/* from db updates */
			ps = db.prepareStatement(sqlFrom);
			ps.setInt(1, Integer.parseInt(takeOnTheAccountForm.getChosenAmount()));
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStore()));
			MyLogger.LogMessage(sqlFrom);

			itemStoreSet = ps.executeQuery();

			/* to db updates */
			ps = db.prepareStatement(sqlTo);
			ps.setInt(1, Integer.parseInt(takeOnTheAccountForm.getChosenAmount()));
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStoreTo()));
			MyLogger.LogMessage(sqlTo);
			itemStoreSet = ps.executeQuery();
			db.commit();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{

			if (itemStoreSet.next())
			{
				storeResult = itemStoreSet.getInt("item_store");
			}
		} catch (Exception exe)
		{
			MyLogger.LogMessage("moveProduct() : Operation not supported PostgreSql error");
		}

		return opResult;

	}

	public ProductExistance checkProductExistance(OperationOnProductForm takeOnTheAccountForm,
			Product product)
	{

		sql = "select sum(iss.item_count) as count, iss.store_fk from item_store iss where item_fk=? and store_fk=? group by iss.store_fk";
		ResultSet itemStoreSet;
		ProductExistance productExistance = new ProductExistance();

		db = dbconnection.getConnection();

		try
		{
			ps = db.prepareStatement(sql);
			ps.setInt(1, takeOnTheAccountForm.getProduct_id());
			ps.setInt(2, Integer.parseInt(takeOnTheAccountForm.getChosenStore()));
			MyLogger.LogMessage(sql);

			itemStoreSet = ps.executeQuery();

			if (itemStoreSet.next())
			{
				productExistance.setAvailibility(itemStoreSet.getInt("count"));
				// productExistance.setItemStore(itemStoreSet.getString("store_fk"));
			}
		} catch (Exception some)
		{
			MyLogger.LogMessage("checkProductExistance() Wrong Store parameters // sql Error");
		}

		return productExistance;
	}

	public ProductExistance checkProductExistanceTo(OperationOnProductForm takeOnTheAccountForm,
			Product product)
	{

		sql = "select sum(iss.item_count) as count, iss.store_fk from item_store iss where item_fk=? and store_fk=? group by iss.store_fk";
		ResultSet itemStoreSet;
		ProductExistance productExistance = new ProductExistance();

		db = dbconnection.getConnection();

		try
		{
			ps = db.prepareStatement(sql);
			ps.setInt(1, takeOnTheAccountForm.getProduct_id());
			ps.setInt(2, Integer.parseInt(takeOnTheAccountForm.getChosenStoreTo()));
			MyLogger.LogMessage(sql);

			itemStoreSet = ps.executeQuery();

			if (itemStoreSet.next())
			{
				productExistance.setAvailibility(itemStoreSet.getInt("count"));
				// productExistance.setItemStore(itemStoreSet.getString("store_fk"));
			}
		} catch (Exception some)
		{
			MyLogger.LogMessage("checkProductExistance() Wrong Store parameters // sql Error");
		}

		return productExistance;
	}

	@Override
	public int insertProduct(OperationOnProductForm takeOnTheAccountForm, Product product)
	{
		ItemStore itemStore = null;
		int opResult = 0;
		int initialItemStoreCount = 0;
		db = dbconnection.getConnection();
		int useInsert = 0;
		ResultSet itemStoreSet = null;
		String sqlFrom;
		String sqlTo;
		String sqlToInsert;
		int storeResult = 0;

		// transaction insert into product

		sqlFrom = "UPDATE item_store SET item_count=item_count - ? WHERE item_fk=? AND store_fk = ? returning Item_store";

		sqlTo = "Insert into item_store(item_count,item_fk,store_fk) values(?, ?, ?) returning Item_store";

		try
		{
			db.setAutoCommit(false);

			/* from db updates */
			ps = db.prepareStatement(sqlFrom);
			ps.setInt(1, Integer.parseInt(takeOnTheAccountForm.getChosenAmount()));
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStore()));
			MyLogger.LogMessage(sqlFrom);

			itemStoreSet = ps.executeQuery();

			/* to db updates */
			ps = db.prepareStatement(sqlTo);
			ps.setInt(1, Integer.parseInt(takeOnTheAccountForm.getChosenAmount()));
			ps.setInt(2, takeOnTheAccountForm.getProduct_id());
			ps.setInt(3, Integer.parseInt(takeOnTheAccountForm.getChosenStoreTo()));
			MyLogger.LogMessage(sqlTo);
			itemStoreSet = ps.executeQuery();
			db.commit();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try
		{

			if (itemStoreSet.next())
			{
				storeResult = itemStoreSet.getInt("item_store");
			}
		} catch (Exception exe)
		{
			MyLogger.LogMessage("moveProduct() : Operation not supported PostgreSql error");
		}

		return opResult;

	}

}
