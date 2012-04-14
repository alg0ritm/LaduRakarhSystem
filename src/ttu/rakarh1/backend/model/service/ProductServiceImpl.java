package ttu.rakarh1.backend.model.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ttu.rakarh1.backend.dao.DrawSearchFormDAOImpl;
import ttu.rakarh1.backend.dao.ProductCatalogDAO;
import ttu.rakarh1.backend.dao.ProductDAO;
import ttu.rakarh1.backend.dao.ProductDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.business_logic.ProductValidator;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.data.ProductSearchCriteria;
import ttu.rakarh1.log.MyLogger;

public class ProductServiceImpl implements ProductService
{

	private ProductCatalogDAO ProductCatalogDAO;
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

	public Product getProductById(int product_id)
	{
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		Product product = null;
		product = ProductDAO.getProductById(product_id);
		dbconnection.close();
		return product;
	}

	public int insertProduct(Product newProduct)
	{
		int inserted_product_id = 0;
		dbconnection dbconnection = null;
		try
		{
			ttu.rakarh1.backend.model.business_logic.ProductValidator ProductValidator = new ProductValidator();
			if (ProductValidator.ValidateProduct(newProduct) == 1)
			{
				ProductDAO ProductDAO = new ProductDAOImpl();
				dbconnection = new dbconnection();
				ProductDAO.setDbConnection(dbconnection);
				inserted_product_id = ProductDAO.insertProduct(newProduct);
				dbconnection.close();
				ActionResult = 1;
			} else
			{
				ProductServiceErrors = ProductValidator.getErrors();
				ActionResult = -1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("ProductServiceImpl.updateProduct():", ex.getMessage());
			if (dbconnection != null)
			{
				dbconnection.close();
			}
			ActionResult = -1;
		}
		return inserted_product_id;
	}

	public int updateProduct(Product updatedProduct)
	{
		dbconnection dbconnection = null;
		try
		{
			ttu.rakarh1.backend.model.business_logic.ProductValidator ProductValidator = new ProductValidator();
			if (ProductValidator.ValidateProduct(updatedProduct) == 1)
			{
				ProductDAO ProductDAO = new ProductDAOImpl();
				dbconnection = new dbconnection();
				ProductDAO.setDbConnection(dbconnection);
				ProductDAO.updateProduct(updatedProduct);
				dbconnection.close();
				ActionResult = 1;
			} else
			{
				ProductServiceErrors = ProductValidator.getErrors();
				ActionResult = -1;
			}
		} catch (Exception ex)
		{
			MyLogger.Log("ProductServiceImpl.updateProduct():", ex.getMessage());
			if (dbconnection != null)
			{
				dbconnection.close();
			}
			ActionResult = -1;
		}
		return ActionResult;
	}

	public List<ttu.rakarh1.backend.model.data.Product> searchProducts(
			ProductSearchCriteria ProductSearchCriteria, HttpServletRequest request)
	{
		List<ttu.rakarh1.backend.model.data.Product> products = null;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		products = ProductDAO.searchProducts(ProductSearchCriteria, request);
		dbconnection.close();
		// MyLogger.LogMessage("PRODUCT LIST"+ products.toString());
		return products;
	}

	public List<ttu.rakarh1.backend.model.data.Product> getProductsByCatalog(int catalog_id)
	{
		List<ttu.rakarh1.backend.model.data.Product> products = null;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		products = ProductDAO.getProductsByCatalog(catalog_id);
		dbconnection.close();
		return products;

	}

	@Override
	public int updateProductAttributes(List<FormAttribute> formAttributes, int item)
	{
		dbconnection dbconnection = null;

		try
		{
			DrawSearchFormDAOImpl drawSearchFormDAOImpl = new DrawSearchFormDAOImpl();
			ProductDAO ProductDAO = new ProductDAOImpl();
			dbconnection = new dbconnection();
			drawSearchFormDAOImpl.setDbConnection(dbconnection);
			drawSearchFormDAOImpl.updateProductAttributes(formAttributes, item);
			dbconnection.close();

		} catch (Exception E)
		{
			MyLogger.Log("ProductServiceImpl -> updateProductAttributes", E.getMessage());
		}
		ActionResult = 1;
		return ActionResult;

	}

	@Override
	public int insertProductAttributes(List<FormAttribute> formAttributes, int producerCode)
	{
		MyLogger.LogMessage("ProductServiceImpl -> insertProductAttributes");
		dbconnection dbconnection = null;

		try
		{
			DrawSearchFormDAOImpl drawSearchFormDAOImpl = new DrawSearchFormDAOImpl();
			ProductDAO ProductDAO = new ProductDAOImpl();
			dbconnection = new dbconnection();
			drawSearchFormDAOImpl.setDbConnection(dbconnection);
			drawSearchFormDAOImpl.insertProductAttributes(formAttributes, producerCode);
			dbconnection.close();

		} catch (Exception E)
		{
			MyLogger.Log("ProductServiceImpl -> updateProductAttributes", E.getMessage());
		}
		ActionResult = 1;
		return ActionResult;

	}

	@Override
	public int getProductId(String producerCode)
	{
		int insProduct;
		dbconnection dbconnection = new dbconnection();
		ProductDAO ProductDAO = new ProductDAOImpl();
		ProductDAO.setDbConnection(dbconnection);
		insProduct = ProductDAO.getProductId(producerCode);
		dbconnection.close();
		return insProduct;
	}

	@Override
	public boolean showAddProduct(int catalog)
	{
		boolean showAddProduct = false;
		dbconnection dbconnection = new dbconnection();
		ProductDAO ProductDAO = new ProductDAOImpl();
		ProductDAO.setDbConnection(dbconnection);
		showAddProduct = ProductDAO.showAddProduct(catalog);
		return showAddProduct;
	}

	@Override
	public ArrayList<Product> getProductsByCatalogForRemoval(int catalogedToBeremovedFrom)
	{
		ArrayList<ttu.rakarh1.backend.model.data.Product> products = null;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		products = ProductDAO.getProductsByCatalogForRemoval(catalogedToBeremovedFrom);
		dbconnection.close();
		return products;
	}

	@Override
	public ProductCatalog getCatalogById(int catalogedToBeremovedFrom)
	{
		// TODO Auto-generated method stub
		ProductCatalog catalog = null;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		catalog = ProductDAO.getCatalogById(catalogedToBeremovedFrom);
		dbconnection.close();
		return catalog;
	}

	@Override
	public ArrayList<Product> getRemovableItems(ArrayList<Integer> productsToBeRemoved)
	{
		ProductCatalog catalog = null;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		ArrayList<Product> productsList = new ArrayList<Product>();
		int i = 0;
		Iterator it = productsToBeRemoved.iterator();
		while(it.hasNext()) {
			Integer next = (Integer) it.next();
			Product product  = ProductDAO.getProductById(next);
			productsList.add(product);

		}

		dbconnection.close();
		return productsList;
	}

	@Override
	public int removeProducts(ArrayList<Product> removableItems)
	{
		int result = 0;
		ProductDAO ProductDAO = new ProductDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		ProductDAO.setDbConnection(dbconnection);
		result = ProductDAO.removeProducts(removableItems);
		dbconnection.close();
		return result;
	}

}
