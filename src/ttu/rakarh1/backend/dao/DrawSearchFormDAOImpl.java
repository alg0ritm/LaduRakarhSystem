package ttu.rakarh1.backend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ttu.rakarh1.backend.model.data.FormAttrField;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.log.MyLogger;

public class DrawSearchFormDAOImpl implements DrawSearchFormDAO {

	DrawSearchFormDAO drawSearchFormDAO = null;
	List<FormAttribute> formAttributes = null;
	List<FormAttrField> formAttributeFields = null;
	ttu.rakarh1.backend.dao.dbconnection dbconnection = null;
	String sql ;
	Connection db ;	
	Statement  st ;
	PreparedStatement ps;
	
	@Override
	public void setDbConnection(dbconnection dbconnection)
	{
		this.dbconnection = dbconnection ;
	}

	
	public List<FormAttribute> getItemFormAttributes(int item_type)
	{
		FormAttribute currentFormAttribute = null;
		FormAttrField currentAttrField = null;
		formAttributes = new ArrayList<ttu.rakarh1.backend.model.data.FormAttribute>();
		formAttributeFields = new ArrayList<FormAttrField>();
		
		try 
		{
			db = dbconnection.getConnection();
			MyLogger.LogMessage("gotConnection" + item_type);
			sql = "Select distinct ia.item_attribute_type_fk, it.item_type as item_type, iat.type_name as type_name, ta.required as ta_required, iat.data_type as data_type "+
			"from item_type it "+
			"inner join type_attribute ta on ta.item_type_fk = it.item_type "+
			"inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk "+
			"left join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type "+
			"inner join item i on i.item=ia.item_fk "+
			"where it.item_type = ?";
			ps = db.prepareStatement(sql);
			ps.setInt(1, item_type);
			MyLogger.LogMessage("SQL " + sql);
			MyLogger.LogMessage("gotConnection OK" + item_type);
			ResultSet rs = ps.executeQuery();
			
			
			int cnt = 1;
			while(rs.next()) {
				currentFormAttribute = new FormAttribute(); 
				
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "item_attribute_type_fk", "item_attribute");
				currentFormAttribute.setItemAttrTypeFk(currentAttrField);
				cnt++;
			
				currentAttrField = createFormAttr(rs, cnt, "item_type", "item_type");
				currentFormAttribute.setItemType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				
				currentAttrField = createFormAttr(rs, cnt, "data_type", "item_attribute_type");
				currentFormAttribute.setDataType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "type_name", "item_attribute_type");
				currentFormAttribute.setName(currentAttrField);
				cnt++;
				
				currentFormAttribute.setIsRequired(rs.getString("ta_required"));
				
				MyLogger.LogMessage("isRequired" + rs.getString("ta_required"));
				formAttributes.add(currentFormAttribute);
				cnt=1;
			}
		}
		catch(Exception e)
		{
			StackTraceElement[] error = e.getStackTrace();
			MyLogger.Log("getItemFormAttributes", "Failed to connect to db or problems with result parsing "+ error.toString());
		}
		
		return formAttributes;
		
	}
	
	public List<FormAttribute> getItemFormAttributes(int item_type, int item)
	{
		
		FormAttribute currentFormAttribute = null;
		FormAttrField currentAttrField = null;
		formAttributes = new ArrayList<ttu.rakarh1.backend.model.data.FormAttribute>();
		formAttributeFields = new ArrayList<FormAttrField>();
		
		try 
		{
			//take product code into account
			/*Select it.item_type as item_type, iat.type_name as type_name, ta.required as ta_required, iat.data_type as data_type,ia.value_text, ia.value_number, ia.item_fk from item_type it inner join type_attribute ta on ta.item_type_fk = it.item_type inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk left join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type inner join item i on i.item=ia.item_fk where it.item_type =10 and i.producer_code = '6M76P'*/
			db = dbconnection.getConnection();
			MyLogger.LogMessage("gotConnection" + item_type);
			sql = "Select ia.item_attribute_type_fk, it.item_type as item_type, iat.type_name as type_name, ta.required as ta_required, iat.data_type as data_type,ia.value_text, ia.value_number "+
			"from item_type it "+
			"inner join type_attribute ta on ta.item_type_fk = it.item_type "+
			"inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk "+
			"left join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type "+
			"inner join item i on i.item=ia.item_fk "+
			"where it.item_type = ? and i.item= ?";
			ps = db.prepareStatement(sql);
			ps.setInt(1, item_type);
			ps.setInt(2, item);
			MyLogger.LogMessage("SQL " + sql);
			MyLogger.LogMessage("gotConnection OK" + item_type);
			ResultSet rs = ps.executeQuery();
			
			
			int cnt = 1;
			while(rs.next()) {
				currentFormAttribute = new FormAttribute(); 
				
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "item_attribute_type_fk", "item_attribute");
				currentFormAttribute.setItemAttrTypeFk(currentAttrField);
				cnt++;

				//MyLogger.LogMessage("UP 1")
				currentAttrField = createFormAttr(rs, cnt, "item_type", "item_type");
				currentFormAttribute.setItemType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				//MyLogger.LogMessage("UP 2");
				currentAttrField = createFormAttr(rs, cnt, "data_type", "item_attribute_type");
				currentFormAttribute.setDataType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "type_name", "item_attribute_type");
				currentFormAttribute.setName(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "value_text", "item_attribute");
				currentFormAttribute.setValueText(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "value_number", "item_attribute");
				currentFormAttribute.setValueNumber(currentAttrField);
				
				currentFormAttribute.setIsRequired(rs.getString("ta_required"));
				
				MyLogger.LogMessage("isRequired" + rs.getString("ta_required"));
				
				formAttributes.add(currentFormAttribute);
				cnt=1;
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
			MyLogger.Log("getItemFormAttributes", "Failed to connect to db or problems with result parsing" + e.getStackTrace());
		}
		
		return formAttributes;
		
	}
	
	public List<FormAttribute> setItemFormAttributes(int item_type, String producerCode)
	{
		
		FormAttribute currentFormAttribute = null;
		FormAttrField currentAttrField = null;
		formAttributes = new ArrayList<ttu.rakarh1.backend.model.data.FormAttribute>();
		formAttributeFields = new ArrayList<FormAttrField>();
		
		try 
		{
			//take product code into account
			/*Select it.item_type as item_type, iat.type_name as type_name, ta.required as ta_required, iat.data_type as data_type,ia.value_text, ia.value_number, ia.item_fk from item_type it inner join type_attribute ta on ta.item_type_fk = it.item_type inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk left join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type inner join item i on i.item=ia.item_fk where it.item_type =10 and i.producer_code = '6M76P'*/
			db = dbconnection.getConnection();
			MyLogger.LogMessage("gotConnection 2" + item_type);
			sql = "Select ia.item_attribute_type_fk, it.item_type as item_type, iat.type_name as type_name, ta.required as ta_required, iat.data_type as data_type,ia.value_text, ia.value_number "+
			"from item_type it "+
			"inner join type_attribute ta on ta.item_type_fk = it.item_type "+
			"inner join item_attribute_type iat on iat.item_attribute_type = ta.item_attribute_type_fk "+
			"left join item_attribute ia on ia.item_attribute_type_fk = iat.item_attribute_type "+
			"inner join item i on i.item=ia.item_fk "+
			"where it.item_type = ? and i.producer_code= ?";
			ps = db.prepareStatement(sql);
			ps.setInt(1, item_type);
			ps.setString(2, producerCode);
			MyLogger.LogMessage("SQL " + sql);
			MyLogger.LogMessage("gotConnection OK" + item_type);
			ResultSet rs = ps.executeQuery();
			
			
			int cnt = 1;
			while(rs.next()) {
				currentFormAttribute = new FormAttribute(); 
				currentAttrField = new FormAttrField();

				//MyLogger.LogMessage("UP 1")
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "item_attribute_type_fk", "item_attribute");
				currentFormAttribute.setItemAttrTypeFk(currentAttrField);
				cnt++;
				
				currentAttrField = createFormAttr(rs, cnt, "item_type", "item_type");
				currentFormAttribute.setItemType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				//MyLogger.LogMessage("UP 2");
				currentAttrField = createFormAttr(rs, cnt, "data_type", "item_attribute_type");
				currentFormAttribute.setDataType(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "type_name", "item_attribute_type");
				currentFormAttribute.setName(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "value_text", "item_attribute");
				currentFormAttribute.setValueText(currentAttrField);
				cnt++;
				currentAttrField = new FormAttrField();
				currentAttrField = createFormAttr(rs, cnt, "value_number", "item_attribute");
				currentFormAttribute.setValueNumber(currentAttrField);
				
				currentFormAttribute.setIsRequired("Y");
				
				
				formAttributes.add(currentFormAttribute);
				cnt=1;
			}
		}
		catch(Exception e)
		{
			e.getStackTrace();
			MyLogger.Log("getItemFormAttributes", "Failed to connect to db or problems with result parsing");
		}
		
		return formAttributes;
		
	}


	private FormAttrField createFormAttr(ResultSet rs, int cnt, String attr, String tableName) 
	{
		
		FormAttrField currentField = new FormAttrField();
		try 
		{
			MyLogger.LogMessage("isSearchable" + rs.getMetaData().isSearchable(1));
			currentField.setValue(rs.getString(attr));
			currentField.setColumnName(attr);
			currentField.setColumnType((rs.getMetaData().getColumnType(cnt)));
			currentField.setTable(tableName);
			currentField.createErrorMap();
			MyLogger.LogMessage("Value =" + rs.getString(attr) + " column name=" + attr + "rs.getMetaData().getColumnType(cnt) " + rs.getMetaData().getColumnType(cnt)+ "tableName=" + tableName);
		}
		catch(Exception E)
		{
			MyLogger.Log("createFormAttr", "failed to createFormAttr");
		}
		return currentField;
	}


	public int updateProductAttributes(List<FormAttribute> formAttributes, int item) throws SQLException
	{
//		Update item_attribute set value_text = '800X450X300' where item_fk = (Select i.item from item i where i.producer_code = '6M76P') 
//		and item_attribute_type_fk = (Select iat.item_attribute_type from item_attribute_type iat where iat.type_name = 'laua liikumine (mm)')
		int update_ok = 1;
		String sqlStart = "Update item_attribute set ";
		int preparedStatesmensLength = formAttributes.size();
		PreparedStatement[] updateAttributes = new PreparedStatement[preparedStatesmensLength];
		for(int i=0; i<preparedStatesmensLength; i++)
		{
			updateAttributes[i] = null;
		}
		try
		{
			db = dbconnection.getConnection();
			db.setAutoCommit(false);
			int i = 0;
			for(FormAttribute fa : formAttributes){
				String sqlBody = "";
				String sql ="";
				if(fa.getValueText() != null){
					sqlBody+="value_text = '" + fa.getName().getVirtValue()+ "'";
				}
				else{
					sqlBody+="value_number = '" + fa.getName().getVirtValue()+ "'";
				}
				sqlBody+=" where item_fk = (Select i.item from item i where i.item = '" + item +"') "+
					"and item_attribute_type_fk ="+ fa.getItemAttrTypeFk().getValue(); //(Select iat.item_attribute_type from item_attribute_type iat where iat.type_name = '" + fa.getName().getValue() + "')";
				sql = sqlStart + sqlBody;
				MyLogger.LogMessage("updateProductAttributes() SQL " + sql);
				updateAttributes[i] = db.prepareStatement(sql);
				updateAttributes[i].executeUpdate();
				i++;
			}
			
			db.commit();
			
			
		} catch (SQLException e ) {
		   
		      if (db!= null) {
		        try {
		          System.err.print("Transaction is being rolled back");
		          db.rollback();
		        } catch(SQLException excep) {
		          MyLogger.LogMessage("DrawSearchFromDAOImpl.updateProductAttributes() " + e.getMessage());
		        }
		      }
		    } finally {
		      db.setAutoCommit(true);
		    }

		return update_ok;
		
	}


	public int insertProductAttributes(List<FormAttribute> formAttributes,int item) throws SQLException
	{
//		db = dbconnection.getConnection();
//		sql = "INSERT INTO item (producer_code,name,description, store_price, sale_price, unit_type_fk) VALUES (?,?,?,?,?,?) RETURNING item";
//		ps = db.prepareStatement(sql);
//		ps.setString(1, newProduct.getProduct_code());
//		ps.setString(2, newProduct.getName());
//		ps.setString(3, newProduct.getDescription());
//		ps.setFloat(4, Float.parseFloat(newProduct.getStore_price()+""));
//		ps.setFloat(5, Float.parseFloat(newProduct.getSale_price()+""));
//		ps.setInt(6, newProduct.getProduct_catalog());
//		ProductRset = ps.executeQuery();
//		MyLogger.LogMessage("ProductDaoImpl.insertProduct() after insert");
//		String sqlStart = "Insert into item_attribute(item_attribute_type_fk, item_fk, type_name, value_text, value_number, data_type) Values(";
		MyLogger.LogMessage("Preparing to isnert new product attributes");
		int update_ok = 1;
		ResultSet ProductRset;
		
		db = dbconnection.getConnection();
		
		
		int preparedStatesmensLength = formAttributes.size();
		PreparedStatement[] updateAttributes = new PreparedStatement[preparedStatesmensLength];
		MyLogger.LogMessage("Before inserting --- initialization");
		try
		{
			for(FormAttribute fa : formAttributes){
				
				String name = fa.getName().getValue();
				MyLogger.LogMessage("1o " + fa.getName().getValue());
				String itemType = fa.getItemType().getValue();
				MyLogger.LogMessage("2o " + fa.getItemType().getValue());
				String dataType = fa.getDataType().getValue();
				MyLogger.LogMessage("3o " + fa.getDataType().getValue());
				String virtValue = fa.getName().getVirtValue();
				MyLogger.LogMessage("4o " + fa.getName().getVirtValue());
				MyLogger.LogMessage("5o " + fa.getItemAttrTypeFk().getValue());
				String itemAttrFk = fa.getItemAttrTypeFk().getValue();
				
				String valueType = "";
				if(dataType.equals("1"))
					valueType = "value_text";
				else 
					valueType = "value_number";
				
				String sqlStart = "Insert into item_attribute(item_attribute_type_fk, item_fk, type_name,"+valueType+", data_type) Values(?,?,?,?,?) RETURNING item_attribute";
				ps = db.prepareStatement(sqlStart);
				
				MyLogger.LogMessage("Insert into item_attribute(item_attribute_type_fk, item_fk, type_name," + valueType + ", data_type) Values('"+itemAttrFk+"','"+item+"','"+name+"','"+virtValue+"','"+dataType+"') RETURNING item_attribute");
				
				String finalSql = "Insert into item_attribute(item_attribute_type_fk, item_fk, type_name," + valueType + ", data_type) Values('"+itemAttrFk+"','"+item+"','"+name+"','"+virtValue+"','"+dataType+"') RETURNING item_attribute";
				
				ps.setInt(1, Integer.parseInt(itemAttrFk));
				ps.setInt(2, item);
				ps.setString(3, name);
				ps.setString(4, virtValue);
				ps.setInt(5, Integer.parseInt(dataType));
				ProductRset = ps.executeQuery();
			}
			MyLogger.LogMessage("After inserting --- initialization");
			
			
		} catch (SQLException e ) {
		   
		      if (db!= null) {
		        try {
		          System.err.print("Transaction is being rolled back");
		          db.rollback();
		        } catch(SQLException excep) {
		          MyLogger.LogMessage("DrawSearchFromDAOImpl.insertProductAttributes() " + e.getMessage());
		        }
		      }
		    } finally {
		      db.setAutoCommit(true);
		    }

		return update_ok;
		
	}

}
