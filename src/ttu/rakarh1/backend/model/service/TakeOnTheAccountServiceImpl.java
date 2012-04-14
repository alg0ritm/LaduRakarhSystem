package ttu.rakarh1.backend.model.service;

import ttu.rakarh1.backend.dao.TakeOnTheAccountDAO;
import ttu.rakarh1.backend.dao.TakeOnTheAccountDAOImpl;
import ttu.rakarh1.backend.dao.dbconnection;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductExistance;
import ttu.rakarh1.web.forms.OperationOnProductForm;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public class TakeOnTheAccountServiceImpl implements TakeOnTheAccountService
{
	public int takeOnTheAccount(Product product)
	{
		int op_result = 0;
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		op_result = takeOnTheAccountDAO.takeOnTheAccount(product);
		return op_result;

	}

	@Override
	public TakeOnTheAccountForm getTakeOnTheAccountForm()
	{
		TakeOnTheAccountForm takeOnTheAccountForm = new TakeOnTheAccountForm();

		return takeOnTheAccountForm;
	}

	@Override
	public int takeProductOnTheAccount(OperationOnProductForm takeOnTheAccountForm,  Product product)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		int result = 0;
		try
		{
			result  = takeOnTheAccountDAO.takeProductOnTheAccount(takeOnTheAccountForm, product);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Product recalculatePrice(OperationOnProductForm takeOnTheAccountForm,
			Product product)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		Product updatedProduct = new Product();
		int result = 0;
		try
		{
			updatedProduct  = takeOnTheAccountDAO.recalculatePrice(product, takeOnTheAccountForm);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return updatedProduct;
	}

	@Override
	public int moveProduct(OperationOnProductForm takeOnTheAccountForm, Product product)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;

		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		int result = 0;
		try
		{
			result  = takeOnTheAccountDAO.moveProduct(takeOnTheAccountForm,product);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;

	}



	@Override
	public int removeProductFromTheAccount(OperationOnProductForm takeOnTheAccountForm,
			Product product, ProductExistance productExistance)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;
		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		int result = 0;
		try
		{
			result  = takeOnTheAccountDAO.removeProductFromTheAccount(takeOnTheAccountForm,product,productExistance);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ProductExistance checkProductExistance(OperationOnProductForm takeOnTheAccountForm,
			Product currentProduct)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;
		ProductExistance productExistance = null;
		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		Product updatedProduct = new Product();
		try
		{
			productExistance  = takeOnTheAccountDAO.checkProductExistance(takeOnTheAccountForm, currentProduct);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return productExistance;

	}

	@Override
	public ProductExistance checkProductExistanceTo(OperationOnProductForm takeOnTheAccountForm,
			Product currentProduct)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;
		ProductExistance productExistance = null;
		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		Product updatedProduct = new Product();
		try
		{
			productExistance  = takeOnTheAccountDAO.checkProductExistanceTo(takeOnTheAccountForm, currentProduct);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return productExistance;


	}

	@Override
	public int insertProduct(OperationOnProductForm takeOnTheAccountForm, Product product)
	{
		TakeOnTheAccountDAO takeOnTheAccountDAO = new TakeOnTheAccountDAOImpl();
		dbconnection dbconnection = null;

		dbconnection = new dbconnection();
		takeOnTheAccountDAO.setDbConnection(dbconnection);
		ItemStore itemStore = null;
		int result = 0;
		try
		{
			result  = takeOnTheAccountDAO.insertProduct(takeOnTheAccountForm,product);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;


	}

}
