package ttu.rakarh1.web.control.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.enums.ProductTransactionTypes;
import ttu.rakarh1.backend.model.data.ItemStore;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.data.ProductExistance;
import ttu.rakarh1.backend.model.service.MoveProductService;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.backend.model.service.ProductServiceImpl;
import ttu.rakarh1.backend.model.service.SupplyFormWithRequestData;
import ttu.rakarh1.backend.model.service.TakeOnTheAccountService;
import ttu.rakarh1.backend.model.service.TakeOnTheAccountServiceImpl;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.OperationOnProductForm;

public class TakeOnTheAccountCommand implements Command
{
	ProductTransactionTypes type;
	OperationOnProductForm takeOnTheAccountForm = null;

	public TakeOnTheAccountCommand(ProductTransactionTypes type)
	{
		System.out.println("JREBE: TEST");
		System.out.println("JREBE: TEST 3 ");
		this.type = type;
		System.out.println("JREBE: TEST");
		System.out.println("JREBE: TEST 4");
	}

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{
		int item;
		Product currentProduct;
		ProductService productService;
		ProductExistance productExistance;
		ProductExistance productExistanceTo;
		SupplyFormWithRequestData supplyFormWithRequestData = null;
		MoveProductService moveProductService = null;
		TakeOnTheAccountService takeOnTheAccountService = null;
		ItemStore itemStore = null;
		float newProductPrice = 0f;
		Product updatedProduct = new Product();

		MyLogger.LogMessage("REQUEST PAAMENTERS" + request.getParameter("chosenAmount"));
		try
		{
			supplyFormWithRequestData = new SupplyFormWithRequestData();
			currentProduct = new Product();
			productService = new ProductServiceImpl();
			// moveProductService = new MoveProductServiceImpl();
			HttpSession session = request.getSession();
			takeOnTheAccountForm = (OperationOnProductForm)session.getAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM);
			if(takeOnTheAccountForm==null)
				takeOnTheAccountForm = new OperationOnProductForm();
			//takeOnTheAccountForm.supplyWithRequestData(request);
			takeOnTheAccountService = new TakeOnTheAccountServiceImpl();
			System.out.println("HELLO J REBEL");
			System.out.println("HELLO J REBEL 2");
			System.out.println("HELLO J REBEL 34");
			System.out.println("HELLO J REBEL 331");
			System.out.println("HELLO J REBEL 33");
			MyLogger.LogMessage("Before Reflection");
			Class c = Class.forName(takeOnTheAccountForm.getClass().getName());
			MyLogger.LogMessage("Before fillForm 1");
			OperationOnProductForm tempForm = new OperationOnProductForm();
			MyLogger.LogMessage("Before fillForm");
			//we know which form type we get
			takeOnTheAccountForm.performBasicValidation(request);
			if(takeOnTheAccountForm.getModelDataOK()==0) {
				request.setAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM, takeOnTheAccountForm);
				return 0;
			}
			takeOnTheAccountForm = (OperationOnProductForm) supplyFormWithRequestData.fillForm(
					takeOnTheAccountForm, request);

			MyLogger.LogMessage("After Reflection");
			MyLogger.LogMessage("After Reflection 1");
			currentProduct = productService.getProductById(takeOnTheAccountForm.getProduct_id());
			takeOnTheAccountForm.setProduct(currentProduct);

			switch (type)
			{
				case TAKE:
					updatedProduct = takeOnTheAccountService.recalculatePrice(takeOnTheAccountForm,
							currentProduct);
					takeOnTheAccountService.takeProductOnTheAccount(takeOnTheAccountForm,
							currentProduct);
					productService.updateProduct(updatedProduct);
					break;
				case REMOVE:
					productExistance = takeOnTheAccountService.checkProductExistance(takeOnTheAccountForm, currentProduct);
					if(productExistance.getAvailibility()>=Integer.parseInt(takeOnTheAccountForm.getChosenAmount()))
					{
						takeOnTheAccountService.removeProductFromTheAccount(takeOnTheAccountForm,
							currentProduct, productExistance);
					}
					else {
						stateHandler.addPopupNotification("availibility","Ei ole piisavalt sellist tyybi tooteid valitud laos " +takeOnTheAccountForm.getChosenStore() + " maksimaalne v6imalik liigutamiseks arv on " + productExistance.getAvailibility() );
						return 0;
					}
					break;
				case MOVE:
					productExistance = takeOnTheAccountService.checkProductExistance(takeOnTheAccountForm, currentProduct);
					productExistanceTo = takeOnTheAccountService.checkProductExistanceTo(takeOnTheAccountForm, currentProduct);
					if(productExistance.getAvailibility()>=Integer.parseInt(takeOnTheAccountForm.getChosenAmount()))
					{
						if(productExistanceTo.getAvailibility()>0)
							takeOnTheAccountService.moveProduct(takeOnTheAccountForm,
									currentProduct);
						else {
							takeOnTheAccountService.insertProduct(takeOnTheAccountForm,
									currentProduct);
						}
					}
					else {
						stateHandler.addPopupNotification("availibility","Ei ole piisavalt sellist tyybi tooteid valitud laos " +takeOnTheAccountForm.getChosenStore() + " maksimaalne v6imalik liigutamiseks arv on " + productExistance.getAvailibility() );
						return 0;
					}
					break;
			}

			// stateHandler.setLastState(StateEnum.TAKEN_ON_THE_ACCOUNT);

			/*
			 * Insert into item_store iss set iss.item_fk = , store_fk =,
			 * item_count =
			 */

			MyLogger.LogMessage("execute() formFilling successfull");
			MyLogger.LogMessage("execute() formFilling successfull 1");
			// request.setParameter("product_id");

			// request.setAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM,
			// takeOnTheAccountForm);

		} catch (Exception e)
		{
			MyLogger.LogMessage("Reflection Error ");
		}

		return 1;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		req.setAttribute(Constant.TAKE_ON_THE_ACCOUNT_FORM, takeOnTheAccountForm );

	}

}
