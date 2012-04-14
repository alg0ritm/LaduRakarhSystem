package ttu.rakarh1.backend.test ;

import java.util.*;
import ttu.rakarh1.backend.model.data.* ;
import ttu.rakarh1.backend.model.service.* ;
import ttu.rakarh1.log.MyLogger ;



public class DrawCatalog {


    public ProductCatalog selectedCatalog = null;
	
	    public static void main(String[] args) throws Exception {
         DrawCatalog DrawCatalog = new DrawCatalog ();
		 System.out.println("Catalog Tree:");
		 System.out.println(DrawCatalog.DrawCatalogTree(2));
		}
	
    public String DrawCatalogTree (int selected_catalog_id)
	{
	List<ProductCatalog> OpenedCatalogTree = null;
	String catalog_out = "";
	ProductCatalog catalog = null;
	ttu.rakarh1.backend.model.service.ProductCatalogTree ProductCatalogTree = new ProductCatalogTreeImpl();
	OpenedCatalogTree =  ProductCatalogTree.getTreeWithOneOpenPath(selected_catalog_id);
		for (int i=0; i< OpenedCatalogTree.size(); i++)
	        {
	 	    catalog = (ProductCatalog) OpenedCatalogTree.get(i);
			catalog_out = catalog_out + drawCatalog(catalog,selected_catalog_id);			
			}
	return catalog_out ;	
	
	}
	
	public String drawCatalog(ProductCatalog catalog,int selected_catalog_id)
	{
	String catalog_out = "";
	String selected_indicator = "";
	if (selected_catalog_id == catalog.getProduct_catalog())
	{
	this.selectedCatalog = catalog ;
	selected_indicator = "<b>[*]</b>";
	}
	ProductCatalog subcatalog = null;
	for (int i=0; i< (catalog.getLevel() - 1); i++)
		{
		catalog_out = catalog_out + "--" ;
		}
	catalog_out = catalog_out + selected_indicator + "<a href=\"?catalog=" + catalog.getProduct_catalog() + "\">" + catalog.getName() + "</a><br>\n";
	
	if (catalog.getSubCatalogs() != null)
	{
	Iterator iter = catalog.getSubCatalogs().iterator();
			while (iter.hasNext())
	          {
               subcatalog = (ProductCatalog) iter.next();
			   catalog_out = catalog_out + drawCatalog(subcatalog,selected_catalog_id);
			   }
	}		   
	return catalog_out;
	}


}