package ttu.rakarh1.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import ttu.rakarh1.backend.model.data.FormAttrField;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;
import ttu.rakarh1.dao.HibernateUtil;
import ttu.rakarh1.log.MyLogger;

public class ProductDAOImpl implements ProductDAO
{

	String sql;
	Connection db;
	PreparedStatement ps;
	Statement st;
	ResultSet ProductRset;
	ttu.rakarh1.backend.dao.dbconnection dbconnection;

	public void setDbConnection(dbconnection dbconnection)
	{
		this.dbconnection = dbconnection;
	}

	public Product getProductById(int product_id)
	{
		Product Product = null;
		try
		{
			db = dbconnection.getConnection();
			sql = "SELECT item, unit_type_fk,supplier_enterprise_fk,item_type_fk,name, store_price, sale_price, producer,description,producer_code, created FROM item WHERE item=?";
			ps = this.db.prepareStatement(sql);
			ps.setInt(1, product_id);
			ProductRset = ps.executeQuery();

			while (ProductRset.next())
			{
				Product = new Product();
				Product.setProduct(ProductRset.getInt("item"));
				Product.setName(ProductRset.getString("name"));
				Product.setDescription(ProductRset.getString("description"));
				Product.setProduct_code(ProductRset.getString("producer_code"));
				Product.setStore_price(ProductRset.getFloat("store_price"));
				Product.setSale_price(ProductRset.getInt("sale_price"));
				Product.setProduct_catalog(ProductRset.getInt("item_type_fk"));
			}
			// this.db.close();

		}

		catch (Exception ex)
		{
			MyLogger.Log("getProductById():", ex.getMessage());

		}

		return Product;
	}

	public List<ttu.rakarh1.backend.model.data.Product> searchProducts(
			ProductSearchCriteria ProductSearchCriteria, HttpServletRequest request)
	{

		// with recursive sumthis(item_type, super_type_fk) as (
		// select item_type, super_type_fk from item_type
		// where item_type =1
		// union all select C.item_type, C.super_type_fk from sumthis P
		// inner join item_type C on P.item_type = C.super_type_fk)
		// select item_type from sumthis
		List<ttu.rakarh1.backend.model.data.Product> ProductList = null;
		try
		{
			Product Product;
			ProductList = new ArrayList<ttu.rakarh1.backend.model.data.Product>();
			db = dbconnection.getConnection();
			st = this.db.createStatement();
			String sql_and = "";
			String sql_where = "";
			String sql_all_together = "";
			String sql_criteria = "";
			String sql_end = " ORDER BY name";
			String sql_additional_attr = "";
			String genSql = "";
			List<ttu.rakarh1.backend.model.data.FormAttribute> formAttributes = null;
			MyLogger.LogMessage("FORMATTRIBUTES1");
			formAttributes = (List<FormAttribute>) request.getAttribute("formAttributes");

			if (formAttributes != null)
			{
				MyLogger.LogMessage("FORMATTRIBUTES2");
				sql_additional_attr = getAdditionalSqlAttr(formAttributes);
			}

			String sql_from = " FROM item i "; /* ,unit_type, item_type "; */
			String sql_start = "SELECT distinct i.item, i.unit_type_fk, i.supplier_enterprise_fk, i.item_type_fk,name, i.store_price, i.sale_price, i.producer, i.description, i.producer_code, i.created ";
			// MyLogger.LogMessage("SEARCH CRITERIA PRODUCT CODE" +
			// ProductSearchCriteria.getProduct_code());
			if (ProductSearchCriteria.getGenAttrList() != null)
			{
				genSql = getGeneralSqlAttr(ProductSearchCriteria);
			}

			if (!(ProductSearchCriteria.getProduct_code().equals("")))
			{
				sql_criteria = "UPPER(i.producer_code) LIKE UPPER('"
						+ ProductSearchCriteria.getProduct_code() + "%')";
			}

			if (!(ProductSearchCriteria.getName().equals("")))
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				String search_string = ProductSearchCriteria.getName().replace(" ", " & ");
				sql_criteria = sql_criteria + sql_and + " (to_tsvector(name) @@ to_tsquery('"
						+ search_string + "'))";
			}

			if (ProductSearchCriteria.getMin_price() != -1)
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				sql_criteria = sql_criteria + sql_and + " i.store_price >= "
						+ Float.toString(ProductSearchCriteria.getMin_price()) + " ";
			}

