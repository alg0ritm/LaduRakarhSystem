package ttu.rakarh1.backend.test ;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ttu.rakarh1.backend.dao.ProductDAO;
import ttu.rakarh1.backend.dao.ProductDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.Product;

public class testProductDAOInsertUpdate {

    public static void main(String[] args) throws Exception {
     int inserted_product_id = 0 ;
     ProductDAO ProductDAO = new ProductDAOImpl();
	 dbconnection dbconnection = null ;
	 dbconnection = new dbconnection();
	 ProductDAO.setDbConnection(dbconnection);
	 Product product = null;
	 Product selected_product = null;
	 Product updated_product = null;
	 product = new Product();
	 product.setName("HP Term788");
	 product.setProduct_catalog(8);
	 product.setProduct_code("H455R566");
	 product.setStore_price(300);
	 product.setSale_price(10);
	 product.setDescription("");
	 inserted_product_id = ProductDAO.insertProduct(product);
     System.out.println("inserted product id:" + Integer.toString(inserted_product_id));
	 selected_product = ProductDAO.getProductById(inserted_product_id);
	 printProduct(selected_product);
     DateFormat df = new SimpleDateFormat("MM/dd/yyyy mm:ss");
     Date today = Calendar.getInstance().getTime();
     String updateTime = df.format(today);
     selected_product.setProduct_code(updateTime);
	 ProductDAO.updateProduct(selected_product);
	 updated_product = ProductDAO.getProductById(selected_product.getProduct());
	 System.out.println("--------toote andmed peale muutmist:---------------------------------");
	 printProduct(updated_product);
	 dbconnection.close();
	}

	 public static void printProduct(Product p)
	 {
	        System.out.println("----------------TOOTE nr: " + Integer.toString(p.getProduct()) + " andmed---------------------------------");
            System.out.println("Product: " + p.getName() + " code:" + p.getProduct_code() +  " hind:" + p.getStore_price());

	 }

}


