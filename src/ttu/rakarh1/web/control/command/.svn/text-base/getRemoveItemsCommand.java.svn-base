package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductCatalog;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.backend.model.service.ProductServiceImpl;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.RemoveItemsForm;

public class getRemoveItemsCommand implements Command
{
	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException {
		int operation_result = 0;
		int inserted_product_id = 0;

		HashMap AllErrors = null ;
		HashMap ProductServiceErrors = null ;
		try {
			RemoveItemsForm removeItemsForm = null;
			ProductService productService = null;

			int catalogedToBeremovedFrom = Integer.parseInt((String) request.getParameter("catalog"));

			productService = new ProductServiceImpl();

			ArrayList<Product> productsForRemoval = productService.getProductsByCatalogForRemoval(catalogedToBeremovedFrom);
			ProductCatalog catalog = productService.getCatalogById(catalogedToBeremovedFrom);



			if(productsForRemoval.size()>0)
			{
				removeItemsForm = new RemoveItemsForm();
				removeItemsForm.setProductsList(productsForRemoval);
				removeItemsForm.setCatalog(catalog);
				removeItemsForm.generateHtml();
				request.setAttribute(Constant.REMOVABLE_ITEMS_FORM, removeItemsForm);
			}
			else {
				stateHandler.addPopupNotification("No products available", "Ei ole producte mis on võimalik kustutada");
			}
			operation_result = 1;

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
