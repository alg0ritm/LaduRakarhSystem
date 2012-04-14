package ttu.rakarh1.backend.model.service;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductExistance;
import ttu.rakarh1.web.forms.OperationOnProductForm;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public interface TakeOnTheAccountService
{
	public int takeOnTheAccount(Product product);

	public TakeOnTheAccountForm getTakeOnTheAccountForm();

	public int takeProductOnTheAccount(OperationOnProductForm takeOnTheAccountForm,  Product product);
	public int removeProductFromTheAccount(OperationOnProductForm takeOnTheAccountForm, Product product, ProductExistance productExistance);

	public Product recalculatePrice(OperationOnProductForm takeOnTheAccountForm,
			Product currentProduct);

	public int moveProduct(OperationOnProductForm takeOnTheAccountForm, Product currentProduct);

	public ProductExistance checkProductExistance(OperationOnProductForm takeOnTheAccountForm,
			Product currentProduct);

	public ProductExistance checkProductExistanceTo(OperationOnProductForm takeOnTheAccountForm,
			Product currentProduct);

	public int insertProduct(OperationOnProductForm takeOnTheAccountForm, Product currentProduct);

}
