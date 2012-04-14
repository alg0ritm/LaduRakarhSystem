package ttu.rakarh1.backend.dao;
import java.sql.* ;
import ttu.rakarh1.backend.model.data.* ;
import ttu.rakarh1.log.MyLogger ;
import java.util.*;
import java.text.*;

public class ProductCatalogDAOImpl implements ProductCatalogDAO {

	String sql ;
	Connection db ;
	Statement  st ;
	PreparedStatement ps;
    ttu.rakarh1.backend.dao.dbconnection dbconnection ;

    public void setDbConnection(dbconnection dbconnection)
	{
	this.dbconnection = dbconnection ;
	}

	public List<ttu.rakarh1.backend.model.data.ProductCatalog>  getFirstlevelCatalogs() {
            List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogList = null;
		try {

		    ProductCatalog CurrentProductCatalog = null;
			CatalogList = new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>();
			db = dbconnection.getConnection();
			sql = "SELECT item_type,super_type_fk,type_name FROM item_type WHERE level=1 ORDER BY type_name " ;
			ps = db.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				CurrentProductCatalog = new ProductCatalog();
				CurrentProductCatalog.setProduct_catalog(rs.getInt("item_type"));
				CurrentProductCatalog.setName(rs.getString("type_name"));
				CurrentProductCatalog.setLevel(1);
				CurrentProductCatalog.setUpper_catalog(rs.getInt("super_type_fk"));
				CatalogList.add(CurrentProductCatalog);
				cnt =  cnt + 1;
			}
			// this.db.close();


		}

		catch(Exception ex)
		{
			MyLogger.Log("getFirstlevelCatalogs():",ex.getMessage());

		}

		return CatalogList;
	}

	public List<ttu.rakarh1.backend.model.data.ProductCatalog> getSubCatalogs(int catalog) {
	            List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogList = null;
		try {

		    ProductCatalog CurrentProductCatalog = null;
		    CatalogList = new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>();
			db = dbconnection.getConnection();
			sql = "SELECT item_type,super_type_fk,type_name, level FROM item_type WHERE super_type_fk=?  ORDER BY type_name " ;
			ps = db.prepareStatement(sql);
			ps.setInt(1, catalog);
			ResultSet rs = ps.executeQuery();
			int cnt = 0;
			while(rs.next()) {
				CurrentProductCatalog = new ProductCatalog();
				CurrentProductCatalog.setProduct_catalog(rs.getInt("item_type"));
				CurrentProductCatalog.setName(rs.getString("type_name"));
				CurrentProductCatalog.setUpper_catalog(rs.getInt("super_type_fk"));
				CurrentProductCatalog.setLevel(rs.getInt("level"));
				CatalogList.add(CurrentProductCatalog);
				cnt =  cnt + 1;
			}
		//	this.db.close();


		}

		catch(Exception ex)
		{
			MyLogger.Log("getSubCatalogs():",ex.getMessage());

		}

		return CatalogList;
	}

public ProductCatalog getCatalogByIdWithSubCatalogs(int catalog) {
	            List<ttu.rakarh1.backend.model.data.ProductCatalog> subCatalogList = null;
				ProductCatalog ProductCatalog = null;
		try {

			db = dbconnection.getConnection();
			sql = "SELECT item_type,super_type_fk,type_name, level FROM item_type WHERE item_type=? " ;
			ps = db.prepareStatement(sql);
			ps.setInt(1, catalog);
			ResultSet rs = ps.executeQuery();

			int cnt = 0;
			while(rs.next()) {
			    ProductCatalog = new ProductCatalog();
				ProductCatalog.setProduct_catalog(rs.getInt("item_type"));
				ProductCatalog.setName(rs.getString("type_name"));
				ProductCatalog.setUpper_catalog(rs.getInt("super_type_fk"));
				ProductCatalog.setLevel(rs.getInt("level"));
				MyLogger.LogMessage("SUB CATALOGS Start: " + "SELECT item_type,super_type_fk,type_name, level FROM item_type WHERE item_type=" + catalog);
				subCatalogList = getSubCatalogs(catalog);
				MyLogger.LogMessage("SUB CATALOGS Middle: " + subCatalogList.size());
				ProductCatalog.setSubCatalogs(subCatalogList);
				MyLogger.LogMessage("SUB CATALOGS End: " + subCatalogList.size());
				cnt =  cnt + 1;
			}
		//	this.db.close();

			MyLogger.LogMessage("SUB CATALOGS FINITO: ");
		}

		catch(Exception ex)
		{
			MyLogger.Log("getSubCatalogs():",ex.getMessage());

		}

		return ProductCatalog;
	}
}
