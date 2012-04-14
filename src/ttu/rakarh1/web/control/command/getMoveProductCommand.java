package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.MoveProductService;
import ttu.rakarh1.backend.model.service.MoveProductServiceImpl;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.backend.model.service.ProductServiceImpl;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.MoveForm;

public class getMoveProductCommand implements Command
{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{
		String item = request.getParameter("product_id");
		int intItem = Integer.parseInt(item);
		String catalog = request.getParameter("catalog");
		int intCatalog = Integer.parseInt(catalog);
		MoveForm moveProductForm = new MoveForm();
		moveProductForm.setItem(item);
		moveProductForm.setCatalog(catalog);

		ProductService productService = new ProductServiceImpl();
		Product currentProduct = productService.getProductById(intItem);

		ArrayList<ItemStore> wareHousesFrom = new ArrayList<ItemStore>();
		ArrayList<ItemStore> wareHousesTo = new ArrayList<ItemStore>();
		MoveProductService moveProductService = null;
		moveProductService = new MoveProductServiceImpl();
		wareHousesFrom = moveProductService.getAvailStoresForItem(currentProduct);
		// MyLogger.LogMessage("getMoveProductCommand execute() before getAvailStores");
		wareHousesTo = moveProductService.getAvailStores();

		request.setAttribute(Constant.MOVE_PRODUCT_FORM, moveProductForm);
		request.setAttribute(Constant.WAREHOUSES_FROM, wareHousesFrom);
		request.setAttribute(Constant.WAREHOUSES_TO, wareHousesTo);

		int operation_result = 1;

		return operation_result;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
