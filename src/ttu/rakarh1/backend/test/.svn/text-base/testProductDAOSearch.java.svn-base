package ttu.rakarh1.backend.test ;
import java.util.List;

import ttu.rakarh1.backend.dao.ProductDAO;
import ttu.rakarh1.backend.dao.ProductDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;

public class testProductDAOSearch {

    public static void main(String[] args) throws Exception {

     ProductDAO ProductDAO = new ProductDAOImpl();
     dbconnection dbconnection = null ;
	 dbconnection = new dbconnection();
	 ProductDAO.setDbConnection(dbconnection);
	 List<ttu.rakarh1.backend.model.data.Product> products = null;
	 ProductSearchCriteria ProductSearchCriteria = new ProductSearchCriteria();
	 ProductSearchCriteria.setName("Proliant");
	 //products = ProductDAO.searchProducts(ProductSearchCriteria);

	 System.out.println("ilma hinnavahemikuta, nime jargi, nimi:" + ProductSearchCriteria.getName());
	 System.out.println("-------------------------------------------------------");
     printProducts(products);

	 ProductSearchCriteria.setMin_price(0);
	 ProductSearchCriteria.setMax_price(100);
	 ProductSearchCriteria.setName("");
	 //products = ProductDAO.searchProducts(ProductSearchCriteria);
	 System.out.println("hinnavahemiku jargi, min price:" + ProductSearchCriteria.getMin_price() + " max_price:" + ProductSearchCriteria.getMax_price() );
	 System.out.println("-------------------------------------------------------");
     printProducts(products);
	 dbconnection.close();
	}

	 public static void printProducts(List<Product> products)
	 {
	   if (products != null)
	    {
	       for (Product p: products) {
            System.out.println("Product: " + p.getName() + "code:" + p.getProduct_code() +  " hind:" + p.getStore_price());
          }
        }
	   else
	   {
	    System.out.println("ei saanud midagi");
	   }
	 }

}


