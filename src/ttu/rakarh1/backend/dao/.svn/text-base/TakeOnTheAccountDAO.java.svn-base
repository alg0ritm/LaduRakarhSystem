package ttu.rakarh1.backend.dao;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductExistance;
import ttu.rakarh1.web.forms.OperationOnProductForm;

public interface TakeOnTheAccountDAO
{
	public int takeOnTheAccount(Product product);
	public Product recalculatePrice(Product product, OperationOnProductForm takeOnTheAccountForm);
	public int takeProductOnTheAccount(OperationOnProductForm takeOnTheAccountForm, Product product);
	public void setDbConnection(dbconnection dbconnection);
	public int removeProductFromTheAccount(OperationOnProductForm takeOnTheAccountForm ,Product product, ProductExistance productExistance);
	public int moveProduct(OperationOnProductForm takeOnTheAccountForm, Product product);
	public ProductExistance checkProductExistance(OperationOnProductForm takeOnTheAccountForm, Product product);
	public ProductExistance checkProductExistanceTo(OperationOnProductForm takeOnTheAccountForm,Product currentProduct);
	public int insertProduct(OperationOnProductForm takeOnTheAccountForm, Product product);


}
