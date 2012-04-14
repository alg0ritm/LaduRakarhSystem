package ttu.rakarh1.backend.dao ;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;

public interface ProductDAO {

	public void setDbConnection(dbconnection dbconnection);
	public Product getProductById(int product_id);
    public List<ttu.rakarh1.backend.model.data.Product> searchProducts(ProductSearchCriteria ProductSearchCriteria, HttpServletRequest request);
	public int insertProduct(Product newProduct);
	public int updateProduct(Product updatedProduct);
	public List<ttu.rakarh1.backend.model.data.Product> getProductsByCatalog(int catalog_id);
	public int getProductId(String producerCode);
	public boolean showAddProduct(int catalog);
	public ArrayList<Product> getProductsByCatalogForRemoval(int catalogedToBeremovedFrom);
	public ProductCatalog getCatalogById(int catalogedToBeremovedFrom);
	public int removeProducts(ArrayList<Product> removableItems);
}
