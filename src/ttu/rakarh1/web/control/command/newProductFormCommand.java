package ttu.rakarh1.web.control.command;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductForm;

public class newProductFormCommand implements Command {

// initsialiseerib tyhja toote lisamise vormi

	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException {
		int operation_result = 0;
		int inserted_product_id = 0;

		try {
			Product ProductToBeInserted = null;
			Product InsertedProduct = null;
			ProductService ProductService = null;
			ProductForm ProductForm = new ProductForm() ;
			request.setAttribute ("NewProductForm", ProductForm);

		} catch (Exception ex) {
			operation_result = 0;
			MyLogger.Log("newProductFormCommand.execute():",ex.getMessage());
		}
		return 1;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
