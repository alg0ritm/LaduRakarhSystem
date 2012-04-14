package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.backend.enums.StateEnum;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.MoveProductService;
import ttu.rakarh1.backend.model.service.MoveProductServiceImpl;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.backend.model.service.ProductServiceImpl;
import ttu.rakarh1.backend.model.service.TakeOnTheAccountService;
import ttu.rakarh1.backend.model.service.TakeOnTheAccountServiceImpl;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.MoveProductForm;
import ttu.rakarh1.web.forms.OperationOnProductForm;
import ttu.rakarh1.web.forms.RemoveFromTheAccountForm;
import ttu.rakarh1.web.forms.TakeOnTheAccountForm;

public class getTakeOnTheAccountCommand implements Command
{
	ProductTransactionTypes type;
	public getTakeOnTheAccountCommand(ProductTransactionTypes type) {
		this.type = type;
	}

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
	throws ServletException, IOException
	{
		Product currentProduct;
		int operation_result = 0;
		ArrayList<ItemStore> itemStoreList = null;
		String item = request.getParameter("product_id");
		String catalog = request.getParameter("catalog");
		ProductService productService = new ProductServiceImpl();
		currentProduct = productService.getProductById(Integer.parseInt(item));
		TakeOnTheAccountService takeOnTheAccountService = new TakeOnTheAccountServiceImpl();
		MoveProductService itemStoreService = new MoveProductServiceImpl();
		ArrayList<ItemStore> availableItemStoreList = new ArrayList<ItemStore>();
		OperationOnProductForm operationOnProductForm = new OperationOnProductForm();
		switch(type) {
			case  TAKE:
				itemStoreList = itemStoreService.getAvailStores();
				TakeOnTheAccountForm takeOnTheAccountForm = new TakeOnTheAccountForm();
				takeOnTheAccountForm.setItemStoreList(itemStoreList);
				takeOnTheAccountForm.setProduct(currentProduct);
				takeOnTheAccountForm.setTransactionType(type);
				operationOnProductForm = takeOnTheAccountForm;
				break;
			case REMOVE:
				itemStoreList = itemStoreService.getAvailStoresForItem(currentProduct);
				RemoveFromTheAccountForm removeFromTheAccountForm = new RemoveFromTheAccountForm();
				removeFromTheAccountForm.setItemStoreList(itemStoreList);
				removeFromTheAccountForm.setProduct(currentProduct);
				removeFromTheAccountForm.setTransactionType(type);
				operationOnProductForm = removeFromTheAccountForm;
				break;
			case MOVE:
				itemStoreList = itemStoreService.getAvailStoresForItem(currentProduct);
				availableItemStoreList = itemStoreService.getAvailStores(itemStoreList);
				MoveProductForm moveProductForm  = new MoveProductForm();
				moveProductForm.setItemStoreList(itemStoreList);
				moveProductForm.setProduct(currentProduct);
				moveProductForm.setTransactionType(type);
				moveProductForm.setAvailableItemStoreList(availableItemStoreList);
				operationOnProductForm = moveProductForm;
		}

		MyLogger.LogMessage("Middle");



		MyLogger.LogMessage("End");
		request.setAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM, operationOnProductForm);
		HttpSession session = request.getSession();
		session.setAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM, operationOnProductForm);
		stateHandler.setLastState(StateEnum.MOVE);
		return operation_result;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
