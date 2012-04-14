package ttu.rakarh1.web.control.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.enums.StateEnum;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductForm;
import ttu.rakarh1.web.forms.ProductRequestProcessor;

public class getProductCommand implements Command {


	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException {

		int operation_result = 0;
		int product_id = 0;
		String request_product_id ="";
		String productCode = "";
		try {
		    request_product_id = request.getParameter("product_id");
		    System.out.println(" TQ JREBEL PROSNIS");
			product_id = Integer.parseInt(request_product_id);
			Product SelectedProduct = null;
			ProductService ProductService = null;
			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductRequestProcessor ProductRequestProcessor  = null;
			ProductForm ProductForm = null ;
			ProductForm = new ProductForm();
			ProductService = ProductServiceFactory.getService();
			SelectedProduct = ProductService.getProductById(product_id);
			ProductForm.getDataFromModel(SelectedProduct);
			request.setAttribute ("UpdateProductForm", ProductForm);
			stateHandler.setLastProduct(SelectedProduct);
			stateHandler.setLastState(StateEnum.EDIT);
			operation_result = 1;

		} catch (Exception ex) {
			operation_result = -1;
			MyLogger.Log("getProductCommand.execute():",ex.getMessage());
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