			if (ProductSearchCriteria.getMax_price() != -1)
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				sql_criteria = sql_criteria + sql_and + " i.store_price <= "
						+ Float.toString(ProductSearchCriteria.getMax_price()) + " ";
			}

			if (ProductSearchCriteria.getSupplier_enterprise_fk() != 0)
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				sql_criteria = sql_criteria + sql_and + " i.supplier_enterprise_fk = "
						+ Integer.toString(ProductSearchCriteria.getSupplier_enterprise_fk()) + " ";
			}

			if (ProductSearchCriteria.getUnit_type_fk() != 0)
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				sql_criteria = sql_criteria + sql_and + " i.unit_type_fk = "
						+ Integer.toString(ProductSearchCriteria.getUnit_type_fk()) + " ";
			}

			if (ProductSearchCriteria.getItem_type_fk() != 0)
			{
				if (sql_criteria.equals(""))
				{
					sql_and = "";
				} else
				{
					sql_and = " AND ";
				}
				sql_criteria = sql_criteria
						+ sql_and
						+ " i.item_type_fk in (with recursive sumthis(item_type, super_type_fk) as ("
						+ "select item_type, super_type_fk " + "from item_type "
						+ "where item_type ="
						+ Integer.toString(ProductSearchCriteria.getItem_type_fk()) + " "
						+ "union all " + "select C.item_type, C.super_type_fk " + "from sumthis P "
						+ "inner join item_type C on P.item_type = C.super_type_fk " + ") "
						+ "select item_type from sumthis" + ") ";
			}

			if (!(sql_criteria.equals("")))
			{
				sql_where = " WHERE ";
			}
			if (!genSql.equals(""))
			{
				sql_from += "inner join item_type it on it.item_type = i.item_type_fk inner join type_attribute ta on ta.item_type_fk = it.item_type  inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk inner join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type";
				sql_criteria += " and (" + genSql + ")";
				// sql_all_together = " inner join ( " + sql_additional_attr +
				// ") q2 on q2.item_fk = item";
			}
			sql_all_together = sql_start + sql_from;
			if (sql_additional_attr != "")
			{
				sql_all_together += " inner join ( " + sql_additional_attr
						+ ") q2 on q2.item_fk = i.item";

			}

			sql_all_together += sql_where + sql_criteria + sql_end;

			MyLogger.LogMessage("ProductDAOImpl -> fdfdf " + sql_all_together);
			System.out.println(sql_all_together);
			ResultSet rs = this.st.executeQuery(sql_all_together);
			int cnt = 0;
			while (rs.next())
			{
				Product = new Product();
				Product.setProduct(rs.getInt("item"));
				Product.setName(rs.getString("name"));
				Product.setDescription(rs.getString("description"));
				Product.setProduct_code(rs.getString("producer_code"));
				Product.setStore_price(rs.getFloat("store_price"));
				Product.setSale_price(rs.getInt("sale_price"));
				Product.setProduct_catalog(rs.getInt("unit_type_fk"));
				ProductList.add(Product);
				cnt = cnt + 1;
			}

		}

		catch (Exception ex)
		{
			MyLogger.Log("searchProducts():", ex.getMessage());

		}

		return ProductList;
	}

	public List<Product> getItems_fromDB()
	{
		MyLogger logger = new MyLogger();
		List<Product> itemList = null;
		Session session = null;
		try
		{
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			itemList = session.createQuery("from Item as a").list();

		} catch (Exception e)
		{
			MyLogger.LogMessage("Error in creating/executing HQL query" + e.getMessage());
		}
		return itemList;
	}

	// show lisa product only for 2+ levels
	public boolean showAddProduct(int catalog)
	{
		int count = 0;
		String sql = "Select it.item_type, it.level from item_type it inner join (select q1.level, q1.item_type from (with recursive sumthis(item_type, super_type_fk, level) as ("
				+ "select item_type, super_type_fk, level from item_type "
				+ "where item_type =? "
				+ "union all select C.item_type, C.super_type_fk, C.level from sumthis P "
				+ "inner join item_type C on P.item_type = C.super_type_fk) "
				+ "select item_type, level from sumthis) q1) q2 on q2.level = it.level and it.item_type = q2.item_type and q2.level>2";
		try
		{
			db = dbconnection.getConnection();

			ps = this.db.prepareStatement(sql);
			ps.setInt(1, catalog);
			ProductRset = ps.executeQuery();



			while ( ProductRset.next() )
			{
			    // Process the row.
			    count++;
			}

			MyLogger.LogMessage("showAddProduct SQL" + sql);
			MyLogger.LogMessage("showAddProduct COUNT" + count);
		} catch (SQLException e)
		{
			MyLogger.LogMessage("error occured when retrievin showAddProduct button" + e.getMessage());
			e.printStackTrace();
		}
		if (count > 0)
			return true;
		return false;
	}

	// use this query for super categories
	/*
	 * Select i.item, i.unit_type_fk, i.supplier_enterprise_fk,
	 * i.item_type_fk,name, i.store_price, i.sale_price, i.producer,
	 * i.description, i.producer_code, i.created FROM item i inner join
	 * item_type it2 on it2.item_type = i.item_type_fk and it2.item_type in
	 * (Select item_type from item_type it3 where it3.super_type_fk = (Select
	 * it1.super_type_fk from item_type it1 where it1.item_type = 9 ))
	 */

	// otherwise qry
	/*
	 * Select i.item, i.unit_type_fk, i.supplier_enterprise_fk,
	 * i.item_type_fk,name, i.store_price, i.sale_price, i.producer,
	 * i.description, i.producer_code, i.created FROM item i inner join
	 * item_type it2 on it2.item_type = i.item_type_fk and it2.item_type in
	 * (Select item_type from item_type it where it.super_type_fk = 4)
	 */

	private String getGeneralSqlAttr(ProductSearchCriteria ProductSearchCriteria)
	{
		ArrayList<String> genAttrList = ProductSearchCriteria.getGenAttrList();
		Iterator i = genAttrList.iterator();
		int cnt = 0;
		String genSql = "";
		while (i.hasNext())
		{
			cnt++;
			int valueInt = 0;
			String curr = ((String) i.next()).trim();
			String and = (cnt == 1) ? "" : " and ";
			try
			{
				valueInt = Integer.parseInt(curr);
			} catch (NumberFormatException e)
			{
				MyLogger.Log("ProductSearchCriteria.getGenAttrList()", e.getMessage());
				valueInt = -1;
			}
			String valuNum = (valueInt == -1) ? "" : " or ia.value_number=" + curr;
			genSql += and + "(ia.value_text ='" + curr + "'" + valuNum + ")";
		}
		return genSql;
	}

	private String getAdditionalSqlAttr(List<FormAttribute> formAttributes)
	{
		String sql = "";
		String typeName = "";
		String typeValue = "";
		String dataType = "";
		int typeColType = 0;
		FormAttrField name = null;
		String sqlBasic = "Select q1.item_fk from "
				+ "(Select it.item_type, iat.type_name, ta.required, iat.data_type as data_type, ia.value_text, ia.item_fk from item_type it "
				+ "inner join type_attribute ta on ta.item_type_fk = it.item_type "
				+ "inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk "
				+ "inner join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type "
				+ ") as q1 " + "inner join item_attribute ia2 on q1.item_fk = ia2.item_fk";
		String sqlGroup = " group by q1.item_fk";
		String sqlJoin = "";
		String sqlHaving = " having count(q1.item_fk)=";
		int cnt = 0;
		for (FormAttribute attr : formAttributes)
		{
			name = attr.getName();
			if (name.getVirtValue() != null)
			{
				cnt++;
				typeName = name.getValue();
				typeValue = name.getVirtValue();
				typeColType = name.getColumnType();
				dataType = attr.getDataType().getValue();

				MyLogger.LogMessage("typeName=" + typeName + " typeValue=" + typeValue
						+ " typeColType=" + typeColType);
				String addition = (Integer.parseInt(dataType) == 1) ? "ia2.value_text = '"
						+ typeValue + "')" : "ia2.value_number= " + typeValue + ")";
				if (cnt == 1)
				{
					sqlJoin = " where ((q1.type_name='" + typeName + "' and " + addition;
				} else
				{
					sqlJoin += " or ( " + "q1.type_name='" + typeName + "' and " + addition;
				}
			}
		}
		if (cnt == 0)
		{
			return sql;
		} else
		{
			sqlJoin += ")";
			sqlHaving += cnt;
			sql = sqlBasic + sqlJoin + sqlGroup + sqlHaving;
			MyLogger.LogMessage("getAdditionalSqlAttr " + sql);
			return sql;
		}
	}

	public int insertProduct(Product newProduct)
	{
		int inserted_product_id = 0;

		try
		{

			db = dbconnection.getConnection();
			MyLogger.LogMessage("insertProduct() after getting connection");
			sql = "INSERT INTO item (producer_code,name,description, store_price, sale_price, item_type_fk) VALUES (?,?,?,?,?,?) RETURNING item";
			MyLogger.LogMessage("INSERT INTO item (producer_code,name,description, store_price, sale_price, item_type_fk) VALUES ("
					+ newProduct.getProduct_code()
					+ ", "
					+ newProduct.getName()
					+ ", "
					+ newProduct.getDescription()
					+ ", "
					+ Float.parseFloat(newProduct.getStore_price() + "")
					+ ", "
					+ Float.parseFloat(newProduct.getSale_price() + "")
					+ ", "
					+ newProduct.getProduct_catalog() + ")");

			ps = db.prepareStatement(sql);
			ps.setString(1, newProduct.getProduct_code());
			ps.setString(2, newProduct.getName());
			ps.setString(3, newProduct.getDescription());
			ps.setFloat(4, Float.parseFloat(newProduct.getStore_price() + ""));
			ps.setFloat(5, Float.parseFloat(newProduct.getSale_price() + ""));
			ps.setInt(6, newProduct.getProduct_catalog());
			ProductRset = ps.executeQuery();
			MyLogger.LogMessage("ProductDaoImpl.insertProduct() after insert");

			while (ProductRset.next())
			{
				inserted_product_id = ProductRset.getInt("item");
			}

			// db.close();
		} catch (Exception ex)
		{
			MyLogger.Log("insertProduct():", ex.getMessage());

		}
		return inserted_product_id;

	}

	public int updateProduct(Product updatedProduct)
	{
		int update_ok = 1;

		try
		{
			db = dbconnection.getConnection();
			sql = "UPDATE item set name=?, producer_code=?,"
					+ "description=?, store_price=?, sale_price=?, item_type_fk=? Where item=?";
			ps = db.prepareStatement(sql);
			ps.setString(1, updatedProduct.getName());
			ps.setString(2, updatedProduct.getProduct_code());
			ps.setString(3, updatedProduct.getDescription());
			MyLogger.LogMessage("ProductDaoImpl.updateProduct() before formatting");
			ps.setFloat(4, Float.parseFloat(updatedProduct.getStore_price() + ""));
			ps.setFloat(5, Float.parseFloat(updatedProduct.getSale_price() + ""));
			ps.setInt(6, updatedProduct.getProduct_catalog());
			ps.setInt(7, updatedProduct.getProduct());
			ps.executeUpdate();

			// db.close();
		} catch (Exception ex)
		{
			MyLogger.Log("updateProduct():", ex.getMessage());
			update_ok = -1;
		}

		return update_ok;
	}

	public List<ttu.rakarh1.backend.model.data.Product> getProductsByCatalog(int catalog_id)
	{
		List<ttu.rakarh1.backend.model.data.Product> ProductList = null;
		Product Product = null;
		try
		{
			db = dbconnection.getConnection();
			sql = "SELECT item, unit_type_fk,supplier_enterprise_fk,item_type_fk,name, store_price, sale_price, producer,"
					+ "description,producer_code, created FROM item WHERE item_type_fk=?";
			ps = this.db.prepareStatement(sql);
			ps.setInt(1, catalog_id);
			ProductRset = ps.executeQuery();
			ProductList = new ArrayList<ttu.rakarh1.backend.model.data.Product>();
			while (ProductRset.next())
			{
				Product = new Product();
				Product.setProduct(ProductRset.getInt("item"));
				Product.setName(ProductRset.getString("name"));
				Product.setDescription(ProductRset.getString("description"));
				Product.setProduct_code(ProductRset.getString("producer_code"));
				Product.setStore_price(ProductRset.getFloat("store_price"));
				Product.setSale_price(ProductRset.getInt("sale_price"));
				Product.setProduct_catalog(ProductRset.getInt("item_type_fk"));
				ProductList.add(Product);
			}
		} catch (Exception ex)
		{
			MyLogger.Log("ProductDAOImpl.getProductsByCatalog():", ex.getMessage());
		}

		return ProductList;
	}

	@Override
	public int getProductId(String producerCode)
	{
		int item = 0;
		try
		{
			db = dbconnection.getConnection();
			String sql = "select i.item from item i where producer_code = '" + producerCode + "'";
			ps = this.db.prepareStatement(sql);
			ProductRset = ps.executeQuery();
			MyLogger.LogMessage("ProductDAOImpl.getProductId(): Returning item"
					+ "select i.item from item where producer_code = '" + producerCode
					+ "' returning item");
			while (ProductRset.next())
			{
				item = ProductRset.getInt("item");
			}

		} catch (Exception ex)
		{
			MyLogger.Log("ProductDAOImpl.getProductId():", ex.getMessage());
		}

		return item;

	}

	@Override
	public ArrayList<Product> getProductsByCatalogForRemoval(int catalogedToBeremovedFrom)
	{
		ArrayList<Product> ProductList = null;
		Product Product = null;
		try
		{
			db = dbconnection.getConnection();
			sql = "SELECT item, unit_type_fk,supplier_enterprise_fk,item_type_fk,name, store_price, sale_price, producer," +
					" description,producer_code, created, a.item_count FROM item " +
					" left join (Select sum(item_count) as item_count, item_fk from item_store its group by item_fk) a on a.item_fk = item.item " +
					" WHERE item_type_fk=? and (a.item_count = 0 or item.item not in (select item_fk from item_store))";
			ps = this.db.prepareStatement(sql);
			ps.setInt(1, catalogedToBeremovedFrom);
			ProductRset = ps.executeQuery();
			ProductList = new ArrayList<ttu.rakarh1.backend.model.data.Product>();
			while (ProductRset.next())
			{
				Product = new Product();
				Product.setProduct(ProductRset.getInt("item"));
				Product.setName(ProductRset.getString("name"));
				Product.setDescription(ProductRset.getString("description"));
				Product.setProduct_code(ProductRset.getString("producer_code"));
				Product.setStore_price(ProductRset.getFloat("store_price"));
				Product.setSale_price(ProductRset.getInt("sale_price"));
				Product.setProduct_catalog(ProductRset.getInt("item_type_fk"));
				ProductList.add(Product);
			}
		} catch (Exception ex)
		{
			MyLogger.Log("ProductDAOImpl.getProductsByCatalog():", ex.getMessage());
		}

		return ProductList;
	}

	@Override
	public ProductCatalog getCatalogById(int catalogedToBeremovedFrom)
	{
		ProductCatalog catalog = new ProductCatalog();
		try
		{
			db = dbconnection.getConnection();
			String sql = "Select item_type, type_name, level, super_type_fk from item_type where item_type=?";

			ps = this.db.prepareStatement(sql);
			ps.setInt(1, catalogedToBeremovedFrom);
			ProductRset = ps.executeQuery();

			while (ProductRset.next())
			{
				catalog.setProduct_catalog(ProductRset.getInt("item_type"));
				catalog.setLevel(ProductRset.getInt("level"));
				catalog.setName(ProductRset.getString("type_name"));
				catalog.setUpper_catalog(ProductRset.getInt("super_type_fk"));
			}

		} catch (Exception ex)
		{
			MyLogger.Log("ProductDAOImpl.getProductId():", ex.getMessage());
		}

		return catalog;
	}

	@Override
	public int removeProducts(ArrayList<Product> removableItems)
	{

		int result = 0;
		int rowsDeleted = 0;
		try
		{
			db = dbconnection.getConnection();
			db.setAutoCommit(false);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			Iterator it = removableItems.iterator();
			while(it.hasNext()) {
				Product next = (Product) it.next();


			/*Delete from item where item=40
			delete from item_store where item_fk=40
			delete from item_action where item_fk=40
			delete from item_attribute where item_fk=40*/

			sql = "Delete from item where item=?";
			db = dbconnection.getConnection();

			// getting all stores where this poduct is registred
			try
			{
				ps = db.prepareStatement(sql);
				ps.setInt(1, next.getProduct());
				rowsDeleted = ps.executeUpdate();

				sql = "delete from item_store where item_fk=?";
				ps = db.prepareStatement(sql);
				ps.setInt(1, next.getProduct());
				rowsDeleted = ps.executeUpdate();

				sql = "delete from item_action where item_fk=?";
				ps = db.prepareStatement(sql);
				ps.setInt(1, next.getProduct());
				rowsDeleted = ps.executeUpdate();

				sql = "delete from item_attribute where item_fk=?";
				ps = db.prepareStatement(sql);
				ps.setInt(1, next.getProduct());
				rowsDeleted = ps.executeUpdate();
				db.commit();

				result = 1;


			} catch (Exception E)
			{


				MyLogger.LogMessage("removeProducts() Wrong Store parameters // sql Error");
				return result;
			}






			// if no stores are set




			}
		}catch(Exception exp) {
			MyLogger.LogMessage("removeProducts() Global error occured while deleting // sql Error");
			return result;
		}
		return result;

	}



}
