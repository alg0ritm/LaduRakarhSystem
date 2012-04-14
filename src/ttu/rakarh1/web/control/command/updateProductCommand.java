package ttu.rakarh1.web.control.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ttu.rakarh1.backend.constant.Constant;
import ttu.rakarh1.backend.model.data.FormAttribute;
import ttu.rakarh1.backend.model.data.Product;
import ttu.rakarh1.backend.model.service.ProductService;
import ttu.rakarh1.log.MyLogger;
import ttu.rakarh1.web.control.ProductServiceFactory;
import ttu.rakarh1.web.control.StateHandler;
import ttu.rakarh1.web.forms.ProductForm;
import ttu.rakarh1.web.forms.ProductRequestProcessor;

public class updateProductCommand implements Command, Constant
{

	public int execute(HttpServletRequest request, HttpServletResponse response,
			StateHandler stateHandler) throws ServletException, IOException
	{
		int operation_result = 0;
		int inserted_product_id = 0;

		HashMap AllErrors = null;
		HashMap ProductServiceErrors = null;
		try
		{
			Product ProductToBeUpdated = null;
			Product UpdatedProduct = null;
			ProductService ProductService = null;
			ProductServiceFactory ProductServiceFactory = new ProductServiceFactory();
			ProductRequestProcessor ProductRequestProcessor = null;
			ProductForm ProductForm = null;
			ProductRequestProcessor = new ProductRequestProcessor();
			MyLogger.LogMessage("updateProductCommand.execute() ->"
					+ "before getFormDataFromRequest()");
			ProductForm = ProductRequestProcessor.getFormDataFromRequest(request);

			List<FormAttribute> formAttributes = (List<FormAttribute>) request
					.getAttribute("formAttributes");
			if (formAttributes != null)
			{
				MyLogger.LogMessage("FORMATTRIBUTES EXIST");
			}
			MyLogger.LogMessage("updateProductCommand.execute() ->" + "beforeConvert");
			ProductToBeUpdated = ProductForm.ConvertToModelData();
			MyLogger.LogMessage("updateProductCommand.execute() ->" + "afterConvert");

			if (ProductForm.getModelDataOK() == 1)
			{
				MyLogger.LogMessage("updateProductCommand.execute() ->" + "beforeUpdate");
				ProductService = ProductServiceFactory.getService();
				ProductForm.setShowAddProduct(ProductService.showAddProduct(ProductToBeUpdated
						.getItem_type_fk()));
				ProductService.updateProduct(ProductToBeUpdated);
				MyLogger.LogMessage("updateProductCommand.execute() ->" + "afterUpdate");
				request.setAttribute(Constant.SHOW_ADD_PRODUCT, ProductForm.isShowAddProduct() + "");
				if (ProductService.getActionResult() == 1)
				{
					MyLogger.LogMessage("updateProductCommand.execute() ->"
							+ "beforeGettingUpdatedProduct");
					UpdatedProduct = ProductService.getProductById(ProductToBeUpdated.getProduct());
					MyLogger.LogMessage("updateProductCommand.execute() ->"
							+ "afterGettingUpdatedProduct");
					ProductForm.getDataFromModel(UpdatedProduct);
					request.setAttribute(Constant.UPDATE_PRODUCT_FORM, ProductForm);
					operation_result = 1;
				} else
				{
					AllErrors = new HashMap();
					if (ProductService.getErrors() != null)
					{
						ProductServiceErrors = ProductService.getErrors();
						AllErrors.putAll(ProductServiceErrors);
					}

					ProductForm.setBusinessErrors(AllErrors);
					request.setAttribute(Constant.UPDATE_PRODUCT_FORM, ProductForm);
					operation_result = 0;
				}

			} else
			{
				request.setAttribute(Constant.UPDATE_PRODUCT_FORM, ProductForm);
				operation_result = -1;
			}

		} catch (Exception ex)
		{
			operation_result = 0;
			MyLogger.Log("updateProductCommand.execute():", ex.getMessage());
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
