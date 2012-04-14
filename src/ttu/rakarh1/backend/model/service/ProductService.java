package ttu.rakarh1.backend.model.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;

public interface ProductService {

	public int getActionResult();
	public HashMap getErrors();
	public Product getProductById(int product_id);
    public int insertProduct(Product newProduct);
	public int updateProduct(Product updatedProduct);
	public List<ttu.rakarh1.backend.model.data.Product> searchProducts(ProductSearchCriteria ProductSearchCriteria, HttpServletRequest request);
	public List<ttu.rakarh1.backend.model.data.Product> getProductsByCatalog(int catalog_id);
	public int updateProductAttributes(List<FormAttribute> formAttributes, int item);
	public int insertProductAttributes(List<FormAttribute> formAttributes, int product_id);
	public int getProductId(String producerCode);
	boolean showAddProduct(int catalog);
	public ArrayList<Product> getProductsByCatalogForRemoval(int catalogedToBeremovedFrom);
	public ProductCatalog getCatalogById(int catalogedToBeremovedFrom);
	public ArrayList<Product> getRemovableItems(ArrayList<Integer> productsToBeRemoved);
	public int removeProducts(ArrayList<Product> removableItems);


}
