package ttu.rakarh1.web.control;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;
import ttu.rakarh1.backend.model.service.ProductService;

public class ProductServiceEmulator implements ProductService {


	private HashMap ProductServiceErrors = null;
	private int ActionResult = 0;

	public HashMap getErrors()
	{
		return ProductServiceErrors;
	}

	public int getActionResult()
	{
		return ActionResult;
	}

	public Product getProductById(int product_id) {
	 Product product = null;
	 product = new Product();
	 product.setProduct(1);
	 product.setName("EMULATED - HP Term788");
	 product.setProduct_catalog(8);
	 product.setProduct_code("H455R566");
	 product.setStore_price(100000);
	 product.setSale_price(10);
	 product.setDescription("");
	 return product ;
	}

	 public int insertProduct(Product newProduct) {
	 int inserted_product_id = 0;
	 if (newProduct.getStore_price() < 100)
	 {
     inserted_product_id = 1 ;
	 ActionResult = 1;
	 }
	 else
	 {
	 ProductServiceErrors = new HashMap();
	 ProductServiceErrors.put("eshop_price","hind yle 100");
	 ActionResult = -1;
	 }

	 return inserted_product_id ;
	}

	 public int updateProduct(Product updatedProduct) {

	 if (updatedProduct.getStore_price() < 100)
	 {
	 	 ActionResult = 1;
	 }
	 else
	 {
	 ProductServiceErrors = new HashMap();
	 ProductServiceErrors.put("eshop_price","hind yle 100");
	 ActionResult = -1;
	 }
	 return ActionResult ;
	}

	public List<ttu.rakarh1.backend.model.data.Product> searchProducts(ProductSearchCriteria ProductSearchCriteria) {
	 List<ttu.rakarh1.backend.model.data.Product> ProductList = null;
	 ProductList = new ArrayList<ttu.rakarh1.backend.model.data.Product>();
	 Product product = null;
	 product = new Product();
	 product.setProduct(1);
	 product.setName("EMULATED - Cisco R344");
	 product.setProduct_catalog(8);
	 product.setProduct_code("C55R566");
	 product.setStore_price(1000);
	 product.setSale_price(10);
	 product.setDescription("");
	 ProductList.add(product);

	 product = new Product();
	 product.setProduct(2);
	 product.setName("EMULATED - 3COM C76");
	 product.setProduct_catalog(8);
	 product.setProduct_code("3C455R566");
	 product.setStore_price(3000);
	 product.setSale_price(10);
	 product.setDescription("");
	 ProductList.add(product);
	 return ProductList;
	}

		public List<ttu.rakarh1.backend.model.data.Product> getProductsByCatalog(int catalog_id)
	{
	 List<ttu.rakarh1.backend.model.data.Product> ProductList = null;
	 ProductList = new ArrayList<ttu.rakarh1.backend.model.data.Product>();
	 Product product = null;
	 product = new Product();
	 product.setProduct(1);
	 product.setName("EMULATED - Cisco R344");
	 product.setProduct_catalog(catalog_id);
	 product.setProduct_code("C55R566");
	 product.setStore_price(1000);
	 product.setSale_price(10);
	 product.setDescription("");
	 ProductList.add(product);

	 product = new Product();
	 product.setProduct(2);
	 product.setName("EMULATED - 3COM C76");
	 product.setProduct_catalog(catalog_id);
	 product.setProduct_code("3C455R566");
	 product.setStore_price(3000);
	 product.setSale_price(10);
	 product.setDescription("");
	 ProductList.add(product);
	 return ProductList;

	}

		@Override
		public List<Product> searchProducts(
				ProductSearchCriteria ProductSearchCriteria,
				HttpServletRequest request) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int updateProductAttributes(List<FormAttribute> formAttributes, int item)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		public int insertProductAttributes(List<FormAttribute> formAttributes, String producerCode)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int insertProductAttributes(List<FormAttribute> formAttributes, int product_id)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getProductId(String producerCode)
		{
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean showAddProduct(int catalog)
		{
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public ArrayList<Product> getProductsByCatalogForRemoval(int catalogedToBeremovedFrom)
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ProductCatalog getCatalogById(int catalogedToBeremovedFrom)
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Product> getRemovableItems(ArrayList<Integer> productsToBeRemoved)
		{
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int removeProducts(ArrayList<Product> removableItems)
		{
			// TODO Auto-generated method stub
			return 0;
		}






}


