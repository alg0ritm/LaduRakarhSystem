package ttu.rakarh1.backend.model.business_logic ;
import java.util.HashMap;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.log.MyLogger;

public class ProductValidator {

	private HashMap ProductErrors=null;


	public void ProductValidator()
	{

	}

	public int ValidateProduct(Product ValidatableProduct)
	{
		ProductErrors = new HashMap();
	    int productOK =1 ;
		try
		{

			if (ValidatableProduct.getStore_price() > 1000000)
			{
				ProductErrors.put("eshop_price","hind yle miljoni");
				productOK = -1;
			}


			if ((ValidatableProduct.getStore_price() <  10) && (ValidatableProduct.getSale_price() > 5 ))
			{
				ProductErrors.put("max_customer_discount","liiga suur maks. allahindluse protsent");
				productOK = -1;
			}
		}
		catch(Exception ex)
		{
			MyLogger.Log("ProductValidator.ValidateProduct():",ex.getMessage());
			productOK = -1;
		}
		return productOK;

	}

	public HashMap getErrors()
	{
	return this.ProductErrors;
	}

}
