package ttu.rakarh1.web.control;
import ttu.rakarh1.backend.model.data.* ;
import ttu.rakarh1.backend.model.service.* ;
// import ttu.rakarh1.backend.dao.* ;
import ttu.rakarh1.log.MyLogger ;
import java.util.*;

public class ProductCatalogTreeEmulator implements ProductCatalogTree {


public List<ttu.rakarh1.backend.model.data.ProductCatalog>  getTreeWithOneOpenPath(int selected_catalog)
  {
   List<ttu.rakarh1.backend.model.data.ProductCatalog> CatalogList = null;
   List<ttu.rakarh1.backend.model.data.ProductCatalog> subCatalogList = null;
   CatalogList = new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>();
   ProductCatalog catalog = null;
   ProductCatalog subcatalog = null;
   catalog = new ProductCatalog();
   catalog.setProduct_catalog(1);
   catalog.setName("emul:arvutid");
   catalog.setUpper_catalog(0);
   catalog.setLevel(1);

   subCatalogList = new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>();
   subcatalog = new ProductCatalog();
   subcatalog.setProduct_catalog(2);
   subcatalog.setName("desktopid");
   subcatalog.setUpper_catalog(1);
   subcatalog.setLevel(2);
   subcatalog.setSubCatalogs(new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>());
   subCatalogList.add(subcatalog);

   subcatalog = new ProductCatalog();
   subcatalog.setProduct_catalog(3);
   subcatalog.setName("laptopid");
   subcatalog.setUpper_catalog(1);
   subcatalog.setLevel(2);
   subcatalog.setSubCatalogs(new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>());
   subCatalogList.add(subcatalog);

   catalog.setSubCatalogs(subCatalogList);
   CatalogList.add(catalog);

   catalog = new ProductCatalog();
   catalog.setProduct_catalog(4);
   catalog.setName("emul:printerid");
   catalog.setLevel(1);
   catalog.setUpper_catalog(0);
   subCatalogList = new ArrayList<ttu.rakarh1.backend.model.data.ProductCatalog>();
   catalog.setSubCatalogs(subCatalogList);
   CatalogList.add(catalog);

   return CatalogList;
  }

@Override
public ProductCatalog getProductCatalogById(int catalogId)
{
	// TODO Auto-generated method stub
	return null;
}


}
