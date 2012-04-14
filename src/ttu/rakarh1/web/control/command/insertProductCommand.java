package ttu.rakarh1.web.control.command;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductForm;
import ttu.rakarh1.web.forms.ProductRequestProcessor;

public class insertProductCommand implements Command {


	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException {
		int operation_result = 0;
		int inserted_product_id = 0;

		HashMap AllErrors = null ;
		HashMap ProductServiceErrors = null ;
		try {
			Product ProductToBeInserted = null;
			Product InsertedProduct = null;
			ProductService ProductService = null;
			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductRequestProcessor ProductRequestProcessor  = null ;
			ProductForm ProductForm = null ;
			ProductRequestProcessor= new ProductRequestProcessor ();
			ProductForm = ProductRequestProcessor.getFormDataFromRequest(request);
			ProductToBeInserted = ProductForm.ConvertToModelData();

			if (ProductForm.getModelDataOK() == 1)
			{
				MyLogger.LogMessage("Inserting product ProductForm.getModelDataOK()==1 ");
				ProductService = ProductServiceFactory.getService();
				inserted_product_id = ProductService.insertProduct(ProductToBeInserted);
				ProductForm.getItem();
				if (ProductService.getActionResult() == 1)
				{
					InsertedProduct = ProductService.getProductById(inserted_product_id);
					ProductForm.getDataFromModel(InsertedProduct);
					request.setAttribute ("UpdateProductForm", ProductForm);
					operation_result = 1;
				}
				else
				{

					AllErrors = new HashMap();
					if (ProductService.getErrors() != null)
					{
						ProductServiceErrors = ProductService.getErrors();
						AllErrors.putAll(ProductServiceErrors);
					}
					ProductForm.setBusinessErrors(AllErrors);
					request.setAttribute ("NewProductForm", ProductForm);
					//stateHandler.setLastState(StateEnum.MOVE);
					operation_result = -1;
				}

			}
			else
			{
				request.setAttribute ("NewProductForm", ProductForm);
				operation_result = -1;
			}

		} catch (Exception ex) {
			operation_result = 0;
			MyLogger.Log("insertProductCommand.execute():",ex.getMessage());
		}
		return operation_result ;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
