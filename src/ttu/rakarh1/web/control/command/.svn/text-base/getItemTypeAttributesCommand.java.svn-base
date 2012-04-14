package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.DrawSearchFormService;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.DrawSearchFormServiceFactory;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.SpecialSearchForm;

public class getItemTypeAttributesCommand implements Command
{

	public int execute(HttpServletRequest request, HttpServletResponse response, StateHandler stateHandler)
			throws ServletException, IOException
	{
		int operation_result;
		List<ttu.rakarh1.backend.model.data.FormAttribute> formAttributes = null;
		final String ACTION_UPDATE = "update_product";
		MyLogger.LogMessage("Inside getItemTypeAttributesCommand");
		try
		{
			int showProduct = 0;
			String userAction;
			String request_product_id = "";
			int product_id = 0;

			int selected_item_type_id = 0;
			String request_selected_utem_type_id = "";

			request_selected_utem_type_id = request.getParameter("catalog");
			selected_item_type_id = Integer.parseInt(request_selected_utem_type_id);
			DrawSearchFormService drawSearchFormService = null;
			SpecialSearchForm specialSearchForm = null;

			DrawSearchFormServiceFactory drawSearchFormServiceFactory = new DrawSearchFormServiceFactory();
			drawSearchFormService = drawSearchFormServiceFactory.getService();

			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductService ProductService = ProductServiceFactory.getService();

			MyLogger.LogMessage("Inside getItemTypeAttributesCommand before specifiing action");

			if (request.getParameter("product_id") != null
					&& request.getParameter("catalog") != null)
			{
				Product SelectedProduct = null;
				String producerCode = null;
				if (Integer.parseInt(request.getParameter("product_id")) != 0)
				{
					request_product_id = request.getParameter("product_id");
					product_id = Integer.parseInt(request_product_id);
					showProduct = 1;
					SelectedProduct = ProductService.getProductById(product_id);
					producerCode = SelectedProduct.getProduct_code();
					formAttributes = drawSearchFormService.getAttributesForItem(
							selected_item_type_id, product_id);
					MyLogger.LogMessage("Returning form attributes " + formAttributes.size());
					if (formAttributes.size() == 0)
					{
						formAttributes = drawSearchFormService
								.getAttributesForItem(selected_item_type_id);
						request.setAttribute("formAttributesActionType", "formAttributesInsert");
					} else
						request.setAttribute("formAttributesActionType", "formAttributesUpdate");

					if (request.getParameter("user_action") != null
							&& request.getParameter("user_action").equals("update_product"))
					{
						MyLogger.LogMessage("with user action case Update");
						String action = request.getParameter("action");
						specialSearchForm = new SpecialSearchForm();
						specialSearchForm.getSpecialFormData(request, formAttributes);
						int errors = specialSearchForm.getSpecialFormDataErrors(request,
								formAttributes);
						if (errors == 0)
						{

							if (action.equalsIgnoreCase("formAttributesInsert"))
							{
								ProductService.insertProductAttributes(formAttributes,
										product_id);
							}
							else
							{
								ProductService.updateProductAttributes(formAttributes, product_id);
							}

						}
					}

					if (request.getParameter("user_action") != null
							&& request.getParameter("user_action").equals("insert_product"))
					{
						MyLogger.LogMessage("with user action case Insert");
						specialSearchForm = new SpecialSearchForm();
						specialSearchForm.getSpecialFormData(request, formAttributes);
						int errors = specialSearchForm.getSpecialFormDataErrors(request,
								formAttributes);
						if (errors == 0)
						{
							ProductService.insertProductAttributes(formAttributes, product_id);
						}
					}
				}
				else {
					if (request.getParameter("user_action") != null
							&& request.getParameter("user_action").equals("insert_product"))
					{
						MyLogger.LogMessage("with user action case Plain Insert");
						formAttributes = drawSearchFormService.getAttributesForItem(selected_item_type_id);
						specialSearchForm = new SpecialSearchForm();
						producerCode = specialSearchForm.getSpecialFormDataInsert(request, formAttributes);
						int insId = ProductService.getProductId(producerCode);
						int errors = specialSearchForm.getSpecialFormDataErrors(request,formAttributes);
						if (errors == 0)
						{
							ProductService.insertProductAttributes(formAttributes, insId);
						}
					}


				}

			} else
				formAttributes = drawSearchFormService.getAttributesForItem(selected_item_type_id);
			specialSearchForm = new SpecialSearchForm();
			specialSearchForm.getSpecialFormData(request, formAttributes);
			request.setAttribute("formAttributes", formAttributes);

			operation_result = 1;
		} catch (Exception ex)
		{
			operation_result = 0;
			MyLogger.Log("getItemTypeAttributesCommand().execute:", ex.getMessage());
			StackTraceElement[] exmess = ex.getStackTrace();
			for (StackTraceElement some : exmess)
			{
				MyLogger.LogMessage(some.toString());
			}

		}
		return operation_result;
	}

	@Override
	public void supplyFormWithErrors(HttpServletRequest req, HttpServletResponse res,
			StateHandler stateHandler)
	{
		// TODO Auto-generated method stub

	}

}
