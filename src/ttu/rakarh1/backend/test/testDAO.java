package ttu.rakarh1.backend.test ;
import java.util.*;
import ttu.rakarh1.log.MyLogger ;
import ttu.rakarh1.backend.dao.* ;
import ttu.rakarh1.backend.model.data.*;

public class testDAO {

    public static void main(String[] args) throws Exception {

     ProductCatalogDAO ProductCatalogDAO = new ProductCatalogDAOImpl();	 
	 dbconnection dbconnection = null ;	 
	 dbconnection = new dbconnection();
	 ProductCatalogDAO.setDbConnection(dbconnection);
	 List<ttu.rakarh1.backend.model.data.ProductCatalog> catalogs = ProductCatalogDAO.getFirstlevelCatalogs();
	           for (ProductCatalog pc : catalogs) {
            System.out.println("Catalog is: " + pc.getName());
          }
    dbconnection.close();
	}

}


