package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.backend.model.service.ProductServiceImpl;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductRequestProcessor;
import ttu.rakarh1.web.forms.RemoveItemsForm;

public class RemoveItemsCommand implements Command
{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{

		int operationResult =0;

		ProductService productService = new ProductServiceImpl();
		ProductRequestProcessor productRequestProcessor = new ProductRequestProcessor();
		ArrayList<Integer> productsToBeRemoved = productRequestProcessor.getRemovableItemsDataFromRequest(request);
		RemoveItemsForm removeItemsForm = new RemoveItemsForm();
		ArrayList<Product> removableItems= productService.getRemovableItems(productsToBeRemoved);
		operationResult = productService.removeProducts(removableItems);

		return 		operationResult;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
