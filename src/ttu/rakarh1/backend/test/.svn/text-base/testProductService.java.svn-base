package ttu.rakarh1.backend.test ;
import java.util.*;
import java.text.*;
import ttu.rakarh1.log.MyLogger ;
import ttu.rakarh1.backend.model.service.* ;
import ttu.rakarh1.backend.model.data.*;

public class testProductService {

    public static void main(String[] args) throws Exception {
     int inserted_product_id = 0 ;
	 System.out.println("--------CRUD test:ProductService.insertProduct()/updateProduct()/getProductById()---------------------------");
     ProductService ProductService = new ProductServiceImpl();
	 Product product = null;
	 Product selected_product = null;
	 Product updated_product = null;
	 product = new Product();
	 product.setName("HP Term788");
	 product.setProduct_catalog(8);
	 product.setProduct_code("H455R566");
	 product.setStore_price(100000000);
	 product.setSale_price(10);
	 product.setDescription("");
	 inserted_product_id = ProductService.insertProduct(product);
	 if (ProductService.getActionResult() == 1)
	 {
     System.out.println("inserted product id:" + Integer.toString(inserted_product_id));
	 selected_product = ProductService.getProductById(inserted_product_id);
	 printProduct(selected_product);
	 }
	 else
	 {
	 HashMap ProductServiceErrors = ProductService.getErrors();
	 Iterator it = ProductServiceErrors.keySet().iterator(); 
	 while(it.hasNext()) 
	  { Object key = it.next(); 
	    String error_msg = (String) ProductServiceErrors.get(key);
		System.out.println("VIGA TOOTE ANDMETES (Validator annab teada):#" + error_msg + "#");
	   }
	 // valime mone teise toote id paringuks kuna uut toodet sisestada ei onnestunud  
	 selected_product = ProductService.getProductById(5); 
	 }
	 
     DateFormat df = new SimpleDateFormat("MM/dd/yyyy mm:ss"); 
     Date today = Calendar.getInstance().getTime(); 
     String updateTime = df.format(today); 
     selected_product.setProduct_code(updateTime);
	 ProductService.updateProduct(selected_product);
	 updated_product = ProductService.getProductById(selected_product.getProduct());
	 System.out.println("--------toote andmed peale muutmist:---------------------------------");
	 printProduct(updated_product);
	 System.out.println("--------Otsingu testimine:ProductService.searchProducts()---------------------------------");
	 List<ttu.rakarh1.backend.model.data.Product> products = null;
	 ProductSearchCriteria ProductSearchCriteria = new ProductSearchCriteria();
	 ProductSearchCriteria.setName("Proliant");
	// products = ProductService.searchProducts(ProductSearchCriteria);	 
	 System.out.println("ilma hinnavahemikuta, nime jargi, nimi:" + ProductSearchCriteria.getName());
	 System.out.println("-------------------------------------------------------");
     printProducts(products);
	 ProductSearchCriteria.setMin_price(0);
	 ProductSearchCriteria.setMax_price(100);
	 ProductSearchCriteria.setName("");
	// products = ProductService.searchProducts(ProductSearchCriteria);
	 System.out.println("hinnavahemiku jargi, min price:" + ProductSearchCriteria.getMin_price() + " max_price:" + ProductSearchCriteria.getMax_price() );
	 System.out.println("-------------------------------------------------------");
     printProducts(products);
	}
	
	 public static void printProduct(Product p)
	 {
	        System.out.println("----------------TOOTE nr: " + Integer.toString(p.getProduct()) + " andmed---------------------------------");
            System.out.println("Product: " + p.getName() + " code:" + p.getProduct_code() +  " hind:" + p.getStore_price());

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


