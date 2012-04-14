package ttu.rakarh1.backend.dao ;
import ttu.rakarh1.backend.model.data.* ;
import java.util.*;

public interface ProductCatalogDAO {
	
	 public void setDbConnection(dbconnection dbconnection);
	 public List<ttu.rakarh1.backend.model.data.ProductCatalog>  getFirstlevelCatalogs() ;
	 public List<ttu.rakarh1.backend.model.data.ProductCatalog> getSubCatalogs(int catalog);
     public ProductCatalog getCatalogByIdWithSubCatalogs(int catalog);
}
